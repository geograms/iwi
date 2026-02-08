package com.google.android.material.search;

import android.view.View;
import androidx.core.view.c0;
import androidx.core.view.n2;
import com.google.android.material.internal.ViewUtils;

/* loaded from: classes.dex */
public final /* synthetic */ class j implements c0, ViewUtils.OnApplyWindowInsetsListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchView f1592a;

    public /* synthetic */ j(SearchView searchView) {
        this.f1592a = searchView;
    }

    @Override // androidx.core.view.c0
    public final n2 onApplyWindowInsets(View view, n2 n2Var) {
        return this.f1592a.lambda$setUpStatusBarSpacerInsetListener$5(view, n2Var);
    }

    @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
    public final n2 onApplyWindowInsets(View view, n2 n2Var, ViewUtils.RelativePadding relativePadding) {
        return this.f1592a.lambda$setUpToolbarInsetListener$4(view, n2Var, relativePadding);
    }
}
