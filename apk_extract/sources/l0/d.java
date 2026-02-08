package l0;

import androidx.room.RoomDatabase;
import com.chamsion.quickchat.db.channelMessage.ChannelMessageDatabase;

/* loaded from: classes.dex */
public final class d extends RoomDatabase.Callback {
    @Override // androidx.room.RoomDatabase.Callback
    public final void onCreate(c0.b bVar) {
        super.onCreate(bVar);
        ChannelMessageDatabase.f1243b.execute(new j0.a(3));
    }
}
