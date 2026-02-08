package androidx.room;

import android.util.Pair;
import c1.l;
import java.util.List;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$attachedDbs$1 extends j implements l {
    public static final AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$attachedDbs$1 INSTANCE = new AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$attachedDbs$1();

    public AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$attachedDbs$1() {
        super(1);
    }

    @Override // c1.l
    public final List<Pair<String, String>> invoke(c0.b bVar) {
        x0.g.u(bVar, "obj");
        return bVar.getAttachedDbs();
    }
}
