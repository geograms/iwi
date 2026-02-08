package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$id;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class e1 {

    /* renamed from: a, reason: collision with root package name */
    public final d f491a;

    /* renamed from: b, reason: collision with root package name */
    public final f1 f492b;

    /* renamed from: c, reason: collision with root package name */
    public final Fragment f493c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f494d = false;

    /* renamed from: e, reason: collision with root package name */
    public int f495e = -1;

    public e1(d dVar, f1 f1Var, Fragment fragment) {
        this.f491a = dVar;
        this.f492b = f1Var;
        this.f493c = fragment;
    }

    public final void a() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.f493c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + fragment);
        }
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        this.f491a.c(false);
    }

    public final void b() {
        View view;
        View view2;
        f1 f1Var = this.f492b;
        f1Var.getClass();
        Fragment fragment = this.f493c;
        ViewGroup viewGroup = fragment.mContainer;
        int iIndexOfChild = -1;
        if (viewGroup != null) {
            ArrayList arrayList = f1Var.f501a;
            int iIndexOf = arrayList.indexOf(fragment);
            int i2 = iIndexOf - 1;
            while (true) {
                if (i2 < 0) {
                    while (true) {
                        iIndexOf++;
                        if (iIndexOf >= arrayList.size()) {
                            break;
                        }
                        Fragment fragment2 = (Fragment) arrayList.get(iIndexOf);
                        if (fragment2.mContainer == viewGroup && (view = fragment2.mView) != null) {
                            iIndexOfChild = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    Fragment fragment3 = (Fragment) arrayList.get(i2);
                    if (fragment3.mContainer == viewGroup && (view2 = fragment3.mView) != null) {
                        iIndexOfChild = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    i2--;
                }
            }
        }
        fragment.mContainer.addView(fragment.mView, iIndexOfChild);
    }

    public final void c() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.f493c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "moveto ATTACHED: " + fragment);
        }
        Fragment fragment2 = fragment.mTarget;
        e1 e1Var = null;
        f1 f1Var = this.f492b;
        if (fragment2 != null) {
            e1 e1Var2 = (e1) f1Var.f502b.get(fragment2.mWho);
            if (e1Var2 == null) {
                throw new IllegalStateException("Fragment " + fragment + " declared target fragment " + fragment.mTarget + " that does not belong to this FragmentManager!");
            }
            fragment.mTargetWho = fragment.mTarget.mWho;
            fragment.mTarget = null;
            e1Var = e1Var2;
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (e1Var = (e1) f1Var.f502b.get(str)) == null) {
                StringBuilder sb = new StringBuilder("Fragment ");
                sb.append(fragment);
                sb.append(" declared target fragment ");
                throw new IllegalStateException(a.a.e(sb, fragment.mTargetWho, " that does not belong to this FragmentManager!"));
            }
        }
        if (e1Var != null) {
            e1Var.k();
        }
        w0 w0Var = fragment.mFragmentManager;
        fragment.mHost = w0Var.f662p;
        fragment.mParentFragment = w0Var.f664r;
        d dVar = this.f491a;
        dVar.i(false);
        fragment.performAttach();
        dVar.d(false);
    }

    public final int d() {
        u1 u1Var;
        Fragment fragment = this.f493c;
        if (fragment.mFragmentManager == null) {
            return fragment.mState;
        }
        int iMin = this.f495e;
        int i2 = d1.f480a[fragment.mMaxState.ordinal()];
        if (i2 != 1) {
            iMin = i2 != 2 ? i2 != 3 ? i2 != 4 ? Math.min(iMin, -1) : Math.min(iMin, 0) : Math.min(iMin, 1) : Math.min(iMin, 5);
        }
        if (fragment.mFromLayout) {
            if (fragment.mInLayout) {
                iMin = Math.max(this.f495e, 2);
                View view = fragment.mView;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.f495e < 4 ? Math.min(iMin, fragment.mState) : Math.min(iMin, 1);
            }
        }
        if (!fragment.mAdded) {
            iMin = Math.min(iMin, 1);
        }
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            w1 w1VarG = w1.g(viewGroup, fragment.getParentFragmentManager());
            w1VarG.getClass();
            u1 u1VarD = w1VarG.d(fragment);
            i = u1VarD != null ? u1VarD.f617b : 0;
            Iterator it = w1VarG.f675c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    u1Var = null;
                    break;
                }
                u1Var = (u1) it.next();
                if (u1Var.f618c.equals(fragment) && !u1Var.f621f) {
                    break;
                }
            }
            if (u1Var != null && (i == 0 || i == 1)) {
                i = u1Var.f617b;
            }
        }
        if (i == 2) {
            iMin = Math.min(iMin, 6);
        } else if (i == 3) {
            iMin = Math.max(iMin, 3);
        } else if (fragment.mRemoving) {
            iMin = fragment.isInBackStack() ? Math.min(iMin, 1) : Math.min(iMin, -1);
        }
        if (fragment.mDeferStart && fragment.mState < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + iMin + " for " + fragment);
        }
        return iMin;
    }

    public final void e() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.f493c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "moveto CREATED: " + fragment);
        }
        if (fragment.mIsCreated) {
            fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
            fragment.mState = 1;
        } else {
            d dVar = this.f491a;
            dVar.j(false);
            fragment.performCreate(fragment.mSavedFragmentState);
            dVar.e(false);
        }
    }

    public final void f() {
        String resourceName;
        Fragment fragment = this.f493c;
        if (fragment.mFromLayout) {
            return;
        }
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + fragment);
        }
        LayoutInflater layoutInflaterPerformGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup == null) {
            int i2 = fragment.mContainerId;
            if (i2 == 0) {
                viewGroup = null;
            } else {
                if (i2 == -1) {
                    throw new IllegalArgumentException(v1.d("Cannot create fragment ", fragment, " for a container view with no id"));
                }
                viewGroup = (ViewGroup) fragment.mFragmentManager.f663q.b(i2);
                if (viewGroup == null && !fragment.mRestored) {
                    try {
                        resourceName = fragment.getResources().getResourceName(fragment.mContainerId);
                    } catch (Resources.NotFoundException unused) {
                        resourceName = "unknown";
                    }
                    throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(fragment.mContainerId) + " (" + resourceName + ") for fragment " + fragment);
                }
            }
        }
        fragment.mContainer = viewGroup;
        fragment.performCreateView(layoutInflaterPerformGetLayoutInflater, viewGroup, fragment.mSavedFragmentState);
        View view = fragment.mView;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            fragment.mView.setTag(R$id.fragment_container_view_tag, fragment);
            if (viewGroup != null) {
                b();
            }
            if (fragment.mHidden) {
                fragment.mView.setVisibility(8);
            }
            View view2 = fragment.mView;
            WeakHashMap weakHashMap = androidx.core.view.d1.f138a;
            if (androidx.core.view.p0.b(view2)) {
                androidx.core.view.q0.c(fragment.mView);
            } else {
                View view3 = fragment.mView;
                view3.addOnAttachStateChangeListener(new l0(this, view3));
            }
            fragment.performViewCreated();
            this.f491a.o(false);
            int visibility = fragment.mView.getVisibility();
            fragment.setPostOnViewCreatedAlpha(fragment.mView.getAlpha());
            if (fragment.mContainer != null && visibility == 0) {
                View viewFindFocus = fragment.mView.findFocus();
                if (viewFindFocus != null) {
                    fragment.setFocusedView(viewFindFocus);
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + fragment);
                    }
                }
                fragment.mView.setAlpha(0.0f);
            }
        }
        fragment.mState = 2;
    }

    public final void g() {
        Fragment fragmentB;
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.f493c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "movefrom CREATED: " + fragment);
        }
        boolean zIsChangingConfigurations = true;
        boolean z2 = fragment.mRemoving && !fragment.isInBackStack();
        f1 f1Var = this.f492b;
        if (!z2) {
            a1 a1Var = f1Var.f503c;
            if (a1Var.f437a.containsKey(fragment.mWho) && a1Var.f440d && !a1Var.f441e) {
                String str = fragment.mTargetWho;
                if (str != null && (fragmentB = f1Var.b(str)) != null && fragmentB.mRetainInstance) {
                    fragment.mTarget = fragmentB;
                }
                fragment.mState = 0;
                return;
            }
        }
        k0 k0Var = fragment.mHost;
        if (k0Var instanceof ViewModelStoreOwner) {
            zIsChangingConfigurations = f1Var.f503c.f441e;
        } else {
            Context context = k0Var.f554b;
            if (context instanceof Activity) {
                zIsChangingConfigurations = true ^ ((Activity) context).isChangingConfigurations();
            }
        }
        if (z2 || zIsChangingConfigurations) {
            a1 a1Var2 = f1Var.f503c;
            a1Var2.getClass();
            if (Log.isLoggable("FragmentManager", 3)) {
                Log.d("FragmentManager", "Clearing non-config state for " + fragment);
            }
            HashMap map = a1Var2.f438b;
            a1 a1Var3 = (a1) map.get(fragment.mWho);
            if (a1Var3 != null) {
                a1Var3.onCleared();
                map.remove(fragment.mWho);
            }
            HashMap map2 = a1Var2.f439c;
            ViewModelStore viewModelStore = (ViewModelStore) map2.get(fragment.mWho);
            if (viewModelStore != null) {
                viewModelStore.clear();
                map2.remove(fragment.mWho);
            }
        }
        fragment.performDestroy();
        this.f491a.f(false);
        Iterator it = f1Var.d().iterator();
        while (it.hasNext()) {
            e1 e1Var = (e1) it.next();
            if (e1Var != null) {
                String str2 = fragment.mWho;
                Fragment fragment2 = e1Var.f493c;
                if (str2.equals(fragment2.mTargetWho)) {
                    fragment2.mTarget = fragment;
                    fragment2.mTargetWho = null;
                }
            }
        }
        String str3 = fragment.mTargetWho;
        if (str3 != null) {
            fragment.mTarget = f1Var.b(str3);
        }
        f1Var.h(this);
    }

    public final void h() {
        View view;
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.f493c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + fragment);
        }
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        fragment.performDestroyView();
        this.f491a.p(false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.setValue(null);
        fragment.mInLayout = false;
    }

    public final void i() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.f493c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + fragment);
        }
        fragment.performDetach();
        this.f491a.g(false);
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (!fragment.mRemoving || fragment.isInBackStack()) {
            a1 a1Var = this.f492b.f503c;
            if (a1Var.f437a.containsKey(fragment.mWho) && a1Var.f440d && !a1Var.f441e) {
                return;
            }
        }
        if (Log.isLoggable("FragmentManager", 3)) {
            Log.d("FragmentManager", "initState called for fragment: " + fragment);
        }
        fragment.initState();
    }

    public final void j() {
        Fragment fragment = this.f493c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (Log.isLoggable("FragmentManager", 3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + fragment);
            }
            fragment.performCreateView(fragment.performGetLayoutInflater(fragment.mSavedFragmentState), null, fragment.mSavedFragmentState);
            View view = fragment.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                fragment.mView.setTag(R$id.fragment_container_view_tag, fragment);
                if (fragment.mHidden) {
                    fragment.mView.setVisibility(8);
                }
                fragment.performViewCreated();
                this.f491a.o(false);
                fragment.mState = 2;
            }
        }
    }

    public final void k() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        boolean z2 = this.f494d;
        Fragment fragment = this.f493c;
        if (z2) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + fragment);
                return;
            }
            return;
        }
        try {
            this.f494d = true;
            while (true) {
                int iD = d();
                int i2 = fragment.mState;
                if (iD == i2) {
                    if (fragment.mHiddenChanged) {
                        if (fragment.mView != null && (viewGroup = fragment.mContainer) != null) {
                            w1 w1VarG = w1.g(viewGroup, fragment.getParentFragmentManager());
                            if (fragment.mHidden) {
                                w1VarG.getClass();
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + fragment);
                                }
                                w1VarG.a(3, 1, this);
                            } else {
                                w1VarG.getClass();
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + fragment);
                                }
                                w1VarG.a(2, 1, this);
                            }
                        }
                        w0 w0Var = fragment.mFragmentManager;
                        if (w0Var != null && fragment.mAdded && w0.B(fragment)) {
                            w0Var.f672z = true;
                        }
                        fragment.mHiddenChanged = false;
                        fragment.onHiddenChanged(fragment.mHidden);
                    }
                    this.f494d = false;
                    return;
                }
                if (iD <= i2) {
                    switch (i2 - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            g();
                            break;
                        case 1:
                            h();
                            fragment.mState = 1;
                            break;
                        case 2:
                            fragment.mInLayout = false;
                            fragment.mState = 2;
                            break;
                        case 3:
                            if (Log.isLoggable("FragmentManager", 3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + fragment);
                            }
                            if (fragment.mView != null && fragment.mSavedViewState == null) {
                                o();
                            }
                            if (fragment.mView != null && (viewGroup3 = fragment.mContainer) != null) {
                                w1 w1VarG2 = w1.g(viewGroup3, fragment.getParentFragmentManager());
                                w1VarG2.getClass();
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + fragment);
                                }
                                w1VarG2.a(1, 3, this);
                            }
                            fragment.mState = 3;
                            break;
                        case 4:
                            q();
                            break;
                        case 5:
                            fragment.mState = 5;
                            break;
                        case 6:
                            l();
                            break;
                    }
                } else {
                    switch (i2 + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (fragment.mView != null && (viewGroup2 = fragment.mContainer) != null) {
                                w1 w1VarG3 = w1.g(viewGroup2, fragment.getParentFragmentManager());
                                int iB = v1.b(fragment.mView.getVisibility());
                                w1VarG3.getClass();
                                if (Log.isLoggable("FragmentManager", 2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + fragment);
                                }
                                w1VarG3.a(iB, 2, this);
                            }
                            fragment.mState = 4;
                            break;
                        case 5:
                            p();
                            break;
                        case 6:
                            fragment.mState = 6;
                            break;
                        case 7:
                            n();
                            break;
                    }
                }
            }
        } catch (Throwable th) {
            this.f494d = false;
            throw th;
        }
    }

    public final void l() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.f493c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "movefrom RESUMED: " + fragment);
        }
        fragment.performPause();
        this.f491a.h(false);
    }

    public final void m(ClassLoader classLoader) {
        Fragment fragment = this.f493c;
        Bundle bundle = fragment.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        fragment.mSavedViewRegistryState = fragment.mSavedFragmentState.getBundle("android:view_registry_state");
        fragment.mTargetWho = fragment.mSavedFragmentState.getString("android:target_state");
        if (fragment.mTargetWho != null) {
            fragment.mTargetRequestCode = fragment.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        Boolean bool = fragment.mSavedUserVisibleHint;
        if (bool != null) {
            fragment.mUserVisibleHint = bool.booleanValue();
            fragment.mSavedUserVisibleHint = null;
        } else {
            fragment.mUserVisibleHint = fragment.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        }
        if (fragment.mUserVisibleHint) {
            return;
        }
        fragment.mDeferStart = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n() {
        /*
            r6 = this;
            r0 = 3
            java.lang.String r1 = "FragmentManager"
            boolean r0 = android.util.Log.isLoggable(r1, r0)
            androidx.fragment.app.Fragment r2 = r6.f493c
            if (r0 == 0) goto L1c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "moveto RESUMED: "
            r0.<init>(r3)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.d(r1, r0)
        L1c:
            android.view.View r0 = r2.getFocusedView()
            if (r0 == 0) goto L78
            android.view.View r3 = r2.mView
            if (r0 != r3) goto L27
            goto L31
        L27:
            android.view.ViewParent r3 = r0.getParent()
        L2b:
            if (r3 == 0) goto L78
            android.view.View r4 = r2.mView
            if (r3 != r4) goto L73
        L31:
            boolean r3 = r0.requestFocus()
            r4 = 2
            boolean r4 = android.util.Log.isLoggable(r1, r4)
            if (r4 == 0) goto L78
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "requestFocus: Restoring focused view "
            r4.<init>(r5)
            r4.append(r0)
            java.lang.String r0 = " "
            r4.append(r0)
            if (r3 == 0) goto L50
            java.lang.String r0 = "succeeded"
            goto L52
        L50:
            java.lang.String r0 = "failed"
        L52:
            r4.append(r0)
            java.lang.String r0 = " on Fragment "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = " resulting in focused view "
            r4.append(r0)
            android.view.View r0 = r2.mView
            android.view.View r0 = r0.findFocus()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            android.util.Log.v(r1, r0)
            goto L78
        L73:
            android.view.ViewParent r3 = r3.getParent()
            goto L2b
        L78:
            r0 = 0
            r2.setFocusedView(r0)
            r2.performResume()
            androidx.fragment.app.d r6 = r6.f491a
            r1 = 0
            r6.k(r1)
            r2.mSavedFragmentState = r0
            r2.mSavedViewState = r0
            r2.mSavedViewRegistryState = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.e1.n():void");
    }

    public final void o() {
        Fragment fragment = this.f493c;
        if (fragment.mView == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        fragment.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            fragment.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        fragment.mViewLifecycleOwner.f597e.c(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        fragment.mSavedViewRegistryState = bundle;
    }

    public final void p() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.f493c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "moveto STARTED: " + fragment);
        }
        fragment.performStart();
        this.f491a.m(false);
    }

    public final void q() {
        boolean zIsLoggable = Log.isLoggable("FragmentManager", 3);
        Fragment fragment = this.f493c;
        if (zIsLoggable) {
            Log.d("FragmentManager", "movefrom STARTED: " + fragment);
        }
        fragment.performStop();
        this.f491a.n(false);
    }

    public e1(d dVar, f1 f1Var, ClassLoader classLoader, p0 p0Var, c1 c1Var) {
        this.f491a = dVar;
        this.f492b = f1Var;
        Fragment fragmentInstantiate = Fragment.instantiate(p0Var.f584a.f662p.f554b, c1Var.f463a, null);
        this.f493c = fragmentInstantiate;
        Bundle bundle = c1Var.f472j;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        fragmentInstantiate.setArguments(bundle);
        fragmentInstantiate.mWho = c1Var.f464b;
        fragmentInstantiate.mFromLayout = c1Var.f465c;
        fragmentInstantiate.mRestored = true;
        fragmentInstantiate.mFragmentId = c1Var.f466d;
        fragmentInstantiate.mContainerId = c1Var.f467e;
        fragmentInstantiate.mTag = c1Var.f468f;
        fragmentInstantiate.mRetainInstance = c1Var.f469g;
        fragmentInstantiate.mRemoving = c1Var.f470h;
        fragmentInstantiate.mDetached = c1Var.f471i;
        fragmentInstantiate.mHidden = c1Var.f473k;
        fragmentInstantiate.mMaxState = Lifecycle.State.values()[c1Var.f474l];
        Bundle bundle2 = c1Var.f475m;
        if (bundle2 != null) {
            fragmentInstantiate.mSavedFragmentState = bundle2;
        } else {
            fragmentInstantiate.mSavedFragmentState = new Bundle();
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Instantiated fragment " + fragmentInstantiate);
        }
    }

    public e1(d dVar, f1 f1Var, Fragment fragment, c1 c1Var) {
        this.f491a = dVar;
        this.f492b = f1Var;
        this.f493c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = c1Var.f475m;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }
}
