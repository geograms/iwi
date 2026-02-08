package com.google.android.material.color.utilities;

import java.util.function.Function;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1555a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1556b;

    public /* synthetic */ f(int i2, int i3) {
        this.f1555a = i3;
        this.f1556b = i2;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i2 = this.f1555a;
        int i3 = this.f1556b;
        DynamicScheme dynamicScheme = (DynamicScheme) obj;
        switch (i2) {
            case 0:
                return DynamicColor.lambda$fromArgb$3(i3, dynamicScheme);
            case 1:
                return DynamicColor.lambda$fromArgb$2(i3, dynamicScheme);
            default:
                return DynamicColor.lambda$fromArgb$4(i3, dynamicScheme);
        }
    }
}
