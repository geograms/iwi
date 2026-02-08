package k0;

import androidx.room.RoomDatabase;
import com.chamsion.quickchat.db.channel.ChannelDatabase;

/* loaded from: classes.dex */
public final class j extends RoomDatabase.Callback {
    @Override // androidx.room.RoomDatabase.Callback
    public final void onCreate(c0.b bVar) {
        super.onCreate(bVar);
        ChannelDatabase.f1237b.execute(new j0.a(2));
    }
}
