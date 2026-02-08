package com.google.android.material.textfield;

import android.view.View;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1612a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EndIconDelegate f1613b;

    public /* synthetic */ c(EndIconDelegate endIconDelegate, int i2) {
        this.f1612a = i2;
        this.f1613b = endIconDelegate;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i2 = this.f1612a;
        EndIconDelegate endIconDelegate = this.f1613b;
        switch (i2) {
            case 0:
                ((ClearTextEndIconDelegate) endIconDelegate).lambda$new$0(view);
                break;
            case 1:
                ((DropdownMenuEndIconDelegate) endIconDelegate).lambda$new$0(view);
                break;
            default:
                ((PasswordToggleEndIconDelegate) endIconDelegate).lambda$new$0(view);
                break;
        }
    }
}
