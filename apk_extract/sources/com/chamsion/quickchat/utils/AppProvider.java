package com.chamsion.quickchat.utils;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import s0.a;

/* loaded from: classes.dex */
public class AppProvider extends ContentProvider {

    /* renamed from: b, reason: collision with root package name */
    public static final UriMatcher f1504b;

    /* renamed from: a, reason: collision with root package name */
    public a f1505a;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f1504b = uriMatcher;
        uriMatcher.addURI("com.chamsion.quickchat.provider", "SUPPORT_SCREENOFF_TALK", 100);
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri uri, String str, String[] strArr) {
        int iDelete = this.f1505a.getWritableDatabase().delete("SUPPORT_SCREENOFF_TALK", str, strArr);
        if (iDelete > 0) {
            getContext().getContentResolver().notifyChange(uri, null);
        }
        return iDelete;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri uri) {
        if (f1504b.match(uri) == 1) {
            return "vnd.android.cursor.dir/vnd.com.chamsion.quickchat.support_screenoff_talk";
        }
        throw new IllegalArgumentException("Unknown URI: " + uri);
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri uri, ContentValues contentValues) {
        long jInsert = this.f1505a.getWritableDatabase().insert("SUPPORT_SCREENOFF_TALK", null, contentValues);
        if (jInsert > 0) {
            Uri uriWithAppendedPath = Uri.withAppendedPath(uri, String.valueOf(jInsert));
            getContext().getContentResolver().notifyChange(uriWithAppendedPath, null);
            return uriWithAppendedPath;
        }
        throw new IllegalArgumentException("Failed to insert row into " + uri);
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        this.f1505a = new a(getContext(), "support_screenoff_talk.db", null, 1);
        return true;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor cursorQuery = this.f1505a.getReadableDatabase().query("SUPPORT_SCREENOFF_TALK", strArr, str, strArr2, null, null, str2);
        cursorQuery.setNotificationUri(getContext().getContentResolver(), uri);
        if (cursorQuery.getCount() > 0) {
            return cursorQuery;
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
