package c0;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class d {
    public static final c Companion = new c();
    private static final String TAG = "SupportSQLite";
    public final int version;

    public d(int i2) {
        this.version = i2;
    }

    public static void a(String str) {
        if (i1.c.F0(str, ":memory:")) {
            return;
        }
        int length = str.length() - 1;
        int i2 = 0;
        boolean z2 = false;
        while (i2 <= length) {
            boolean z3 = x0.g.z(str.charAt(!z2 ? i2 : length), 32) <= 0;
            if (z2) {
                if (!z3) {
                    break;
                } else {
                    length--;
                }
            } else if (z3) {
                i2++;
            } else {
                z2 = true;
            }
        }
        if (str.subSequence(i2, length + 1).toString().length() == 0) {
            return;
        }
        Log.w(TAG, "deleting the database file: ".concat(str));
        try {
            SQLiteDatabase.deleteDatabase(new File(str));
        } catch (Exception e2) {
            Log.w(TAG, "delete failed: ", e2);
        }
    }

    public void onConfigure(b bVar) {
        x0.g.u(bVar, "db");
    }

    public void onCorruption(b bVar) {
        x0.g.u(bVar, "db");
        Log.e(TAG, "Corruption reported by sqlite on database: " + bVar + ".path");
        if (!bVar.isOpen()) {
            String path = bVar.getPath();
            if (path != null) {
                a(path);
                return;
            }
            return;
        }
        List attachedDbs = null;
        try {
            try {
                attachedDbs = bVar.getAttachedDbs();
            } catch (SQLiteException unused) {
            }
            try {
                bVar.close();
            } catch (IOException unused2) {
            }
            if (attachedDbs != null) {
                return;
            }
        } finally {
            if (attachedDbs != null) {
                Iterator it = attachedDbs.iterator();
                while (it.hasNext()) {
                    Object obj = ((Pair) it.next()).second;
                    x0.g.t(obj, "p.second");
                    a((String) obj);
                }
            } else {
                String path2 = bVar.getPath();
                if (path2 != null) {
                    a(path2);
                }
            }
        }
    }

    public abstract void onCreate(b bVar);

    public void onDowngrade(b bVar, int i2, int i3) {
        x0.g.u(bVar, "db");
        throw new SQLiteException("Can't downgrade database from version " + i2 + " to " + i3);
    }

    public abstract void onOpen(b bVar);

    public abstract void onUpgrade(b bVar, int i2, int i3);
}
