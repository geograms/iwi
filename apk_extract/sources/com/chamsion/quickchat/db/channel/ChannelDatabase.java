package com.chamsion.quickchat.db.channel;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import k0.a;
import k0.f;
import k0.i;
import k0.j;
import k0.u;
import k0.x;

@Database(entities = {a.class, u.class}, exportSchema = false, version = 6)
/* loaded from: classes.dex */
public abstract class ChannelDatabase extends RoomDatabase {

    /* renamed from: a, reason: collision with root package name */
    public static volatile ChannelDatabase f1236a;

    /* renamed from: b, reason: collision with root package name */
    public static final ExecutorService f1237b = Executors.newFixedThreadPool(4);

    /* renamed from: c, reason: collision with root package name */
    public static final i f1238c = new i(0);

    /* renamed from: d, reason: collision with root package name */
    public static final j f1239d = new j();

    public static ChannelDatabase c(Context context) {
        if (f1236a == null) {
            synchronized (ChannelDatabase.class) {
                try {
                    if (f1236a == null) {
                        f1236a = (ChannelDatabase) Room.databaseBuilder(context.getApplicationContext(), ChannelDatabase.class, "channel_database").addCallback(f1239d).allowMainThreadQueries().addMigrations(f1238c).build();
                    }
                } finally {
                }
            }
        }
        return f1236a;
    }

    public abstract f a();

    public abstract x b();
}
