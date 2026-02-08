package y;

import android.widget.EditText;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class k extends androidx.emoji2.text.h {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f2682a;

    public k(EditText editText) {
        this.f2682a = new WeakReference(editText);
    }

    @Override // androidx.emoji2.text.h
    public final void onInitialized() {
        l.a((EditText) this.f2682a.get(), 1);
    }
}
