#!/usr/bin/env python3
"""
Copy boot_b to boot_a via mtkclient DA session.
Reads boot_b in 64KB chunks (separate cmd_read_data calls to avoid USB overflow),
then writes the full image to boot_a in one shot (writes don't have the 64KB limit).
"""
import sys
import os
from struct import pack, unpack

# Add mtkclient to path
sys.path.insert(0, "/tmp/mtkclient")

from mtkclient.Library.mtk_class import Mtk
from mtkclient.Library.DA.xflash.xflash_lib import DAXFlash
from mtkclient.Library.DA.mtk_daloader import DAloader
from mtkclient.config.mtk_config import MtkConfig
from mtkclient.Library.DA.storage import DaStorage, EmmcPartitionType

# Partition offsets from GPT (4096-byte sectors)
BOOT_B_OFFSET = 0x4e400000
BOOT_A_OFFSET = 0x2ac00000
CHUNK_SIZE = 0x10000  # 64KB per read
TOTAL_READ = 0xDE0000  # ~14MB (kernel_size rounded up + header)

def main():
    print(f"[*] Will read {TOTAL_READ} bytes ({TOTAL_READ/1024/1024:.1f} MB) from boot_b")
    print(f"[*] Then write to boot_a at offset 0x{BOOT_A_OFFSET:x}")
    print(f"[*] Chunks: {TOTAL_READ // CHUNK_SIZE}")
    print()

    # Initialize mtkclient
    config = MtkConfig(loglevel="info")
    config.sectorsize = 4096
    mtk = Mtk(config=config)

    print("[*] Waiting for device... (connect now)")
    if not mtk.preloader.init():
        print("[!] Failed to init preloader")
        return False

    # Setup DA
    from mtkclient.Library.DA.mtk_da_handler import DaHandler
    da_handler = DaHandler(mtk, __loader__)
    mtk = da_handler.configure_da(mtk, os.path.dirname(os.path.realpath(__file__)))

    if not mtk.daloader:
        print("[!] Failed to load DA")
        return False

    da = mtk.daloader.da

    # Get storage info
    storage = DaStorage.MTK_DA_STORAGE_UFS
    parttype = EmmcPartitionType.MTK_DA_EMMC_PART_USER

    print(f"[*] Reading boot_b in {TOTAL_READ // CHUNK_SIZE} x 64KB chunks...")
    boot_data = bytearray()

    for i in range(TOTAL_READ // CHUNK_SIZE):
        offset = BOOT_B_OFFSET + (i * CHUNK_SIZE)

        # Issue a read command for just 64KB
        if not da.cmd_read_data(addr=offset, size=CHUNK_SIZE, storage=storage, parttype=parttype):
            print(f"[!] cmd_read_data failed at chunk {i} (offset 0x{offset:x})")
            break

        # Read the response
        chunk = bytearray()
        try:
            # Read header
            hdr = da.usbread(12, maxtimeout=5000)
            if len(hdr) != 12:
                print(f"[!] Short header at chunk {i}")
                break
            magic, _, slength = unpack("<III", hdr)
            if magic != 0xFEEEEEEF:
                print(f"[!] Bad magic at chunk {i}: 0x{magic:x}")
                break

            # Read data
            remaining = slength
            while remaining > 0:
                data = da.usbread(min(remaining, 0x10000))
                if not data:
                    raise IOError("USB read failed")
                chunk.extend(data)
                remaining -= len(data)

            if slength > 4:
                boot_data.extend(chunk)
                # Send acknowledgment
                ack = pack("<IIII", da.cmd.MAGIC, da.data_type.DT_PROTOCOL_FLOW, 4, 0)
                da.usbwrite(ack)
            elif slength == 4:
                flag = unpack("<I", chunk)[0]
                if flag != 0:
                    print(f"[!] Error status at chunk {i}")
                    break

            # Read final status for this cmd_read_data
            hdr2 = da.usbread(12, maxtimeout=5000)
            if len(hdr2) == 12:
                magic2, _, slength2 = unpack("<III", hdr2)
                if magic2 == 0xFEEEEEEF and slength2 == 4:
                    da.usbread(4)  # consume the status word

        except Exception as e:
            print(f"[!] Exception at chunk {i}: {e}")
            break

        pct = (i + 1) * 100 // (TOTAL_READ // CHUNK_SIZE)
        print(f"  [{pct:3d}%] Chunk {i+1}/{TOTAL_READ // CHUNK_SIZE} - read 0x{len(boot_data):x} bytes", end='\r')

    print()
    print(f"[*] Read {len(boot_data)} bytes ({len(boot_data)/1024/1024:.1f} MB) from boot_b")

    if len(boot_data) < 0x10000:
        print("[!] Read too little data, aborting")
        return False

    # Verify boot image header
    if boot_data[0:8] != b'ANDROID!':
        print("[!] Not a valid boot image!")
        return False

    kernel_size = unpack("<I", boot_data[8:12])[0]
    print(f"[*] Boot image verified: ANDROID! header, kernel={kernel_size} bytes")

    # Pad to full partition size (64MB) with zeros
    full_size = 0x4000000
    if len(boot_data) < full_size:
        boot_data.extend(b'\x00' * (full_size - len(boot_data)))

    # Save a copy
    save_path = "/tmp/boot_b_extracted.img"
    with open(save_path, 'wb') as f:
        f.write(boot_data)
    print(f"[*] Saved to {save_path}")

    # Now write to boot_a
    print(f"[*] Writing {len(boot_data)} bytes to boot_a at 0x{BOOT_A_OFFSET:x}...")
    result = da.writeflash(addr=BOOT_A_OFFSET, length=len(boot_data),
                           wdata=bytes(boot_data), parttype=parttype, display=True)

    if result:
        print("[+] boot_a written successfully!")
    else:
        print("[!] Failed to write boot_a")
        return False

    return True

if __name__ == "__main__":
    try:
        success = main()
        sys.exit(0 if success else 1)
    except KeyboardInterrupt:
        print("\n[!] Interrupted")
        sys.exit(1)
    except Exception as e:
        print(f"[!] Fatal error: {e}")
        import traceback
        traceback.print_exc()
        sys.exit(1)
