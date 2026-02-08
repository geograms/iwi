package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.chamsion.quickchat.widget.CheckMarkView;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class r extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1111a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1112b;

    public /* synthetic */ r(int i2, Object obj) {
        this.f1111a = i2;
        this.f1112b = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i2 = this.f1111a;
        Object obj = this.f1112b;
        switch (i2) {
            case 0:
                ((v) obj).end();
                animator.removeListener(this);
                break;
            case 1:
                androidx.vectordrawable.graphics.drawable.g gVar = (androidx.vectordrawable.graphics.drawable.g) obj;
                ArrayList arrayList = new ArrayList(gVar.f1139e);
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((androidx.vectordrawable.graphics.drawable.c) arrayList.get(i3)).onAnimationEnd(gVar);
                }
                break;
            default:
                CheckMarkView checkMarkView = (CheckMarkView) obj;
                Iterator it = checkMarkView.f1515e.iterator();
                while (it.hasNext()) {
                    ((Animator.AnimatorListener) it.next()).onAnimationEnd(animator);
                }
                checkMarkView.f1515e.clear();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f1111a) {
            case 1:
                androidx.vectordrawable.graphics.drawable.g gVar = (androidx.vectordrawable.graphics.drawable.g) this.f1112b;
                ArrayList arrayList = new ArrayList(gVar.f1139e);
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((androidx.vectordrawable.graphics.drawable.c) arrayList.get(i2)).onAnimationStart(gVar);
                }
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
