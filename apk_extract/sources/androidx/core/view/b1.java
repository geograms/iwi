package androidx.core.view;

import android.view.ContentInfo;
import android.view.OnReceiveContentListener;
import android.view.View;
import java.util.Objects;

/* loaded from: classes.dex */
public final class b1 implements OnReceiveContentListener {

    /* renamed from: a, reason: collision with root package name */
    public final d0 f132a;

    public b1(d0 d0Var) {
        this.f132a = d0Var;
    }

    public final ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
        l lVar = new l(new k.j(contentInfo));
        l lVarA = ((u.s) this.f132a).a(view, lVar);
        if (lVarA == null) {
            return null;
        }
        if (lVarA == lVar) {
            return contentInfo;
        }
        ContentInfo contentInfoG = lVarA.f183a.g();
        Objects.requireNonNull(contentInfoG);
        return g.f(contentInfoG);
    }
}
