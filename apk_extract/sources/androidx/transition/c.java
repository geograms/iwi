package androidx.transition;

import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import androidx.core.view.d1;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class c extends Property {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1052a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Class cls, String str, int i2) {
        super(cls, str);
        this.f1052a = i2;
    }

    public final void a(View view, PointF pointF) {
        switch (this.f1052a) {
            case 2:
                int left = view.getLeft();
                int top = view.getTop();
                int iRound = Math.round(pointF.x);
                int iRound2 = Math.round(pointF.y);
                c cVar = e0.f1062a;
                view.setLeftTopRightBottom(left, top, iRound, iRound2);
                break;
            case 3:
                int iRound3 = Math.round(pointF.x);
                int iRound4 = Math.round(pointF.y);
                int right = view.getRight();
                int bottom = view.getBottom();
                c cVar2 = e0.f1062a;
                view.setLeftTopRightBottom(iRound3, iRound4, right, bottom);
                break;
            default:
                int iRound5 = Math.round(pointF.x);
                int iRound6 = Math.round(pointF.y);
                int width = view.getWidth() + iRound5;
                int height = view.getHeight() + iRound6;
                c cVar3 = e0.f1062a;
                view.setLeftTopRightBottom(iRound5, iRound6, width, height);
                break;
        }
    }

    public final void b(f fVar, PointF pointF) {
        switch (this.f1052a) {
            case 0:
                fVar.getClass();
                fVar.f1063a = Math.round(pointF.x);
                int iRound = Math.round(pointF.y);
                fVar.f1064b = iRound;
                int i2 = fVar.f1068f + 1;
                fVar.f1068f = i2;
                if (i2 == fVar.f1069g) {
                    int i3 = fVar.f1063a;
                    int i4 = fVar.f1065c;
                    int i5 = fVar.f1066d;
                    View view = fVar.f1067e;
                    c cVar = e0.f1062a;
                    view.setLeftTopRightBottom(i3, iRound, i4, i5);
                    fVar.f1068f = 0;
                    fVar.f1069g = 0;
                    break;
                }
                break;
            default:
                fVar.getClass();
                fVar.f1065c = Math.round(pointF.x);
                int iRound2 = Math.round(pointF.y);
                fVar.f1066d = iRound2;
                int i6 = fVar.f1069g + 1;
                fVar.f1069g = i6;
                if (fVar.f1068f == i6) {
                    int i7 = fVar.f1063a;
                    int i8 = fVar.f1064b;
                    int i9 = fVar.f1065c;
                    View view2 = fVar.f1067e;
                    c cVar2 = e0.f1062a;
                    view2.setLeftTopRightBottom(i7, i8, i9, iRound2);
                    fVar.f1068f = 0;
                    fVar.f1069g = 0;
                    break;
                }
                break;
        }
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        switch (this.f1052a) {
            case 0:
                return null;
            case 1:
                return null;
            case 2:
                return null;
            case 3:
                return null;
            case 4:
                return null;
            case 5:
                c cVar = e0.f1062a;
                return Float.valueOf(((View) obj).getTransitionAlpha());
            default:
                WeakHashMap weakHashMap = d1.f138a;
                return androidx.core.view.o0.a((View) obj);
        }
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        switch (this.f1052a) {
            case 0:
                b((f) obj, (PointF) obj2);
                break;
            case 1:
                b((f) obj, (PointF) obj2);
                break;
            case 2:
                a((View) obj, (PointF) obj2);
                break;
            case 3:
                a((View) obj, (PointF) obj2);
                break;
            case 4:
                a((View) obj, (PointF) obj2);
                break;
            case 5:
                float fFloatValue = ((Float) obj2).floatValue();
                c cVar = e0.f1062a;
                ((View) obj).setTransitionAlpha(fFloatValue);
                break;
            default:
                WeakHashMap weakHashMap = d1.f138a;
                androidx.core.view.o0.c((View) obj, (Rect) obj2);
                break;
        }
    }
}
