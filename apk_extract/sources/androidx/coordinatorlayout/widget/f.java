package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.R$styleable;

/* loaded from: classes.dex */
public final class f extends ViewGroup.MarginLayoutParams {

    /* renamed from: a, reason: collision with root package name */
    public c f76a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f77b;

    /* renamed from: c, reason: collision with root package name */
    public final int f78c;

    /* renamed from: d, reason: collision with root package name */
    public int f79d;

    /* renamed from: e, reason: collision with root package name */
    public final int f80e;

    /* renamed from: f, reason: collision with root package name */
    public final int f81f;

    /* renamed from: g, reason: collision with root package name */
    public int f82g;

    /* renamed from: h, reason: collision with root package name */
    public int f83h;

    /* renamed from: i, reason: collision with root package name */
    public int f84i;

    /* renamed from: j, reason: collision with root package name */
    public int f85j;

    /* renamed from: k, reason: collision with root package name */
    public View f86k;

    /* renamed from: l, reason: collision with root package name */
    public View f87l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f88m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f89n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f90o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f91p;

    /* renamed from: q, reason: collision with root package name */
    public final Rect f92q;

    /* renamed from: r, reason: collision with root package name */
    public Object f93r;

    public f() {
        super(-2, -2);
        this.f77b = false;
        this.f78c = 0;
        this.f79d = 0;
        this.f80e = -1;
        this.f81f = -1;
        this.f82g = 0;
        this.f83h = 0;
        this.f92q = new Rect();
    }

    public final boolean a(int i2) {
        if (i2 == 0) {
            return this.f89n;
        }
        if (i2 != 1) {
            return false;
        }
        return this.f90o;
    }

    public final void b(c cVar) {
        c cVar2 = this.f76a;
        if (cVar2 != cVar) {
            if (cVar2 != null) {
                cVar2.onDetachedFromLayoutParams();
            }
            this.f76a = cVar;
            this.f93r = null;
            this.f77b = true;
            if (cVar != null) {
                cVar.onAttachedToLayoutParams(this);
            }
        }
    }

    public f(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f77b = false;
        this.f78c = 0;
        this.f79d = 0;
        this.f80e = -1;
        this.f81f = -1;
        this.f82g = 0;
        this.f83h = 0;
        this.f92q = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout_Layout);
        this.f78c = typedArrayObtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
        this.f81f = typedArrayObtainStyledAttributes.getResourceId(R$styleable.CoordinatorLayout_Layout_layout_anchor, -1);
        this.f79d = typedArrayObtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
        this.f80e = typedArrayObtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_keyline, -1);
        this.f82g = typedArrayObtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
        this.f83h = typedArrayObtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(R$styleable.CoordinatorLayout_Layout_layout_behavior);
        this.f77b = zHasValue;
        if (zHasValue) {
            this.f76a = CoordinatorLayout.parseBehavior(context, attributeSet, typedArrayObtainStyledAttributes.getString(R$styleable.CoordinatorLayout_Layout_layout_behavior));
        }
        typedArrayObtainStyledAttributes.recycle();
        c cVar = this.f76a;
        if (cVar != null) {
            cVar.onAttachedToLayoutParams(this);
        }
    }

    public f(f fVar) {
        super((ViewGroup.MarginLayoutParams) fVar);
        this.f77b = false;
        this.f78c = 0;
        this.f79d = 0;
        this.f80e = -1;
        this.f81f = -1;
        this.f82g = 0;
        this.f83h = 0;
        this.f92q = new Rect();
    }

    public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f77b = false;
        this.f78c = 0;
        this.f79d = 0;
        this.f80e = -1;
        this.f81f = -1;
        this.f82g = 0;
        this.f83h = 0;
        this.f92q = new Rect();
    }

    public f(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f77b = false;
        this.f78c = 0;
        this.f79d = 0;
        this.f80e = -1;
        this.f81f = -1;
        this.f82g = 0;
        this.f83h = 0;
        this.f92q = new Rect();
    }
}
