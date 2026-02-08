package androidx.fragment.app;

import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

/* loaded from: classes.dex */
public final class b0 extends k0 implements ViewModelStoreOwner, androidx.activity.l, androidx.activity.result.i, b1 {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ c0 f457e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        this.f457e = appCompatActivity;
    }

    @Override // androidx.fragment.app.b1
    public final void a(Fragment fragment) {
        this.f457e.onAttachFragment(fragment);
    }

    @Override // androidx.fragment.app.i0
    public final View b(int i2) {
        return this.f457e.findViewById(i2);
    }

    @Override // androidx.fragment.app.i0
    public final boolean c() {
        Window window = this.f457e.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    @Override // androidx.activity.result.i
    public final androidx.activity.result.h getActivityResultRegistry() {
        return this.f457e.getActivityResultRegistry();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public final Lifecycle getLifecycle() {
        return this.f457e.mFragmentLifecycleRegistry;
    }

    @Override // androidx.activity.l
    public final androidx.activity.k getOnBackPressedDispatcher() {
        return this.f457e.getOnBackPressedDispatcher();
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public final ViewModelStore getViewModelStore() {
        return this.f457e.getViewModelStore();
    }
}
