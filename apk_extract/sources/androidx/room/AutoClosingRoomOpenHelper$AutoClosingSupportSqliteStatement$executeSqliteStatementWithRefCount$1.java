package androidx.room;

import androidx.room.AutoClosingRoomOpenHelper;
import c0.k;
import c1.l;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeSqliteStatementWithRefCount$1 extends j implements l {
    final /* synthetic */ l $block;
    final /* synthetic */ AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoClosingRoomOpenHelper$AutoClosingSupportSqliteStatement$executeSqliteStatementWithRefCount$1(AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement autoClosingSupportSqliteStatement, l lVar) {
        super(1);
        this.this$0 = autoClosingSupportSqliteStatement;
        this.$block = lVar;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.Object] */
    @Override // c1.l
    public final T invoke(c0.b bVar) {
        x0.g.u(bVar, "db");
        k kVarCompileStatement = bVar.compileStatement(this.this$0.sql);
        this.this$0.doBinds(kVarCompileStatement);
        return this.$block.invoke(kVarCompileStatement);
    }
}
