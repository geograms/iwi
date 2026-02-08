package com.chamsion.quickchat.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chamsion.quickchat.db.channel.ChannelDatabase;
import com.chamsion.quickchat.ui.AddNewChannelActivity;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.wonder.dmr.utils.SPUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k0.a;
import k0.r;
import k0.s;
import k0.t;
import m0.n;
import p0.b;
import p0.d;
import p0.e;
import p0.h;
import q0.c;
import x0.g;

/* loaded from: classes.dex */
public class AddNewChannelActivity extends AppCompatActivity implements View.OnClickListener {
    public static int I0;
    public RelativeLayout A;
    public RelativeLayout B;
    public RelativeLayout C;
    public int C0;
    public RelativeLayout D;
    public n D0;
    public RelativeLayout E;
    public RelativeLayout F;
    public RelativeLayout G;
    public RelativeLayout H;
    public RelativeLayout I;
    public RelativeLayout J;
    public RelativeLayout K;
    public RelativeLayout L;
    public EditText M;
    public EditText N;
    public TextInputEditText O;
    public TextInputEditText P;
    public TextInputLayout Q;
    public TextInputLayout R;
    public TextView S;
    public TextView T;
    public RecyclerView U;
    public RelativeLayout V;
    public a X;

    /* renamed from: a0, reason: collision with root package name */
    public t f1261a0;

    /* renamed from: b, reason: collision with root package name */
    public AddNewChannelActivity f1262b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f1264c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f1266d;

    /* renamed from: e, reason: collision with root package name */
    public ImageView f1268e;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f1270f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f1272g;

    /* renamed from: h, reason: collision with root package name */
    public AppCompatSpinner f1274h;

    /* renamed from: i, reason: collision with root package name */
    public AppCompatSpinner f1276i;

    /* renamed from: j, reason: collision with root package name */
    public AppCompatSpinner f1278j;

    /* renamed from: k, reason: collision with root package name */
    public AppCompatSpinner f1280k;

    /* renamed from: l, reason: collision with root package name */
    public AppCompatSpinner f1282l;

    /* renamed from: m, reason: collision with root package name */
    public AppCompatSpinner f1284m;

    /* renamed from: n, reason: collision with root package name */
    public AppCompatSpinner f1286n;

    /* renamed from: o, reason: collision with root package name */
    public AppCompatSpinner f1288o;

    /* renamed from: p, reason: collision with root package name */
    public AppCompatSpinner f1290p;

    /* renamed from: q, reason: collision with root package name */
    public AppCompatSpinner f1292q;

    /* renamed from: r, reason: collision with root package name */
    public AppCompatSpinner f1294r;

    /* renamed from: s, reason: collision with root package name */
    public AppCompatSpinner f1296s;

    /* renamed from: t, reason: collision with root package name */
    public AppCompatSpinner f1298t;

    /* renamed from: u, reason: collision with root package name */
    public AppCompatSpinner f1300u;

    /* renamed from: v, reason: collision with root package name */
    public AppCompatSpinner f1302v;

    /* renamed from: w, reason: collision with root package name */
    public AppCompatSpinner f1304w;

    /* renamed from: x, reason: collision with root package name */
    public RelativeLayout f1306x;

    /* renamed from: y, reason: collision with root package name */
    public RelativeLayout f1308y;

    /* renamed from: z, reason: collision with root package name */
    public RelativeLayout f1310z;

    /* renamed from: a, reason: collision with root package name */
    public final String f1260a = AddNewChannelActivity.class.getName();
    public final byte[] W = {1, 2};
    public boolean Y = false;
    public boolean Z = false;

    /* renamed from: b0, reason: collision with root package name */
    public int f1263b0 = -1;

    /* renamed from: c0, reason: collision with root package name */
    public String f1265c0 = "";

    /* renamed from: d0, reason: collision with root package name */
    public String f1267d0 = "";

    /* renamed from: e0, reason: collision with root package name */
    public final ArrayList f1269e0 = new ArrayList();

    /* renamed from: f0, reason: collision with root package name */
    public c f1271f0 = null;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f1273g0 = true;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f1275h0 = true;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f1277i0 = true;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f1279j0 = true;

    /* renamed from: k0, reason: collision with root package name */
    public int f1281k0 = 1;

    /* renamed from: l0, reason: collision with root package name */
    public byte f1283l0 = 1;

    /* renamed from: m0, reason: collision with root package name */
    public byte f1285m0 = 1;

    /* renamed from: n0, reason: collision with root package name */
    public byte f1287n0 = 0;

    /* renamed from: o0, reason: collision with root package name */
    public byte f1289o0 = 0;

    /* renamed from: p0, reason: collision with root package name */
    public byte f1291p0 = 0;

    /* renamed from: q0, reason: collision with root package name */
    public byte f1293q0 = 2;

    /* renamed from: r0, reason: collision with root package name */
    public String f1295r0 = "";

    /* renamed from: s0, reason: collision with root package name */
    public int f1297s0 = 401025000;

    /* renamed from: t0, reason: collision with root package name */
    public int f1299t0 = 401025000;

    /* renamed from: u0, reason: collision with root package name */
    public byte f1301u0 = 2;

    /* renamed from: v0, reason: collision with root package name */
    public byte f1303v0 = 0;

    /* renamed from: w0, reason: collision with root package name */
    public byte f1305w0 = 5;

    /* renamed from: x0, reason: collision with root package name */
    public byte f1307x0 = 0;

    /* renamed from: y0, reason: collision with root package name */
    public byte f1309y0 = 0;

    /* renamed from: z0, reason: collision with root package name */
    public byte f1311z0 = 0;
    public byte A0 = 0;
    public byte B0 = 2;
    public final ArrayList E0 = new ArrayList();
    public final ArrayList F0 = new ArrayList();
    public int G0 = 3;
    public String H0 = "";

    public static /* synthetic */ void d(AddNewChannelActivity addNewChannelActivity, List list) {
        addNewChannelActivity.getClass();
        if (Build.VERSION.SDK_INT >= 35) {
            if (list.isEmpty()) {
                addNewChannelActivity.C0 = -1;
            } else {
                addNewChannelActivity.C0 = ((a) list.getLast()).f1939c;
            }
        }
    }

    public static void g(TextInputLayout textInputLayout) {
        TextView textView = (TextView) textInputLayout.findViewById(R.id.textinput_error);
        if (textView != null) {
            textView.setGravity(8388613);
            textView.setTextAlignment(3);
        }
    }

    public final String e() {
        ArrayList arrayList = this.f1269e0;
        arrayList.clear();
        c cVar = this.f1271f0;
        ArrayList arrayList2 = cVar.f2485b;
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Log.d(cVar.f2484a, "getData = " + ((String) it.next()));
        }
        arrayList.addAll(arrayList2);
        if (arrayList.size() == 0) {
            f(false);
        }
        Iterator it2 = arrayList.iterator();
        String str = "";
        while (it2.hasNext()) {
            str = str + ((String) it2.next()) + "-";
        }
        Log.d(this.f1260a, "getGroupList = " + str);
        return str;
    }

    public final void f(boolean z2) {
        ArrayList arrayList = this.f1269e0;
        int i2 = 0;
        if (z2) {
            a aVar = this.X;
            if (aVar.f1941e == 0) {
                String str = aVar.f1951o;
                if (str == null || TextUtils.isEmpty(str)) {
                    return;
                }
                String[] strArrSplit = this.X.f1951o.split("-");
                int length = strArrSplit.length;
                int[] iArr = new int[length];
                for (int i3 = 0; i3 < strArrSplit.length; i3++) {
                    iArr[i3] = Integer.parseInt(strArrSplit[i3]);
                }
                Log.d(this.f1260a, a.a.c("getGroupList ", length));
                while (i2 < length) {
                    arrayList.add(iArr[i2] + "");
                    i2++;
                }
            }
        } else {
            arrayList.clear();
            while (i2 < 32) {
                if (i2 == 0) {
                    arrayList.add("1");
                } else {
                    arrayList.add("0");
                }
                i2++;
            }
        }
        ArrayList arrayList2 = this.f1271f0.f2485b;
        arrayList2.clear();
        arrayList2.addAll(arrayList);
        this.f1271f0.notifyDataSetChanged();
    }

    public final void h(int i2, int i3) throws Resources.NotFoundException {
        Log.e(this.f1260a, "WONDER ,updateAspRxYaYin type = " + i2 + " rxV = " + i3);
        if (i2 == 0) {
            this.D.setVisibility(8);
        } else if (i2 == 1) {
            this.f1286n.setAdapter((SpinnerAdapter) new ArrayAdapter(this.f1262b, com.chamsion.quickchat.R.layout.support_spinner_dropdown_item, getResources().getStringArray(com.chamsion.quickchat.R.array.type_ctcss)));
        } else if (i2 == 2) {
            this.f1286n.setAdapter((SpinnerAdapter) new ArrayAdapter(this.f1262b, com.chamsion.quickchat.R.layout.support_spinner_dropdown_item, getResources().getStringArray(com.chamsion.quickchat.R.array.type_cdcss_n_83)));
        } else if (i2 == 3) {
            this.f1286n.setAdapter((SpinnerAdapter) new ArrayAdapter(this.f1262b, com.chamsion.quickchat.R.layout.support_spinner_dropdown_item, getResources().getStringArray(com.chamsion.quickchat.R.array.type_cdcss_i_83)));
        }
        if (!this.Y || i3 == -1) {
            return;
        }
        this.f1286n.setSelection(i3);
    }

    public final void i(int i2, int i3) throws Resources.NotFoundException {
        Log.e(this.f1260a, "WONDER ,updateAspTxYaYin type = " + i2 + " txV = " + i3);
        if (i2 == 0) {
            this.C.setVisibility(8);
        } else if (i2 == 1) {
            this.f1284m.setAdapter((SpinnerAdapter) new ArrayAdapter(this.f1262b, com.chamsion.quickchat.R.layout.support_spinner_dropdown_item, getResources().getStringArray(com.chamsion.quickchat.R.array.type_ctcss)));
        } else if (i2 == 2) {
            this.f1284m.setAdapter((SpinnerAdapter) new ArrayAdapter(this.f1262b, com.chamsion.quickchat.R.layout.support_spinner_dropdown_item, getResources().getStringArray(com.chamsion.quickchat.R.array.type_cdcss_n_83)));
        } else if (i2 == 3) {
            this.f1284m.setAdapter((SpinnerAdapter) new ArrayAdapter(this.f1262b, com.chamsion.quickchat.R.layout.support_spinner_dropdown_item, getResources().getStringArray(com.chamsion.quickchat.R.array.type_cdcss_i_83)));
        }
        if (!this.Y || i3 == -1) {
            return;
        }
        this.f1284m.setSelection(i3);
    }

    public final void j(int i2) {
        int i3 = this.f1263b0;
        boolean z2 = i3 != i2 && i3 == 1;
        if (i2 == 0) {
            this.f1306x.setVisibility(8);
            this.f1308y.setVisibility(8);
            this.f1310z.setVisibility(8);
            this.A.setVisibility(8);
            this.B.setVisibility(8);
            this.C.setVisibility(8);
            this.D.setVisibility(8);
            if (this.f1300u.getSelectedItemPosition() == 0) {
                this.L.setVisibility(0);
            } else {
                this.L.setVisibility(8);
            }
            if (this.f1298t.getSelectedItemPosition() == 1) {
                this.T.setVisibility(8);
                this.f1288o.setVisibility(8);
            } else if (this.f1298t.getSelectedItemPosition() == 0) {
                this.T.setVisibility(0);
                this.f1288o.setVisibility(8);
            } else {
                this.T.setVisibility(8);
                this.f1288o.setVisibility(8);
                this.K.setVisibility(8);
            }
            this.E.setVisibility(0);
            this.F.setVisibility(0);
            this.G.setVisibility(0);
            this.H.setVisibility(0);
            this.K.setVisibility(0);
            this.J.setVisibility(0);
            if (this.f1298t.getSelectedItem().equals(getString(com.chamsion.quickchat.R.string.interphone_channel_contact_type_group))) {
                this.V.setVisibility(0);
                this.I.setVisibility(0);
            } else if (this.f1298t.getSelectedItem().equals(getString(com.chamsion.quickchat.R.string.interphone_channel_contact_type_all))) {
                this.I.setVisibility(8);
            } else if (this.f1298t.getSelectedItem().equals(getString(com.chamsion.quickchat.R.string.interphone_channel_contact_type_default))) {
                this.I.setVisibility(0);
            }
            this.f1263b0 = 0;
            if (z2) {
                Log.i(this.f1260a, "initDigitalDefault");
                this.f1290p.setSelection(I0);
                this.O.setText(this.f1299t0 + "");
                this.P.setText(this.f1297s0 + "");
                this.f1292q.setSelection(1);
                this.f1274h.setSelection(0);
                this.f1296s.setSelection(0);
                this.f1298t.setSelection(1);
                this.f1300u.setSelection(1);
                f(false);
            }
        }
        if (1 == i2) {
            this.f1306x.setVisibility(0);
            this.f1308y.setVisibility(0);
            this.f1310z.setVisibility(0);
            this.A.setVisibility(0);
            this.B.setVisibility(0);
            if (this.f1280k.getSelectedItem().equals(getString(com.chamsion.quickchat.R.string.interphone_channel_txtype_wave))) {
                this.C.setVisibility(8);
            } else {
                this.C.setVisibility(0);
            }
            if (this.f1282l.getSelectedItem().equals(getString(com.chamsion.quickchat.R.string.interphone_channel_txtype_wave))) {
                this.D.setVisibility(8);
            } else {
                this.D.setVisibility(0);
            }
            if (this.Y) {
                this.f1278j.setSelection((byte) this.X.f1962z);
                this.f1304w.setSelection(((byte) this.X.E) - 1);
            } else {
                this.f1304w.setSelection(this.B0 - 1);
                this.f1278j.setSelection(this.f1305w0);
            }
            this.E.setVisibility(8);
            this.F.setVisibility(8);
            this.G.setVisibility(8);
            this.H.setVisibility(8);
            this.I.setVisibility(8);
            this.J.setVisibility(8);
            this.L.setVisibility(8);
            this.V.setVisibility(8);
            this.K.setVisibility(8);
            this.f1263b0 = 1;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i2;
        if (view.getId() != com.chamsion.quickchat.R.id.iv_done) {
            if (view.getId() == com.chamsion.quickchat.R.id.iv_close) {
                finish();
                return;
            }
            return;
        }
        this.H0 = "";
        if (TextUtils.isEmpty(this.f1265c0)) {
            this.H0 = getString(com.chamsion.quickchat.R.string.title_connot_be_empty);
        }
        if (this.f1299t0 == 0) {
            this.Q.setError(getString(com.chamsion.quickchat.R.string.rate_cannot_be_empty));
            g(this.Q);
            this.H0 = "" + ((Object) this.Q.getError());
        }
        if (this.f1297s0 == 0) {
            this.R.setError(getString(com.chamsion.quickchat.R.string.rate_cannot_be_empty));
            g(this.R);
            this.H0 = "" + ((Object) this.R.getError());
        }
        int i3 = I0;
        if (i3 == 0) {
            int i4 = this.f1299t0;
            if (i4 < 400000000 || i4 > 480000000) {
                this.Q.setError("400M~480M");
                g(this.Q);
                this.H0 = "" + ((Object) this.Q.getError());
            }
            int i5 = this.f1297s0;
            if (i5 < 400000000 || i5 > 480000000) {
                this.R.setError("400M~480M");
                g(this.R);
                this.H0 = "" + ((Object) this.R.getError());
            }
        } else if (i3 == 1) {
            int i6 = this.f1299t0;
            if (i6 < 136000000 || i6 > 174000000) {
                this.Q.setError("136M~174M");
                g(this.Q);
                this.H0 = "" + ((Object) this.Q.getError());
            }
            int i7 = this.f1297s0;
            if (i7 < 136000000 || i7 > 174000000) {
                this.R.setError("136M~174M");
                g(this.R);
                this.H0 = "" + ((Object) this.R.getError());
            }
        }
        if (this.f1300u.getSelectedItem().equals(getString(com.chamsion.quickchat.R.string.interphone_channel_encryption_enable)) && this.f1274h.getSelectedItemPosition() == 0) {
            this.H0 = "" + ((Object) this.N.getError());
            String str = this.f1295r0;
            if (str == null || TextUtils.isEmpty(str)) {
                this.f1270f.setVisibility(0);
                this.H0 = "" + getString(com.chamsion.quickchat.R.string.pwd_cannot_be_empty);
            }
        }
        if (this.f1263b0 == 0 && this.f1281k0 == 0 && this.f1283l0 != 2) {
            this.S.setError(getString(com.chamsion.quickchat.R.string.num_cannot_be_zero));
            this.H0 = "" + ((Object) this.S.getError());
        }
        this.H0 = "" + ((Object) this.M.getError()) + ((Object) this.Q.getError()) + ((Object) this.R.getError()) + ((Object) this.N.getError()) + ((Object) this.S.getError());
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1299t0);
        sb.append("check   ");
        sb.append(this.H0);
        String string = sb.toString();
        String str2 = this.f1260a;
        Log.d(str2, string);
        if (this.f1268e.getVisibility() == 8 && this.Q.getError() == null && this.R.getError() == null && this.S.getError() == null) {
            Log.d(str2, "check, A ");
        } else {
            if (TextUtils.isEmpty(this.H0) && !this.H0.contains(null)) {
                return;
            }
            Log.d(str2, "check, B ");
            if (!TextUtils.isEmpty(this.H0)) {
                return;
            }
        }
        if (!this.Y) {
            this.f1266d.setEnabled(false);
            int i8 = this.f1263b0;
            if (i8 == 1) {
                a aVar = new a();
                aVar.f1938b = g.N(this.f1262b, 1, "curr_country_id");
                aVar.f1940d = this.f1265c0;
                aVar.f1941e = 1;
                aVar.f1945i = this.f1299t0;
                aVar.f1944h = this.f1297s0;
                aVar.f1961y = this.f1303v0;
                aVar.f1962z = this.f1305w0;
                aVar.A = this.f1307x0;
                aVar.B = this.f1309y0;
                aVar.C = this.f1311z0;
                aVar.D = this.A0;
                aVar.f1947k = (byte) ((Integer) g.J(this.f1262b, "save_power", 2)).intValue();
                aVar.f1948l = (byte) ((Integer) g.J(this.f1262b, "volume", 8)).intValue();
                aVar.f1960x = (byte) ((Integer) g.J(this.f1262b, "mic", 0)).intValue();
                aVar.f1946j = (byte) ((Integer) g.J(this.f1262b, "power", 1)).intValue();
                aVar.f1950n = ((Integer) g.J(this.f1262b, "local_id", 1)).intValue();
                aVar.E = this.B0;
                aVar.f1949m = this.f1301u0;
                aVar.f1939c = this.C0 + 1;
                s sVar = this.f1261a0.f2013a;
                sVar.getClass();
                ChannelDatabase.f1237b.execute(new r(sVar, aVar, 1));
            } else if (i8 == 0) {
                a aVar2 = new a();
                aVar2.f1938b = g.N(this.f1262b, 1, "curr_country_id");
                aVar2.f1940d = this.f1265c0;
                aVar2.f1941e = 0;
                aVar2.f1945i = this.f1299t0;
                aVar2.f1944h = this.f1297s0;
                aVar2.f1954r = this.f1285m0;
                aVar2.f1957u = this.f1291p0;
                aVar2.f1955s = this.f1287n0;
                aVar2.f1956t = this.f1289o0;
                byte b2 = this.f1283l0;
                aVar2.f1953q = b2;
                aVar2.f1952p = this.f1281k0;
                byte b3 = this.f1293q0;
                aVar2.f1958v = b3;
                if (b3 == 2) {
                    aVar2.f1959w = "12345678";
                    i2 = 1;
                } else {
                    i2 = 1;
                    if (b3 == 1) {
                        aVar2.f1959w = this.f1295r0;
                    }
                }
                if (b2 == 0) {
                    aVar2.f1943g = i2;
                } else {
                    aVar2.f1943g = 3;
                }
                aVar2.f1950n = ((Integer) g.J(this.f1262b, "local_id", 1)).intValue();
                aVar2.f1946j = (byte) ((Integer) g.J(this.f1262b, "power", 1)).intValue();
                aVar2.f1947k = (byte) ((Integer) g.J(this.f1262b, "save_power", 2)).intValue();
                aVar2.f1948l = (byte) ((Integer) g.J(this.f1262b, "volume", 8)).intValue();
                aVar2.f1960x = (byte) ((Integer) g.J(this.f1262b, "mic", 0)).intValue();
                aVar2.f1951o = e();
                aVar2.E = this.B0;
                aVar2.f1949m = this.f1301u0;
                aVar2.f1939c = this.C0 + 1;
                s sVar2 = this.f1261a0.f2013a;
                sVar2.getClass();
                ChannelDatabase.f1237b.execute(new r(sVar2, aVar2, 1));
            }
            new Handler().postDelayed(new h(this, 0), 1000L);
            return;
        }
        int i9 = this.f1263b0;
        if (i9 == 1) {
            Log.d(str2, " updateAnalogData , " + this.f1265c0);
            a aVar3 = this.X;
            if (!this.f1265c0.equals(this.f1267d0)) {
                aVar3.f1940d = this.f1265c0;
            }
            aVar3.f1941e = 1;
            aVar3.f1937a = this.X.f1937a;
            aVar3.f1942f = this.Z;
            aVar3.f1945i = this.f1299t0;
            aVar3.f1944h = this.f1297s0;
            aVar3.f1961y = this.f1303v0;
            aVar3.f1962z = this.f1305w0;
            aVar3.A = this.f1307x0;
            aVar3.B = this.f1309y0;
            aVar3.C = this.f1311z0;
            aVar3.D = this.A0;
            aVar3.f1950n = ((Integer) g.J(this.f1262b, "local_id", 1)).intValue();
            aVar3.f1946j = (byte) ((Integer) g.J(this.f1262b, "power", 1)).intValue();
            aVar3.f1947k = (byte) ((Integer) g.J(this.f1262b, "save_power", 2)).intValue();
            aVar3.f1948l = (byte) ((Integer) g.J(this.f1262b, "volume", 8)).intValue();
            aVar3.f1960x = (byte) ((Integer) g.J(this.f1262b, "mic", 0)).intValue();
            aVar3.E = this.B0;
            aVar3.f1949m = this.f1301u0;
            aVar3.f1954r = this.f1285m0;
            aVar3.f1957u = this.f1291p0;
            aVar3.f1955s = this.f1287n0;
            aVar3.f1956t = this.f1289o0;
            Log.d(str2, "UPDATE mContactType " + ((int) this.f1283l0) + " mContact=" + this.f1281k0);
            aVar3.f1953q = this.f1283l0;
            aVar3.f1952p = this.f1281k0;
            byte b4 = this.f1293q0;
            aVar3.f1958v = b4;
            if (b4 == 2) {
                aVar3.f1959w = "12345678";
            } else if (b4 == 1) {
                aVar3.f1959w = this.f1295r0;
            }
            this.f1261a0.a(aVar3);
        } else if (i9 == 0) {
            a aVar4 = this.X;
            if (!this.f1265c0.equals(this.f1267d0)) {
                aVar4.f1940d = this.f1265c0;
            }
            aVar4.f1941e = 0;
            aVar4.f1937a = this.X.f1937a;
            aVar4.f1942f = this.Z;
            aVar4.f1945i = this.f1299t0;
            aVar4.f1944h = this.f1297s0;
            aVar4.f1954r = this.f1285m0;
            aVar4.f1957u = this.f1291p0;
            aVar4.f1955s = this.f1287n0;
            aVar4.f1956t = this.f1289o0;
            Log.d(str2, "UPDATE mContactType " + ((int) this.f1283l0) + " mContact=" + this.f1281k0 + " ,mSmsType=" + this.G0);
            byte b5 = this.f1283l0;
            aVar4.f1953q = b5;
            aVar4.f1952p = this.f1281k0;
            if (b5 == 0) {
                aVar4.f1943g = 1;
            } else {
                aVar4.f1943g = 3;
            }
            byte b6 = this.f1293q0;
            aVar4.f1958v = b6;
            if (b6 == 2) {
                aVar4.f1959w = "12345678";
            } else if (b6 == 1) {
                aVar4.f1959w = this.f1295r0;
            }
            aVar4.f1950n = ((Integer) g.J(this.f1262b, "local_id", 1)).intValue();
            aVar4.f1946j = (byte) ((Integer) g.J(this.f1262b, "power", 1)).intValue();
            aVar4.f1947k = (byte) ((Integer) g.J(this.f1262b, "save_power", 2)).intValue();
            aVar4.f1948l = (byte) ((Integer) g.J(this.f1262b, "volume", 8)).intValue();
            aVar4.f1960x = (byte) ((Integer) g.J(this.f1262b, "mic", 0)).intValue();
            aVar4.f1951o = e();
            byte b7 = this.B0;
            aVar4.f1949m = this.f1301u0;
            aVar4.f1961y = this.f1303v0;
            aVar4.f1962z = this.f1305w0;
            aVar4.A = this.f1307x0;
            aVar4.B = this.f1309y0;
            aVar4.C = this.f1311z0;
            aVar4.D = this.A0;
            aVar4.E = b7;
            this.f1261a0.a(aVar4);
        }
        new Handler().postDelayed(new h(this, 1), 1000L);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.c0, androidx.activity.h, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        configuration.fontScale = 1.0f;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        displayMetrics.scaledDensity = displayMetrics.density;
        getResources().updateConfiguration(configuration, displayMetrics);
    }

    @Override // androidx.fragment.app.c0, androidx.activity.h, h.l, android.app.Activity
    public final void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        setContentView(com.chamsion.quickchat.R.layout.activity_add_new_channel);
        this.f1262b = this;
        int i2 = 8;
        findViewById(com.chamsion.quickchat.R.id.tv_title).setVisibility(8);
        TextView textView = (TextView) findViewById(com.chamsion.quickchat.R.id.tv_center_title);
        this.f1272g = textView;
        textView.setVisibility(0);
        this.f1272g.setText(getResources().getString(com.chamsion.quickchat.R.string.add_new_channel));
        ImageView imageView = (ImageView) findViewById(com.chamsion.quickchat.R.id.iv_close);
        this.f1264c = imageView;
        imageView.setVisibility(0);
        ImageView imageView2 = (ImageView) findViewById(com.chamsion.quickchat.R.id.iv_done);
        this.f1266d = imageView2;
        imageView2.setVisibility(0);
        this.f1274h = (AppCompatSpinner) findViewById(com.chamsion.quickchat.R.id.asp_channel_type);
        this.f1276i = (AppCompatSpinner) findViewById(com.chamsion.quickchat.R.id.asp_brandwidth);
        this.f1278j = (AppCompatSpinner) findViewById(com.chamsion.quickchat.R.id.asp_sq);
        this.f1280k = (AppCompatSpinner) findViewById(com.chamsion.quickchat.R.id.asp_transmission);
        this.f1282l = (AppCompatSpinner) findViewById(com.chamsion.quickchat.R.id.asp_receive);
        this.f1292q = (AppCompatSpinner) findViewById(com.chamsion.quickchat.R.id.asp_cc);
        this.f1294r = (AppCompatSpinner) findViewById(com.chamsion.quickchat.R.id.asp_channel_mode);
        this.f1296s = (AppCompatSpinner) findViewById(com.chamsion.quickchat.R.id.asp_slot_type);
        this.f1298t = (AppCompatSpinner) findViewById(com.chamsion.quickchat.R.id.asp_contacts_type);
        this.f1300u = (AppCompatSpinner) findViewById(com.chamsion.quickchat.R.id.asp_encryption_switch);
        this.f1302v = (AppCompatSpinner) findViewById(com.chamsion.quickchat.R.id.asp_relay);
        this.f1304w = (AppCompatSpinner) findViewById(com.chamsion.quickchat.R.id.asp_monitor);
        this.f1284m = (AppCompatSpinner) findViewById(com.chamsion.quickchat.R.id.asp_transmission_value);
        this.f1286n = (AppCompatSpinner) findViewById(com.chamsion.quickchat.R.id.asp_receive_value);
        this.f1288o = (AppCompatSpinner) findViewById(com.chamsion.quickchat.R.id.asp_sms_type);
        this.C = (RelativeLayout) findViewById(com.chamsion.quickchat.R.id.rl_analog_transmission_value);
        this.D = (RelativeLayout) findViewById(com.chamsion.quickchat.R.id.rl_analog_receive_value);
        this.M = (EditText) findViewById(com.chamsion.quickchat.R.id.et_channel_name);
        this.f1268e = (ImageView) findViewById(com.chamsion.quickchat.R.id.iv_error);
        this.f1290p = (AppCompatSpinner) findViewById(com.chamsion.quickchat.R.id.et_channel_frequency_band);
        this.O = (TextInputEditText) findViewById(com.chamsion.quickchat.R.id.et_tx);
        this.Q = (TextInputLayout) findViewById(com.chamsion.quickchat.R.id.til_tx);
        this.P = (TextInputEditText) findViewById(com.chamsion.quickchat.R.id.et_rx);
        this.R = (TextInputLayout) findViewById(com.chamsion.quickchat.R.id.til_rx);
        this.S = (TextView) findViewById(com.chamsion.quickchat.R.id.et_contacts_number);
        this.T = (TextView) findViewById(com.chamsion.quickchat.R.id.tv_sms_type_group);
        this.N = (EditText) findViewById(com.chamsion.quickchat.R.id.et_encryption);
        this.f1270f = (ImageView) findViewById(com.chamsion.quickchat.R.id.iv_error_encryption);
        this.f1306x = (RelativeLayout) findViewById(com.chamsion.quickchat.R.id.rl_analog_bandwidth);
        this.f1308y = (RelativeLayout) findViewById(com.chamsion.quickchat.R.id.rl_analog_sq);
        this.f1310z = (RelativeLayout) findViewById(com.chamsion.quickchat.R.id.rl_analog_transmission);
        this.A = (RelativeLayout) findViewById(com.chamsion.quickchat.R.id.rl_analog_receive);
        this.B = (RelativeLayout) findViewById(com.chamsion.quickchat.R.id.rl_analog_monitor);
        this.E = (RelativeLayout) findViewById(com.chamsion.quickchat.R.id.rl_digital_cc);
        this.F = (RelativeLayout) findViewById(com.chamsion.quickchat.R.id.rl_digital_channel_mode);
        this.G = (RelativeLayout) findViewById(com.chamsion.quickchat.R.id.rl_digital_slot);
        this.H = (RelativeLayout) findViewById(com.chamsion.quickchat.R.id.rl_digital_contacts_type);
        this.I = (RelativeLayout) findViewById(com.chamsion.quickchat.R.id.rl_digital_contacts_number);
        this.J = (RelativeLayout) findViewById(com.chamsion.quickchat.R.id.rl_digital_encryption_switch);
        this.L = (RelativeLayout) findViewById(com.chamsion.quickchat.R.id.rl_digital_encryption);
        this.K = (RelativeLayout) findViewById(com.chamsion.quickchat.R.id.rl_digital_sms_type);
        this.U = (RecyclerView) findViewById(com.chamsion.quickchat.R.id.recyclerview_group_list);
        this.V = (RelativeLayout) findViewById(com.chamsion.quickchat.R.id.rl_group_list);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("what");
        boolean zEquals = stringExtra.equals("modify");
        final int i3 = 1;
        String str = this.f1260a;
        if (zEquals) {
            a aVar = (a) intent.getSerializableExtra("channel");
            this.X = aVar;
            this.Y = true;
            this.Z = aVar.f1942f;
            this.f1281k0 = aVar.f1952p;
            Log.e(str, "initView.......WHAT_MODIFY");
            a aVar2 = this.X;
            byte b2 = (byte) aVar2.C;
            if (b2 != 0) {
                i(b2, (byte) aVar2.D);
            }
            a aVar3 = this.X;
            byte b3 = (byte) aVar3.A;
            if (b3 != 0) {
                h(b3, (byte) aVar3.B);
            }
        } else if (stringExtra.equals("add")) {
            Log.e(str, "initView.......WHAT_ADD");
            this.O.setText("");
            this.P.setText("");
            this.M.setText("");
            this.f1268e.setVisibility(0);
            this.f1272g.setText(getResources().getString(com.chamsion.quickchat.R.string.add_new_channel));
            this.Y = false;
            h(0, -1);
            i(0, -1);
        }
        this.f1261a0 = (t) new ViewModelProvider(this).get(t.class);
        this.f1261a0.f2013a.a(getSharedPreferences(SPUtils.FILE_NAME, 0).getInt("curr_country_id", 1)).observe(this, new b(i, this));
        if (this.D0 == null) {
            this.D0 = (n) new ViewModelProvider(this).get(n.class);
        }
        this.D0.f2133b.observe(this, new e(this, i));
        this.f1264c.setOnClickListener(new View.OnClickListener(this) { // from class: p0.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AddNewChannelActivity f2281b;

            {
                this.f2281b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i4 = i;
                this.f2281b.onClick(view);
            }
        });
        this.f1266d.setOnClickListener(new View.OnClickListener(this) { // from class: p0.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AddNewChannelActivity f2281b;

            {
                this.f2281b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i4 = i3;
                this.f2281b.onClick(view);
            }
        });
        this.f1288o.setOnItemSelectedListener(new p0.c(this, i2));
        this.f1274h.setOnItemSelectedListener(new p0.c(this, 9));
        this.f1274h.setSelection(0);
        this.f1300u.setOnItemSelectedListener(new p0.c(this, 10));
        this.f1276i.setOnItemSelectedListener(new p0.c(this, 11));
        this.f1278j.setOnItemSelectedListener(new p0.c(this, 12));
        this.f1280k.setOnItemSelectedListener(new p0.c(this, 13));
        this.f1284m.setOnItemSelectedListener(new p0.c(this, 14));
        this.f1286n.setOnItemSelectedListener(new p0.c(this, 15));
        this.f1282l.setOnItemSelectedListener(new p0.c(this, i));
        this.f1302v.setOnItemSelectedListener(new p0.c(this, i3));
        int i4 = 2;
        this.f1304w.setOnItemSelectedListener(new p0.c(this, i4));
        int i5 = 3;
        this.f1292q.setOnItemSelectedListener(new p0.c(this, i5));
        this.f1294r.setOnItemSelectedListener(new p0.c(this, 4));
        this.f1296s.setOnItemSelectedListener(new p0.c(this, 5));
        this.f1298t.setOnItemSelectedListener(new p0.c(this, 6));
        this.M.addTextChangedListener(new d(this, i));
        this.f1290p.setOnItemSelectedListener(new p0.c(this, 7));
        this.O.addTextChangedListener(new d(this, i3));
        this.P.addTextChangedListener(new d(this, i4));
        this.S.setOnClickListener(new p0.g(this, i));
        this.N.addTextChangedListener(new d(this, i5));
        this.f1271f0 = new c();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(4);
        gridLayoutManager.setOrientation(1);
        this.U.setLayoutManager(gridLayoutManager);
        this.U.setAdapter(this.f1271f0);
        if (this.Y) {
            a aVar4 = this.X;
            Log.e(str, "updateModifyView,");
            this.f1272g.setText(getResources().getString(com.chamsion.quickchat.R.string.modify_channel));
            j(aVar4.f1941e);
            int i6 = aVar4.f1945i;
            if (i6 <= 480000000 && i6 >= 400000000) {
                this.f1290p.setSelection(0);
                I0 = 0;
            } else if (i6 <= 174000000 && i6 >= 136000000) {
                this.f1290p.setSelection(1);
                I0 = 1;
            }
            String str2 = aVar4.f1940d;
            this.f1267d0 = str2;
            if (TextUtils.isEmpty(str2)) {
                StringBuilder sb = new StringBuilder();
                sb.append(getResources().getString(aVar4.f1941e == 1 ? com.chamsion.quickchat.R.string.analog_channel : com.chamsion.quickchat.R.string.digital_channel));
                sb.append(aVar4.f1939c);
                this.f1267d0 = sb.toString();
            }
            int i7 = this.f1263b0;
            if (i7 == 1) {
                this.M.setText(this.f1267d0);
                this.f1274h.setSelection(aVar4.f1941e);
                this.O.setText(aVar4.f1945i + "");
                this.P.setText(aVar4.f1944h + "");
                this.f1276i.setSelection((byte) aVar4.f1961y);
                this.f1278j.setSelection((byte) aVar4.f1962z);
                this.f1280k.setSelection((byte) aVar4.C);
                this.f1282l.setSelection((byte) aVar4.A);
                Log.e(str, "updateModifyView , channel.getMonitor() = " + ((int) ((byte) aVar4.E)));
                this.f1304w.setSelection(((byte) aVar4.E) - 1);
                this.f1302v.setSelection(((byte) aVar4.f1949m) - 1);
            } else if (i7 == 0) {
                this.M.setText(this.f1267d0);
                this.f1274h.setSelection(aVar4.f1941e);
                this.O.setText(aVar4.f1945i + "");
                this.P.setText(aVar4.f1944h + "");
                this.f1292q.setSelection((byte) aVar4.f1954r);
                this.f1294r.setSelection(((byte) aVar4.f1957u) == 4 ? 1 : 0);
                this.f1296s.setSelection((byte) aVar4.f1955s);
                this.f1298t.setSelection((byte) aVar4.f1953q);
                this.S.setText(aVar4.f1952p + "");
                this.f1300u.setSelection(((byte) aVar4.f1958v) - 1);
                this.N.setText(aVar4.f1959w);
                this.f1302v.setSelection(((byte) aVar4.f1949m) - 1);
                this.f1298t.getSelectedItemPosition();
            }
            f(true);
        } else {
            Log.e(str, "updateAddView,");
            this.f1292q.setSelection(this.f1285m0);
            this.f1294r.setSelection(this.f1291p0 == 4 ? 1 : 0);
            this.f1296s.setSelection(this.f1287n0);
            this.f1298t.setSelection(this.f1283l0);
            this.f1300u.setSelection(this.f1293q0 - 1);
            this.f1304w.setSelection(this.B0 - 1);
            this.f1302v.setSelection(this.f1301u0 - 1);
            this.f1276i.setSelection(this.f1303v0);
            this.f1278j.setSelection(this.f1305w0);
            this.f1280k.setSelection(this.f1311z0);
            this.f1282l.setSelection(this.f1307x0);
            f(false);
        }
        Configuration configuration = getResources().getConfiguration();
        configuration.fontScale = 1.0f;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        displayMetrics.scaledDensity = displayMetrics.density;
        getResources().updateConfiguration(configuration, displayMetrics);
    }

    @Override // androidx.fragment.app.c0, android.app.Activity
    public final void onResume() {
        super.onResume();
        Log.d(this.f1260a, "onResume: ");
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.c0, android.app.Activity
    public final void onStop() {
        super.onStop();
    }
}
