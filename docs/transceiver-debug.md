# Transceiver Debug Log (HOTWAV Hyper 8 Ultra)

## TX Path — Stock App Analysis

- When the module reports state `3` (TX active), `o0` spins up `AudioRecord(8 kHz, 16‑bit mono)` with a **160-byte buffer** (80 samples = 10 ms).
- The recorder thread (`h0`, case 1) reads exactly 160 bytes at a time, converts them to a 320-char hex string, and posts `Message.what = 1` to handler `a.b` (instance created as `new a.b(this, looper, 4)`).
- Handler `a.b` (case `a=4`, `what=1`) calls `SerialPortHelper.sendHex(...)` on `/dev/ttyS1` at **230,400 baud**. `sendHex` is just hex→bytes + write, so **TX audio is sent as raw 160-byte PCM frames with no `0xBB...0x44` framing**.
- Frame pacing is maintained with a ~10 ms cadence (`SystemClock.uptimeMillis` busy-wait in `h0`); no additional headers, counters, or checksums are applied on TX.

## RX Path — Stock App Analysis

- RX audio arrives on ttyS1 as framed packets: `BB 00 [4 hdr bytes] [160 bytes PCM] 44` (167 bytes total)
- The stock app does **not** use `AudioAttributes.USAGE_VOICE_COMMUNICATION` — it uses standard media playback
- Speaker enable (`CMD 0x3C`) must be set before RX audio will flow

## Init Sequence — Critical Findings (2026-02-08)

### PTT sysfs must stay HIGH the entire session

The stock app sets PTT HIGH at boot and **never** drops it until power-off. The PTT sysfs is not a TX trigger — it's a hardware enable. Dropping PTT to LOW causes:
- Module may not boot (init timeout, no response to CMD 0x27)
- Module may get stuck in TX after boot (cannot transition to idle)

### setTransferInterrupt must be mode 3

The stock app uses `setTransferInterrupt(3)`, not mode 2. This enables bidirectional PCM audio on ttyS1. Mode 2 appeared to work for TX but did not enable RX audio reception properly.

### launchCommand(0) FAIL is normal during init

After power-on, the module starts in a TX-like state (status 0x03). Sending `launchCommand(0)` to transition to idle returns **FAIL** — this is expected. The stock app treats it as non-fatal. The module transitions to idle (status 0x01) regardless of the FAIL response.

### Stock app PTT button never touches sysfs

TX/RX transitions in the stock app use **only** serial commands:
- `launchCommand(1)` to enter TX
- `launchCommand(0)` to return to idle/RX
- Speaker is disabled during TX (`setSpeakerEnable(0)`) and re-enabled after (`setSpeakerEnable(1)`)

## Resolved Debug Issues

### Issue 1: TX audio not producing sound (fixed earlier)
- **Cause**: Demo code wrapped PCM in `BB 00 ... 44` framing
- **Fix**: Send raw 160-byte PCM frames on ttyS1 with 10ms cadence

### Issue 2: Init timeout / module not booting (fixed 2026-02-08)
- **Cause**: PTT sysfs was LOW during boot
- **Fix**: Set all three GPIOs (power, pwd, PTT) HIGH before polling checkInitComplete

### Issue 3: Module stuck in TX after init (fixed 2026-02-08)
- **Cause**: Missing `launchCommand(0)` after init, wrong transfer interrupt mode
- **Fix**: Send `setTransferInterrupt(3)` then `launchCommand(0)` (non-fatal) after speaker enable. Module transitions from TX (0x03) → Idle (0x01).

### Issue 4: RX audio not received (fixed 2026-02-08)
- **Cause**: Combination of issues 2 + 3, plus PTT sysfs being toggled during TX
- **Fix**: Keep PTT HIGH always, use mode 3 transfer interrupt, send launch(0) to enter idle. Also gate audio receiver with `rxEnabled` flag to prevent boot garbage from triggering AudioTrack.

## Misc Notes

- Mic gain/volume are set via CMD `0x2A`/`0x2E` after channel configuration; failures are non-fatal in the stock flow.
- AudioTrack should use `USAGE_MEDIA` + `CONTENT_TYPE_MUSIC` with buffer `Math.max(minBuf, 16384)` for smooth RX playback.
- RX frame counter logging: first frame logged immediately, then every 50 frames.
