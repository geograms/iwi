package androidx.transition;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class b0 extends v {

    /* renamed from: c, reason: collision with root package name */
    public int f1049c;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f1047a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public boolean f1048b = true;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1050d = false;

    /* renamed from: e, reason: collision with root package name */
    public int f1051e = 0;

    @Override // androidx.transition.v
    public final v addListener(u uVar) {
        return (b0) super.addListener(uVar);
    }

    @Override // androidx.transition.v
    public final v addTarget(View view) {
        for (int i2 = 0; i2 < this.f1047a.size(); i2++) {
            ((v) this.f1047a.get(i2)).addTarget(view);
        }
        return (b0) super.addTarget(view);
    }

    @Override // androidx.transition.v
    public final void cancel() {
        super.cancel();
        int size = this.f1047a.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((v) this.f1047a.get(i2)).cancel();
        }
    }

    @Override // androidx.transition.v
    public final void captureEndValues(c0 c0Var) {
        if (isValidTarget(c0Var.f1054b)) {
            Iterator it = this.f1047a.iterator();
            while (it.hasNext()) {
                v vVar = (v) it.next();
                if (vVar.isValidTarget(c0Var.f1054b)) {
                    vVar.captureEndValues(c0Var);
                    c0Var.f1055c.add(vVar);
                }
            }
        }
    }

    @Override // androidx.transition.v
    public final void capturePropagationValues(c0 c0Var) {
        super.capturePropagationValues(c0Var);
        int size = this.f1047a.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((v) this.f1047a.get(i2)).capturePropagationValues(c0Var);
        }
    }

    @Override // androidx.transition.v
    public final void captureStartValues(c0 c0Var) {
        if (isValidTarget(c0Var.f1054b)) {
            Iterator it = this.f1047a.iterator();
            while (it.hasNext()) {
                v vVar = (v) it.next();
                if (vVar.isValidTarget(c0Var.f1054b)) {
                    vVar.captureStartValues(c0Var);
                    c0Var.f1055c.add(vVar);
                }
            }
        }
    }

    @Override // androidx.transition.v
    public final void createAnimators(ViewGroup viewGroup, d0 d0Var, d0 d0Var2, ArrayList arrayList, ArrayList arrayList2) {
        long startDelay = getStartDelay();
        int size = this.f1047a.size();
        for (int i2 = 0; i2 < size; i2++) {
            v vVar = (v) this.f1047a.get(i2);
            if (startDelay > 0 && (this.f1048b || i2 == 0)) {
                long startDelay2 = vVar.getStartDelay();
                if (startDelay2 > 0) {
                    vVar.setStartDelay(startDelay2 + startDelay);
                } else {
                    vVar.setStartDelay(startDelay);
                }
            }
            vVar.createAnimators(viewGroup, d0Var, d0Var2, arrayList, arrayList2);
        }
    }

    public final void e(v vVar) {
        this.f1047a.add(vVar);
        vVar.mParent = this;
        long j2 = this.mDuration;
        if (j2 >= 0) {
            vVar.setDuration(j2);
        }
        if ((this.f1051e & 1) != 0) {
            vVar.setInterpolator(getInterpolator());
        }
        if ((this.f1051e & 2) != 0) {
            getPropagation();
            vVar.setPropagation(null);
        }
        if ((this.f1051e & 4) != 0) {
            vVar.setPathMotion(getPathMotion());
        }
        if ((this.f1051e & 8) != 0) {
            vVar.setEpicenterCallback(getEpicenterCallback());
        }
    }

    @Override // androidx.transition.v
    public final v excludeTarget(View view, boolean z2) {
        for (int i2 = 0; i2 < this.f1047a.size(); i2++) {
            ((v) this.f1047a.get(i2)).excludeTarget(view, z2);
        }
        return super.excludeTarget(view, z2);
    }

    public final void f(v vVar) {
        this.f1047a.remove(vVar);
        vVar.mParent = null;
    }

    @Override // androidx.transition.v
    public final void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.f1047a.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((v) this.f1047a.get(i2)).forceToEnd(viewGroup);
        }
    }

    public final void g(long j2) {
        ArrayList arrayList;
        super.setDuration(j2);
        if (this.mDuration < 0 || (arrayList = this.f1047a) == null) {
            return;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((v) this.f1047a.get(i2)).setDuration(j2);
        }
    }

    @Override // androidx.transition.v
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final b0 setInterpolator(TimeInterpolator timeInterpolator) {
        this.f1051e |= 1;
        ArrayList arrayList = this.f1047a;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((v) this.f1047a.get(i2)).setInterpolator(timeInterpolator);
            }
        }
        return (b0) super.setInterpolator(timeInterpolator);
    }

    public final void i(int i2) {
        if (i2 == 0) {
            this.f1048b = true;
        } else {
            if (i2 != 1) {
                throw new AndroidRuntimeException(a.a.c("Invalid parameter for TransitionSet ordering: ", i2));
            }
            this.f1048b = false;
        }
    }

    @Override // androidx.transition.v
    public final void pause(View view) {
        super.pause(view);
        int size = this.f1047a.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((v) this.f1047a.get(i2)).pause(view);
        }
    }

    @Override // androidx.transition.v
    public final v removeListener(u uVar) {
        return (b0) super.removeListener(uVar);
    }

    @Override // androidx.transition.v
    public final v removeTarget(int i2) {
        for (int i3 = 0; i3 < this.f1047a.size(); i3++) {
            ((v) this.f1047a.get(i3)).removeTarget(i2);
        }
        return (b0) super.removeTarget(i2);
    }

    @Override // androidx.transition.v
    public final void resume(View view) {
        super.resume(view);
        int size = this.f1047a.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((v) this.f1047a.get(i2)).resume(view);
        }
    }

    @Override // androidx.transition.v
    public final void runAnimators() {
        if (this.f1047a.isEmpty()) {
            start();
            end();
            return;
        }
        a0 a0Var = new a0();
        a0Var.f1045a = this;
        Iterator it = this.f1047a.iterator();
        while (it.hasNext()) {
            ((v) it.next()).addListener(a0Var);
        }
        this.f1049c = this.f1047a.size();
        if (this.f1048b) {
            Iterator it2 = this.f1047a.iterator();
            while (it2.hasNext()) {
                ((v) it2.next()).runAnimators();
            }
            return;
        }
        for (int i2 = 1; i2 < this.f1047a.size(); i2++) {
            ((v) this.f1047a.get(i2 - 1)).addListener(new h(2, this, (v) this.f1047a.get(i2)));
        }
        v vVar = (v) this.f1047a.get(0);
        if (vVar != null) {
            vVar.runAnimators();
        }
    }

    @Override // androidx.transition.v
    public final void setCanRemoveViews(boolean z2) {
        super.setCanRemoveViews(z2);
        int size = this.f1047a.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((v) this.f1047a.get(i2)).setCanRemoveViews(z2);
        }
    }

    @Override // androidx.transition.v
    public final /* bridge */ /* synthetic */ v setDuration(long j2) {
        g(j2);
        return this;
    }

    @Override // androidx.transition.v
    public final void setEpicenterCallback(t tVar) {
        super.setEpicenterCallback(tVar);
        this.f1051e |= 8;
        int size = this.f1047a.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((v) this.f1047a.get(i2)).setEpicenterCallback(tVar);
        }
    }

    @Override // androidx.transition.v
    public final void setPathMotion(n nVar) {
        super.setPathMotion(nVar);
        this.f1051e |= 4;
        if (this.f1047a != null) {
            for (int i2 = 0; i2 < this.f1047a.size(); i2++) {
                ((v) this.f1047a.get(i2)).setPathMotion(nVar);
            }
        }
    }

    @Override // androidx.transition.v
    public final void setPropagation(z zVar) {
        super.setPropagation(null);
        this.f1051e |= 2;
        int size = this.f1047a.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((v) this.f1047a.get(i2)).setPropagation(null);
        }
    }

    @Override // androidx.transition.v
    public final v setSceneRoot(ViewGroup viewGroup) {
        super.setSceneRoot(viewGroup);
        int size = this.f1047a.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((v) this.f1047a.get(i2)).setSceneRoot(viewGroup);
        }
        return this;
    }

    @Override // androidx.transition.v
    public final v setStartDelay(long j2) {
        return (b0) super.setStartDelay(j2);
    }

    @Override // androidx.transition.v
    public final String toString(String str) {
        String string = super.toString(str);
        for (int i2 = 0; i2 < this.f1047a.size(); i2++) {
            StringBuilder sbG = a.a.g(string, "\n");
            sbG.append(((v) this.f1047a.get(i2)).toString(str + "  "));
            string = sbG.toString();
        }
        return string;
    }

    @Override // androidx.transition.v
    /* renamed from: clone */
    public final v mo2clone() {
        b0 b0Var = (b0) super.mo2clone();
        b0Var.f1047a = new ArrayList();
        int size = this.f1047a.size();
        for (int i2 = 0; i2 < size; i2++) {
            v vVarMo2clone = ((v) this.f1047a.get(i2)).mo2clone();
            b0Var.f1047a.add(vVarMo2clone);
            vVarMo2clone.mParent = b0Var;
        }
        return b0Var;
    }

    @Override // androidx.transition.v
    public final v addTarget(int i2) {
        for (int i3 = 0; i3 < this.f1047a.size(); i3++) {
            ((v) this.f1047a.get(i3)).addTarget(i2);
        }
        return (b0) super.addTarget(i2);
    }

    @Override // androidx.transition.v
    public final v excludeTarget(String str, boolean z2) {
        for (int i2 = 0; i2 < this.f1047a.size(); i2++) {
            ((v) this.f1047a.get(i2)).excludeTarget(str, z2);
        }
        return super.excludeTarget(str, z2);
    }

    @Override // androidx.transition.v
    public final v removeTarget(View view) {
        for (int i2 = 0; i2 < this.f1047a.size(); i2++) {
            ((v) this.f1047a.get(i2)).removeTarget(view);
        }
        return (b0) super.removeTarget(view);
    }

    @Override // androidx.transition.v
    public final v addTarget(String str) {
        for (int i2 = 0; i2 < this.f1047a.size(); i2++) {
            ((v) this.f1047a.get(i2)).addTarget(str);
        }
        return (b0) super.addTarget(str);
    }

    @Override // androidx.transition.v
    public final v excludeTarget(int i2, boolean z2) {
        for (int i3 = 0; i3 < this.f1047a.size(); i3++) {
            ((v) this.f1047a.get(i3)).excludeTarget(i2, z2);
        }
        return super.excludeTarget(i2, z2);
    }

    @Override // androidx.transition.v
    public final v removeTarget(Class cls) {
        for (int i2 = 0; i2 < this.f1047a.size(); i2++) {
            ((v) this.f1047a.get(i2)).removeTarget((Class<?>) cls);
        }
        return (b0) super.removeTarget((Class<?>) cls);
    }

    @Override // androidx.transition.v
    public final v addTarget(Class cls) {
        for (int i2 = 0; i2 < this.f1047a.size(); i2++) {
            ((v) this.f1047a.get(i2)).addTarget((Class<?>) cls);
        }
        return (b0) super.addTarget((Class<?>) cls);
    }

    @Override // androidx.transition.v
    public final v excludeTarget(Class cls, boolean z2) {
        for (int i2 = 0; i2 < this.f1047a.size(); i2++) {
            ((v) this.f1047a.get(i2)).excludeTarget((Class<?>) cls, z2);
        }
        return super.excludeTarget((Class<?>) cls, z2);
    }

    @Override // androidx.transition.v
    public final v removeTarget(String str) {
        for (int i2 = 0; i2 < this.f1047a.size(); i2++) {
            ((v) this.f1047a.get(i2)).removeTarget(str);
        }
        return (b0) super.removeTarget(str);
    }
}
