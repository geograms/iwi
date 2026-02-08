package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class c0 extends androidx.activity.h implements h.d, h.e {
    static final String FRAGMENTS_TAG = "android:support:fragments";
    boolean mCreated;
    final LifecycleRegistry mFragmentLifecycleRegistry;
    final j0 mFragments;
    boolean mResumed;
    boolean mStopped;

    public c0() {
        this.mFragments = new j0(new b0((AppCompatActivity) this));
        this.mFragmentLifecycleRegistry = new LifecycleRegistry(this);
        this.mStopped = true;
        getSavedStateRegistry().c(FRAGMENTS_TAG, new z(this));
        addOnContextAvailableListener(new a0(this));
    }

    public static boolean c(w0 w0Var, Lifecycle.State state) {
        boolean zC = false;
        for (Fragment fragment : w0Var.f649c.f()) {
            if (fragment != null) {
                if (fragment.getHost() != null) {
                    zC |= c(fragment.getChildFragmentManager(), state);
                }
                r1 r1Var = fragment.mViewLifecycleOwner;
                if (r1Var != null) {
                    r1Var.b();
                    if (r1Var.f596d.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                        fragment.mViewLifecycleOwner.f596d.setCurrentState(state);
                        zC = true;
                    }
                }
                if (fragment.mLifecycleRegistry.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                    fragment.mLifecycleRegistry.setCurrentState(state);
                    zC = true;
                }
            }
        }
        return zC;
    }

    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.f547a.f556d.f652f.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            a0.a.a(this).b(str2, printWriter);
        }
        this.mFragments.f547a.f556d.p(str, fileDescriptor, printWriter, strArr);
    }

    public w0 getSupportFragmentManager() {
        return this.mFragments.f547a.f556d;
    }

    @Deprecated
    public a0.a getSupportLoaderManager() {
        return a0.a.a(this);
    }

    public void markFragmentsCreated() {
        while (c(getSupportFragmentManager(), Lifecycle.State.CREATED)) {
        }
    }

    @Override // androidx.activity.h, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        this.mFragments.a();
        super.onActivityResult(i2, i3, intent);
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    @Override // androidx.activity.h, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mFragments.a();
        super.onConfigurationChanged(configuration);
        for (Fragment fragment : this.mFragments.f547a.f556d.f649c.f()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    @Override // androidx.activity.h, h.l, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        x0 x0Var = this.mFragments.f547a.f556d;
        x0Var.A = false;
        x0Var.B = false;
        x0Var.H.f442f = false;
        x0Var.o(1);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i2, Menu menu) {
        if (i2 != 0) {
            return super.onCreatePanelMenu(i2, menu);
        }
        boolean zOnCreatePanelMenu = super.onCreatePanelMenu(i2, menu);
        j0 j0Var = this.mFragments;
        return j0Var.f547a.f556d.i(menu, getMenuInflater()) | zOnCreatePanelMenu;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mFragments.f547a.f556d.j();
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        for (Fragment fragment : this.mFragments.f547a.f556d.f649c.f()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 == 0) {
            return this.mFragments.f547a.f556d.k(menuItem);
        }
        if (i2 != 6) {
            return false;
        }
        return this.mFragments.f547a.f556d.h(menuItem);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z2) {
        for (Fragment fragment : this.mFragments.f547a.f556d.f649c.f()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z2);
            }
        }
    }

    @Override // androidx.activity.h, android.app.Activity
    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        this.mFragments.a();
        super.onNewIntent(intent);
    }

    @Override // androidx.activity.h, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        if (i2 == 0) {
            this.mFragments.f547a.f556d.l(menu);
        }
        super.onPanelClosed(i2, menu);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.f547a.f556d.o(5);
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z2) {
        for (Fragment fragment : this.mFragments.f547a.f556d.f649c.f()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z2);
            }
        }
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Deprecated
    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i2, View view, Menu menu) {
        if (i2 != 0) {
            return super.onPreparePanel(i2, view, menu);
        }
        return this.mFragments.f547a.f556d.n(menu) | onPrepareOptionsPanel(view, menu);
    }

    @Override // androidx.activity.h, android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.mFragments.a();
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // android.app.Activity
    public void onResume() {
        this.mFragments.a();
        super.onResume();
        this.mResumed = true;
        this.mFragments.f547a.f556d.s(true);
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        x0 x0Var = this.mFragments.f547a.f556d;
        x0Var.A = false;
        x0Var.B = false;
        x0Var.H.f442f = false;
        x0Var.o(7);
    }

    @Override // android.app.Activity
    public void onStart() {
        this.mFragments.a();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            x0 x0Var = this.mFragments.f547a.f556d;
            x0Var.A = false;
            x0Var.B = false;
            x0Var.H.f442f = false;
            x0Var.o(4);
        }
        this.mFragments.f547a.f556d.s(true);
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
        x0 x0Var2 = this.mFragments.f547a.f556d;
        x0Var2.A = false;
        x0Var2.B = false;
        x0Var2.H.f442f = false;
        x0Var2.o(5);
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.a();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        x0 x0Var = this.mFragments.f547a.f556d;
        x0Var.B = true;
        x0Var.H.f442f = true;
        x0Var.o(4);
        this.mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    public void setEnterSharedElementCallback(h.o oVar) {
        int i2 = h.f.f1829b;
        h.b.c(this, null);
    }

    public void setExitSharedElementCallback(h.o oVar) {
        int i2 = h.f.f1829b;
        h.b.d(this, null);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        startActivityFromFragment(fragment, intent, i2, (Bundle) null);
    }

    @Deprecated
    public void startIntentSenderFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        if (i2 != -1) {
            fragment.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
        } else {
            int i6 = h.f.f1829b;
            h.a.c(this, intentSender, i2, intent, i3, i4, i5, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        int i2 = h.f.f1829b;
        h.b.a(this);
    }

    public abstract void supportInvalidateOptionsMenu();

    public void supportPostponeEnterTransition() {
        int i2 = h.f.f1829b;
        h.b.b(this);
    }

    public void supportStartPostponedEnterTransition() {
        int i2 = h.f.f1829b;
        h.b.e(this);
    }

    @Override // h.e
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i2) {
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        if (i2 != -1) {
            fragment.startActivityForResult(intent, i2, bundle);
        } else {
            int i3 = h.f.f1829b;
            h.a.b(this, intent, -1, bundle);
        }
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    public c0(int i2) {
        super(i2);
        this.mFragments = new j0(new b0((AppCompatActivity) this));
        this.mFragmentLifecycleRegistry = new LifecycleRegistry(this);
        this.mStopped = true;
        getSavedStateRegistry().c(FRAGMENTS_TAG, new z(this));
        addOnContextAvailableListener(new a0(this));
    }
}
