package androidx.dynamicanimation.animation;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public final class e extends h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f326a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String str, int i2) {
        super(str);
        this.f326a = i2;
    }

    public final float a(View view) {
        switch (this.f326a) {
            case 2:
                return view.getAlpha();
            case 8:
                return view.getScaleX();
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                return view.getScaleY();
            case 10:
                return view.getRotation();
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                return view.getRotationX();
            default:
                return view.getRotationY();
        }
    }

    public final void b(View view, float f2) {
        switch (this.f326a) {
            case 2:
                view.setAlpha(f2);
                break;
            case 8:
                view.setScaleX(f2);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                view.setScaleY(f2);
                break;
            case 10:
                view.setRotation(f2);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                view.setRotationX(f2);
                break;
            default:
                view.setRotationY(f2);
                break;
        }
    }

    @Override // androidx.dynamicanimation.animation.j
    public final /* bridge */ /* synthetic */ float getValue(Object obj) {
        switch (this.f326a) {
            case 2:
                break;
            case 8:
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                break;
            case 10:
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                break;
        }
        return a((View) obj);
    }

    @Override // androidx.dynamicanimation.animation.j
    public final /* bridge */ /* synthetic */ void setValue(Object obj, float f2) {
        switch (this.f326a) {
            case 2:
                b((View) obj, f2);
                break;
            case 8:
                b((View) obj, f2);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                b((View) obj, f2);
                break;
            case 10:
                b((View) obj, f2);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                b((View) obj, f2);
                break;
            default:
                b((View) obj, f2);
                break;
        }
    }
}
