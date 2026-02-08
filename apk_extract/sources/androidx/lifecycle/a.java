package androidx.lifecycle;

import android.os.Bundle;
import androidx.activity.h;
import b0.d;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f688a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f689b;

    public /* synthetic */ a(int i2, Object obj) {
        this.f688a = i2;
        this.f689b = obj;
    }

    @Override // b0.d
    public final Bundle saveState() {
        int i2 = this.f688a;
        Object obj = this.f689b;
        switch (i2) {
            case 0:
                return SavedStateHandle.m1savedStateProvider$lambda0((SavedStateHandle) obj);
            case 1:
                return SavedStateHandle.m1savedStateProvider$lambda0((SavedStateHandle) obj);
            default:
                return h.b((h) obj);
        }
    }
}
