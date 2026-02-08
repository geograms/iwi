package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.style.ReplacementSpan;

/* loaded from: classes.dex */
public final class x extends ReplacementSpan {

    /* renamed from: b, reason: collision with root package name */
    public final n f423b;

    /* renamed from: a, reason: collision with root package name */
    public final Paint.FontMetricsInt f422a = new Paint.FontMetricsInt();

    /* renamed from: c, reason: collision with root package name */
    public float f424c = 1.0f;

    public x(n nVar) {
        if (nVar == null) {
            throw new NullPointerException("metadata cannot be null");
        }
        this.f423b = nVar;
    }

    @Override // android.text.style.ReplacementSpan
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int getSize(Paint paint, CharSequence charSequence, int i2, int i3, Paint.FontMetricsInt fontMetricsInt) {
        Paint.FontMetricsInt fontMetricsInt2 = this.f422a;
        paint.getFontMetricsInt(fontMetricsInt2);
        float fAbs = Math.abs(fontMetricsInt2.descent - fontMetricsInt2.ascent) * 1.0f;
        n nVar = this.f423b;
        this.f424c = fAbs / (nVar.c().a(14) != 0 ? r8.f2649b.getShort(r1 + r8.f2648a) : (short) 0);
        x.a aVarC = nVar.c();
        int iA = aVarC.a(14);
        if (iA != 0) {
            aVarC.f2649b.getShort(iA + aVarC.f2648a);
        }
        short s2 = (short) ((nVar.c().a(12) != 0 ? r5.f2649b.getShort(r7 + r5.f2648a) : (short) 0) * this.f424c);
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = fontMetricsInt2.ascent;
            fontMetricsInt.descent = fontMetricsInt2.descent;
            fontMetricsInt.top = fontMetricsInt2.top;
            fontMetricsInt.bottom = fontMetricsInt2.bottom;
        }
        return s2;
    }

    @Override // android.text.style.ReplacementSpan
    public final void draw(Canvas canvas, CharSequence charSequence, int i2, int i3, float f2, int i4, int i5, int i6, Paint paint) {
        j.a().getClass();
        n nVar = this.f423b;
        u uVar = nVar.f390b;
        Typeface typeface = (Typeface) uVar.f417d;
        Typeface typeface2 = paint.getTypeface();
        paint.setTypeface(typeface);
        canvas.drawText((char[]) uVar.f415b, nVar.f389a * 2, 2, f2, i5, paint);
        paint.setTypeface(typeface2);
    }
}
