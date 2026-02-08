package androidx.room.util;

import android.database.Cursor;
import androidx.room.util.TableInfo;
import c0.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import v0.i;
import v0.l;
import w0.f;
import x0.g;

/* loaded from: classes.dex */
public final class TableInfoKt {
    private static final Map<String, TableInfo.Column> readColumns(b bVar, String str) throws IOException {
        Cursor cursorQuery = bVar.query("PRAGMA table_info(`" + str + "`)");
        try {
            if (cursorQuery.getColumnCount() <= 0) {
                l lVar = l.f2601a;
                g.y(cursorQuery, null);
                return lVar;
            }
            int columnIndex = cursorQuery.getColumnIndex("name");
            int columnIndex2 = cursorQuery.getColumnIndex("type");
            int columnIndex3 = cursorQuery.getColumnIndex("notnull");
            int columnIndex4 = cursorQuery.getColumnIndex("pk");
            int columnIndex5 = cursorQuery.getColumnIndex("dflt_value");
            f fVar = new f();
            while (true) {
                if (!cursorQuery.moveToNext()) {
                    fVar.b();
                    fVar.f2643l = true;
                    g.y(cursorQuery, null);
                    return fVar;
                }
                String string = cursorQuery.getString(columnIndex);
                String string2 = cursorQuery.getString(columnIndex2);
                boolean z2 = cursorQuery.getInt(columnIndex3) != 0;
                int i2 = cursorQuery.getInt(columnIndex4);
                String string3 = cursorQuery.getString(columnIndex5);
                g.t(string, "name");
                g.t(string2, "type");
                fVar.put(string, new TableInfo.Column(string, string2, z2, i2, string3, 2));
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                g.y(cursorQuery, th);
                throw th2;
            }
        }
    }

    private static final List<TableInfo.ForeignKeyWithSequence> readForeignKeyFieldMappings(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        w0.b bVar = new w0.b();
        while (cursor.moveToNext()) {
            int i2 = cursor.getInt(columnIndex);
            int i3 = cursor.getInt(columnIndex2);
            String string = cursor.getString(columnIndex3);
            g.t(string, "cursor.getString(fromColumnIndex)");
            String string2 = cursor.getString(columnIndex4);
            g.t(string2, "cursor.getString(toColumnIndex)");
            bVar.add(new TableInfo.ForeignKeyWithSequence(i2, i3, string, string2));
        }
        g.k(bVar);
        if (bVar.f2622c <= 1) {
            return i.P0(bVar);
        }
        Object[] array = bVar.toArray(new Comparable[0]);
        Comparable[] comparableArr = (Comparable[]) array;
        if (comparableArr.length > 1) {
            Arrays.sort(comparableArr);
        }
        List<TableInfo.ForeignKeyWithSequence> listAsList = Arrays.asList(array);
        g.t(listAsList, "asList(this)");
        return listAsList;
    }

    private static final Set<TableInfo.ForeignKey> readForeignKeys(b bVar, String str) throws IOException {
        Cursor cursorQuery = bVar.query("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = cursorQuery.getColumnIndex("id");
            int columnIndex2 = cursorQuery.getColumnIndex("seq");
            int columnIndex3 = cursorQuery.getColumnIndex("table");
            int columnIndex4 = cursorQuery.getColumnIndex("on_delete");
            int columnIndex5 = cursorQuery.getColumnIndex("on_update");
            List<TableInfo.ForeignKeyWithSequence> foreignKeyFieldMappings = readForeignKeyFieldMappings(cursorQuery);
            cursorQuery.moveToPosition(-1);
            w0.i iVar = new w0.i();
            while (cursorQuery.moveToNext()) {
                if (cursorQuery.getInt(columnIndex2) == 0) {
                    int i2 = cursorQuery.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj : foreignKeyFieldMappings) {
                        if (((TableInfo.ForeignKeyWithSequence) obj).getId() == i2) {
                            arrayList3.add(obj);
                        }
                    }
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        TableInfo.ForeignKeyWithSequence foreignKeyWithSequence = (TableInfo.ForeignKeyWithSequence) it.next();
                        arrayList.add(foreignKeyWithSequence.getFrom());
                        arrayList2.add(foreignKeyWithSequence.getTo());
                    }
                    String string = cursorQuery.getString(columnIndex3);
                    g.t(string, "cursor.getString(tableColumnIndex)");
                    String string2 = cursorQuery.getString(columnIndex4);
                    g.t(string2, "cursor.getString(onDeleteColumnIndex)");
                    String string3 = cursorQuery.getString(columnIndex5);
                    g.t(string3, "cursor.getString(onUpdateColumnIndex)");
                    iVar.add(new TableInfo.ForeignKey(string, string2, string3, arrayList, arrayList2));
                }
            }
            g.l(iVar);
            g.y(cursorQuery, null);
            return iVar;
        } finally {
        }
    }

    private static final TableInfo.Index readIndex(b bVar, String str, boolean z2) throws IOException {
        Cursor cursorQuery = bVar.query("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = cursorQuery.getColumnIndex("seqno");
            int columnIndex2 = cursorQuery.getColumnIndex("cid");
            int columnIndex3 = cursorQuery.getColumnIndex("name");
            int columnIndex4 = cursorQuery.getColumnIndex("desc");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex4 != -1) {
                TreeMap treeMap = new TreeMap();
                TreeMap treeMap2 = new TreeMap();
                while (cursorQuery.moveToNext()) {
                    if (cursorQuery.getInt(columnIndex2) >= 0) {
                        int i2 = cursorQuery.getInt(columnIndex);
                        String string = cursorQuery.getString(columnIndex3);
                        String str2 = cursorQuery.getInt(columnIndex4) > 0 ? "DESC" : "ASC";
                        Integer numValueOf = Integer.valueOf(i2);
                        g.t(string, "columnName");
                        treeMap.put(numValueOf, string);
                        treeMap2.put(Integer.valueOf(i2), str2);
                    }
                }
                Collection collectionValues = treeMap.values();
                g.t(collectionValues, "columnsMap.values");
                List listP0 = i.P0(collectionValues);
                Collection collectionValues2 = treeMap2.values();
                g.t(collectionValues2, "ordersMap.values");
                TableInfo.Index index = new TableInfo.Index(str, z2, listP0, i.P0(collectionValues2));
                g.y(cursorQuery, null);
                return index;
            }
            g.y(cursorQuery, null);
            return null;
        } finally {
        }
    }

    private static final Set<TableInfo.Index> readIndices(b bVar, String str) throws IOException {
        Cursor cursorQuery = bVar.query("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = cursorQuery.getColumnIndex("name");
            int columnIndex2 = cursorQuery.getColumnIndex("origin");
            int columnIndex3 = cursorQuery.getColumnIndex("unique");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                w0.i iVar = new w0.i();
                while (cursorQuery.moveToNext()) {
                    if (g.g("c", cursorQuery.getString(columnIndex2))) {
                        String string = cursorQuery.getString(columnIndex);
                        boolean z2 = true;
                        if (cursorQuery.getInt(columnIndex3) != 1) {
                            z2 = false;
                        }
                        g.t(string, "name");
                        TableInfo.Index index = readIndex(bVar, string, z2);
                        if (index == null) {
                            g.y(cursorQuery, null);
                            return null;
                        }
                        iVar.add(index);
                    }
                }
                g.l(iVar);
                g.y(cursorQuery, null);
                return iVar;
            }
            g.y(cursorQuery, null);
            return null;
        } finally {
        }
    }

    public static final TableInfo readTableInfo(b bVar, String str) {
        g.u(bVar, "database");
        g.u(str, "tableName");
        return new TableInfo(str, readColumns(bVar, str), readForeignKeys(bVar, str), readIndices(bVar, str));
    }
}
