package w;

import android.view.View;
import android.view.WindowInsets;
import androidx.drawerlayout.widget.DrawerLayout;

/* loaded from: classes.dex */
public final class a implements View.OnApplyWindowInsetsListener {
    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        DrawerLayout drawerLayout = (DrawerLayout) view;
        boolean z2 = false;
        boolean z3 = windowInsets.getSystemWindowInsetTop() > 0;
        drawerLayout.f312w = windowInsets;
        drawerLayout.f313x = z3;
        if (!z3 && drawerLayout.getBackground() == null) {
            z2 = true;
        }
        drawerLayout.setWillNotDraw(z2);
        drawerLayout.requestLayout();
        return windowInsets.consumeSystemWindowInsets();
    }
}
