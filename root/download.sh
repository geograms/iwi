#!/bin/bash
# Download large binary files excluded from git.
# These are needed for root/recovery experiments on the HOTWAV Hyper 8 Ultra.
#
# Usage: ./download.sh [--all]
#   Without args: downloads essential tools only (~90MB)
#   --all:        also downloads GSI images (~4.5GB extra)

set -euo pipefail
cd "$(dirname "$0")"

MAGISK_VER="v28.1"
KERNELSU_VER="v1.0.2"  # release tag for manager APK v3.1.0
KERNELSU_RELEASE="v3.1.0"
GKI_BUILD_ID="13762941"  # matches kernel 6.6.89-android15-8-gbe8d201b0d27-ab13762941-4k

GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m'

download() {
    local url="$1" dest="$2"
    if [ -f "$dest" ]; then
        echo -e "${GREEN}[SKIP]${NC} $dest (already exists)"
        return
    fi
    echo -e "${YELLOW}[GET]${NC}  $dest"
    curl -fSL --progress-bar -o "$dest" "$url"
}

echo "=== Essential tools ==="

# Magisk v28.1
download \
    "https://github.com/topjohnwu/Magisk/releases/download/${MAGISK_VER}/Magisk-${MAGISK_VER}.apk" \
    "Magisk.apk"

# Magisk.zip is just the APK renamed (for sideloading)
if [ ! -f "Magisk.zip" ] && [ -f "Magisk.apk" ]; then
    echo -e "${YELLOW}[CP]${NC}   Magisk.zip (copy of Magisk.apk)"
    cp Magisk.apk Magisk.zip
fi

# Extract magiskboot from Magisk APK
if [ ! -f "magiskboot" ] && [ -f "Magisk.apk" ]; then
    echo -e "${YELLOW}[EXT]${NC}  magiskboot (from Magisk.apk)"
    tmpdir=$(mktemp -d)
    unzip -q -o Magisk.apk "lib/x86_64/libmagiskboot.so" -d "$tmpdir"
    cp "$tmpdir/lib/x86_64/libmagiskboot.so" magiskboot
    chmod +x magiskboot
    rm -rf "$tmpdir"
fi

# KernelSU manager APK
download \
    "https://github.com/tiann/KernelSU/releases/download/${KERNELSU_RELEASE}/KernelSU_${KERNELSU_RELEASE}_32302-release.apk" \
    "KernelSU.apk"

# ksud CLI (x86_64 Linux, for patching boot images on host)
download \
    "https://github.com/tiann/KernelSU/releases/download/${KERNELSU_RELEASE}/ksud-x86_64-unknown-linux-musl" \
    "ksud"
chmod +x ksud 2>/dev/null || true

# KernelSU kernel module for android15-6.6 KMI
download \
    "https://github.com/tiann/KernelSU/releases/download/${KERNELSU_RELEASE}/android15-6.6_kernelsu.ko" \
    "kernelsu.ko"

echo ""
echo "=== GKI boot images ==="

# GKI boot.img from Google CI (exact build matching the device kernel)
# Kernel: 6.6.89-android15-8-gbe8d201b0d27-ab13762941-4k
download \
    "https://ci.android.com/builds/submitted/${GKI_BUILD_ID}/kernel_aarch64/latest/raw/boot.img" \
    "gki_boot.img"

# GKI certified boot images (various kernel versions tried during experiments)
# These are from Google's GKI certified boot archive
GKI_BOOTS=(
    "gki-boot-5.15.zip|https://dl.google.com/android/gki/gki-certified-boot-android13-5.15-2024-08_r1.zip"
    "gki-boot-5.15-gz.zip|https://dl.google.com/android/gki/gki-certified-boot-android13-5.15-2024-08_r1-gz.zip"
    "gki-boot-6.1.zip|https://dl.google.com/android/gki/gki-certified-boot-android14-6.1-2024-08_r1.zip"
    "gki-boot-6.1-gz.zip|https://dl.google.com/android/gki/gki-certified-boot-android14-6.1-2024-08_r1-gz.zip"
    "gki-boot-a12-5.10-gz.zip|https://dl.google.com/android/gki/gki-certified-boot-android12-5.10-2024-08_r1-gz.zip"
    "gki-boot-a13-5.10-gz.zip|https://dl.google.com/android/gki/gki-certified-boot-android13-5.10-2024-08_r1-gz.zip"
    "gki-boot-a15-6.6-gz.zip|https://dl.google.com/android/gki/gki-certified-boot-android15-6.6-2024-11_r1-gz.zip"
)

for entry in "${GKI_BOOTS[@]}"; do
    dest="${entry%%|*}"
    url="${entry##*|}"
    download "$url" "$dest" || echo -e "  (URL may have changed, check https://developer.android.com/topic/generic-system-image/releases)"
done

# The 64MB .bin files are boot.img extracted from the zips above
# gki-6.1-boot_a.bin and gki-6.6-boot_a.bin are extracted boot images
# Extract them if the zips exist but the bins don't
for pair in "gki-boot-6.1.zip:gki-6.1-boot_a.bin" "gki-boot-a15-6.6-gz.zip:gki-6.6-boot_a.bin"; do
    zipfile="${pair%%:*}"
    binfile="${pair##*:}"
    if [ -f "$zipfile" ] && [ ! -f "$binfile" ]; then
        echo -e "${YELLOW}[EXT]${NC}  $binfile (from $zipfile)"
        tmpdir=$(mktemp -d)
        unzip -q -o "$zipfile" -d "$tmpdir"
        boot_found=$(find "$tmpdir" -name "boot*.img" -type f | head -1)
        if [ -n "$boot_found" ]; then
            cp "$boot_found" "$binfile"
        else
            echo "  WARNING: No boot*.img found in $zipfile"
        fi
        rm -rf "$tmpdir"
    fi
done

if [ "${1:-}" = "--all" ]; then
    echo ""
    echo "=== GSI images (large, used in failed experiments) ==="

    # AOSP arm64 GSI (Android 15, userdebug)
    # Original: aosp_arm64-exp-BP11.241210.004-12926906-ac28fd4c.zip
    download \
        "https://dl.google.com/developers/android/baklava/images/gsi/aosp_arm64-exp-BP11.241210.004-12926906-ac28fd4c.zip" \
        "aosp_arm64_gsi.zip"

    # Extract system.img from AOSP GSI
    if [ -f "aosp_arm64_gsi.zip" ] && [ ! -f "system.img" ]; then
        echo -e "${YELLOW}[EXT]${NC}  system.img (from aosp_arm64_gsi.zip)"
        unzip -q -o "aosp_arm64_gsi.zip" "system.img" -d .
    fi

    # LineageOS 22.2 GSI
    # Check SourceForge for latest URL - this changes with each build
    LINEAGE_URL="https://sourceforge.net/projects/andyyan-gsi/files/lineage-22/lineage-22.2-20260105-VANILLA-arm64_bgN-EXT4-image.7z/download"
    download \
        "$LINEAGE_URL" \
        "LineageOS-22.2-VANILLA-EXT4-GSI.7z" \
        || echo "  LineageOS GSI URL may have changed. Check: https://sourceforge.net/projects/andyyan-gsi/files/"

    # Extract LineageOS img from 7z
    if [ -f "LineageOS-22.2-VANILLA-EXT4-GSI.7z" ] && [ ! -f "LineageOS-22.2-20260105-VANILLA-EXT4-GSI.img" ]; then
        echo -e "${YELLOW}[EXT]${NC}  LineageOS GSI img (from .7z)"
        7z x -y "LineageOS-22.2-VANILLA-EXT4-GSI.7z" >/dev/null 2>&1 \
            || echo "  Install p7zip-full to extract: sudo apt install p7zip-full"
    fi
else
    echo ""
    echo "Skipping GSI images (~4.5GB). Use --all to include them."
fi

echo ""
echo "=== Done ==="
echo "Note: Device-specific dumps (gpt_raw.bin, misc_*.bin, vbmeta_*.bin)"
echo "      are tracked in git — they cannot be re-downloaded."
