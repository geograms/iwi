package com.google.android.material.timepicker;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1620a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1621b;

    public /* synthetic */ b(int i2, Object obj) {
        this.f1620a = i2;
        this.f1621b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f1620a;
        Object obj = this.f1621b;
        switch (i2) {
            case 0:
                ((RadialViewGroup) obj).updateLayoutParams();
                break;
            default:
                ((MaterialTimePicker) obj).lambda$onViewCreated$0();
                break;
        }
    }
}
