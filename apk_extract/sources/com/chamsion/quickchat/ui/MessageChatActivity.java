package com.chamsion.quickchat.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomSQLiteQuery;
import com.chamsion.quickchat.R;
import com.chamsion.quickchat.ui.MessageChatActivity;
import com.wonder.dmr.DmrManager;
import com.wonder.dmr.utils.SPUtils;
import k.j;
import k0.a;
import k0.e;
import k0.t;
import n0.f;
import n0.i;
import n0.n;
import n0.o;
import n0.p;
import p0.u0;
import p0.v0;
import x0.g;

/* loaded from: classes.dex */
public class MessageChatActivity extends AppCompatActivity {

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f1437o = 0;

    /* renamed from: b, reason: collision with root package name */
    public MessageChatActivity f1439b;

    /* renamed from: c, reason: collision with root package name */
    public EditText f1440c;

    /* renamed from: d, reason: collision with root package name */
    public RecyclerView f1441d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f1442e;

    /* renamed from: l, reason: collision with root package name */
    public n f1449l;

    /* renamed from: a, reason: collision with root package name */
    public final String f1438a = MessageChatActivity.class.getName();

    /* renamed from: f, reason: collision with root package name */
    public int f1443f = -1;

    /* renamed from: g, reason: collision with root package name */
    public a f1444g = null;

    /* renamed from: h, reason: collision with root package name */
    public int f1445h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f1446i = -1;

    /* renamed from: j, reason: collision with root package name */
    public int f1447j = 1;

    /* renamed from: k, reason: collision with root package name */
    public p f1448k = null;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1450m = true;

    /* renamed from: n, reason: collision with root package name */
    public Handler f1451n = null;

    public final void d() {
        p pVar = (p) new ViewModelProvider(this).get(p.class);
        this.f1448k = pVar;
        int i2 = this.f1445h;
        int i3 = this.f1446i;
        o oVar = pVar.f2192a;
        int i4 = 2;
        int i5 = 1;
        if (i3 == 0) {
            int iN = g.N(pVar.f2194c, 1, "pref_person_device_id");
            i iVar = oVar.f2191a;
            iVar.getClass();
            RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM message_table WHERE messageType = 0 AND ((senderId = ? AND receiverId = ?) OR (senderId = ? AND receiverId = ?)) ORDER BY timestamp ASC", 4);
            long j2 = iN;
            roomSQLiteQueryAcquire.bindLong(1, j2);
            long j3 = i2;
            roomSQLiteQueryAcquire.bindLong(2, j3);
            roomSQLiteQueryAcquire.bindLong(3, j3);
            roomSQLiteQueryAcquire.bindLong(4, j2);
            pVar.f2193b = iVar.f2175a.getInvalidationTracker().createLiveData(new String[]{"message_table"}, false, new f(iVar, roomSQLiteQueryAcquire, i5));
        } else {
            i iVar2 = oVar.f2191a;
            iVar2.getClass();
            RoomSQLiteQuery roomSQLiteQueryAcquire2 = RoomSQLiteQuery.acquire("SELECT * FROM message_table WHERE groupId = ?", 1);
            roomSQLiteQueryAcquire2.bindLong(1, i2);
            pVar.f2193b = iVar2.f2175a.getInvalidationTracker().createLiveData(new String[]{"message_table"}, false, new f(iVar2, roomSQLiteQueryAcquire2, i4));
        }
        this.f1448k.f2193b.observe(this, new v0(this, i4));
    }

    @Override // androidx.fragment.app.c0, androidx.activity.h, h.l, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_message_chat);
        this.f1439b = this;
        final int i2 = 0;
        ((ImageView) findViewById(R.id.iv_send)).setOnClickListener(new View.OnClickListener(this) { // from class: p0.w0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MessageChatActivity f2462b;

            {
                this.f2462b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3 = i2;
                MessageChatActivity messageChatActivity = this.f2462b;
                switch (i3) {
                    case 0:
                        if (messageChatActivity.f1450m) {
                            String str = new String(messageChatActivity.f1440c.getText().toString().getBytes());
                            if (!TextUtils.isEmpty(str)) {
                                int i4 = messageChatActivity.f1444g.f1952p;
                                Log.d("MessageChatActivity", " sendMessage 146: " + i4 + "       " + messageChatActivity.f1447j + "       " + str + "       " + messageChatActivity.f1443f + "       " + ((int) ((byte) messageChatActivity.f1444g.f1953q)) + "       " + messageChatActivity.f1444g.f1943g);
                                DmrManager.getInstance().sendMsg(messageChatActivity.f1444g.f1943g, messageChatActivity.f1443f, str, new g0(messageChatActivity, str, i4));
                                Handler handler = messageChatActivity.f1451n;
                                if (handler != null) {
                                    handler.sendEmptyMessageDelayed(256, 1500L);
                                }
                                messageChatActivity.f1450m = false;
                                break;
                            }
                        }
                        break;
                    default:
                        int i5 = MessageChatActivity.f1437o;
                        messageChatActivity.finish();
                        break;
                }
            }
        });
        this.f1442e = (TextView) findViewById(R.id.tv_title);
        final int i3 = 1;
        ((ImageView) findViewById(R.id.iv_close)).setOnClickListener(new View.OnClickListener(this) { // from class: p0.w0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MessageChatActivity f2462b;

            {
                this.f2462b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i32 = i3;
                MessageChatActivity messageChatActivity = this.f2462b;
                switch (i32) {
                    case 0:
                        if (messageChatActivity.f1450m) {
                            String str = new String(messageChatActivity.f1440c.getText().toString().getBytes());
                            if (!TextUtils.isEmpty(str)) {
                                int i4 = messageChatActivity.f1444g.f1952p;
                                Log.d("MessageChatActivity", " sendMessage 146: " + i4 + "       " + messageChatActivity.f1447j + "       " + str + "       " + messageChatActivity.f1443f + "       " + ((int) ((byte) messageChatActivity.f1444g.f1953q)) + "       " + messageChatActivity.f1444g.f1943g);
                                DmrManager.getInstance().sendMsg(messageChatActivity.f1444g.f1943g, messageChatActivity.f1443f, str, new g0(messageChatActivity, str, i4));
                                Handler handler = messageChatActivity.f1451n;
                                if (handler != null) {
                                    handler.sendEmptyMessageDelayed(256, 1500L);
                                }
                                messageChatActivity.f1450m = false;
                                break;
                            }
                        }
                        break;
                    default:
                        int i5 = MessageChatActivity.f1437o;
                        messageChatActivity.finish();
                        break;
                }
            }
        });
        this.f1441d = (RecyclerView) findViewById(R.id.msg_recyclerview);
        this.f1440c = (EditText) findViewById(R.id.et_msg);
        this.f1443f = ((Integer) g.J(this.f1439b, "local_id", 1)).intValue();
        this.f1451n = new Handler(new Handler.Callback() { // from class: p0.x0
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                int i4 = MessageChatActivity.f1437o;
                MessageChatActivity messageChatActivity = this.f2465a;
                messageChatActivity.getClass();
                if (message.what != 256) {
                    return false;
                }
                messageChatActivity.f1450m = true;
                return false;
            }
        });
        Intent intent = getIntent();
        this.f1445h = intent.getIntExtra("targetId", -1);
        this.f1446i = intent.getIntExtra("msgType", -1);
        this.f1447j = intent.getIntExtra("channelId", -1);
        Log.i(this.f1438a, "getMessageEncode , mIndex = " + this.f1445h + " ,mSmsType = " + this.f1446i + " ,mChannelId = " + this.f1447j);
        this.f1442e.setText("");
        n nVar = new n(this, new j(19, this));
        this.f1449l = nVar;
        this.f1441d.setAdapter(nVar);
        this.f1441d.setLayoutManager(new LinearLayoutManager());
        this.f1440c.setOnFocusChangeListener(new u0());
        t tVar = (t) new ViewModelProvider(this).get(t.class);
        int i4 = this.f1447j;
        if (i4 == -1) {
            if (this.f1444g == null) {
                tVar.f2013a.a(getSharedPreferences(SPUtils.FILE_NAME, 0).getInt("curr_country_id", 1)).observe(this, new v0(this, i3));
                return;
            }
            return;
        }
        k0.f fVar = (k0.f) tVar.f2013a.f2012b;
        fVar.getClass();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM channels WHERE id = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, i4);
        fVar.f1977a.getInvalidationTracker().createLiveData(new String[]{"channels"}, false, new e(fVar, roomSQLiteQueryAcquire, i3)).observe(this, new v0(this, i2));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.c0, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        Handler handler = this.f1451n;
        if (handler != null) {
            handler.removeCallbacksAndMessages(this);
        }
    }

    @Override // androidx.fragment.app.c0, android.app.Activity
    public final void onResume() {
        super.onResume();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.c0, android.app.Activity
    public final void onStop() {
        super.onStop();
        this.f1450m = true;
    }
}
