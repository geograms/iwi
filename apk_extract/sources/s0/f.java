package s0;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.util.Log;
import androidx.appcompat.widget.ActivityChooserView;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: k, reason: collision with root package name */
    public static volatile f f2525k;

    /* renamed from: a, reason: collision with root package name */
    public AudioTrack f2526a;

    /* renamed from: b, reason: collision with root package name */
    public long f2527b;

    /* renamed from: c, reason: collision with root package name */
    public long f2528c;

    /* renamed from: d, reason: collision with root package name */
    public long f2529d;

    /* renamed from: e, reason: collision with root package name */
    public long f2530e;

    /* renamed from: f, reason: collision with root package name */
    public AudioRecord f2531f;

    /* renamed from: g, reason: collision with root package name */
    public final LinkedBlockingQueue f2532g = new LinkedBlockingQueue(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);

    /* renamed from: h, reason: collision with root package name */
    public final StringBuilder f2533h = new StringBuilder();

    /* renamed from: i, reason: collision with root package name */
    public final LinkedList f2534i = new LinkedList();

    /* renamed from: j, reason: collision with root package name */
    public final Object f2535j = new Object();

    public f() throws IllegalStateException {
        b();
    }

    public static f a() {
        if (f2525k == null) {
            synchronized (f.class) {
                try {
                    if (f2525k == null) {
                        f2525k = new f();
                    }
                } finally {
                }
            }
        }
        return f2525k;
    }

    public final void b() throws IllegalStateException {
        boolean z2;
        if (this.f2526a != null) {
            return;
        }
        try {
            try {
                AudioRecord audioRecord = new AudioRecord(1, 8000, 16, 2, AudioRecord.getMinBufferSize(8000, 16, 2));
                this.f2531f = audioRecord;
                if (audioRecord.getState() == 1) {
                    this.f2531f.startRecording();
                    Log.d("PcmPlayer", "占用录音资源成功");
                }
                z2 = true;
            } catch (Exception e2) {
                Log.e("PcmPlayer", "占用音频资源失败", e2);
                z2 = false;
            }
            Log.d("PcmPlayer", "HZH initializeAudioTrack 173: " + z2);
            int iMax = Math.max(AudioTrack.getMinBufferSize(8000, 4, 2), 16384);
            AudioTrack audioTrack = new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(1).build(), new AudioFormat.Builder().setSampleRate(8000).setEncoding(2).setChannelMask(4).build(), iMax, 1, 0);
            this.f2526a = audioTrack;
            if (audioTrack.getState() != 1) {
                Log.e("PcmPlayer", "AudioTrack initialization failed");
                d();
            } else {
                Log.d("PcmPlayer", "AudioTrack initialized successfully with buffer size: " + iMax);
            }
        } catch (Exception e3) {
            Log.e("PcmPlayer", "Error initializing AudioTrack: " + e3.getMessage());
            d();
        }
    }

    public final void c(StringBuilder sb) throws IllegalStateException {
        AudioTrack audioTrack;
        byte[] bArr;
        try {
            try {
                Log.d("PcmPlayer", "HZH playPCMData 124: " + Thread.currentThread().getName());
                synchronized (this.f2535j) {
                    try {
                        if (this.f2526a == null) {
                            b();
                        }
                        String strSubstring = sb.substring(12, sb.length() - 2);
                        int length = strSubstring.length();
                        if ((length & 1) == 1) {
                            length++;
                            bArr = new byte[length / 2];
                            strSubstring = "0".concat(strSubstring);
                        } else {
                            bArr = new byte[length / 2];
                        }
                        int i2 = 0;
                        int i3 = 0;
                        while (i2 < length) {
                            int i4 = i2 + 2;
                            bArr[i3] = (byte) Integer.parseInt(strSubstring.substring(i2, i4), 16);
                            i3++;
                            i2 = i4;
                        }
                        int iWrite = this.f2526a.write(bArr, 0, bArr.length);
                        if (iWrite < 0) {
                            Log.e("PcmPlayer", "AudioTrack 写入失败: " + iWrite);
                        } else if (iWrite != 0) {
                            this.f2529d++;
                        }
                        Log.d("PcmPlayer", "HZH playPCMData 147: " + Thread.currentThread().getName());
                        this.f2526a.play();
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                audioTrack = this.f2526a;
                if (audioTrack == null) {
                    return;
                }
            } catch (Exception e2) {
                Log.d("PcmPlayer", "playPCMData error:" + e2.getMessage());
                audioTrack = this.f2526a;
                if (audioTrack == null) {
                    return;
                }
            }
            audioTrack.stop();
        } catch (Throwable th2) {
            AudioTrack audioTrack2 = this.f2526a;
            if (audioTrack2 != null) {
                audioTrack2.stop();
            }
            throw th2;
        }
    }

    public final void d() throws IllegalStateException {
        LinkedBlockingQueue linkedBlockingQueue = this.f2532g;
        if (linkedBlockingQueue != null) {
            linkedBlockingQueue.clear();
        }
        AudioRecord audioRecord = this.f2531f;
        if (audioRecord != null) {
            try {
                audioRecord.stop();
                this.f2531f.release();
            } catch (Exception e2) {
                Log.e("PcmPlayer", "释放AudioRecord失败", e2);
            }
            this.f2531f = null;
        }
        AudioTrack audioTrack = this.f2526a;
        if (audioTrack != null) {
            try {
                audioTrack.stop();
                this.f2526a.release();
            } catch (Exception e3) {
                Log.e("PcmPlayer", "释放AudioTrack失败", e3);
            }
            this.f2526a = null;
        }
    }
}
