package androidx.room;

import c1.l;
import java.util.Locale;
import kotlin.jvm.internal.j;

/* loaded from: classes.dex */
public final class AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setLocale$1 extends j implements l {
    final /* synthetic */ Locale $locale;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$setLocale$1(Locale locale) {
        super(1);
        this.$locale = locale;
    }

    @Override // c1.l
    public final Object invoke(c0.b bVar) {
        x0.g.u(bVar, "db");
        bVar.setLocale(this.$locale);
        return null;
    }
}
