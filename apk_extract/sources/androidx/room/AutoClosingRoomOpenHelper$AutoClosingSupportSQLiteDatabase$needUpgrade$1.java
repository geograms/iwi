package androidx.room;

import c1.l;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$needUpgrade$1 extends j implements l {
    final /* synthetic */ int $newVersion;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$needUpgrade$1(int i2) {
        super(1);
        this.$newVersion = i2;
    }

    @Override // c1.l
    public final Boolean invoke(c0.b bVar) {
        x0.g.u(bVar, "db");
        return Boolean.valueOf(bVar.needUpgrade(this.$newVersion));
    }
}
