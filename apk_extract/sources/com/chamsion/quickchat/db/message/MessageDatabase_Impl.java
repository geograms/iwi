package com.chamsion.quickchat.db.message;

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
import n0.i;
import n0.k;

/* loaded from: classes.dex */
public final class MessageDatabase_Impl extends MessageDatabase {

    /* renamed from: e, reason: collision with root package name */
    public volatile i f1255e;

    @Override // com.chamsion.quickchat.db.message.MessageDatabase
    public final i b() {
        i iVar;
        if (this.f1255e != null) {
            return this.f1255e;
        }
        synchronized (this) {
            try {
                if (this.f1255e == null) {
                    this.f1255e = new i(this);
                }
                iVar = this.f1255e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iVar;
    }

    @Override // androidx.room.RoomDatabase
    public final void clearAllTables() {
        super.assertNotMainThread();
        b writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `message_table`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "message_table");
    }

    @Override // androidx.room.RoomDatabase
    public final h createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(databaseConfiguration, new k(this), "d328e261cb94651247f921b9e8bb5964", "2e36454272fb2a27211e5e0a49fcc609");
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
        map.put(i.class, Collections.emptyList());
        return map;
    }
}
