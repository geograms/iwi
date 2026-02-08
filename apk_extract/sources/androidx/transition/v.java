package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.graphics.Rect;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.widget.ListView;
import androidx.core.view.d1;
import androidx.core.view.s0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class v implements Cloneable {
    static final boolean DBG = false;
    private static final String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final String MATCH_ID_STR = "id";
    public static final int MATCH_INSTANCE = 1;
    private static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final String MATCH_NAME_STR = "name";
    private ArrayList<c0> mEndValuesList;
    private t mEpicenterCallback;
    private g.b mNameOverrides;
    z mPropagation;
    private ArrayList<c0> mStartValuesList;
    private static final int[] DEFAULT_MATCH_ORDER = {2, 1, 3, 4};
    private static final n STRAIGHT_PATH_MOTION = new p();
    private static ThreadLocal<g.b> sRunningAnimators = new ThreadLocal<>();
    private String mName = getClass().getName();
    private long mStartDelay = -1;
    long mDuration = -1;
    private TimeInterpolator mInterpolator = null;
    ArrayList<Integer> mTargetIds = new ArrayList<>();
    ArrayList<View> mTargets = new ArrayList<>();
    private ArrayList<String> mTargetNames = null;
    private ArrayList<Class<?>> mTargetTypes = null;
    private ArrayList<Integer> mTargetIdExcludes = null;
    private ArrayList<View> mTargetExcludes = null;
    private ArrayList<Class<?>> mTargetTypeExcludes = null;
    private ArrayList<String> mTargetNameExcludes = null;
    private ArrayList<Integer> mTargetIdChildExcludes = null;
    private ArrayList<View> mTargetChildExcludes = null;
    private ArrayList<Class<?>> mTargetTypeChildExcludes = null;
    private d0 mStartValues = new d0();
    private d0 mEndValues = new d0();
    b0 mParent = null;
    private int[] mMatchOrder = DEFAULT_MATCH_ORDER;
    private ViewGroup mSceneRoot = null;
    boolean mCanRemoveViews = false;
    ArrayList<Animator> mCurrentAnimators = new ArrayList<>();
    private int mNumInstances = 0;
    private boolean mPaused = false;
    private boolean mEnded = false;
    private ArrayList<u> mListeners = null;
    private ArrayList<Animator> mAnimators = new ArrayList<>();
    private n mPathMotion = STRAIGHT_PATH_MOTION;

    public static void a(d0 d0Var, View view, c0 c0Var) {
        d0Var.f1056a.put(view, c0Var);
        int id = view.getId();
        if (id >= 0) {
            SparseArray sparseArray = d0Var.f1057b;
            if (sparseArray.indexOfKey(id) >= 0) {
                sparseArray.put(id, null);
            } else {
                sparseArray.put(id, view);
            }
        }
        WeakHashMap weakHashMap = d1.f138a;
        String strK = s0.k(view);
        if (strK != null) {
            g.b bVar = d0Var.f1059d;
            if (bVar.containsKey(strK)) {
                bVar.put(strK, null);
            } else {
                bVar.put(strK, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                g.e eVar = d0Var.f1058c;
                if (eVar.f1787a) {
                    eVar.d();
                }
                if (g.d.b(eVar.f1788b, eVar.f1790d, itemIdAtPosition) < 0) {
                    androidx.core.view.m0.r(view, true);
                    eVar.g(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) eVar.e(itemIdAtPosition, null);
                if (view2 != null) {
                    androidx.core.view.m0.r(view2, false);
                    eVar.g(itemIdAtPosition, null);
                }
            }
        }
    }

    public static g.b c() {
        g.b bVar = sRunningAnimators.get();
        if (bVar != null) {
            return bVar;
        }
        g.b bVar2 = new g.b();
        sRunningAnimators.set(bVar2);
        return bVar2;
    }

    public static boolean d(c0 c0Var, c0 c0Var2, String str) {
        Object obj = c0Var.f1053a.get(str);
        Object obj2 = c0Var2.f1053a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    public v addListener(u uVar) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(uVar);
        return this;
    }

    public v addTarget(View view) {
        this.mTargets.add(view);
        return this;
    }

    public void animate(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(animator.getStartDelay() + getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new r(0, this));
        animator.start();
    }

    public final void b(View view, boolean z2) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.mTargetIdExcludes;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList2 = this.mTargetExcludes;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class<?>> arrayList3 = this.mTargetTypeExcludes;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (this.mTargetTypeExcludes.get(i2).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    c0 c0Var = new c0(view);
                    if (z2) {
                        captureStartValues(c0Var);
                    } else {
                        captureEndValues(c0Var);
                    }
                    c0Var.f1055c.add(this);
                    capturePropagationValues(c0Var);
                    if (z2) {
                        a(this.mStartValues, view, c0Var);
                    } else {
                        a(this.mEndValues, view, c0Var);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.mTargetIdChildExcludes;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList<View> arrayList5 = this.mTargetChildExcludes;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class<?>> arrayList6 = this.mTargetTypeChildExcludes;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i3 = 0; i3 < size2; i3++) {
                                    if (this.mTargetTypeChildExcludes.get(i3).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                                b(viewGroup.getChildAt(i4), z2);
                            }
                        }
                    }
                }
            }
        }
    }

    public void cancel() {
        for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
            this.mCurrentAnimators.get(size).cancel();
        }
        ArrayList<u> arrayList = this.mListeners;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
        int size2 = arrayList2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((u) arrayList2.get(i2)).onTransitionCancel(this);
        }
    }

    public abstract void captureEndValues(c0 c0Var);

    public void capturePropagationValues(c0 c0Var) {
    }

    public abstract void captureStartValues(c0 c0Var);

    public void captureValues(ViewGroup viewGroup, boolean z2) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        g.b bVar;
        clearValues(z2);
        if ((this.mTargetIds.size() > 0 || this.mTargets.size() > 0) && (((arrayList = this.mTargetNames) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetTypes) == null || arrayList2.isEmpty()))) {
            for (int i2 = 0; i2 < this.mTargetIds.size(); i2++) {
                View viewFindViewById = viewGroup.findViewById(this.mTargetIds.get(i2).intValue());
                if (viewFindViewById != null) {
                    c0 c0Var = new c0(viewFindViewById);
                    if (z2) {
                        captureStartValues(c0Var);
                    } else {
                        captureEndValues(c0Var);
                    }
                    c0Var.f1055c.add(this);
                    capturePropagationValues(c0Var);
                    if (z2) {
                        a(this.mStartValues, viewFindViewById, c0Var);
                    } else {
                        a(this.mEndValues, viewFindViewById, c0Var);
                    }
                }
            }
            for (int i3 = 0; i3 < this.mTargets.size(); i3++) {
                View view = this.mTargets.get(i3);
                c0 c0Var2 = new c0(view);
                if (z2) {
                    captureStartValues(c0Var2);
                } else {
                    captureEndValues(c0Var2);
                }
                c0Var2.f1055c.add(this);
                capturePropagationValues(c0Var2);
                if (z2) {
                    a(this.mStartValues, view, c0Var2);
                } else {
                    a(this.mEndValues, view, c0Var2);
                }
            }
        } else {
            b(viewGroup, z2);
        }
        if (z2 || (bVar = this.mNameOverrides) == null) {
            return;
        }
        int i4 = bVar.f1812c;
        ArrayList arrayList3 = new ArrayList(i4);
        for (int i5 = 0; i5 < i4; i5++) {
            arrayList3.add(this.mStartValues.f1059d.remove((String) this.mNameOverrides.h(i5)));
        }
        for (int i6 = 0; i6 < i4; i6++) {
            View view2 = (View) arrayList3.get(i6);
            if (view2 != null) {
                this.mStartValues.f1059d.put((String) this.mNameOverrides.j(i6), view2);
            }
        }
    }

    public void clearValues(boolean z2) {
        if (z2) {
            this.mStartValues.f1056a.clear();
            this.mStartValues.f1057b.clear();
            this.mStartValues.f1058c.b();
        } else {
            this.mEndValues.f1056a.clear();
            this.mEndValues.f1057b.clear();
            this.mEndValues.f1058c.b();
        }
    }

    public Animator createAnimator(ViewGroup viewGroup, c0 c0Var, c0 c0Var2) {
        return null;
    }

    public void createAnimators(ViewGroup viewGroup, d0 d0Var, d0 d0Var2, ArrayList<c0> arrayList, ArrayList<c0> arrayList2) {
        Animator animatorCreateAnimator;
        int i2;
        View view;
        c0 c0Var;
        Animator animator;
        g.b bVarC = c();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            c0 c0Var2 = arrayList.get(i3);
            c0 c0Var3 = arrayList2.get(i3);
            c0 c0Var4 = null;
            if (c0Var2 != null && !c0Var2.f1055c.contains(this)) {
                c0Var2 = null;
            }
            if (c0Var3 != null && !c0Var3.f1055c.contains(this)) {
                c0Var3 = null;
            }
            if (!(c0Var2 == null && c0Var3 == null) && ((c0Var2 == null || c0Var3 == null || isTransitionRequired(c0Var2, c0Var3)) && (animatorCreateAnimator = createAnimator(viewGroup, c0Var2, c0Var3)) != null)) {
                if (c0Var3 != null) {
                    view = c0Var3.f1054b;
                    String[] transitionProperties = getTransitionProperties();
                    if (transitionProperties != null && transitionProperties.length > 0) {
                        c0Var = new c0(view);
                        c0 c0Var5 = (c0) d0Var2.f1056a.getOrDefault(view, null);
                        if (c0Var5 != null) {
                            int i4 = 0;
                            while (i4 < transitionProperties.length) {
                                HashMap map = c0Var.f1053a;
                                int i5 = size;
                                String str = transitionProperties[i4];
                                map.put(str, c0Var5.f1053a.get(str));
                                i4++;
                                size = i5;
                            }
                        }
                        i2 = size;
                        int i6 = bVarC.f1812c;
                        for (int i7 = 0; i7 < i6; i7++) {
                            s sVar = (s) bVarC.getOrDefault((Animator) bVarC.h(i7), null);
                            if (sVar.f1115c != null && sVar.f1113a == view && sVar.f1114b.equals(getName()) && sVar.f1115c.equals(c0Var)) {
                                animator = null;
                                break;
                            }
                        }
                    } else {
                        i2 = size;
                        c0Var = null;
                    }
                    animator = animatorCreateAnimator;
                    animatorCreateAnimator = animator;
                    c0Var4 = c0Var;
                } else {
                    i2 = size;
                    view = c0Var2.f1054b;
                }
                if (animatorCreateAnimator != null) {
                    String name = getName();
                    c cVar = e0.f1062a;
                    o0 o0Var = new o0(viewGroup);
                    s sVar2 = new s();
                    sVar2.f1113a = view;
                    sVar2.f1114b = name;
                    sVar2.f1115c = c0Var4;
                    sVar2.f1116d = o0Var;
                    sVar2.f1117e = this;
                    bVarC.put(animatorCreateAnimator, sVar2);
                    this.mAnimators.add(animatorCreateAnimator);
                }
            } else {
                i2 = size;
            }
            i3++;
            size = i2;
        }
        if (sparseIntArray.size() != 0) {
            for (int i8 = 0; i8 < sparseIntArray.size(); i8++) {
                Animator animator2 = this.mAnimators.get(sparseIntArray.keyAt(i8));
                animator2.setStartDelay(animator2.getStartDelay() + (sparseIntArray.valueAt(i8) - Long.MAX_VALUE));
            }
        }
    }

    public void end() {
        int i2 = this.mNumInstances - 1;
        this.mNumInstances = i2;
        if (i2 == 0) {
            ArrayList<u> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((u) arrayList2.get(i3)).onTransitionEnd(this);
                }
            }
            for (int i4 = 0; i4 < this.mStartValues.f1058c.h(); i4++) {
                View view = (View) this.mStartValues.f1058c.i(i4);
                if (view != null) {
                    WeakHashMap weakHashMap = d1.f138a;
                    androidx.core.view.m0.r(view, false);
                }
            }
            for (int i5 = 0; i5 < this.mEndValues.f1058c.h(); i5++) {
                View view2 = (View) this.mEndValues.f1058c.i(i5);
                if (view2 != null) {
                    WeakHashMap weakHashMap2 = d1.f138a;
                    androidx.core.view.m0.r(view2, false);
                }
            }
            this.mEnded = true;
        }
    }

    public v excludeChildren(int i2, boolean z2) {
        ArrayList<Integer> arrayListC = this.mTargetIdChildExcludes;
        if (i2 > 0) {
            arrayListC = z2 ? x0.g.c(Integer.valueOf(i2), arrayListC) : x0.g.r0(Integer.valueOf(i2), arrayListC);
        }
        this.mTargetIdChildExcludes = arrayListC;
        return this;
    }

    public v excludeTarget(String str, boolean z2) {
        ArrayList<String> arrayListC = this.mTargetNameExcludes;
        if (str != null) {
            arrayListC = z2 ? x0.g.c(str, arrayListC) : x0.g.r0(str, arrayListC);
        }
        this.mTargetNameExcludes = arrayListC;
        return this;
    }

    public void forceToEnd(ViewGroup viewGroup) {
        g.b bVarC = c();
        int i2 = bVarC.f1812c;
        if (viewGroup == null || i2 == 0) {
            return;
        }
        c cVar = e0.f1062a;
        WindowId windowId = viewGroup.getWindowId();
        g.b bVar = new g.b(bVarC);
        bVarC.clear();
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            s sVar = (s) bVar.j(i3);
            if (sVar.f1113a != null) {
                p0 p0Var = sVar.f1116d;
                if ((p0Var instanceof o0) && ((o0) p0Var).f1108a.equals(windowId)) {
                    ((Animator) bVar.h(i3)).end();
                }
            }
        }
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Rect getEpicenter() {
        t tVar = this.mEpicenterCallback;
        Rect rect = null;
        if (tVar == null) {
            return null;
        }
        j jVar = (j) tVar;
        int i2 = jVar.f1079a;
        Rect rect2 = jVar.f1080b;
        switch (i2) {
            case 0:
                return rect2;
            default:
                if (rect2 != null && !rect2.isEmpty()) {
                    rect = rect2;
                }
                return rect;
        }
    }

    public t getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
    
        if (r3 < 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002f, code lost:
    
        if (r7 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0031, code lost:
    
        r5 = r5.mEndValuesList;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0034, code lost:
    
        r5 = r5.mStartValuesList;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003d, code lost:
    
        return r5.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.transition.c0 getMatchedTransitionValues(android.view.View r6, boolean r7) {
        /*
            r5 = this;
            androidx.transition.b0 r0 = r5.mParent
            if (r0 == 0) goto L9
            androidx.transition.c0 r5 = r0.getMatchedTransitionValues(r6, r7)
            return r5
        L9:
            if (r7 == 0) goto Le
            java.util.ArrayList<androidx.transition.c0> r0 = r5.mStartValuesList
            goto L10
        Le:
            java.util.ArrayList<androidx.transition.c0> r0 = r5.mEndValuesList
        L10:
            r1 = 0
            if (r0 != 0) goto L14
            return r1
        L14:
            int r2 = r0.size()
            r3 = 0
        L19:
            if (r3 >= r2) goto L2c
            java.lang.Object r4 = r0.get(r3)
            androidx.transition.c0 r4 = (androidx.transition.c0) r4
            if (r4 != 0) goto L24
            return r1
        L24:
            android.view.View r4 = r4.f1054b
            if (r4 != r6) goto L29
            goto L2d
        L29:
            int r3 = r3 + 1
            goto L19
        L2c:
            r3 = -1
        L2d:
            if (r3 < 0) goto L3d
            if (r7 == 0) goto L34
            java.util.ArrayList<androidx.transition.c0> r5 = r5.mEndValuesList
            goto L36
        L34:
            java.util.ArrayList<androidx.transition.c0> r5 = r5.mStartValuesList
        L36:
            java.lang.Object r5 = r5.get(r3)
            r1 = r5
            androidx.transition.c0 r1 = (androidx.transition.c0) r1
        L3d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.v.getMatchedTransitionValues(android.view.View, boolean):androidx.transition.c0");
    }

    public String getName() {
        return this.mName;
    }

    public n getPathMotion() {
        return this.mPathMotion;
    }

    public z getPropagation() {
        return null;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    public List<Class<?>> getTargetTypes() {
        return this.mTargetTypes;
    }

    public List<View> getTargets() {
        return this.mTargets;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public c0 getTransitionValues(View view, boolean z2) {
        b0 b0Var = this.mParent;
        if (b0Var != null) {
            return b0Var.getTransitionValues(view, z2);
        }
        return (c0) (z2 ? this.mStartValues : this.mEndValues).f1056a.getOrDefault(view, null);
    }

    public boolean isTransitionRequired(c0 c0Var, c0 c0Var2) {
        if (c0Var == null || c0Var2 == null) {
            return false;
        }
        String[] transitionProperties = getTransitionProperties();
        if (transitionProperties == null) {
            Iterator it = c0Var.f1053a.keySet().iterator();
            while (it.hasNext()) {
                if (d(c0Var, c0Var2, (String) it.next())) {
                }
            }
            return false;
        }
        for (String str : transitionProperties) {
            if (!d(c0Var, c0Var2, str)) {
            }
        }
        return false;
        return true;
    }

    public boolean isValidTarget(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.mTargetIdExcludes;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.mTargetExcludes;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.mTargetTypeExcludes;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.mTargetTypeExcludes.get(i2).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.mTargetNameExcludes != null) {
            WeakHashMap weakHashMap = d1.f138a;
            if (s0.k(view) != null && this.mTargetNameExcludes.contains(s0.k(view))) {
                return false;
            }
        }
        if ((this.mTargetIds.size() == 0 && this.mTargets.size() == 0 && (((arrayList = this.mTargetTypes) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetNames) == null || arrayList2.isEmpty()))) || this.mTargetIds.contains(Integer.valueOf(id)) || this.mTargets.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.mTargetNames;
        if (arrayList6 != null) {
            WeakHashMap weakHashMap2 = d1.f138a;
            if (arrayList6.contains(s0.k(view))) {
                return true;
            }
        }
        if (this.mTargetTypes != null) {
            for (int i3 = 0; i3 < this.mTargetTypes.size(); i3++) {
                if (this.mTargetTypes.get(i3).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void pause(View view) {
        int i2;
        if (this.mEnded) {
            return;
        }
        g.b bVarC = c();
        int i3 = bVarC.f1812c;
        c cVar = e0.f1062a;
        WindowId windowId = view.getWindowId();
        int i4 = i3 - 1;
        while (true) {
            i2 = 0;
            if (i4 < 0) {
                break;
            }
            s sVar = (s) bVarC.j(i4);
            if (sVar.f1113a != null) {
                p0 p0Var = sVar.f1116d;
                if ((p0Var instanceof o0) && ((o0) p0Var).f1108a.equals(windowId)) {
                    i2 = 1;
                }
                if (i2 != 0) {
                    ((Animator) bVarC.h(i4)).pause();
                }
            }
            i4--;
        }
        ArrayList<u> arrayList = this.mListeners;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
            int size = arrayList2.size();
            while (i2 < size) {
                ((u) arrayList2.get(i2)).onTransitionPause(this);
                i2++;
            }
        }
        this.mPaused = true;
    }

    public void playTransition(ViewGroup viewGroup) {
        s sVar;
        View view;
        c0 c0Var;
        View view2;
        this.mStartValuesList = new ArrayList<>();
        this.mEndValuesList = new ArrayList<>();
        d0 d0Var = this.mStartValues;
        d0 d0Var2 = this.mEndValues;
        g.b bVar = new g.b(d0Var.f1056a);
        g.b bVar2 = new g.b(d0Var2.f1056a);
        int i2 = 0;
        while (true) {
            int[] iArr = this.mMatchOrder;
            if (i2 >= iArr.length) {
                break;
            }
            int i3 = iArr[i2];
            if (i3 == 1) {
                for (int i4 = bVar.f1812c - 1; i4 >= 0; i4--) {
                    View view3 = (View) bVar.h(i4);
                    if (view3 != null && isValidTarget(view3) && (c0Var = (c0) bVar2.remove(view3)) != null && isValidTarget(c0Var.f1054b)) {
                        this.mStartValuesList.add((c0) bVar.i(i4));
                        this.mEndValuesList.add(c0Var);
                    }
                }
            } else if (i3 == 2) {
                g.b bVar3 = d0Var.f1059d;
                int i5 = bVar3.f1812c;
                for (int i6 = 0; i6 < i5; i6++) {
                    View view4 = (View) bVar3.j(i6);
                    if (view4 != null && isValidTarget(view4)) {
                        View view5 = (View) d0Var2.f1059d.getOrDefault(bVar3.h(i6), null);
                        if (view5 != null && isValidTarget(view5)) {
                            c0 c0Var2 = (c0) bVar.getOrDefault(view4, null);
                            c0 c0Var3 = (c0) bVar2.getOrDefault(view5, null);
                            if (c0Var2 != null && c0Var3 != null) {
                                this.mStartValuesList.add(c0Var2);
                                this.mEndValuesList.add(c0Var3);
                                bVar.remove(view4);
                                bVar2.remove(view5);
                            }
                        }
                    }
                }
            } else if (i3 == 3) {
                SparseArray sparseArray = d0Var.f1057b;
                SparseArray sparseArray2 = d0Var2.f1057b;
                int size = sparseArray.size();
                for (int i7 = 0; i7 < size; i7++) {
                    View view6 = (View) sparseArray.valueAt(i7);
                    if (view6 != null && isValidTarget(view6) && (view2 = (View) sparseArray2.get(sparseArray.keyAt(i7))) != null && isValidTarget(view2)) {
                        c0 c0Var4 = (c0) bVar.getOrDefault(view6, null);
                        c0 c0Var5 = (c0) bVar2.getOrDefault(view2, null);
                        if (c0Var4 != null && c0Var5 != null) {
                            this.mStartValuesList.add(c0Var4);
                            this.mEndValuesList.add(c0Var5);
                            bVar.remove(view6);
                            bVar2.remove(view2);
                        }
                    }
                }
            } else if (i3 == 4) {
                g.e eVar = d0Var.f1058c;
                int iH = eVar.h();
                for (int i8 = 0; i8 < iH; i8++) {
                    View view7 = (View) eVar.i(i8);
                    if (view7 != null && isValidTarget(view7)) {
                        View view8 = (View) d0Var2.f1058c.e(eVar.f(i8), null);
                        if (view8 != null && isValidTarget(view8)) {
                            c0 c0Var6 = (c0) bVar.getOrDefault(view7, null);
                            c0 c0Var7 = (c0) bVar2.getOrDefault(view8, null);
                            if (c0Var6 != null && c0Var7 != null) {
                                this.mStartValuesList.add(c0Var6);
                                this.mEndValuesList.add(c0Var7);
                                bVar.remove(view7);
                                bVar2.remove(view8);
                            }
                        }
                    }
                }
            }
            i2++;
        }
        for (int i9 = 0; i9 < bVar.f1812c; i9++) {
            c0 c0Var8 = (c0) bVar.j(i9);
            if (isValidTarget(c0Var8.f1054b)) {
                this.mStartValuesList.add(c0Var8);
                this.mEndValuesList.add(null);
            }
        }
        for (int i10 = 0; i10 < bVar2.f1812c; i10++) {
            c0 c0Var9 = (c0) bVar2.j(i10);
            if (isValidTarget(c0Var9.f1054b)) {
                this.mEndValuesList.add(c0Var9);
                this.mStartValuesList.add(null);
            }
        }
        g.b bVarC = c();
        int i11 = bVarC.f1812c;
        c cVar = e0.f1062a;
        WindowId windowId = viewGroup.getWindowId();
        for (int i12 = i11 - 1; i12 >= 0; i12--) {
            Animator animator = (Animator) bVarC.h(i12);
            if (animator != null && (sVar = (s) bVarC.getOrDefault(animator, null)) != null && (view = sVar.f1113a) != null) {
                p0 p0Var = sVar.f1116d;
                if ((p0Var instanceof o0) && ((o0) p0Var).f1108a.equals(windowId)) {
                    c0 transitionValues = getTransitionValues(view, true);
                    c0 matchedTransitionValues = getMatchedTransitionValues(view, true);
                    if (transitionValues == null && matchedTransitionValues == null) {
                        matchedTransitionValues = (c0) this.mEndValues.f1056a.getOrDefault(view, null);
                    }
                    if ((transitionValues != null || matchedTransitionValues != null) && sVar.f1117e.isTransitionRequired(sVar.f1115c, matchedTransitionValues)) {
                        if (animator.isRunning() || animator.isStarted()) {
                            animator.cancel();
                        } else {
                            bVarC.remove(animator);
                        }
                    }
                }
            }
        }
        createAnimators(viewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
        runAnimators();
    }

    public v removeListener(u uVar) {
        ArrayList<u> arrayList = this.mListeners;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(uVar);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
        return this;
    }

    public v removeTarget(View view) {
        this.mTargets.remove(view);
        return this;
    }

    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                g.b bVarC = c();
                int i2 = bVarC.f1812c;
                c cVar = e0.f1062a;
                WindowId windowId = view.getWindowId();
                for (int i3 = i2 - 1; i3 >= 0; i3--) {
                    s sVar = (s) bVarC.j(i3);
                    if (sVar.f1113a != null) {
                        p0 p0Var = sVar.f1116d;
                        if ((p0Var instanceof o0) && ((o0) p0Var).f1108a.equals(windowId)) {
                            ((Animator) bVarC.h(i3)).resume();
                        }
                    }
                }
                ArrayList<u> arrayList = this.mListeners;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                    int size = arrayList2.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        ((u) arrayList2.get(i4)).onTransitionResume(this);
                    }
                }
            }
            this.mPaused = false;
        }
    }

    public void runAnimators() {
        start();
        g.b bVarC = c();
        Iterator<Animator> it = this.mAnimators.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (bVarC.containsKey(next)) {
                start();
                if (next != null) {
                    next.addListener(new q(this, bVarC));
                    animate(next);
                }
            }
        }
        this.mAnimators.clear();
        end();
    }

    public void setCanRemoveViews(boolean z2) {
        this.mCanRemoveViews = z2;
    }

    public v setDuration(long j2) {
        this.mDuration = j2;
        return this;
    }

    public void setEpicenterCallback(t tVar) {
        this.mEpicenterCallback = tVar;
    }

    public v setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public void setMatchOrder(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.mMatchOrder = DEFAULT_MATCH_ORDER;
            return;
        }
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            if (i3 < 1 || i3 > 4) {
                throw new IllegalArgumentException("matches contains invalid value");
            }
            for (int i4 = 0; i4 < i2; i4++) {
                if (iArr[i4] == i3) {
                    throw new IllegalArgumentException("matches contains a duplicate value");
                }
            }
        }
        this.mMatchOrder = (int[]) iArr.clone();
    }

    public void setPathMotion(n nVar) {
        if (nVar == null) {
            this.mPathMotion = STRAIGHT_PATH_MOTION;
        } else {
            this.mPathMotion = nVar;
        }
    }

    public void setPropagation(z zVar) {
    }

    public v setSceneRoot(ViewGroup viewGroup) {
        this.mSceneRoot = viewGroup;
        return this;
    }

    public v setStartDelay(long j2) {
        this.mStartDelay = j2;
        return this;
    }

    public void start() {
        if (this.mNumInstances == 0) {
            ArrayList<u> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((u) arrayList2.get(i2)).onTransitionStart(this);
                }
            }
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    public String toString(String str) {
        StringBuilder sbF = a.a.f(str);
        sbF.append(getClass().getSimpleName());
        sbF.append("@");
        sbF.append(Integer.toHexString(hashCode()));
        sbF.append(": ");
        String string = sbF.toString();
        if (this.mDuration != -1) {
            StringBuilder sbG = a.a.g(string, "dur(");
            sbG.append(this.mDuration);
            sbG.append(") ");
            string = sbG.toString();
        }
        if (this.mStartDelay != -1) {
            StringBuilder sbG2 = a.a.g(string, "dly(");
            sbG2.append(this.mStartDelay);
            sbG2.append(") ");
            string = sbG2.toString();
        }
        if (this.mInterpolator != null) {
            StringBuilder sbG3 = a.a.g(string, "interp(");
            sbG3.append(this.mInterpolator);
            sbG3.append(") ");
            string = sbG3.toString();
        }
        if (this.mTargetIds.size() <= 0 && this.mTargets.size() <= 0) {
            return string;
        }
        String strD = a.a.d(string, "tgts(");
        if (this.mTargetIds.size() > 0) {
            for (int i2 = 0; i2 < this.mTargetIds.size(); i2++) {
                if (i2 > 0) {
                    strD = a.a.d(strD, ", ");
                }
                StringBuilder sbF2 = a.a.f(strD);
                sbF2.append(this.mTargetIds.get(i2));
                strD = sbF2.toString();
            }
        }
        if (this.mTargets.size() > 0) {
            for (int i3 = 0; i3 < this.mTargets.size(); i3++) {
                if (i3 > 0) {
                    strD = a.a.d(strD, ", ");
                }
                StringBuilder sbF3 = a.a.f(strD);
                sbF3.append(this.mTargets.get(i3));
                strD = sbF3.toString();
            }
        }
        return a.a.d(strD, ")");
    }

    public v addTarget(int i2) {
        if (i2 != 0) {
            this.mTargetIds.add(Integer.valueOf(i2));
        }
        return this;
    }

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public v mo2clone() {
        try {
            v vVar = (v) super.clone();
            vVar.mAnimators = new ArrayList<>();
            vVar.mStartValues = new d0();
            vVar.mEndValues = new d0();
            vVar.mStartValuesList = null;
            vVar.mEndValuesList = null;
            return vVar;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public v removeTarget(int i2) {
        if (i2 != 0) {
            this.mTargetIds.remove(Integer.valueOf(i2));
        }
        return this;
    }

    public v addTarget(String str) {
        if (this.mTargetNames == null) {
            this.mTargetNames = new ArrayList<>();
        }
        this.mTargetNames.add(str);
        return this;
    }

    public v excludeChildren(View view, boolean z2) {
        ArrayList<View> arrayListR0 = this.mTargetChildExcludes;
        if (view != null) {
            if (z2) {
                arrayListR0 = x0.g.c(view, arrayListR0);
            } else {
                arrayListR0 = x0.g.r0(view, arrayListR0);
            }
        }
        this.mTargetChildExcludes = arrayListR0;
        return this;
    }

    public v excludeTarget(int i2, boolean z2) {
        ArrayList<Integer> arrayListR0 = this.mTargetIdExcludes;
        if (i2 > 0) {
            if (z2) {
                arrayListR0 = x0.g.c(Integer.valueOf(i2), arrayListR0);
            } else {
                arrayListR0 = x0.g.r0(Integer.valueOf(i2), arrayListR0);
            }
        }
        this.mTargetIdExcludes = arrayListR0;
        return this;
    }

    public v removeTarget(String str) {
        ArrayList<String> arrayList = this.mTargetNames;
        if (arrayList != null) {
            arrayList.remove(str);
        }
        return this;
    }

    public v removeTarget(Class<?> cls) {
        ArrayList<Class<?>> arrayList = this.mTargetTypes;
        if (arrayList != null) {
            arrayList.remove(cls);
        }
        return this;
    }

    public v addTarget(Class<?> cls) {
        if (this.mTargetTypes == null) {
            this.mTargetTypes = new ArrayList<>();
        }
        this.mTargetTypes.add(cls);
        return this;
    }

    public v excludeChildren(Class<?> cls, boolean z2) {
        ArrayList<Class<?>> arrayListR0 = this.mTargetTypeChildExcludes;
        if (cls != null) {
            if (z2) {
                arrayListR0 = x0.g.c(cls, arrayListR0);
            } else {
                arrayListR0 = x0.g.r0(cls, arrayListR0);
            }
        }
        this.mTargetTypeChildExcludes = arrayListR0;
        return this;
    }

    public v excludeTarget(View view, boolean z2) {
        ArrayList<View> arrayListR0 = this.mTargetExcludes;
        if (view != null) {
            if (z2) {
                arrayListR0 = x0.g.c(view, arrayListR0);
            } else {
                arrayListR0 = x0.g.r0(view, arrayListR0);
            }
        }
        this.mTargetExcludes = arrayListR0;
        return this;
    }

    public v excludeTarget(Class<?> cls, boolean z2) {
        ArrayList<Class<?>> arrayListR0 = this.mTargetTypeExcludes;
        if (cls != null) {
            if (z2) {
                arrayListR0 = x0.g.c(cls, arrayListR0);
            } else {
                arrayListR0 = x0.g.r0(cls, arrayListR0);
            }
        }
        this.mTargetTypeExcludes = arrayListR0;
        return this;
    }

    public String toString() {
        return toString("");
    }
}
