package androidx.cursoradapter.widget;

import android.database.Cursor;

/* loaded from: classes.dex */
public interface d {
    void changeCursor(Cursor cursor);

    CharSequence convertToString(Cursor cursor);

    Cursor getCursor();

    Cursor runQueryOnBackgroundThread(CharSequence charSequence);
}
