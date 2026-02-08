package androidx.room;

import android.content.ContentValues;
import c1.l;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$insert$1 extends j implements l {
    final /* synthetic */ int $conflictAlgorithm;
    final /* synthetic */ String $table;
    final /* synthetic */ ContentValues $values;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$insert$1(String str, int i2, ContentValues contentValues) {
        super(1);
        this.$table = str;
        this.$conflictAlgorithm = i2;
        this.$values = contentValues;
    }

    @Override // c1.l
    public final Long invoke(c0.b bVar) {
        x0.g.u(bVar, "db");
        return Long.valueOf(bVar.insert(this.$table, this.$conflictAlgorithm, this.$values));
    }
}
