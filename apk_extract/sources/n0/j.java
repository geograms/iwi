package n0;

import androidx.room.RoomDatabase;
import com.chamsion.quickchat.db.message.MessageDatabase;

/* loaded from: classes.dex */
public final class j extends RoomDatabase.Callback {
    @Override // androidx.room.RoomDatabase.Callback
    public final void onCreate(c0.b bVar) {
        super.onCreate(bVar);
        MessageDatabase.f1252b.execute(new j0.a(5));
    }
}
