package com.google.android.material.textfield;

import android.view.View;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1614a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EndIconDelegate f1615b;

    public /* synthetic */ d(EndIconDelegate endIconDelegate, int i2) {
        this.f1614a = i2;
        this.f1615b = endIconDelegate;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z2) {
        int i2 = this.f1614a;
        EndIconDelegate endIconDelegate = this.f1615b;
        switch (i2) {
            case 0:
                ((ClearTextEndIconDelegate) endIconDelegate).lambda$new$1(view, z2);
                break;
            default:
                ((DropdownMenuEndIconDelegate) endIconDelegate).lambda$new$1(view, z2);
                break;
        }
    }
}
