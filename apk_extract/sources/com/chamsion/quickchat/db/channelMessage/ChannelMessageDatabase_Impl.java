package com.chamsion.quickchat.db.channelMessage;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import c0.b;
import c0.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import l0.c;
import l0.e;

/* loaded from: classes.dex */
public final class ChannelMessageDatabase_Impl extends ChannelMessageDatabase {

    /* renamed from: d, reason: collision with root package name */
    public volatile c f1245d;

    @Override // com.chamsion.quickchat.db.channelMessage.ChannelMessageDatabase
    public final c b() {
        c cVar;
        if (this.f1245d != null) {
            return this.f1245d;
        }
        synchronized (this) {
            try {
                if (this.f1245d == null) {
                    this.f1245d = new c(this);
                }
                cVar = this.f1245d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return cVar;
    }

    @Override // androidx.room.RoomDatabase
    public final void clearAllTables() {
        super.assertNotMainThread();
        b writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `channel_message_table`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    public final InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "channel_message_table");
    }

    @Override // androidx.room.RoomDatabase
    public final h createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(databaseConfiguration, new e(this), "81adfcaf667ba468ae19b2302714cbc0", "bf5b49d6a1c94277aa6fd116fa401d52");
        c0.e eVarB = c.c.b(databaseConfiguration.context);
        eVarB.f1226b = databaseConfiguration.name;
        eVarB.f1227c = roomOpenHelper;
        return databaseConfiguration.sqliteOpenHelperFactory.create(eVarB.a());
    }

    @Override // androidx.room.RoomDatabase
    public final List getAutoMigrations(Map map) {
        return new ArrayList();
    }

    @Override // androidx.room.RoomDatabase
    public final Set getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public final Map getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(c.class, Collections.emptyList());
        return map;
    }
}
