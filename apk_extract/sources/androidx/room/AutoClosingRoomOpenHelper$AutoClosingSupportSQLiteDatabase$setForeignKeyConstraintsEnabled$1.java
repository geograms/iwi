package androidx.room;

import c1.l;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setForeignKeyConstraintsEnabled$1 extends j implements l {
    final /* synthetic */ boolean $enabled;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setForeignKeyConstraintsEnabled$1(boolean z2) {
        super(1);
        this.$enabled = z2;
    }

    @Override // c1.l
    public final Object invoke(c0.b bVar) {
        x0.g.u(bVar, "db");
        bVar.setForeignKeyConstraintsEnabled(this.$enabled);
        return null;
    }
}
