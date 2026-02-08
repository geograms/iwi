package k0;

import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class e implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1974a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RoomSQLiteQuery f1975b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1976c;

    public /* synthetic */ e(Object obj, RoomSQLiteQuery roomSQLiteQuery, int i2) {
        this.f1974a = i2;
        this.f1976c = obj;
        this.f1975b = roomSQLiteQuery;
    }

    public final ArrayList a() {
        Cursor cursorQuery;
        int i2;
        int i3;
        int i4 = this.f1974a;
        RoomSQLiteQuery roomSQLiteQuery = this.f1975b;
        Object obj = this.f1976c;
        switch (i4) {
            case 0:
                cursorQuery = DBUtil.query(((f) obj).f1977a, roomSQLiteQuery, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "countryId");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "channelIdInCountry");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "channelName");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "channelType");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enbale");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "smsType");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rx_freq");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tx_freq");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pwrsave");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "volume");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "relay");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "localId");
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
                    int i5 = columnIndexOrThrow14;
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        a aVar = new a();
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
                        int i6 = i5;
                        int i7 = columnIndexOrThrow;
                        aVar.f1950n = cursorQuery.getInt(i6);
                        int i8 = columnIndexOrThrow15;
                        if (cursorQuery.isNull(i8)) {
                            i2 = columnIndexOrThrow13;
                            aVar.f1951o = null;
                        } else {
                            i2 = columnIndexOrThrow13;
                            aVar.f1951o = cursorQuery.getString(i8);
                        }
                        int i9 = columnIndexOrThrow16;
                        aVar.f1952p = cursorQuery.getInt(i9);
                        int i10 = columnIndexOrThrow17;
                        aVar.f1953q = cursorQuery.getInt(i10);
                        int i11 = columnIndexOrThrow18;
                        aVar.f1954r = cursorQuery.getInt(i11);
                        int i12 = columnIndexOrThrow19;
                        aVar.f1955s = cursorQuery.getInt(i12);
                        int i13 = columnIndexOrThrow20;
                        aVar.f1956t = cursorQuery.getInt(i13);
                        int i14 = columnIndexOrThrow21;
                        aVar.f1957u = cursorQuery.getInt(i14);
                        int i15 = columnIndexOrThrow22;
                        aVar.f1958v = cursorQuery.getInt(i15);
                        int i16 = columnIndexOrThrow23;
                        if (cursorQuery.isNull(i16)) {
                            i3 = i15;
                            aVar.f1959w = null;
                        } else {
                            i3 = i15;
                            aVar.f1959w = cursorQuery.getString(i16);
                        }
                        int i17 = columnIndexOrThrow24;
                        aVar.f1960x = cursorQuery.getInt(i17);
                        int i18 = columnIndexOrThrow25;
                        aVar.f1961y = cursorQuery.getInt(i18);
                        int i19 = columnIndexOrThrow26;
                        aVar.f1962z = cursorQuery.getInt(i19);
                        int i20 = columnIndexOrThrow27;
                        aVar.A = cursorQuery.getInt(i20);
                        int i21 = columnIndexOrThrow28;
                        aVar.B = cursorQuery.getInt(i21);
                        int i22 = columnIndexOrThrow29;
                        aVar.C = cursorQuery.getInt(i22);
                        int i23 = columnIndexOrThrow30;
                        aVar.D = cursorQuery.getInt(i23);
                        int i24 = columnIndexOrThrow31;
                        aVar.E = cursorQuery.getInt(i24);
                        arrayList2.add(aVar);
                        columnIndexOrThrow13 = i2;
                        columnIndexOrThrow15 = i8;
                        columnIndexOrThrow16 = i9;
                        columnIndexOrThrow17 = i10;
                        columnIndexOrThrow18 = i11;
                        columnIndexOrThrow19 = i12;
                        columnIndexOrThrow20 = i13;
                        columnIndexOrThrow21 = i14;
                        columnIndexOrThrow22 = i3;
                        columnIndexOrThrow23 = i16;
                        columnIndexOrThrow24 = i17;
                        columnIndexOrThrow25 = i18;
                        columnIndexOrThrow26 = i19;
                        columnIndexOrThrow27 = i20;
                        columnIndexOrThrow28 = i21;
                        columnIndexOrThrow29 = i22;
                        columnIndexOrThrow30 = i23;
                        columnIndexOrThrow31 = i24;
                        columnIndexOrThrow = i7;
                        i5 = i6;
                        arrayList = arrayList2;
                    }
                    return arrayList;
                } catch (Throwable th) {
                    throw th;
                }
            default:
                cursorQuery = DBUtil.query(((x) obj).f2022a, roomSQLiteQuery, false, null);
                try {
                    int columnIndexOrThrow32 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow33 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "countryCode");
                    int columnIndexOrThrow34 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isSelected");
                    ArrayList arrayList3 = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        u uVar = new u(cursorQuery.isNull(columnIndexOrThrow33) ? null : cursorQuery.getString(columnIndexOrThrow33));
                        uVar.f2016a = cursorQuery.getInt(columnIndexOrThrow32);
                        uVar.f2018c = cursorQuery.getInt(columnIndexOrThrow34) != 0;
                        arrayList3.add(uVar);
                    }
                    return arrayList3;
                } finally {
                    cursorQuery.close();
                }
        }
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        a aVar;
        switch (this.f1974a) {
            case 0:
                return a();
            case 1:
                Cursor cursorQuery = DBUtil.query(((f) this.f1976c).f1977a, this.f1975b, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "countryId");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "channelIdInCountry");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "channelName");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "channelType");
                    int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "enbale");
                    int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "smsType");
                    int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "rx_freq");
                    int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "tx_freq");
                    int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "power");
                    int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "pwrsave");
                    int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "volume");
                    int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "relay");
                    int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "localId");
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
                    if (cursorQuery.moveToFirst()) {
                        aVar = new a();
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
                        aVar.f1950n = cursorQuery.getInt(columnIndexOrThrow14);
                        if (cursorQuery.isNull(columnIndexOrThrow15)) {
                            aVar.f1951o = null;
                        } else {
                            aVar.f1951o = cursorQuery.getString(columnIndexOrThrow15);
                        }
                        aVar.f1952p = cursorQuery.getInt(columnIndexOrThrow16);
                        aVar.f1953q = cursorQuery.getInt(columnIndexOrThrow17);
                        aVar.f1954r = cursorQuery.getInt(columnIndexOrThrow18);
                        aVar.f1955s = cursorQuery.getInt(columnIndexOrThrow19);
                        aVar.f1956t = cursorQuery.getInt(columnIndexOrThrow20);
                        aVar.f1957u = cursorQuery.getInt(columnIndexOrThrow21);
                        aVar.f1958v = cursorQuery.getInt(columnIndexOrThrow22);
                        if (cursorQuery.isNull(columnIndexOrThrow23)) {
                            aVar.f1959w = null;
                        } else {
                            aVar.f1959w = cursorQuery.getString(columnIndexOrThrow23);
                        }
                        aVar.f1960x = cursorQuery.getInt(columnIndexOrThrow24);
                        aVar.f1961y = cursorQuery.getInt(columnIndexOrThrow25);
                        aVar.f1962z = cursorQuery.getInt(columnIndexOrThrow26);
                        aVar.A = cursorQuery.getInt(columnIndexOrThrow27);
                        aVar.B = cursorQuery.getInt(columnIndexOrThrow28);
                        aVar.C = cursorQuery.getInt(columnIndexOrThrow29);
                        aVar.D = cursorQuery.getInt(columnIndexOrThrow30);
                        aVar.E = cursorQuery.getInt(columnIndexOrThrow31);
                    } else {
                        aVar = null;
                    }
                    cursorQuery.close();
                    return aVar;
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            default:
                return a();
        }
    }

    public final void finalize() {
        int i2 = this.f1974a;
        RoomSQLiteQuery roomSQLiteQuery = this.f1975b;
        switch (i2) {
            case 0:
                roomSQLiteQuery.release();
                break;
            case 1:
                roomSQLiteQuery.release();
                break;
            default:
                roomSQLiteQuery.release();
                break;
        }
    }
}
