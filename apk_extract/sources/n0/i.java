package n0;

import androidx.room.RoomDatabase;
import com.chamsion.quickchat.db.message.MessageDatabase;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final RoomDatabase f2175a;

    /* renamed from: b, reason: collision with root package name */
    public final k0.b f2176b;

    /* renamed from: c, reason: collision with root package name */
    public final h f2177c;

    /* renamed from: d, reason: collision with root package name */
    public final h f2178d;

    public i(MessageDatabase messageDatabase) {
        this.f2175a = messageDatabase;
        this.f2176b = new k0.b(this, messageDatabase, 4);
        int i2 = 0;
        new g(messageDatabase, i2);
        int i3 = 1;
        new g(messageDatabase, i3);
        this.f2177c = new h(messageDatabase, i2);
        this.f2178d = new h(messageDatabase, i3);
    }
}
