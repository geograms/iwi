package p0;

import me.f1reking.serialportlib.listener.Status;

/* loaded from: classes.dex */
public abstract /* synthetic */ class n0 {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f2368a;

    static {
        int[] iArr = new int[Status.values().length];
        f2368a = iArr;
        try {
            iArr[Status.NO_READ_WRITE_PERMISSION.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f2368a[Status.OPEN_FAIL.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
