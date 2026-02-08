package p;

import android.text.TextUtils;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class j {
    public static int a(Locale locale) {
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
