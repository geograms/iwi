package m0;

import android.widget.CompoundButton;

/* loaded from: classes.dex */
public final class g implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2107a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f2108b;

    public g(k kVar, int i2) {
        this.f2108b = kVar;
        this.f2107a = i2;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        this.f2108b.f2124c.set(this.f2107a, Boolean.valueOf(!((Boolean) r1.get(r0)).booleanValue()));
    }
}
