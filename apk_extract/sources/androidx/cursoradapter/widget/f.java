package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class f extends c {
    private int mDropDownLayout;
    private LayoutInflater mInflater;
    private int mLayout;

    public f(Context context, int i2) {
        init(context, (Cursor) null, 1);
        this.mDropDownLayout = i2;
        this.mLayout = i2;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // androidx.cursoradapter.widget.c
    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.mInflater.inflate(this.mDropDownLayout, viewGroup, false);
    }

    @Override // androidx.cursoradapter.widget.c
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.mInflater.inflate(this.mLayout, viewGroup, false);
    }

    public void setDropDownViewResource(int i2) {
        this.mDropDownLayout = i2;
    }

    public void setViewResource(int i2) {
        this.mLayout = i2;
    }
}
