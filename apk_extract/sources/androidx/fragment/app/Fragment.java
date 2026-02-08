package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.R$id;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, b0.g {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    v mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    private boolean mCalled;
    w0 mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    ViewModelProvider.Factory mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    w0 mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    k0 mHost;
    boolean mInLayout;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    private Boolean mIsPrimaryNavigationFragment;
    LayoutInflater mLayoutInflater;
    LifecycleRegistry mLifecycleRegistry;
    Lifecycle.State mMaxState;
    boolean mMenuVisible;
    private final AtomicInteger mNextLocalRequestCode;
    private final ArrayList<u> mOnPreAttachedListeners;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    Runnable mPostponedDurationRunnable;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    b0.f mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    int mState;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    String mTargetWho;
    boolean mUserVisibleHint;
    View mView;
    r1 mViewLifecycleOwner;
    MutableLiveData<LifecycleOwner> mViewLifecycleOwnerLiveData;
    String mWho;

    public Fragment() {
        this.mState = -1;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new x0();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new r(this, 0);
        this.mMaxState = Lifecycle.State.RESUMED;
        this.mViewLifecycleOwnerLiveData = new MutableLiveData<>();
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mOnPreAttachedListeners = new ArrayList<>();
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        this.mSavedStateRegistryController = new b0.f(this);
        this.mDefaultFactory = null;
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    public final v a() {
        if (this.mAnimationInfo == null) {
            v vVar = new v();
            vVar.f634k = null;
            Object obj = USE_DEFAULT_TRANSITION;
            vVar.f635l = obj;
            vVar.f636m = null;
            vVar.f637n = obj;
            vVar.f638o = null;
            vVar.f639p = obj;
            vVar.f642s = 1.0f;
            vVar.f643t = null;
            this.mAnimationInfo = vVar;
        }
        return this.mAnimationInfo;
    }

    public final int b() {
        Lifecycle.State state = this.mMaxState;
        return (state == Lifecycle.State.INITIALIZED || this.mParentFragment == null) ? state.ordinal() : Math.min(state.ordinal(), this.mParentFragment.b());
    }

    public final androidx.activity.result.e c(c.b bVar, f.a aVar, androidx.activity.result.c cVar) {
        if (this.mState > 1) {
            throw new IllegalStateException(v1.d("Fragment ", this, " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate())."));
        }
        AtomicReference atomicReference = new AtomicReference();
        u uVar = new u(this, aVar, atomicReference, bVar, cVar);
        if (this.mState >= 0) {
            atomicReference.set(((androidx.activity.result.h) aVar.apply(null)).c(generateActivityResultKey(), this, bVar, cVar));
        } else {
            this.mOnPreAttachedListeners.add(uVar);
        }
        return new androidx.activity.result.e(this, atomicReference, bVar, 2);
    }

    public void callStartTransitionListener(boolean z2) {
        ViewGroup viewGroup;
        w0 w0Var;
        v vVar = this.mAnimationInfo;
        if (vVar != null) {
            vVar.f644u = false;
            vVar.getClass();
            vVar.getClass();
        }
        if (this.mView == null || (viewGroup = this.mContainer) == null || (w0Var = this.mFragmentManager) == null) {
            return;
        }
        w1 w1VarG = w1.g(viewGroup, w0Var);
        w1VarG.h();
        if (z2) {
            this.mHost.f555c.post(new h(2, this, w1VarG));
        } else {
            w1VarG.c();
        }
    }

    public i0 createFragmentContainer() {
        return new s(this);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(getPopDirection());
        if (getEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(getEnterAnim());
        }
        if (getExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(getExitAnim());
        }
        if (getPopEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(getPopEnterAnim());
        }
        if (getPopExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
        }
        if (getContext() != null) {
            a0.a.a(this).b(str, printWriter);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.p(a.a.d(str, "  "), fileDescriptor, printWriter, strArr);
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Fragment findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.f649c.c(str);
    }

    public String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    public final c0 getActivity() {
        k0 k0Var = this.mHost;
        if (k0Var == null) {
            return null;
        }
        return (c0) k0Var.f553a;
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        v vVar = this.mAnimationInfo;
        if (vVar == null || (bool = vVar.f641r) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        v vVar = this.mAnimationInfo;
        if (vVar == null || (bool = vVar.f640q) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public View getAnimatingAway() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return null;
        }
        return vVar.f624a;
    }

    public Animator getAnimator() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return null;
        }
        return vVar.f625b;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final w0 getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException(v1.d("Fragment ", this, " has not been attached yet."));
    }

    public Context getContext() {
        k0 k0Var = this.mHost;
        if (k0Var == null) {
            return null;
        }
        return k0Var.f554b;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        Application application;
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.mDefaultFactory == null) {
            Context applicationContext = requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            if (application == null && Log.isLoggable("FragmentManager", 3)) {
                Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.mDefaultFactory = new SavedStateViewModelFactory(application, this, getArguments());
        }
        return this.mDefaultFactory;
    }

    public int getEnterAnim() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return 0;
        }
        return vVar.f627d;
    }

    public Object getEnterTransition() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return null;
        }
        return vVar.f634k;
    }

    public h.o getEnterTransitionCallback() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return null;
        }
        vVar.getClass();
        return null;
    }

    public int getExitAnim() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return 0;
        }
        return vVar.f628e;
    }

    public Object getExitTransition() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return null;
        }
        return vVar.f636m;
    }

    public h.o getExitTransitionCallback() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return null;
        }
        vVar.getClass();
        return null;
    }

    public View getFocusedView() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return null;
        }
        return vVar.f643t;
    }

    @Deprecated
    public final w0 getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        k0 k0Var = this.mHost;
        if (k0Var == null) {
            return null;
        }
        return ((b0) k0Var).f457e;
    }

    public final int getId() {
        return this.mFragmentId;
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        k0 k0Var = this.mHost;
        if (k0Var == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        c0 c0Var = ((b0) k0Var).f457e;
        LayoutInflater layoutInflaterCloneInContext = c0Var.getLayoutInflater().cloneInContext(c0Var);
        layoutInflaterCloneInContext.setFactory2(this.mChildFragmentManager.f652f);
        return layoutInflaterCloneInContext;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public a0.a getLoaderManager() {
        return a0.a.a(this);
    }

    public int getNextTransition() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return 0;
        }
        return vVar.f631h;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final w0 getParentFragmentManager() {
        w0 w0Var = this.mFragmentManager;
        if (w0Var != null) {
            return w0Var;
        }
        throw new IllegalStateException(v1.d("Fragment ", this, " not associated with a fragment manager."));
    }

    public boolean getPopDirection() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return false;
        }
        return vVar.f626c;
    }

    public int getPopEnterAnim() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return 0;
        }
        return vVar.f629f;
    }

    public int getPopExitAnim() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return 0;
        }
        return vVar.f630g;
    }

    public float getPostOnViewCreatedAlpha() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return 1.0f;
        }
        return vVar.f642s;
    }

    public Object getReenterTransition() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return null;
        }
        Object obj = vVar.f637n;
        return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return null;
        }
        Object obj = vVar.f635l;
        return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
    }

    @Override // b0.g
    public final b0.e getSavedStateRegistry() {
        return this.mSavedStateRegistryController.f1219b;
    }

    public Object getSharedElementEnterTransition() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return null;
        }
        return vVar.f638o;
    }

    public Object getSharedElementReturnTransition() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return null;
        }
        Object obj = vVar.f639p;
        return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
    }

    public ArrayList<String> getSharedElementSourceNames() {
        ArrayList<String> arrayList;
        v vVar = this.mAnimationInfo;
        return (vVar == null || (arrayList = vVar.f632i) == null) ? new ArrayList<>() : arrayList;
    }

    public ArrayList<String> getSharedElementTargetNames() {
        ArrayList<String> arrayList;
        v vVar = this.mAnimationInfo;
        return (vVar == null || (arrayList = vVar.f633j) == null) ? new ArrayList<>() : arrayList;
    }

    public final String getString(int i2) {
        return getResources().getString(i2);
    }

    public final String getTag() {
        return this.mTag;
    }

    @Deprecated
    public final Fragment getTargetFragment() {
        String str;
        Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        w0 w0Var = this.mFragmentManager;
        if (w0Var == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return w0Var.f649c.b(str);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i2) {
        return getResources().getText(i2);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public LifecycleOwner getViewLifecycleOwner() {
        r1 r1Var = this.mViewLifecycleOwner;
        if (r1Var != null) {
            return r1Var;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public LiveData<LifecycleOwner> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (b() == Lifecycle.State.INITIALIZED.ordinal()) {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        HashMap map = this.mFragmentManager.H.f439c;
        ViewModelStore viewModelStore = (ViewModelStore) map.get(this.mWho);
        if (viewModelStore != null) {
            return viewModelStore;
        }
        ViewModelStore viewModelStore2 = new ViewModelStore();
        map.put(this.mWho, viewModelStore2);
        return viewModelStore2;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void initState() {
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        this.mSavedStateRegistryController = new b0.f(this);
        this.mDefaultFactory = null;
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new x0();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    public boolean isHideReplaced() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return false;
        }
        return vVar.f645v;
    }

    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        Fragment fragment;
        return this.mMenuVisible && (this.mFragmentManager == null || (fragment = this.mParentFragment) == null || fragment.isMenuVisible());
    }

    public boolean isPostponed() {
        v vVar = this.mAnimationInfo;
        if (vVar == null) {
            return false;
        }
        return vVar.f644u;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isRemovingParent() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null && (parentFragment.isRemoving() || parentFragment.isRemovingParent());
    }

    public final boolean isResumed() {
        return this.mState >= 7;
    }

    public final boolean isStateSaved() {
        w0 w0Var = this.mFragmentManager;
        if (w0Var == null) {
            return false;
        }
        return w0Var.A || w0Var.B;
    }

    public final boolean isVisible() {
        View view;
        return (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    public void noteStateNotSaved() {
        this.mChildFragmentManager.F();
    }

    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i2 + " resultCode: " + i3 + " data: " + intent);
        }
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        w0 w0Var = this.mChildFragmentManager;
        if (w0Var.f661o >= 1) {
            return;
        }
        w0Var.A = false;
        w0Var.B = false;
        w0Var.H.f442f = false;
        w0Var.o(1);
    }

    public Animation onCreateAnimation(int i2, boolean z2, int i3) {
        return null;
    }

    public Animator onCreateAnimator(int i2, boolean z2, int i3) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2 = this.mContentLayoutId;
        if (i2 != 0) {
            return layoutInflater.inflate(i2, viewGroup, false);
        }
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean z2) {
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z2) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z2) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z2) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    public void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.F();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (!this.mCalled) {
            throw new x1(v1.d("Fragment ", this, " did not call through to super.onActivityCreated()"));
        }
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.mView != null) {
            restoreViewState(this.mSavedFragmentState);
        }
        this.mSavedFragmentState = null;
        w0 w0Var = this.mChildFragmentManager;
        w0Var.A = false;
        w0Var.B = false;
        w0Var.H.f442f = false;
        w0Var.o(4);
    }

    public void performAttach() {
        Iterator<u> it = this.mOnPreAttachedListeners.iterator();
        while (it.hasNext()) {
            u next = it.next();
            Fragment fragment = next.f612e;
            next.f609b.set(((androidx.activity.result.h) next.f608a.apply(null)).c(fragment.generateActivityResultKey(), fragment, next.f610c, next.f611d));
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.b(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach(this.mHost.f554b);
        if (!this.mCalled) {
            throw new x1(v1.d("Fragment ", this, " did not call through to super.onAttach()"));
        }
        Iterator it2 = this.mFragmentManager.f660n.iterator();
        while (it2.hasNext()) {
            ((b1) it2.next()).a(this);
        }
        w0 w0Var = this.mChildFragmentManager;
        w0Var.A = false;
        w0Var.B = false;
        w0Var.H.f442f = false;
        w0Var.o(0);
    }

    public void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
        for (Fragment fragment : this.mChildFragmentManager.f649c.f()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    public boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (onContextItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.h(menuItem);
    }

    public void performCreate(Bundle bundle) {
        this.mChildFragmentManager.F();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.addObserver(new LifecycleEventObserver() { // from class: androidx.fragment.app.Fragment.5
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                View view;
                if (event != Lifecycle.Event.ON_STOP || (view = Fragment.this.mView) == null) {
                    return;
                }
                view.cancelPendingInputEvents();
            }
        });
        this.mSavedStateRegistryController.b(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (!this.mCalled) {
            throw new x1(v1.d("Fragment ", this, " did not call through to super.onCreate()"));
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
    }

    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z2 = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onCreateOptionsMenu(menu, menuInflater);
            z2 = true;
        }
        return z2 | this.mChildFragmentManager.i(menu, menuInflater);
    }

    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.F();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new r1(this, getViewModelStore());
        View viewOnCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = viewOnCreateView;
        if (viewOnCreateView == null) {
            if (this.mViewLifecycleOwner.f596d != null) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.mViewLifecycleOwner = null;
            return;
        }
        this.mViewLifecycleOwner.b();
        ViewTreeLifecycleOwner.set(this.mView, this.mViewLifecycleOwner);
        ViewTreeViewModelStoreOwner.set(this.mView, this.mViewLifecycleOwner);
        View view = this.mView;
        r1 r1Var = this.mViewLifecycleOwner;
        x0.g.u(view, "<this>");
        view.setTag(R$id.view_tree_saved_state_registry_owner, r1Var);
        this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
    }

    public void performDestroy() {
        this.mChildFragmentManager.j();
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (!this.mCalled) {
            throw new x1(v1.d("Fragment ", this, " did not call through to super.onDestroy()"));
        }
    }

    public void performDestroyView() {
        this.mChildFragmentManager.o(1);
        if (this.mView != null) {
            r1 r1Var = this.mViewLifecycleOwner;
            r1Var.b();
            if (r1Var.f596d.getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                this.mViewLifecycleOwner.a(Lifecycle.Event.ON_DESTROY);
            }
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (!this.mCalled) {
            throw new x1(v1.d("Fragment ", this, " did not call through to super.onDestroyView()"));
        }
        g.m mVar = a0.a.a(this).f7b.f5a;
        if (mVar.f1816c <= 0) {
            this.mPerformedCreateView = false;
        } else {
            a.a.j(mVar.f1815b[0]);
            throw null;
        }
    }

    public void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (!this.mCalled) {
            throw new x1(v1.d("Fragment ", this, " did not call through to super.onDetach()"));
        }
        w0 w0Var = this.mChildFragmentManager;
        if (w0Var.C) {
            return;
        }
        w0Var.j();
        this.mChildFragmentManager = new x0();
    }

    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        LayoutInflater layoutInflaterOnGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = layoutInflaterOnGetLayoutInflater;
        return layoutInflaterOnGetLayoutInflater;
    }

    public void performLowMemory() {
        onLowMemory();
        for (Fragment fragment : this.mChildFragmentManager.f649c.f()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    public void performMultiWindowModeChanged(boolean z2) {
        onMultiWindowModeChanged(z2);
        for (Fragment fragment : this.mChildFragmentManager.f649c.f()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z2);
            }
        }
    }

    public boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.k(menuItem);
    }

    public void performOptionsMenuClosed(Menu menu) {
        if (this.mHidden) {
            return;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.l(menu);
    }

    public void performPause() {
        this.mChildFragmentManager.o(5);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(Lifecycle.Event.ON_PAUSE);
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            throw new x1(v1.d("Fragment ", this, " did not call through to super.onPause()"));
        }
    }

    public void performPictureInPictureModeChanged(boolean z2) {
        onPictureInPictureModeChanged(z2);
        for (Fragment fragment : this.mChildFragmentManager.f649c.f()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z2);
            }
        }
    }

    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z2 = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onPrepareOptionsMenu(menu);
            z2 = true;
        }
        return z2 | this.mChildFragmentManager.n(menu);
    }

    public void performPrimaryNavigationFragmentChanged() {
        this.mFragmentManager.getClass();
        boolean zC = w0.C(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != zC) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(zC);
            onPrimaryNavigationFragmentChanged(zC);
            w0 w0Var = this.mChildFragmentManager;
            w0Var.T();
            w0Var.m(w0Var.f665s);
        }
    }

    public void performResume() {
        this.mChildFragmentManager.F();
        this.mChildFragmentManager.s(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new x1(v1.d("Fragment ", this, " did not call through to super.onResume()"));
        }
        LifecycleRegistry lifecycleRegistry = this.mLifecycleRegistry;
        Lifecycle.Event event = Lifecycle.Event.ON_RESUME;
        lifecycleRegistry.handleLifecycleEvent(event);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(event);
        }
        w0 w0Var = this.mChildFragmentManager;
        w0Var.A = false;
        w0Var.B = false;
        w0Var.H.f442f = false;
        w0Var.o(7);
    }

    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.c(bundle);
        y0 y0VarL = this.mChildFragmentManager.L();
        if (y0VarL != null) {
            bundle.putParcelable("android:support:fragments", y0VarL);
        }
    }

    public void performStart() {
        this.mChildFragmentManager.F();
        this.mChildFragmentManager.s(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new x1(v1.d("Fragment ", this, " did not call through to super.onStart()"));
        }
        LifecycleRegistry lifecycleRegistry = this.mLifecycleRegistry;
        Lifecycle.Event event = Lifecycle.Event.ON_START;
        lifecycleRegistry.handleLifecycleEvent(event);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(event);
        }
        w0 w0Var = this.mChildFragmentManager;
        w0Var.A = false;
        w0Var.B = false;
        w0Var.H.f442f = false;
        w0Var.o(5);
    }

    public void performStop() {
        w0 w0Var = this.mChildFragmentManager;
        w0Var.B = true;
        w0Var.H.f442f = true;
        w0Var.o(4);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(Lifecycle.Event.ON_STOP);
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            throw new x1(v1.d("Fragment ", this, " did not call through to super.onStop()"));
        }
    }

    public void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.o(2);
    }

    public void postponeEnterTransition() {
        a().f644u = true;
    }

    public final <I, O> androidx.activity.result.d registerForActivityResult(c.b bVar, androidx.activity.result.c cVar) {
        return c(bVar, new t(0, this), cVar);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(String[] strArr, int i2) {
        if (this.mHost == null) {
            throw new IllegalStateException(v1.d("Fragment ", this, " not attached to Activity"));
        }
        w0 parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.f670x == null) {
            parentFragmentManager.f662p.getClass();
            return;
        }
        parentFragmentManager.f671y.addLast(new s0(this.mWho, i2));
        parentFragmentManager.f670x.a(strArr);
    }

    public final c0 requireActivity() {
        c0 activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException(v1.d("Fragment ", this, " not attached to an activity."));
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException(v1.d("Fragment ", this, " does not have any arguments."));
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException(v1.d("Fragment ", this, " not attached to a context."));
    }

    @Deprecated
    public final w0 requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException(v1.d("Fragment ", this, " not attached to a host."));
    }

    public final Fragment requireParentFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException(v1.d("Fragment ", this, " is not attached to any Fragment or host"));
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException(v1.d("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public void restoreChildFragmentState(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.mChildFragmentManager.K(parcelable);
        w0 w0Var = this.mChildFragmentManager;
        w0Var.A = false;
        w0Var.B = false;
        w0Var.H.f442f = false;
        w0Var.o(1);
    }

    public final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        if (this.mView != null) {
            r1 r1Var = this.mViewLifecycleOwner;
            r1Var.f597e.b(this.mSavedViewRegistryState);
            this.mSavedViewRegistryState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            throw new x1(v1.d("Fragment ", this, " did not call through to super.onViewStateRestored()"));
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(Lifecycle.Event.ON_CREATE);
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z2) {
        a().f641r = Boolean.valueOf(z2);
    }

    public void setAllowReturnTransitionOverlap(boolean z2) {
        a().f640q = Boolean.valueOf(z2);
    }

    public void setAnimatingAway(View view) {
        a().f624a = view;
    }

    public void setAnimations(int i2, int i3, int i4, int i5) {
        if (this.mAnimationInfo == null && i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            return;
        }
        a().f627d = i2;
        a().f628e = i3;
        a().f629f = i4;
        a().f630g = i5;
    }

    public void setAnimator(Animator animator) {
        a().f625b = animator;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    public void setEnterSharedElementCallback(h.o oVar) {
        a().getClass();
    }

    public void setEnterTransition(Object obj) {
        a().f634k = obj;
    }

    public void setExitSharedElementCallback(h.o oVar) {
        a().getClass();
    }

    public void setExitTransition(Object obj) {
        a().f636m = obj;
    }

    public void setFocusedView(View view) {
        a().f643t = view;
    }

    public void setHasOptionsMenu(boolean z2) {
        if (this.mHasMenu != z2) {
            this.mHasMenu = z2;
            if (!isAdded() || isHidden()) {
                return;
            }
            ((b0) this.mHost).f457e.supportInvalidateOptionsMenu();
        }
    }

    public void setHideReplaced(boolean z2) {
        a().f645v = z2;
    }

    public void setInitialSavedState(y yVar) {
        Bundle bundle;
        if (this.mFragmentManager != null) {
            throw new IllegalStateException("Fragment already added");
        }
        if (yVar == null || (bundle = yVar.f678a) == null) {
            bundle = null;
        }
        this.mSavedFragmentState = bundle;
    }

    public void setMenuVisibility(boolean z2) {
        if (this.mMenuVisible != z2) {
            this.mMenuVisible = z2;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                ((b0) this.mHost).f457e.supportInvalidateOptionsMenu();
            }
        }
    }

    public void setNextTransition(int i2) {
        if (this.mAnimationInfo == null && i2 == 0) {
            return;
        }
        a();
        this.mAnimationInfo.f631h = i2;
    }

    public void setOnStartEnterTransitionListener(x xVar) {
        a();
        v vVar = this.mAnimationInfo;
        vVar.getClass();
        if (xVar == null) {
            return;
        }
        if (vVar.f644u) {
            vVar.getClass();
        }
        if (xVar != null) {
            ((v0) xVar).f646a++;
        }
    }

    public void setPopDirection(boolean z2) {
        if (this.mAnimationInfo == null) {
            return;
        }
        a().f626c = z2;
    }

    public void setPostOnViewCreatedAlpha(float f2) {
        a().f642s = f2;
    }

    public void setReenterTransition(Object obj) {
        a().f637n = obj;
    }

    @Deprecated
    public void setRetainInstance(boolean z2) {
        this.mRetainInstance = z2;
        w0 w0Var = this.mFragmentManager;
        if (w0Var == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z2) {
            w0Var.H.a(this);
        } else {
            w0Var.H.b(this);
        }
    }

    public void setReturnTransition(Object obj) {
        a().f635l = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        a().f638o = obj;
    }

    public void setSharedElementNames(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        a();
        v vVar = this.mAnimationInfo;
        vVar.f632i = arrayList;
        vVar.f633j = arrayList2;
    }

    public void setSharedElementReturnTransition(Object obj) {
        a().f639p = obj;
    }

    @Deprecated
    public void setTargetFragment(Fragment fragment, int i2) {
        w0 w0Var = this.mFragmentManager;
        w0 w0Var2 = fragment != null ? fragment.mFragmentManager : null;
        if (w0Var != null && w0Var2 != null && w0Var != w0Var2) {
            throw new IllegalArgumentException(v1.d("Fragment ", fragment, " must share the same FragmentManager to be set as a target fragment"));
        }
        for (Fragment targetFragment = fragment; targetFragment != null; targetFragment = targetFragment.getTargetFragment()) {
            if (targetFragment.equals(this)) {
                throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
            }
        }
        if (fragment == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else if (this.mFragmentManager == null || fragment.mFragmentManager == null) {
            this.mTargetWho = null;
            this.mTarget = fragment;
        } else {
            this.mTargetWho = fragment.mWho;
            this.mTarget = null;
        }
        this.mTargetRequestCode = i2;
    }

    @Deprecated
    public void setUserVisibleHint(boolean z2) {
        boolean z3 = false;
        if (!this.mUserVisibleHint && z2 && this.mState < 5 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            w0 w0Var = this.mFragmentManager;
            e1 e1VarF = w0Var.f(this);
            Fragment fragment = e1VarF.f493c;
            if (fragment.mDeferStart) {
                if (w0Var.f648b) {
                    w0Var.D = true;
                } else {
                    fragment.mDeferStart = false;
                    e1VarF.k();
                }
            }
        }
        this.mUserVisibleHint = z2;
        if (this.mState < 5 && !z2) {
            z3 = true;
        }
        this.mDeferStart = z3;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z2);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        k0 k0Var = this.mHost;
        if (k0Var == null) {
            return false;
        }
        b0 b0Var = (b0) k0Var;
        b0Var.getClass();
        int i2 = h.f.f1829b;
        return h.c.c(b0Var.f457e, str);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent, Bundle bundle) {
        k0 k0Var = this.mHost;
        if (k0Var == null) {
            throw new IllegalStateException(v1.d("Fragment ", this, " not attached to Activity"));
        }
        Object obj = i.e.f1841a;
        i.a.b(k0Var.f554b, intent, bundle);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        startActivityForResult(intent, i2, null);
    }

    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        Intent intent2 = intent;
        if (this.mHost == null) {
            throw new IllegalStateException(v1.d("Fragment ", this, " not attached to Activity"));
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + i2 + " IntentSender: " + intentSender + " fillInIntent: " + intent + " options: " + bundle);
        }
        w0 parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.f669w == null) {
            k0 k0Var = parentFragmentManager.f662p;
            if (i2 != -1) {
                k0Var.getClass();
                throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
            }
            Activity activity = k0Var.f553a;
            int i6 = h.f.f1829b;
            h.a.c(activity, intentSender, i2, intent, i3, i4, i5, bundle);
            return;
        }
        if (bundle != null) {
            if (intent2 == null) {
                intent2 = new Intent();
                intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            }
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent2 + " for fragment " + this);
            }
            intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        androidx.activity.result.j jVar = new androidx.activity.result.j(intentSender, intent2, i3, i4);
        parentFragmentManager.f671y.addLast(new s0(this.mWho, i2));
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Fragment " + this + "is launching an IntentSender for result ");
        }
        parentFragmentManager.f669w.a(jVar);
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo == null || !a().f644u) {
            return;
        }
        if (this.mHost == null) {
            a().f644u = false;
        } else if (Looper.myLooper() != this.mHost.f555c.getLooper()) {
            this.mHost.f555c.postAtFrontOfQueue(new r(this, 1));
        } else {
            callStartTransitionListener(true);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(Optimizer.OPTIMIZATION_GRAPH_WRAP);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        sb.append(")");
        return sb.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        try {
            Fragment fragment = (Fragment) p0.b(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.setArguments(bundle);
            }
            return fragment;
        } catch (IllegalAccessException e2) {
            throw new w("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (InstantiationException e3) {
            throw new w("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        } catch (NoSuchMethodException e4) {
            throw new w("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e4);
        } catch (InvocationTargetException e5) {
            throw new w("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e5);
        }
    }

    public final String getString(int i2, Object... objArr) {
        return getResources().getString(i2, objArr);
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        k0 k0Var = this.mHost;
        Activity activity = k0Var == null ? null : k0Var.f553a;
        if (activity != null) {
            this.mCalled = false;
            onAttach(activity);
        }
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        k0 k0Var = this.mHost;
        Activity activity = k0Var == null ? null : k0Var.f553a;
        if (activity != null) {
            this.mCalled = false;
            onInflate(activity, attributeSet, bundle);
        }
    }

    public final void postponeEnterTransition(long j2, TimeUnit timeUnit) {
        a().f644u = true;
        w0 w0Var = this.mFragmentManager;
        Handler handler = w0Var != null ? w0Var.f662p.f555c : new Handler(Looper.getMainLooper());
        handler.removeCallbacks(this.mPostponedDurationRunnable);
        handler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j2));
    }

    public final <I, O> androidx.activity.result.d registerForActivityResult(c.b bVar, androidx.activity.result.h hVar, androidx.activity.result.c cVar) {
        return c(bVar, new d(this, hVar), cVar);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        if (this.mHost == null) {
            throw new IllegalStateException(v1.d("Fragment ", this, " not attached to Activity"));
        }
        w0 parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.f668v != null) {
            parentFragmentManager.f671y.addLast(new s0(this.mWho, i2));
            if (intent != null && bundle != null) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
            }
            parentFragmentManager.f668v.a(intent);
            return;
        }
        k0 k0Var = parentFragmentManager.f662p;
        k0Var.getClass();
        if (i2 != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        Object obj = i.e.f1841a;
        i.a.b(k0Var.f554b, intent, bundle);
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent) {
        startActivity(intent, null);
    }

    public Fragment(int i2) {
        this();
        this.mContentLayoutId = i2;
    }
}
