package p0;

import android.content.ContentResolver;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.chamsion.quickchat.ui.AddNewContactsActivity;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class k extends AsyncTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2354a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Uri f2355b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2356c;

    public /* synthetic */ k(Object obj, Uri uri, int i2) {
        this.f2354a = i2;
        this.f2356c = obj;
        this.f2355b = uri;
    }

    public final void a() throws IOException {
        int i2 = this.f2354a;
        Uri uri = this.f2355b;
        Object obj = this.f2356c;
        switch (i2) {
            case 0:
                ContentResolver contentResolver = ((AddNewContactsActivity) obj).getContentResolver();
                try {
                    InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
                    OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(((AddNewContactsActivity) obj).f1330r);
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int i3 = inputStreamOpenInputStream.read(bArr);
                        if (i3 == -1) {
                            if (outputStreamOpenOutputStream != null) {
                                outputStreamOpenOutputStream.close();
                            }
                            inputStreamOpenInputStream.close();
                            break;
                        } else {
                            outputStreamOpenOutputStream.write(bArr, 0, i3);
                        }
                    }
                } catch (IOException unused) {
                    Log.d("AddNewContactsActivity", " doInBackground 211: Failed to copy photo");
                    return;
                }
            default:
                ContentResolver contentResolver2 = ((f0) obj).getActivity().getContentResolver();
                try {
                    InputStream inputStreamOpenInputStream2 = contentResolver2.openInputStream(uri);
                    OutputStream outputStreamOpenOutputStream2 = contentResolver2.openOutputStream(((f0) obj).C);
                    byte[] bArr2 = new byte[8192];
                    while (true) {
                        int i4 = inputStreamOpenInputStream2.read(bArr2);
                        if (i4 == -1) {
                            if (outputStreamOpenOutputStream2 != null) {
                                outputStreamOpenOutputStream2.close();
                            }
                            inputStreamOpenInputStream2.close();
                            break;
                        } else {
                            outputStreamOpenOutputStream2.write(bArr2, 0, i4);
                        }
                    }
                } catch (IOException unused2) {
                    Log.d("FragmentMine", " doInBackground 211: Failed to copy photo");
                }
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ Object doInBackground(Object[] objArr) throws IOException {
        switch (this.f2354a) {
            case 0:
                a();
                break;
            default:
                a();
                break;
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        Object obj2 = this.f2356c;
        int i2 = this.f2354a;
        switch (i2) {
            case 0:
                switch (i2) {
                    case 0:
                        int i3 = AddNewContactsActivity.f1312w;
                        ((AddNewContactsActivity) obj2).e();
                        break;
                    default:
                        f0 f0Var = (f0) obj2;
                        if (f0Var.isAdded()) {
                            int i4 = f0.G;
                            f0Var.g();
                            break;
                        }
                        break;
                }
            default:
                switch (i2) {
                    case 0:
                        int i5 = AddNewContactsActivity.f1312w;
                        ((AddNewContactsActivity) obj2).e();
                        break;
                    default:
                        f0 f0Var2 = (f0) obj2;
                        if (f0Var2.isAdded()) {
                            int i6 = f0.G;
                            f0Var2.g();
                            break;
                        }
                        break;
                }
        }
    }
}
