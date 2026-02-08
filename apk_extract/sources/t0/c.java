package t0;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.chamsion.quickchat.R;

/* loaded from: classes.dex */
public final class c extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    public final Bitmap f2554a;

    /* renamed from: b, reason: collision with root package name */
    public final RectF f2555b;

    /* renamed from: c, reason: collision with root package name */
    public final float f2556c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2557d;

    /* renamed from: e, reason: collision with root package name */
    public final Rect f2558e;

    public c(Bitmap bitmap, int i2) {
        this.f2557d = i2;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_8888);
        this.f2554a = bitmapCreateBitmap;
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int iMin = Math.min(width, height);
        Rect rect = new Rect((width - iMin) / 2, (height - iMin) / 2, iMin, iMin);
        float f2 = i2;
        RectF rectF = new RectF(0.0f, 0.0f, f2, f2);
        Path path = new Path();
        path.addArc(rectF, 0.0f, 360.0f);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-16777216);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rectF, paint);
        paint.setXfermode(null);
        this.f2556c = 1.0f;
        this.f2558e = new Rect(0, 0, i2, i2);
        this.f2555b = new RectF(0.0f, 0.0f, f2, f2);
    }

    public static c a(Context context, Bitmap bitmap) {
        return new c(bitmap, (int) context.getResources().getDimension(R.dimen.interphone_circle_view_size));
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        float f2 = this.f2557d;
        float f3 = (f2 - (this.f2556c * f2)) / 2.0f;
        RectF rectF = this.f2555b;
        float f4 = f2 - f3;
        rectF.set(f3, f3, f4, f4);
        canvas.drawBitmap(this.f2554a, this.f2558e, rectF, (Paint) null);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.f2557d;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.f2557d;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
