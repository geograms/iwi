package androidx.room;

import c1.l;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$2 extends j implements l {
    final /* synthetic */ int $version;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$version$2(int i2) {
        super(1);
        this.$version = i2;
    }

    @Override // c1.l
    public final Object invoke(c0.b bVar) {
        x0.g.u(bVar, "db");
        bVar.setVersion(this.$version);
        return null;
    }
}
