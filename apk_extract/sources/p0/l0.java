package p0;

import android.util.Log;
import com.wonder.dmr.OnTransferInterruptListener;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import me.f1reking.serialportlib.listener.IOpenSerialPortListener;
import me.f1reking.serialportlib.listener.ISerialPortDataListener;
import me.f1reking.serialportlib.listener.Status;

/* loaded from: classes.dex */
public final class l0 implements OnTransferInterruptListener, IOpenSerialPortListener, ISerialPortDataListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o0 f2363a;

    public /* synthetic */ l0(o0 o0Var) {
        this.f2363a = o0Var;
    }

    @Override // com.wonder.dmr.OnTransferInterruptListener
    public final void OnCallback(int i2) {
        o0 o0Var = this.f2363a;
        if (i2 != 0) {
            if (i2 == 1) {
                o0Var.f2372a0 = 0;
                return;
            } else {
                if (i2 == 2) {
                    o0Var.f2372a0 = 0;
                    return;
                }
                return;
            }
        }
        Log.d(o0Var.f2378g, "sendCommandInterrupt  , = 发送中断指令成功");
        String str = " setPttLaunchDirect  , 1 =  mState = " + o0Var.f2372a0;
        String str2 = o0Var.f2378g;
        Log.d(str2, str);
        if (o0Var.f2372a0 != 1) {
            return;
        }
        if (!o0Var.f2373b0) {
            o0Var.r();
            o0Var.f2372a0 = 0;
            Log.d(str2, " setPttLaunchDirect  , 3  =  mState = " + o0Var.f2372a0);
            return;
        }
        Log.d(str2, " setPttLaunch  , 设置对讲机为发射状态；");
        a.b bVar = o0Var.f2375d0;
        if (bVar != null) {
            bVar.removeMessages(259);
            o0Var.f2375d0.sendEmptyMessageDelayed(259, 0L);
        }
        o0Var.f2372a0 = 2;
        Log.d(str2, " setPttLaunchDirect  , 2  =  mState = " + o0Var.f2372a0);
    }

    @Override // me.f1reking.serialportlib.listener.ISerialPortDataListener
    public final void onDataReceived(byte[] bArr) {
        int iLastIndexOf;
        s0.f fVarA = s0.f.a();
        StringBuilder sb = fVarA.f2533h;
        try {
            fVarA.f2527b++;
            String strM = x0.g.m(bArr);
            if (!strM.startsWith("68") || !strM.endsWith("10")) {
                if (bArr.length == 167) {
                    fVarA.f2528c++;
                    String[] strArrSplit = strM.split(",");
                    LinkedBlockingQueue linkedBlockingQueue = fVarA.f2532g;
                    linkedBlockingQueue.addAll(Arrays.asList(strArrSplit));
                    sb.setLength(0);
                    while (!linkedBlockingQueue.isEmpty()) {
                        String str = (String) linkedBlockingQueue.poll();
                        if (str == null) {
                            Log.d("PcmPlayer", "pcmPackageItem data is null !!!");
                            return;
                        }
                        sb.append(str);
                        if (sb.toString().startsWith("BB00") && sb.toString().endsWith("44") && sb.length() == 334) {
                            fVarA.c(sb);
                            sb.setLength(0);
                        } else if (sb.length() > 334 && sb.toString().endsWith("bb") && (iLastIndexOf = fVarA.f2534i.lastIndexOf("BB00")) > -1) {
                            String strSubstring = sb.substring(iLastIndexOf);
                            if (strSubstring.startsWith("BB00") && strSubstring.endsWith("44") && strSubstring.length() == 334) {
                                fVarA.c(sb);
                                sb.setLength(0);
                            }
                        }
                    }
                    Log.d("AudioTrackManager", "HZH 收到数据 " + fVarA.f2527b + "   有效数据   " + fVarA.f2528c + "   无效数据   " + fVarA.f2530e + "  写播放的数据  " + fVarA.f2529d);
                    return;
                }
            }
            fVarA.f2530e++;
        } catch (Exception e2) {
            Log.e("PcmPlayer", "Error processing single PCM data: " + e2.getMessage(), e2);
            fVarA.f2530e = fVarA.f2530e + 1;
        }
    }

    @Override // me.f1reking.serialportlib.listener.ISerialPortDataListener
    public final void onDataSend(byte[] bArr) {
    }

    @Override // me.f1reking.serialportlib.listener.IOpenSerialPortListener
    public final void onFail(File file, Status status) {
        o0 o0Var = this.f2363a;
        Log.i(o0Var.f2378g, "onFail: PCM /dev/ttyS1 Fail:" + status);
        if (n0.f2368a[status.ordinal()] != 1) {
            Log.i(o0Var.f2378g, "onFail: PCM /dev/ttyS1 open fail !!!");
        } else {
            Log.i(o0Var.f2378g, "onFail: PCM /dev/ttyS1 no permission");
        }
    }

    @Override // me.f1reking.serialportlib.listener.IOpenSerialPortListener
    public final void onSuccess(File file) {
        Log.i(this.f2363a.f2378g, "hzh init /dev/ttyS1 open success!");
    }
}
