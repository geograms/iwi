package com.google.android.material.search;

/* loaded from: classes.dex */
public final /* synthetic */ class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1595a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1596b;

    public /* synthetic */ l(int i2, Object obj) {
        this.f1595a = i2;
        this.f1596b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f1595a;
        Object obj = this.f1596b;
        switch (i2) {
            case 0:
                ((SearchViewAnimationHelper) obj).lambda$startShowAnimationExpand$0();
                break;
            case 1:
                ((SearchViewAnimationHelper) obj).lambda$startShowAnimationTranslate$1();
                break;
            default:
                ((SearchBar) obj).lambda$startOnLoadAnimation$1();
                break;
        }
    }
}
