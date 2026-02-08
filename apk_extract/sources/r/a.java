package r;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    public final int f2488a;

    /* renamed from: b, reason: collision with root package name */
    public final g f2489b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2490c;

    public a(int i2, g gVar, int i3) {
        this.f2488a = i2;
        this.f2489b = gVar;
        this.f2490c = i3;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f2488a);
        this.f2489b.f2507a.performAction(this.f2490c, bundle);
    }
}
