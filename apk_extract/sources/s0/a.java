package s0;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: classes.dex */
public final class a extends SQLiteOpenHelper {
    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE SUPPORT_SCREENOFF_TALK (_id INTEGER PRIMARY KEY AUTOINCREMENT, dummy TEXT)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) throws SQLException {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS SUPPORT_SCREENOFF_TALK");
        sQLiteDatabase.execSQL("CREATE TABLE SUPPORT_SCREENOFF_TALK (_id INTEGER PRIMARY KEY AUTOINCREMENT, dummy TEXT)");
    }
}
