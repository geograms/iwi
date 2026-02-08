package t;

import android.content.ClipData;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.core.view.d1;
import androidx.core.view.h;
import androidx.core.view.i;
import k.j;

/* loaded from: classes.dex */
public final class b extends InputConnectionWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.android.material.search.a f2548a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(InputConnection inputConnection, com.google.android.material.search.a aVar) {
        super(inputConnection, false);
        this.f2548a = aVar;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo, int i2, Bundle bundle) {
        Bundle bundle2;
        j jVar = inputContentInfo == null ? null : new j(7, new j(inputContentInfo));
        View view = (View) this.f2548a.f1575a;
        if ((i2 & 1) != 0) {
            try {
                jVar.a();
                InputContentInfo inputContentInfo2 = (InputContentInfo) ((d) jVar.f1934b).j();
                bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle2.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfo2);
            } catch (Exception e2) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e2);
            }
        } else {
            bundle2 = bundle;
        }
        ClipData clipData = new ClipData(jVar.i(), new ClipData.Item(jVar.k()));
        i hVar = Build.VERSION.SDK_INT >= 31 ? new h(clipData, 2) : new androidx.core.view.j(clipData, 2);
        hVar.c(jVar.c());
        hVar.setExtras(bundle2);
        if (d1.h(view, hVar.a()) == null) {
            return true;
        }
        return super.commitContent(inputContentInfo, i2, bundle);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean performPrivateCommand(String str, Bundle bundle) {
        return super.performPrivateCommand(str, bundle);
    }
}
