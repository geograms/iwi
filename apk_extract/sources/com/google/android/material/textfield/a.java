package com.google.android.material.textfield;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1608a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EndIconDelegate f1609b;

    public /* synthetic */ a(EndIconDelegate endIconDelegate, int i2) {
        this.f1608a = i2;
        this.f1609b = endIconDelegate;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f1608a;
        EndIconDelegate endIconDelegate = this.f1609b;
        switch (i2) {
            case 0:
                ((ClearTextEndIconDelegate) endIconDelegate).lambda$tearDown$2();
                break;
            default:
                ((DropdownMenuEndIconDelegate) endIconDelegate).lambda$afterEditTextChanged$3();
                break;
        }
    }
}
