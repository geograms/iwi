package p0;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chamsion.quickchat.R;
import com.chamsion.quickchat.db.channel.ChannelDatabase;
import com.chamsion.quickchat.ui.AddNewChannelActivity;
import com.wonder.dmr.AnalogCommand;
import com.wonder.dmr.DigitalCommand;
import com.wonder.dmr.DmrManager;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class p extends j0.b implements View.OnClickListener {
    public static final /* synthetic */ int C = 0;
    public Dialog B;

    /* renamed from: h, reason: collision with root package name */
    public androidx.fragment.app.c0 f2400h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2401i;

    /* renamed from: j, reason: collision with root package name */
    public RecyclerView f2402j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f2403k;

    /* renamed from: l, reason: collision with root package name */
    public TextView f2404l;

    /* renamed from: m, reason: collision with root package name */
    public TextView f2405m;

    /* renamed from: n, reason: collision with root package name */
    public ImageView f2406n;

    /* renamed from: o, reason: collision with root package name */
    public ImageView f2407o;

    /* renamed from: p, reason: collision with root package name */
    public ImageView f2408p;

    /* renamed from: q, reason: collision with root package name */
    public RelativeLayout f2409q;

    /* renamed from: s, reason: collision with root package name */
    public k0.t f2411s;

    /* renamed from: t, reason: collision with root package name */
    public k0.q f2412t;

    /* renamed from: v, reason: collision with root package name */
    public k0.a f2414v;

    /* renamed from: x, reason: collision with root package name */
    public k0.a f2416x;

    /* renamed from: g, reason: collision with root package name */
    public final String f2399g = p.class.getName();

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList f2410r = new ArrayList();

    /* renamed from: u, reason: collision with root package name */
    public int f2413u = 0;

    /* renamed from: w, reason: collision with root package name */
    public int f2415w = 0;

    /* renamed from: y, reason: collision with root package name */
    public boolean f2417y = false;

    /* renamed from: z, reason: collision with root package name */
    public a.b f2418z = null;
    public HandlerThread A = null;

    @Override // j0.b
    public final void d() {
    }

    @Override // j0.b
    public final void e() {
        String str = this.f2399g;
        Log.d(str, "lazyLoad .... ");
        if (!this.f1895a || this.f2401i) {
            return;
        }
        final int i2 = 1;
        this.f2401i = true;
        Log.d(str, "init .... ");
        HandlerThread handlerThread = new HandlerThread("work-handlerthread");
        this.A = handlerThread;
        handlerThread.start();
        final int i3 = 3;
        this.f2418z = new a.b(this, this.A.getLooper(), 3);
        final int i4 = 0;
        this.f2415w = ((Integer) x0.g.J(this.f2400h, "index", 0)).intValue();
        this.f2407o.setOnClickListener(new View.OnClickListener(this) { // from class: p0.o

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ p f2370b;

            {
                this.f2370b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                int i5 = i4;
                this.f2370b.onClick(view);
            }
        });
        this.f2406n.setOnClickListener(new View.OnClickListener(this) { // from class: p0.o

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ p f2370b;

            {
                this.f2370b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                int i5 = i2;
                this.f2370b.onClick(view);
            }
        });
        final int i5 = 2;
        this.f2408p.setOnClickListener(new View.OnClickListener(this) { // from class: p0.o

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ p f2370b;

            {
                this.f2370b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                int i52 = i5;
                this.f2370b.onClick(view);
            }
        });
        this.f2404l.setOnClickListener(new View.OnClickListener(this) { // from class: p0.o

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ p f2370b;

            {
                this.f2370b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                int i52 = i3;
                this.f2370b.onClick(view);
            }
        });
        final int i6 = 4;
        this.f2405m.setOnClickListener(new View.OnClickListener(this) { // from class: p0.o

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ p f2370b;

            {
                this.f2370b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                int i52 = i6;
                this.f2370b.onClick(view);
            }
        });
        k0.q qVar = new k0.q();
        this.f2412t = qVar;
        this.f2402j.setAdapter(qVar);
        this.f2402j.setLayoutManager(new LinearLayoutManager());
        k0.q qVar2 = this.f2412t;
        qVar2.f2007d = new n(this, 1);
        qVar2.f2006c = new n(this, 2);
    }

    public final void f(k0.a aVar) {
        String str = this.f2399g;
        if (aVar == null) {
            Log.w(str, "configEnable,channle is null");
            return;
        }
        int i2 = aVar.f1941e;
        if (i2 == 1) {
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
            DmrManager.getInstance().setAnalogCmd(analogCommand, new k.j(17, this));
            return;
        }
        if (i2 == 0) {
            DigitalCommand digitalCommand = new DigitalCommand();
            digitalCommand.setRx_freq(aVar.f1944h);
            digitalCommand.setTx_freq(aVar.f1945i);
            digitalCommand.setLocalId(aVar.f1950n);
            String[] strArrSplit = aVar.f1951o.split("-");
            int length = strArrSplit.length;
            int[] iArr = new int[length];
            for (int i3 = 0; i3 < strArrSplit.length; i3++) {
                iArr[i3] = Integer.parseInt(strArrSplit[i3]);
            }
            Log.d(str, "getGroupList " + length);
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
            DmrManager.getInstance().setDigitalCmd(digitalCommand, new n(this, 0));
        }
    }

    public final void g() {
        DmrManager.getInstance().setTransferInterrupt(((Integer) x0.g.J(this.f2400h, "trans_interr", 2)).intValue(), new n(this, 3));
    }

    public final void h(boolean z2) {
        this.f2417y = z2;
        k0.q qVar = this.f2412t;
        qVar.f2005b = z2;
        qVar.notifyDataSetChanged();
        if (z2) {
            this.f2409q.setVisibility(0);
            this.f2404l.setVisibility(0);
            this.f2405m.setVisibility(0);
            this.f2407o.setVisibility(8);
            this.f2406n.setVisibility(8);
            return;
        }
        this.f2409q.setVisibility(8);
        this.f2404l.setVisibility(8);
        this.f2405m.setVisibility(8);
        this.f2407o.setVisibility(8);
        this.f2406n.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        DmrManager.getInstance().resetData();
        int id = view.getId();
        if (id == R.id.iv_add) {
            Intent intent = new Intent(getActivity(), (Class<?>) AddNewChannelActivity.class);
            intent.putExtra("what", "add");
            startActivityForResult(intent, 1);
            return;
        }
        if (id == R.id.iv_delete) {
            h(true);
            return;
        }
        if (id == R.id.iv_delete_comfirm) {
            h(false);
            return;
        }
        if (id == R.id.tv_select_cancel) {
            h(false);
            return;
        }
        if (id == R.id.tv_select_all) {
            return;
        }
        int i2 = R.id.channel_list_area_dialog_use;
        ArrayList arrayList = this.f2410r;
        if (id == i2) {
            Dialog dialog = this.B;
            if (dialog != null) {
                dialog.dismiss();
                this.B = null;
            }
            k0.a aVar = (k0.a) arrayList.get(this.f2415w);
            aVar.f1942f = false;
            this.f2411s.a(aVar);
            f(this.f2414v);
            k0.a aVar2 = this.f2414v;
            aVar2.f1942f = true;
            this.f2411s.a(aVar2);
            this.f2412t.notifyDataSetChanged();
            x0.g.m0(this.f2400h, "index", Integer.valueOf(this.f2413u));
            Log.d("FragmentChannel", "HZH click 315: " + this.f2413u);
            return;
        }
        if (id == R.id.channel_list_area_dialog_edit) {
            Dialog dialog2 = this.B;
            if (dialog2 != null) {
                dialog2.dismiss();
                this.B = null;
            }
            k0.a aVar3 = this.f2414v;
            Intent intent2 = new Intent(getActivity(), (Class<?>) AddNewChannelActivity.class);
            intent2.putExtra("channel", aVar3);
            intent2.putExtra("what", "modify");
            startActivityForResult(intent2, 1);
            return;
        }
        if (id == R.id.channel_list_area_dialog_delete) {
            Dialog dialog3 = this.B;
            if (dialog3 != null) {
                dialog3.dismiss();
                this.B = null;
            }
            k0.t tVar = this.f2411s;
            k0.a aVar4 = this.f2414v;
            k0.s sVar = tVar.f2013a;
            sVar.getClass();
            ChannelDatabase.f1237b.execute(new k0.r(sVar, aVar4, 2));
            if (this.f2413u < this.f2415w) {
                Log.d("FragmentChannel", "HZH deleteChannelConfirm 390: " + this.f2415w);
                k0.a aVar5 = (k0.a) arrayList.get(this.f2415w);
                aVar5.f1942f = true;
                this.f2411s.a(aVar5);
                this.f2412t.notifyDataSetChanged();
                int i3 = this.f2415w - 1;
                this.f2415w = i3;
                x0.g.m0(this.f2400h, "index", Integer.valueOf(i3));
            }
            this.f2416x = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f1899e == null) {
            this.f1899e = layoutInflater.inflate(R.layout.fragment_channel, viewGroup, false);
        }
        this.f1899e.setBackground(getResources().getDrawable(R.color.black));
        ViewGroup viewGroup2 = (ViewGroup) this.f1899e.getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(this.f1899e);
        }
        this.f2400h = getActivity();
        return this.f1899e;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        Log.d(this.f2399g, "onDestroyView .... ");
        h(false);
        a.b bVar = this.f2418z;
        if (bVar != null) {
            bVar.removeCallbacksAndMessages(null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        Log.d(this.f2399g, "onResume .... ");
        this.f2415w = ((Integer) x0.g.J(this.f2400h, "index", 0)).intValue();
        h(false);
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(R.id.tv_title);
        this.f2403k = textView;
        textView.setText(getResources().getString(R.string.rb_channel));
        this.f2406n = (ImageView) view.findViewById(R.id.iv_add);
        this.f2407o = (ImageView) view.findViewById(R.id.iv_delete);
        this.f2406n.setVisibility(0);
        this.f2407o.setVisibility(8);
        this.f2402j = (RecyclerView) view.findViewById(R.id.recycler_channel);
        this.f2408p = (ImageView) view.findViewById(R.id.iv_delete_comfirm);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_delete_comfirm);
        this.f2409q = relativeLayout;
        relativeLayout.setVisibility(8);
        this.f2404l = (TextView) view.findViewById(R.id.tv_select_cancel);
        this.f2405m = (TextView) view.findViewById(R.id.tv_select_all);
        setUserVisibleHint(true);
        if (this.f2411s == null) {
            this.f2411s = (k0.t) new ViewModelProvider(this).get(k0.t.class);
        }
        this.f2411s.f2013a.a(x0.g.N(getContext(), 1, "curr_country_id")).observe(getViewLifecycleOwner(), new b(1, this));
    }
}
