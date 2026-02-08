# DMR Transceiver Module — HOTWAV Hyper 8 Ultra

## Overview

The HOTWAV Hyper 8 Ultra contains an embedded DMR (Digital Mobile Radio) transceiver module manufactured by **Wonder** (Shenzhen-based, associated with the `com.wonder.dmr` SDK). The module is soldered onto the phone's mainboard and communicates with the Android application processor via two UART serial ports.

The phone itself is manufactured by **Shenzhen Tugao Intelligent Co., Ltd** (branded as HOTWAV) with the stock radio app published under the package `com.chamsion.quickchat`.

## Module Identification

| Property | Value |
|----------|-------|
| **Firmware Version** | `DMR003BN.UV4P.V016` |
| **SDK Package** | `com.wonder.dmr` |
| **SDK Version** | 1.0.9 (2025-04-27) |
| **JNI Library** | `libwonder_serialport.so` (Vanzeak implementation) |
| **Exact Chip Model** | Unknown (not exposed to the Android layer) |

### Firmware Version Breakdown

The firmware string `DMR003BN.UV4P.V016` likely encodes:
- `DMR003BN` — Module hardware/platform identifier (DMR series, model 003BN)
- `UV4P` — Dual-band (UV = UHF+VHF), variant "4P"
- `V016` — Firmware revision 016

Queried at runtime via serial command `0x34` (getVersion), returned as a UTF-8 string in the response payload.

## Frequency Bands

Validated from the stock QuickChat app (`AddNewChannelActivity.java`):

| Band | Range | Band Byte |
|------|-------|-----------|
| **VHF** | 136.000 – 174.000 MHz | `0x01` |
| **UHF** | 400.000 – 480.000 MHz | `0x00` |

## Supported Modes

- **Analog FM** (CMD 0x23 — setAnalogChannel)
- **DMR Digital** (CMD 0x22 — setDigitalChannel) — ETSI TS 102 361, Tier II
- **AES-256 encryption** (per channel, with configurable key)
- **CTCSS/DCS** sub-tones (analog mode)

---

## Communication Interface

The module uses two UART serial ports on the MediaTek MT6877 SoC:

| Port | Baud Rate | Purpose |
|------|-----------|---------|
| `/dev/ttyS0` | 57,600 | Command/control protocol |
| `/dev/ttyS1` | 230,400 | PCM audio data (TX and RX) |

Both ports use 8N1 (8 data bits, no parity, 1 stop bit), no flow control.

### GPIO Control (sysfs)

| Path | Function |
|------|----------|
| `/sys/devices/platform/intercom/intercom_power_control` | Module power enable |
| `/sys/devices/platform/intercom/intercom_pwd_control` | Module wake/sleep |
| `/sys/devices/platform/intercom/intercom_ptt_control` | TX/RX control: LOW=TX, HIGH=idle/RX |

All three GPIOs **must** be HIGH for module boot. Power and PWD remain HIGH for the entire session. PTT is toggled during transmissions.

**PTT GPIO is the primary TX/RX control mechanism.** The stock app (`DmrService.java`) toggles it during every transmission:

- **PTT LOW** (write `0`) → Module enters TX mode (status `0x03`)
- **PTT HIGH** (write `1`) → Module returns to idle/RX (status `0x01`)

The stock app **never** uses `launchCommand` (CMD 0x26) for PTT. GPIO-based PTT is the only method that produces clean, reliable transmissions.

### Sysfs write pattern
```java
FileOutputStream fos = new FileOutputStream(path);
byte[] data = { (byte)(on ? '1' : '0'), '\n' };
fos.write(data);
fos.close();
```

---

## Serial Command Protocol

### Frame Format

```
[0x68] [CMD] [0x01] [0x01] [CRC_hi] [CRC_lo] [LEN_hi] [LEN_lo] [...payload...] [0x10]
```

- Header: `0x68`, Footer: `0x10`
- CRC: 16-bit ones' complement checksum over the full frame (CRC bytes zeroed during calculation)
- Length: Big-endian 16-bit payload length

### Response Format

```
[0x68] [CMD] [0x00] [STATUS] [CRC_hi] [CRC_lo] [LEN_hi] [LEN_lo] [...payload...] [0x10]
```

Status codes: `0x00` = Success, `0x01` = Fail, `0x02` = CRC Error

### Response Parsing

```java
byte cmdId = data[1];    // command ID echo
byte status = data[3];   // 0=SUCCESS, 1=FAIL, 2=CRC_ERROR
int payloadLen = ((data[6] & 0xFF) << 8) | (data[7] & 0xFF);
byte[] payload = Arrays.copyOfRange(data, 8, 8 + payloadLen);
```

### Frequency Encoding

Frequencies are 4-byte little-endian integers (Hz):
```java
bArr[offset]     = (byte) (freq & 0xFF);
bArr[offset + 1] = (byte) ((freq >> 8) & 0xFF);
bArr[offset + 2] = (byte) ((freq >> 16) & 0xFF);
bArr[offset + 3] = (byte) ((freq >> 24) & 0xFF);
```

DMR IDs (local ID, contact ID) use the same 4-byte little-endian encoding.

### CRC Utilities

- `CRC.checkSumBytes(byte[] data, int len)` — frame checksum
- `CRC.calculateCRC16XMODEM(byte[] data)` — CRC16-XMODEM for firmware update packets

### Command Table

| CMD | Hex | Description |
|-----|-----|-------------|
| setDigitalChannel | 0x22 | Configure DMR digital channel |
| setAnalogChannel | 0x23 | Configure analog FM channel |
| launchCommand | 0x26 | Exists in protocol but unused for PTT (see GPIO) |
| checkInitComplete | 0x27 | Poll module boot status |
| setEnhancements | 0x28 | Set enhancements |
| setEncryption | 0x29 | Set encryption (8-byte key) |
| setMicGain | 0x2A | Set microphone gain level |
| getDigitalVoiceInfo | 0x2B | Get digital voice reception info |
| sendTextMessage | 0x2C | Send text message (SMS) |
| getReceivedSMS | 0x2D | Get received SMS |
| setVolume | 0x2E | Set speaker volume (default: 8) |
| setMonitor | 0x2F | Set monitor mode |
| setSquelch | 0x30 | Set squelch level |
| setPowerSaving | 0x31 | Set power saving mode |
| getRSSI | 0x32 | Get signal strength |
| setRelayOffline | 0x33 | Set relay offline |
| getVersion | 0x34 | Query firmware version string |
| setTransferInterrupt | 0x35 | Set audio transfer mode (0=off, 2=TX only, 3=bidirectional) |
| statusBeacon | 0x36 | Module status report (unsolicited) |
| setPolitePolicy | 0x37 | Set polite policy |
| setSmsProtocolType | 0x3A | Set SMS protocol type |
| setTOT | 0x3B | Set time-out timer |
| setSpkEn | 0x3C | Speaker enable/disable |

### setTransferInterrupt (CMD 0x35)

Configures the audio transfer mode on `ttyS1`. Must be sent after channel configuration and before entering TX/RX. **Mode 3 is required for RX audio** — mode 2 enables TX but not RX.

```
68 35 01 01 [CRC] [CRC] 00 01 [MODE] 10
```

Mode values:
- `0` = Off (disables audio transfer)
- `2` = TX only (RX audio does not flow)
- `3` = Bidirectional — stock default (enables PCM audio on ttyS1 for both TX and RX)

### Status Beacon (CMD 0x36)

The module sends periodic unsolicited status beacons (~10/sec during TX/RX):

```
68 36 02 00 [CRC] [CRC] 00 01 [STATE] 10
```

Known state values:
- `0x01` = Idle (ready for RX or TX)
- `0x02` = RX-end (reception just finished)
- `0x03` = Transmitting (TX active)
- `0x04` = Transitioning

**Important**: After PTT GPIO goes LOW, audio TX must NOT start until the module reports status `0x03`. Sending audio before TX is confirmed produces garbled output.

---

## Audio Path

Audio is transmitted and received as **raw PCM** over `/dev/ttyS1`:

| Parameter | Value |
|-----------|-------|
| Sample rate | 8,000 Hz |
| Bit depth | 16-bit signed |
| Channels | 1 (mono) |
| Frame size | 160 bytes (80 samples = 10ms) |

The DMR module handles AMBE codec encoding/decoding internally — the app sends/receives raw PCM, not AMBE-encoded audio.

### TX Audio (App → Module)

TX audio is sent as **raw 160-byte PCM frames** with **no framing** (no `BB`/`44` headers). The module expects a steady stream of exactly one 160-byte frame every 10ms.

#### Stock app TX pipeline (p0/h0.java case 1, p0/r0.java, p0/o0.java)

1. Module reports status `0x03` (TX active) → `o0` spins up `AudioRecord(8 kHz, 16-bit mono)` with a **160-byte buffer** (NOT `getMinBufferSize()`)
2. Recorder thread (`h0`, case 1) reads exactly 160 bytes, converts to 320-char hex string, posts `Message.what = 1` to handler `a.b`
3. Handler `a.b` (case `a=4`, `what=1`) calls `SerialPortHelper.sendHex(...)` on ttyS1 at 230,400 baud — hex→bytes + write, so raw PCM with no additional framing
4. No headers, counters, or checksums on TX

#### Frame pacing (critical for audio quality)

The stock app uses a **busy-wait spin loop** — NOT `Thread.sleep()`:

```java
// From p0/h0.java case 1 → p0/o0.java field E
while (SystemClock.uptimeMillis() - o0Var.E < 10) { }   // SPIN until 10ms elapsed
o0Var.E = SystemClock.uptimeMillis();                     // record send time
handler.sendMessage(msg);                                  // THEN send frame
```

Why this matters:
- `Thread.sleep(10)` on Android can actually sleep 11–25ms due to kernel scheduler granularity
- At 10ms cadence (100 frames/sec), this causes 10–150% timing variance per frame
- The DMR vocoder is extremely sensitive to frame timing — jitter corrupts the encoded output
- Busy-wait guarantees sub-millisecond precision at the cost of CPU on one core
- `SystemClock.uptimeMillis()` is used (not `elapsedRealtime()`) — excludes deep sleep time
- The `AudioRecord.read()` of 160 bytes at 8kHz already provides ~10ms natural blocking, so the busy-wait typically spins for only 0–2ms

**AudioRecord configuration:**
- Buffer size: exactly `PCM_FRAME_SIZE` (160 bytes), NOT `getMinBufferSize()`
- Source: `MediaRecorder.AudioSource.MIC`

### RX Audio (Module → App)

RX audio arrives on ttyS1 as framed packets:

```
[0xBB] [0x00] [4 header bytes] [160 bytes PCM] [0x44]
```

Total frame: 167 bytes. The 4 header bytes after `BB 00` are not yet fully decoded.

**RX playback configuration:**
- `AudioTrack` with `USAGE_MEDIA` + `CONTENT_TYPE_MUSIC` (NOT `USAGE_VOICE_COMMUNICATION`)
- Buffer size: `Math.max(getMinBufferSize(), 16384)` for smooth playback
- Speaker must be enabled via CMD `0x3C` before RX audio will flow
- Gate the audio receiver with an `rxEnabled` flag to prevent boot garbage from triggering AudioTrack

---

## Power-On Sequence

The stock QuickChat app performs the following steps to power on the module:

1. Reset all sysfs GPIOs to `0`
2. Wait 200ms
3. Open `/dev/ttyS0` (57600 baud) and `/dev/ttyS1` (230400 baud)
4. Start command read thread on ttyS0
5. Wait 100ms, then set **all three** GPIOs HIGH (power, pwd, PTT)
6. Wait 500ms for module boot
7. Poll `checkInitComplete` (CMD 0x27) every 500ms, up to 10 retries
8. `getVersion` (CMD 0x34) — non-fatal if timeout
9. `setAnalogChannel` (CMD 0x23) — configure frequency, squelch, power, CTCSS/DCS
10. `setTransferInterrupt(3)` (CMD 0x35) — enable bidirectional audio
11. `setMicGain` (CMD 0x2A) and `setVolume` (CMD 0x2E) — non-fatal
12. `setSpeakerEnable(1)` (CMD 0x3C) — enable speaker for RX

After this sequence, the module enters idle mode (PTT GPIO HIGH = idle/RX) and will receive incoming RF signals. No `launchCommand` is needed.

### Power-Off Sequence

1. Disable RX audio reception flag
2. Stop audio transmit thread (if running)
3. Stop serial read thread
4. Stop AudioTrack (if running)
5. Write `0` to all sysfs GPIOs (power, pwd, PTT)
6. Close ttyS1 (audio serial)
7. Close ttyS0 (command serial)

---

## TX/RX Transitions

TX and RX are controlled via the **PTT sysfs GPIO** — the stock app never uses `launchCommand` for PTT:

### Enter TX (PTT press)
1. Disable speaker: `setSpeakerEnable(0)` (CMD 0x3C)
2. Set PTT GPIO **LOW**: write `0` to `intercom_ptt_control`
3. **Wait** for module status beacon `0x03` (TX confirmed) before sending audio
4. Start `AudioRecord` → read 160-byte frames → busy-wait 10ms → write to ttyS1

### Exit TX (PTT release)
1. Set PTT GPIO **HIGH**: write `1` to `intercom_ptt_control`
2. **Wait 300ms** (stock app timing) — continue sending audio during this delay to let the vocoder finish encoding cleanly
3. Stop `AudioRecord`
4. Re-enable speaker: `setSpeakerEnable(1)` (CMD 0x3C)

### RX (passive)
- When another station transmits on the configured frequency, the module automatically starts sending framed audio (`BB 00 ... 44`) on ttyS1
- RX is active whenever PTT GPIO is HIGH (idle mode) and `setTransferInterrupt(3)` has been sent
- Speaker must be enabled via CMD 0x3C

### PTT GPIO vs launchCommand

| | PTT GPIO (sysfs) | launchCommand (CMD 0x26) |
|---|---|---|
| Used by stock app for PTT | **Yes** | **No** |
| LOW = TX, HIGH = idle/RX | Yes | N/A |
| Audio quality | Clean, correct | Not tested for PTT |
| Notes | Primary control method | Exists in protocol but unused for PTT |

---

## Power Specifications

- TX power levels are configurable per-channel via a `power` byte field
- Exact wattage mapping is handled by the module firmware (not exposed to app)
- HOTWAV advertises up to 20 km range in open terrain

---

## Resolved Issues

### 1. TX audio not producing sound
- **Cause**: Demo code wrapped PCM in `BB 00 ... 44` framing (RX format)
- **Fix**: Send raw 160-byte PCM frames on ttyS1 — no framing on TX

### 2. Init timeout / module not booting
- **Cause**: PTT sysfs was LOW during boot
- **Fix**: Set all three GPIOs (power, pwd, PTT) HIGH before polling checkInitComplete

### 3. Module stuck in TX after init
- **Cause**: Missing `setTransferInterrupt(3)`, wrong transfer interrupt mode
- **Fix**: Send `setTransferInterrupt(3)` after channel config. PTT GPIO HIGH after boot = idle mode

### 4. RX audio not received
- **Cause**: Combination of issues 2 + 3, plus incorrect understanding of PTT GPIO role
- **Fix**: Keep PTT HIGH for idle/RX, use mode 3 transfer interrupt. Gate audio receiver with `rxEnabled` flag to prevent boot garbage from triggering AudioTrack

### 5. TX/RX control via launchCommand doesn't work reliably
- **Cause**: Initial analysis assumed `launchCommand` was the TX/RX control
- **Finding**: Stock app uses PTT GPIO for all TX/RX transitions
- **Fix**: Toggle `intercom_ptt_control` sysfs: LOW=TX, HIGH=idle/RX

### 6. TX audio garbled/choppy
- **Cause**: `Thread.sleep(10)` introduces 10–150% jitter at 10ms cadence. Android kernel scheduler granularity means `sleep(10)` can actually sleep 11–25ms. Code also used send-then-wait order (wrong) and `elapsedRealtime()` (wrong).
- **Stock app behavior**: Busy-wait spin loop with `SystemClock.uptimeMillis()` in wait-then-send order
- **Fix**: Replace `Thread.sleep()` with `while (uptimeMillis() - lastSendTime < 10) { }`. Use `PCM_FRAME_SIZE` (160) as AudioRecord buffer instead of `getMinBufferSize()`. Result: clear audio matching stock app quality.
- **Root cause breakdown**:
  1. `Thread.sleep()` jitter → busy-wait (sub-ms precision)
  2. Send-then-wait → wait-then-send (guarantees minimum 10ms gap)
  3. `elapsedRealtime()` → `uptimeMillis()` (matches stock app, excludes deep sleep)
  4. `getMinBufferSize()` → `PCM_FRAME_SIZE` (matches stock app's exact 160-byte buffer)

### 7. TX audio starts before module is ready
- **Cause**: Sending audio immediately after PTT GPIO goes LOW, before module enters TX mode
- **Fix**: Wait for module status beacon `0x03` (TX confirmed) before starting AudioRecord

---

## Open Questions

1. Full meaning of the 4 header bytes in RX audio frames (`BB 00 XX XX XX XX [PCM] 44`)
2. Exact wattage mapping for TX power levels
3. Purpose of `launchCommand` (CMD 0x26) if not used for PTT — possibly for DMR digital mode or relay features

## References

- Stock app package: `com.chamsion.quickchat` (decompiled via JADX)
- SDK: `com.wonder.dmr.DmrManager`, `com.wonder.serial.SerialPort`
- Firmware queried at runtime: `DMR003BN.UV4P.V016`
- Decompiled sources: `./apk_extract/sources/`
