package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.room.RoomDatabase;
import androidx.room.migration.AutoMigrationSpec;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import v0.k;

/* loaded from: classes.dex */
public class DatabaseConfiguration {
    public final boolean allowDestructiveMigrationOnDowngrade;
    public final boolean allowMainThreadQueries;
    public final List<AutoMigrationSpec> autoMigrationSpecs;
    public final List<RoomDatabase.Callback> callbacks;
    public final Context context;
    public final String copyFromAssetPath;
    public final File copyFromFile;
    public final Callable<InputStream> copyFromInputStream;
    public final RoomDatabase.JournalMode journalMode;
    public final RoomDatabase.MigrationContainer migrationContainer;
    private final Set<Integer> migrationNotRequiredFrom;
    public final boolean multiInstanceInvalidation;
    public final Intent multiInstanceInvalidationServiceIntent;
    public final String name;
    public final RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback;
    public final Executor queryExecutor;
    public final boolean requireMigration;
    public final c0.g sqliteOpenHelperFactory;
    public final Executor transactionExecutor;
    public final List<Object> typeConverters;

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"LambdaLast"})
    public DatabaseConfiguration(Context context, String str, c0.g gVar, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z2, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, Intent intent, boolean z3, boolean z4, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, List<? extends Object> list2, List<? extends AutoMigrationSpec> list3) {
        x0.g.u(context, "context");
        x0.g.u(gVar, "sqliteOpenHelperFactory");
        x0.g.u(migrationContainer, "migrationContainer");
        x0.g.u(journalMode, "journalMode");
        x0.g.u(executor, "queryExecutor");
        x0.g.u(executor2, "transactionExecutor");
        x0.g.u(list2, "typeConverters");
        x0.g.u(list3, "autoMigrationSpecs");
        this.context = context;
        this.name = str;
        this.sqliteOpenHelperFactory = gVar;
        this.migrationContainer = migrationContainer;
        this.callbacks = list;
        this.allowMainThreadQueries = z2;
        this.journalMode = journalMode;
        this.queryExecutor = executor;
        this.transactionExecutor = executor2;
        this.multiInstanceInvalidationServiceIntent = intent;
        this.requireMigration = z3;
        this.allowDestructiveMigrationOnDowngrade = z4;
        this.migrationNotRequiredFrom = set;
        this.copyFromAssetPath = str2;
        this.copyFromFile = file;
        this.copyFromInputStream = callable;
        this.prepackagedDatabaseCallback = prepackagedDatabaseCallback;
        this.typeConverters = list2;
        this.autoMigrationSpecs = list3;
        this.multiInstanceInvalidation = intent != null;
    }

    public boolean isMigrationRequired(int i2, int i3) {
        if ((i2 > i3 && this.allowDestructiveMigrationOnDowngrade) || !this.requireMigration) {
            return false;
        }
        Set<Integer> set = this.migrationNotRequiredFrom;
        return set == null || !set.contains(Integer.valueOf(i2));
    }

    public boolean isMigrationRequiredFrom(int i2) {
        return isMigrationRequired(i2, i2 + 1);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DatabaseConfiguration(Context context, String str, c0.g gVar, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z2, RoomDatabase.JournalMode journalMode, Executor executor, boolean z3, Set<Integer> set) {
        x0.g.u(context, "context");
        x0.g.u(gVar, "sqliteOpenHelperFactory");
        x0.g.u(migrationContainer, "migrationContainer");
        x0.g.u(journalMode, "journalMode");
        x0.g.u(executor, "queryExecutor");
        k kVar = k.f2600a;
        this(context, str, gVar, migrationContainer, list, z2, journalMode, executor, executor, (Intent) null, z3, false, set, (String) null, (File) null, (Callable<InputStream>) null, (RoomDatabase.PrepackagedDatabaseCallback) null, (List<? extends Object>) kVar, (List<? extends AutoMigrationSpec>) kVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DatabaseConfiguration(Context context, String str, c0.g gVar, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z2, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, boolean z3, boolean z4, boolean z5, Set<Integer> set) {
        x0.g.u(context, "context");
        x0.g.u(gVar, "sqliteOpenHelperFactory");
        x0.g.u(migrationContainer, "migrationContainer");
        x0.g.u(journalMode, "journalMode");
        x0.g.u(executor, "queryExecutor");
        x0.g.u(executor2, "transactionExecutor");
        Intent intent = z3 ? new Intent(context, (Class<?>) MultiInstanceInvalidationService.class) : null;
        k kVar = k.f2600a;
        this(context, str, gVar, migrationContainer, list, z2, journalMode, executor, executor2, intent, z4, z5, set, (String) null, (File) null, (Callable<InputStream>) null, (RoomDatabase.PrepackagedDatabaseCallback) null, kVar, kVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DatabaseConfiguration(Context context, String str, c0.g gVar, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z2, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, boolean z3, boolean z4, boolean z5, Set<Integer> set, String str2, File file) {
        x0.g.u(context, "context");
        x0.g.u(gVar, "sqliteOpenHelperFactory");
        x0.g.u(migrationContainer, "migrationContainer");
        x0.g.u(journalMode, "journalMode");
        x0.g.u(executor, "queryExecutor");
        x0.g.u(executor2, "transactionExecutor");
        Intent intent = z3 ? new Intent(context, (Class<?>) MultiInstanceInvalidationService.class) : null;
        k kVar = k.f2600a;
        this(context, str, gVar, migrationContainer, list, z2, journalMode, executor, executor2, intent, z4, z5, set, str2, file, (Callable<InputStream>) null, (RoomDatabase.PrepackagedDatabaseCallback) null, kVar, kVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public DatabaseConfiguration(Context context, String str, c0.g gVar, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z2, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, boolean z3, boolean z4, boolean z5, Set<Integer> set, String str2, File file, Callable<InputStream> callable) {
        x0.g.u(context, "context");
        x0.g.u(gVar, "sqliteOpenHelperFactory");
        x0.g.u(migrationContainer, "migrationContainer");
        x0.g.u(journalMode, "journalMode");
        x0.g.u(executor, "queryExecutor");
        x0.g.u(executor2, "transactionExecutor");
        Intent intent = z3 ? new Intent(context, (Class<?>) MultiInstanceInvalidationService.class) : null;
        k kVar = k.f2600a;
        this(context, str, gVar, migrationContainer, list, z2, journalMode, executor, executor2, intent, z4, z5, set, str2, file, callable, (RoomDatabase.PrepackagedDatabaseCallback) null, kVar, kVar);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @SuppressLint({"LambdaLast"})
    public DatabaseConfiguration(Context context, String str, c0.g gVar, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z2, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, boolean z3, boolean z4, boolean z5, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
        x0.g.u(context, "context");
        x0.g.u(gVar, "sqliteOpenHelperFactory");
        x0.g.u(migrationContainer, "migrationContainer");
        x0.g.u(journalMode, "journalMode");
        x0.g.u(executor, "queryExecutor");
        x0.g.u(executor2, "transactionExecutor");
        Intent intent = z3 ? new Intent(context, (Class<?>) MultiInstanceInvalidationService.class) : null;
        k kVar = k.f2600a;
        this(context, str, gVar, migrationContainer, list, z2, journalMode, executor, executor2, intent, z4, z5, set, str2, file, callable, prepackagedDatabaseCallback, kVar, kVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"LambdaLast"})
    public DatabaseConfiguration(Context context, String str, c0.g gVar, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z2, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, boolean z3, boolean z4, boolean z5, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, List<? extends Object> list2) {
        this(context, str, gVar, migrationContainer, list, z2, journalMode, executor, executor2, z3 ? new Intent(context, (Class<?>) MultiInstanceInvalidationService.class) : null, z4, z5, set, str2, file, callable, prepackagedDatabaseCallback, list2, k.f2600a);
        x0.g.u(context, "context");
        x0.g.u(gVar, "sqliteOpenHelperFactory");
        x0.g.u(migrationContainer, "migrationContainer");
        x0.g.u(journalMode, "journalMode");
        x0.g.u(executor, "queryExecutor");
        x0.g.u(executor2, "transactionExecutor");
        x0.g.u(list2, "typeConverters");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"LambdaLast"})
    public DatabaseConfiguration(Context context, String str, c0.g gVar, RoomDatabase.MigrationContainer migrationContainer, List<? extends RoomDatabase.Callback> list, boolean z2, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, boolean z3, boolean z4, boolean z5, Set<Integer> set, String str2, File file, Callable<InputStream> callable, RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, List<? extends Object> list2, List<? extends AutoMigrationSpec> list3) {
        this(context, str, gVar, migrationContainer, list, z2, journalMode, executor, executor2, z3 ? new Intent(context, (Class<?>) MultiInstanceInvalidationService.class) : null, z4, z5, set, str2, file, callable, (RoomDatabase.PrepackagedDatabaseCallback) null, list2, list3);
        x0.g.u(context, "context");
        x0.g.u(gVar, "sqliteOpenHelperFactory");
        x0.g.u(migrationContainer, "migrationContainer");
        x0.g.u(journalMode, "journalMode");
        x0.g.u(executor, "queryExecutor");
        x0.g.u(executor2, "transactionExecutor");
        x0.g.u(list2, "typeConverters");
        x0.g.u(list3, "autoMigrationSpecs");
    }
}
