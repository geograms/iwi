package n0;

import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class f implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2170a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RoomSQLiteQuery f2171b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ i f2172c;

    public /* synthetic */ f(i iVar, RoomSQLiteQuery roomSQLiteQuery, int i2) {
        this.f2170a = i2;
        this.f2172c = iVar;
        this.f2171b = roomSQLiteQuery;
    }

    public final ArrayList a() {
        Cursor cursorQuery;
        int i2 = this.f2170a;
        RoomSQLiteQuery roomSQLiteQuery = this.f2171b;
        i iVar = this.f2172c;
        switch (i2) {
            case 0:
                cursorQuery = DBUtil.query(iVar.f2175a, roomSQLiteQuery, false, null);
                try {
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        a aVar = new a();
                        aVar.f2138a = cursorQuery.getInt(0);
                        aVar.f2139b = cursorQuery.getInt(1);
                        aVar.f2140c = cursorQuery.isNull(2) ? null : cursorQuery.getString(2);
                        aVar.f2141d = cursorQuery.isNull(3) ? null : cursorQuery.getString(3);
                        aVar.f2144g = cursorQuery.getInt(4);
                        aVar.f2142e = cursorQuery.getLong(5);
                        aVar.f2143f = cursorQuery.isNull(6) ? null : cursorQuery.getBlob(6);
                        arrayList.add(aVar);
                    }
                    return arrayList;
                } finally {
                }
            case 1:
                cursorQuery = DBUtil.query(iVar.f2175a, roomSQLiteQuery, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "channelIndex");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "senderId");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "senderName");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "receiverId");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "groupId");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "groupName");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "message");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "messageType");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "messageDirection");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "avatarData");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "receiverName");
                    ArrayList arrayList2 = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        e eVar = new e();
                        ArrayList arrayList3 = arrayList2;
                        eVar.f2157a = cursorQuery.getInt(columnIndexOrThrow);
                        eVar.f2158b = cursorQuery.getInt(columnIndexOrThrow2);
                        eVar.f2159c = cursorQuery.getInt(columnIndexOrThrow3);
                        eVar.f2160d = cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4);
                        eVar.f2161e = cursorQuery.getInt(columnIndexOrThrow5);
                        eVar.f2162f = cursorQuery.getInt(columnIndexOrThrow6);
                        eVar.f2163g = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                        eVar.f2164h = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getString(columnIndexOrThrow8);
                        int i3 = columnIndexOrThrow8;
                        int i4 = columnIndexOrThrow7;
                        eVar.f2165i = cursorQuery.getLong(columnIndexOrThrow9);
                        eVar.f2166j = cursorQuery.getInt(columnIndexOrThrow10);
                        eVar.f2167k = cursorQuery.getInt(columnIndexOrThrow11);
                        eVar.f2168l = cursorQuery.isNull(columnIndexOrThrow12) ? null : cursorQuery.getBlob(columnIndexOrThrow12);
                        eVar.f2169m = cursorQuery.isNull(columnIndexOrThrow13) ? null : cursorQuery.getString(columnIndexOrThrow13);
                        arrayList3.add(eVar);
                        columnIndexOrThrow7 = i4;
                        arrayList2 = arrayList3;
                        columnIndexOrThrow8 = i3;
                    }
                    return arrayList2;
                } finally {
                }
            case 2:
                cursorQuery = DBUtil.query(iVar.f2175a, roomSQLiteQuery, false, null);
                try {
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "channelIndex");
                    int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "senderId");
                    int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "senderName");
                    int columnIndexOrThrow18 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "receiverId");
                    int columnIndexOrThrow19 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "groupId");
                    int columnIndexOrThrow20 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "groupName");
                    int columnIndexOrThrow21 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "message");
                    int columnIndexOrThrow22 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                    int columnIndexOrThrow23 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "messageType");
                    int columnIndexOrThrow24 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "messageDirection");
                    int columnIndexOrThrow25 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "avatarData");
                    int columnIndexOrThrow26 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "receiverName");
                    ArrayList arrayList4 = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        e eVar2 = new e();
                        ArrayList arrayList5 = arrayList4;
                        eVar2.f2157a = cursorQuery.getInt(columnIndexOrThrow14);
                        eVar2.f2158b = cursorQuery.getInt(columnIndexOrThrow15);
                        eVar2.f2159c = cursorQuery.getInt(columnIndexOrThrow16);
                        eVar2.f2160d = cursorQuery.isNull(columnIndexOrThrow17) ? null : cursorQuery.getString(columnIndexOrThrow17);
                        eVar2.f2161e = cursorQuery.getInt(columnIndexOrThrow18);
                        eVar2.f2162f = cursorQuery.getInt(columnIndexOrThrow19);
                        eVar2.f2163g = cursorQuery.isNull(columnIndexOrThrow20) ? null : cursorQuery.getString(columnIndexOrThrow20);
                        eVar2.f2164h = cursorQuery.isNull(columnIndexOrThrow21) ? null : cursorQuery.getString(columnIndexOrThrow21);
                        int i5 = columnIndexOrThrow21;
                        int i6 = columnIndexOrThrow20;
                        eVar2.f2165i = cursorQuery.getLong(columnIndexOrThrow22);
                        eVar2.f2166j = cursorQuery.getInt(columnIndexOrThrow23);
                        eVar2.f2167k = cursorQuery.getInt(columnIndexOrThrow24);
                        eVar2.f2168l = cursorQuery.isNull(columnIndexOrThrow25) ? null : cursorQuery.getBlob(columnIndexOrThrow25);
                        eVar2.f2169m = cursorQuery.isNull(columnIndexOrThrow26) ? null : cursorQuery.getString(columnIndexOrThrow26);
                        arrayList5.add(eVar2);
                        columnIndexOrThrow20 = i6;
                        arrayList4 = arrayList5;
                        columnIndexOrThrow21 = i5;
                    }
                    return arrayList4;
                } finally {
                }
            default:
                cursorQuery = DBUtil.query(iVar.f2175a, roomSQLiteQuery, false, null);
                try {
                    int columnIndexOrThrow27 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow28 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "channelIndex");
                    int columnIndexOrThrow29 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "senderId");
                    int columnIndexOrThrow30 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "senderName");
                    int columnIndexOrThrow31 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "receiverId");
                    int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "groupId");
                    int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "groupName");
                    int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "message");
                    int columnIndexOrThrow35 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
                    int columnIndexOrThrow36 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "messageType");
                    int columnIndexOrThrow37 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "messageDirection");
                    int columnIndexOrThrow38 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "avatarData");
                    int columnIndexOrThrow39 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "receiverName");
                    ArrayList arrayList6 = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        e eVar3 = new e();
                        ArrayList arrayList7 = arrayList6;
                        eVar3.f2157a = cursorQuery.getInt(columnIndexOrThrow27);
                        eVar3.f2158b = cursorQuery.getInt(columnIndexOrThrow28);
                        eVar3.f2159c = cursorQuery.getInt(columnIndexOrThrow29);
                        eVar3.f2160d = cursorQuery.isNull(columnIndexOrThrow30) ? null : cursorQuery.getString(columnIndexOrThrow30);
                        eVar3.f2161e = cursorQuery.getInt(columnIndexOrThrow31);
                        eVar3.f2162f = cursorQuery.getInt(columnIndexOrThrow32);
                        eVar3.f2163g = cursorQuery.isNull(columnIndexOrThrow33) ? null : cursorQuery.getString(columnIndexOrThrow33);
                        eVar3.f2164h = cursorQuery.isNull(columnIndexOrThrow34) ? null : cursorQuery.getString(columnIndexOrThrow34);
                        int i7 = columnIndexOrThrow27;
                        int i8 = columnIndexOrThrow28;
                        eVar3.f2165i = cursorQuery.getLong(columnIndexOrThrow35);
                        eVar3.f2166j = cursorQuery.getInt(columnIndexOrThrow36);
                        eVar3.f2167k = cursorQuery.getInt(columnIndexOrThrow37);
                        eVar3.f2168l = cursorQuery.isNull(columnIndexOrThrow38) ? null : cursorQuery.getBlob(columnIndexOrThrow38);
                        eVar3.f2169m = cursorQuery.isNull(columnIndexOrThrow39) ? null : cursorQuery.getString(columnIndexOrThrow39);
                        arrayList7.add(eVar3);
                        columnIndexOrThrow28 = i8;
                        arrayList6 = arrayList7;
                        columnIndexOrThrow27 = i7;
                    }
                    return arrayList6;
                } finally {
                }
        }
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        switch (this.f2170a) {
        }
        return a();
    }

    public final void finalize() {
        int i2 = this.f2170a;
        RoomSQLiteQuery roomSQLiteQuery = this.f2171b;
        switch (i2) {
            case 0:
                roomSQLiteQuery.release();
                break;
            case 1:
                roomSQLiteQuery.release();
                break;
            case 2:
                roomSQLiteQuery.release();
                break;
            default:
                roomSQLiteQuery.release();
                break;
        }
    }
}
