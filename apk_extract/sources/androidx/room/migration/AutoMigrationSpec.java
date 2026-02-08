package androidx.room.migration;

import c0.b;
import x0.g;

/* loaded from: classes.dex */
public interface AutoMigrationSpec {
    default void onPostMigrate(b bVar) {
        g.u(bVar, "db");
    }
}
