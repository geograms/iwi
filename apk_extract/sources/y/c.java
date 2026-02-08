package y;

import android.text.Editable;
import androidx.emoji2.text.w;

/* loaded from: classes.dex */
public final class c extends Editable.Factory {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f2666a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static volatile c f2667b;

    /* renamed from: c, reason: collision with root package name */
    public static Class f2668c;

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class cls = f2668c;
        return cls != null ? new w(cls, charSequence) : super.newEditable(charSequence);
    }
}
