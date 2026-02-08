package k0;

import androidx.room.RoomDatabase;
import androidx.room.SharedSQLiteStatement;

/* loaded from: classes.dex */
public final class w extends SharedSQLiteStatement {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2020a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2021b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w(Object obj, RoomDatabase roomDatabase, int i2) {
        super(roomDatabase);
        this.f2020a = i2;
        this.f2021b = obj;
    }

    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        switch (this.f2020a) {
            case 0:
                return "DELETE FROM countries";
            case 1:
                return "DELETE FROM channel_message_table";
            default:
                return "DELETE FROM contacts_table";
        }
    }
}
