package androidx.room.util;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.MatrixCursor;
import android.util.Log;
import c1.l;
import i1.c;
import java.io.IOException;
import v0.f;
import x0.g;

/* loaded from: classes.dex */
public final class CursorUtil {
    public static final Cursor copyAndClose(Cursor cursor) throws IOException {
        g.u(cursor, "c");
        try {
            MatrixCursor matrixCursor = new MatrixCursor(cursor.getColumnNames(), cursor.getCount());
            while (cursor.moveToNext()) {
                Object[] objArr = new Object[cursor.getColumnCount()];
                int columnCount = cursor.getColumnCount();
                for (int i2 = 0; i2 < columnCount; i2++) {
                    int type = cursor.getType(i2);
                    if (type == 0) {
                        objArr[i2] = null;
                    } else if (type == 1) {
                        objArr[i2] = Long.valueOf(cursor.getLong(i2));
                    } else if (type == 2) {
                        objArr[i2] = Double.valueOf(cursor.getDouble(i2));
                    } else if (type == 3) {
                        objArr[i2] = cursor.getString(i2);
                    } else {
                        if (type != 4) {
                            throw new IllegalStateException();
                        }
                        objArr[i2] = cursor.getBlob(i2);
                    }
                }
                matrixCursor.addRow(objArr);
            }
            g.y(cursor, null);
            return matrixCursor;
        } finally {
        }
    }

    private static final int findColumnIndexBySuffix(Cursor cursor, String str) {
        return -1;
    }

    public static final int getColumnIndex(Cursor cursor, String str) {
        g.u(cursor, "c");
        g.u(str, "name");
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = cursor.getColumnIndex("`" + str + '`');
        return columnIndex2 >= 0 ? columnIndex2 : findColumnIndexBySuffix(cursor, str);
    }

    public static final int getColumnIndexOrThrow(Cursor cursor, String str) {
        String strG0;
        g.u(cursor, "c");
        g.u(str, "name");
        int columnIndex = getColumnIndex(cursor, str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            String[] columnNames = cursor.getColumnNames();
            g.t(columnNames, "c.columnNames");
            strG0 = f.G0(columnNames);
        } catch (Exception e2) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e2);
            strG0 = "unknown";
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist. Available columns: " + strG0);
    }

    public static final <R> R useCursor(Cursor cursor, l lVar) throws IOException {
        g.u(cursor, "<this>");
        g.u(lVar, "block");
        try {
            R r2 = (R) lVar.invoke(cursor);
            g.y(cursor, null);
            return r2;
        } finally {
        }
    }

    public static final Cursor wrapMappedColumns(Cursor cursor, final String[] strArr, final int[] iArr) {
        g.u(cursor, "cursor");
        g.u(strArr, "columnNames");
        g.u(iArr, "mapping");
        if (strArr.length == iArr.length) {
            return new CursorWrapper(cursor) { // from class: androidx.room.util.CursorUtil.wrapMappedColumns.2
                @Override // android.database.CursorWrapper, android.database.Cursor
                public int getColumnIndex(String str) {
                    g.u(str, "columnName");
                    String[] strArr2 = strArr;
                    int[] iArr2 = iArr;
                    int length = strArr2.length;
                    int i2 = 0;
                    int i3 = 0;
                    while (i2 < length) {
                        int i4 = i3 + 1;
                        if (c.F0(strArr2[i2], str)) {
                            return iArr2[i3];
                        }
                        i2++;
                        i3 = i4;
                    }
                    return super.getColumnIndex(str);
                }
            };
        }
        throw new IllegalStateException("Expected columnNames.length == mapping.length".toString());
    }

    public static final int findColumnIndexBySuffix(String[] strArr, String str) {
        g.u(strArr, "columnNames");
        g.u(str, "name");
        String strConcat = ".".concat(str);
        String str2 = "." + str + '`';
        int length = strArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            String str3 = strArr[i2];
            int i4 = i3 + 1;
            if (str3.length() >= str.length() + 2) {
                g.u(strConcat, "suffix");
                if (str3.endsWith(strConcat)) {
                    return i3;
                }
                if (str3.charAt(0) == '`') {
                    g.u(str2, "suffix");
                    if (str3.endsWith(str2)) {
                        return i3;
                    }
                } else {
                    continue;
                }
            }
            i2++;
            i3 = i4;
        }
        return -1;
    }
}
