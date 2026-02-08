package com.chamsion.quickchat.db.message;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import k0.i;
import n0.e;
import n0.j;
import x0.g;

@TypeConverters({g.class})
@Database(entities = {e.class}, exportSchema = false, version = 2)
/* loaded from: classes.dex */
public abstract class MessageDatabase extends RoomDatabase {

    /* renamed from: a, reason: collision with root package name */
    public static volatile MessageDatabase f1251a;

    /* renamed from: b, reason: collision with root package name */
    public static final ExecutorService f1252b = Executors.newFixedThreadPool(4);

    /* renamed from: c, reason: collision with root package name */
    public static final i f1253c = new i(2);

    /* renamed from: d, reason: collision with root package name */
    public static final j f1254d = new j();

    public static MessageDatabase a(Context context) {
        if (f1251a == null) {
            synchronized (MessageDatabase.class) {
                try {
                    if (f1251a == null) {
                        f1251a = (MessageDatabase) Room.databaseBuilder(context.getApplicationContext(), MessageDatabase.class, "messages_database").addCallback(f1254d).allowMainThreadQueries().addMigrations(f1253c).build();
                    }
                } finally {
                }
            }
        }
        return f1251a;
    }

    public abstract n0.i b();
}
