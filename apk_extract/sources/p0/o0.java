package p0;

import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioAttributes;
import android.media.AudioRecord;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.lifecycle.ViewModelProvider;
import com.chamsion.quickchat.App;
import com.chamsion.quickchat.R;
import com.chamsion.quickchat.ui.MainActivity;
import com.chamsion.quickchat.widget.CircleProgressDrawable;
import com.wonder.dmr.AnalogCommand;
import com.wonder.dmr.DigitalCommand;
import com.wonder.dmr.DmrManager;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import me.f1reking.serialportlib.SerialPortHelper;
import me.f1reking.serialportlib.entity.BAUDRATE;
import me.f1reking.serialportlib.entity.DATAB;
import me.f1reking.serialportlib.entity.FLOWCON;
import me.f1reking.serialportlib.entity.PARITY;
import me.f1reking.serialportlib.entity.STOPB;

/* loaded from: classes.dex */
public class o0 extends j0.b {

    /* renamed from: h0, reason: collision with root package name */
    public static final int[] f2371h0 = {R.drawable.num0, R.drawable.num1, R.drawable.num2, R.drawable.num3, R.drawable.num4, R.drawable.num5, R.drawable.num6, R.drawable.num7, R.drawable.num8, R.drawable.num9};
    public int A;
    public AudioRecord B;
    public SerialPortHelper F;
    public SoundPool H;
    public int I;
    public boolean J;
    public n0.p K;
    public String[] L;
    public String[] M;
    public String N;
    public String O;
    public String P;
    public String Q;
    public String R;
    public String S;
    public String T;
    public String U;
    public String V;
    public ProgressDialog X;

    /* renamed from: g0, reason: collision with root package name */
    public s0.b f2379g0;

    /* renamed from: h, reason: collision with root package name */
    public androidx.fragment.app.c0 f2380h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2381i;

    /* renamed from: j, reason: collision with root package name */
    public ImageView f2382j;

    /* renamed from: k, reason: collision with root package name */
    public ImageView f2383k;

    /* renamed from: l, reason: collision with root package name */
    public ImageView f2384l;

    /* renamed from: m, reason: collision with root package name */
    public ImageView f2385m;

    /* renamed from: n, reason: collision with root package name */
    public TextView f2386n;

    /* renamed from: o, reason: collision with root package name */
    public TextView f2387o;

    /* renamed from: p, reason: collision with root package name */
    public ImageView f2388p;

    /* renamed from: q, reason: collision with root package name */
    public ImageView f2389q;

    /* renamed from: r, reason: collision with root package name */
    public k0.t f2390r;

    /* renamed from: s, reason: collision with root package name */
    public k0.a f2391s;

    /* renamed from: v, reason: collision with root package name */
    public Button f2394v;

    /* renamed from: w, reason: collision with root package name */
    public Button f2395w;

    /* renamed from: x, reason: collision with root package name */
    public CircleProgressDrawable f2396x;

    /* renamed from: y, reason: collision with root package name */
    public m0 f2397y;

    /* renamed from: g, reason: collision with root package name */
    public final String f2378g = o0.class.getName();

    /* renamed from: t, reason: collision with root package name */
    public int f2392t = 0;

    /* renamed from: u, reason: collision with root package name */
    public final ArrayList f2393u = new ArrayList();

    /* renamed from: z, reason: collision with root package name */
    public boolean f2398z = true;
    public final LinkedBlockingQueue C = new LinkedBlockingQueue();
    public final LinkedList D = new LinkedList();
    public long E = 0;
    public int G = -1;
    public boolean W = false;
    public final k0.y Y = new k0.y(6, this);
    public long Z = 0;

    /* renamed from: a0, reason: collision with root package name */
    public int f2372a0 = 0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f2373b0 = false;

    /* renamed from: c0, reason: collision with root package name */
    public long f2374c0 = 0;

    /* renamed from: d0, reason: collision with root package name */
    public a.b f2375d0 = null;

    /* renamed from: e0, reason: collision with root package name */
    public HandlerThread f2376e0 = null;

    /* renamed from: f0, reason: collision with root package name */
    public long f2377f0 = 0;

    public static void f(o0 o0Var, boolean z2) {
        o0Var.getClass();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("/sys/devices/platform/intercom/intercom_ptt_control");
            byte[] bArr = new byte[2];
            bArr[0] = (byte) (z2 ? 49 : 48);
            bArr[1] = 10;
            fileOutputStream.write(bArr);
            fileOutputStream.close();
        } catch (Exception e2) {
            Log.d(o0Var.f2378g, "Exception:" + e2.getMessage());
            e2.printStackTrace();
        }
    }

    @Override // j0.b
    public final void e() {
        if (!this.f1895a || this.f2381i) {
            return;
        }
        final int i2 = 1;
        this.f2381i = true;
        String str = this.f2378g;
        Log.d(str, "init .... ");
        HandlerThread handlerThread = new HandlerThread("work-handlerthread");
        this.f2376e0 = handlerThread;
        handlerThread.start();
        this.f2375d0 = new a.b(this, this.f2376e0.getLooper(), 4);
        if (this.f2379g0 == null) {
            this.f2379g0 = new s0.b(getContext());
        }
        final int i3 = 0;
        this.f2392t = ((Integer) x0.g.J(this.f2380h, "index", 0)).intValue();
        Log.i(str, "/dev/ttyS1 initPcmSerialPort");
        SerialPortHelper serialPortHelper = this.F;
        if (serialPortHelper == null || !serialPortHelper.isOpen()) {
            SerialPortHelper serialPortHelper2 = new SerialPortHelper();
            this.F = serialPortHelper2;
            serialPortHelper2.setPort("/dev/ttyS1");
            this.F.setBaudRate(BAUDRATE.getBaudrate(BAUDRATE.B230400));
            this.F.setStopBits(STOPB.getStopBit(STOPB.B1));
            this.F.setDataBits(DATAB.getDataBit(DATAB.CS8));
            this.F.setParity(PARITY.getParity(PARITY.NONE));
            this.F.setFlowCon(FLOWCON.getFlowCon(FLOWCON.NONE));
            this.F.setIOpenSerialPortListener(new l0(this));
            this.F.setISerialPortDataListener(new l0(this));
            this.F.open();
        } else {
            Log.e(str, "run: PCM /dev/ttyS1 already open!");
        }
        this.f2382j.setOnTouchListener(new View.OnTouchListener(this) { // from class: p0.k0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ o0 f2358b;

            {
                this.f2358b = this;
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                int i4 = i3;
                o0 o0Var = this.f2358b;
                switch (i4) {
                    case 0:
                        int[] iArr = o0.f2371h0;
                        o0Var.getClass();
                        if (motionEvent.getAction() == 1) {
                            o0Var.n();
                            break;
                        }
                        break;
                    default:
                        int[] iArr2 = o0.f2371h0;
                        o0Var.getClass();
                        int action = motionEvent.getAction();
                        if ((action != 1 && action != 3) || !o0Var.W) {
                            break;
                        } else {
                            o0Var.n();
                            o0Var.W = false;
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        this.f2382j.setOnLongClickListener(new n0.b(i2, this));
        this.f2382j.setOnTouchListener(new View.OnTouchListener(this) { // from class: p0.k0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ o0 f2358b;

            {
                this.f2358b = this;
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                int i4 = i2;
                o0 o0Var = this.f2358b;
                switch (i4) {
                    case 0:
                        int[] iArr = o0.f2371h0;
                        o0Var.getClass();
                        if (motionEvent.getAction() == 1) {
                            o0Var.n();
                            break;
                        }
                        break;
                    default:
                        int[] iArr2 = o0.f2371h0;
                        o0Var.getClass();
                        int action = motionEvent.getAction();
                        if ((action != 1 && action != 3) || !o0Var.W) {
                            break;
                        } else {
                            o0Var.n();
                            o0Var.W = false;
                            break;
                        }
                        break;
                }
                return false;
            }
        });
        ImageView imageView = this.f2383k;
        k0.y yVar = this.Y;
        imageView.setOnClickListener(yVar);
        this.f2385m.setOnClickListener(yVar);
        this.f2384l.setOnClickListener(yVar);
        this.f2394v.setOnClickListener(yVar);
        this.f2395w.setOnClickListener(yVar);
    }

    public final void g(k0.a aVar, int i2) {
        int[] iArr;
        if (!App.f1234c) {
            Log.d("FragmentPtt", " 初始化 模块未初始化完成 500ms后再试 : " + System.currentTimeMillis());
            this.f2375d0.removeMessages(256);
            this.f2375d0.sendEmptyMessageDelayed(256, 500L);
            return;
        }
        if (System.currentTimeMillis() - this.f2374c0 < 1000) {
            Log.d("FragmentPtt", "初始化 两次Config 间隔太短 return: ");
            return;
        }
        this.f2374c0 = System.currentTimeMillis();
        if (aVar == null) {
            return;
        }
        Log.d("FragmentPtt", " 初始化 模块初始化完成 配置信道: " + System.currentTimeMillis());
        int i3 = aVar.f1941e;
        int i4 = 1;
        int i5 = 0;
        if (i3 == 1) {
            AnalogCommand analogCommand = new AnalogCommand();
            analogCommand.setRx_freq(aVar.f1944h);
            analogCommand.setTx_freq(aVar.f1945i);
            analogCommand.setBand((byte) aVar.f1961y);
            analogCommand.setPower((byte) aVar.f1946j);
            analogCommand.setSq((byte) aVar.f1962z);
            analogCommand.setRx_type((byte) aVar.A);
            analogCommand.setRx_subcode((byte) aVar.B);
            analogCommand.setTx_type((byte) aVar.C);
            analogCommand.setTx_subcode((byte) aVar.D);
            analogCommand.setPwrsave((byte) aVar.f1947k);
            analogCommand.setMonitor((byte) aVar.E);
            analogCommand.setRelay((byte) aVar.f1949m);
            DmrManager.getInstance().setAnalogCmd(analogCommand, new g0(this, i2, aVar, i5));
            return;
        }
        if (i3 == 0) {
            DigitalCommand digitalCommand = new DigitalCommand();
            digitalCommand.setRx_freq(aVar.f1944h);
            digitalCommand.setTx_freq(aVar.f1945i);
            digitalCommand.setLocalId(aVar.f1950n);
            String str = aVar.f1951o;
            if (str == null) {
                iArr = new int[32];
            } else {
                String[] strArrSplit = str.split("-");
                int[] iArr2 = new int[strArrSplit.length];
                while (i5 < strArrSplit.length) {
                    iArr2[i5] = Integer.parseInt(strArrSplit[i5]);
                    i5++;
                }
                Log.d(this.f2378g, strArrSplit.length + " , getGroupList =" + strArrSplit);
                iArr = iArr2;
            }
            digitalCommand.setGroupList(iArr);
            digitalCommand.setTx_contact(aVar.f1952p);
            digitalCommand.setContactType((byte) aVar.f1953q);
            digitalCommand.setPower((byte) aVar.f1946j);
            digitalCommand.setCc((byte) aVar.f1954r);
            digitalCommand.setInboundSlot((byte) aVar.f1955s);
            digitalCommand.setOutboundSlot((byte) aVar.f1956t);
            digitalCommand.setChannelMode((byte) aVar.f1957u);
            digitalCommand.setEncryptSw((byte) aVar.f1958v);
            digitalCommand.setEncryptKey(aVar.f1959w.getBytes());
            digitalCommand.setPwrsave((byte) aVar.f1947k);
            digitalCommand.setMic((byte) aVar.f1960x);
            digitalCommand.setRelay((byte) aVar.f1949m);
            DmrManager.getInstance().setDigitalCmd(digitalCommand, new g0(this, i2, aVar, i4));
        }
    }

    public final void h(androidx.fragment.app.c0 c0Var) {
        if (c0Var instanceof MainActivity) {
            ((MainActivity) c0Var).getClass();
        }
        ProgressDialog progressDialog = this.X;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        if (this.X != null) {
            new Handler(Looper.getMainLooper()).postDelayed(new h0(this, 3), 2000L);
        }
    }

    public final int i() {
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        arrayList.addAll(this.f2393u);
        for (int size = arrayList.size(); size > 0; size--) {
            int i2 = size - 1;
            if (((k0.a) arrayList.get(i2)).f1941e == 1) {
                arrayList.remove(i2);
            }
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (this.f2391s.equals(arrayList.get(i3))) {
                return i3;
            }
        }
        return -1;
    }

    public final void j() {
        String str = " handlePttRelease  , 1 =  mIsPressed = " + this.f2373b0;
        String str2 = this.f2378g;
        Log.d(str2, str);
        if (this.f2373b0) {
            Log.d(str2, " handlePttRelease  ,2 =  mState = " + this.f2372a0);
            this.f2373b0 = false;
            if (this.f2372a0 == 2) {
                r();
                this.f2372a0 = 0;
                Log.d(str2, " handlePttRelease  恢复状态为空闲,3 =  mState = " + this.f2372a0);
            }
        }
    }

    public final void k() {
        this.L = this.f2380h.getResources().getStringArray(R.array.channel_type);
        this.M = this.f2380h.getResources().getStringArray(R.array.contact_type_item);
        this.N = this.f2380h.getResources().getString(R.string.channel_ptt_device_num) + ": ";
        this.O = this.f2380h.getResources().getString(R.string.channel_ptt_channel_type) + ": ";
        this.P = this.f2380h.getResources().getString(R.string.channel_ptt_color_code) + ": ";
        this.U = this.f2380h.getResources().getString(R.string.channel_ptt_call_type) + ": ";
        this.V = this.f2380h.getResources().getString(R.string.channel_ptt_call_num) + ": ";
        this.Q = this.f2380h.getResources().getString(R.string.channel_list_transmission_frequency) + ": ";
        this.R = this.f2380h.getResources().getString(R.string.channel_list_receiving_frequency) + ": ";
        this.S = this.f2380h.getResources().getString(R.string.transmitting_subsonic_code) + ": ";
        this.T = this.f2380h.getResources().getString(R.string.receive_subsonic_code) + ": ";
    }

    public final boolean l() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f2377f0 < 1200) {
            s(getString(R.string.click_too_fast));
            return false;
        }
        boolean z2 = x0.g.N(getActivity(), 0, "pref_person_send_status") == 1;
        if (z2) {
            Toast.makeText(getActivity(), R.string.interphone_talk_send_status_toast, 0).show();
        }
        if (!z2) {
            if (this.J) {
                Toast.makeText(getActivity(), R.string.interphone_talk_receive_status_toast, 0).show();
            }
            if (!this.J) {
                this.f2377f0 = jCurrentTimeMillis;
                return true;
            }
        }
        return false;
    }

    public final void m() {
        String str = this.f2378g;
        Log.d(str, "onPttKeyDown  .");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.Z < 500) {
            Toast.makeText(this.f2380h, R.string.avoid_quick_click, 0).show();
            j();
            p();
            return;
        }
        this.W = true;
        this.Z = jCurrentTimeMillis;
        Log.d(str, " handlePttPress  , 1 =  mState = " + this.f2372a0);
        if (!this.f2373b0) {
            this.f2373b0 = true;
            boolean zBooleanValue = ((Boolean) x0.g.J(this.f2380h, "launch_interr_enable", Boolean.FALSE)).booleanValue();
            Log.d(str, "isInterruptEnable, enable = " + zBooleanValue);
            if (!zBooleanValue) {
                this.f2372a0 = 2;
                Log.d(str, " setPttLaunchDirect  , =  常规流程设置对讲机为发射状态；mState= " + this.f2372a0);
                Log.d(str, " setPttLaunch  , 设置对讲机为发射状态；");
                a.b bVar = this.f2375d0;
                if (bVar != null) {
                    bVar.removeMessages(259);
                    this.f2375d0.sendEmptyMessageDelayed(259, 0L);
                }
            } else if (this.f2372a0 == 0) {
                this.f2372a0 = 1;
                DmrManager.getInstance().setTransferInterrupt(3, new l0(this));
            } else {
                Log.d(str, " handlePttPress  , 2 = mState is not IDLE  mState = " + this.f2372a0);
            }
        }
        x0.g.o0(App.f1233b, 1, "pref_person_send_status");
    }

    public final void n() {
        this.W = false;
        Log.d(this.f2378g, "onPttKeyUp  .");
        j();
        x0.g.o0(App.f1233b, 0, "pref_person_send_status");
        new Handler().postDelayed(new h0(this, 2), 300L);
    }

    public final void o() {
        if (isAdded()) {
            if (this.H == null) {
                SoundPool soundPoolBuild = new SoundPool.Builder().setMaxStreams(1).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build()).build();
                this.H = soundPoolBuild;
                soundPoolBuild.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() { // from class: p0.i0
                    @Override // android.media.SoundPool.OnLoadCompleteListener
                    public final void onLoadComplete(SoundPool soundPool, int i2, int i3) {
                        soundPool.play(this.f2349a.I, 0.7f, 0.7f, 1, 0, 1.0f);
                    }
                });
            }
            this.I = this.H.load(getActivity(), R.raw.start_send, 1);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (this.f2391s != null) {
            k();
            v(this.f2391s);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f1899e == null) {
            this.f1899e = layoutInflater.inflate(R.layout.fragment_ptt, viewGroup, false);
        }
        this.f1899e.setBackground(getResources().getDrawable(R.color.black));
        ViewGroup viewGroup2 = (ViewGroup) this.f1899e.getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(this.f1899e);
        }
        this.f2380h = getActivity();
        k();
        return this.f1899e;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() throws IllegalStateException {
        super.onDestroy();
        s0.f.a().d();
        AudioRecord audioRecord = this.B;
        if (audioRecord != null) {
            audioRecord.release();
            this.B = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        a.b bVar = this.f2375d0;
        if (bVar != null) {
            bVar.removeCallbacksAndMessages(null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f2385m.setImageResource(R.drawable.selector_next);
        this.f2384l.setImageResource(R.drawable.selector_previous);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(R.id.tv_title);
        this.f2386n = textView;
        textView.setText(getResources().getString(R.string.rb_ptt));
        this.f2382j = (ImageView) view.findViewById(R.id.iv_ptt);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_menu);
        this.f2383k = imageView;
        imageView.setVisibility(8);
        this.f2387o = (TextView) view.findViewById(R.id.tv_info);
        this.f2384l = (ImageView) view.findViewById(R.id.iv_previous);
        this.f2385m = (ImageView) view.findViewById(R.id.iv_next);
        this.f2388p = (ImageView) view.findViewById(R.id.iv_channel_num);
        this.f2389q = (ImageView) view.findViewById(R.id.iv_channel_num1);
        this.f2396x = (CircleProgressDrawable) view.findViewById(R.id.iv_talkback_progress);
        this.f2394v = (Button) view.findViewById(R.id.fab_edit_channel);
        this.f2395w = (Button) view.findViewById(R.id.fab_send_msg);
        this.f2385m.setEnabled(false);
        this.f2384l.setEnabled(false);
        this.f2382j.setEnabled(false);
        new Handler().postDelayed(new h0(this, 0), 1000L);
        setUserVisibleHint(true);
        if (this.K == null) {
            this.K = (n0.p) new ViewModelProvider(this).get(n0.p.class);
        }
        if (this.f2390r == null) {
            this.f2390r = (k0.t) new ViewModelProvider(this).get(k0.t.class);
        }
        int iN = x0.g.N(getContext(), 1, "curr_country_id");
        Log.d("FragmentPtt", " roomChannelObserve 252: " + iN);
        this.f2390r.f2013a.a(iN).observe(getViewLifecycleOwner(), new b(7, this));
    }

    public final void p() {
        m0 m0Var = this.f2397y;
        if (m0Var != null) {
            m0Var.cancel();
        }
        CircleProgressDrawable circleProgressDrawable = this.f2396x;
        if (circleProgressDrawable != null) {
            circleProgressDrawable.setProgress(0);
            this.f2396x.setVisibility(4);
        }
    }

    public final void q() {
        int iIntValue = ((Integer) x0.g.J(this.f2380h, "trans_interr", 2)).intValue();
        Log.d("MainActivity", "初始化 开始设置中断");
        DmrManager.getInstance().setTransferInterrupt(iIntValue, new j0(this, 1));
    }

    public final void r() {
        Log.d(this.f2378g, "setPttReceive  , =  常规流程设置对讲机为接收状态；");
        a.b bVar = this.f2375d0;
        if (bVar != null) {
            bVar.removeMessages(259);
        }
        a.b bVar2 = this.f2375d0;
        if (bVar2 != null) {
            bVar2.removeMessages(260);
            this.f2375d0.sendEmptyMessageDelayed(260, 0L);
        }
    }

    public final void s(String str) {
        s0.b bVar = this.f2379g0;
        if (bVar != null) {
            bVar.setText(str);
            this.f2379g0.setDuration(0);
            this.f2379g0.show();
        }
    }

    public final void t() {
        AudioRecord audioRecord = this.B;
        if (audioRecord != null) {
            audioRecord.stop();
            this.B.release();
            this.B = null;
            this.f2398z = false;
        }
    }

    public final void u(k0.a aVar) {
        a.b bVar;
        if (!((Boolean) x0.g.J(this.f2380h, "voice", j0.c.f1902c)).booleanValue() || (bVar = this.f2375d0) == null) {
            return;
        }
        bVar.removeMessages(Optimizer.OPTIMIZATION_STANDARD);
        Message messageObtainMessage = this.f2375d0.obtainMessage();
        messageObtainMessage.obj = aVar;
        messageObtainMessage.what = Optimizer.OPTIMIZATION_STANDARD;
        this.f2375d0.sendMessage(messageObtainMessage);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x01c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v(k0.a r11) throws android.content.res.Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 656
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.o0.v(k0.a):void");
    }

    public final void w(int i2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (i2 == 0) {
            this.f2392t++;
        } else if (i2 == 1) {
            this.f2392t--;
        }
        if (this.f2392t < 0) {
            this.f2392t = 0;
        }
        int i3 = this.f2392t;
        ArrayList arrayList = this.f2393u;
        if (i3 >= arrayList.size()) {
            this.f2392t = arrayList.size() - 1;
        }
        k0.a aVar = (k0.a) arrayList.get(this.f2392t);
        this.f2391s = aVar;
        aVar.f1942f = true;
        this.f2390r.a(aVar);
        x0.g.m0(this.f2380h, "index", Integer.valueOf(this.f2392t));
        Log.d("FragmentPtt", "HZH updateCurrentIndex 1024: " + this.f2391s);
    }
}
