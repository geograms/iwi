#!/usr/bin/env bash
set -euo pipefail

ADB="/home/brito/Android/Sdk/platform-tools/adb"
APK="app/build/outputs/apk/debug/app-debug.apk"
SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"

cd "$SCRIPT_DIR"

# Check for exactly one connected device
DEVICE_COUNT=$("$ADB" devices | grep -c 'device$' || true)
if [ "$DEVICE_COUNT" -eq 0 ]; then
    echo "ERROR: No Android device connected."
    exit 1
elif [ "$DEVICE_COUNT" -gt 1 ]; then
    echo "WARNING: Multiple devices connected, using first one."
fi

DEVICE=$("$ADB" devices | grep 'device$' | head -1 | awk '{print $1}')
MODEL=$("$ADB" -s "$DEVICE" shell getprop ro.product.model 2>/dev/null || echo "unknown")
echo "Device: $DEVICE ($MODEL)"

# Kill any previous Gradle builds and daemons (respect 2GB RAM limit)
if pgrep -f "GradleDaemon" > /dev/null 2>&1; then
    echo "Stopping Gradle daemons..."
    ./gradlew --stop 2>/dev/null || true
    sleep 1
fi
if pgrep -x "javac\|kotlinc" > /dev/null 2>&1; then
    echo "Killing running compiler processes..."
    pkill -x "javac\|kotlinc" 2>/dev/null || true
    sleep 1
fi

# Build
echo ""
echo "=== Building debug APK ==="
./gradlew assembleDebug

# Stop the app if it's running (so the new APK actually loads)
echo ""
echo "=== Stopping app ==="
"$ADB" -s "$DEVICE" shell am force-stop com.geograms.iwi

# Install
echo ""
echo "=== Installing on $DEVICE ($MODEL) ==="
"$ADB" -s "$DEVICE" install -r "$APK"

# Clear logcat so we only see fresh output
"$ADB" -s "$DEVICE" logcat -c

# Launch
echo ""
echo "=== Launching on $DEVICE ($MODEL) ==="
"$ADB" -s "$DEVICE" shell am start -n com.geograms.iwi/.MainActivity

echo ""
echo "=== Logcat (RadioManager + SerialPort) — Ctrl+C to stop ==="
echo ""
"$ADB" -s "$DEVICE" logcat -v time -s RadioManager:V SerialPort:V SerialPortJni:V AndroidRuntime:E
