# InterPhone / QuickChat — Reverse Engineering Report

## What was done

1. Connected to the **Hyper8Ultra** Android device via ADB
   (`/home/brito/Android/Sdk/platform-tools/adb`)
2. Identified the target app: `com.chamsion.quickchat` (system app at `/system/app/QuickChat/QuickChat.apk`)
3. Pulled the APK (6.1 MB) to `./QuickChat.apk`
4. Installed **jadx v1.5.3** at `/home/brito/dev/jadx/` for decompilation
5. Decompiled all classes to `./apk_extract/sources/` (1075 classes, 18 minor decompilation errors from obfuscation)
6. Analyzed the full program structure, serial protocol, and hardware interface

---

## What this app is

**QuickChat** is a DMR (Digital Mobile Radio) walkie-talkie companion app made by **Chamsion**. It runs on embedded Android devices (like the Hyper8Ultra) that have a **built-in radio transceiver module** connected to the Android SoC via a **serial port** (UART).

The app does NOT use WiFi or cellular for communication. It controls a physical radio module to transmit/receive on **UHF/VHF frequencies** using the **DMR digital protocol** or **FM analog mode**.

**DMR library version**: 1.0.9 (2025-04-27)

---

## How it works — the big picture

The Hyper8Ultra is not a regular phone. It is a **hybrid device** with a **DMR radio transceiver module** physically built into the same enclosure alongside the Android SoC. The two communicate over an **internal UART serial line**, not over any network.

```
Android app  →  serial port (UART)  →  DMR radio module  →  RF antenna  →  air
```

**What the Android side does:**
- UI, contacts, message history (Room DB)
- Builds binary command frames and sends them over serial
- Parses response frames from the module
- Controls power/PTT via kernel sysfs (`/sys/devices/platform/intercom/`)
- Routes audio in/out of the radio module via custom AudioManager params (`pdt_play`, `pdt_mic`)

**What the radio module does:**
- All RF work (modulation, demodulation, frequency synthesis)
- DMR protocol stack (TDMA timeslots, color codes, encryption)
- Analog FM mode
- Has its own firmware (updatable via XMODEM over the same serial link)

The app is essentially a **serial terminal with a nice UI** — it sends structured byte commands to the radio module and interprets the responses. The radio module is a black box that does all the actual radio work.

---

## Architecture

```
┌─────────────────────────────────────────────────┐
│  UI Layer (com.chamsion.quickchat.ui)            │
│  15 Activities + Fragments + ViewModels          │
├─────────────────────────────────────────────────┤
│  Service Layer (com.chamsion.quickchat.service)  │
│  DmrService — foreground service                 │
├─────────────────────────────────────────────────┤
│  Database Layer (com.chamsion.quickchat.db)       │
│  Room: channels, contacts, messages              │
├─────────────────────────────────────────────────┤
│  DMR Protocol (com.wonder.dmr)                   │
│  DmrManager — command framing & response parsing │
├─────────────────────────────────────────────────┤
│  Serial Layer (com.wonder.serial)                │
│  SerialTools → SerialPort (JNI native)           │
├─────────────────────────────────────────────────┤
│  Native libs                                     │
│  libwonder_serialport.so — UART open/read/write  │
│  libserialport.so — alternative serial driver    │
└─────────────────────────────────────────────────┘
```

---

## Package breakdown

### `com.chamsion.quickchat` — Application layer

| File | Role |
|---|---|
| `App.java` | Application entry point. Stores global context, registers screen on/off receiver, handles first-launch initialization |
| `R.java` | Generated resource IDs |

### `com.chamsion.quickchat.service`

| File | Role |
|---|---|
| `DmrService.java` | Foreground service that manages the radio module lifecycle. Controls hardware power/PTT via sysfs. Holds a WakeLock when "screen off support" is enabled. Binds to `DmrManager` for serial communication |

### `com.chamsion.quickchat.ui` — Activities

| Activity | Purpose |
|---|---|
| `SplashActivity` | Launch screen |
| `MainActivity` | Main navigation with 5 tabs: PTT, Channel, Contacts, Message, Mine. Opens/closes speaker and mic via AudioManager. Binds/unbinds `DmrService` |
| `ChatActivity` | 1:1 private text messaging (by DMR ID). Uses Room `message_table` with sender ID and message type |
| `MessageChatActivity` | Channel/group text messaging |
| `AddNewChannelActivity` | Create/edit radio channels (frequency, color code, timeslot, power, etc.) |
| `AddNewContactsActivity` | Add contacts by DMR ID |
| `ManagerActivity` | Management screen |
| `SettingsActivity` | App settings |
| `UpdateDmrAcitivity` | Firmware update for the radio module (XMODEM over serial) |
| `FragmentLocalDeviceAreaActivity` | Device area configuration |
| `FragmentLocalDeviceAreaListActivity` | Area list |
| `FragmentLocalInformationActivity` | Device info display |
| `FragmentLocalSettingsActivity` | Local radio settings |
| `FragmentLocalUseGuideActivity` | User guide |

### `com.chamsion.quickchat.db` — Persistence (Room)

| Database | Table | Purpose |
|---|---|---|
| `ChannelDatabase` | channels | Radio channel configurations |
| `ContactDatabase` | contacts | DMR contact entries (ID + name) |
| `MessageDatabase` | message_table | Private text messages |
| `ChannelMessageDatabase` | channel messages | Group/channel text messages |

### `com.chamsion.quickchat.widget` — Custom views

| Widget | Purpose |
|---|---|
| `CheckErrorView` | Error state indicator |
| `CheckInitializeView` | Initialization progress |
| `CheckMarkView` | Success checkmark |
| `CircleProgressDrawable` | Circular progress indicator (used during firmware update) |

### `com.chamsion.quickchat.utils`

| File | Purpose |
|---|---|
| `AppProvider.java` | ContentProvider for inter-process data access |

---

## DMR Protocol Library — `com.wonder.dmr`

### DmrManager (singleton)

The core class that manages all communication with the radio module. It:
- Opens/configures the serial port via `SerialTools`
- Sends binary-framed commands
- Receives and parses responses on a background `HandlerThread`
- Dispatches results to listeners via `Handler` messages

### Command frame format

```
 Byte:  [0]   [1]     [2]   [3]   [4..5]     [6..7]     [8..N-1]   [N]
        0x68  CMD_ID  0x01  0x01  CRC16(hi/lo) LEN(hi/lo) PAYLOAD    0x10
        ^^^^                      ^^^^^^^^^^   ^^^^^^^^^              ^^^^
        STX                       Checksum     Data length            ETX
```

- Start byte: `0x68`
- End byte: `0x10`
- CRC is computed by `CRC.checkSumBytes()` and placed at bytes [4..5]
- Data length at [6..7] covers the payload only
- Response byte [3] indicates status: `0` = success, `1` = fail, `2` = checksum error

### Command table

| CMD ID | Hex | Function | Direction |
|---|---|---|---|
| 34 | 0x22 | Set digital channel params | App -> Radio |
| 35 | 0x23 | Set analog channel params | App -> Radio |
| 38 | 0x26 | Launch/PTT command | App -> Radio |
| 39 | 0x27 | Check initialization complete | App -> Radio |
| 40 | 0x28 | Set enhancements | App -> Radio |
| 41 | 0x29 | Set encryption (8-byte key) | App -> Radio |
| 42 | 0x2A | Set MIC gain | App -> Radio |
| 43 | 0x2B | Get digital voice reception info | App -> Radio |
| 44 | 0x2C | Send text message (SMS) | App -> Radio |
| 45 | 0x2D | Get received SMS | App -> Radio |
| 46 | 0x2E | Set volume | App -> Radio |
| 47 | 0x2F | Set monitor mode | App -> Radio |
| 48 | 0x30 | Set squelch level | App -> Radio |
| 49 | 0x31 | Set power saving mode | App -> Radio |
| 50 | 0x32 | Get RSSI (signal strength) | App -> Radio |
| 51 | 0x33 | Set relay offline | App -> Radio |
| 52 | 0x34 | Get firmware version | App -> Radio |
| 53 | 0x35 | Set transfer interrupt | App -> Radio |
| 55 | 0x37 | Set polite policy | App -> Radio |
| 58 | 0x3A | Set SMS protocol type | App -> Radio |
| 59 | 0x3B | Set TOT (time-out timer) | App -> Radio |
| 60 | 0x3C | Set SPK_EN (speaker enable) | App -> Radio |

### DigitalCommand — DMR digital channel parameters

| Field | Type | Description |
|---|---|---|
| rx_freq | int | Receive frequency (Hz as int) |
| tx_freq | int | Transmit frequency (Hz as int) |
| localId | int | Local DMR ID |
| groupList | int[32] | Up to 32 RX group IDs |
| tx_contact | int | Transmit contact/talkgroup ID |
| contactType | byte | Contact type (private/group/all) |
| power | byte | TX power level |
| cc | byte | DMR color code (0-15) |
| inboundSlot | byte | RX timeslot (1 or 2) |
| outboundSlot | byte | TX timeslot (1 or 2) |
| channelMode | byte | Channel mode |
| encryptSw | byte | Encryption on/off |
| encryptKey | byte[8] | 8-byte encryption key |
| pwrsave | byte | Power saving mode |
| volume | byte | Volume level |
| mic | byte | MIC gain level |
| relay | byte | Relay/repeater mode |

### AnalogCommand — FM analog channel parameters

| Field | Type | Description |
|---|---|---|
| rx_freq | int | Receive frequency |
| tx_freq | int | Transmit frequency |
| band | byte | Bandwidth (narrow/wide) |
| power | byte | TX power level |
| sq | byte | Squelch level |
| rx_type | byte | RX subtone type (CTCSS/DCS/none) |
| rx_subcode | byte | RX subtone code |
| tx_type | byte | TX subtone type |
| tx_subcode | byte | TX subtone code |
| pwrsave | byte | Power saving mode |
| volume | byte | Volume level |
| monitor | byte | Monitor (open squelch) |
| relay | byte | Relay/repeater mode |

### Listener interfaces (~20)

All follow the same pattern: `OnXxxListener` with an `OnCallback(int status, ...)` method. Registered on `DmrManager` before sending a command. Response dispatched via `Handler` message IDs:

| Message ID | Listener |
|---|---|
| 256 | OnLaunchCommandListener (PTT) |
| 258 | OnMicGainListener |
| 259 | OnDigitalVoiceReceptionInfoListener |
| 260 | OnVolumeListener |
| 261 | OnEnhancementsListener |
| 262-263 | OnEnhanceListener |
| 264 | OnTextMessageListener |
| 265 | OnEncryptionListener |
| 266 | OnMonitorListener |
| 267 | OnSquelchListener |
| 268 | OnPowerSavingModeListener |
| 269 | OnRSSIListener |
| 270 | OnRelayOfflineListener |
| 271 | OnVersionListener |
| 272 | OnTransferInterruptListener |
| 273 | OnReportStatusListener |
| 274 | OnPolicyListener |
| 275 | OnSmsListener |
| 276 | OnAnalogCmdListener |
| 277 | OnDigitalCmdListener |
| 279 | OnSmsProtocolTypeListener |
| 280 | OnTotListener |
| 281 | OnSpkEnListener |

---

## Serial Port Layer — `com.wonder.serial`

### SerialPort.java (JNI)

Loads native library `libwonder_serialport.so` and exposes:
- `native_open(String port, int baudrate)` -> file descriptor
- `native_close(int fd)`
- `native_readData(int fd, byte[] buf, int len, int timeout)`
- `native_writeData(int fd, byte[] buf, int len)`
- `native_setup(int fd, int baudrate, int nbits, char parity, int stopbits)`

### SerialTools.java (singleton)

Manages serial I/O with dedicated threads:
- **Receive thread** (`a`): continuously reads 64-byte chunks, dispatches via `Handler` to `OnDataReceiveListener`
- **Send thread** (`SendHandler`): queued message-based writes with configurable delay (default 10ms)
- Default write delay: 10ms between commands

### Alternative library: `me.f1reking.serialportlib`

A secondary serial port library is also bundled (F1reKing SerialPortLib) with:
- `SerialPortHelper`, `SerialPortFinder`, `SerialPortReceivedThread`
- Entity classes: `BAUDRATE`, `DATAB`, `PARITY`, `STOPB`, `FLOWCON`, `Device`, `Driver`
- May be used for device discovery or as a fallback

---

## Hardware interface

### Sysfs control paths

The `DmrService` controls the radio module via Linux sysfs:

```
/sys/devices/platform/intercom/intercom_power_control  — radio power on (1) / off (0)
/sys/devices/platform/intercom/intercom_pwd_control     — password/enable control
/sys/devices/platform/intercom/intercom_ptt_control     — push-to-talk on (1) / off (0)
```

These are written via a `Handler` on a background `HandlerThread` with a 10ms delay.

### Audio routing

The app routes audio through Android's `AudioManager` with custom parameters:
- `pdt_play=on` / `pdt_play=off` — enable/disable radio audio playback (speaker)
- `pdt_mic=on` / `pdt_mic=off` — enable/disable microphone for radio TX
- Stream volume is managed on `STREAM_MUSIC` (stream type 3)

### Native libraries

| Library | Architectures | Purpose |
|---|---|---|
| `libwonder_serialport.so` | arm64-v8a, armeabi-v7a, armeabi, mips, mips64, x86, x86_64 | Primary serial port JNI (by Vanzeak) |
| `libserialport.so` | arm64-v8a, armeabi-v7a, x86, x86_64 | Alternative serial port driver |

---

## Firmware update mechanism

The `UpdateDmrAcitivity` + `DmrManager` implement firmware updates using the **XMODEM protocol** over serial:

1. `checkDmrUpgradeMode()` — sends "1" to enter upgrade mode
2. `sendUpgradeFirstPackage(fileSize)` — sends SOH packet (133 bytes) with filename "Filename.bin" and file size, CRC16-XMODEM checksum
3. `sendUpgradeDataPackage(seqNum, data)` — sends STX packets (1029 bytes): 1024-byte data blocks with sequence number and CRC16
4. `sendUpgradeLastPackage(seqNum)` — sends final SOH packet
5. `sendDmrUpgradeEndMsg()` — sends EOT (0x04)

Upgrade stages tracked via `getDmrUpgradeProcessStage()`: BEFORE(0) -> READY(1) -> START(2) -> END(3) -> FINISH(4)

---

## Obfuscation notes

The APK uses **ProGuard/R8 obfuscation**:
- All library and internal classes are renamed to single-letter packages (`a`, `b`, `c` ... `z0`, `a1`, etc.)
- The app's own package (`com.chamsion.quickchat`) and the `com.wonder.*` libraries retain their original names
- The `me.f1reking.serialportlib` library also retains its names
- One large method (`checkReceiveDmrData`) failed to decompile fully (854 instructions) — this is the main response parser

---

## Key observations

1. **Chinese-origin codebase**: Log messages are in Chinese (e.g., "打开串口成功" = "Serial port opened successfully", "对讲机回复信息" = "Intercom reply info")
2. **Message encoding**: Default is GB2312 (Chinese character set), configurable via `setMessageEncode()`
3. **Embedded device**: This is designed for purpose-built Android intercom devices with kernel-level intercom drivers (`/sys/devices/platform/intercom/`)
4. **WakeLock support**: Can keep the CPU awake when the screen is off for continuous radio operation
5. **The app is a system app**: Installed at `/system/app/QuickChat/` indicating it ships pre-installed on these devices
