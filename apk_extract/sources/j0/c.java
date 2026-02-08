package j0;

import android.content.Context;
import android.net.Uri;
import java.util.LinkedHashMap;
import k0.h;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f1900a = Uri.parse("content://com.chamsion.quickchat.provider/support_screenoff_talk");

    /* renamed from: b, reason: collision with root package name */
    public static final Boolean f1901b;

    /* renamed from: c, reason: collision with root package name */
    public static final Boolean f1902c;

    /* renamed from: d, reason: collision with root package name */
    public static final LinkedHashMap f1903d;

    /* renamed from: e, reason: collision with root package name */
    public static final String f1904e;

    static {
        Boolean bool = Boolean.FALSE;
        f1901b = bool;
        f1902c = bool;
        f1903d = new LinkedHashMap();
        f1904e = "channel_area_default_uhf";
    }

    public static String a(Context context, String str) {
        boolean z2 = false;
        for (int i2 = 0; i2 < 14; i2++) {
            if (h.f1985b[i2][0].equals(str)) {
                z2 = true;
            }
        }
        return !z2 ? str : context.getString(context.getResources().getIdentifier(str, "string", context.getPackageName()));
    }
}
