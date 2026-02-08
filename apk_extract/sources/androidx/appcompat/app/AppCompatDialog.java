package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.i;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionMode;
import androidx.core.view.p;
import x0.g;

/* loaded from: classes.dex */
public class AppCompatDialog extends i implements AppCompatCallback {
    private AppCompatDelegate mDelegate;
    private final p mKeyDispatcher;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatDialog(Context context, boolean z2, DialogInterface.OnCancelListener onCancelListener) {
        super(context, 0);
        g.u(context, "context");
        final int i2 = 0;
        this.mKeyDispatcher = new p(this) { // from class: androidx.appcompat.app.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AppCompatDialog f63b;

            {
                this.f63b = this;
            }

            @Override // androidx.core.view.p
            public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                int i3 = i2;
                return this.f63b.superDispatchKeyEvent(keyEvent);
            }
        };
        setCancelable(z2);
        setOnCancelListener(onCancelListener);
    }

    private static int getThemeResId(Context context, int i2) {
        if (i2 != 0) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().addContentView(view, layoutParams);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        getDelegate().onDestroy();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        getWindow().getDecorView();
        p pVar = this.mKeyDispatcher;
        if (pVar == null) {
            return false;
        }
        return pVar.superDispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i2) {
        return (T) getDelegate().findViewById(i2);
    }

    public AppCompatDelegate getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = AppCompatDelegate.create(this, this);
        }
        return this.mDelegate;
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().getSupportActionBar();
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    @Override // androidx.activity.i, android.app.Dialog
    public void onCreate(Bundle bundle) {
        getDelegate().installViewFactory();
        super.onCreate(bundle);
        getDelegate().onCreate(bundle);
    }

    @Override // androidx.activity.i, android.app.Dialog
    public void onStop() {
        super.onStop();
        getDelegate().onStop();
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeFinished(ActionMode actionMode) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeStarted(ActionMode actionMode) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback callback) {
        return null;
    }

    @Override // android.app.Dialog
    public void setContentView(int i2) {
        getDelegate().setContentView(i2);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        getDelegate().setTitle(charSequence);
    }

    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean supportRequestWindowFeature(int i2) {
        return getDelegate().requestWindowFeature(i2);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        getDelegate().setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().setContentView(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i2) {
        super.setTitle(i2);
        getDelegate().setTitle(getContext().getString(i2));
    }

    public AppCompatDialog(Context context) {
        this(context, 0);
    }

    public AppCompatDialog(Context context, int i2) {
        super(context, getThemeResId(context, i2));
        final int i3 = 1;
        this.mKeyDispatcher = new p(this) { // from class: androidx.appcompat.app.a

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AppCompatDialog f63b;

            {
                this.f63b = this;
            }

            @Override // androidx.core.view.p
            public final boolean superDispatchKeyEvent(KeyEvent keyEvent) {
                int i32 = i3;
                return this.f63b.superDispatchKeyEvent(keyEvent);
            }
        };
        AppCompatDelegate delegate = getDelegate();
        delegate.setTheme(getThemeResId(context, i2));
        delegate.onCreate(null);
    }
}
