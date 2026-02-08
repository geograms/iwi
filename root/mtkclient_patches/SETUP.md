# Reinstall mtkclient (if /tmp is lost)

```bash
# Clone mtkclient
cd /tmp && git clone https://github.com/bkerler/mtkclient.git

# Create venv and install
python3 -m venv /tmp/mtk-venv
/tmp/mtk-venv/bin/pip install /tmp/mtkclient

# Apply patches (copy these files over the originals)
cp thread_handling.py /tmp/mtkclient/mtkclient/Library/thread_handling.py
cp xflash_lib.py /tmp/mtkclient/mtkclient/Library/DA/xflash/xflash_lib.py
cp storage.py /tmp/mtkclient/mtkclient/Library/DA/storage.py
```

## Usage for raw offset read/write (bypasses partition hang)
```bash
# Read 64KB from raw UFS offset (requires fresh USB connection each time)
/tmp/mtk-venv/bin/python /tmp/mtkclient/mtk.py ro <offset_hex> <length_hex> <output_file> --sectorsize 4096

# Write at raw UFS offset
/tmp/mtk-venv/bin/python /tmp/mtkclient/mtk.py wo <offset_hex> <length_hex> <input_file> --sectorsize 4096
```
