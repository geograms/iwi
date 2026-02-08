package androidx.room;

import c1.l;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$execSQL$1 extends j implements l {
    final /* synthetic */ String $sql;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$execSQL$1(String str) {
        super(1);
        this.$sql = str;
    }

    @Override // c1.l
    public final Object invoke(c0.b bVar) {
        x0.g.u(bVar, "db");
        bVar.execSQL(this.$sql);
        return null;
    }
}
