package com.chamsion.quickchat.widget;

import a.a;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.chamsion.quickchat.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class CheckMarkView extends View {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f1510f = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Paint f1511a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f1512b;

    /* renamed from: c, reason: collision with root package name */
    public float f1513c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1514d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f1515e;

    public CheckMarkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f1513c = 0.0f;
        this.f1514d = false;
        this.f1515e = new ArrayList();
        Paint paint = new Paint(1);
        this.f1511a = paint;
        paint.setColor(getContext().getResources().getColor(R.color.channel_view_normal));
        Paint paint2 = this.f1511a;
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        this.f1511a.setStrokeWidth(10.0f);
        Paint paint3 = new Paint(1);
        this.f1512b = paint3;
        paint3.setColor(getContext().getResources().getColor(R.color.channel_view_normal));
        this.f1512b.setStrokeWidth(10.0f);
        this.f1512b.setStyle(style);
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float fMin = Math.min(this.f1513c / 0.5f, 1.0f);
        float fMax = Math.max((this.f1513c - 0.5f) / 0.5f, 0.0f);
        int width = getWidth();
        float f2 = width / 2.0f;
        float height = getHeight() / 2.0f;
        float fMin2 = Math.min(width, r6) / 2.5f;
        canvas.drawCircle(f2, height, fMin2, this.f1511a);
        float f3 = 0.2f * fMin2;
        float f4 = f2 - (0.3f * fMin2);
        float f5 = (0.4f * fMin2) + f2;
        float f6 = (f2 - (0.7f * fMin2)) + f3;
        float f7 = (height + f3) - f3;
        float f8 = f4 + f3;
        float f9 = ((0.5f * fMin2) + height) - f3;
        float f10 = f5 + f3;
        float f11 = (height - f3) - f3;
        new Path().moveTo(f6, f7);
        canvas.drawLine(f6, f7, ((f8 - f6) * fMin) + f6, a.a(f9, f7, fMin, f7), this.f1512b);
        if (fMin >= 1.0f) {
            canvas.drawLine(f8 - (fMin2 * 0.03f), f9, a.a(f10, f8, fMax, f8), a.a(f11, f9, fMax, f9), this.f1512b);
        }
    }
}
