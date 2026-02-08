package n0;

import androidx.room.SharedSQLiteStatement;
import com.chamsion.quickchat.db.message.MessageDatabase;

/* loaded from: classes.dex */
public final class h extends SharedSQLiteStatement {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2174a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(MessageDatabase messageDatabase, int i2) {
        super(messageDatabase);
        this.f2174a = i2;
    }

    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        switch (this.f2174a) {
            case 0:
                return "DELETE FROM message_table";
            default:
                return "DELETE FROM message_table WHERE (messageType = 0 AND (senderId = ? OR receiverId = ?)) OR (messageType = 1 AND groupId = ?)";
        }
    }
}
