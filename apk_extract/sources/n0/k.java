package n0;

import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import com.chamsion.quickchat.db.message.MessageDatabase_Impl;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class k extends RoomOpenHelper.Delegate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MessageDatabase_Impl f2179a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(MessageDatabase_Impl messageDatabase_Impl) {
        super(2);
        this.f2179a = messageDatabase_Impl;
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void createAllTables(c0.b bVar) {
        bVar.execSQL("CREATE TABLE IF NOT EXISTS `message_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `channelIndex` INTEGER NOT NULL, `senderId` INTEGER NOT NULL, `senderName` TEXT, `receiverId` INTEGER NOT NULL, `groupId` INTEGER NOT NULL, `groupName` TEXT, `message` TEXT, `timestamp` INTEGER NOT NULL, `messageType` INTEGER NOT NULL, `messageDirection` INTEGER NOT NULL, `avatarData` BLOB, `receiverName` TEXT)");
        bVar.execSQL(RoomMasterTable.CREATE_QUERY);
        bVar.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'd328e261cb94651247f921b9e8bb5964')");
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void dropAllTables(c0.b bVar) {
        bVar.execSQL("DROP TABLE IF EXISTS `message_table`");
        List list = ((RoomDatabase) this.f2179a).mCallbacks;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((RoomDatabase.Callback) it.next()).onDestructiveMigration(bVar);
            }
        }
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void onCreate(c0.b bVar) {
        List list = ((RoomDatabase) this.f2179a).mCallbacks;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((RoomDatabase.Callback) it.next()).onCreate(bVar);
            }
        }
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void onOpen(c0.b bVar) {
        MessageDatabase_Impl messageDatabase_Impl = this.f2179a;
        ((RoomDatabase) messageDatabase_Impl).mDatabase = bVar;
        messageDatabase_Impl.internalInitInvalidationTracker(bVar);
        List list = ((RoomDatabase) messageDatabase_Impl).mCallbacks;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((RoomDatabase.Callback) it.next()).onOpen(bVar);
            }
        }
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void onPostMigrate(c0.b bVar) {
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void onPreMigrate(c0.b bVar) throws IOException {
        DBUtil.dropFtsSyncTriggers(bVar);
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final RoomOpenHelper.ValidationResult onValidateSchema(c0.b bVar) {
        HashMap map = new HashMap(13);
        map.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
        map.put("channelIndex", new TableInfo.Column("channelIndex", "INTEGER", true, 0, null, 1));
        map.put("senderId", new TableInfo.Column("senderId", "INTEGER", true, 0, null, 1));
        map.put("senderName", new TableInfo.Column("senderName", "TEXT", false, 0, null, 1));
        map.put("receiverId", new TableInfo.Column("receiverId", "INTEGER", true, 0, null, 1));
        map.put("groupId", new TableInfo.Column("groupId", "INTEGER", true, 0, null, 1));
        map.put("groupName", new TableInfo.Column("groupName", "TEXT", false, 0, null, 1));
        map.put("message", new TableInfo.Column("message", "TEXT", false, 0, null, 1));
        map.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, 1));
        map.put("messageType", new TableInfo.Column("messageType", "INTEGER", true, 0, null, 1));
        map.put("messageDirection", new TableInfo.Column("messageDirection", "INTEGER", true, 0, null, 1));
        map.put("avatarData", new TableInfo.Column("avatarData", "BLOB", false, 0, null, 1));
        map.put("receiverName", new TableInfo.Column("receiverName", "TEXT", false, 0, null, 1));
        TableInfo tableInfo = new TableInfo("message_table", map, new HashSet(0), new HashSet(0));
        TableInfo tableInfo2 = TableInfo.read(bVar, "message_table");
        if (tableInfo.equals(tableInfo2)) {
            return new RoomOpenHelper.ValidationResult(true, null);
        }
        return new RoomOpenHelper.ValidationResult(false, "message_table(com.chamsion.quickchat.db.message.Message).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
    }
}
