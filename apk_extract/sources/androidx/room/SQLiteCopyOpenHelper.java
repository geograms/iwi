package androidx.room;

import android.content.Context;
import android.util.Log;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.FileUtil;
import c0.h;
import d0.i;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class SQLiteCopyOpenHelper implements h, DelegatingOpenHelper {
    private final Context context;
    private final String copyFromAssetPath;
    private final File copyFromFile;
    private final Callable<InputStream> copyFromInputStream;
    private DatabaseConfiguration databaseConfiguration;
    private final int databaseVersion;
    private final h delegate;
    private boolean verified;

    public SQLiteCopyOpenHelper(Context context, String str, File file, Callable<InputStream> callable, int i2, h hVar) {
        x0.g.u(context, "context");
        x0.g.u(hVar, "delegate");
        this.context = context;
        this.copyFromAssetPath = str;
        this.copyFromFile = file;
        this.copyFromInputStream = callable;
        this.databaseVersion = i2;
        this.delegate = hVar;
    }

    private final void copyDatabaseFile(File file, boolean z2) throws IOException {
        ReadableByteChannel readableByteChannelNewChannel;
        if (this.copyFromAssetPath != null) {
            readableByteChannelNewChannel = Channels.newChannel(this.context.getAssets().open(this.copyFromAssetPath));
            x0.g.t(readableByteChannelNewChannel, "newChannel(context.assets.open(copyFromAssetPath))");
        } else if (this.copyFromFile != null) {
            readableByteChannelNewChannel = new FileInputStream(this.copyFromFile).getChannel();
            x0.g.t(readableByteChannelNewChannel, "FileInputStream(copyFromFile).channel");
        } else {
            Callable<InputStream> callable = this.copyFromInputStream;
            if (callable == null) {
                throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
            }
            try {
                readableByteChannelNewChannel = Channels.newChannel(callable.call());
                x0.g.t(readableByteChannelNewChannel, "newChannel(inputStream)");
            } catch (Exception e2) {
                throw new IOException("inputStreamCallable exception on call", e2);
            }
        }
        File fileCreateTempFile = File.createTempFile("room-copy-helper", ".tmp", this.context.getCacheDir());
        fileCreateTempFile.deleteOnExit();
        FileChannel channel = new FileOutputStream(fileCreateTempFile).getChannel();
        x0.g.t(channel, "output");
        FileUtil.copy(readableByteChannelNewChannel, channel);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        }
        dispatchOnOpenPrepackagedDatabase(fileCreateTempFile, z2);
        if (fileCreateTempFile.renameTo(file)) {
            return;
        }
        throw new IOException("Failed to move intermediate file (" + fileCreateTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
    }

    private final h createFrameworkOpenHelper(File file) {
        try {
            final int version = DBUtil.readVersion(file);
            c0.e eVarB = c.c.b(this.context);
            eVarB.f1226b = file.getAbsolutePath();
            final int i2 = version >= 1 ? version : 1;
            eVarB.f1227c = new c0.d(i2) { // from class: androidx.room.SQLiteCopyOpenHelper$createFrameworkOpenHelper$configuration$1
                @Override // c0.d
                public void onCreate(c0.b bVar) {
                    x0.g.u(bVar, "db");
                }

                @Override // c0.d
                public void onOpen(c0.b bVar) {
                    x0.g.u(bVar, "db");
                    int i3 = version;
                    if (i3 < 1) {
                        bVar.setVersion(i3);
                    }
                }

                @Override // c0.d
                public void onUpgrade(c0.b bVar, int i3, int i4) {
                    x0.g.u(bVar, "db");
                }
            };
            c0.f fVarA = eVarB.a();
            return new i(fVarA.f1228a, fVarA.f1229b, fVarA.f1230c, fVarA.f1231d, fVarA.f1232e);
        } catch (IOException e2) {
            throw new RuntimeException("Malformed database file, unable to read version.", e2);
        }
    }

    private final void dispatchOnOpenPrepackagedDatabase(File file, boolean z2) throws IOException {
        DatabaseConfiguration databaseConfiguration = this.databaseConfiguration;
        if (databaseConfiguration == null) {
            x0.g.B0("databaseConfiguration");
            throw null;
        }
        if (databaseConfiguration.prepackagedDatabaseCallback == null) {
            return;
        }
        h hVarCreateFrameworkOpenHelper = createFrameworkOpenHelper(file);
        try {
            c0.b writableDatabase = z2 ? hVarCreateFrameworkOpenHelper.getWritableDatabase() : hVarCreateFrameworkOpenHelper.getReadableDatabase();
            DatabaseConfiguration databaseConfiguration2 = this.databaseConfiguration;
            if (databaseConfiguration2 == null) {
                x0.g.B0("databaseConfiguration");
                throw null;
            }
            RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback = databaseConfiguration2.prepackagedDatabaseCallback;
            x0.g.q(prepackagedDatabaseCallback);
            prepackagedDatabaseCallback.onOpenPrepackagedDatabase(writableDatabase);
            x0.g.y(hVarCreateFrameworkOpenHelper, null);
        } finally {
        }
    }

    private final void verifyDatabaseFile(boolean z2) throws IOException {
        String databaseName = getDatabaseName();
        if (databaseName == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        File databasePath = this.context.getDatabasePath(databaseName);
        DatabaseConfiguration databaseConfiguration = this.databaseConfiguration;
        if (databaseConfiguration == null) {
            x0.g.B0("databaseConfiguration");
            throw null;
        }
        boolean z3 = databaseConfiguration.multiInstanceInvalidation;
        e0.a aVar = new e0.a(databaseName, this.context.getFilesDir(), z3);
        try {
            aVar.a(z3);
            if (!databasePath.exists()) {
                try {
                    copyDatabaseFile(databasePath, z2);
                    aVar.b();
                    return;
                } catch (IOException e2) {
                    throw new RuntimeException("Unable to copy database file.", e2);
                }
            }
            try {
                int version = DBUtil.readVersion(databasePath);
                int i2 = this.databaseVersion;
                if (version == i2) {
                    aVar.b();
                    return;
                }
                DatabaseConfiguration databaseConfiguration2 = this.databaseConfiguration;
                if (databaseConfiguration2 == null) {
                    x0.g.B0("databaseConfiguration");
                    throw null;
                }
                if (databaseConfiguration2.isMigrationRequired(version, i2)) {
                    aVar.b();
                    return;
                }
                if (this.context.deleteDatabase(databaseName)) {
                    try {
                        copyDatabaseFile(databasePath, z2);
                    } catch (IOException e3) {
                        Log.w(Room.LOG_TAG, "Unable to copy database file.", e3);
                    }
                } else {
                    Log.w(Room.LOG_TAG, "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                }
                aVar.b();
                return;
            } catch (IOException e4) {
                Log.w(Room.LOG_TAG, "Unable to read database version.", e4);
                aVar.b();
                return;
            }
        } catch (Throwable th) {
            aVar.b();
            throw th;
        }
        aVar.b();
        throw th;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        getDelegate().close();
        this.verified = false;
    }

    @Override // c0.h
    public String getDatabaseName() {
        return getDelegate().getDatabaseName();
    }

    @Override // androidx.room.DelegatingOpenHelper
    public h getDelegate() {
        return this.delegate;
    }

    @Override // c0.h
    public c0.b getReadableDatabase() throws IOException {
        if (!this.verified) {
            verifyDatabaseFile(false);
            this.verified = true;
        }
        return getDelegate().getReadableDatabase();
    }

    @Override // c0.h
    public c0.b getWritableDatabase() throws IOException {
        if (!this.verified) {
            verifyDatabaseFile(true);
            this.verified = true;
        }
        return getDelegate().getWritableDatabase();
    }

    public final void setDatabaseConfiguration(DatabaseConfiguration databaseConfiguration) {
        x0.g.u(databaseConfiguration, "databaseConfiguration");
        this.databaseConfiguration = databaseConfiguration;
    }

    @Override // c0.h
    public void setWriteAheadLoggingEnabled(boolean z2) {
        getDelegate().setWriteAheadLoggingEnabled(z2);
    }
}
