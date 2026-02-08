package com.google.android.material.timepicker;

import com.google.android.material.button.MaterialButtonToggleGroup;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements MaterialButtonToggleGroup.OnButtonCheckedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1622a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1623b;

    public /* synthetic */ c(int i2, Object obj) {
        this.f1622a = i2;
        this.f1623b = obj;
    }

    @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
    public final void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i2, boolean z2) {
        int i3 = this.f1622a;
        Object obj = this.f1623b;
        switch (i3) {
            case 0:
                ((TimePickerTextInputPresenter) obj).lambda$setupPeriodToggle$0(materialButtonToggleGroup, i2, z2);
                break;
            default:
                ((TimePickerView) obj).lambda$new$0(materialButtonToggleGroup, i2, z2);
                break;
        }
    }
}
