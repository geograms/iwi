package androidx.emoji2.text;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.inputmethod.EditorInfo;

/* loaded from: classes.dex */
public final class e extends k.j {

    /* renamed from: c, reason: collision with root package name */
    public volatile p f367c;

    /* renamed from: d, reason: collision with root package name */
    public volatile u f368d;

    public final void n() {
        try {
            ((j) this.f1934b).f379f.e(new d(this));
        } catch (Throwable th) {
            ((j) this.f1934b).d(th);
        }
    }

    public final CharSequence o(CharSequence charSequence, int i2, int i3, boolean z2) {
        y yVar;
        int iCharCount;
        x[] xVarArr;
        p pVar = this.f367c;
        pVar.getClass();
        boolean z3 = charSequence instanceof w;
        if (z3) {
            ((w) charSequence).a();
        }
        if (!z3) {
            try {
                yVar = charSequence instanceof Spannable ? new y((Spannable) charSequence) : (!(charSequence instanceof Spanned) || ((Spanned) charSequence).nextSpanTransition(i2 + (-1), i3 + 1, x.class) > i3) ? null : new y(charSequence);
            } finally {
                if (z3) {
                    ((w) charSequence).b();
                }
            }
        }
        if (yVar != null && (xVarArr = (x[]) yVar.f426b.getSpans(i2, i3, x.class)) != null && xVarArr.length > 0) {
            for (x xVar : xVarArr) {
                int spanStart = yVar.f426b.getSpanStart(xVar);
                int spanEnd = yVar.f426b.getSpanEnd(xVar);
                if (spanStart != i3) {
                    yVar.removeSpan(xVar);
                }
                i2 = Math.min(spanStart, i2);
                i3 = Math.max(spanEnd, i3);
            }
        }
        if (i2 != i3 && i2 < charSequence.length()) {
            o oVar = new o((t) pVar.f399b.f416c);
            int iCodePointAt = Character.codePointAt(charSequence, i2);
            int i4 = 0;
            y yVar2 = yVar;
            loop1: while (true) {
                iCharCount = i2;
                while (i2 < i3 && i4 < Integer.MAX_VALUE) {
                    int iA = oVar.a(iCodePointAt);
                    if (iA == 1) {
                        iCharCount += Character.charCount(Character.codePointAt(charSequence, iCharCount));
                        if (iCharCount < i3) {
                            iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                        }
                        i2 = iCharCount;
                    } else if (iA == 2) {
                        i2 += Character.charCount(iCodePointAt);
                        if (i2 < i3) {
                            iCodePointAt = Character.codePointAt(charSequence, i2);
                        }
                    } else if (iA == 3) {
                        if (z2 || !pVar.b(charSequence, iCharCount, i2, oVar.f395d.f413b)) {
                            if (yVar2 == null) {
                                yVar2 = new y((Spannable) new SpannableString(charSequence));
                            }
                            n nVar = oVar.f395d.f413b;
                            pVar.f398a.getClass();
                            yVar2.setSpan(new x(nVar), iCharCount, i2, 33);
                            i4++;
                        }
                    }
                }
                break loop1;
            }
            if (oVar.f392a == 2 && oVar.f394c.f413b != null && ((oVar.f397f > 1 || oVar.c()) && i4 < Integer.MAX_VALUE && (z2 || !pVar.b(charSequence, iCharCount, i2, oVar.f394c.f413b)))) {
                if (yVar2 == null) {
                    yVar2 = new y(charSequence);
                }
                n nVar2 = oVar.f394c.f413b;
                pVar.f398a.getClass();
                yVar2.setSpan(new x(nVar2), iCharCount, i2, 33);
            }
            if (yVar2 != null) {
                Spannable spannable = yVar2.f426b;
                if (z3) {
                    ((w) charSequence).b();
                }
                return spannable;
            }
            if (!z3) {
                return charSequence;
            }
        } else if (!z3) {
            return charSequence;
        }
        return charSequence;
    }

    public final void p(EditorInfo editorInfo) {
        Bundle bundle = editorInfo.extras;
        x.b bVar = (x.b) this.f368d.f414a;
        int iA = bVar.a(4);
        bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", iA != 0 ? bVar.f2649b.getInt(iA + bVar.f2648a) : 0);
        Bundle bundle2 = editorInfo.extras;
        ((j) this.f1934b).getClass();
        bundle2.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
    }
}
