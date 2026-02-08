package androidx.room;

import c0.k;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class SharedSQLiteStatement$stmt$2 extends j implements c1.a {
    final /* synthetic */ SharedSQLiteStatement this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedSQLiteStatement$stmt$2(SharedSQLiteStatement sharedSQLiteStatement) {
        super(0);
        this.this$0 = sharedSQLiteStatement;
    }

    @Override // c1.a
    public final k invoke() {
        return this.this$0.createNewStatement();
    }
}
