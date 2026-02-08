package androidx.room;

import android.content.Context;
import androidx.room.RoomDatabase;

/* loaded from: classes.dex */
public final class Room {
    private static final String CURSOR_CONV_SUFFIX = "_CursorConverter";
    public static final Room INSTANCE = new Room();
    public static final String LOG_TAG = "ROOM";
    public static final String MASTER_TABLE_NAME = "room_master_table";

    private Room() {
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T extends androidx.room.RoomDatabase> androidx.room.RoomDatabase.Builder<T> databaseBuilder(android.content.Context r5, java.lang.Class<T> r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "context"
            x0.g.u(r5, r0)
            java.lang.String r0 = "klass"
            x0.g.u(r6, r0)
            r0 = 1
            if (r7 == 0) goto L4f
            int r1 = r7.length()
            if (r1 == 0) goto L4f
            f1.c r1 = new f1.c
            int r2 = r7.length()
            int r2 = r2 - r0
            r3 = 0
            r1.<init>(r3, r2, r0)
            boolean r2 = r1 instanceof java.util.Collection
            if (r2 == 0) goto L2c
            r2 = r1
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L2c
            goto L4f
        L2c:
            java.util.Iterator r1 = r1.iterator()
        L30:
            r2 = r1
            f1.b r2 = (f1.b) r2
            boolean r2 = r2.f1768c
            if (r2 == 0) goto L4f
            r2 = r1
            f1.b r2 = (f1.b) r2
            int r2 = r2.b()
            char r2 = r7.charAt(r2)
            boolean r4 = java.lang.Character.isWhitespace(r2)
            if (r4 != 0) goto L30
            boolean r2 = java.lang.Character.isSpaceChar(r2)
            if (r2 == 0) goto L50
            goto L30
        L4f:
            r3 = r0
        L50:
            r0 = r0 ^ r3
            if (r0 == 0) goto L59
            androidx.room.RoomDatabase$Builder r0 = new androidx.room.RoomDatabase$Builder
            r0.<init>(r5, r6, r7)
            return r0
        L59:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder"
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.Room.databaseBuilder(android.content.Context, java.lang.Class, java.lang.String):androidx.room.RoomDatabase$Builder");
    }

    public static final <T, C> T getGeneratedImplementation(Class<C> cls, String str) throws ClassNotFoundException {
        String str2;
        x0.g.u(cls, "klass");
        x0.g.u(str, "suffix");
        Package r02 = cls.getPackage();
        x0.g.q(r02);
        String name = r02.getName();
        String canonicalName = cls.getCanonicalName();
        x0.g.q(canonicalName);
        x0.g.t(name, "fullPackage");
        if (name.length() != 0) {
            canonicalName = canonicalName.substring(name.length() + 1);
            x0.g.t(canonicalName, "this as java.lang.String).substring(startIndex)");
        }
        StringBuilder sb = new StringBuilder();
        String strReplace = canonicalName.replace('.', '_');
        x0.g.t(strReplace, "this as java.lang.String…replace(oldChar, newChar)");
        sb.append(strReplace);
        sb.append(str);
        String string = sb.toString();
        try {
            if (name.length() == 0) {
                str2 = string;
            } else {
                str2 = name + '.' + string;
            }
            Class<?> cls2 = Class.forName(str2, true, cls.getClassLoader());
            x0.g.r(cls2, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.Room.getGeneratedImplementation>");
            return (T) cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("Cannot find implementation for " + cls.getCanonicalName() + ". " + string + " does not exist");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("Cannot access the constructor " + cls.getCanonicalName());
        } catch (InstantiationException unused3) {
            throw new RuntimeException("Failed to create an instance of " + cls.getCanonicalName());
        }
    }

    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(Context context, Class<T> cls) {
        x0.g.u(context, "context");
        x0.g.u(cls, "klass");
        return new RoomDatabase.Builder<>(context, cls, null);
    }
}
