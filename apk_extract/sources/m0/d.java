package m0;

import androidx.room.RoomDatabase;
import com.chamsion.quickchat.db.contacts.ContactDatabase;
import k0.w;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final RoomDatabase f2101a;

    /* renamed from: b, reason: collision with root package name */
    public final k0.b f2102b;

    /* renamed from: c, reason: collision with root package name */
    public final b f2103c;

    /* renamed from: d, reason: collision with root package name */
    public final b f2104d;

    /* renamed from: e, reason: collision with root package name */
    public final w f2105e;

    public d(ContactDatabase contactDatabase) {
        this.f2101a = contactDatabase;
        this.f2102b = new k0.b(this, contactDatabase, 3);
        this.f2103c = new b(contactDatabase, 0);
        this.f2104d = new b(contactDatabase, 1);
        this.f2105e = new w(this, contactDatabase, 2);
    }
}
