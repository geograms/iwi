package androidx.room.util;

import a.a;
import android.database.Cursor;
import c0.b;
import java.io.IOException;
import kotlin.jvm.internal.g;

/* loaded from: classes.dex */
public final class ViewInfo {
    public static final Companion Companion = new Companion(null);
    public final String name;
    public final String sql;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final ViewInfo read(b bVar, String str) throws IOException {
            ViewInfo viewInfo;
            x0.g.u(bVar, "database");
            x0.g.u(str, "viewName");
            Cursor cursorQuery = bVar.query("SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '" + str + '\'');
            try {
                if (cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(0);
                    x0.g.t(string, "cursor.getString(0)");
                    viewInfo = new ViewInfo(string, cursorQuery.getString(1));
                } else {
                    viewInfo = new ViewInfo(str, null);
                }
                x0.g.y(cursorQuery, null);
                return viewInfo;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    x0.g.y(cursorQuery, th);
                    throw th2;
                }
            }
        }
    }

    public ViewInfo(String str, String str2) {
        x0.g.u(str, "name");
        this.name = str;
        this.sql = str2;
    }

    public static final ViewInfo read(b bVar, String str) {
        return Companion.read(bVar, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewInfo)) {
            return false;
        }
        ViewInfo viewInfo = (ViewInfo) obj;
        if (x0.g.g(this.name, viewInfo.name)) {
            String str = this.sql;
            if (str != null) {
                if (x0.g.g(str, viewInfo.sql)) {
                    return true;
                }
            } else if (viewInfo.sql == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        String str = this.sql;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ViewInfo{name='");
        sb.append(this.name);
        sb.append("', sql='");
        return a.e(sb, this.sql, "'}");
    }
}
