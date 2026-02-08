package m0;

import androidx.room.RoomDatabase;
import com.chamsion.quickchat.db.contacts.ContactDatabase;

/* loaded from: classes.dex */
public final class e extends RoomDatabase.Callback {
    @Override // androidx.room.RoomDatabase.Callback
    public final void onCreate(c0.b bVar) {
        super.onCreate(bVar);
        ContactDatabase.f1247b.execute(new j0.a(4));
    }
}
