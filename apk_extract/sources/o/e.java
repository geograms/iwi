package o;

import android.util.Base64;
import java.util.List;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f2216a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2217b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2218c;

    /* renamed from: d, reason: collision with root package name */
    public final List f2219d;

    /* renamed from: e, reason: collision with root package name */
    public final String f2220e;

    public e(String str, String str2, String str3, List list) {
        str.getClass();
        this.f2216a = str;
        str2.getClass();
        this.f2217b = str2;
        this.f2218c = str3;
        list.getClass();
        this.f2219d = list;
        this.f2220e = str + "-" + str2 + "-" + str3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f2216a + ", mProviderPackage: " + this.f2217b + ", mQuery: " + this.f2218c + ", mCertificates:");
        int i2 = 0;
        while (true) {
            List list = this.f2219d;
            if (i2 >= list.size()) {
                sb.append("}mCertificatesArray: 0");
                return sb.toString();
            }
            sb.append(" [");
            List list2 = (List) list.get(i2);
            for (int i3 = 0; i3 < list2.size(); i3++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString((byte[]) list2.get(i3), 0));
                sb.append("\"");
            }
            sb.append(" ]");
            i2++;
        }
    }
}
