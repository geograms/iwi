# LineageOS 22.2 GSI on HOTWAV Hyper 8 Ultra — Step-by-Step Guide

> Tested and confirmed working on 2026-02-07.
> No official LineageOS build exists for this device. This guide uses a Generic System Image (GSI).

## Device Specs

| | |
|---|---|
| **Model** | HOTWAV Hyper 8 Ultra |
| **SoC** | MediaTek Dimensity 7050 (MT6877V/TTZA) |
| **Stock OS** | Android 15 |
| **Kernel** | 6.6.118-android15-8 (GKI branch: android15-6.6) |
| **Boot image** | v4, gzip compressed kernel, no ramdisk |
| **Storage** | UFS, 512 GB |
| **Partitions** | Dynamic (Virtual A/B), super partition 13,968 MB |
| **Filesystem** | erofs for system/vendor/product |

---

## What You Need

### Software

1. **mtkclient** — MediaTek exploit tool for low-level partition writes
   - Clone: `git clone https://github.com/bkerler/mtkclient`
   - Install in a Python venv: `python3 -m venv mtk-venv && source mtk-venv/bin/activate && pip install -r requirements.txt`
   - **Apply patches** (see [mtkclient Patches](#mtkclient-patches) section below)

2. **Android SDK Platform Tools** — for `adb` and `fastboot`
   - https://developer.android.com/tools/releases/platform-tools

3. **GKI boot image** — Google's Generic Kernel Image for android15-6.6
   - Download: `https://dl.google.com/android/gki/gki-certified-boot-android15-6.6-YYYY-MM_rN-gz.zip`
   - Extract the `boot-6.6-gz.img` file from the zip

4. **LineageOS GSI** — Generic System Image, VANILLA-EXT4 variant
   - Source: MisterZtr GSI builds on SourceForge
   - File: `LineageOS-22.2-YYYYMMDD-VANILLA-EXT4-GSI.img` (~2.5 GB)
   - Use VANILLA (no Google apps) + EXT4 (read-write, needed for root later)

### Hardware

- USB-A to USB-C cable (USB-C to USB-C may not work with mtkclient)
- A Linux PC (mtkclient works best on Linux)

### Prerequisite: Unlocked Bootloader

Your bootloader must already be unlocked. The HOTWAV Hyper 8 Ultra can be unlocked via:
- Settings → Developer Options → OEM Unlocking (toggle on)
- `adb reboot bootloader` → `fastboot flashing unlock`

---

## Step-by-Step Instructions

### Overview

The process has two phases:

1. **Phase 1 (mtkclient)**: Write a GKI kernel, disabled vbmeta, and slot metadata directly to flash storage using MediaTek's download mode. This gets the device booting with a generic kernel.
2. **Phase 2 (fastbootd)**: From booted Android, enter fastbootd and flash the LineageOS GSI over the stock system partition.

### Prepare the Files

#### 1. Create a disabled vbmeta image (64 KB)

Android Verified Boot must be disabled or the GKI kernel will fail signature checks.

```bash
# Create a 4096-byte vbmeta with AVB disabled (flags=0x02)
python3 -c "
import struct
# AVB vbmeta header
header = b'AVB0'                    # magic
header += struct.pack('>I', 1)      # major version
header += struct.pack('>I', 2)      # minor version
header += b'\x00' * 104             # padding to offset 120
header += struct.pack('>I', 2)      # flags: 0x02 = disable verification
header += b'\x00' * (4096 - len(header))  # pad to 4096 bytes
with open('vbmeta_disabled.img', 'wb') as f:
    f.write(header)
"

# Pad to 64 KB (mtkclient minimum write size)
dd if=/dev/zero bs=65536 count=1 of=vbmeta_padded.bin
dd if=vbmeta_disabled.img of=vbmeta_padded.bin conv=notrunc
```

#### 2. Create the GKI boot image (64 MB padded)

The boot partition is 64 MB. The GKI boot image must be padded to fill it completely.

```bash
# Extract GKI boot image from downloaded zip
unzip gki-certified-boot-android15-6.6-*.zip boot-6.6-gz.img

# Pad to exactly 64 MB (67108864 bytes)
dd if=/dev/zero bs=1 count=67108864 of=gki-boot-padded.bin
dd if=boot-6.6-gz.img of=gki-boot-padded.bin conv=notrunc
```

#### 3. Create slot A misc image (64 KB)

This tells the bootloader to boot from slot A.

```bash
python3 -c "
import struct, binascii

data = bytearray(65536)  # 64 KB, zero-filled

# bootloader_control at offset 0x800
bc = bytearray(32)
bc[0:4] = b'_a\x00\x00'     # slot_suffix
bc[4:8] = b'BCAB'            # magic
bc[8] = 0x01                 # version
bc[9] = 0x02                 # nb_slot
bc[10] = 0x00                # recovery_tries_remaining
bc[11] = 0x00                # merge_status

# slot_info[0] (slot A): priority=15, tries=7, successful=1, verity=0
bc[12] = 15   # priority
bc[13] = 7    # tries_remaining
bc[14] = 1    # successful_boot
bc[15] = 0    # verity_corrupted

# slot_info[1] (slot B): priority=14, tries=7, successful=1, verity=0
bc[16] = 14
bc[17] = 7
bc[18] = 1
bc[19] = 0

# CRC32 over first 28 bytes
crc = binascii.crc32(bc[0:28]) & 0xFFFFFFFF
struct.pack_into('<I', bc, 28, crc)

data[0x800:0x800+32] = bc

with open('misc_slot_a.bin', 'wb') as f:
    f.write(data)
print('Created misc_slot_a.bin')
print(f'CRC32: {crc:#010x}')
"
```

### Phase 1: Flash via mtkclient (3 power cycles)

mtkclient exploits MediaTek's preloader download mode to write directly to flash storage. Each operation requires a full power cycle.

**How to enter preloader mode:**
1. Power off the device completely (disconnect USB, hold power button 15-20 seconds)
2. Connect USB cable to PC — do NOT press any buttons on the phone
3. The device's boot loop will be caught by mtkclient automatically
4. mtkclient will print "Status: Detected" when connected

**Step 1 — Disable AVB verification:**

```bash
python3 mtk.py wo 0x8a08000 0x10000 vbmeta_padded.bin --sectorsize 4096
```

Wait for "Write succeeded". Then power cycle (disconnect USB, hold power 15-20s).

**Step 2 — Flash GKI kernel to boot_a:**

```bash
python3 mtk.py wo 0x2ac00000 0x4000000 gki-boot-padded.bin --sectorsize 4096
```

This writes 64 MB. Wait for completion (~10 seconds). Then power cycle.

**Step 3 — Set slot A as active:**

```bash
python3 mtk.py wo 0x8000 0x10000 misc_slot_a.bin --sectorsize 4096
```

Wait for "Write succeeded". Then power cycle.

**Step 4 — Boot the device:**

Disconnect USB, hold power 15-20 seconds, then press power to turn on normally. The device should boot to the stock Android home screen using the GKI kernel.

> **If it boot-loops**: You may have the wrong GKI kernel version. See [Identifying the Correct GKI Kernel](#identifying-the-correct-gki-kernel) below.

### Phase 2: Flash LineageOS GSI via fastbootd

Once the device has booted to Android:

**Step 5 — Enable USB Debugging:**

1. Go to Settings → About Phone → tap "Build Number" 7 times to enable Developer Options
2. Go to Settings → Developer Options → enable "USB Debugging"
3. Connect USB cable, tap "Allow" on the USB debugging authorization prompt
4. Verify: `adb devices` should show the device

**Step 6 — Enter fastbootd:**

```bash
adb reboot fastboot
```

Wait for the fastbootd screen (shows Android robot logo with "fastbootd" text).

> **WARNING**: Do NOT use `adb reboot bootloader`. That enters basic fastboot (LK), where commands hang on this device. You MUST use `adb reboot fastboot` to enter fastbootd (userspace fastboot).

**Step 7 — Delete product partition to free space:**

```bash
fastboot delete-logical-partition product_a
```

The LineageOS GSI (2.5 GB) is larger than the stock system_a (2.4 GB). Deleting product_a frees 1.7 GB in the super partition.

**Step 8 — Flash the GSI:**

```bash
fastboot flash system_a LineageOS-22.2-YYYYMMDD-VANILLA-EXT4-GSI.img
```

This sends ~10 sparse chunks and completes in about 90 seconds.

**Step 9 — Wipe userdata:**

```bash
fastboot -w
```

You may see "not automatically formatting" and "File system type raw not supported" — this is normal. Android will format the partition on first boot.

**Step 10 — Reboot:**

```bash
fastboot reboot
```

### Phase 3: First Boot

The device will reboot into LineageOS. The first boot may show the Android logo for several minutes while the system initializes and formats userdata.

The LineageOS setup wizard should appear. Hardware that works with stock vendor HALs (display, touchscreen, WiFi, cellular, cameras) should function normally since the vendor partition is untouched.

### Phase 4 (Optional): Root with Magisk

After LineageOS is running:

1. **Extract the current boot image:**
   ```bash
   adb shell su -c "dd if=/dev/block/by-name/boot_a of=/sdcard/boot_a.img"
   adb pull /sdcard/boot_a.img
   ```

2. **Patch with Magisk:**
   - Transfer the Magisk APK to the device and install it
   - Open Magisk → Install → Select and Patch a File → choose `boot_a.img`
   - Pull the patched image: `adb pull /sdcard/Download/magisk_patched-*.img`

3. **Flash the patched boot:**
   ```bash
   adb reboot fastboot
   fastboot flash boot_a magisk_patched-*.img
   fastboot reboot
   ```

4. Open Magisk app — it should show "Installed" status.

---

## Key Warnings and Gotchas

### Use fastbootd, NOT basic fastboot
- `adb reboot bootloader` → basic fastboot (LK) — **commands hang on this device**
- `adb reboot fastboot` → fastbootd (userspace) — **this is what you need**
- Basic fastboot shows "FASTBOOT" text; fastbootd shows Android robot logo

### Flash GSI to slot A, NOT slot B
This is a Virtual A/B device. Vendor, system_ext, vendor_dlkm, and product logical partitions only exist for slot A. Flashing a GSI to system_b will boot-loop because there's no vendor_b.

### mtkclient power cycle procedure
Each mtkclient write requires a full power cycle:
1. Disconnect USB cable
2. Hold power button 15-20 seconds (until device is fully off)
3. Reconnect USB cable WITHOUT pressing any buttons
4. mtkclient catches the preloader download mode during boot

Do NOT hold volume buttons — that enters BROM mode which requires a preloader binary.

### `fastboot -w` warning is harmless
The "not automatically formatting" and "File system type raw not supported" messages are normal. Android's init process formats userdata on first boot.

---

## Identifying the Correct GKI Kernel

If you're unsure which GKI kernel version your device uses, compare compressed kernel sizes from the stock boot image against Google's GKI certified boot images.

**Method:**
1. Read the first 64 KB of the stock boot partition via mtkclient
2. Parse the Android boot image header to get `kernel_size`
3. Download GKI certified boot images for all candidate branches
4. Compare the `kernel_size` — the closest match is your kernel version

For the HOTWAV Hyper 8 Ultra:

| GKI Branch | Kernel Size (gzip) | Difference from Stock |
|---|---|---|
| Stock | 14,538,864 bytes | — |
| **android15-6.6** | **14,643,299 bytes** | **0.7%** (correct) |
| android14-6.1 | 14,095,612 bytes | 3.0% |
| android14-5.15 | 17,276,341 bytes | 18.8% |
| android12-5.10 | 19,708,400 bytes | 35.6% |
| android13-5.10 | 21,527,841 bytes | 48.1% |

GKI certified boot images are available at:
```
https://dl.google.com/android/gki/gki-certified-boot-<branch>-YYYY-MM_rN-gz.zip
```

> **Note**: Online specs for the MT6877 (Dimensity 7050) incorrectly report kernel 5.10. The size-comparison method above is more reliable than web searches.

---

## mtkclient Patches

The stock mtkclient has bugs that prevent writes on this device. Two patches are required:

### Patch 1: storage.py — Minimum write size

File: `mtkclient/Library/DA/storage.py`, around line 356.

The stock code forces a minimum 128 KB (0x20000) transfer, but USB dies after 64 KB, so the write never finalizes.

**Change:**
```python
# Before:
if length < 0x20000:
    length = 0x20000

# After:
if length < 0x10000:
    length = 0x10000
```

### Patch 2: xflash_lib.py — Null packet length fallback

File: `mtkclient/Library/DA/xflash/xflash_lib.py`, in the `writeflash()` function.

Add a fallback for when the DA returns `None` as the packet length:

```python
# In writeflash(), after getting packet_length:
if packet_length is None:
    packet_length = 0x10000  # fallback to 64KB
```

---

## Partition Map Reference

### GPT Physical Partitions (key offsets, 4096-byte UFS sectors)

| Partition | Offset | Size |
|---|---|---|
| misc | 0x8000 | 0.5 MB |
| vbmeta_a | 0x8a08000 | 8 MB |
| vbmeta_system_a | 0x9208000 | 8 MB |
| vbmeta_vendor_a | 0x9a08000 | 8 MB |
| vbmeta_b | 0xa208000 | 8 MB |
| vbmeta_system_b | 0xaa08000 | 8 MB |
| vbmeta_vendor_b | 0xb208000 | 8 MB |
| boot_a | 0x2ac00000 | 64 MB |
| boot_b | 0x4e400000 | 64 MB |
| vendor_boot_b | 0x52400000 | 65 MB |
| super | 0x58000000 | 13,968 MB |

### Slot A Logical Partitions (inside super)

| Partition | Size | Filesystem | After GSI Flash |
|---|---|---|---|
| system_a | 2.5 GB | ext4 | LineageOS 22.2 GSI |
| system_ext_a | 497 MB | erofs | Stock (untouched) |
| vendor_a | 511 MB | erofs | Stock (untouched) |
| product_a | — | — | DELETED (was 1.7 GB) |
| vendor_dlkm_a | 15 MB | erofs | Stock (untouched) |
| system_dlkm_a | ~15 MB | erofs | Stock (untouched) |

### bootloader_control Structure (misc partition, offset 0x800)

```
offset 0x000: slot_suffix[4]  ("_a\0\0" or "_b\0\0")
offset 0x004: magic[4]        ("BCAB")
offset 0x008: version          (1 byte, = 0x01)
offset 0x009: nb_slot          (1 byte, = 0x02)
offset 0x00A: recovery_tries   (1 byte)
offset 0x00B: merge_status     (1 byte)
offset 0x00C: slot_info[0]     (4 bytes: priority, tries, successful, verity)
offset 0x010: slot_info[1]     (4 bytes)
offset 0x014-0x01B: reserved   (8 bytes)
offset 0x01C: crc32            (4 bytes, CRC32 over bytes 0-27)
```

---

## Troubleshooting

### Device boot-loops after flashing GKI kernel
- Wrong kernel version. Use the [size-comparison method](#identifying-the-correct-gki-kernel) to find the correct GKI branch.
- If GKI android14-6.1 was flashed: it shows the Android logo briefly then loops. Switch to android15-6.6.

### mtkclient can't connect
- Make sure the device is OFF before connecting USB
- Do NOT press any buttons — preloader mode is caught automatically during boot
- If it enters BROM mode (vol up + vol down), it will fail without a preloader binary
- Try a different USB port (USB 2.0 ports are more reliable than USB 3.0)

### fastboot commands hang
- You're in basic fastboot (LK), not fastbootd. Reboot to Android and use `adb reboot fastboot`.
- If stuck in basic fastboot, hold power 10+ seconds to force reboot.

### "not automatically formatting" during `fastboot -w`
- This is normal on this device. Android formats userdata on first boot.

### LineageOS boot-loops after flash
- Make sure you flashed to `system_a`, not `system` or `system_b`
- Make sure you deleted `product_a` first (GSI needs the space)
- Make sure vbmeta_a has AVB disabled (flags=0x02)
- Make sure you're booting slot A (misc partition set correctly)

### Can't backup stock firmware
- `fastboot fetch` is not supported on this device
- `dd` requires root access (available after Magisk install)
- mtkclient reads are limited to 64 KB per session (impractical for full partitions)
- The stock boot_b kernel remains intact and can be restored later
- vendor_a, system_ext_a, vendor_dlkm_a are not modified by this procedure

---

## What Didn't Work (for reference)

These approaches were tried and failed — documented to save others time:

1. **BCB commands** ("bootonce-bootloader", "boot-recovery") written to misc offset 0x0 — device ignores them
2. **Hardware key combos** for bootloader menu — inconsistent, stopped working after vbmeta was modified
3. **vbmeta with flags=0x00** (verification enabled) — no effect; bootloader menu was triggered by hash mismatch, not the enabled flag
4. **Zeroing boot_a header** — device falls back to slot B which also boot-loops
5. **Catching ADB during boot loop** — kernel crashes too early for USB gadget to initialize
6. **`fastboot fetch`** — not supported, commands hang
7. **Reading full partitions via mtkclient** — USB overflow after 64 KB, impractical for large reads
8. **GKI android14-6.1 kernel** — wrong version, boot-loops with Android logo
9. **Flashing GSI to slot B** — Virtual A/B device has no vendor_b/product_b partitions
10. **Basic fastboot (LK) commands** — all hang with "< waiting for any device >"
