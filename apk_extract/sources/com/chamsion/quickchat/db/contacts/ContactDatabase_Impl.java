package com.chamsion.quickchat.db.contacts;

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
import m0.d;
import m0.f;

/* loaded from: classes.dex */
public final class ContactDatabase_Impl extends ContactDatabase {

    /* renamed from: e, reason: collision with root package name */
    public volatile d f1250e;

    @Override // com.chamsion.quickchat.db.contacts.ContactDatabase
    public final d a() {
        d dVar;
        if (this.f1250e != null) {
            return this.f1250e;
        }
        synchronized (this) {
            try {
                if (this.f1250e == null) {
                    this.f1250e = new d(this);
                }
                dVar = this.f1250e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    @Override // androidx.room.RoomDatabase
    public final void clearAllTables() {
        super.assertNotMainThread();
        b writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `contacts_table`");
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "contacts_table");
    }

    @Override // androidx.room.RoomDatabase
    public final h createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        RoomOpenHelper roomOpenHelper = new RoomOpenHelper(databaseConfiguration, new f(this), "58d953fab86c950f8d99095d4b5f47eb", "ecd99c0504d9994e0d5078fc808f5f89");
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
        map.put(d.class, Collections.emptyList());
        return map;
    }
}
