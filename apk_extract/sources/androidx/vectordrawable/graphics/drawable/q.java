package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.util.ArrayDeque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class q extends h {

    /* renamed from: j, reason: collision with root package name */
    public static final PorterDuff.Mode f1198j = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    public o f1199b;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuffColorFilter f1200c;

    /* renamed from: d, reason: collision with root package name */
    public ColorFilter f1201d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1202e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1203f;

    /* renamed from: g, reason: collision with root package name */
    public final float[] f1204g;

    /* renamed from: h, reason: collision with root package name */
    public final Matrix f1205h;

    /* renamed from: i, reason: collision with root package name */
    public final Rect f1206i;

    public q() {
        this.f1203f = true;
        this.f1204g = new float[9];
        this.f1205h = new Matrix();
        this.f1206i = new Rect();
        o oVar = new o();
        oVar.f1187c = null;
        oVar.f1188d = f1198j;
        oVar.f1186b = new n();
        this.f1199b = oVar;
    }

    public final PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        Drawable drawable = this.f1141a;
        if (drawable == null) {
            return false;
        }
        l.b.b(drawable);
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Paint paint;
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        Rect rect = this.f1206i;
        copyBounds(rect);
        if (rect.width() <= 0 || rect.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f1201d;
        if (colorFilter == null) {
            colorFilter = this.f1200c;
        }
        Matrix matrix = this.f1205h;
        canvas.getMatrix(matrix);
        float[] fArr = this.f1204g;
        matrix.getValues(fArr);
        float fAbs = Math.abs(fArr[0]);
        float fAbs2 = Math.abs(fArr[4]);
        float fAbs3 = Math.abs(fArr[1]);
        float fAbs4 = Math.abs(fArr[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iWidth = (int) (rect.width() * fAbs);
        int iMin = Math.min(2048, iWidth);
        int iMin2 = Math.min(2048, (int) (rect.height() * fAbs2));
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(rect.left, rect.top);
        if (isAutoMirrored() && l.c.a(this) == 1) {
            canvas.translate(rect.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        rect.offsetTo(0, 0);
        o oVar = this.f1199b;
        Bitmap bitmap = oVar.f1190f;
        if (bitmap == null || iMin != bitmap.getWidth() || iMin2 != oVar.f1190f.getHeight()) {
            oVar.f1190f = Bitmap.createBitmap(iMin, iMin2, Bitmap.Config.ARGB_8888);
            oVar.f1195k = true;
        }
        if (this.f1203f) {
            o oVar2 = this.f1199b;
            if (oVar2.f1195k || oVar2.f1191g != oVar2.f1187c || oVar2.f1192h != oVar2.f1188d || oVar2.f1194j != oVar2.f1189e || oVar2.f1193i != oVar2.f1186b.getRootAlpha()) {
                o oVar3 = this.f1199b;
                oVar3.f1190f.eraseColor(0);
                Canvas canvas2 = new Canvas(oVar3.f1190f);
                n nVar = oVar3.f1186b;
                nVar.a(nVar.f1176g, n.f1169p, canvas2, iMin, iMin2);
                o oVar4 = this.f1199b;
                oVar4.f1191g = oVar4.f1187c;
                oVar4.f1192h = oVar4.f1188d;
                oVar4.f1193i = oVar4.f1186b.getRootAlpha();
                oVar4.f1194j = oVar4.f1189e;
                oVar4.f1195k = false;
            }
        } else {
            o oVar5 = this.f1199b;
            oVar5.f1190f.eraseColor(0);
            Canvas canvas3 = new Canvas(oVar5.f1190f);
            n nVar2 = oVar5.f1186b;
            nVar2.a(nVar2.f1176g, n.f1169p, canvas3, iMin, iMin2);
        }
        o oVar6 = this.f1199b;
        if (oVar6.f1186b.getRootAlpha() >= 255 && colorFilter == null) {
            paint = null;
        } else {
            if (oVar6.f1196l == null) {
                Paint paint2 = new Paint();
                oVar6.f1196l = paint2;
                paint2.setFilterBitmap(true);
            }
            oVar6.f1196l.setAlpha(oVar6.f1186b.getRootAlpha());
            oVar6.f1196l.setColorFilter(colorFilter);
            paint = oVar6.f1196l;
        }
        canvas.drawBitmap(oVar6.f1190f, (Rect) null, rect, paint);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        Drawable drawable = this.f1141a;
        return drawable != null ? l.a.a(drawable) : this.f1199b.f1186b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return this.f1199b.getChangingConfigurations() | super.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        Drawable drawable = this.f1141a;
        return drawable != null ? l.b.c(drawable) : this.f1201d;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f1141a != null) {
            return new p(this.f1141a.getConstantState());
        }
        this.f1199b.f1185a = getChangingConfigurations();
        return this.f1199b;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        Drawable drawable = this.f1141a;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f1199b.f1186b.f1178i;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        Drawable drawable = this.f1141a;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f1199b.f1186b.f1177h;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        n nVar;
        int i2;
        int i3;
        boolean z2;
        int i4;
        boolean z3;
        Paint.Join join;
        Paint.Cap cap;
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            l.b.d(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        o oVar = this.f1199b;
        oVar.f1186b = new n();
        TypedArray typedArrayD0 = x0.g.d0(resources, theme, attributeSet, a.f1123a);
        o oVar2 = this.f1199b;
        n nVar2 = oVar2.f1186b;
        int i5 = !x0.g.T(xmlPullParser, "tintMode") ? -1 : typedArrayD0.getInt(6, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        int i6 = 3;
        if (i5 == 3) {
            mode = PorterDuff.Mode.SRC_OVER;
        } else if (i5 != 5) {
            if (i5 != 9) {
                switch (i5) {
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        mode = PorterDuff.Mode.MULTIPLY;
                        break;
                    case 15:
                        mode = PorterDuff.Mode.SCREEN;
                        break;
                    case 16:
                        mode = PorterDuff.Mode.ADD;
                        break;
                }
            } else {
                mode = PorterDuff.Mode.SRC_ATOP;
            }
        }
        oVar2.f1188d = mode;
        int i7 = 1;
        ColorStateList colorStateListA = null;
        boolean z4 = false;
        if (x0.g.T(xmlPullParser, "tint")) {
            TypedValue typedValue = new TypedValue();
            typedArrayD0.getValue(1, typedValue);
            int i8 = typedValue.type;
            if (i8 == 2) {
                throw new UnsupportedOperationException("Failed to resolve attribute at index 1: " + typedValue);
            }
            if (i8 < 28 || i8 > 31) {
                Resources resources2 = typedArrayD0.getResources();
                int resourceId = typedArrayD0.getResourceId(1, 0);
                ThreadLocal threadLocal = j.c.f1854a;
                try {
                    colorStateListA = j.c.a(resources2, resources2.getXml(resourceId), theme);
                } catch (Exception e2) {
                    Log.e("CSLCompat", "Failed to inflate ColorStateList.", e2);
                }
            } else {
                colorStateListA = ColorStateList.valueOf(typedValue.data);
            }
        }
        ColorStateList colorStateList = colorStateListA;
        if (colorStateList != null) {
            oVar2.f1187c = colorStateList;
        }
        boolean z5 = oVar2.f1189e;
        if (x0.g.T(xmlPullParser, "autoMirrored")) {
            z5 = typedArrayD0.getBoolean(5, z5);
        }
        oVar2.f1189e = z5;
        float f2 = nVar2.f1179j;
        if (x0.g.T(xmlPullParser, "viewportWidth")) {
            f2 = typedArrayD0.getFloat(7, f2);
        }
        nVar2.f1179j = f2;
        float f3 = nVar2.f1180k;
        if (x0.g.T(xmlPullParser, "viewportHeight")) {
            f3 = typedArrayD0.getFloat(8, f3);
        }
        nVar2.f1180k = f3;
        if (nVar2.f1179j <= 0.0f) {
            throw new XmlPullParserException(typedArrayD0.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f3 <= 0.0f) {
            throw new XmlPullParserException(typedArrayD0.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        nVar2.f1177h = typedArrayD0.getDimension(3, nVar2.f1177h);
        float dimension = typedArrayD0.getDimension(2, nVar2.f1178i);
        nVar2.f1178i = dimension;
        if (nVar2.f1177h <= 0.0f) {
            throw new XmlPullParserException(typedArrayD0.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(typedArrayD0.getPositionDescription() + "<vector> tag requires height > 0");
        }
        float alpha = nVar2.getAlpha();
        if (x0.g.T(xmlPullParser, "alpha")) {
            alpha = typedArrayD0.getFloat(4, alpha);
        }
        nVar2.setAlpha(alpha);
        String string = typedArrayD0.getString(0);
        if (string != null) {
            nVar2.f1182m = string;
            nVar2.f1184o.put(string, nVar2);
        }
        typedArrayD0.recycle();
        oVar.f1185a = getChangingConfigurations();
        oVar.f1195k = true;
        o oVar3 = this.f1199b;
        n nVar3 = oVar3.f1186b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(nVar3.f1176g);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z6 = true;
        while (eventType != i7 && (xmlPullParser.getDepth() >= depth || eventType != i6)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                k kVar = (k) arrayDeque.peek();
                boolean zEquals = "path".equals(name);
                i2 = depth;
                g.b bVar = nVar3.f1184o;
                if (zEquals) {
                    j jVar = new j();
                    jVar.f1143f = 0.0f;
                    jVar.f1145h = 1.0f;
                    jVar.f1146i = 1.0f;
                    jVar.f1147j = 0.0f;
                    jVar.f1148k = 1.0f;
                    jVar.f1149l = 0.0f;
                    Paint.Cap cap2 = Paint.Cap.BUTT;
                    jVar.f1150m = cap2;
                    Paint.Join join2 = Paint.Join.MITER;
                    jVar.f1151n = join2;
                    nVar = nVar3;
                    jVar.f1152o = 4.0f;
                    TypedArray typedArrayD02 = x0.g.d0(resources, theme, attributeSet, a.f1125c);
                    if (x0.g.T(xmlPullParser, "pathData")) {
                        String string2 = typedArrayD02.getString(0);
                        if (string2 != null) {
                            jVar.f1166b = string2;
                        }
                        String string3 = typedArrayD02.getString(2);
                        if (string3 != null) {
                            jVar.f1165a = x0.g.F(string3);
                        }
                        jVar.f1144g = x0.g.P(typedArrayD02, xmlPullParser, theme, "fillColor", 1);
                        float f4 = jVar.f1146i;
                        if (x0.g.T(xmlPullParser, "fillAlpha")) {
                            f4 = typedArrayD02.getFloat(12, f4);
                        }
                        jVar.f1146i = f4;
                        int i9 = !x0.g.T(xmlPullParser, "strokeLineCap") ? -1 : typedArrayD02.getInt(8, -1);
                        Paint.Cap cap3 = jVar.f1150m;
                        if (i9 != 0) {
                            join = join2;
                            cap = i9 != 1 ? i9 != 2 ? cap3 : Paint.Cap.SQUARE : Paint.Cap.ROUND;
                        } else {
                            join = join2;
                            cap = cap2;
                        }
                        jVar.f1150m = cap;
                        int i10 = !x0.g.T(xmlPullParser, "strokeLineJoin") ? -1 : typedArrayD02.getInt(9, -1);
                        jVar.f1151n = i10 != 0 ? i10 != 1 ? i10 != 2 ? jVar.f1151n : Paint.Join.BEVEL : Paint.Join.ROUND : join;
                        float f5 = jVar.f1152o;
                        if (x0.g.T(xmlPullParser, "strokeMiterLimit")) {
                            f5 = typedArrayD02.getFloat(10, f5);
                        }
                        jVar.f1152o = f5;
                        jVar.f1142e = x0.g.P(typedArrayD02, xmlPullParser, theme, "strokeColor", 3);
                        float f6 = jVar.f1145h;
                        if (x0.g.T(xmlPullParser, "strokeAlpha")) {
                            f6 = typedArrayD02.getFloat(11, f6);
                        }
                        jVar.f1145h = f6;
                        float f7 = jVar.f1143f;
                        if (x0.g.T(xmlPullParser, "strokeWidth")) {
                            f7 = typedArrayD02.getFloat(4, f7);
                        }
                        jVar.f1143f = f7;
                        float f8 = jVar.f1148k;
                        if (x0.g.T(xmlPullParser, "trimPathEnd")) {
                            f8 = typedArrayD02.getFloat(6, f8);
                        }
                        jVar.f1148k = f8;
                        float f9 = jVar.f1149l;
                        if (x0.g.T(xmlPullParser, "trimPathOffset")) {
                            f9 = typedArrayD02.getFloat(7, f9);
                        }
                        jVar.f1149l = f9;
                        float f10 = jVar.f1147j;
                        if (x0.g.T(xmlPullParser, "trimPathStart")) {
                            f10 = typedArrayD02.getFloat(5, f10);
                        }
                        jVar.f1147j = f10;
                        int i11 = jVar.f1167c;
                        if (x0.g.T(xmlPullParser, "fillType")) {
                            i11 = typedArrayD02.getInt(13, i11);
                        }
                        jVar.f1167c = i11;
                    }
                    typedArrayD02.recycle();
                    kVar.f1154b.add(jVar);
                    if (jVar.getPathName() != null) {
                        bVar.put(jVar.getPathName(), jVar);
                    }
                    oVar3.f1185a |= jVar.f1168d;
                    z3 = false;
                    i3 = 1;
                    z6 = false;
                } else {
                    nVar = nVar3;
                    if ("clip-path".equals(name)) {
                        i iVar = new i();
                        if (x0.g.T(xmlPullParser, "pathData")) {
                            TypedArray typedArrayD03 = x0.g.d0(resources, theme, attributeSet, a.f1126d);
                            String string4 = typedArrayD03.getString(0);
                            if (string4 != null) {
                                iVar.f1166b = string4;
                            }
                            String string5 = typedArrayD03.getString(1);
                            if (string5 != null) {
                                iVar.f1165a = x0.g.F(string5);
                            }
                            iVar.f1167c = !x0.g.T(xmlPullParser, "fillType") ? 0 : typedArrayD03.getInt(2, 0);
                            typedArrayD03.recycle();
                        }
                        kVar.f1154b.add(iVar);
                        if (iVar.getPathName() != null) {
                            bVar.put(iVar.getPathName(), iVar);
                        }
                        oVar3.f1185a = iVar.f1168d | oVar3.f1185a;
                    } else if ("group".equals(name)) {
                        k kVar2 = new k();
                        TypedArray typedArrayD04 = x0.g.d0(resources, theme, attributeSet, a.f1124b);
                        float f11 = kVar2.f1155c;
                        if (x0.g.T(xmlPullParser, "rotation")) {
                            f11 = typedArrayD04.getFloat(5, f11);
                        }
                        kVar2.f1155c = f11;
                        i3 = 1;
                        kVar2.f1156d = typedArrayD04.getFloat(1, kVar2.f1156d);
                        kVar2.f1157e = typedArrayD04.getFloat(2, kVar2.f1157e);
                        float f12 = kVar2.f1158f;
                        if (x0.g.T(xmlPullParser, "scaleX")) {
                            f12 = typedArrayD04.getFloat(3, f12);
                        }
                        kVar2.f1158f = f12;
                        float f13 = kVar2.f1159g;
                        if (x0.g.T(xmlPullParser, "scaleY")) {
                            f13 = typedArrayD04.getFloat(4, f13);
                        }
                        kVar2.f1159g = f13;
                        float f14 = kVar2.f1160h;
                        if (x0.g.T(xmlPullParser, "translateX")) {
                            f14 = typedArrayD04.getFloat(6, f14);
                        }
                        kVar2.f1160h = f14;
                        float f15 = kVar2.f1161i;
                        if (x0.g.T(xmlPullParser, "translateY")) {
                            f15 = typedArrayD04.getFloat(7, f15);
                        }
                        kVar2.f1161i = f15;
                        z3 = false;
                        String string6 = typedArrayD04.getString(0);
                        if (string6 != null) {
                            kVar2.f1164l = string6;
                        }
                        kVar2.c();
                        typedArrayD04.recycle();
                        kVar.f1154b.add(kVar2);
                        arrayDeque.push(kVar2);
                        if (kVar2.getGroupName() != null) {
                            bVar.put(kVar2.getGroupName(), kVar2);
                        }
                        oVar3.f1185a = kVar2.f1163k | oVar3.f1185a;
                    }
                    z3 = false;
                    i3 = 1;
                }
                z2 = z3;
                i4 = 3;
            } else {
                nVar = nVar3;
                i2 = depth;
                i3 = i7;
                z2 = z4;
                i4 = 3;
                if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                    arrayDeque.pop();
                }
            }
            eventType = xmlPullParser.next();
            i6 = i4;
            z4 = z2;
            i7 = i3;
            depth = i2;
            nVar3 = nVar;
        }
        if (z6) {
            throw new XmlPullParserException("no path defined");
        }
        this.f1200c = a(oVar.f1187c, oVar.f1188d);
    }

    @Override // android.graphics.drawable.Drawable
    public final void invalidateSelf() {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        Drawable drawable = this.f1141a;
        return drawable != null ? l.a.d(drawable) : this.f1199b.f1189e;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (!super.isStateful()) {
            o oVar = this.f1199b;
            if (oVar != null) {
                n nVar = oVar.f1186b;
                if (nVar.f1183n == null) {
                    nVar.f1183n = Boolean.valueOf(nVar.f1176g.a());
                }
                if (nVar.f1183n.booleanValue() || ((colorStateList = this.f1199b.f1187c) != null && colorStateList.isStateful())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f1202e && super.mutate() == this) {
            o oVar = this.f1199b;
            o oVar2 = new o();
            oVar2.f1187c = null;
            oVar2.f1188d = f1198j;
            if (oVar != null) {
                oVar2.f1185a = oVar.f1185a;
                n nVar = new n(oVar.f1186b);
                oVar2.f1186b = nVar;
                if (oVar.f1186b.f1174e != null) {
                    nVar.f1174e = new Paint(oVar.f1186b.f1174e);
                }
                if (oVar.f1186b.f1173d != null) {
                    oVar2.f1186b.f1173d = new Paint(oVar.f1186b.f1173d);
                }
                oVar2.f1187c = oVar.f1187c;
                oVar2.f1188d = oVar.f1188d;
                oVar2.f1189e = oVar.f1189e;
            }
            this.f1199b = oVar2;
            this.f1202e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean z2;
        PorterDuff.Mode mode;
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        o oVar = this.f1199b;
        ColorStateList colorStateList = oVar.f1187c;
        if (colorStateList == null || (mode = oVar.f1188d) == null) {
            z2 = false;
        } else {
            this.f1200c = a(colorStateList, mode);
            invalidateSelf();
            z2 = true;
        }
        n nVar = oVar.f1186b;
        if (nVar.f1183n == null) {
            nVar.f1183n = Boolean.valueOf(nVar.f1176g.a());
        }
        if (nVar.f1183n.booleanValue()) {
            boolean zB = oVar.f1186b.f1176g.b(iArr);
            oVar.f1195k |= zB;
            if (zB) {
                invalidateSelf();
                return true;
            }
        }
        return z2;
    }

    @Override // android.graphics.drawable.Drawable
    public final void scheduleSelf(Runnable runnable, long j2) {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.f1199b.f1186b.getRootAlpha() != i2) {
            this.f1199b.f1186b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z2) {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            l.a.e(drawable, z2);
        } else {
            this.f1199b.f1189e = z2;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f1201d = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i2) {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            x0.g.v0(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            l.b.h(drawable, colorStateList);
            return;
        }
        o oVar = this.f1199b;
        if (oVar.f1187c != colorStateList) {
            oVar.f1187c = colorStateList;
            this.f1200c = a(colorStateList, oVar.f1188d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            l.b.i(drawable, mode);
            return;
        }
        o oVar = this.f1199b;
        if (oVar.f1188d != mode) {
            oVar.f1188d = mode;
            this.f1200c = a(oVar.f1187c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z2, boolean z3) {
        Drawable drawable = this.f1141a;
        return drawable != null ? drawable.setVisible(z2, z3) : super.setVisible(z2, z3);
    }

    @Override // android.graphics.drawable.Drawable
    public final void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    public q(o oVar) {
        this.f1203f = true;
        this.f1204g = new float[9];
        this.f1205h = new Matrix();
        this.f1206i = new Rect();
        this.f1199b = oVar;
        this.f1200c = a(oVar.f1187c, oVar.f1188d);
    }

    @Override // android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f1141a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }
}
