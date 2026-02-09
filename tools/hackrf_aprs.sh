#!/bin/bash
# hackrf_aprs.sh — Send an APRS message via HackRF
#
# Usage:
#   ./hackrf_aprs.sh "Hello world"
#   ./hackrf_aprs.sh "Hello world" 5
#   ./hackrf_aprs.sh                    # sends "HackRF test"

set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"
WAV2IQ="$SCRIPT_DIR/wav2iq"

# Callsign settings
SRC_CALL="N0CALL-7"
DEST="APZ001,WIDE1-1"

MESSAGE="${1:-HackRF test}"
REPEATS="${2:-1}"
FREQ_MHZ=144.800
FREQ_HZ=144800000

PACKET="${SRC_CALL}>${DEST}:>${MESSAGE}"

DEVIATION=5000
SAMPLE_RATE=2048000
TX_GAIN=47
AMP=1

TMPDIR=$(mktemp -d)
trap "rm -rf $TMPDIR" EXIT

PKT_FILE="$TMPDIR/packets.txt"
WAV_FILE="$TMPDIR/aprs.wav"
IQ_FILE="$TMPDIR/aprs.raw"

# Check dependencies
for cmd in gen_packets hackrf_transfer; do
    if ! command -v "$cmd" &>/dev/null; then
        echo "ERROR: $cmd not found in PATH" >&2
        exit 1
    fi
done
if [ ! -x "$WAV2IQ" ]; then
    echo "ERROR: wav2iq not found at $WAV2IQ (run: cd tools && gcc -O2 -o wav2iq wav2iq.c -lm)" >&2
    exit 1
fi

# 1. Write packet file (repeated N times)
for _ in $(seq 1 "$REPEATS"); do
    echo "$PACKET"
done > "$PKT_FILE"

echo "Message: $MESSAGE"
echo "Packet : $PACKET"
echo "Repeats: $REPEATS"
echo "Freq   : $FREQ_MHZ MHz"
echo ""

# 2. Generate 2-second 1000Hz warmup tone (lets HackRF PLL stabilize)
WARMUP_WAV="$TMPDIR/warmup.wav"
WARMUP_IQ="$TMPDIR/warmup.raw"
sox -n -r 8000 -b 16 -c 1 "$WARMUP_WAV" synth 2 sine 1000
"$WAV2IQ" "$WARMUP_WAV" "$WARMUP_IQ" "$DEVIATION"
echo "Warmup: 2s tone generated"

# 3. Generate AFSK WAV
gen_packets -o "$WAV_FILE" -r 8000 -a 100 "$PKT_FILE" 2>&1
echo ""

# 4. FM-modulate to IQ
"$WAV2IQ" "$WAV_FILE" "$IQ_FILE" "$DEVIATION"
echo ""

# 5. Concatenate warmup + APRS IQ
COMBINED_IQ="$TMPDIR/combined.raw"
cat "$WARMUP_IQ" "$IQ_FILE" > "$COMBINED_IQ"

# 6. Transmit
hackrf_transfer -t "$COMBINED_IQ" -f "$FREQ_HZ" -s "$SAMPLE_RATE" -x "$TX_GAIN" -a "$AMP" 2>&1
echo ""
echo "Done."
