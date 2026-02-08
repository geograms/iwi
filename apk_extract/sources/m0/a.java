package m0;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import java.io.Serializable;

/* loaded from: classes.dex */
public final class a implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public int f2090a;

    /* renamed from: b, reason: collision with root package name */
    public int f2091b;

    /* renamed from: c, reason: collision with root package name */
    public String f2092c;

    /* renamed from: d, reason: collision with root package name */
    public int f2093d;

    /* renamed from: e, reason: collision with root package name */
    public String f2094e;

    /* renamed from: f, reason: collision with root package name */
    public int f2095f;

    /* renamed from: g, reason: collision with root package name */
    public String f2096g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f2097h;

    public final void a(Bitmap bitmap) {
        if (bitmap == null) {
            this.f2097h = null;
            return;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        this.f2097h = byteArrayOutputStream.toByteArray();
    }
}
