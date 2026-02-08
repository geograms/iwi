package com.chamsion.quickchat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.chamsion.quickchat.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class CheckInitializeView extends View {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f1508a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f1509b;

    public CheckInitializeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        new ArrayList();
        Paint paint = new Paint(1);
        this.f1508a = paint;
        paint.setColor(getContext().getResources().getColor(R.color.channel_view_normal));
        Paint paint2 = this.f1508a;
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        this.f1508a.setStrokeWidth(10.0f);
        Paint paint3 = new Paint(1);
        this.f1509b = paint3;
        paint3.setColor(getContext().getResources().getColor(R.color.channel_view_normal));
        this.f1509b.setStrokeWidth(10.0f);
        this.f1509b.setStyle(style);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        float f2 = width / 2.0f;
        float height = getHeight() / 2.0f;
        float fMin = Math.min(width, r1) / 2.5f;
        this.f1509b.setStrokeWidth(8.0f);
        this.f1509b.setStyle(Paint.Style.STROKE);
        canvas.drawArc(new RectF(f2 - fMin, height - fMin, f2 + fMin, height + fMin), ((System.currentTimeMillis() % 1000) / 1000.0f) * 360.0f, 90.0f, false, this.f1509b);
    }
}
