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

See [transceiver.md](transceiver.md) for full serial protocol documentation (frame format, command table, frequency encoding, CRC, status codes, GPIO control, audio path, TX/RX transitions, and resolved issues).

### Sysfs Control Pattern
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

## LogCallback Pattern
Pass log messages from background threads to UI:
```java
public interface LogCallback { void onLog(String message); }
// In Activity: radio.setLogCallback(msg -> runOnUiThread(() -> tvLog.append(msg + "\n")));
```
Used by: `RadioManager` → `MainActivity`

## Power On/Off & PTT Sequences
See [transceiver.md](transceiver.md) — sections "Power-On Sequence", "Power-Off Sequence", and "TX/RX Transitions".

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

## APRS / AX.25 Patterns

Self-contained APRS over Bell 202 AFSK, optimized for 8kHz/16-bit/mono PCM.
See: `iwi-demo/…/AX25.java`, `iwi-demo/…/APRS.java`

### CRC-CCITT (AX.25)
Bit-by-bit CRC with polynomial 0x8408 (reflected), init 0xFFFF, final XOR 0xFFFF:
```java
int crc = AX25.crcCcitt(data, 0, data.length);
// Append as little-endian: low byte first, high byte second
// Residue after including FCS in CRC: 0x0F47 (0xF0B8 ^ 0xFFFF)
```
Reusable for any CRC-CCITT application (X.25, HDLC, PPP).

### AFSK Modulation (Bell 202)
Generate 1200-baud AFSK audio (mark=1200Hz, space=2200Hz) from a boolean tone sequence:
```java
short[] pcm = AX25.modulateAfsk(tones); // true=mark, false=space
// Continuous-phase sine, fractional sample accumulator for non-integer samples/bit
```
Works at 8kHz (~6.67 samples/bit). Reusable for any Bell 202 application.

### AFSK Demodulation
Streaming correlation-based demodulator with PLL bit clock recovery:
```java
AX25.Demodulator demod = new AX25.Demodulator(frame -> {
    AX25.ParsedFrame pf = AX25.parseFrame(frame);
    // process decoded frame
});
demod.addSamples(pcmChunk, count); // feed any chunk size
```

### APRS Coordinate Encoding
Convert decimal degrees to APRS format:
```java
String lat = APRS.encodeLatitude(38.0266);   // "3801.60N"
String lon = APRS.encodeLongitude(-122.1247); // "12207.48W"
double lat2 = APRS.parseLatitude("3801.60N"); // 38.0267
```

### APRS Packet Building (one-liner TX)
```java
// Position packet → PCM audio, ready to send over serial
short[] pcm = APRS.modulatePositionPacket("N0CALL", 7, lat, lon, '/', '[', "comment");
// Message packet
short[] pcm = APRS.modulateMessagePacket("N0CALL", 7, "W1AW", "Hello!", "001");
```

### APRS RX (streaming)
```java
AX25.Demodulator demod = APRS.createDemodulator(packet -> {
    // packet.srcCall, packet.lat, packet.lon, packet.message, etc.
});
demod.addSamples(pcm, count); // feed from AudioReceiver
```

### HDLC Framing
Reusable HDLC encode (bit stuffing + flags) and NRZI encode:
```java
boolean[] hdlc = AX25.hdlcEncode(frameWithCrc, preambleFlags, trailerFlags);
boolean[] nrzi = AX25.nrziEncode(hdlc); // 0=toggle, 1=no change
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
| AX.25 layer | `./iwi-demo/app/src/main/java/com/geograms/iwi/AX25.java` |
| APRS layer | `./iwi-demo/app/src/main/java/com/geograms/iwi/APRS.java` |
| Demo APK output | `./iwi-demo/app/build/outputs/apk/debug/app-debug.apk` |
