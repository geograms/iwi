# Root Experiments — HOTWAV Hyper 8 Ultra

## Device Info

| Property | Value |
|---|---|
| Model | HOTWAV Hyper 8 Ultra |
| ADB Serial | `Hyper8Ultra0000957` |
| SoC | MediaTek MT6877 (Dimensity 900 / 7050) |
| Android | 15 (AP3A.240905.015.A2) |
| Build | `HOTWAV_Hyper 8 Ultra_V12_20251226` |
| Kernel | 6.6.89-android15-8-gbe8d201b0d27-ab13762941-4k |
| Partition scheme | A/B (active slot: `_a`) |
| Storage | UFS (`/dev/block/sdc*`) |
| boot_a | `/dev/block/sdc32` (64MB / 0x4000000) |
| init_boot_a | `/dev/block/sdc34` (8MB / 0x800000) |
| FOTA provider | Chamsion (`ro.fota.oem=chamsion_MTK_15.0`) |
| Bootloader | **Unlocked** (via `fastboot flashing unlock`) |

## Why Root Is Needed

Our IWI-Demo app needs to control the DMR radio module via:
- Serial port `/dev/ttyS0` (SELinux context: `u:object_r:ttyS_device:s0`)
- Sysfs power control `/sys/devices/platform/intercom/intercom_{power,pwd,ptt}_control` (SELinux context: `u:object_r:sysfs:s0`)

The stock QuickChat app works because it's installed as a system app at `/system/app/QuickChat/` and runs with `platform_app` SELinux context, signed with the HOTWAV/Wheatek OEM platform key. Our app runs as `untrusted_app` and gets `EACCES` on all hardware operations.

## Experiments (chronological)

### 1. System App Installation (FAILED)
**Idea**: Install our APK as a system app at `/system/app/`.
**Result**: System partition is `erofs` (read-only, non-remountable). Even with `adb remount`, the filesystem cannot be written to. Would need to rebuild the entire system image.

### 2. Platform Key Signing (IMPOSSIBLE)
**Idea**: Sign our APK with the HOTWAV/Wheatek platform key to get `platform_app` context.
**Result**: The platform key is a private key held by the OEM. We extracted the public certificate fingerprint (`BD:C0:8A:B5:E5:F0:9B:82:A7:37:6A:22:57:E2:87:77`) but the private key is inaccessible. AOSP test keys have a different fingerprint, so they won't match.

### 3. ADB Root (FAILED)
**Idea**: `adb root` to get root shell.
**Result**: `adbd cannot run as root in production builds`. Only works on `userdebug` or `eng` builds.

### 4. SELinux Permissive Mode (FAILED)
**Idea**: `adb shell setenforce 0` to disable SELinux enforcement.
**Result**: Requires root. Cannot be done from `shell` user.

### 5. Bootloader Unlock (SUCCESS)
**Steps**:
1. Enabled OEM unlocking in Developer Options
2. `adb reboot bootloader`
3. `fastboot flashing unlock` — succeeded after ~30 seconds
4. Device factory reset and bootloader confirmed unlocked

**Side effects**: Factory reset wiped all data. Had to redo Android setup, re-enable Developer Options, re-enable USB Debugging.

### 6. Fastboot Fetch init_boot (FAILED)
**Idea**: `fastboot fetch init_boot_a` to read the partition for Magisk patching.
**Result**: `Device does not support fetch command.` — standard MediaTek limitation. MediaTek fastboot implementations typically don't support the `fetch` command.

### 7. DD from ADB Shell (FAILED)
**Idea**: `dd if=/dev/block/sdc34 of=/sdcard/init_boot_a.img` via ADB shell.
**Result**: `Permission denied` — SELinux still blocks `untrusted_app`/`shell` from reading block devices, even with an unlocked bootloader.

### 8. DD from Recovery ADB (FAILED)
**Idea**: `adb reboot recovery`, then use ADB shell in recovery mode (which typically runs as root).
**Result**: Recovery's adbd crashes with `Could not set SELinux context for subprocess` (SIGABRT). Both `adb shell` and `adb exec-out` fail. This is a heavily locked-down stock recovery.

### 9. BROM Mode via Button Combo (FAILED)
**Idea**: Enter MediaTek BROM (bootrom) mode for `mtkclient` partition extraction. Standard method: power off, hold Volume Up/Down, connect USB.
**Result**: Device doesn't enter BROM mode with any button combination (Vol Up, Vol Down, both). Just shows charging animation and boots normally.

### 10. mtkclient with --crash (FAILED)
**Idea**: Use mtkclient's software crash exploit to force BROM mode.
**Result**: mtkclient v2.1.2 installed (`/tmp/mtk-venv/bin/python /tmp/mtkclient/mtk.py`). The `--crash` flag didn't trigger BROM mode — kept polling without detecting the device.

### 11. Magisk Sideload via Recovery (FAILED)
**Idea**: Rename Magisk APK to .zip, use `adb sideload` in recovery's "Apply update from ADB" mode.
**Result**: Magisk v28.1 downloaded and sideloaded, but stock recovery rejected the package due to signature verification failure. Recovery only accepts OTA packages signed with the OEM key.

### 12. Stock Firmware Download (FAILED)
**Idea**: Download HOTWAV Hyper 8 Ultra stock firmware, extract `init_boot.img`, patch with Magisk.
**Result**: Firmware not available on any repository checked:
- androidmtk.com — device not listed
- firmwarepanda.com — device not listed
- romprovider.com — device not listed
- hotwav.com — no firmware download section on product page
This is a relatively new device (V12 firmware dated 2025-12-26).

### 13. Google CI GKI Boot Image (SUCCESS — downloaded)
**Idea**: Download GKI boot.img from Google's Android CI (build ID `ab13762941` matching the kernel).
**Result**: Successfully downloaded from `https://ci.android.com/builds/submitted/13762941/kernel_aarch64/latest/raw/boot.img`.
- `boot.img` — 67,108,864 bytes (64MB), valid `ANDROID!` header, exact match for kernel build `ab13762941`
- `init_boot.img` — returned HTML error page (not available as a kernel CI artifact, it's a platform artifact)
- `boot-lz4.img` — 53,477,376 bytes (also available, lz4-compressed variant)
- **Key insight**: The build ID `ab13762941` from the kernel version string (`6.6.89-android15-8-gbe8d201b0d27-ab13762941-4k`) maps directly to Google CI URL `https://ci.android.com/builds/submitted/<build_id>/kernel_aarch64/latest/raw/<filename>`

### 14. DSU with Google Official GSI (FAILED)
**Idea**: Use DSU (Dynamic System Update) to temporarily boot Google's official AOSP GSI, which is a `userdebug` build where `adb root` works. Then extract `init_boot_a` from the root shell.
**Result**:
- `gsi_tool` exists at `/system/bin/gsi_tool` but requires root to install
- DSU Loader app not present on device
- Downloaded AOSP arm64 GSI: `aosp_arm64-exp-BP11.241210.004-12926906-ac28fd4c.zip` (848MB)
- Extracted `system.img` (1.8GB) and `vbmeta.img` (4KB) from the zip
- Flashed `system_b` logical partition in fastbootd mode with `-S 256M` sparse chunking
- Device fell back to slot_a because slot_b was missing other logical partitions (vendor_b, product_b, system_ext_b, etc.)
- Flashing vbmeta_b failed ("No such file or directory" — physical partition needs regular fastboot, not fastbootd)

### 15. GSI Flash to Slot B (FAILED)
**Idea**: Flash Google GSI to system_b, switch to slot b, boot with `adb root`.
**Result**: Successfully flashed system_b in fastbootd but device couldn't boot slot b due to missing complementary partitions. Automatic fallback to slot_a. GSI-based approaches require all logical partitions in the slot to be populated.

### 16. FOTA API Reverse Engineering (PARTIAL)
**Idea**: Reverse-engineer the HOTWAV FOTA app to query their OTA server and download firmware containing `init_boot.img`.
**Findings**:
- Decompiled `com.hotwav.update` APK at `/tmp/fota_extract/sources/`
- OTA Server: `https://fota5p.adups.com` (Adups, Chinese FOTA provider)
- Fallback server: `https://fota5p.adups.cn`
- API endpoints:
  - `/otainter-5.0/fota5/detectSchedule.do` — delta update check
  - `/otainter-5.0/fota5/fullDetectSchedule.do` — full update check
  - `/otainter-5.0/fota5/submitReport.do` — reporting
  - `/otainter-5.0/fota5/fcmReport.do` — FCM reporting
- Request parameters (from `t1/c.java`): `device_type`, `platform`, `project`, `version`, `sdk_level`, `sdk_release`, `mid`, `imei1`, `imei2`, `swFingerprint`, `appVersion`, `local`, `operator`, `spn1`, `androidId`, `fotaSign`, `fcmId`, `agreeType`, etc.
- **Encryption**: Parameters are concatenated as `&key=value` string, then encrypted with a custom XOR-based cipher (`v1/f.java` method `j()`), sent as `key=<encrypted_hex>&shaKey=<sha256_of_encrypted_hex>` POST body
- FOTA app has no launcher activity (only `GdprActivity`), services are not exported
- Triggering update check via ADB failed:
  - `am startservice` → "no service started" (not exported)
  - `am broadcast BOOT_COMPLETED` → "Permission Denial" (protected broadcast)
  - `cmd jobscheduler run` → "Could not find job" (no jobs registered)
- **Blocked**: Would need to reimplement the proprietary XOR encryption to craft manual API requests

### 17. KernelSU GKI Approach (FAILED — device bricked)
**Idea**: Use KernelSU instead of Magisk. KernelSU patches the kernel itself (in boot partition), not the ramdisk (in init_boot). Since we have the exact GKI boot.img from Google CI, we can patch it with KernelSU and flash to boot_a.
**Steps taken**:
1. Downloaded `ksud-x86_64-unknown-linux-musl` (3MB) from KernelSU v3.1.0 release
2. Downloaded `android15-6.6_kernelsu.ko` (243KB) — kernel module for our KMI
3. Downloaded `KernelSU_v3.1.0_32302-release.apk` (7.9MB) — manager app
4. Extracted `magiskboot` from Magisk APK (`lib/x86_64/libmagiskboot.so` — statically linked, works on Linux x86_64)
5. Patched GKI boot.img: `ksud boot-patch -b /tmp/gki_boot.img -m /tmp/kernelsu.ko --kmi android15-6.6 --magiskboot /tmp/magiskboot -o /tmp/`
   - Output: `/tmp/kernelsu_patched_20260207_133853.img` (64MB, valid `ANDROID!` header)
   - Note: "No ramdisk, create by default" — expected for Android 15 GKI boot images where ramdisk is in init_boot
6. Installed KernelSU manager APK on device (succeeded)
7. Attempted `fastboot boot` (temporary boot) → `FAILED (Status read failed (No such device))` — MTK doesn't support `fastboot boot`
8. Flashed permanently: `fastboot flash boot_a /tmp/kernelsu_patched_20260207_133853.img` → **OKAY** (1.6s)
9. Disabled AVB: `fastboot --disable-verity --disable-verification flash vbmeta_a root/vbmeta.img` → **OKAY**
10. Rebooted: `fastboot reboot`
11. Device did NOT boot — entered preloader download mode
12. Flashed unpatched GKI boot.img back: `fastboot flash boot_a /tmp/gki_boot.img` → still didn't boot
13. **Key lesson**: The Google CI GKI boot.img is NOT identical to the OEM's stock boot.img. The OEM customizes the kernel (vendor modules, device tree, etc.). Flashing vanilla GKI bricks the device.

### 18. mtkclient Recovery Attempts (PARTIAL SUCCESS)
**Idea**: Use mtkclient to recover the bricked device via MediaTek preloader download mode.
**Steps taken**:
1. Device enters preloader download mode (USB ID `0e8d:2000`) on boot failure
2. Installed udev rules (`/etc/udev/rules.d/52-mtk.rules`) for USB permissions
3. mtkclient successfully detects device, uploads DA (Download Agent), detects UFS storage
4. **DA partition enumeration hangs**: Every partition-based command (`printgpt`, `r`, `w`) gets stuck at "Requesting available partitions" with "Error on sending dev ctrl 0x4000X: OK" messages
5. `meta FASTBOOT` sets flag successfully but device never actually enters fastboot (reboots back to preloader because boot.img is invalid and LK can't proceed)
6. `da meta FASTBOOT` also sets flag but device doesn't stay in fastboot
7. **Key discovery**: `mtk.py ro` (read at offset) and `mtk.py wo` (write at offset) BYPASS partition enumeration entirely!
8. DA can read exactly one 0x10000 (64KB) chunk before USB I/O error disconnects
9. **Patched mtkclient** to save partial read data (flush after each chunk write in `thread_handling.py`, handle partial reads in `xflash_lib.py`)
10. Successfully read 64KB of GPT data from offset 0 → `/tmp/gpt_raw.bin`
11. **Parsed full GPT partition table** — see "Full GPT Partition Map" section below

### 19. A/B Slot Switch via misc Partition (NEXT STEP)
**Idea**: Switch active slot from A (broken boot) to B (stock boot) by writing to the `misc` partition at offset 0x800.
**Plan**:
1. Read 64KB from misc partition (offset `0x8000` on disk) using patched mtkclient `ro`
2. Parse A/B metadata at offset 0x800 within misc (AVB `AvbABData` format, 32 bytes)
3. Modify slot priorities: set slot B priority=15, tries_remaining=7; lower slot A priority=14
4. Recalculate CRC32 of first 28 bytes
5. Write modified misc back using mtkclient `wo`
6. Reboot — device should boot from slot B with stock kernel
**Status**: NOT YET ATTEMPTED

### FOTA Encryption Details (v1/f.java)

The `j()` method implements a custom symmetric cipher:
1. Generate random key length (3-14 bytes) and random padding length (0-15 bytes)
2. Generate random key bytes
3. XOR plaintext with repeating key
4. Rotate each key byte left by 3 bits
5. Construct frame: `[header_byte][padding][rotated_key][xored_data]`
6. Return as uppercase hex string

The `p()` method is just SHA-256 of the input string (used for `shaKey` parameter).

## Full GPT Partition Map (from raw UFS read)

Read via `mtk.py ro 0 0x10000 /tmp/gpt_raw.bin` (patched mtkclient, partial read).
UFS sector size: 4096 bytes. GPT header at sector 1 (offset 0x1000).

| # | Name | LBA Start | LBA End | Size (MB) | Raw Offset | Raw Length |
|---|------|-----------|---------|-----------|------------|------------|
| 0 | misc | 8 | 135 | 0.5 | `0x8000` | `0x80000` |
| 1 | para | 136 | 263 | 0.5 | `0x88000` | `0x80000` |
| 2 | expdb | 264 | 10503 | 40.0 | `0x108000` | `0x2800000` |
| 3 | frp | 10504 | 10759 | 1.0 | `0x2908000` | `0x100000` |
| 4 | nvcfg | 10760 | 18951 | 32.0 | `0x2A08000` | `0x2000000` |
| 5 | nvdata | 18952 | 35335 | 64.0 | `0x4A08000` | `0x4000000` |
| 6 | vbmeta_a | 35336 | 37383 | 8.0 | `0x8A08000` | `0x800000` |
| 7 | vbmeta_system_a | 37384 | 39431 | 8.0 | `0x9208000` | `0x800000` |
| 8 | vbmeta_vendor_a | 39432 | 41479 | 8.0 | `0x9A08000` | `0x800000` |
| 9 | vbmeta_b | 41480 | 43527 | 8.0 | `0xA208000` | `0x800000` |
| 10 | vbmeta_system_b | 43528 | 45575 | 8.0 | `0xAA08000` | `0x800000` |
| 11 | vbmeta_vendor_b | 45576 | 47623 | 8.0 | `0xB208000` | `0x800000` |
| 12 | metadata | 47624 | 64007 | 64.0 | `0xBA08000` | `0x4000000` |
| 13 | persist | 64008 | 77823 | 54.0 | `0xFA08000` | `0x3600000` |
| 14 | protect1 | 77824 | 79871 | 8.0 | `0x13000000` | `0x800000` |
| 15 | protect2 | 79872 | 81919 | 8.0 | `0x13800000` | `0x800000` |
| 16 | seccfg | 81920 | 83967 | 8.0 | `0x14000000` | `0x800000` |
| 17 | otp | 83968 | 96255 | 48.0 | `0x14800000` | `0x3000000` |
| 18 | modem_a | 96256 | 147455 | 200.0 | `0x17800000` | `0xC800000` |
| 19 | spmfw_a | 147456 | 147711 | 1.0 | `0x24000000` | `0x100000` |
| 20 | audio_dsp_a | 147712 | 149759 | 8.0 | `0x24100000` | `0x800000` |
| 21 | pi_img_a | 149760 | 150015 | 1.0 | `0x24900000` | `0x100000` |
| 22 | dpm_a | 150016 | 151039 | 4.0 | `0x24A00000` | `0x400000` |
| 23 | scp_a | 151040 | 154111 | 12.0 | `0x24E00000` | `0xC00000` |
| 24 | sspm_a | 154112 | 154623 | 2.0 | `0x25A00000` | `0x200000` |
| 25 | mcupm_a | 154624 | 154879 | 1.0 | `0x25C00000` | `0x100000` |
| 26 | cam_vpu1_a | 154880 | 158719 | 15.0 | `0x25D00000` | `0xF00000` |
| 27 | cam_vpu2_a | 158720 | 162559 | 15.0 | `0x26C00000` | `0xF00000` |
| 28 | cam_vpu3_a | 162560 | 166399 | 15.0 | `0x27B00000` | `0xF00000` |
| 29 | gz_a | 166400 | 174591 | 32.0 | `0x28A00000` | `0x2000000` |
| 30 | lk_a | 174592 | 175103 | 2.0 | `0x2AA00000` | `0x200000` |
| **31** | **boot_a** | **175104** | **191487** | **64.0** | **`0x2AC00000`** | **`0x4000000`** |
| 32 | vendor_boot_a | 191488 | 208127 | 65.0 | `0x2EC00000` | `0x4100000` |
| 33 | init_boot_a | 208128 | 210175 | 8.0 | `0x32D00000` | `0x800000` |
| 34 | dtbo_a | 210176 | 212223 | 8.0 | `0x33500000` | `0x800000` |
| 35 | tee_a | 212224 | 213503 | 5.0 | `0x33D00000` | `0x500000` |
| 36 | sec1 | 213504 | 214015 | 2.0 | `0x34200000` | `0x200000` |
| 37 | proinfo | 214016 | 214783 | 3.0 | `0x34400000` | `0x300000` |
| 38 | nvram | 214784 | 231167 | 64.0 | `0x34700000` | `0x4000000` |
| 39 | boot_para | 231168 | 237823 | 26.0 | `0x38700000` | `0x1A00000` |
| 40 | logo | 237824 | 241663 | 15.0 | `0x3A100000` | `0xF00000` |
| 41 | modem_b | 241664 | 292863 | 200.0 | `0x3B000000` | `0xC800000` |
| 53 | lk_b | 320000 | 320511 | 2.0 | `0x4E200000` | `0x200000` |
| **54** | **boot_b** | **320512** | **336895** | **64.0** | **`0x4E400000`** | **`0x4000000`** |
| 55 | vendor_boot_b | 336896 | 353535 | 65.0 | `0x52400000` | `0x4100000` |
| 56 | init_boot_b | 353536 | 355583 | 8.0 | `0x56500000` | `0x800000` |
| 57 | dtbo_b | 355584 | 357631 | 8.0 | `0x56D00000` | `0x800000` |
| 58 | tee_b | 357632 | 360447 | 11.0 | `0x57500000` | `0xB00000` |
| 59 | super | 360448 | 3936255 | 13968.0 | `0x58000000` | `0x36C800000` |
| 60 | userdata | 3936256 | 124952567 | 472720.0 | `0x3C1000000` | `0x73F8FF8000` |
| 61 | mrdump | 124952568 | 124956663 | 16.0 | `0x7729FF8000` | `0x1000000` |
| 62 | flashinfo | 124956664 | 124960759 | 16.0 | `0x772AFF8000` | `0x1000000` |

## A/B Slot Metadata (for slot switching)

The A/B slot info is stored in the **`misc` partition** at **offset 0x800** from the start of misc.
- misc partition raw offset on UFS: `0x8000`
- So A/B metadata is at raw UFS offset: `0x8000 + 0x800 = 0x8800`
- Format: AVB `AvbABData` (32 bytes, magic `\0AB0` = `00 41 42 30`)

```
Offset  Field                   Size    Notes
0x00    magic                   4       00 41 42 30 ("\0AB0")
0x04    version_major           1       1
0x05    version_minor           1       0
0x06    reserved1               2       00 00
0x08    slots[0].priority       1       15=active, 14=standby, 0=unbootable
0x09    slots[0].tries_remaining 1      0-7
0x0A    slots[0].successful_boot 1      non-zero = success
0x0B    slots[0].reserved       1       00
0x0C    slots[1].priority       1       same as above
0x0D    slots[1].tries_remaining 1
0x0E    slots[1].successful_boot 1
0x0F    slots[1].reserved       1       00
0x10    reserved2               12      00 * 12
0x1C    crc32                   4       CRC32 of bytes 0x00-0x1B (little-endian)
```

To switch to slot B: set `slots[1].priority=15`, `slots[1].tries_remaining=7`, lower `slots[0].priority=14`, recalculate CRC32.

## mtkclient Patching Notes

mtkclient v2.1.2 has issues with this device's DA (partition enumeration hangs). Key fixes:

### Bypass: Use `ro`/`wo` commands
`mtk.py ro <offset> <length> <filename>` and `mtk.py wo <offset> <length> <filename>` bypass partition enumeration by reading/writing at raw UFS offsets.

### Partial read fix (applied to /tmp/mtkclient/)
1. **`mtkclient/Library/thread_handling.py`**: Removed 8MB write buffer, added `wf.flush()` after each chunk write
2. **`mtkclient/Library/DA/xflash/xflash_lib.py`**: Added `error_occurred` flag, skip final USB ack on error, save partial data on USB disconnect

### DA limitations on this device
- Can only transfer one 0x10000 (64KB) chunk per session before USB I/O error
- "Error on sending dev ctrl 0x4000X: OK (0x0)" messages are non-fatal (unsupported control codes)
- Device disconnects USB after first chunk read, requiring full power cycle between attempts

## Key Discoveries

### Google CI Build Artifact URL Pattern
```
https://ci.android.com/builds/submitted/<build_id>/kernel_aarch64/latest/raw/<filename>
```
Where `<build_id>` is extracted from the kernel version string: `6.6.89-android15-8-gbe8d201b0d27-ab<build_id>-4k`

Available artifacts: `boot.img`, `boot-lz4.img`, `boot-gz.img`, `Image`, `System.map`, `*.ko`, `BUILD_INFO`, `gki-info.txt`

### KernelSU Boot Patching on PC
```bash
# Extract magiskboot from Magisk APK (statically linked, runs on Linux x86_64)
unzip Magisk.apk lib/x86_64/libmagiskboot.so -d /tmp/
cp /tmp/lib/x86_64/libmagiskboot.so /tmp/magiskboot && chmod +x /tmp/magiskboot

# Download ksud for Linux
curl -L -o /tmp/ksud https://github.com/tiann/KernelSU/releases/download/v3.1.0/ksud-x86_64-unknown-linux-musl
chmod +x /tmp/ksud

# Download KernelSU kernel module for your KMI
curl -L -o /tmp/kernelsu.ko https://github.com/tiann/KernelSU/releases/download/v3.1.0/android15-6.6_kernelsu.ko

# Patch boot image
/tmp/ksud boot-patch -b boot.img -m kernelsu.ko --kmi android15-6.6 --magiskboot /tmp/magiskboot -o /tmp/
```

### Partition Sizes (from fastboot)
```
boot_a:      0x4000000  (64 MB)
init_boot_a: 0x800000   (8 MB)
vbmeta_a:    0x1000     (4 KB)
```

## Tools Available

| Tool | Location | Notes |
|---|---|---|
| ADB | `/home/brito/Android/Sdk/platform-tools/adb` | Standard Android Debug Bridge |
| fastboot | `/home/brito/Android/Sdk/platform-tools/fastboot` | Limited on MTK (no fetch, no boot) |
| mtkclient | `/tmp/mtk-venv/bin/python /tmp/mtkclient/mtk.py` | v2.1.2, **patched** for partial reads |
| Magisk APK | `root/Magisk.apk` | v28.1 |
| Magisk ZIP | `root/Magisk.zip` | v28.1 (renamed APK for sideload) |
| magiskboot | `/tmp/magiskboot` | Extracted from Magisk APK x86_64, statically linked |
| ksud | `/tmp/ksud` | KernelSU v3.1.0, x86_64 Linux (musl) |
| KernelSU APK | `/tmp/KernelSU.apk` | v3.1.0, manager app |
| KernelSU .ko | `/tmp/kernelsu.ko` | android15-6.6 kernel module, 243KB |
| GKI boot.img | `/tmp/gki_boot.img` | Unpatched, build ab13762941, 64MB |
| GKI boot-lz4 | `/tmp/gki_boot.img.lz4` | LZ4 variant, 51MB |
| Patched boot | `/tmp/kernelsu_patched_20260207_133853.img` | KernelSU-patched, 64MB |
| AOSP GSI | `root/aosp_arm64_gsi.zip` | Android 15 BP11.241210.004 |
| payload_dumper | `/tmp/mtk-venv/` | Python package in mtkclient venv |
| GPT raw dump | `/tmp/gpt_raw.bin` | 64KB GPT from UFS offset 0, parsed successfully |

## Current Device State (2026-02-07)

**WARNING**: Device is semi-bricked.
- **boot_a**: Contains incompatible Google CI GKI boot.img (NOT stock). Device cannot boot from slot A.
- **vbmeta_a**: Modified with `--disable-verity --disable-verification`
- **Slot B**: Should have original stock boot/kernel from factory (never modified)
- **Device behavior**: Enters MediaTek preloader download mode (USB `0e8d:2000`) on every boot
- **mtkclient**: Can connect, upload DA, read/write raw UFS offsets (one 64KB chunk per session)
- **Fastboot**: NOT accessible (device can't reach LK bootloader because boot.img is invalid)
- **Recovery plan**: Switch active slot from A to B by modifying misc partition A/B metadata

## Plan After Root

1. Install Magisk or KernelSU manager on the device
2. Use the root solution to permanently patch the boot chain
3. Verify root persists across reboots
4. Update `RadioManager.java` to use `su` for sysfs writes, or set SELinux to permissive
5. Re-deploy and test the IWI-Demo app with working radio control

## Remaining Approaches to Try (priority order)

1. **Switch to slot B via misc partition** (NEXT) — Read misc from raw offset `0x8000`, modify A/B metadata at +0x800, write back. This switches to slot B which has the stock boot kernel. Requires 3 mtkclient sessions (read misc, modify, write misc).
2. **Read boot_b and write to boot_a** — If slot switch doesn't work, read boot_b (offset `0x4E400000`) and write it to boot_a (offset `0x2AC00000`). Challenge: boot is 64MB, DA can only transfer 64KB per session = 1024 sessions needed. IMPRACTICAL.
3. **Contact HOTWAV support** (`support@hotwav.com`) — Request stock firmware to restore boot_a properly
4. **FOTA encryption reimplementation** — Write Python script implementing XOR cipher from `v1/f.java` to query `fota5p.adups.com` for firmware download
5. **mtkclient BROM via hardware** — Short test points on PCB to force BROM mode (device teardown)
6. **After recovery**: Extract stock boot_a via `dd` (if root available) or mtkclient, then patch with Magisk/KernelSU for root
