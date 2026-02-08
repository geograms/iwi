package androidx.core.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
public abstract class f {
    private static final String TAG = "ActionProvider(support)";
    private final Context mContext;
    private d mSubUiVisibilityListener;
    private e mVisibilityListener;

    public f(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public abstract boolean hasSubMenu();

    public boolean isVisible() {
        return true;
    }

    public abstract View onCreateActionView();

    public View onCreateActionView(MenuItem menuItem) {
        return onCreateActionView();
    }

    public boolean onPerformDefaultAction() {
        return false;
    }

    public abstract void onPrepareSubMenu(SubMenu subMenu);

    public boolean overridesItemVisibility() {
        return false;
    }

    public void refreshVisibility() {
        if (this.mVisibilityListener == null || !overridesItemVisibility()) {
            return;
        }
        this.mVisibilityListener.onActionProviderVisibilityChanged(isVisible());
    }

    public void reset() {
        this.mVisibilityListener = null;
        this.mSubUiVisibilityListener = null;
    }

    public void setSubUiVisibilityListener(d dVar) {
        this.mSubUiVisibilityListener = dVar;
    }

    public void setVisibilityListener(e eVar) {
        if (this.mVisibilityListener != null && eVar != null) {
            Log.w(TAG, "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.mVisibilityListener = eVar;
    }

    public void subUiVisibilityChanged(boolean z2) {
        d dVar = this.mSubUiVisibilityListener;
        if (dVar != null) {
            dVar.onSubUiVisibilityChanged(z2);
        }
    }
}
