package p0;

import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.chamsion.quickchat.App;
import com.chamsion.quickchat.R;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class e0 extends j0.b {

    /* renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f2304q = 0;

    /* renamed from: g, reason: collision with root package name */
    public final String f2305g = e0.class.getName();

    /* renamed from: h, reason: collision with root package name */
    public boolean f2306h;

    /* renamed from: i, reason: collision with root package name */
    public ImageView f2307i;

    /* renamed from: j, reason: collision with root package name */
    public RecyclerView f2308j;

    /* renamed from: k, reason: collision with root package name */
    public androidx.fragment.app.c0 f2309k;

    /* renamed from: l, reason: collision with root package name */
    public n0.d f2310l;

    /* renamed from: m, reason: collision with root package name */
    public n0.p f2311m;

    /* renamed from: n, reason: collision with root package name */
    public TextView f2312n;

    /* renamed from: o, reason: collision with root package name */
    public Dialog f2313o;

    /* renamed from: p, reason: collision with root package name */
    public k0.t f2314p;

    @Override // j0.b
    public final void e() {
        if (!this.f1895a || this.f2306h) {
            return;
        }
        this.f2306h = true;
        Log.d(this.f2305g, "init .... ");
        n0.d dVar = new n0.d(this.f2309k, new c0(this), new c0(this));
        this.f2310l = dVar;
        this.f2308j.setAdapter(dVar);
        this.f2308j.setLayoutManager(new LinearLayoutManager());
    }

    public final k0.a f() {
        RoomSQLiteQuery roomSQLiteQuery;
        int columnIndexOrThrow;
        int columnIndexOrThrow2;
        int columnIndexOrThrow3;
        int columnIndexOrThrow4;
        int columnIndexOrThrow5;
        int columnIndexOrThrow6;
        int columnIndexOrThrow7;
        int columnIndexOrThrow8;
        int columnIndexOrThrow9;
        int columnIndexOrThrow10;
        int columnIndexOrThrow11;
        int columnIndexOrThrow12;
        int columnIndexOrThrow13;
        int columnIndexOrThrow14;
        int i2;
        int i3;
        int iN = x0.g.N(this.f2309k, 1, "curr_country_id");
        k0.f fVar = (k0.f) this.f2314p.f2013a.f2012b;
        fVar.getClass();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM channels WHERE countryId = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, iN);
        RoomDatabase roomDatabase = fVar.f1977a;
        roomDatabase.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(roomDatabase, roomSQLiteQueryAcquire, false, null);
        try {
            columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "countryId");
            columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "channelIdInCountry");
            columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "channelName");
            columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "channelType");
            columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enbale");
            columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "smsType");
            columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rx_freq");
            columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tx_freq");
            columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power");
            columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pwrsave");
            columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "volume");
            columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "relay");
            columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "localId");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        } catch (Throwable th) {
            th = th;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
        try {
            int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "groupList");
            int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tx_contact");
            int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "contactType");
            int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cc");
            int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "inboundSlot");
            int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "outboundSlot");
            int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "channelMode");
            int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "encryptSw");
            int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "encryptKey");
            int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "mic");
            int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "band");
            int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "sq");
            int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rx_type");
            int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rx_subcode");
            int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tx_type");
            int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tx_subcode");
            int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "monitor");
            int i4 = columnIndexOrThrow14;
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                k0.a aVar = new k0.a();
                ArrayList arrayList2 = arrayList;
                aVar.f1937a = cursorQuery.getInt(columnIndexOrThrow);
                aVar.f1938b = cursorQuery.getInt(columnIndexOrThrow2);
                aVar.f1939c = cursorQuery.getInt(columnIndexOrThrow3);
                if (cursorQuery.isNull(columnIndexOrThrow4)) {
                    aVar.f1940d = null;
                } else {
                    aVar.f1940d = cursorQuery.getString(columnIndexOrThrow4);
                }
                aVar.f1941e = cursorQuery.getInt(columnIndexOrThrow5);
                aVar.f1942f = cursorQuery.getInt(columnIndexOrThrow6) != 0;
                aVar.f1943g = cursorQuery.getInt(columnIndexOrThrow7);
                aVar.f1944h = cursorQuery.getInt(columnIndexOrThrow8);
                aVar.f1945i = cursorQuery.getInt(columnIndexOrThrow9);
                aVar.f1946j = cursorQuery.getInt(columnIndexOrThrow10);
                aVar.f1947k = cursorQuery.getInt(columnIndexOrThrow11);
                aVar.f1948l = cursorQuery.getInt(columnIndexOrThrow12);
                aVar.f1949m = cursorQuery.getInt(columnIndexOrThrow13);
                int i5 = i4;
                int i6 = columnIndexOrThrow;
                aVar.f1950n = cursorQuery.getInt(i5);
                int i7 = columnIndexOrThrow15;
                if (cursorQuery.isNull(i7)) {
                    i2 = columnIndexOrThrow12;
                    aVar.f1951o = null;
                } else {
                    i2 = columnIndexOrThrow12;
                    aVar.f1951o = cursorQuery.getString(i7);
                }
                int i8 = columnIndexOrThrow16;
                aVar.f1952p = cursorQuery.getInt(i8);
                int i9 = columnIndexOrThrow17;
                aVar.f1953q = cursorQuery.getInt(i9);
                int i10 = columnIndexOrThrow18;
                aVar.f1954r = cursorQuery.getInt(i10);
                int i11 = columnIndexOrThrow19;
                aVar.f1955s = cursorQuery.getInt(i11);
                int i12 = columnIndexOrThrow20;
                aVar.f1956t = cursorQuery.getInt(i12);
                int i13 = columnIndexOrThrow21;
                aVar.f1957u = cursorQuery.getInt(i13);
                int i14 = columnIndexOrThrow22;
                aVar.f1958v = cursorQuery.getInt(i14);
                int i15 = columnIndexOrThrow23;
                if (cursorQuery.isNull(i15)) {
                    i3 = i14;
                    aVar.f1959w = null;
                } else {
                    i3 = i14;
                    aVar.f1959w = cursorQuery.getString(i15);
                }
                int i16 = columnIndexOrThrow24;
                aVar.f1960x = cursorQuery.getInt(i16);
                int i17 = columnIndexOrThrow25;
                aVar.f1961y = cursorQuery.getInt(i17);
                int i18 = columnIndexOrThrow26;
                aVar.f1962z = cursorQuery.getInt(i18);
                int i19 = columnIndexOrThrow27;
                aVar.A = cursorQuery.getInt(i19);
                int i20 = columnIndexOrThrow28;
                aVar.B = cursorQuery.getInt(i20);
                int i21 = columnIndexOrThrow29;
                aVar.C = cursorQuery.getInt(i21);
                int i22 = columnIndexOrThrow30;
                aVar.D = cursorQuery.getInt(i22);
                int i23 = columnIndexOrThrow31;
                aVar.E = cursorQuery.getInt(i23);
                arrayList2.add(aVar);
                columnIndexOrThrow31 = i23;
                columnIndexOrThrow = i6;
                i4 = i5;
                arrayList = arrayList2;
                columnIndexOrThrow12 = i2;
                columnIndexOrThrow15 = i7;
                columnIndexOrThrow16 = i8;
                columnIndexOrThrow17 = i9;
                columnIndexOrThrow18 = i10;
                columnIndexOrThrow19 = i11;
                columnIndexOrThrow20 = i12;
                columnIndexOrThrow21 = i13;
                columnIndexOrThrow22 = i3;
                columnIndexOrThrow23 = i15;
                columnIndexOrThrow24 = i16;
                columnIndexOrThrow25 = i17;
                columnIndexOrThrow26 = i18;
                columnIndexOrThrow27 = i19;
                columnIndexOrThrow28 = i20;
                columnIndexOrThrow29 = i21;
                columnIndexOrThrow30 = i22;
            }
            cursorQuery.close();
            roomSQLiteQuery.release();
            Iterator it = arrayList.iterator();
            k0.a aVar2 = null;
            while (it.hasNext()) {
                k0.a aVar3 = (k0.a) it.next();
                if (aVar3.f1942f) {
                    aVar2 = aVar3;
                }
            }
            return aVar2;
        } catch (Throwable th2) {
            th = th2;
            cursorQuery.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f1899e == null) {
            this.f1899e = layoutInflater.inflate(R.layout.fragment_message, viewGroup, false);
        }
        this.f1899e.setBackground(getResources().getDrawable(R.color.black));
        ViewGroup viewGroup2 = (ViewGroup) this.f1899e.getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(this.f1899e);
        }
        this.f2309k = getActivity();
        return this.f1899e;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((TextView) view.findViewById(R.id.tv_title)).setText(getResources().getString(R.string.rb_message));
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_add);
        this.f2307i = imageView;
        int i2 = 0;
        imageView.setVisibility(0);
        this.f2308j = (RecyclerView) view.findViewById(R.id.recycler_message);
        this.f2312n = (TextView) view.findViewById(R.id.tv_no_message);
        this.f2307i.setOnClickListener(new k0.y(5, this));
        setUserVisibleHint(true);
        if (this.f2311m == null) {
            this.f2311m = (n0.p) new ViewModelProvider(this).get(n0.p.class);
        }
        n0.o oVar = this.f2311m.f2192a;
        oVar.getClass();
        int iN = x0.g.N(App.f1233b, 1, "pref_person_device_id");
        n0.i iVar = oVar.f2191a;
        iVar.getClass();
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT CASE    WHEN messageType = 1 THEN groupId    ELSE (CASE WHEN senderId < receiverId THEN                senderId || '_' || receiverId            ELSE                receiverId || '_' || senderId            END) END AS conversationId, messageType AS conversationType, CASE    WHEN messageType = 1 THEN groupName    ELSE (CASE WHEN senderId = ? THEN                receiverName            ELSE                senderName            END) END AS name, (SELECT message FROM message_table  WHERE (CASE            WHEN messageType = 1 THEN groupId ELSE (CASE WHEN senderId < receiverId THEN senderId || '_' || receiverId ELSE receiverId || '_' || senderId END)        END) =        (CASE            WHEN message_table_main.messageType = 1 THEN message_table_main.groupId ELSE (CASE WHEN message_table_main.senderId < message_table_main.receiverId THEN message_table_main.senderId || '_' || message_table_main.receiverId ELSE message_table_main.receiverId || '_' || message_table_main.senderId END)        END)  AND messageType = message_table_main.messageType  ORDER BY timestamp DESC LIMIT 1) AS lastMessage, (SELECT channelIndex FROM message_table  WHERE (CASE            WHEN messageType = 1 THEN groupId ELSE (CASE WHEN senderId < receiverId THEN senderId || '_' || receiverId ELSE receiverId || '_' || senderId END)        END) =        (CASE            WHEN message_table_main.messageType = 1 THEN message_table_main.groupId ELSE (CASE WHEN message_table_main.senderId < message_table_main.receiverId THEN message_table_main.senderId || '_' || message_table_main.receiverId ELSE message_table_main.receiverId || '_' || message_table_main.senderId END)        END)  AND messageType = message_table_main.messageType  ORDER BY timestamp DESC LIMIT 1) AS channelId, MAX(timestamp) AS lastMessageTime, (SELECT avatarData FROM message_table  WHERE (CASE            WHEN messageType = 1 THEN groupId ELSE (CASE WHEN senderId < receiverId THEN senderId || '_' || receiverId ELSE receiverId || '_' || senderId END)        END) =        (CASE            WHEN message_table_main.messageType = 1 THEN message_table_main.groupId ELSE (CASE WHEN message_table_main.senderId < message_table_main.receiverId THEN message_table_main.senderId || '_' || message_table_main.receiverId ELSE message_table_main.receiverId || '_' || message_table_main.senderId END)        END)  AND messageType = message_table_main.messageType  ORDER BY timestamp DESC LIMIT 1) AS avatarData FROM message_table AS message_table_main GROUP BY    CASE        WHEN messageType = 1 THEN groupId        ELSE (CASE WHEN senderId < receiverId THEN senderId || '_' || receiverId ELSE receiverId || '_' || senderId END)    END,    messageType ORDER BY lastMessageTime DESC", 1);
        roomSQLiteQueryAcquire.bindLong(1, iN);
        iVar.f2175a.getInvalidationTracker().createLiveData(new String[]{"message_table"}, false, new n0.f(iVar, roomSQLiteQueryAcquire, i2)).observe(this, new b(6, this));
        this.f2314p = (k0.t) new ViewModelProvider(this).get(k0.t.class);
    }
}
