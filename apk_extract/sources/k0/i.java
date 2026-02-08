package k0;

import androidx.room.migration.Migration;

/* loaded from: classes.dex */
public final class i extends Migration {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1987a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(int i2) {
        super(1, 2);
        this.f1987a = i2;
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(c0.b bVar) {
        switch (this.f1987a) {
            case 0:
                bVar.execSQL("ALTER TABLE channel_table ADD COLUMN smsType INTEGER NOT NULL DEFAULT 3");
                break;
            case 1:
                try {
                    bVar.execSQL("ALTER TABLE Contact ADD COLUMN avatarData BLOB");
                    break;
                } catch (Exception unused) {
                    return;
                }
            default:
                try {
                    bVar.execSQL("ALTER TABLE Contact ADD COLUMN avatarData BLOB");
                    break;
                } catch (Exception unused2) {
                    return;
                }
        }
    }
}
