package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import c1.l;
import x0.g;

/* loaded from: classes.dex */
public final class ViewModelInitializer<T extends ViewModel> {
    private final Class<T> clazz;
    private final l initializer;

    public ViewModelInitializer(Class<T> cls, l lVar) {
        g.u(cls, "clazz");
        g.u(lVar, "initializer");
        this.clazz = cls;
        this.initializer = lVar;
    }

    public final Class<T> getClazz$lifecycle_viewmodel_release() {
        return this.clazz;
    }

    public final l getInitializer$lifecycle_viewmodel_release() {
        return this.initializer;
    }
}
