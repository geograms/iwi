package m0;

import android.database.Cursor;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class c implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RoomSQLiteQuery f2099a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f2100b;

    public c(d dVar, RoomSQLiteQuery roomSQLiteQuery) {
        this.f2100b = dVar;
        this.f2099a = roomSQLiteQuery;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Cursor cursorQuery = DBUtil.query(this.f2100b.f2101a, this.f2099a, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "number");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "channel");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "channel_db_id");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "logo");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "avatarData");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                a aVar = new a();
                aVar.f2090a = cursorQuery.getInt(columnIndexOrThrow);
                aVar.f2091b = cursorQuery.getInt(columnIndexOrThrow2);
                aVar.f2092c = cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3);
                aVar.f2093d = cursorQuery.getInt(columnIndexOrThrow4);
                aVar.f2094e = cursorQuery.isNull(columnIndexOrThrow5) ? null : cursorQuery.getString(columnIndexOrThrow5);
                aVar.f2095f = cursorQuery.getInt(columnIndexOrThrow6);
                aVar.f2096g = cursorQuery.isNull(columnIndexOrThrow7) ? null : cursorQuery.getString(columnIndexOrThrow7);
                aVar.f2097h = cursorQuery.isNull(columnIndexOrThrow8) ? null : cursorQuery.getBlob(columnIndexOrThrow8);
                arrayList.add(aVar);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
        }
    }

    public final void finalize() {
        this.f2099a.release();
    }
}
