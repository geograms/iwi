package androidx.recyclerview.widget;

import android.database.Observable;

/* loaded from: classes.dex */
public final class w0 extends Observable {
    public final boolean a() {
        return !((Observable) this).mObservers.isEmpty();
    }

    public final void b() {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((x0) ((Observable) this).mObservers.get(size)).onChanged();
        }
    }

    public final void c(int i2, int i3) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((x0) ((Observable) this).mObservers.get(size)).onItemRangeMoved(i2, i3, 1);
        }
    }

    public final void d(int i2, int i3, Object obj) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((x0) ((Observable) this).mObservers.get(size)).onItemRangeChanged(i2, i3, obj);
        }
    }

    public final void e(int i2, int i3) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((x0) ((Observable) this).mObservers.get(size)).onItemRangeInserted(i2, i3);
        }
    }

    public final void f(int i2, int i3) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((x0) ((Observable) this).mObservers.get(size)).onItemRangeRemoved(i2, i3);
        }
    }
}
