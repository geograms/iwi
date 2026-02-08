package androidx.room.util;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import c0.b;
import c0.j;
import i1.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import w0.a;
import x0.g;

/* loaded from: classes.dex */
public final class DBUtil {
    public static final CancellationSignal createCancellationSignal() {
        return new CancellationSignal();
    }

    public static final void dropFtsSyncTriggers(b bVar) throws IOException {
        g.u(bVar, "db");
        w0.b bVar2 = new w0.b();
        Cursor cursorQuery = bVar.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (cursorQuery.moveToNext()) {
            try {
                bVar2.add(cursorQuery.getString(0));
            } finally {
            }
        }
        g.y(cursorQuery, null);
        g.k(bVar2);
        Iterator it = bVar2.iterator();
        while (true) {
            a aVar = (a) it;
            if (!aVar.hasNext()) {
                return;
            }
            String str = (String) aVar.next();
            g.t(str, "triggerName");
            if (c.O0(str, "room_fts_content_sync_")) {
                bVar.execSQL("DROP TRIGGER IF EXISTS ".concat(str));
            }
        }
    }

    public static final void foreignKeyCheck(b bVar, String str) throws IOException {
        g.u(bVar, "db");
        g.u(str, "tableName");
        Cursor cursorQuery = bVar.query("PRAGMA foreign_key_check(`" + str + "`)");
        try {
            if (cursorQuery.getCount() > 0) {
                throw new SQLiteConstraintException(processForeignKeyCheckFailure(cursorQuery));
            }
            g.y(cursorQuery, null);
        } finally {
        }
    }

    private static final String processForeignKeyCheckFailure(Cursor cursor) {
        StringBuilder sb = new StringBuilder();
        int count = cursor.getCount();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (cursor.moveToNext()) {
            if (cursor.isFirst()) {
                sb.append("Foreign key violation(s) detected in '");
                sb.append(cursor.getString(0));
                sb.append("'.\n");
            }
            String string = cursor.getString(3);
            if (!linkedHashMap.containsKey(string)) {
                g.t(string, "constraintIndex");
                String string2 = cursor.getString(2);
                g.t(string2, "cursor.getString(2)");
                linkedHashMap.put(string, string2);
            }
        }
        sb.append("Number of different violations discovered: ");
        sb.append(linkedHashMap.keySet().size());
        sb.append("\nNumber of rows in violation: ");
        sb.append(count);
        sb.append("\nViolation(s) detected in the following constraint(s):\n");
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            sb.append("\tParent Table = ");
            sb.append(str2);
            sb.append(", Foreign Key Constraint Index = ");
            sb.append(str);
            sb.append("\n");
        }
        String string3 = sb.toString();
        g.t(string3, "StringBuilder().apply(builderAction).toString()");
        return string3;
    }

    public static final Cursor query(RoomDatabase roomDatabase, j jVar, boolean z2) {
        g.u(roomDatabase, "db");
        g.u(jVar, "sqLiteQuery");
        return query(roomDatabase, jVar, z2, null);
    }

    public static final int readVersion(File file) {
        g.u(file, "databaseFile");
        FileChannel channel = new FileInputStream(file).getChannel();
        try {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(byteBufferAllocate) != 4) {
                throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
            }
            byteBufferAllocate.rewind();
            int i2 = byteBufferAllocate.getInt();
            g.y(channel, null);
            return i2;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                g.y(channel, th);
                throw th2;
            }
        }
    }

    public static final Cursor query(RoomDatabase roomDatabase, j jVar, boolean z2, CancellationSignal cancellationSignal) {
        g.u(roomDatabase, "db");
        g.u(jVar, "sqLiteQuery");
        Cursor cursorQuery = roomDatabase.query(jVar, cancellationSignal);
        if (!z2 || !(cursorQuery instanceof AbstractWindowedCursor)) {
            return cursorQuery;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) cursorQuery;
        int count = abstractWindowedCursor.getCount();
        return (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count ? CursorUtil.copyAndClose(cursorQuery) : cursorQuery;
    }
}
