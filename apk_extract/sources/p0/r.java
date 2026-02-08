package p0;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chamsion.quickchat.R;
import com.chamsion.quickchat.ui.AddNewContactsActivity;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class r extends j0.b {
    public static final /* synthetic */ int D = 0;
    public Dialog C;

    /* renamed from: h, reason: collision with root package name */
    public androidx.fragment.app.c0 f2427h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2428i;

    /* renamed from: j, reason: collision with root package name */
    public ImageButton f2429j;

    /* renamed from: k, reason: collision with root package name */
    public ImageButton f2430k;

    /* renamed from: l, reason: collision with root package name */
    public RecyclerView f2431l;

    /* renamed from: m, reason: collision with root package name */
    public TextView f2432m;

    /* renamed from: n, reason: collision with root package name */
    public TextView f2433n;

    /* renamed from: o, reason: collision with root package name */
    public ImageView f2434o;

    /* renamed from: p, reason: collision with root package name */
    public ImageView f2435p;

    /* renamed from: q, reason: collision with root package name */
    public ImageView f2436q;

    /* renamed from: s, reason: collision with root package name */
    public RelativeLayout f2438s;

    /* renamed from: t, reason: collision with root package name */
    public m0.k f2439t;

    /* renamed from: w, reason: collision with root package name */
    public TextView f2442w;

    /* renamed from: x, reason: collision with root package name */
    public m0.n f2443x;

    /* renamed from: y, reason: collision with root package name */
    public m0.a f2444y;

    /* renamed from: g, reason: collision with root package name */
    public final String f2426g = r.class.getName();

    /* renamed from: r, reason: collision with root package name */
    public int f2437r = -1;

    /* renamed from: u, reason: collision with root package name */
    public final ArrayList f2440u = new ArrayList();

    /* renamed from: v, reason: collision with root package name */
    public final ArrayList f2441v = new ArrayList();

    /* renamed from: z, reason: collision with root package name */
    public final q f2445z = new q(this, 0);
    public final q A = new q(this, 1);
    public final g B = new g(this, 2);

    public static void f(r rVar, m0.a aVar) {
        rVar.getClass();
        Intent intent = new Intent(rVar.getActivity(), (Class<?>) AddNewContactsActivity.class);
        intent.putExtra("type_contacts", rVar.f2437r);
        intent.putExtra("contacts", aVar);
        intent.putExtra("what", "modify");
        rVar.startActivityForResult(intent, 1);
    }

    @Override // j0.b
    public final void e() {
        if (!this.f1895a || this.f2428i) {
            return;
        }
        this.f2428i = true;
        Log.d(this.f2426g, "init .... ");
        ImageButton imageButton = this.f2429j;
        g gVar = this.B;
        imageButton.setOnClickListener(gVar);
        this.f2430k.setOnClickListener(gVar);
        this.f2435p.setOnClickListener(gVar);
        this.f2434o.setOnClickListener(gVar);
        this.f2436q.setOnClickListener(gVar);
        this.f2432m.setOnClickListener(gVar);
        this.f2433n.setOnClickListener(gVar);
        m0.k kVar = new m0.k();
        kVar.f2122a = m0.k.class.getName();
        kVar.f2123b = new ArrayList();
        kVar.f2124c = new ArrayList();
        kVar.f2125d = false;
        kVar.f2126e = null;
        this.f2439t = kVar;
        this.f2431l.setAdapter(kVar);
        this.f2431l.setLayoutManager(new LinearLayoutManager());
        m0.k kVar2 = this.f2439t;
        kVar2.f2126e = this.A;
        kVar2.f2127f = this.f2445z;
        this.f2429j.setSelected(true);
        this.f2430k.setSelected(false);
        this.f2437r = 0;
        this.f2439t.a(this.f2440u);
        this.f2439t.notifyDataSetChanged();
    }

    public final void g(boolean z2) {
        m0.k kVar = this.f2439t;
        kVar.f2125d = z2;
        kVar.notifyDataSetChanged();
        if (z2) {
            this.f2438s.setVisibility(0);
            this.f2432m.setVisibility(0);
            this.f2433n.setVisibility(0);
            this.f2435p.setVisibility(8);
            this.f2434o.setVisibility(8);
            return;
        }
        this.f2438s.setVisibility(8);
        this.f2432m.setVisibility(8);
        this.f2433n.setVisibility(8);
        this.f2435p.setVisibility(8);
        this.f2434o.setVisibility(0);
        Log.d(this.f2426g, "selectAll");
        this.f2439t.b(false);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.f2434o.setEnabled(true);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f1899e == null) {
            this.f1899e = layoutInflater.inflate(R.layout.fragment_contacts, viewGroup, false);
        }
        this.f1899e.setBackground(getResources().getDrawable(R.color.black));
        ViewGroup viewGroup2 = (ViewGroup) this.f1899e.getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(this.f1899e);
        }
        this.f2427h = getActivity();
        return this.f1899e;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        g(false);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        g(false);
        if (this.f2443x == null) {
            this.f2443x = (m0.n) new ViewModelProvider(this).get(m0.n.class);
        }
        this.f2443x.f2133b.observe(this, new b(2, this));
        this.f2429j.setBackgroundResource(R.drawable.shape_contacts_person_selector);
        this.f2430k.setBackgroundResource(R.drawable.shape_contacts_group_selector);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((TextView) view.findViewById(R.id.tv_title)).setText(getResources().getString(R.string.rb_contacts));
        this.f2429j = (ImageButton) view.findViewById(R.id.ib_person);
        this.f2430k = (ImageButton) view.findViewById(R.id.ib_group);
        this.f2431l = (RecyclerView) view.findViewById(R.id.recycler_contacts);
        this.f2442w = (TextView) view.findViewById(R.id.tv_no_contacts);
        this.f2434o = (ImageView) view.findViewById(R.id.iv_add);
        this.f2435p = (ImageView) view.findViewById(R.id.iv_delete);
        this.f2434o.setVisibility(0);
        this.f2435p.setVisibility(8);
        this.f2436q = (ImageView) view.findViewById(R.id.iv_delete_comfirm);
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_delete_comfirm);
        this.f2438s = relativeLayout;
        relativeLayout.setVisibility(8);
        this.f2432m = (TextView) view.findViewById(R.id.tv_select_cancel);
        this.f2433n = (TextView) view.findViewById(R.id.tv_select_all);
        setUserVisibleHint(true);
    }
}
