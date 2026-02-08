package androidx.emoji2.text;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import java.util.stream.IntStream;

/* loaded from: classes.dex */
public final class y implements Spannable {

    /* renamed from: a, reason: collision with root package name */
    public boolean f425a = false;

    /* renamed from: b, reason: collision with root package name */
    public Spannable f426b;

    public y(Spannable spannable) {
        this.f426b = spannable;
    }

    @Override // java.lang.CharSequence
    public final char charAt(int i2) {
        return this.f426b.charAt(i2);
    }

    @Override // java.lang.CharSequence
    public final IntStream chars() {
        return this.f426b.chars();
    }

    @Override // java.lang.CharSequence
    public final IntStream codePoints() {
        return this.f426b.codePoints();
    }

    @Override // android.text.Spanned
    public final int getSpanEnd(Object obj) {
        return this.f426b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanFlags(Object obj) {
        return this.f426b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public final int getSpanStart(Object obj) {
        return this.f426b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public final Object[] getSpans(int i2, int i3, Class cls) {
        return this.f426b.getSpans(i2, i3, cls);
    }

    @Override // java.lang.CharSequence
    public final int length() {
        return this.f426b.length();
    }

    @Override // android.text.Spanned
    public final int nextSpanTransition(int i2, int i3, Class cls) {
        return this.f426b.nextSpanTransition(i2, i3, cls);
    }

    @Override // android.text.Spannable
    public final void removeSpan(Object obj) {
        Spannable spannable = this.f426b;
        if (!this.f425a && (spannable instanceof PrecomputedText)) {
            this.f426b = new SpannableString(spannable);
        }
        this.f425a = true;
        this.f426b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public final void setSpan(Object obj, int i2, int i3, int i4) {
        Spannable spannable = this.f426b;
        if (!this.f425a && (spannable instanceof PrecomputedText)) {
            this.f426b = new SpannableString(spannable);
        }
        this.f425a = true;
        this.f426b.setSpan(obj, i2, i3, i4);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i2, int i3) {
        return this.f426b.subSequence(i2, i3);
    }

    @Override // java.lang.CharSequence
    public final String toString() {
        return this.f426b.toString();
    }

    public y(CharSequence charSequence) {
        this.f426b = new SpannableString(charSequence);
    }
}
