package com.google.android.material.search;

/* loaded from: classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1593a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchView f1594b;

    public /* synthetic */ k(SearchView searchView, int i2) {
        this.f1593a = i2;
        this.f1594b = searchView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f1593a;
        SearchView searchView = this.f1594b;
        switch (i2) {
            case 0:
                searchView.lambda$requestFocusAndShowKeyboard$8();
                break;
            case 1:
                searchView.lambda$clearFocusAndHideKeyboard$9();
                break;
            default:
                searchView.requestFocusAndShowKeyboardIfNeeded();
                break;
        }
    }
}
