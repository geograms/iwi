package androidx.room;

import android.database.Cursor;
import androidx.room.migration.Migration;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class RoomOpenHelper extends c0.d {
    public static final Companion Companion = new Companion(null);
    private DatabaseConfiguration configuration;
    private final Delegate delegate;
    private final String identityHash;
    private final String legacyHash;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final boolean hasEmptySchema$room_runtime_release(c0.b bVar) throws IOException {
            x0.g.u(bVar, "db");
            Cursor cursorQuery = bVar.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
            try {
                boolean z2 = false;
                if (cursorQuery.moveToFirst()) {
                    if (cursorQuery.getInt(0) == 0) {
                        z2 = true;
                    }
                }
                x0.g.y(cursorQuery, null);
                return z2;
            } finally {
            }
        }

        public final boolean hasRoomMasterTable$room_runtime_release(c0.b bVar) throws IOException {
            x0.g.u(bVar, "db");
            Cursor cursorQuery = bVar.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
            try {
                boolean z2 = false;
                if (cursorQuery.moveToFirst()) {
                    if (cursorQuery.getInt(0) != 0) {
                        z2 = true;
                    }
                }
                x0.g.y(cursorQuery, null);
                return z2;
            } finally {
            }
        }
    }

    public static abstract class Delegate {
        public final int version;

        public Delegate(int i2) {
            this.version = i2;
        }

        public abstract void createAllTables(c0.b bVar);

        public abstract void dropAllTables(c0.b bVar);

        public abstract void onCreate(c0.b bVar);

        public abstract void onOpen(c0.b bVar);

        public void onPostMigrate(c0.b bVar) {
            x0.g.u(bVar, "db");
        }

        public void onPreMigrate(c0.b bVar) {
            x0.g.u(bVar, "db");
        }

        public ValidationResult onValidateSchema(c0.b bVar) {
            x0.g.u(bVar, "db");
            validateMigration(bVar);
            return new ValidationResult(true, null);
        }

        public void validateMigration(c0.b bVar) {
            x0.g.u(bVar, "db");
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    public static class ValidationResult {
        public final String expectedFoundMsg;
        public final boolean isValid;

        public ValidationResult(boolean z2, String str) {
            this.isValid = z2;
            this.expectedFoundMsg = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomOpenHelper(DatabaseConfiguration databaseConfiguration, Delegate delegate, String str, String str2) {
        super(delegate.version);
        x0.g.u(databaseConfiguration, "configuration");
        x0.g.u(delegate, "delegate");
        x0.g.u(str, "identityHash");
        x0.g.u(str2, "legacyHash");
        this.configuration = databaseConfiguration;
        this.delegate = delegate;
        this.identityHash = str;
        this.legacyHash = str2;
    }

    private final void checkIdentity(c0.b bVar) throws IOException {
        if (!Companion.hasRoomMasterTable$room_runtime_release(bVar)) {
            ValidationResult validationResultOnValidateSchema = this.delegate.onValidateSchema(bVar);
            if (validationResultOnValidateSchema.isValid) {
                this.delegate.onPostMigrate(bVar);
                updateIdentity(bVar);
                return;
            } else {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + validationResultOnValidateSchema.expectedFoundMsg);
            }
        }
        Cursor cursorQuery = bVar.query(new c0.a(RoomMasterTable.READ_QUERY));
        try {
            String string = cursorQuery.moveToFirst() ? cursorQuery.getString(0) : null;
            x0.g.y(cursorQuery, null);
            if (x0.g.g(this.identityHash, string) || x0.g.g(this.legacyHash, string)) {
                return;
            }
            throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + this.identityHash + ", found: " + string);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                x0.g.y(cursorQuery, th);
                throw th2;
            }
        }
    }

    private final void createMasterTableIfNotExists(c0.b bVar) {
        bVar.execSQL(RoomMasterTable.CREATE_QUERY);
    }

    private final void updateIdentity(c0.b bVar) {
        createMasterTableIfNotExists(bVar);
        bVar.execSQL(RoomMasterTable.createInsertQuery(this.identityHash));
    }

    @Override // c0.d
    public void onConfigure(c0.b bVar) {
        x0.g.u(bVar, "db");
        super.onConfigure(bVar);
    }

    @Override // c0.d
    public void onCreate(c0.b bVar) throws IOException {
        x0.g.u(bVar, "db");
        boolean zHasEmptySchema$room_runtime_release = Companion.hasEmptySchema$room_runtime_release(bVar);
        this.delegate.createAllTables(bVar);
        if (!zHasEmptySchema$room_runtime_release) {
            ValidationResult validationResultOnValidateSchema = this.delegate.onValidateSchema(bVar);
            if (!validationResultOnValidateSchema.isValid) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + validationResultOnValidateSchema.expectedFoundMsg);
            }
        }
        updateIdentity(bVar);
        this.delegate.onCreate(bVar);
    }

    @Override // c0.d
    public void onDowngrade(c0.b bVar, int i2, int i3) {
        x0.g.u(bVar, "db");
        onUpgrade(bVar, i2, i3);
    }

    @Override // c0.d
    public void onOpen(c0.b bVar) throws IOException {
        x0.g.u(bVar, "db");
        checkIdentity(bVar);
        this.delegate.onOpen(bVar);
        this.configuration = null;
    }

    @Override // c0.d
    public void onUpgrade(c0.b bVar, int i2, int i3) {
        List<Migration> listFindMigrationPath;
        x0.g.u(bVar, "db");
        DatabaseConfiguration databaseConfiguration = this.configuration;
        if (databaseConfiguration == null || (listFindMigrationPath = databaseConfiguration.migrationContainer.findMigrationPath(i2, i3)) == null) {
            DatabaseConfiguration databaseConfiguration2 = this.configuration;
            if (databaseConfiguration2 != null && !databaseConfiguration2.isMigrationRequired(i2, i3)) {
                this.delegate.dropAllTables(bVar);
                this.delegate.createAllTables(bVar);
                return;
            }
            throw new IllegalStateException("A migration from " + i2 + " to " + i3 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
        }
        this.delegate.onPreMigrate(bVar);
        Iterator<T> it = listFindMigrationPath.iterator();
        while (it.hasNext()) {
            ((Migration) it.next()).migrate(bVar);
        }
        ValidationResult validationResultOnValidateSchema = this.delegate.onValidateSchema(bVar);
        if (validationResultOnValidateSchema.isValid) {
            this.delegate.onPostMigrate(bVar);
            updateIdentity(bVar);
        } else {
            throw new IllegalStateException("Migration didn't properly handle: " + validationResultOnValidateSchema.expectedFoundMsg);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoomOpenHelper(DatabaseConfiguration databaseConfiguration, Delegate delegate, String str) {
        this(databaseConfiguration, delegate, "", str);
        x0.g.u(databaseConfiguration, "configuration");
        x0.g.u(delegate, "delegate");
        x0.g.u(str, "legacyHash");
    }
}
