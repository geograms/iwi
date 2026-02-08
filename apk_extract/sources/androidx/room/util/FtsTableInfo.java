package androidx.room.util;

import android.database.Cursor;
import c0.b;
import i1.c;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.g;
import v0.m;
import w0.i;

/* loaded from: classes.dex */
public final class FtsTableInfo {
    public static final Companion Companion = new Companion(null);
    private static final String[] FTS_OPTIONS = {"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};
    public final Set<String> columns;
    public final String name;
    public final Set<String> options;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private final Set<String> readColumns(b bVar, String str) throws IOException {
            i iVar = new i();
            Cursor cursorQuery = bVar.query("PRAGMA table_info(`" + str + "`)");
            try {
                if (cursorQuery.getColumnCount() > 0) {
                    int columnIndex = cursorQuery.getColumnIndex("name");
                    while (cursorQuery.moveToNext()) {
                        String string = cursorQuery.getString(columnIndex);
                        x0.g.t(string, "cursor.getString(nameIndex)");
                        iVar.add(string);
                    }
                }
                x0.g.y(cursorQuery, null);
                x0.g.l(iVar);
                return iVar;
            } finally {
            }
        }

        private final Set<String> readOptions(b bVar, String str) throws IOException {
            Cursor cursorQuery = bVar.query("SELECT * FROM sqlite_master WHERE `name` = '" + str + '\'');
            try {
                String string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("sql")) : "";
                x0.g.y(cursorQuery, null);
                x0.g.t(string, "sql");
                return parseOptions(string);
            } finally {
            }
        }

        public final Set<String> parseOptions(String str) {
            Character ch;
            x0.g.u(str, "createStatement");
            if (str.length() == 0) {
                return m.f2602a;
            }
            String strSubstring = str.substring(c.J0(str, '(') + 1, c.M0(str, ')'));
            x0.g.t(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            ArrayList arrayList = new ArrayList();
            ArrayDeque arrayDeque = new ArrayDeque();
            int i2 = -1;
            int i3 = 0;
            int i4 = 0;
            while (i3 < strSubstring.length()) {
                char cCharAt = strSubstring.charAt(i3);
                int i5 = i4 + 1;
                if (cCharAt == '\'' || cCharAt == '\"' || cCharAt == '`') {
                    if (arrayDeque.isEmpty()) {
                        arrayDeque.push(Character.valueOf(cCharAt));
                    } else {
                        Character ch2 = (Character) arrayDeque.peek();
                        if (ch2 != null && ch2.charValue() == cCharAt) {
                            arrayDeque.pop();
                        }
                    }
                } else if (cCharAt == '[') {
                    if (arrayDeque.isEmpty()) {
                        arrayDeque.push(Character.valueOf(cCharAt));
                    }
                } else if (cCharAt == ']') {
                    if (!arrayDeque.isEmpty() && (ch = (Character) arrayDeque.peek()) != null && ch.charValue() == '[') {
                        arrayDeque.pop();
                    }
                } else if (cCharAt == ',' && arrayDeque.isEmpty()) {
                    String strSubstring2 = strSubstring.substring(i2 + 1, i4);
                    x0.g.t(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    int length = strSubstring2.length() - 1;
                    int i6 = 0;
                    boolean z2 = false;
                    while (i6 <= length) {
                        boolean z3 = x0.g.z(strSubstring2.charAt(!z2 ? i6 : length), 32) <= 0;
                        if (z2) {
                            if (!z3) {
                                break;
                            }
                            length--;
                        } else if (z3) {
                            i6++;
                        } else {
                            z2 = true;
                        }
                    }
                    arrayList.add(strSubstring2.subSequence(i6, length + 1).toString());
                    i2 = i4;
                }
                i3++;
                i4 = i5;
            }
            String strSubstring3 = strSubstring.substring(i2 + 1);
            x0.g.t(strSubstring3, "this as java.lang.String).substring(startIndex)");
            arrayList.add(c.Q0(strSubstring3).toString());
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                String str2 = (String) next;
                String[] strArr = FtsTableInfo.FTS_OPTIONS;
                int length2 = strArr.length;
                int i7 = 0;
                while (true) {
                    if (i7 >= length2) {
                        break;
                    }
                    if (c.O0(str2, strArr[i7])) {
                        arrayList2.add(next);
                        break;
                    }
                    i7++;
                }
            }
            return v0.i.Q0(arrayList2);
        }

        public final FtsTableInfo read(b bVar, String str) {
            x0.g.u(bVar, "database");
            x0.g.u(str, "tableName");
            return new FtsTableInfo(str, readColumns(bVar, str), readOptions(bVar, str));
        }
    }

    public FtsTableInfo(String str, Set<String> set, Set<String> set2) {
        x0.g.u(str, "name");
        x0.g.u(set, "columns");
        x0.g.u(set2, "options");
        this.name = str;
        this.columns = set;
        this.options = set2;
    }

    public static final Set<String> parseOptions(String str) {
        return Companion.parseOptions(str);
    }

    public static final FtsTableInfo read(b bVar, String str) {
        return Companion.read(bVar, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FtsTableInfo)) {
            return false;
        }
        FtsTableInfo ftsTableInfo = (FtsTableInfo) obj;
        if (x0.g.g(this.name, ftsTableInfo.name) && x0.g.g(this.columns, ftsTableInfo.columns)) {
            return x0.g.g(this.options, ftsTableInfo.options);
        }
        return false;
    }

    public int hashCode() {
        return this.options.hashCode() + ((this.columns.hashCode() + (this.name.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "FtsTableInfo{name='" + this.name + "', columns=" + this.columns + ", options=" + this.options + "'}";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FtsTableInfo(String str, Set<String> set, String str2) {
        this(str, set, Companion.parseOptions(str2));
        x0.g.u(str, "name");
        x0.g.u(set, "columns");
        x0.g.u(str2, "createSql");
    }
}
