# APRS RX Experiments

APRS RX over the radio module has been tested and confirmed working. This document tracks the intermittent bugs encountered during testing and the fixes applied.

## Test setup

- **Radio**: Hyper 8 Ultra (DMR module, firmware `DMR003BN.UV4P.V016`)
- **App**: IWI on Android, HTTP API on port 6789
- **TX test source**: HackRF One at 144.800 MHz, FM deviation 5000 Hz, IQ rate 2.048 MHz
- **APRS generation pipeline**: `gen_packets` (direwolf) -> WAV 8kHz mono -> `wav2iq` (FM modulate) -> `hackrf_transfer`
- **Test command**: `./tools/hackrf_aprs.sh "HackRF test" 3`
- **Demodulator self-test**: runs on every power-on, generates a synthetic AFSK packet and feeds it through the demodulator. Consistently passes.

## Bug 1: PLL sign inversion (2026-02-09)

### Symptom
After replacing the fixed PLL nudge with a proportional PLL, APRS RX stopped decoding entirely.

### Root cause
The proportional correction had the wrong sign:
```java
// BROKEN — pushes clock away from lock
bitClock -= error * PLL_GAIN;

// CORRECT — pushes clock toward lock
bitClock += error * PLL_GAIN;
```

### What was tested

| PLL variant | Gain | Result |
|---|---|---|
| Original fixed nudge (`+= 0.5` / `-= 0.5`) | n/a | Working (self-test + real RF) |
| Proportional, wrong sign (`-=`) | 0.30 | No frames at all |
| Proportional, correct sign (`+=`) | 0.30 | Garbled addresses, CRC fail |
| Proportional, correct sign (`+=`) | 0.50 | Correct addresses, CRC fail (frame 38 bytes instead of 37) |

### Resolution
Reverted to the original fixed PLL. Self-test passes.

```java
private static final double PLL_SHIFT = 0.5;
if (bitClock < SAMPLES_PER_BIT / 2) {
    bitClock += PLL_SHIFT;
} else {
    bitClock -= PLL_SHIFT;
}
```

The proportional PLL idea is sound but needs more careful tuning. The fixed PLL works reliably.

## Bug 2: Frame length off by one (intermittent)

### Symptom
Demodulator finds a candidate frame with correct AX.25 addresses but CRC fails. Frame is 38 bytes instead of the expected 37.

### Evidence
```
candidate frame len=38 crc=0x95AF expect=0x0F47
CRC FAIL, all bytes: 82 A0 B4 60 60 62 D0 9C 60 86 82 94 98 EE AE 92 88 8A 62 40 ...
```

The first 20 bytes decode correctly:
- `82 A0 B4 60 60 62` = destination `APZ001`
- `D0 9C 60 86 82 94 98 EE` = source `N0CALL-7` (with SSID)
- `AE 92 88 8A 62 40` = path `WIDE1-1`

One extra byte (8 bits) is inserted somewhere in the frame, shifting the tail and corrupting CRC.

### Status
Open. Need to dump complete frame hex and compare byte-by-byte with expected to locate the insertion point.

### CRC verification
The CRC-CCITT implementation was verified correct in isolation:
- Poly 0x8408, init 0xFFFF, final XOR 0xFFFF
- Residue check (CRC over data+CRC bytes) = 0x0F47

## Bug 3: HackRF warmup (2026-02-09)

### Symptom
Very short HackRF transmissions sometimes miss the start of the APRS preamble because the HackRF PLL hasn't stabilized.

### Fix
Added a 2-second 1000Hz warmup tone before the APRS data in `hackrf_aprs.sh`. The tone is FM-modulated to IQ and prepended to the APRS IQ before transmission.

## Other fix: API power state not synced to UI (2026-02-09)

### Symptom
Powering the radio on/off via the HTTP API worked at the protocol level but the Android UI stayed in the previous state (button text, status, enabled controls).

### Fix
Added `PowerStateListener` interface to `ApiServer.java`. `MainActivity` registers a listener that updates all UI elements (power button, status text, PTT/APRS buttons, audio meter) when the API changes power state.

## Next steps

1. **Investigate the 38-byte frame bug**: dump ALL bytes of the CRC-failed frame and compare byte-by-byte with the expected 37-byte frame to find where the extra bit is inserted.

2. **Offline demod testing**: download `/radio/last-rx` WAV during a known-good reception, run it through `atest` (direwolf) to verify the audio quality, then feed it to our demodulator to reproduce the issue without needing the RF path.

3. **Proportional PLL revisit**: the fixed PLL works but a properly tuned proportional PLL should track better on noisy signals. The sign is now known-correct (`+=`); the gain needs experimentation in the 0.3-0.7 range once the frame-length bug is resolved.
