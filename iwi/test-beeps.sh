#!/usr/bin/env bash
set -euo pipefail

ADB="/home/brito/Android/Sdk/platform-tools/adb"

# PTT button center coordinates (from uiautomator dump)
PTT_X=540
PTT_Y=1143
HOLD_MS=6000

echo "=== PTT + Beep Test ==="
echo "1. Holding PTT for ${HOLD_MS}ms"
echo "2. Playing beeps through speaker"
echo "3. Mic should pick up beeps → DMR module → receiver"
echo ""

# Start PTT hold in background
"$ADB" shell input swipe $PTT_X $PTT_Y $PTT_X $PTT_Y $HOLD_MS &
PTT_PID=$!

# Wait a moment for PTT to engage
sleep 1

# Play beeps through speaker
echo "Playing beeps..."
"$ADB" shell am start -a android.intent.action.VIEW -d file:///sdcard/beeps.wav -t audio/wav 2>&1

# Wait for PTT hold to finish
wait $PTT_PID
echo "PTT released"

sleep 1

# Show relevant logs
echo ""
echo "=== Logs ==="
"$ADB" logcat -d -v time -s RadioManager:V 2>/dev/null | grep -E "PTT|Launch|RX \[" || true
