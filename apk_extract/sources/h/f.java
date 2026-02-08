package h;

import android.app.Activity;
import android.text.TextUtils;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class f extends i.e {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f1829b = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(Activity activity, String[] strArr, int i2) {
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException(a.a.e(new StringBuilder("Permission request for permissions "), Arrays.toString(strArr), " must not contain null or empty values"));
            }
        }
        if (activity instanceof e) {
            ((e) activity).validateRequestPermissionsRequestCode(i2);
        }
        c.b(activity, strArr, i2);
    }
}
