# Transceiver TX Path Notes (HOTWAV Hyper 8 Ultra)

## What the stock app does
- When the module reports state `3` (TX active), `o0` spins up `AudioRecord(8 kHz, 16‑bit mono)` with a **160-byte buffer** (80 samples = 10 ms).
- The recorder thread (`h0`, case 1) reads exactly 160 bytes at a time, converts them to a 320-char hex string, and posts `Message.what = 1` to handler `a.b` (instance created as `new a.b(this, looper, 4)`).
- Handler `a.b` (case `a=4`, `what=1`) calls `SerialPortHelper.sendHex(...)` on `/dev/ttyS1` at **230,400 baud**. `sendHex` is just hex→bytes + write, so **TX audio is sent as raw 160-byte PCM frames with no `0xBB...0x44` framing**.
- Frame pacing is maintained with a ~10 ms cadence (`SystemClock.uptimeMillis` busy-wait in `h0`); no additional headers, counters, or checksums are applied on TX.
- The “transfer interrupt” command (`CMD 0x35`) is optional; default prefs keep it disabled. When enabled it is set to mode `3` just before PTT, otherwise PTT goes straight to TX.

## Implications
- RX frames from the modem arrive as `BB 00 … 44` packets, but **TX expects bare PCM**. Wrapping TX audio in `BB/44` causes the module to key up without emitting audio.
- Maintaining the 10 ms / 160-byte rhythm is important; the stock app busy-waits to keep timing tight.
- Mic gain/volume are set via CMD `0x2A`/`0x2E` after channel configuration; failures are non-fatal in the stock flow.

## Demo gap that was fixed
- The initial demo framed PCM with `BB 00 ... 44`. Switching to raw 160-byte writes on `/dev/ttyS1` (10 ms cadence) aligns with the stock implementation and should produce audible TX audio.
