package k;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;

/* loaded from: classes.dex */
public abstract class a {
    public static ColorFilter a(int i2, Object obj) {
        return new BlendModeColorFilter(i2, (BlendMode) obj);
    }
}
