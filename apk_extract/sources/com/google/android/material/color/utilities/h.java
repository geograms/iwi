package com.google.android.material.color.utilities;

import java.util.function.Function;

/* loaded from: classes.dex */
public final /* synthetic */ class h implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1558a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1559b;

    public /* synthetic */ h(int i2, Object obj) {
        this.f1558a = i2;
        this.f1559b = obj;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i2 = this.f1558a;
        Object obj2 = this.f1559b;
        switch (i2) {
            case 0:
                return DynamicColor.lambda$getTone$11((DynamicColor) obj2, (DynamicScheme) obj);
            case 1:
                return DynamicColor.lambda$fromArgb$0((TonalPalette) obj2, (DynamicScheme) obj);
            case 2:
                return DynamicColor.lambda$fromArgb$1((Hct) obj2, (DynamicScheme) obj);
            default:
                return ((TemperatureCache) obj2).lambda$getHctsByTemp$0((Hct) obj);
        }
    }
}
