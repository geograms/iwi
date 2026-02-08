package androidx.core.view;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* loaded from: classes.dex */
public final /* synthetic */ class o2 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f190a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f191b;

    public /* synthetic */ o2(int i2, View view) {
        this.f190a = i2;
        this.f191b = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f190a;
        View view = this.f191b;
        switch (i2) {
            case 0:
                ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
                break;
            default:
                view.requestLayout();
                break;
        }
    }
}
