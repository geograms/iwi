# Reusable Code & Patterns — InterPhone Project

## Tools & Commands

### ADB access
```bash
# ADB is not in PATH, use full path:
/home/brito/Android/Sdk/platform-tools/adb

# Target device (InterPhone hardware):
/home/brito/Android/Sdk/platform-tools/adb -s Hyper8Ultra0000957 <command>

# Pull APK from device:
/home/brito/Android/Sdk/platform-tools/adb -s Hyper8Ultra0000957 pull /system/app/QuickChat/QuickChat.apk .
```

### jadx decompilation
```bash
# jadx installed at:
/home/brito/dev/jadx/bin/jadx

# Decompile APK (classes only, limit memory to 1GB):
JVM_OPTS="-Xmx1g" /home/brito/dev/jadx/bin/jadx -d ./apk_extract ./QuickChat.apk --no-res
```

## Serial Protocol Patterns

### Command frame builder pattern
All serial commands follow the same frame structure — reusable for building new commands:
```
Header: 0x68
CMD ID: 1 byte
Fixed:  0x01 0x01
CRC:    2 bytes (computed by CRC.checkSumBytes)
Length: 2 bytes (payload length, big-endian)
Data:   N bytes
Footer: 0x10
```

### Frequency encoding
Frequencies are encoded as 4-byte little-endian integers (Hz):
```java
bArr[offset]     = (byte) (freq & 0xFF);
bArr[offset + 1] = (byte) ((freq >> 8) & 0xFF);
bArr[offset + 2] = (byte) ((freq >> 16) & 0xFF);
bArr[offset + 3] = (byte) ((freq >> 24) & 0xFF);
```

### DMR ID encoding
DMR IDs (local ID, contact ID) use the same 4-byte little-endian pattern as frequencies.

### CRC utilities
Two CRC functions available in `com.wonder.dmr.utils.CRC`:
- `CRC.checkSumBytes(byte[] data, int len)` — frame checksum
- `CRC.calculateCRC16XMODEM(byte[] data)` — CRC16-XMODEM for firmware update packets

### Response status codes
```
0 = SUCCESS
1 = FAIL
2 = CHECKSUM_ERROR
-1 = ERROR (serial not ready)
```

## Sysfs Control Pattern
Write ASCII '1' or '0' + newline via FileOutputStream:
```java
FileOutputStream fos = new FileOutputStream(path);
byte[] data = { (byte)(on ? '1' : '0'), '\n' };
fos.write(data);
fos.close();
```
Used by: `iwi-demo/…/RadioManager.java`

## Serial Read Thread Pattern
Continuously read 64-byte chunks from serial port, parse responses:
```java
// Read thread (daemon) — loops while running
byte[] buf = new byte[64];
int bytesRead = serialPort.readData(fd, buf);
if (bytesRead > 0) {
    byte[] data = Arrays.copyOf(buf, bytesRead);
    handleResponse(data);
}
```
Used by: `iwi-demo/…/RadioManager.java` (inner class `SerialReadThread`)

## Response ACK Pattern (CountDownLatch)
Wait for module ACK before proceeding to next command:
```java
CountDownLatch latch = new CountDownLatch(1);
sendCommand(cmd);
if (!latch.await(2000, TimeUnit.MILLISECONDS)) {
    // timeout — module did not respond
}
// In handleResponse(): latch.countDown() when matching response arrives
```
Used by: `RadioManager.powerOn()` for init (CMD 0x27) and channel (CMD 0x23) ACKs.

## Response Parsing Pattern
Response format: `[header, cmd, ?, status, CRC_hi, CRC_lo, len_hi, len_lo, ...payload..., footer]`
```java
byte cmdId = data[1];    // command ID echo
byte status = data[3];   // 0=SUCCESS, 1=FAIL, 2=CRC_ERROR
int payloadLen = ((data[6] & 0xFF) << 8) | (data[7] & 0xFF);
byte[] payload = Arrays.copyOfRange(data, 8, 8 + payloadLen);
```
Used by: `RadioManager.handleResponse()`

## LogCallback Pattern
Pass log messages from background threads to UI:
```java
public interface LogCallback { void onLog(String message); }
// In Activity: radio.setLogCallback(msg -> runOnUiThread(() -> tvLog.append(msg + "\n")));
```
Used by: `RadioManager` → `MainActivity`

## Power On/Off Sequence
1. Write `0` to all sysfs (power, pwd, ptt)
2. Wait 200ms
3. Open serial `/dev/ttyS0` at 57600
4. Start serial read thread
5. Wait 100ms, write `1` to all sysfs
6. Wait 500ms for module boot
7. Send `checkInitComplete` (CMD 0x27) → wait for ACK (up to 2s)
8. Send `getVersion` (CMD 0x34) — informational
9. Send `setAnalogCmd` (CMD 0x23) with frequency → wait for ACK (up to 2s)
10. `AudioManager.setParameters("pdt_play=on")`

Power off: pdt_play=off, pdt_mic=off, stop read thread, sysfs all to 0, close serial.

## PTT Sequence
**Press**: sysfs ptt=1 → pdt_mic=on → launchCommand(1) (CMD 0x26)
**Release**: launchCommand(0) → pdt_mic=off → sysfs ptt=0 → pdt_play=on

## SerialPort JNI Wrapper
Reusable JNI wrapper for `libwonder_serialport.so`:
```java
// Load: System.loadLibrary("wonder_serialport");
// Methods: open(port, baudrate), close(fd), readData(fd, buf), writeData(fd, buf)
```
See: `iwi-demo/…/SerialPort.java`

## mtkclient raw offset read/write

Bypasses partition table (which hangs on this device). Each session requires a fresh USB connection (disconnect USB + hold power 15-20s).

```bash
# Read 64KB from raw UFS offset
/tmp/mtk-venv/bin/python /tmp/mtkclient/mtk.py ro <offset_hex> <length_hex> <output_file> --sectorsize 4096

# Write at raw UFS offset
/tmp/mtk-venv/bin/python /tmp/mtkclient/mtk.py wo <offset_hex> <length_hex> <input_file> --sectorsize 4096

# Known offsets:
# misc partition: 0x8000 (length 0x10000 = 64KB)
# A/B slot metadata at misc offset 0x800
```

Patches required: see `root/mtkclient_patches/SETUP.md`

## fastboot GSI flash sequence

For flashing Generic System Images on devices with dynamic (super) partitions:

```bash
# Enter userspace fastboot (required for dynamic partitions)
fastboot reboot fastboot

# Disable vbmeta verification
fastboot flash vbmeta_<slot> vbmeta.img

# Free space in super by deleting product
fastboot delete-logical-partition product_<slot>

# Flash GSI
fastboot flash system <gsi_image>.img

# Factory reset (required for new system)
fastboot -w

# Reboot
fastboot reboot
```

## File Locations

| Item | Path |
|---|---|
| Original APK | `./QuickChat.apk` |
| Backup APK | `./backup/QuickChat.apk` |
| Decompiled sources | `./apk_extract/sources/` |
| App classes | `./apk_extract/sources/com/chamsion/quickchat/` |
| DMR library | `./apk_extract/sources/com/wonder/dmr/` |
| Serial library | `./apk_extract/sources/com/wonder/serial/` |
| SerialPortLib | `./apk_extract/sources/me/f1reking/serialportlib/` |
| Native .so files | Inside APK at `lib/<arch>/` |
| IWI Demo app | `./iwi-demo/` |
| Demo APK output | `./iwi-demo/app/build/outputs/apk/debug/app-debug.apk` |
