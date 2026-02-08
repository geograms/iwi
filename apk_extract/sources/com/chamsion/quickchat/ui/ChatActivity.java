package com.chamsion.quickchat.ui;

import a.c;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomSQLiteQuery;
import com.chamsion.quickchat.R;
import java.util.ArrayList;
import m0.a;
import n0.f;
import n0.i;
import n0.n;
import n0.p;
import p0.e;
import p0.g;
import p0.m;

/* loaded from: classes.dex */
public class ChatActivity extends AppCompatActivity {

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f1335n = 0;

    /* renamed from: b, reason: collision with root package name */
    public ChatActivity f1337b;

    /* renamed from: c, reason: collision with root package name */
    public EditText f1338c;

    /* renamed from: d, reason: collision with root package name */
    public RecyclerView f1339d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f1340e;

    /* renamed from: h, reason: collision with root package name */
    public LinearLayoutManager f1343h;

    /* renamed from: a, reason: collision with root package name */
    public final String f1336a = ChatActivity.class.getName();

    /* renamed from: f, reason: collision with root package name */
    public int f1341f = -1;

    /* renamed from: g, reason: collision with root package name */
    public a f1342g = null;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f1344i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public boolean f1345j = true;

    /* renamed from: k, reason: collision with root package name */
    public final g f1346k = new g(this, 1);

    /* renamed from: l, reason: collision with root package name */
    public p f1347l = null;

    /* renamed from: m, reason: collision with root package name */
    public Handler f1348m = null;

    @Override // androidx.fragment.app.c0, androidx.activity.h, h.l, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_chat);
        this.f1337b = this;
        TextView textView = (TextView) findViewById(R.id.btn_send);
        g gVar = this.f1346k;
        textView.setOnClickListener(gVar);
        this.f1340e = (TextView) findViewById(R.id.tv_title);
        ((ImageView) findViewById(R.id.iv_close)).setOnClickListener(gVar);
        this.f1339d = (RecyclerView) findViewById(R.id.msg_recyclerview);
        this.f1338c = (EditText) findViewById(R.id.et_msg);
        this.f1341f = ((Integer) x0.g.J(this.f1337b, "local_id", 1)).intValue();
        this.f1348m = new Handler(new c(1, this));
        this.f1342g = (a) getIntent().getSerializableExtra("chat");
        this.f1340e.setText(this.f1342g.f2092c + "(" + this.f1342g.f2093d + ")");
        this.f1339d.setAdapter(new n(this, new m()));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        this.f1343h = linearLayoutManager;
        this.f1339d.setLayoutManager(linearLayoutManager);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.c0, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        Handler handler = this.f1348m;
        if (handler != null) {
            handler.removeCallbacksAndMessages(this);
        }
    }

    @Override // androidx.fragment.app.c0, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (this.f1347l == null) {
            this.f1347l = (p) new ViewModelProvider(this).get(p.class);
        }
        Log.d(this.f1336a, "roomMessageObserve,TYPE_PERSON, ID:" + this.f1342g.f2093d + " type " + this.f1342g.f2091b);
        p pVar = this.f1347l;
        a aVar = this.f1342g;
        int i2 = aVar.f2093d;
        int i3 = aVar.f2091b;
        i iVar = pVar.f2192a.f2191a;
        iVar.getClass();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM message_table WHERE senderId = ? AND messageType = ?", 2);
        roomSQLiteQueryAcquire.bindLong(1, i2);
        roomSQLiteQueryAcquire.bindLong(2, i3);
        iVar.f2175a.getInvalidationTracker().createLiveData(new String[]{"message_table"}, false, new f(iVar, roomSQLiteQueryAcquire, 3)).observe(this, new e(this, 1));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.c0, android.app.Activity
    public final void onStop() {
        super.onStop();
        this.f1345j = true;
    }
}
