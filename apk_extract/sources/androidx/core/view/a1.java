package androidx.core.view;

import android.view.ContentInfo;
import android.view.View;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class a1 {
    public static String[] a(View view) {
        return view.getReceiveContentMimeTypes();
    }

    public static l b(View view, l lVar) {
        ContentInfo contentInfoG = lVar.f183a.g();
        Objects.requireNonNull(contentInfoG);
        ContentInfo contentInfoF = g.f(contentInfoG);
        ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoF);
        if (contentInfoPerformReceiveContent == null) {
            return null;
        }
        return contentInfoPerformReceiveContent == contentInfoF ? lVar : new l(new k.j(contentInfoPerformReceiveContent));
    }

    public static void c(View view, String[] strArr, d0 d0Var) {
        if (d0Var == null) {
            view.setOnReceiveContentListener(strArr, null);
        } else {
            view.setOnReceiveContentListener(strArr, new b1(d0Var));
        }
    }
}
