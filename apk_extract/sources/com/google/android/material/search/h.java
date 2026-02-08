package com.google.android.material.search;

import android.view.View;

/* loaded from: classes.dex */
public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1587a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SearchView f1588b;

    public /* synthetic */ h(SearchView searchView, int i2) {
        this.f1587a = i2;
        this.f1588b = searchView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i2 = this.f1587a;
        SearchView searchView = this.f1588b;
        switch (i2) {
            case 0:
                searchView.lambda$setUpBackButton$1(view);
                break;
            case 1:
                searchView.lambda$setupWithSearchBar$7(view);
                break;
            default:
                searchView.lambda$setUpClearButton$2(view);
                break;
        }
    }
}
