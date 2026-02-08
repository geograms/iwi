package com.chamsion.quickchat.db.contacts;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import k0.i;
import m0.a;
import m0.d;
import m0.e;
import x0.g;

@TypeConverters({g.class})
@Database(entities = {a.class}, exportSchema = false, version = 2)
/* loaded from: classes.dex */
public abstract class ContactDatabase extends RoomDatabase {

    /* renamed from: a, reason: collision with root package name */
    public static volatile ContactDatabase f1246a;

    /* renamed from: b, reason: collision with root package name */
    public static final ExecutorService f1247b = Executors.newFixedThreadPool(4);

    /* renamed from: c, reason: collision with root package name */
    public static final i f1248c = new i(1);

    /* renamed from: d, reason: collision with root package name */
    public static final e f1249d = new e();

    public static ContactDatabase b(Context context) {
        if (f1246a == null) {
            synchronized (ContactDatabase.class) {
                try {
                    if (f1246a == null) {
                        f1246a = (ContactDatabase) Room.databaseBuilder(context.getApplicationContext(), ContactDatabase.class, "contacts_database").addCallback(f1249d).allowMainThreadQueries().addMigrations(f1248c).build();
                    }
                } finally {
                }
            }
        }
        return f1246a;
    }

    public abstract d a();
}
