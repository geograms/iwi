package v0;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public abstract class h extends g {
    public static void M0(AbstractCollection abstractCollection, Object[] objArr) {
        x0.g.u(objArr, "elements");
        List listAsList = Arrays.asList(objArr);
        x0.g.t(listAsList, "asList(this)");
        abstractCollection.addAll(listAsList);
    }
}
