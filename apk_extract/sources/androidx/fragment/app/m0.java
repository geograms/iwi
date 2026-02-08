package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$styleable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class m0 implements LayoutInflater.Factory2 {

    /* renamed from: a, reason: collision with root package name */
    public final w0 f565a;

    public m0(w0 w0Var) {
        this.f565a = w0Var;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        e1 e1VarF;
        View view2;
        boolean zEquals = FragmentContainerView.class.getName().equals(str);
        w0 w0Var = this.f565a;
        if (zEquals) {
            FragmentContainerView fragmentContainerView = new FragmentContainerView(context, attributeSet);
            fragmentContainerView.f431d = true;
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FragmentContainerView);
            if (classAttribute == null) {
                classAttribute = typedArrayObtainStyledAttributes.getString(R$styleable.FragmentContainerView_android_name);
            }
            String string = typedArrayObtainStyledAttributes.getString(R$styleable.FragmentContainerView_android_tag);
            typedArrayObtainStyledAttributes.recycle();
            int id = fragmentContainerView.getId();
            Fragment fragmentV = w0Var.v(id);
            if (classAttribute != null && fragmentV == null) {
                if (id <= 0) {
                    throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + (string != null ? " with tag ".concat(string) : ""));
                }
                p0 p0VarY = w0Var.y();
                context.getClassLoader();
                Fragment fragmentInstantiate = Fragment.instantiate(p0VarY.f584a.f662p.f554b, classAttribute, null);
                fragmentInstantiate.onInflate(context, attributeSet, (Bundle) null);
                a aVar = new a(w0Var);
                aVar.f537o = true;
                fragmentInstantiate.mContainer = fragmentContainerView;
                aVar.c(fragmentContainerView.getId(), fragmentInstantiate, string, 1);
                if (aVar.f529g) {
                    throw new IllegalStateException("This transaction is already being added to the back stack");
                }
                aVar.f432p.t(aVar, true);
            }
            Iterator it = w0Var.f649c.d().iterator();
            while (it.hasNext()) {
                e1 e1Var = (e1) it.next();
                Fragment fragment = e1Var.f493c;
                if (fragment.mContainerId == fragmentContainerView.getId() && (view2 = fragment.mView) != null && view2.getParent() == null) {
                    fragment.mContainer = fragmentContainerView;
                    e1Var.b();
                }
            }
            return fragmentContainerView;
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R$styleable.Fragment);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes2.getString(R$styleable.Fragment_android_name);
        }
        int resourceId = typedArrayObtainStyledAttributes2.getResourceId(R$styleable.Fragment_android_id, -1);
        String string2 = typedArrayObtainStyledAttributes2.getString(R$styleable.Fragment_android_tag);
        typedArrayObtainStyledAttributes2.recycle();
        if (attributeValue != null) {
            try {
                if (Fragment.class.isAssignableFrom(p0.a(context.getClassLoader(), attributeValue))) {
                    int id2 = view != null ? view.getId() : 0;
                    if (id2 == -1 && resourceId == -1 && string2 == null) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                    }
                    Fragment fragmentV2 = resourceId != -1 ? w0Var.v(resourceId) : null;
                    if (fragmentV2 == null && string2 != null) {
                        f1 f1Var = w0Var.f649c;
                        ArrayList arrayList = f1Var.f501a;
                        int size = arrayList.size() - 1;
                        while (true) {
                            if (size >= 0) {
                                Fragment fragment2 = (Fragment) arrayList.get(size);
                                if (fragment2 != null && string2.equals(fragment2.mTag)) {
                                    fragmentV2 = fragment2;
                                    break;
                                }
                                size--;
                            } else {
                                Iterator it2 = f1Var.f502b.values().iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        fragmentV2 = null;
                                        break;
                                    }
                                    e1 e1Var2 = (e1) it2.next();
                                    if (e1Var2 != null) {
                                        Fragment fragment3 = e1Var2.f493c;
                                        if (string2.equals(fragment3.mTag)) {
                                            fragmentV2 = fragment3;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (fragmentV2 == null && id2 != -1) {
                        fragmentV2 = w0Var.v(id2);
                    }
                    if (fragmentV2 == null) {
                        p0 p0VarY2 = w0Var.y();
                        context.getClassLoader();
                        fragmentV2 = Fragment.instantiate(p0VarY2.f584a.f662p.f554b, attributeValue, null);
                        fragmentV2.mFromLayout = true;
                        fragmentV2.mFragmentId = resourceId != 0 ? resourceId : id2;
                        fragmentV2.mContainerId = id2;
                        fragmentV2.mTag = string2;
                        fragmentV2.mInLayout = true;
                        fragmentV2.mFragmentManager = w0Var;
                        k0 k0Var = w0Var.f662p;
                        fragmentV2.mHost = k0Var;
                        fragmentV2.onInflate(k0Var.f554b, attributeSet, fragmentV2.mSavedFragmentState);
                        e1VarF = w0Var.a(fragmentV2);
                        if (Log.isLoggable("FragmentManager", 2)) {
                            Log.v("FragmentManager", "Fragment " + fragmentV2 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    } else {
                        if (fragmentV2.mInLayout) {
                            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id2) + " with another fragment for " + attributeValue);
                        }
                        fragmentV2.mInLayout = true;
                        fragmentV2.mFragmentManager = w0Var;
                        k0 k0Var2 = w0Var.f662p;
                        fragmentV2.mHost = k0Var2;
                        fragmentV2.onInflate(k0Var2.f554b, attributeSet, fragmentV2.mSavedFragmentState);
                        e1VarF = w0Var.f(fragmentV2);
                        if (Log.isLoggable("FragmentManager", 2)) {
                            Log.v("FragmentManager", "Retained Fragment " + fragmentV2 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                        }
                    }
                    fragmentV2.mContainer = (ViewGroup) view;
                    e1VarF.k();
                    e1VarF.j();
                    View view3 = fragmentV2.mView;
                    if (view3 == null) {
                        throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
                    }
                    if (resourceId != 0) {
                        view3.setId(resourceId);
                    }
                    if (fragmentV2.mView.getTag() == null) {
                        fragmentV2.mView.setTag(string2);
                    }
                    fragmentV2.mView.addOnAttachStateChangeListener(new l0(this, e1VarF));
                    return fragmentV2.mView;
                }
            } catch (ClassNotFoundException unused) {
            }
        }
        return null;
    }
}
