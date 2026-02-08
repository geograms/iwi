package androidx.room.util;

import a.a;
import androidx.room.ColumnInfo;
import androidx.room.Index;
import c0.b;
import i1.c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.g;
import v0.m;

/* loaded from: classes.dex */
public final class TableInfo {
    public static final int CREATED_FROM_DATABASE = 2;
    public static final int CREATED_FROM_ENTITY = 1;
    public static final int CREATED_FROM_UNKNOWN = 0;
    public static final Companion Companion = new Companion(null);
    public final Map<String, Column> columns;
    public final Set<ForeignKey> foreignKeys;
    public final Set<Index> indices;
    public final String name;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final TableInfo read(b bVar, String str) {
            x0.g.u(bVar, "database");
            x0.g.u(str, "tableName");
            return TableInfoKt.readTableInfo(bVar, str);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CreatedFrom {
    }

    public static final class ForeignKey {
        public final List<String> columnNames;
        public final String onDelete;
        public final String onUpdate;
        public final List<String> referenceColumnNames;
        public final String referenceTable;

        public ForeignKey(String str, String str2, String str3, List<String> list, List<String> list2) {
            x0.g.u(str, "referenceTable");
            x0.g.u(str2, "onDelete");
            x0.g.u(str3, "onUpdate");
            x0.g.u(list, "columnNames");
            x0.g.u(list2, "referenceColumnNames");
            this.referenceTable = str;
            this.onDelete = str2;
            this.onUpdate = str3;
            this.columnNames = list;
            this.referenceColumnNames = list2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ForeignKey)) {
                return false;
            }
            ForeignKey foreignKey = (ForeignKey) obj;
            if (x0.g.g(this.referenceTable, foreignKey.referenceTable) && x0.g.g(this.onDelete, foreignKey.onDelete) && x0.g.g(this.onUpdate, foreignKey.onUpdate) && x0.g.g(this.columnNames, foreignKey.columnNames)) {
                return x0.g.g(this.referenceColumnNames, foreignKey.referenceColumnNames);
            }
            return false;
        }

        public int hashCode() {
            return this.referenceColumnNames.hashCode() + ((this.columnNames.hashCode() + ((this.onUpdate.hashCode() + ((this.onDelete.hashCode() + (this.referenceTable.hashCode() * 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.referenceTable + "', onDelete='" + this.onDelete + " +', onUpdate='" + this.onUpdate + "', columnNames=" + this.columnNames + ", referenceColumnNames=" + this.referenceColumnNames + '}';
        }
    }

    public static final class ForeignKeyWithSequence implements Comparable<ForeignKeyWithSequence> {
        private final String from;
        private final int id;
        private final int sequence;
        private final String to;

        public ForeignKeyWithSequence(int i2, int i3, String str, String str2) {
            x0.g.u(str, "from");
            x0.g.u(str2, "to");
            this.id = i2;
            this.sequence = i3;
            this.from = str;
            this.to = str2;
        }

        public final String getFrom() {
            return this.from;
        }

        public final int getId() {
            return this.id;
        }

        public final int getSequence() {
            return this.sequence;
        }

        public final String getTo() {
            return this.to;
        }

        @Override // java.lang.Comparable
        public int compareTo(ForeignKeyWithSequence foreignKeyWithSequence) {
            x0.g.u(foreignKeyWithSequence, "other");
            int i2 = this.id - foreignKeyWithSequence.id;
            return i2 == 0 ? this.sequence - foreignKeyWithSequence.sequence : i2;
        }
    }

    public TableInfo(String str, Map<String, Column> map, Set<ForeignKey> set, Set<Index> set2) {
        x0.g.u(str, "name");
        x0.g.u(map, "columns");
        x0.g.u(set, "foreignKeys");
        this.name = str;
        this.columns = map;
        this.foreignKeys = set;
        this.indices = set2;
    }

    public static final TableInfo read(b bVar, String str) {
        return Companion.read(bVar, str);
    }

    public boolean equals(Object obj) {
        Set<Index> set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo)) {
            return false;
        }
        TableInfo tableInfo = (TableInfo) obj;
        if (!x0.g.g(this.name, tableInfo.name) || !x0.g.g(this.columns, tableInfo.columns) || !x0.g.g(this.foreignKeys, tableInfo.foreignKeys)) {
            return false;
        }
        Set<Index> set2 = this.indices;
        if (set2 == null || (set = tableInfo.indices) == null) {
            return true;
        }
        return x0.g.g(set2, set);
    }

    public int hashCode() {
        return this.foreignKeys.hashCode() + ((this.columns.hashCode() + (this.name.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "TableInfo{name='" + this.name + "', columns=" + this.columns + ", foreignKeys=" + this.foreignKeys + ", indices=" + this.indices + '}';
    }

    public static final class Column {
        public static final Companion Companion = new Companion(null);
        public final int affinity;
        public final int createdFrom;
        public final String defaultValue;
        public final String name;
        public final boolean notNull;
        public final int primaryKeyPosition;
        public final String type;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(g gVar) {
                this();
            }

            private final boolean containsSurroundingParenthesis(String str) {
                if (str.length() == 0) {
                    return false;
                }
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                while (i2 < str.length()) {
                    char cCharAt = str.charAt(i2);
                    int i5 = i4 + 1;
                    if (i4 == 0 && cCharAt != '(') {
                        return false;
                    }
                    if (cCharAt == '(') {
                        i3++;
                    } else if (cCharAt == ')' && i3 - 1 == 0 && i4 != str.length() - 1) {
                        return false;
                    }
                    i2++;
                    i4 = i5;
                }
                return i3 == 0;
            }

            public final boolean defaultValueEquals(String str, String str2) {
                x0.g.u(str, "current");
                if (x0.g.g(str, str2)) {
                    return true;
                }
                if (!containsSurroundingParenthesis(str)) {
                    return false;
                }
                String strSubstring = str.substring(1, str.length() - 1);
                x0.g.t(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                return x0.g.g(c.Q0(strSubstring).toString(), str2);
            }
        }

        public Column(String str, String str2, boolean z2, int i2, String str3, int i3) {
            x0.g.u(str, "name");
            x0.g.u(str2, "type");
            this.name = str;
            this.type = str2;
            this.notNull = z2;
            this.primaryKeyPosition = i2;
            this.defaultValue = str3;
            this.createdFrom = i3;
            this.affinity = findAffinity(str2);
        }

        public static final boolean defaultValueEquals(String str, String str2) {
            return Companion.defaultValueEquals(str, str2);
        }

        @ColumnInfo.SQLiteTypeAffinity
        private final int findAffinity(String str) {
            if (str == null) {
                return 5;
            }
            Locale locale = Locale.US;
            x0.g.t(locale, "US");
            String upperCase = str.toUpperCase(locale);
            x0.g.t(upperCase, "this as java.lang.String).toUpperCase(locale)");
            if (c.E0(upperCase, "INT", false)) {
                return 3;
            }
            if (c.E0(upperCase, "CHAR", false) || c.E0(upperCase, "CLOB", false) || c.E0(upperCase, "TEXT", false)) {
                return 2;
            }
            if (c.E0(upperCase, "BLOB", false)) {
                return 5;
            }
            return (c.E0(upperCase, "REAL", false) || c.E0(upperCase, "FLOA", false) || c.E0(upperCase, "DOUB", false)) ? 4 : 1;
        }

        @ColumnInfo.SQLiteTypeAffinity
        public static /* synthetic */ void getAffinity$annotations() {
        }

        public boolean equals(Object obj) {
            String str;
            String str2;
            String str3;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Column) || this.primaryKeyPosition != ((Column) obj).primaryKeyPosition) {
                return false;
            }
            Column column = (Column) obj;
            if (!x0.g.g(this.name, column.name) || this.notNull != column.notNull) {
                return false;
            }
            if (this.createdFrom == 1 && column.createdFrom == 2 && (str3 = this.defaultValue) != null && !Companion.defaultValueEquals(str3, column.defaultValue)) {
                return false;
            }
            if (this.createdFrom == 2 && column.createdFrom == 1 && (str2 = column.defaultValue) != null && !Companion.defaultValueEquals(str2, this.defaultValue)) {
                return false;
            }
            int i2 = this.createdFrom;
            return (i2 == 0 || i2 != column.createdFrom || ((str = this.defaultValue) == null ? column.defaultValue == null : Companion.defaultValueEquals(str, column.defaultValue))) && this.affinity == column.affinity;
        }

        public int hashCode() {
            return (((((this.name.hashCode() * 31) + this.affinity) * 31) + (this.notNull ? 1231 : 1237)) * 31) + this.primaryKeyPosition;
        }

        public final boolean isPrimaryKey() {
            return this.primaryKeyPosition > 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Column{name='");
            sb.append(this.name);
            sb.append("', type='");
            sb.append(this.type);
            sb.append("', affinity='");
            sb.append(this.affinity);
            sb.append("', notNull=");
            sb.append(this.notNull);
            sb.append(", primaryKeyPosition=");
            sb.append(this.primaryKeyPosition);
            sb.append(", defaultValue='");
            String str = this.defaultValue;
            if (str == null) {
                str = "undefined";
            }
            return a.e(sb, str, "'}");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Column(String str, String str2, boolean z2, int i2) {
            this(str, str2, z2, i2, null, 0);
            x0.g.u(str, "name");
            x0.g.u(str2, "type");
        }
    }

    public /* synthetic */ TableInfo(String str, Map map, Set set, Set set2, int i2, g gVar) {
        this(str, map, set, (i2 & 8) != 0 ? null : set2);
    }

    public static final class Index {
        public static final Companion Companion = new Companion(null);
        public static final String DEFAULT_PREFIX = "index_";
        public final List<String> columns;
        public final String name;
        public List<String> orders;
        public final boolean unique;

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(g gVar) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, java.util.Collection, java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r5v2, types: [java.util.ArrayList] */
        public Index(String str, boolean z2, List<String> list, List<String> list2) {
            x0.g.u(str, "name");
            x0.g.u(list, "columns");
            x0.g.u(list2, "orders");
            this.name = str;
            this.unique = z2;
            this.columns = list;
            this.orders = list2;
            if (list2.isEmpty()) {
                int size = list.size();
                list2 = new ArrayList<>(size);
                for (int i2 = 0; i2 < size; i2++) {
                    list2.add(Index.Order.ASC.name());
                }
            }
            this.orders = list2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Index)) {
                return false;
            }
            Index index = (Index) obj;
            if (this.unique == index.unique && x0.g.g(this.columns, index.columns) && x0.g.g(this.orders, index.orders)) {
                return c.O0(this.name, DEFAULT_PREFIX) ? c.O0(index.name, DEFAULT_PREFIX) : x0.g.g(this.name, index.name);
            }
            return false;
        }

        public int hashCode() {
            return this.orders.hashCode() + ((this.columns.hashCode() + ((((c.O0(this.name, DEFAULT_PREFIX) ? -1184239155 : this.name.hashCode()) * 31) + (this.unique ? 1 : 0)) * 31)) * 31);
        }

        public String toString() {
            return "Index{name='" + this.name + "', unique=" + this.unique + ", columns=" + this.columns + ", orders=" + this.orders + "'}";
        }

        public Index(String str, boolean z2, List<String> list) {
            x0.g.u(str, "name");
            x0.g.u(list, "columns");
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(Index.Order.ASC.name());
            }
            this(str, z2, list, arrayList);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TableInfo(String str, Map<String, Column> map, Set<ForeignKey> set) {
        this(str, map, set, m.f2602a);
        x0.g.u(str, "name");
        x0.g.u(map, "columns");
        x0.g.u(set, "foreignKeys");
    }
}
