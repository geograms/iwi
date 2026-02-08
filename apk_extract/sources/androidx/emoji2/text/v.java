package androidx.emoji2.text;

import android.text.Editable;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextWatcher;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class v implements TextWatcher, SpanWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final Object f418a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f419b = new AtomicInteger(0);

    public v(Object obj) {
        this.f418a = obj;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        ((TextWatcher) this.f418a).afterTextChanged(editable);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        ((TextWatcher) this.f418a).beforeTextChanged(charSequence, i2, i3, i4);
    }

    @Override // android.text.SpanWatcher
    public final void onSpanAdded(Spannable spannable, Object obj, int i2, int i3) {
        if (this.f419b.get() <= 0 || !(obj instanceof x)) {
            ((SpanWatcher) this.f418a).onSpanAdded(spannable, obj, i2, i3);
        }
    }

    @Override // android.text.SpanWatcher
    public final void onSpanChanged(Spannable spannable, Object obj, int i2, int i3, int i4, int i5) {
        if (this.f419b.get() <= 0 || !(obj instanceof x)) {
            ((SpanWatcher) this.f418a).onSpanChanged(spannable, obj, i2, i3, i4, i5);
        }
    }

    @Override // android.text.SpanWatcher
    public final void onSpanRemoved(Spannable spannable, Object obj, int i2, int i3) {
        if (this.f419b.get() <= 0 || !(obj instanceof x)) {
            ((SpanWatcher) this.f418a).onSpanRemoved(spannable, obj, i2, i3);
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        ((TextWatcher) this.f418a).onTextChanged(charSequence, i2, i3, i4);
    }
}
