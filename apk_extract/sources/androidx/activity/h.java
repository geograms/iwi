package androidx.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Trace;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.core.view.u;
import androidx.core.view.w;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class h extends h.l implements ViewModelStoreOwner, HasDefaultViewModelProviderFactory, b0.g, l, androidx.activity.result.i {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final androidx.activity.result.h mActivityResultRegistry;
    private int mContentLayoutId;
    final b.a mContextAwareHelper;
    private ViewModelProvider.Factory mDefaultFactory;
    private final LifecycleRegistry mLifecycleRegistry;
    private final u mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    private final k mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<q.a> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<q.a> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<q.a> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<q.a> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<q.a> mOnTrimMemoryListeners;
    final b0.f mSavedStateRegistryController;
    private ViewModelStore mViewModelStore;

    public h() {
        this.mContextAwareHelper = new b.a();
        int i2 = 0;
        this.mMenuHostHelper = new u(new b(i2, this));
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        b0.f fVar = new b0.f(this);
        this.mSavedStateRegistryController = fVar;
        this.mOnBackPressedDispatcher = new k(new d(i2, this));
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new f(this);
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList<>();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        getLifecycle().addObserver(new LifecycleEventObserver() { // from class: androidx.activity.ComponentActivity$3
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_STOP) {
                    Window window = this.f9a.getWindow();
                    View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                    if (viewPeekDecorView != null) {
                        viewPeekDecorView.cancelPendingInputEvents();
                    }
                }
            }
        });
        getLifecycle().addObserver(new LifecycleEventObserver() { // from class: androidx.activity.ComponentActivity$4
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    this.f10a.mContextAwareHelper.f1209b = null;
                    if (this.f10a.isChangingConfigurations()) {
                        return;
                    }
                    this.f10a.getViewModelStore().clear();
                }
            }
        });
        getLifecycle().addObserver(new LifecycleEventObserver() { // from class: androidx.activity.ComponentActivity$5
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                h hVar = this.f11a;
                hVar.ensureViewModelStore();
                hVar.getLifecycle().removeObserver(this);
            }
        });
        fVar.a();
        SavedStateHandleSupport.enableSavedStateHandles(this);
        getSavedStateRegistry().c(ACTIVITY_RESULT_TAG, new androidx.lifecycle.a(2, this));
        addOnContextAvailableListener(new b.b() { // from class: androidx.activity.c
            @Override // b.b
            public final void onContextAvailable(Context context) {
                h.a(this.f19a);
            }
        });
    }

    public static void a(h hVar) {
        Bundle bundleA = hVar.getSavedStateRegistry().a(ACTIVITY_RESULT_TAG);
        if (bundleA != null) {
            androidx.activity.result.h hVar2 = hVar.mActivityResultRegistry;
            hVar2.getClass();
            ArrayList<Integer> integerArrayList = bundleA.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = bundleA.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList == null || integerArrayList == null) {
                return;
            }
            hVar2.f52e = bundleA.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
            hVar2.f48a = (Random) bundleA.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
            Bundle bundle = bundleA.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
            Bundle bundle2 = hVar2.f55h;
            bundle2.putAll(bundle);
            for (int i2 = 0; i2 < stringArrayList.size(); i2++) {
                String str = stringArrayList.get(i2);
                HashMap map = hVar2.f50c;
                boolean zContainsKey = map.containsKey(str);
                HashMap map2 = hVar2.f49b;
                if (zContainsKey) {
                    Integer num = (Integer) map.remove(str);
                    if (!bundle2.containsKey(str)) {
                        map2.remove(num);
                    }
                }
                int iIntValue = integerArrayList.get(i2).intValue();
                String str2 = stringArrayList.get(i2);
                map2.put(Integer.valueOf(iIntValue), str2);
                map.put(str2, Integer.valueOf(iIntValue));
            }
        }
    }

    public static Bundle b(h hVar) {
        hVar.getClass();
        Bundle bundle = new Bundle();
        androidx.activity.result.h hVar2 = hVar.mActivityResultRegistry;
        hVar2.getClass();
        HashMap map = hVar2.f50c;
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(map.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(map.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(hVar2.f52e));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) hVar2.f55h.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", hVar2.f48a);
        return bundle;
    }

    public void addMenuProvider(w wVar) {
        u uVar = this.mMenuHostHelper;
        uVar.f212b.add(null);
        uVar.f211a.run();
    }

    public final void addOnConfigurationChangedListener(q.a aVar) {
        this.mOnConfigurationChangedListeners.add(aVar);
    }

    public final void addOnContextAvailableListener(b.b bVar) {
        b.a aVar = this.mContextAwareHelper;
        if (aVar.f1209b != null) {
            bVar.onContextAvailable(aVar.f1209b);
        }
        aVar.f1208a.add(bVar);
    }

    public final void addOnMultiWindowModeChangedListener(q.a aVar) {
        this.mOnMultiWindowModeChangedListeners.add(aVar);
    }

    public final void addOnNewIntentListener(q.a aVar) {
        this.mOnNewIntentListeners.add(aVar);
    }

    public final void addOnPictureInPictureModeChangedListener(q.a aVar) {
        this.mOnPictureInPictureModeChangedListeners.add(aVar);
    }

    public final void addOnTrimMemoryListener(q.a aVar) {
        this.mOnTrimMemoryListeners.add(aVar);
    }

    public void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            g gVar = (g) getLastNonConfigurationInstance();
            if (gVar != null) {
                this.mViewModelStore = gVar.f28b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new ViewModelStore();
            }
        }
    }

    @Override // androidx.activity.result.i
    public final androidx.activity.result.h getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras();
        if (getApplication() != null) {
            mutableCreationExtras.set(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY, getApplication());
        }
        mutableCreationExtras.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        mutableCreationExtras.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            mutableCreationExtras.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, getIntent().getExtras());
        }
        return mutableCreationExtras;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory == null) {
            this.mDefaultFactory = new SavedStateViewModelFactory(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.mDefaultFactory;
    }

    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        g gVar = (g) getLastNonConfigurationInstance();
        if (gVar != null) {
            return gVar.f27a;
        }
        return null;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.activity.l
    public final k getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    @Override // b0.g
    public final b0.e getSavedStateRegistry() {
        return this.mSavedStateRegistryController.f1219b;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        ensureViewModelStore();
        return this.mViewModelStore;
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (this.mActivityResultRegistry.a(i2, i3, intent)) {
            return;
        }
        super.onActivityResult(i2, i3, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        this.mOnBackPressedDispatcher.b();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<q.a> it = this.mOnConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            ((o.g) it.next()).a(configuration);
        }
    }

    @Override // h.l, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.mSavedStateRegistryController.b(bundle);
        b.a aVar = this.mContextAwareHelper;
        aVar.f1209b = this;
        Iterator it = aVar.f1208a.iterator();
        while (it.hasNext()) {
            ((b.b) it.next()).onContextAvailable(this);
        }
        super.onCreate(bundle);
        ReportFragment.injectIfNeededIn(this);
        int i2 = this.mContentLayoutId;
        if (i2 != 0) {
            setContentView(i2);
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        u uVar = this.mMenuHostHelper;
        getMenuInflater();
        Iterator it = uVar.f212b.iterator();
        if (!it.hasNext()) {
            return true;
        }
        a.a.j(it.next());
        throw null;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z2, Configuration configuration) {
        Iterator<q.a> it = this.mOnMultiWindowModeChangedListeners.iterator();
        while (it.hasNext()) {
            ((o.g) it.next()).a(new c.c());
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator<q.a> it = this.mOnNewIntentListeners.iterator();
        while (it.hasNext()) {
            ((o.g) it.next()).a(intent);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (super.onOptionsItemSelected(menuItem)) {
            return true;
        }
        Iterator it = this.mMenuHostHelper.f212b.iterator();
        if (!it.hasNext()) {
            return false;
        }
        a.a.j(it.next());
        throw null;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i2, Menu menu) {
        Iterator it = this.mMenuHostHelper.f212b.iterator();
        if (it.hasNext()) {
            a.a.j(it.next());
            throw null;
        }
        super.onPanelClosed(i2, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z2, Configuration configuration) {
        Iterator<q.a> it = this.mOnPictureInPictureModeChangedListeners.iterator();
        while (it.hasNext()) {
            ((o.g) it.next()).a(new c.c());
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        Iterator it = this.mMenuHostHelper.f212b.iterator();
        if (!it.hasNext()) {
            return true;
        }
        a.a.j(it.next());
        throw null;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (this.mActivityResultRegistry.a(i2, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        g gVar;
        Object objOnRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        ViewModelStore viewModelStore = this.mViewModelStore;
        if (viewModelStore == null && (gVar = (g) getLastNonConfigurationInstance()) != null) {
            viewModelStore = gVar.f28b;
        }
        if (viewModelStore == null && objOnRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        g gVar2 = new g();
        gVar2.f27a = objOnRetainCustomNonConfigurationInstance;
        gVar2.f28b = viewModelStore;
        return gVar2;
    }

    @Override // h.l, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Lifecycle lifecycle = getLifecycle();
        if (lifecycle instanceof LifecycleRegistry) {
            ((LifecycleRegistry) lifecycle).setCurrentState(Lifecycle.State.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.c(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
        Iterator<q.a> it = this.mOnTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            ((o.g) it.next()).a(Integer.valueOf(i2));
        }
    }

    public Context peekAvailableContext() {
        return this.mContextAwareHelper.f1209b;
    }

    public final <I, O> androidx.activity.result.d registerForActivityResult(c.b bVar, androidx.activity.result.h hVar, androidx.activity.result.c cVar) {
        return hVar.c("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, bVar, cVar);
    }

    public void removeMenuProvider(w wVar) {
        this.mMenuHostHelper.c();
    }

    public final void removeOnConfigurationChangedListener(q.a aVar) {
        this.mOnConfigurationChangedListeners.remove(aVar);
    }

    public final void removeOnContextAvailableListener(b.b bVar) {
        this.mContextAwareHelper.f1208a.remove(bVar);
    }

    public final void removeOnMultiWindowModeChangedListener(q.a aVar) {
        this.mOnMultiWindowModeChangedListeners.remove(aVar);
    }

    public final void removeOnNewIntentListener(q.a aVar) {
        this.mOnNewIntentListeners.remove(aVar);
    }

    public final void removeOnPictureInPictureModeChangedListener(q.a aVar) {
        this.mOnPictureInPictureModeChangedListeners.remove(aVar);
    }

    public final void removeOnTrimMemoryListener(q.a aVar) {
        this.mOnTrimMemoryListeners.remove(aVar);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (x0.g.W()) {
                Trace.beginSection("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // android.app.Activity
    public abstract void setContentView(int i2);

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        ViewTreeLifecycleOwner.set(getWindow().getDecorView(), this);
        ViewTreeViewModelStoreOwner.set(getWindow().getDecorView(), this);
        View decorView = getWindow().getDecorView();
        x0.g.u(decorView, "<this>");
        decorView.setTag(androidx.savedstate.R$id.view_tree_saved_state_registry_owner, this);
        View decorView2 = getWindow().getDecorView();
        x0.g.u(decorView2, "<this>");
        decorView2.setTag(R$id.view_tree_on_back_pressed_dispatcher_owner, this);
        super.setContentView(view);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        super.startActivityForResult(intent, i2);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        super.startActivityForResult(intent, i2, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
    }

    public void addMenuProvider(w wVar, LifecycleOwner lifecycleOwner) {
        this.mMenuHostHelper.a(lifecycleOwner);
    }

    public final <I, O> androidx.activity.result.d registerForActivityResult(c.b bVar, androidx.activity.result.c cVar) {
        return registerForActivityResult(bVar, this.mActivityResultRegistry, cVar);
    }

    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(w wVar, LifecycleOwner lifecycleOwner, Lifecycle.State state) {
        this.mMenuHostHelper.b(lifecycleOwner, state);
    }

    public h(int i2) {
        this();
        this.mContentLayoutId = i2;
    }
}
