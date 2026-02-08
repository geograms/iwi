package com.chamsion.quickchat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.chamsion.quickchat.R;
import i.d;
import i.e;

/* loaded from: classes.dex */
public class CircleProgressDrawable extends View {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f1516a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f1517b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f1518c;

    /* renamed from: d, reason: collision with root package name */
    public int f1519d;

    /* renamed from: e, reason: collision with root package name */
    public RectF f1520e;

    public CircleProgressDrawable(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Paint paint = new Paint();
        this.f1516a = paint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setStrokeWidth(27.0f);
        int i2 = R.color.progess_background;
        Object obj = e.f1841a;
        paint.setColor(d.a(context, i2));
        Paint paint2 = new Paint();
        this.f1518c = paint2;
        paint2.setStyle(style);
        paint2.setStrokeCap(cap);
        paint2.setAntiAlias(true);
        paint2.setDither(true);
        paint2.setStrokeWidth(20.0f);
        paint2.setColor(d.a(context, R.color.progess_background_seleted));
        int i3 = R.color.color1;
        int i4 = R.color.color2;
        if (i3 == -1 || i4 == -1) {
            this.f1517b = null;
        } else {
            this.f1517b = new int[]{i3, i4};
        }
        this.f1519d = 0;
    }

    public int getProgress() {
        return this.f1519d;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.f1520e, 0.0f, 360.0f, false, this.f1516a);
        canvas.drawArc(this.f1520e, 275.0f, (this.f1519d * 360) / 100, false, this.f1518c);
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        float f2 = measuredWidth > measuredHeight ? measuredHeight : measuredWidth;
        Paint paint = this.f1516a;
        float strokeWidth = paint.getStrokeWidth();
        Paint paint2 = this.f1518c;
        if (strokeWidth <= paint2.getStrokeWidth()) {
            paint = paint2;
        }
        int strokeWidth2 = (int) (f2 - paint.getStrokeWidth());
        this.f1520e = new RectF(((measuredWidth - strokeWidth2) / 2) + getPaddingLeft(), ((measuredHeight - strokeWidth2) / 2) + getPaddingTop(), r6 + strokeWidth2, r7 + strokeWidth2);
    }

    public void setBackColor(int i2) {
        Paint paint = this.f1516a;
        Context context = getContext();
        Object obj = e.f1841a;
        paint.setColor(d.a(context, i2));
        invalidate();
    }

    public void setBackWidth(int i2) {
        this.f1516a.setStrokeWidth(i2);
        invalidate();
    }

    public void setProgColor(int i2) {
        Paint paint = this.f1518c;
        Context context = getContext();
        Object obj = e.f1841a;
        paint.setColor(d.a(context, i2));
        paint.setShader(null);
        invalidate();
    }

    public void setProgWidth(int i2) {
        this.f1518c.setStrokeWidth(i2);
        invalidate();
    }

    public void setProgress(int i2) {
        this.f1519d = i2;
        invalidate();
    }

    public void setProgColor(int[] iArr) {
        if (iArr == null || iArr.length < 2) {
            return;
        }
        this.f1517b = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int[] iArr2 = this.f1517b;
            Context context = getContext();
            int i3 = iArr[i2];
            Object obj = e.f1841a;
            iArr2[i2] = d.a(context, i3);
        }
        this.f1518c.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getMeasuredWidth(), this.f1517b, (float[]) null, Shader.TileMode.MIRROR));
        invalidate();
    }
}
