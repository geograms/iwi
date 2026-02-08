package m0;

import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import com.chamsion.quickchat.db.contacts.ContactDatabase_Impl;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class f extends RoomOpenHelper.Delegate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ContactDatabase_Impl f2106a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(ContactDatabase_Impl contactDatabase_Impl) {
        super(2);
        this.f2106a = contactDatabase_Impl;
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void createAllTables(c0.b bVar) {
        bVar.execSQL("CREATE TABLE IF NOT EXISTS `contacts_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `type` INTEGER NOT NULL, `name` TEXT, `number` INTEGER NOT NULL, `channel` TEXT, `channel_db_id` INTEGER NOT NULL, `logo` TEXT, `avatarData` BLOB)");
        bVar.execSQL(RoomMasterTable.CREATE_QUERY);
        bVar.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '58d953fab86c950f8d99095d4b5f47eb')");
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void dropAllTables(c0.b bVar) {
        bVar.execSQL("DROP TABLE IF EXISTS `contacts_table`");
        List list = ((RoomDatabase) this.f2106a).mCallbacks;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((RoomDatabase.Callback) it.next()).onDestructiveMigration(bVar);
            }
        }
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void onCreate(c0.b bVar) {
        List list = ((RoomDatabase) this.f2106a).mCallbacks;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((RoomDatabase.Callback) it.next()).onCreate(bVar);
            }
        }
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void onOpen(c0.b bVar) {
        ContactDatabase_Impl contactDatabase_Impl = this.f2106a;
        ((RoomDatabase) contactDatabase_Impl).mDatabase = bVar;
        contactDatabase_Impl.internalInitInvalidationTracker(bVar);
        List list = ((RoomDatabase) contactDatabase_Impl).mCallbacks;
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
        HashMap map = new HashMap(8);
        map.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
        map.put("type", new TableInfo.Column("type", "INTEGER", true, 0, null, 1));
        map.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, 1));
        map.put("number", new TableInfo.Column("number", "INTEGER", true, 0, null, 1));
        map.put("channel", new TableInfo.Column("channel", "TEXT", false, 0, null, 1));
        map.put("channel_db_id", new TableInfo.Column("channel_db_id", "INTEGER", true, 0, null, 1));
        map.put("logo", new TableInfo.Column("logo", "TEXT", false, 0, null, 1));
        map.put("avatarData", new TableInfo.Column("avatarData", "BLOB", false, 0, null, 1));
        TableInfo tableInfo = new TableInfo("contacts_table", map, new HashSet(0), new HashSet(0));
        TableInfo tableInfo2 = TableInfo.read(bVar, "contacts_table");
        if (tableInfo.equals(tableInfo2)) {
            return new RoomOpenHelper.ValidationResult(true, null);
        }
        return new RoomOpenHelper.ValidationResult(false, "contacts_table(com.chamsion.quickchat.db.contacts.Contact).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
    }
}
