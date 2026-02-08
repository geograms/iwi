package k0;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.AsyncTask;
import android.util.Log;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import com.chamsion.quickchat.App;
import com.chamsion.quickchat.db.channel.ChannelDatabase;

/* loaded from: classes.dex */
public final class g extends AsyncTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1983a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f1984b;

    public /* synthetic */ g(h hVar, int i2) {
        this.f1983a = i2;
        this.f1984b = hVar;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) throws Resources.NotFoundException {
        a aVarA;
        u uVar;
        String str;
        a aVarA2;
        String[][] strArr = h.f1985b;
        int i2 = this.f1983a;
        h hVar = this.f1984b;
        switch (i2) {
            case 0:
                ChannelDatabase.c(App.f1233b).b().a();
                ChannelDatabase.c(App.f1233b).a().a();
                for (int i3 = 0; i3 < 14; i3++) {
                    String[] strArr2 = strArr[i3];
                    String str2 = strArr2[0];
                    String str3 = strArr2[1];
                    int iB = (int) ChannelDatabase.c(App.f1233b).b().b(new u(str2));
                    Resources resources = hVar.f1986a.getResources();
                    Context context = hVar.f1986a;
                    int identifier = resources.getIdentifier(str3, "array", context.getPackageName());
                    if (identifier != 0) {
                        int[] intArray = context.getResources().getIntArray(identifier);
                        for (int i4 = 1; i4 <= intArray.length; i4++) {
                            int i5 = intArray[i4 - 1];
                            if ((str3.contains("uhf") || str3.contains("vhf")) && i4 <= 8) {
                                a aVar = new a();
                                aVar.f1941e = 0;
                                aVar.f1945i = i5;
                                aVar.f1944h = i5;
                                aVarA = aVar;
                            } else {
                                aVarA = h.a(hVar, i5, i5);
                            }
                            aVarA.f1938b = iB;
                            aVarA.f1939c = i4;
                            if (iB == 1 && i4 == 1) {
                                aVarA.f1942f = true;
                            }
                            ChannelDatabase.c(App.f1233b).a().b(aVarA);
                        }
                    }
                }
                return null;
            default:
                int iIntValue = ((Integer[]) objArr)[0].intValue();
                x xVarB = ChannelDatabase.c(App.f1233b).b();
                xVarB.getClass();
                RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM countries WHERE id = ?", 1);
                long j2 = iIntValue;
                roomSQLiteQueryAcquire.bindLong(1, j2);
                RoomDatabase roomDatabase = xVarB.f2022a;
                roomDatabase.assertNotSuspendingTransaction();
                Cursor cursorQuery = DBUtil.query(roomDatabase, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "countryCode");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isSelected");
                    if (cursorQuery.moveToFirst()) {
                        uVar = new u(cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2));
                        uVar.f2016a = cursorQuery.getInt(columnIndexOrThrow);
                        uVar.f2018c = cursorQuery.getInt(columnIndexOrThrow3) != 0;
                    } else {
                        uVar = null;
                    }
                    if (uVar == null) {
                        return Boolean.FALSE;
                    }
                    int i6 = 0;
                    while (true) {
                        if (i6 < 14) {
                            String[] strArr3 = strArr[i6];
                            if (strArr3[0].equals(uVar.f2017b)) {
                                str = strArr3[1];
                            } else {
                                i6++;
                            }
                        } else {
                            str = null;
                        }
                    }
                    if (str == null) {
                        return Boolean.FALSE;
                    }
                    f fVarA = ChannelDatabase.c(App.f1233b).a();
                    RoomDatabase roomDatabase2 = fVarA.f1977a;
                    roomDatabase2.assertNotSuspendingTransaction();
                    d dVar = fVarA.f1982f;
                    c0.k kVarAcquire = dVar.acquire();
                    kVarAcquire.bindLong(1, j2);
                    try {
                        roomDatabase2.beginTransaction();
                        try {
                            kVarAcquire.executeUpdateDelete();
                            roomDatabase2.setTransactionSuccessful();
                            dVar.release(kVarAcquire);
                            Resources resources2 = hVar.f1986a.getResources();
                            Context context2 = hVar.f1986a;
                            int identifier2 = resources2.getIdentifier(str, "array", context2.getPackageName());
                            if (identifier2 == 0) {
                                return Boolean.FALSE;
                            }
                            int[] intArray2 = context2.getResources().getIntArray(identifier2);
                            for (int i7 = 1; i7 <= intArray2.length; i7++) {
                                int i8 = intArray2[i7 - 1];
                                if (!str.contains("uhf") && !str.contains("vhf")) {
                                    aVarA2 = h.a(hVar, i8, i8);
                                } else if (i7 <= 8) {
                                    a aVar2 = new a();
                                    aVar2.f1941e = 0;
                                    aVar2.f1945i = i8;
                                    aVar2.f1944h = i8;
                                    aVarA2 = aVar2;
                                } else {
                                    aVarA2 = h.a(hVar, i8, i8);
                                }
                                aVarA2.f1938b = iIntValue;
                                ChannelDatabase.c(App.f1233b).a().b(aVarA2);
                            }
                            return Boolean.TRUE;
                        } finally {
                            roomDatabase2.endTransaction();
                        }
                    } catch (Throwable th) {
                        dVar.release(kVarAcquire);
                        throw th;
                    }
                } finally {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                }
        }
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        switch (this.f1983a) {
            case 1:
                Log.d("ChannelDataUtil", " onPostExecute 146: " + ((Boolean) obj));
                break;
            default:
                super.onPostExecute(obj);
                break;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(h hVar, int i2, int i3) {
        this(hVar, 0);
        this.f1983a = i2;
        int i4 = 1;
        if (i2 != 1) {
        } else {
            this(hVar, i4);
        }
    }
}
