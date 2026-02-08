package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Parcelable;
import androidx.versionedparcelable.CustomVersionedParcelable;
import l.d;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f114k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    public Object f116b;

    /* renamed from: j, reason: collision with root package name */
    public String f124j;

    /* renamed from: a, reason: collision with root package name */
    public int f115a = -1;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f117c = null;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f118d = null;

    /* renamed from: e, reason: collision with root package name */
    public int f119e = 0;

    /* renamed from: f, reason: collision with root package name */
    public int f120f = 0;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f121g = null;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f122h = f114k;

    /* renamed from: i, reason: collision with root package name */
    public String f123i = null;

    public final String toString() {
        String str;
        int iA;
        if (this.f115a == -1) {
            return String.valueOf(this.f116b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.f115a) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case 4:
                str = "URI";
                break;
            case 5:
                str = "BITMAP_MASKABLE";
                break;
            case 6:
                str = "URI_MASKABLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        sb.append(str);
        switch (this.f115a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f116b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f116b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f124j);
                sb.append(" id=");
                int i2 = this.f115a;
                if (i2 == -1) {
                    iA = d.a(this.f116b);
                } else {
                    if (i2 != 2) {
                        throw new IllegalStateException("called getResId() on " + this);
                    }
                    iA = this.f119e;
                }
                sb.append(String.format("0x%08x", Integer.valueOf(iA)));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f119e);
                if (this.f120f != 0) {
                    sb.append(" off=");
                    sb.append(this.f120f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f116b);
                break;
        }
        if (this.f121g != null) {
            sb.append(" tint=");
            sb.append(this.f121g);
        }
        if (this.f122h != f114k) {
            sb.append(" mode=");
            sb.append(this.f122h);
        }
        sb.append(")");
        return sb.toString();
    }
}
