package com.chamsion.quickchat.db.channelMessage;

import androidx.fragment.app.c0;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import l0.a;
import l0.c;
import l0.d;

@Database(entities = {a.class}, exportSchema = false, version = 1)
/* loaded from: classes.dex */
public abstract class ChannelMessageDatabase extends RoomDatabase {

    /* renamed from: a, reason: collision with root package name */
    public static volatile ChannelMessageDatabase f1242a;

    /* renamed from: b, reason: collision with root package name */
    public static final ExecutorService f1243b = Executors.newFixedThreadPool(4);

    /* renamed from: c, reason: collision with root package name */
    public static final d f1244c = new d();

    public static ChannelMessageDatabase a(c0 c0Var) {
        if (f1242a == null) {
            synchronized (ChannelMessageDatabase.class) {
                try {
                    if (f1242a == null) {
                        f1242a = (ChannelMessageDatabase) Room.databaseBuilder(c0Var.getApplicationContext(), ChannelMessageDatabase.class, "channel_messages_database").addCallback(f1244c).allowMainThreadQueries().build();
                    }
                } finally {
                }
            }
        }
        return f1242a;
    }

    public abstract c b();
}
