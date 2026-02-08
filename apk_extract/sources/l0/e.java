package l0;

import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import com.chamsion.quickchat.db.channelMessage.ChannelMessageDatabase_Impl;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class e extends RoomOpenHelper.Delegate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChannelMessageDatabase_Impl f2088a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(ChannelMessageDatabase_Impl channelMessageDatabase_Impl) {
        super(1);
        this.f2088a = channelMessageDatabase_Impl;
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void createAllTables(c0.b bVar) {
        bVar.execSQL("CREATE TABLE IF NOT EXISTS `channel_message_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `channelIndex` INTEGER NOT NULL, `channelName` TEXT, `timestamp` INTEGER NOT NULL, `msgCount` INTEGER NOT NULL)");
        bVar.execSQL(RoomMasterTable.CREATE_QUERY);
        bVar.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '81adfcaf667ba468ae19b2302714cbc0')");
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void dropAllTables(c0.b bVar) {
        bVar.execSQL("DROP TABLE IF EXISTS `channel_message_table`");
        List list = ((RoomDatabase) this.f2088a).mCallbacks;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((RoomDatabase.Callback) it.next()).onDestructiveMigration(bVar);
            }
        }
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void onCreate(c0.b bVar) {
        List list = ((RoomDatabase) this.f2088a).mCallbacks;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((RoomDatabase.Callback) it.next()).onCreate(bVar);
            }
        }
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void onOpen(c0.b bVar) {
        ChannelMessageDatabase_Impl channelMessageDatabase_Impl = this.f2088a;
        ((RoomDatabase) channelMessageDatabase_Impl).mDatabase = bVar;
        channelMessageDatabase_Impl.internalInitInvalidationTracker(bVar);
        List list = ((RoomDatabase) channelMessageDatabase_Impl).mCallbacks;
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
        HashMap map = new HashMap(5);
        map.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
        map.put("channelIndex", new TableInfo.Column("channelIndex", "INTEGER", true, 0, null, 1));
        map.put("channelName", new TableInfo.Column("channelName", "TEXT", false, 0, null, 1));
        map.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, 1));
        map.put("msgCount", new TableInfo.Column("msgCount", "INTEGER", true, 0, null, 1));
        TableInfo tableInfo = new TableInfo("channel_message_table", map, new HashSet(0), new HashSet(0));
        TableInfo tableInfo2 = TableInfo.read(bVar, "channel_message_table");
        if (tableInfo.equals(tableInfo2)) {
            return new RoomOpenHelper.ValidationResult(true, null);
        }
        return new RoomOpenHelper.ValidationResult(false, "channel_message_table(com.chamsion.quickchat.db.channelMessage.ChannelMessage).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
    }
}
