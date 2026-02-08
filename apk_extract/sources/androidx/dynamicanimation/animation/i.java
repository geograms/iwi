package androidx.dynamicanimation.animation;

import android.util.FloatProperty;

/* loaded from: classes.dex */
public final class i extends j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FloatProperty f329a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(String str, FloatProperty floatProperty) {
        super(str);
        this.f329a = floatProperty;
    }

    @Override // androidx.dynamicanimation.animation.j
    public final float getValue(Object obj) {
        return ((Float) this.f329a.get(obj)).floatValue();
    }

    @Override // androidx.dynamicanimation.animation.j
    public final void setValue(Object obj, float f2) {
        this.f329a.setValue(obj, f2);
    }
}
