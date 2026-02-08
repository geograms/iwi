# IWI Radio HTTP API

HTTP API for remote radio control. Server runs on port **6789** on the device.

All responses are `application/json` with CORS `Access-Control-Allow-Origin: *`.

## Radio Endpoints

### GET /radio/status
Get current radio state.

```bash
curl http://<ip>:6789/radio/status
```

Response:
```json
{
  "powered": true,
  "frequency_mhz": 144.8,
  "squelch": 0,
  "volume": 8,
  "firmware": "DMR003BN.UV4P.V016",
  "module_status": 1,
  "module_status_text": "idle"
}
```

### POST /radio/power/on
Power on the radio module.

```bash
curl -X POST http://<ip>:6789/radio/power/on \
  -d '{"frequency_mhz": 144.8, "squelch": 0}'
```

### POST /radio/power/off
Power off the radio module.

```bash
curl -X POST http://<ip>:6789/radio/power/off
```

### POST /radio/frequency
Change frequency (while powered).

```bash
curl -X POST http://<ip>:6789/radio/frequency \
  -d '{"frequency_mhz": 144.39}'
```

### POST /radio/squelch
Change squelch level (0-9, 0=open).

```bash
curl -X POST http://<ip>:6789/radio/squelch \
  -d '{"level": 0}'
```

### POST /radio/volume
Change speaker volume (0-15).

```bash
curl -X POST http://<ip>:6789/radio/volume \
  -d '{"level": 8}'
```

### POST /radio/ptt/on
Key PTT (start voice TX from mic).

```bash
curl -X POST http://<ip>:6789/radio/ptt/on
```

### POST /radio/ptt/off
Unkey PTT (stop voice TX).

```bash
curl -X POST http://<ip>:6789/radio/ptt/off
```

### POST /radio/tone
Send synthesized tone beep sequence over the air.

```bash
curl -X POST http://<ip>:6789/radio/tone \
  -d '{"count": 3, "tone_ms": 200, "gap_ms": 100}'
```

Blocks until the tone sequence completes.

### POST /radio/wav
Transmit a WAV audio file over the air. The WAV is decoded, converted to 8kHz
mono 16-bit (resampled if needed), and queued for transmission.

Goes through the same TX queue as APRS — gets auto power-on, frequency
management, and collision avoidance.

Supports: PCM WAV, 8/16-bit, mono/stereo, any sample rate (1-192kHz).
Max duration: 60 seconds. Max file size: 10 MB.

**Multipart form upload (recommended):**
```bash
curl -X POST http://<ip>:6789/radio/wav -F wav=@audio.wav

# With frequency switch:
curl -X POST http://<ip>:6789/radio/wav \
  -F wav=@audio.wav -F frequency_mhz=144.39
```

**Raw binary POST:**
```bash
curl -X POST http://<ip>:6789/radio/wav \
  --data-binary @audio.wav -H "Content-Type: audio/wav"

# With frequency (query param):
curl -X POST "http://<ip>:6789/radio/wav?frequency_mhz=144.39" \
  --data-binary @audio.wav -H "Content-Type: audio/wav"
```

Response:
```json
{
  "queued": true,
  "job_id": 3,
  "queue_size": 0,
  "type": "wav",
  "duration_ms": 2500,
  "original_sample_rate": 44100,
  "original_channels": 2,
  "original_bits": 16
}
```

**Generate test WAV files with ffmpeg/sox:**
```bash
# Generate 1kHz tone (2s, 8kHz mono, ready to send as-is)
sox -n -r 8000 -c 1 -b 16 tone.wav synth 2 sine 1000

# Convert any audio to radio-compatible format
ffmpeg -i input.mp3 -ar 8000 -ac 1 -acodec pcm_s16le output.wav
```

### GET /radio/log
Get recent serial/event log entries.

```bash
curl "http://<ip>:6789/radio/log?lines=50"
```

Response:
```json
{
  "lines": ["=== Power On ===", "ttyS0 opened fd=3", ...],
  "count": 50
}
```

## APRS Endpoints

APRS TX endpoints are **non-blocking** — they validate the request, build the packet,
place it on a TX queue, and return immediately. The queue worker handles:

1. **Auto power-on** — if the radio is off, it powers on automatically
2. **Frequency management** — switches to `frequency_mhz` if specified, restores after TX
3. **RX/TX collision avoidance** — waits for 500ms of channel silence before transmitting
4. **Serial TX** — PTT, audio frame pacing, PTT release

Queue capacity: 50 jobs. Jobs are processed FIFO, one at a time.

All APRS TX endpoints accept an optional `frequency_mhz` field:
- If specified, the radio switches to that frequency before TX (and restores after)
- If omitted, uses the current radio frequency
- If the radio is off, powers on at the specified frequency (or 144.8 MHz default)

### POST /aprs/message
Queue an APRS message packet for transmission.

```bash
curl -X POST http://<ip>:6789/aprs/message \
  -d '{"src_call":"N0CALL","src_ssid":7,"dest_call":"KO6JZI","message":"hello","msg_id":"001","frequency_mhz":144.39}'
```

Response:
```json
{"queued": true, "job_id": 1, "queue_size": 0, "type": "aprs_message"}
```

### POST /aprs/position
Queue an APRS position packet for transmission.

```bash
curl -X POST http://<ip>:6789/aprs/position \
  -d '{"src_call":"N0CALL","src_ssid":7,"lat":37.7749,"lon":-122.4194,"symbol_table":"/","symbol_code":"[","comment":"IWI test"}'
```

### POST /aprs/status
Queue an APRS status packet for transmission.

```bash
curl -X POST http://<ip>:6789/aprs/status \
  -d '{"src_call":"N0CALL","src_ssid":7,"status":"IWI Radio test"}'
```

### GET /aprs/queue
Check TX queue status.

```bash
curl http://<ip>:6789/aprs/queue
```

Response:
```json
{"queue_size": 2, "radio_powered": true, "module_status": "idle"}
```

### GET /aprs/received
Get received APRS packets.

```bash
# All received packets
curl http://<ip>:6789/aprs/received

# Only packets after a given timestamp (epoch millis)
curl "http://<ip>:6789/aprs/received?since=1707400000000"
```

Response:
```json
{
  "packets": [
    {
      "time": 1707400123456,
      "raw": "N0CALL-7>APZ001:>hello",
      "src_call": "N0CALL",
      "src_ssid": 7,
      "type": ">"
    }
  ],
  "count": 1
}
```

## Error Responses

All errors return:
```json
{"error": "description of the problem"}
```

Common HTTP status codes:
- `409 Conflict` — radio not in expected state (e.g., already powered on/off)
- `400 Bad Request` — invalid/missing JSON fields
- `404 Not Found` — unknown endpoint
- `500 Internal Server Error` — operation failed or timed out
- `503 Service Unavailable` — TX queue full

## Quick Start

```bash
# Get device IP
adb shell ip route | grep wlan0

# Check status (radio may be off — that's OK for APRS)
curl http://192.168.1.100:6789/radio/status

# Send APRS status (auto powers on if needed)
curl -X POST http://192.168.1.100:6789/aprs/status \
  -d '{"src_call":"N0CALL","src_ssid":7,"status":"IWI API test"}'

# Send APRS on specific frequency (switches, sends, restores)
curl -X POST http://192.168.1.100:6789/aprs/message \
  -d '{"src_call":"N0CALL","src_ssid":7,"dest_call":"KO6JZI","message":"hello","frequency_mhz":144.39}'

# Check queue status
curl http://192.168.1.100:6789/aprs/queue

# Check received packets
curl http://192.168.1.100:6789/aprs/received

# Manual power on/off still available
curl -X POST http://192.168.1.100:6789/radio/power/on \
  -d '{"frequency_mhz":144.8,"squelch":0}'
curl -X POST http://192.168.1.100:6789/radio/power/off
```
