package k0;

import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import com.chamsion.quickchat.db.channel.ChannelDatabase_Impl;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class k extends RoomOpenHelper.Delegate {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ChannelDatabase_Impl f1988a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(ChannelDatabase_Impl channelDatabase_Impl) {
        super(6);
        this.f1988a = channelDatabase_Impl;
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void createAllTables(c0.b bVar) {
        bVar.execSQL("CREATE TABLE IF NOT EXISTS `channels` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `countryId` INTEGER NOT NULL, `channelIdInCountry` INTEGER NOT NULL, `channelName` TEXT, `channelType` INTEGER NOT NULL, `enbale` INTEGER NOT NULL, `smsType` INTEGER NOT NULL, `rx_freq` INTEGER NOT NULL, `tx_freq` INTEGER NOT NULL, `power` INTEGER NOT NULL, `pwrsave` INTEGER NOT NULL, `volume` INTEGER NOT NULL, `relay` INTEGER NOT NULL, `localId` INTEGER NOT NULL, `groupList` TEXT, `tx_contact` INTEGER NOT NULL, `contactType` INTEGER NOT NULL, `cc` INTEGER NOT NULL, `inboundSlot` INTEGER NOT NULL, `outboundSlot` INTEGER NOT NULL, `channelMode` INTEGER NOT NULL, `encryptSw` INTEGER NOT NULL, `encryptKey` TEXT, `mic` INTEGER NOT NULL, `band` INTEGER NOT NULL, `sq` INTEGER NOT NULL, `rx_type` INTEGER NOT NULL, `rx_subcode` INTEGER NOT NULL, `tx_type` INTEGER NOT NULL, `tx_subcode` INTEGER NOT NULL, `monitor` INTEGER NOT NULL, FOREIGN KEY(`countryId`) REFERENCES `countries`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        bVar.execSQL("CREATE INDEX IF NOT EXISTS `index_channels_countryId` ON `channels` (`countryId`)");
        bVar.execSQL("CREATE TABLE IF NOT EXISTS `countries` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `countryCode` TEXT, `isSelected` INTEGER NOT NULL)");
        bVar.execSQL(RoomMasterTable.CREATE_QUERY);
        bVar.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '4ba122d35db25c95058d160d321a681e')");
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void dropAllTables(c0.b bVar) {
        bVar.execSQL("DROP TABLE IF EXISTS `channels`");
        bVar.execSQL("DROP TABLE IF EXISTS `countries`");
        List list = ((RoomDatabase) this.f1988a).mCallbacks;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((RoomDatabase.Callback) it.next()).onDestructiveMigration(bVar);
            }
        }
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void onCreate(c0.b bVar) {
        List list = ((RoomDatabase) this.f1988a).mCallbacks;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((RoomDatabase.Callback) it.next()).onCreate(bVar);
            }
        }
    }

    @Override // androidx.room.RoomOpenHelper.Delegate
    public final void onOpen(c0.b bVar) {
        ChannelDatabase_Impl channelDatabase_Impl = this.f1988a;
        ((RoomDatabase) channelDatabase_Impl).mDatabase = bVar;
        bVar.execSQL("PRAGMA foreign_keys = ON");
        channelDatabase_Impl.internalInitInvalidationTracker(bVar);
        List list = ((RoomDatabase) channelDatabase_Impl).mCallbacks;
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
        HashMap map = new HashMap(31);
        map.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
        map.put("countryId", new TableInfo.Column("countryId", "INTEGER", true, 0, null, 1));
        map.put("channelIdInCountry", new TableInfo.Column("channelIdInCountry", "INTEGER", true, 0, null, 1));
        map.put("channelName", new TableInfo.Column("channelName", "TEXT", false, 0, null, 1));
        map.put("channelType", new TableInfo.Column("channelType", "INTEGER", true, 0, null, 1));
        map.put("enbale", new TableInfo.Column("enbale", "INTEGER", true, 0, null, 1));
        map.put("smsType", new TableInfo.Column("smsType", "INTEGER", true, 0, null, 1));
        map.put("rx_freq", new TableInfo.Column("rx_freq", "INTEGER", true, 0, null, 1));
        map.put("tx_freq", new TableInfo.Column("tx_freq", "INTEGER", true, 0, null, 1));
        map.put("power", new TableInfo.Column("power", "INTEGER", true, 0, null, 1));
        map.put("pwrsave", new TableInfo.Column("pwrsave", "INTEGER", true, 0, null, 1));
        map.put("volume", new TableInfo.Column("volume", "INTEGER", true, 0, null, 1));
        map.put("relay", new TableInfo.Column("relay", "INTEGER", true, 0, null, 1));
        map.put("localId", new TableInfo.Column("localId", "INTEGER", true, 0, null, 1));
        map.put("groupList", new TableInfo.Column("groupList", "TEXT", false, 0, null, 1));
        map.put("tx_contact", new TableInfo.Column("tx_contact", "INTEGER", true, 0, null, 1));
        map.put("contactType", new TableInfo.Column("contactType", "INTEGER", true, 0, null, 1));
        map.put("cc", new TableInfo.Column("cc", "INTEGER", true, 0, null, 1));
        map.put("inboundSlot", new TableInfo.Column("inboundSlot", "INTEGER", true, 0, null, 1));
        map.put("outboundSlot", new TableInfo.Column("outboundSlot", "INTEGER", true, 0, null, 1));
        map.put("channelMode", new TableInfo.Column("channelMode", "INTEGER", true, 0, null, 1));
        map.put("encryptSw", new TableInfo.Column("encryptSw", "INTEGER", true, 0, null, 1));
        map.put("encryptKey", new TableInfo.Column("encryptKey", "TEXT", false, 0, null, 1));
        map.put("mic", new TableInfo.Column("mic", "INTEGER", true, 0, null, 1));
        map.put("band", new TableInfo.Column("band", "INTEGER", true, 0, null, 1));
        map.put("sq", new TableInfo.Column("sq", "INTEGER", true, 0, null, 1));
        map.put("rx_type", new TableInfo.Column("rx_type", "INTEGER", true, 0, null, 1));
        map.put("rx_subcode", new TableInfo.Column("rx_subcode", "INTEGER", true, 0, null, 1));
        map.put("tx_type", new TableInfo.Column("tx_type", "INTEGER", true, 0, null, 1));
        map.put("tx_subcode", new TableInfo.Column("tx_subcode", "INTEGER", true, 0, null, 1));
        map.put("monitor", new TableInfo.Column("monitor", "INTEGER", true, 0, null, 1));
        HashSet hashSet = new HashSet(1);
        hashSet.add(new TableInfo.ForeignKey("countries", "CASCADE", "NO ACTION", Arrays.asList("countryId"), Arrays.asList("id")));
        HashSet hashSet2 = new HashSet(1);
        hashSet2.add(new TableInfo.Index("index_channels_countryId", false, Arrays.asList("countryId"), Arrays.asList("ASC")));
        TableInfo tableInfo = new TableInfo("channels", map, hashSet, hashSet2);
        TableInfo tableInfo2 = TableInfo.read(bVar, "channels");
        if (!tableInfo.equals(tableInfo2)) {
            return new RoomOpenHelper.ValidationResult(false, "channels(com.chamsion.quickchat.db.channel.Channel).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
        }
        HashMap map2 = new HashMap(3);
        map2.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
        map2.put("countryCode", new TableInfo.Column("countryCode", "TEXT", false, 0, null, 1));
        map2.put("isSelected", new TableInfo.Column("isSelected", "INTEGER", true, 0, null, 1));
        TableInfo tableInfo3 = new TableInfo("countries", map2, new HashSet(0), new HashSet(0));
        TableInfo tableInfo4 = TableInfo.read(bVar, "countries");
        if (tableInfo3.equals(tableInfo4)) {
            return new RoomOpenHelper.ValidationResult(true, null);
        }
        return new RoomOpenHelper.ValidationResult(false, "countries(com.chamsion.quickchat.db.channel.Country).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
    }
}
