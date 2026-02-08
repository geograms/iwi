package androidx.room;

import c1.l;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setMaximumSize$1 extends j implements l {
    final /* synthetic */ long $numBytes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setMaximumSize$1(long j2) {
        super(1);
        this.$numBytes = j2;
    }

    @Override // c1.l
    public final Long invoke(c0.b bVar) {
        x0.g.u(bVar, "db");
        return Long.valueOf(bVar.setMaximumSize(this.$numBytes));
    }
}
