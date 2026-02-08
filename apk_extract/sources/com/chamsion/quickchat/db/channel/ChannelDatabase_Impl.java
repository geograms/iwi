package com.chamsion.quickchat.db.channel;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import c.c;
import c0.b;
import c0.e;
import c0.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k0.f;
import k0.k;
import k0.x;

/* loaded from: classes.dex */
public final class ChannelDatabase_Impl extends ChannelDatabase {

    /* renamed from: e, reason: collision with root package name */
    public volatile x f1240e;

    /* renamed from: f, reason: collision with root package name */
    public volatile f f1241f;

    @Override // com.chamsion.quickchat.db.channel.ChannelDatabase
    public final f a() {
        f fVar;
        if (this.f1241f != null) {
            return this.f1241f;
        }
        synchronized (this) {
            try {
                if (this.f1241f == null) {
                    this.f1241f = new f(this);
                }
                fVar = this.f1241f;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    @Override // com.chamsion.quickchat.db.channel.ChannelDatabase
    public final x b() {
        x xVar;
        if (this.f1240e != null) {
            return this.f1240e;
        }
        synchronized (this) {
            try {
                if (this.f1240e == null) {
                    this.f1240e = new x(this);
                }
                xVar = this.f1240e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return xVar;
    }

    @Override // androidx.room.RoomDatabase
    public final void clearAllTables() {
        super.assertNotMainThread();
        b writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("PRAGMA defer_foreign_keys = TRUE");
            writableDatabase.execSQL("DELETE FROM `channels`");
            writableDatabase.execSQL("DELETE FROM `countries`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "channels", "countries");
    }

    @Override // androidx.room.RoomDatabase
    public final h createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(databaseConfiguration, new k(this), "4ba122d35db25c95058d160d321a681e", "bd1c006dbe9f72f6520d25078a394763");
        e eVarB = c.b(databaseConfiguration.context);
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
        map.put(x.class, Collections.emptyList());
        map.put(f.class, Collections.emptyList());
        return map;
    }
}
