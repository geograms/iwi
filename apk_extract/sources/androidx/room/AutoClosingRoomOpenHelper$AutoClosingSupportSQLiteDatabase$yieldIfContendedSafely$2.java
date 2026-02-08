package androidx.room;

import c1.l;
import kotlin.jvm.internal.i;

/* loaded from: classes.dex */
public /* synthetic */ class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$2 extends i implements l {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$2 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$2();

    public AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$yieldIfContendedSafely$2() {
        super("yieldIfContendedSafely", "yieldIfContendedSafely()Z");
    }

    @Override // c1.l
    public final Boolean invoke(c0.b bVar) {
        x0.g.u(bVar, "p0");
        return Boolean.valueOf(bVar.yieldIfContendedSafely());
    }
}
