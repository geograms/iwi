package androidx.room;

import c1.l;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$2 extends j implements l {
    final /* synthetic */ long $numBytes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$pageSize$2(long j2) {
        super(1);
        this.$numBytes = j2;
    }

    @Override // c1.l
    public final Object invoke(c0.b bVar) {
        x0.g.u(bVar, "db");
        bVar.setPageSize(this.$numBytes);
        return null;
    }
}
