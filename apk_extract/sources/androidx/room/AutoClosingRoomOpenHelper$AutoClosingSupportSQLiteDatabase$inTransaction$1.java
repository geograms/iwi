package androidx.room;

import c1.l;
import kotlin.jvm.internal.i;

/* loaded from: classes.dex */
public /* synthetic */ class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1 extends i implements l {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1();

    public AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1() {
        super("inTransaction", "inTransaction()Z");
    }

    @Override // c1.l
    public final Boolean invoke(c0.b bVar) {
        x0.g.u(bVar, "p0");
        return Boolean.valueOf(bVar.inTransaction());
    }
}
