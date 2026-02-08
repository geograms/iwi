package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final c.c f398a;

    /* renamed from: b, reason: collision with root package name */
    public final u f399b;

    /* renamed from: c, reason: collision with root package name */
    public final g f400c;

    public p(u uVar, c.c cVar, c cVar2) {
        this.f398a = cVar;
        this.f399b = uVar;
        this.f400c = cVar2;
    }

    public static boolean a(Editable editable, KeyEvent keyEvent, boolean z2) {
        x[] xVarArr;
        if (!KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (xVarArr = (x[]) editable.getSpans(selectionStart, selectionEnd, x.class)) != null && xVarArr.length > 0) {
            for (x xVar : xVarArr) {
                int spanStart = editable.getSpanStart(xVar);
                int spanEnd = editable.getSpanEnd(xVar);
                if ((z2 && spanStart == selectionStart) || ((!z2 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean b(CharSequence charSequence, int i2, int i3, n nVar) {
        if (nVar.f391c == 0) {
            g gVar = this.f400c;
            x.a aVarC = nVar.c();
            int iA = aVarC.a(8);
            if (iA != 0) {
                aVarC.f2649b.getShort(iA + aVarC.f2648a);
            }
            c cVar = (c) gVar;
            cVar.getClass();
            ThreadLocal threadLocal = c.f364b;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = (StringBuilder) threadLocal.get();
            sb.setLength(0);
            while (i2 < i3) {
                sb.append(charSequence.charAt(i2));
                i2++;
            }
            TextPaint textPaint = cVar.f365a;
            String string = sb.toString();
            int i4 = k.h.f1930a;
            nVar.f391c = k.g.a(textPaint, string) ? 2 : 1;
        }
        return nVar.f391c == 2;
    }
}
