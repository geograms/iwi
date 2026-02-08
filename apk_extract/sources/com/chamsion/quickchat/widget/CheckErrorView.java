package com.chamsion.quickchat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.chamsion.quickchat.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class CheckErrorView extends View {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f1506a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f1507b;

    public CheckErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        new ArrayList();
        Paint paint = new Paint(1);
        this.f1506a = paint;
        paint.setColor(getContext().getResources().getColor(R.color.channel_view_normal));
        Paint paint2 = this.f1506a;
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        this.f1506a.setStrokeWidth(10.0f);
        Paint paint3 = new Paint(1);
        this.f1507b = paint3;
        paint3.setColor(getContext().getResources().getColor(R.color.channel_view_normal));
        this.f1507b.setStrokeWidth(10.0f);
        this.f1507b.setStyle(style);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float fMin = Math.min(0.0f, 1.0f);
        float fMax = Math.max(-1.0f, 0.0f);
        int width = getWidth();
        float f2 = width / 2.0f;
        float height = getHeight() / 2.0f;
        float fMin2 = Math.min(width, r5) / 2.5f;
        canvas.drawCircle(f2, height, fMin2, this.f1506a);
        if (fMin > 0.0f) {
            float f3 = fMin2 * 0.4f;
            float f4 = f2 - f3;
            float f5 = height - f3;
            float f6 = fMin2 * 0.8f * fMin;
            canvas.drawLine(f4, f5, f4 + f6, f5 + f6, this.f1507b);
        }
        if (fMax > 0.0f) {
            float f7 = 0.4f * fMin2;
            float f8 = f2 + f7;
            float f9 = height - f7;
            float f10 = fMin2 * 0.8f * fMax;
            canvas.drawLine(f8, f9, f8 - f10, f9 + f10, this.f1507b);
        }
    }
}
