package k0;

import androidx.room.SharedSQLiteStatement;
import com.chamsion.quickchat.db.channel.ChannelDatabase;

/* loaded from: classes.dex */
public final class d extends SharedSQLiteStatement {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1973a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(ChannelDatabase channelDatabase, int i2) {
        super(channelDatabase);
        this.f1973a = i2;
    }

    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        switch (this.f1973a) {
            case 0:
                return "DELETE FROM channels";
            default:
                return "DELETE FROM channels WHERE countryId = ?";
        }
    }
}
