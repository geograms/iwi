package p0;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.chamsion.quickchat.ui.AddNewContactsActivity;
import java.io.File;

/* loaded from: classes.dex */
public final class l extends AsyncTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2359a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f2360b = true;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Uri f2361c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f2362d;

    public /* synthetic */ l(Object obj, Uri uri, int i2) {
        this.f2359a = i2;
        this.f2362d = obj;
        this.f2361c = uri;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0114 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0154 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0291 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0266 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x013f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v30, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v42 */
    /* JADX WARN: Type inference failed for: r1v43, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v53 */
    /* JADX WARN: Type inference failed for: r1v54 */
    /* JADX WARN: Type inference failed for: r1v55 */
    /* JADX WARN: Type inference failed for: r1v56 */
    /* JADX WARN: Type inference failed for: r1v57 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v68 */
    /* JADX WARN: Type inference failed for: r1v69 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v70 */
    /* JADX WARN: Type inference failed for: r1v71 */
    /* JADX WARN: Type inference failed for: r1v72 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x009b -> B:144:0x0151). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:89:0x01ed -> B:142:0x02a3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap a() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 714
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.l.a():android.graphics.Bitmap");
    }

    public final void b(Bitmap bitmap) {
        int i2 = this.f2359a;
        Object obj = this.f2362d;
        switch (i2) {
            case 0:
                if (bitmap != null) {
                    AddNewContactsActivity addNewContactsActivity = (AddNewContactsActivity) obj;
                    addNewContactsActivity.f1316d.setImageDrawable(t0.c.a(addNewContactsActivity.f1327o, bitmap));
                    addNewContactsActivity.f1333u = bitmap;
                }
                AddNewContactsActivity addNewContactsActivity2 = (AddNewContactsActivity) obj;
                if (addNewContactsActivity2.getCacheDir() != null) {
                    new File(addNewContactsActivity2.getCacheDir(), "TakeEditUserPhoto2.jpg").delete();
                    new File(addNewContactsActivity2.getCacheDir(), "CropEditUserPhoto.jpg").delete();
                    break;
                }
                break;
            default:
                f0 f0Var = (f0) obj;
                int i3 = f0.G;
                f0Var.m(bitmap);
                if (f0Var.getActivity() != null && f0Var.getActivity().getCacheDir() != null) {
                    new File(f0Var.getActivity().getCacheDir(), "TakeEditUserPhoto2.jpg").delete();
                    new File(f0Var.getActivity().getCacheDir(), "CropEditUserPhoto.jpg").delete();
                    break;
                }
                break;
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) {
        switch (this.f2359a) {
            case 0:
                break;
            default:
                break;
        }
        return a();
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        switch (this.f2359a) {
            case 0:
                b((Bitmap) obj);
                break;
            default:
                b((Bitmap) obj);
                break;
        }
    }
}
