package l0;

import androidx.room.RoomDatabase;
import com.chamsion.quickchat.db.channelMessage.ChannelMessageDatabase;
import k0.w;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final RoomDatabase f2086a;

    /* renamed from: b, reason: collision with root package name */
    public final w f2087b;

    public c(ChannelMessageDatabase channelMessageDatabase) {
        this.f2086a = channelMessageDatabase;
        new k0.b(this, channelMessageDatabase, 2);
        new b(channelMessageDatabase, 0);
        new b(channelMessageDatabase, 1);
        this.f2087b = new w(this, channelMessageDatabase, 1);
    }
}
