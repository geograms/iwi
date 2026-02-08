package u;

import android.widget.ListView;

/* loaded from: classes.dex */
public abstract class h {
    public static boolean a(ListView listView, int i2) {
        return listView.canScrollList(i2);
    }

    public static void b(ListView listView, int i2) {
        listView.scrollListBy(i2);
    }
}
