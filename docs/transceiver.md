# DMR Transceiver Module - HOTWAV Hyper 8 Ultra

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
- `DMR003BN` - Module hardware/platform identifier (DMR series, model 003BN)
- `UV4P` - Dual-band (UV = UHF+VHF), variant "4P"
- `V016` - Firmware revision 016

The firmware is queried at runtime via serial command `0x34` (getVersion) and returned as a UTF-8 string in the response payload.

## Frequency Bands

Validated from the stock QuickChat app frequency input validation (`AddNewChannelActivity.java`):

| Band | Range | Band Byte |
|------|-------|-----------|
| **VHF** | 136.000 - 174.000 MHz | `0x01` |
| **UHF** | 400.000 - 480.000 MHz | `0x00` |

## Supported Modes

- **Analog FM** (CMD 0x23 - setAnalogChannel)
- **DMR Digital** (CMD 0x22 - setDigitalChannel) - ETSI TS 102 361, Tier II
- **AES-256 encryption** (per channel, with configurable key)
- **CTCSS/DCS** sub-tones (analog mode)

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
| `/sys/devices/platform/intercom/intercom_ptt_control` | Hardware PTT line |

All three GPIOs **must** be set to `1` during power-on — the module will not boot unless all three are HIGH. They remain HIGH for the entire session until power-off. The stock app never toggles any of them mid-session.

**Critical**: The PTT sysfs line does **not** control TX/RX transitions. TX and RX are controlled exclusively via serial commands (`launchCommand(1)` for TX, `launchCommand(0)` for RX/idle). The PTT GPIO is simply a hardware enable that must stay HIGH for the module to operate.

## Serial Command Protocol

### Frame Format

```
[0x68] [CMD] [0x01] [0x01] [CRC_hi] [CRC_lo] [LEN_hi] [LEN_lo] [...payload...] [0x10]
```

- Header: `0x68`
- Footer: `0x10`
- CRC: 16-bit ones' complement checksum over the full frame (with CRC bytes zeroed)
- Length: Big-endian 16-bit payload length

### Response Format

```
[0x68] [CMD] [0x00] [STATUS] [CRC_hi] [CRC_lo] [LEN_hi] [LEN_lo] [...payload...] [0x10]
```

Status codes:
- `0x00` = Success
- `0x01` = Fail
- `0x02` = CRC Error

### Command Table

| CMD | Hex | Description |
|-----|-----|-------------|
| setDigitalChannel | 0x22 | Configure DMR digital channel |
| setAnalogChannel | 0x23 | Configure analog FM channel |
| launchCommand | 0x26 | TX start (1) / RX-idle (0) |
| checkInitComplete | 0x27 | Poll module boot status |
| setMicGain | 0x2A | Set microphone gain level |
| setVolume | 0x2E | Set speaker volume (default: 8) |
| getVersion | 0x34 | Query firmware version string |
| setTransferInterrupt | 0x35 | Set audio transfer mode (0=off, 3=stock default) |
| statusBeacon | 0x36 | Module status report (unsolicited) |
| setSpkEn | 0x3C | Speaker enable/disable |

### setTransferInterrupt (CMD 0x35)

Configures the audio transfer mode on `ttyS1`. The stock app uses mode `3`. Must be sent after channel configuration and before entering TX/RX.

```
68 35 01 01 [CRC] [CRC] 00 01 [MODE] 10
```

Mode values:
- `0` = Off (disables audio transfer)
- `3` = Stock default (enables bidirectional PCM audio on ttyS1)

### Status Beacon (CMD 0x36)

The module sends periodic unsolicited status beacons (~10/sec during TX/RX):

```
68 36 02 00 [CRC] [CRC] 00 01 [STATE] 10
```

Known state values:
- `0x01` = Idle (ready for RX or TX)
- `0x03` = Transmitting (TX active)
- `0x04` = Transitioning

## Audio Path

Audio is transmitted and received as **raw PCM** over `/dev/ttyS1`:

| Parameter | Value |
|-----------|-------|
| Sample rate | 8,000 Hz |
| Bit depth | 16-bit signed |
| Channels | 1 (mono) |
| Frame size | 160 bytes (80 samples = 10ms) |

### Audio Framing (ttyS1)

RX audio packets from the module use this framing:

```
[0xBB] [0x00] [4 header bytes] [160 bytes PCM] [0x44]
```

Total frame: 167 bytes. The 4 header bytes after `BB 00` are not yet fully decoded.

TX audio framing is expected to follow a similar structure (under investigation).

The DMR module handles AMBE codec encoding/decoding internally - the app sends/receives raw PCM, not AMBE-encoded audio.

## Power Specifications

- TX power levels are configurable per-channel via a `power` byte field
- Exact wattage mapping is handled by the module firmware (not exposed to app)
- HOTWAV advertises up to 20 km range in open terrain

## Power-On Sequence (stock app behavior)

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
10. `setTransferInterrupt(3)` (CMD 0x35) — enable audio transfer
11. `setMicGain` (CMD 0x2A) and `setVolume` (CMD 0x2E) — non-fatal
12. `setSpeakerEnable(1)` (CMD 0x3C) — enable speaker for RX
13. `launchCommand(0)` (CMD 0x26) — transition from TX to idle/RX mode (**FAIL response is normal** during init, the module transitions anyway)

After this sequence, the module enters idle mode (status `0x01`) and will receive incoming RF signals.

## TX/RX Transitions

TX and RX are controlled **only** via serial commands — never via sysfs GPIO:

- **Enter TX**: `launchCommand(1)` — module status changes to `0x03`, app sends raw PCM on ttyS1
- **Exit TX → Idle**: `launchCommand(0)` — may return FAIL initially, retry up to 3 times
- **RX is passive**: When another station transmits on the configured frequency, the module automatically starts sending audio frames on ttyS1

The PTT sysfs GPIO stays HIGH from power-on to power-off. It is a hardware enable, not a TX trigger.

## Resolved Issues

1. ~~`launchCommand(0)` returns FAIL~~ — This is **normal** during the TX→idle transition. The stock app treats it as non-fatal. After init, sending `launchCommand(0)` with FAIL response still transitions the module to idle.
2. ~~TX audio not producing audible output~~ — TX audio must be sent as **raw 160-byte PCM frames** (no BB/44 framing). The module encodes them internally.
3. ~~RX audio not being received~~ — Required all three sysfs GPIOs HIGH, `setTransferInterrupt(3)`, and `launchCommand(0)` after init to enter idle/RX mode.

## Open Questions

1. The exact TX audio framing format used by the stock app handler (1780 instructions, too complex for JADX) — but raw PCM works
2. Full meaning of the 4 header bytes in RX audio frames (`BB 00 XX XX XX XX [PCM] 44`)
3. Exact wattage mapping for TX power levels

## References

- Stock app package: `com.chamsion.quickchat` (decompiled via JADX)
- SDK: `com.wonder.dmr.DmrManager`, `com.wonder.serial.SerialPort`
- Firmware queried at runtime: `DMR003BN.UV4P.V016`
