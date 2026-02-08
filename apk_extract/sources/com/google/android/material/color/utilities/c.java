package com.google.android.material.color.utilities;

import java.util.function.Function;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1549a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DynamicScheme f1550b;

    public /* synthetic */ c(int i2, DynamicScheme dynamicScheme) {
        this.f1549a = i2;
        this.f1550b = dynamicScheme;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i2 = this.f1549a;
        DynamicScheme dynamicScheme = this.f1550b;
        DynamicColor dynamicColor = (DynamicColor) obj;
        switch (i2) {
            case 0:
                return DynamicColor.lambda$toneMinContrastDefault$14(dynamicScheme, dynamicColor);
            case 1:
                return DynamicColor.lambda$getTone$9(dynamicScheme, dynamicColor);
            default:
                return DynamicColor.lambda$toneMaxContrastDefault$17(dynamicScheme, dynamicColor);
        }
    }
}
