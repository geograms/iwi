package m0;

import androidx.room.EntityDeletionOrUpdateAdapter;
import com.chamsion.quickchat.db.contacts.ContactDatabase;

/* loaded from: classes.dex */
public final class b extends EntityDeletionOrUpdateAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2098a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(ContactDatabase contactDatabase, int i2) {
        super(contactDatabase);
        this.f2098a = i2;
    }

    public final void a(c0.k kVar, a aVar) {
        switch (this.f2098a) {
            case 0:
                kVar.bindLong(1, aVar.f2090a);
                break;
            default:
                kVar.bindLong(1, aVar.f2090a);
                kVar.bindLong(2, aVar.f2091b);
                String str = aVar.f2092c;
                if (str == null) {
                    kVar.bindNull(3);
                } else {
                    kVar.bindString(3, str);
                }
                kVar.bindLong(4, aVar.f2093d);
                String str2 = aVar.f2094e;
                if (str2 == null) {
                    kVar.bindNull(5);
                } else {
                    kVar.bindString(5, str2);
                }
                kVar.bindLong(6, aVar.f2095f);
                String str3 = aVar.f2096g;
                if (str3 == null) {
                    kVar.bindNull(7);
                } else {
                    kVar.bindString(7, str3);
                }
                byte[] bArr = aVar.f2097h;
                if (bArr == null) {
                    kVar.bindNull(8);
                } else {
                    kVar.bindBlob(8, bArr);
                }
                kVar.bindLong(9, aVar.f2090a);
                break;
        }
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter
    public final /* bridge */ /* synthetic */ void bind(c0.k kVar, Object obj) {
        switch (this.f2098a) {
            case 0:
                a(kVar, (a) obj);
                break;
            default:
                a(kVar, (a) obj);
                break;
        }
    }

    @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        switch (this.f2098a) {
            case 0:
                return "DELETE FROM `contacts_table` WHERE `id` = ?";
            default:
                return "UPDATE OR ABORT `contacts_table` SET `id` = ?,`type` = ?,`name` = ?,`number` = ?,`channel` = ?,`channel_db_id` = ?,`logo` = ?,`avatarData` = ? WHERE `id` = ?";
        }
    }
}
