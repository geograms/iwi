package androidx.room;

import c0.i;
import c0.j;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class RoomSQLiteQuery implements j, i {
    private static final int BLOB = 5;
    public static final int DESIRED_POOL_SIZE = 10;
    private static final int DOUBLE = 3;
    private static final int LONG = 2;
    private static final int NULL = 1;
    public static final int POOL_LIMIT = 15;
    private static final int STRING = 4;
    private int argCount;
    private final int[] bindingTypes;
    public final byte[][] blobBindings;
    private final int capacity;
    public final double[] doubleBindings;
    public final long[] longBindings;
    private volatile String query;
    public final String[] stringBindings;
    public static final Companion Companion = new Companion(null);
    public static final TreeMap<Integer, RoomSQLiteQuery> queryPool = new TreeMap<>();

    @Retention(RetentionPolicy.SOURCE)
    public @interface Binding {
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        public static /* synthetic */ void getDESIRED_POOL_SIZE$annotations() {
        }

        public static /* synthetic */ void getPOOL_LIMIT$annotations() {
        }

        public static /* synthetic */ void getQueryPool$annotations() {
        }

        public final RoomSQLiteQuery acquire(String str, int i2) {
            x0.g.u(str, "query");
            TreeMap<Integer, RoomSQLiteQuery> treeMap = RoomSQLiteQuery.queryPool;
            synchronized (treeMap) {
                Map.Entry<Integer, RoomSQLiteQuery> entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(i2));
                if (entryCeilingEntry == null) {
                    RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(i2, null);
                    roomSQLiteQuery.init(str, i2);
                    return roomSQLiteQuery;
                }
                treeMap.remove(entryCeilingEntry.getKey());
                RoomSQLiteQuery value = entryCeilingEntry.getValue();
                value.init(str, i2);
                return value;
            }
        }

        public final RoomSQLiteQuery copyFrom(j jVar) {
            x0.g.u(jVar, "supportSQLiteQuery");
            final RoomSQLiteQuery roomSQLiteQueryAcquire = acquire(jVar.getSql(), jVar.getArgCount());
            jVar.bindTo(new i() { // from class: androidx.room.RoomSQLiteQuery$Companion$copyFrom$1
                @Override // c0.i
                public void bindBlob(int i2, byte[] bArr) {
                    x0.g.u(bArr, "value");
                    roomSQLiteQueryAcquire.bindBlob(i2, bArr);
                }

                @Override // c0.i
                public void bindDouble(int i2, double d2) {
                    roomSQLiteQueryAcquire.bindDouble(i2, d2);
                }

                @Override // c0.i
                public void bindLong(int i2, long j2) {
                    roomSQLiteQueryAcquire.bindLong(i2, j2);
                }

                @Override // c0.i
                public void bindNull(int i2) {
                    roomSQLiteQueryAcquire.bindNull(i2);
                }

                @Override // c0.i
                public void bindString(int i2, String str) {
                    x0.g.u(str, "value");
                    roomSQLiteQueryAcquire.bindString(i2, str);
                }

                @Override // c0.i
                public void clearBindings() {
                    roomSQLiteQueryAcquire.clearBindings();
                }

                @Override // java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    roomSQLiteQueryAcquire.close();
                }
            });
            return roomSQLiteQueryAcquire;
        }

        public final void prunePoolLocked$room_runtime_release() {
            TreeMap<Integer, RoomSQLiteQuery> treeMap = RoomSQLiteQuery.queryPool;
            if (treeMap.size() <= 15) {
                return;
            }
            int size = treeMap.size() - 10;
            Iterator<Integer> it = treeMap.descendingKeySet().iterator();
            x0.g.t(it, "queryPool.descendingKeySet().iterator()");
            while (true) {
                int i2 = size - 1;
                if (size <= 0) {
                    return;
                }
                it.next();
                it.remove();
                size = i2;
            }
        }
    }

    public /* synthetic */ RoomSQLiteQuery(int i2, kotlin.jvm.internal.g gVar) {
        this(i2);
    }

    public static final RoomSQLiteQuery acquire(String str, int i2) {
        return Companion.acquire(str, i2);
    }

    public static final RoomSQLiteQuery copyFrom(j jVar) {
        return Companion.copyFrom(jVar);
    }

    private static /* synthetic */ void getBindingTypes$annotations() {
    }

    public static /* synthetic */ void getBlobBindings$annotations() {
    }

    public static /* synthetic */ void getDoubleBindings$annotations() {
    }

    public static /* synthetic */ void getLongBindings$annotations() {
    }

    public static /* synthetic */ void getStringBindings$annotations() {
    }

    @Override // c0.i
    public void bindBlob(int i2, byte[] bArr) {
        x0.g.u(bArr, "value");
        this.bindingTypes[i2] = 5;
        this.blobBindings[i2] = bArr;
    }

    @Override // c0.i
    public void bindDouble(int i2, double d2) {
        this.bindingTypes[i2] = 3;
        this.doubleBindings[i2] = d2;
    }

    @Override // c0.i
    public void bindLong(int i2, long j2) {
        this.bindingTypes[i2] = 2;
        this.longBindings[i2] = j2;
    }

    @Override // c0.i
    public void bindNull(int i2) {
        this.bindingTypes[i2] = 1;
    }

    @Override // c0.i
    public void bindString(int i2, String str) {
        x0.g.u(str, "value");
        this.bindingTypes[i2] = 4;
        this.stringBindings[i2] = str;
    }

    @Override // c0.j
    public void bindTo(i iVar) {
        x0.g.u(iVar, "statement");
        int argCount = getArgCount();
        if (1 > argCount) {
            return;
        }
        int i2 = 1;
        while (true) {
            int i3 = this.bindingTypes[i2];
            if (i3 == 1) {
                iVar.bindNull(i2);
            } else if (i3 == 2) {
                iVar.bindLong(i2, this.longBindings[i2]);
            } else if (i3 == 3) {
                iVar.bindDouble(i2, this.doubleBindings[i2]);
            } else if (i3 == 4) {
                String str = this.stringBindings[i2];
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                iVar.bindString(i2, str);
            } else if (i3 == 5) {
                byte[] bArr = this.blobBindings[i2];
                if (bArr == null) {
                    throw new IllegalArgumentException("Required value was null.".toString());
                }
                iVar.bindBlob(i2, bArr);
            }
            if (i2 == argCount) {
                return;
            } else {
                i2++;
            }
        }
    }

    @Override // c0.i
    public void clearBindings() {
        Arrays.fill(this.bindingTypes, 1);
        Arrays.fill(this.stringBindings, (Object) null);
        Arrays.fill(this.blobBindings, (Object) null);
        this.query = null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final void copyArgumentsFrom(RoomSQLiteQuery roomSQLiteQuery) {
        x0.g.u(roomSQLiteQuery, "other");
        int argCount = roomSQLiteQuery.getArgCount() + 1;
        System.arraycopy(roomSQLiteQuery.bindingTypes, 0, this.bindingTypes, 0, argCount);
        System.arraycopy(roomSQLiteQuery.longBindings, 0, this.longBindings, 0, argCount);
        System.arraycopy(roomSQLiteQuery.stringBindings, 0, this.stringBindings, 0, argCount);
        System.arraycopy(roomSQLiteQuery.blobBindings, 0, this.blobBindings, 0, argCount);
        System.arraycopy(roomSQLiteQuery.doubleBindings, 0, this.doubleBindings, 0, argCount);
    }

    @Override // c0.j
    public int getArgCount() {
        return this.argCount;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    @Override // c0.j
    public String getSql() {
        String str = this.query;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final void init(String str, int i2) {
        x0.g.u(str, "query");
        this.query = str;
        this.argCount = i2;
    }

    public final void release() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = queryPool;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.capacity), this);
            Companion.prunePoolLocked$room_runtime_release();
        }
    }

    private RoomSQLiteQuery(int i2) {
        this.capacity = i2;
        int i3 = i2 + 1;
        this.bindingTypes = new int[i3];
        this.longBindings = new long[i3];
        this.doubleBindings = new double[i3];
        this.stringBindings = new String[i3];
        this.blobBindings = new byte[i3][];
    }
}
