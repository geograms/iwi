from queue import Queue
def writedata(filename, rq: Queue):
    """
    Writer thread: writes each block to disk incrementally and flushes
    after each write so that partial data survives if a subsequent
    USB read fails.
    """
    try:
        with open(filename, "wb") as wf:
            while True:
                block = rq.get(timeout=300)
                if block is None:
                    break
                try:
                    wf.write(block)
                    wf.flush()
                except Exception as e:
                    print(f"Write error: {e}")
                    break
    except Exception as e:
        print(f"Writer thread exception: {e}")
