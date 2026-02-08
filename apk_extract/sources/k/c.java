package k;

import android.graphics.BlendMode;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public abstract class c {
    public static Object a(b bVar) {
        switch (bVar.ordinal()) {
            case 0:
                return BlendMode.CLEAR;
            case 1:
                return BlendMode.SRC;
            case 2:
                return BlendMode.DST;
            case 3:
                return BlendMode.SRC_OVER;
            case 4:
                return BlendMode.DST_OVER;
            case 5:
                return BlendMode.SRC_IN;
            case 6:
                return BlendMode.DST_IN;
            case 7:
                return BlendMode.SRC_OUT;
            case 8:
                return BlendMode.DST_OUT;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                return BlendMode.SRC_ATOP;
            case 10:
                return BlendMode.DST_ATOP;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                return BlendMode.XOR;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                return BlendMode.PLUS;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                return BlendMode.MODULATE;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                return BlendMode.SCREEN;
            case 15:
                return BlendMode.OVERLAY;
            case 16:
                return BlendMode.DARKEN;
            case 17:
                return BlendMode.LIGHTEN;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                return BlendMode.COLOR_DODGE;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                return BlendMode.COLOR_BURN;
            case 20:
                return BlendMode.HARD_LIGHT;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                return BlendMode.SOFT_LIGHT;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                return BlendMode.DIFFERENCE;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                return BlendMode.EXCLUSION;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                return BlendMode.MULTIPLY;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                return BlendMode.HUE;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                return BlendMode.SATURATION;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                return BlendMode.COLOR;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                return BlendMode.LUMINOSITY;
            default:
                return null;
        }
    }
}
