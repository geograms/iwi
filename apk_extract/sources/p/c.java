package p;

import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f2268a;

    /* renamed from: b, reason: collision with root package name */
    public final TextDirectionHeuristic f2269b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2270c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2271d;

    public c(PrecomputedText.Params params) {
        this.f2268a = params.getTextPaint();
        this.f2269b = params.getTextDirection();
        this.f2270c = params.getBreakStrategy();
        this.f2271d = params.getHyphenationFrequency();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.f2270c == cVar.f2270c && this.f2271d == cVar.f2271d) {
            TextPaint textPaint = this.f2268a;
            float textSize = textPaint.getTextSize();
            TextPaint textPaint2 = cVar.f2268a;
            return textSize == textPaint2.getTextSize() && textPaint.getTextScaleX() == textPaint2.getTextScaleX() && textPaint.getTextSkewX() == textPaint2.getTextSkewX() && textPaint.getLetterSpacing() == textPaint2.getLetterSpacing() && TextUtils.equals(textPaint.getFontFeatureSettings(), textPaint2.getFontFeatureSettings()) && textPaint.getFlags() == textPaint2.getFlags() && textPaint.getTextLocales().equals(textPaint2.getTextLocales()) && (textPaint.getTypeface() != null ? textPaint.getTypeface().equals(textPaint2.getTypeface()) : textPaint2.getTypeface() == null) && this.f2269b == cVar.f2269b;
        }
        return false;
    }

    public final int hashCode() {
        TextPaint textPaint = this.f2268a;
        return q.b.b(Float.valueOf(textPaint.getTextSize()), Float.valueOf(textPaint.getTextScaleX()), Float.valueOf(textPaint.getTextSkewX()), Float.valueOf(textPaint.getLetterSpacing()), Integer.valueOf(textPaint.getFlags()), textPaint.getTextLocales(), textPaint.getTypeface(), Boolean.valueOf(textPaint.isElegantTextHeight()), this.f2269b, Integer.valueOf(this.f2270c), Integer.valueOf(this.f2271d));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        StringBuilder sb2 = new StringBuilder("textSize=");
        TextPaint textPaint = this.f2268a;
        sb2.append(textPaint.getTextSize());
        sb.append(sb2.toString());
        sb.append(", textScaleX=" + textPaint.getTextScaleX());
        sb.append(", textSkewX=" + textPaint.getTextSkewX());
        sb.append(", letterSpacing=" + textPaint.getLetterSpacing());
        sb.append(", elegantTextHeight=" + textPaint.isElegantTextHeight());
        sb.append(", textLocale=" + textPaint.getTextLocales());
        sb.append(", typeface=" + textPaint.getTypeface());
        sb.append(", variationSettings=" + textPaint.getFontVariationSettings());
        sb.append(", textDir=" + this.f2269b);
        sb.append(", breakStrategy=" + this.f2270c);
        sb.append(", hyphenationFrequency=" + this.f2271d);
        sb.append("}");
        return sb.toString();
    }
}
