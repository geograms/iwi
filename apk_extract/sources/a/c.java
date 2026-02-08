package a;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;
import androidx.constraintlayout.solver.widgets.Optimizer;
import com.chamsion.quickchat.App;
import com.chamsion.quickchat.R;
import com.chamsion.quickchat.ui.ChatActivity;
import com.chamsion.quickchat.ui.MainActivity;
import com.wonder.dmr.DigitalVoiceReceptionInfo;
import com.wonder.dmr.DmrManager;
import com.wonder.dmr.OnAnalogCmdListener;
import com.wonder.dmr.OnDigitalCmdListener;
import com.wonder.dmr.OnDigitalVoiceReceptionInfoListener;
import com.wonder.dmr.OnEncryptionListener;
import com.wonder.dmr.OnEnhanceListener;
import com.wonder.dmr.OnEnhancementsListener;
import com.wonder.dmr.OnInitializationFinishlistener;
import com.wonder.dmr.OnLaunchCommandListener;
import com.wonder.dmr.OnMicGainListener;
import com.wonder.dmr.OnMonitorListener;
import com.wonder.dmr.OnPolicyListener;
import com.wonder.dmr.OnPowerOnListener;
import com.wonder.dmr.OnPowerSavingModeListener;
import com.wonder.dmr.OnRSSIListener;
import com.wonder.dmr.OnRelayOfflineListener;
import com.wonder.dmr.OnReportStatusListener;
import com.wonder.dmr.OnSmsListener;
import com.wonder.dmr.OnSmsProtocolTypeListener;
import com.wonder.dmr.OnSpkEnListener;
import com.wonder.dmr.OnSquelchListener;
import com.wonder.dmr.OnTextMessageListener;
import com.wonder.dmr.OnTotListener;
import com.wonder.dmr.OnTransferInterruptListener;
import com.wonder.dmr.OnUpgradeModeListener;
import com.wonder.dmr.OnVersionListener;
import com.wonder.dmr.OnVolumeListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import p0.o0;
import x0.g;

/* loaded from: classes.dex */
public final class c implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3b;

    public /* synthetic */ c(int i2, Object obj) {
        this.f2a = i2;
        this.f3b = obj;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i2 = this.f2a;
        Object obj = this.f3b;
        switch (i2) {
            case 0:
                int i3 = message.what;
                if (i3 == 288) {
                    OnUpgradeModeListener onUpgradeModeListener = ((DmrManager) obj).N;
                    if (onUpgradeModeListener != null) {
                        onUpgradeModeListener.OnCallback(message.arg1);
                        break;
                    }
                } else {
                    switch (i3) {
                        case 256:
                            OnLaunchCommandListener onLaunchCommandListener = ((DmrManager) obj).f1675q;
                            if (onLaunchCommandListener != null) {
                                onLaunchCommandListener.OnCallback(message.arg1);
                                break;
                            }
                            break;
                        case Optimizer.OPTIMIZATION_STANDARD /* 257 */:
                            OnInitializationFinishlistener onInitializationFinishlistener = ((DmrManager) obj).f1676r;
                            if (onInitializationFinishlistener != null) {
                                onInitializationFinishlistener.OnCallback(message.arg1);
                                break;
                            }
                            break;
                        case 258:
                            OnMicGainListener onMicGainListener = ((DmrManager) obj).f1679u;
                            if (onMicGainListener != null) {
                                onMicGainListener.OnCallback(message.arg1);
                                break;
                            }
                            break;
                        case 259:
                            OnDigitalVoiceReceptionInfoListener onDigitalVoiceReceptionInfoListener = ((DmrManager) obj).f1680v;
                            if (onDigitalVoiceReceptionInfoListener != null) {
                                onDigitalVoiceReceptionInfoListener.OnCallback(message.arg1, (DigitalVoiceReceptionInfo) message.obj);
                                break;
                            }
                            break;
                        case 260:
                            OnVolumeListener onVolumeListener = ((DmrManager) obj).f1683y;
                            if (onVolumeListener != null) {
                                onVolumeListener.OnCallback(message.arg1);
                                break;
                            }
                            break;
                        case 261:
                            OnEnhancementsListener onEnhancementsListener = ((DmrManager) obj).f1677s;
                            if (onEnhancementsListener != null) {
                                onEnhancementsListener.OnCallback(message.arg1);
                                break;
                            }
                            break;
                        case 262:
                            OnEnhanceListener onEnhanceListener = ((DmrManager) obj).L;
                            if (onEnhanceListener != null) {
                                onEnhanceListener.OnCallback_1(DmrManager.SUCCESS, message.arg1, message.arg2);
                                break;
                            }
                            break;
                        case 263:
                            OnEnhanceListener onEnhanceListener2 = ((DmrManager) obj).L;
                            if (onEnhanceListener2 != null) {
                                onEnhanceListener2.OnCallback_2(message.arg1);
                                break;
                            }
                            break;
                        case 264:
                            OnTextMessageListener onTextMessageListener = ((DmrManager) obj).f1681w;
                            if (onTextMessageListener != null) {
                                onTextMessageListener.OnCallback(message.arg1);
                                break;
                            }
                            break;
                        case 265:
                            OnEncryptionListener onEncryptionListener = ((DmrManager) obj).f1678t;
                            if (onEncryptionListener != null) {
                                onEncryptionListener.OnCallback(message.arg1);
                                break;
                            }
                            break;
                        case 266:
                            OnMonitorListener onMonitorListener = ((DmrManager) obj).f1684z;
                            if (onMonitorListener != null) {
                                onMonitorListener.OnCallback(message.arg1);
                                break;
                            }
                            break;
                        case 267:
                            OnSquelchListener onSquelchListener = ((DmrManager) obj).A;
                            if (onSquelchListener != null) {
                                onSquelchListener.OnCallback(message.arg1);
                                break;
                            }
                            break;
                        case 268:
                            OnPowerSavingModeListener onPowerSavingModeListener = ((DmrManager) obj).B;
                            if (onPowerSavingModeListener != null) {
                                onPowerSavingModeListener.OnCallback(message.arg1);
                                break;
                            }
                            break;
                        case 269:
                            OnRSSIListener onRSSIListener = ((DmrManager) obj).C;
                            if (onRSSIListener != null) {
                                onRSSIListener.OnCallback(message.arg1, message.arg2);
                                break;
                            }
                            break;
                        case 270:
                            OnRelayOfflineListener onRelayOfflineListener = ((DmrManager) obj).D;
                            if (onRelayOfflineListener != null) {
                                onRelayOfflineListener.OnCallback(message.arg1);
                                break;
                            }
                            break;
                        case 271:
                            OnVersionListener onVersionListener = ((DmrManager) obj).E;
                            if (onVersionListener != null) {
                                onVersionListener.OnCallback(message.arg1, (String) message.obj);
                                break;
                            }
                            break;
                        case 272:
                            OnTransferInterruptListener onTransferInterruptListener = ((DmrManager) obj).F;
                            if (onTransferInterruptListener != null) {
                                onTransferInterruptListener.OnCallback(message.arg1);
                                break;
                            }
                            break;
                        case 273:
                            OnReportStatusListener onReportStatusListener = ((DmrManager) obj).G;
                            if (onReportStatusListener != null) {
                                onReportStatusListener.OnCallback(message.arg1, message.arg2);
                                break;
                            }
                            break;
                        case 274:
                            OnPolicyListener onPolicyListener = ((DmrManager) obj).H;
                            if (onPolicyListener != null) {
                                onPolicyListener.OnCallback(message.arg1);
                                break;
                            }
                            break;
                        case 275:
                            int i4 = message.arg1;
                            int i5 = i4 & 255;
                            int i6 = (i4 >> 8) & 255;
                            int i7 = message.arg2;
                            String str = (String) message.obj;
                            OnSmsListener onSmsListener = ((DmrManager) obj).f1682x;
                            if (onSmsListener != null) {
                                onSmsListener.OnCallback(i6, i5, i7, str);
                                break;
                            }
                            break;
                        case 276:
                            OnAnalogCmdListener onAnalogCmdListener = ((DmrManager) obj).f1674p;
                            if (onAnalogCmdListener != null) {
                                onAnalogCmdListener.OnCallback(message.arg1);
                                break;
                            }
                            break;
                        case 277:
                            OnDigitalCmdListener onDigitalCmdListener = ((DmrManager) obj).f1673o;
                            if (onDigitalCmdListener != null) {
                                onDigitalCmdListener.OnCallback(message.arg1);
                                break;
                            }
                            break;
                        case 278:
                            DmrManager dmrManager = (DmrManager) obj;
                            Log.d(dmrManager.f1659a, "MSG_POWER_ON_STATE " + dmrManager.f1663e);
                            OnPowerOnListener onPowerOnListener = dmrManager.f1663e;
                            if (onPowerOnListener != null) {
                                onPowerOnListener.OnCallback();
                                break;
                            }
                            break;
                        case 279:
                            OnSmsProtocolTypeListener onSmsProtocolTypeListener = ((DmrManager) obj).I;
                            if (onSmsProtocolTypeListener != null) {
                                onSmsProtocolTypeListener.OnCallback(message.arg1);
                                break;
                            }
                            break;
                        case 280:
                            OnTotListener onTotListener = ((DmrManager) obj).J;
                            if (onTotListener != null) {
                                onTotListener.OnCallback(message.arg1);
                                break;
                            }
                            break;
                        case 281:
                            OnSpkEnListener onSpkEnListener = ((DmrManager) obj).K;
                            if (onSpkEnListener != null) {
                                onSpkEnListener.OnCallback(message.arg1);
                                break;
                            }
                            break;
                    }
                }
                break;
            case 1:
                if (message.what == 256) {
                    ((ChatActivity) obj).f1345j = true;
                    break;
                }
                break;
            default:
                int i8 = message.what;
                if (i8 == 0) {
                    MainActivity mainActivity = (MainActivity) obj;
                    if (mainActivity.f1422t != null) {
                        Log.d(mainActivity.f1403a, "初始化 MSG_DMR_POWERON,已上电，开始查看是否初始化。。");
                        o0.c cVar = mainActivity.f1422t;
                        b bVar = cVar.f2250d;
                        if (bVar != null) {
                            Message messageObtainMessage = bVar.obtainMessage();
                            messageObtainMessage.arg1 = 1;
                            messageObtainMessage.what = 256;
                            cVar.f2250d.sendMessageDelayed(messageObtainMessage, 50L);
                            break;
                        }
                    }
                } else if (i8 == 1) {
                    MainActivity mainActivity2 = (MainActivity) obj;
                    if (mainActivity2.f1422t != null && message.arg1 == 0) {
                        Log.d(mainActivity2.f1403a, "初始化 对讲机已启动,查询DMR版本号。");
                        o0.c cVar2 = mainActivity2.f1422t;
                        b bVar2 = cVar2.f2250d;
                        if (bVar2 != null) {
                            Message messageObtainMessage2 = bVar2.obtainMessage();
                            messageObtainMessage2.arg1 = 2;
                            messageObtainMessage2.what = 256;
                            cVar2.f2250d.sendMessageDelayed(messageObtainMessage2, 50L);
                            break;
                        }
                    }
                } else if (i8 == 2) {
                    if (message.arg1 == 0) {
                        MainActivity mainActivity3 = (MainActivity) obj;
                        g.m0(mainActivity3.f1410h, "version", (String) message.obj);
                        if (mainActivity3.f1413k != null) {
                            App.f1234c = true;
                            Log.d("MainActivity", "初始化 firstSetChannel设置信道 ");
                            o0 o0Var = mainActivity3.f1413k;
                            k0.a aVar = o0Var.f2391s;
                            if (aVar != null) {
                                o0Var.g(aVar, -1);
                                break;
                            }
                        }
                    }
                } else if (i8 == 3 && message.arg1 == 0) {
                    MainActivity mainActivity4 = (MainActivity) obj;
                    int i9 = mainActivity4.f1420r;
                    Toast.makeText(mainActivity4.f1410h, mainActivity4.getString(R.string.volume) + i9, 0).show();
                    Iterator it = mainActivity4.f1412j.iterator();
                    while (it.hasNext()) {
                        k0.a aVar2 = (k0.a) it.next();
                        Log.d(mainActivity4.f1403a, "初始化 MSG_DMR_VOLUME,DMR版本号查询完成，开始配置参数。。");
                        aVar2.f1948l = (byte) mainActivity4.f1420r;
                        mainActivity4.f1411i.a(aVar2);
                    }
                    break;
                }
                break;
        }
        return false;
    }
}
