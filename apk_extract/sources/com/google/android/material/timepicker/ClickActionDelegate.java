package com.google.android.material.timepicker;

import android.content.Context;
import android.view.View;
import r.f;
import r.g;

/* loaded from: classes.dex */
class ClickActionDelegate extends androidx.core.view.c {
    private final f clickAction;

    public ClickActionDelegate(Context context, int i2) {
        this.clickAction = new f(16, context.getString(i2));
    }

    @Override // androidx.core.view.c
    public void onInitializeAccessibilityNodeInfo(View view, g gVar) {
        super.onInitializeAccessibilityNodeInfo(view, gVar);
        gVar.b(this.clickAction);
    }
}
