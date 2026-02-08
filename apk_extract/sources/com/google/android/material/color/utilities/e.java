package com.google.android.material.color.utilities;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.function.Function;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1554a;

    public /* synthetic */ e(int i2) {
        this.f1554a = i2;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.f1554a) {
            case 0:
                return DynamicColor.lambda$toneMinContrastDefault$16((Double) obj);
            case 1:
                return MaterialDynamicColors.lambda$static$141((DynamicScheme) obj);
            case 2:
                return MaterialDynamicColors.lambda$static$139((DynamicScheme) obj);
            case 3:
                return ((DynamicScheme) obj).neutralPalette;
            case 4:
                return MaterialDynamicColors.highestSurface((DynamicScheme) obj);
            case 5:
                return ((DynamicScheme) obj).primaryPalette;
            case 6:
                return MaterialDynamicColors.lambda$static$102((DynamicScheme) obj);
            case 7:
                return MaterialDynamicColors.lambda$static$103((DynamicScheme) obj);
            case 8:
                return ((DynamicScheme) obj).primaryPalette;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                return MaterialDynamicColors.lambda$static$105((DynamicScheme) obj);
            case 10:
                return MaterialDynamicColors.lambda$static$106((DynamicScheme) obj);
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                return ((DynamicScheme) obj).secondaryPalette;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                return MaterialDynamicColors.lambda$static$108((DynamicScheme) obj);
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                return MaterialDynamicColors.highestSurface((DynamicScheme) obj);
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                return MaterialDynamicColors.lambda$static$10((DynamicScheme) obj);
            case 15:
                return ((DynamicScheme) obj).secondaryPalette;
            case 16:
                return MaterialDynamicColors.lambda$static$111((DynamicScheme) obj);
            case 17:
                return MaterialDynamicColors.highestSurface((DynamicScheme) obj);
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                return ((DynamicScheme) obj).secondaryPalette;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                return MaterialDynamicColors.lambda$static$114((DynamicScheme) obj);
            case 20:
                return MaterialDynamicColors.lambda$static$115((DynamicScheme) obj);
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                return ((DynamicScheme) obj).secondaryPalette;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                return MaterialDynamicColors.lambda$static$117((DynamicScheme) obj);
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                return MaterialDynamicColors.lambda$static$118((DynamicScheme) obj);
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                return ((DynamicScheme) obj).tertiaryPalette;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                return ((DynamicScheme) obj).neutralPalette;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                return MaterialDynamicColors.lambda$static$120((DynamicScheme) obj);
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                return MaterialDynamicColors.highestSurface((DynamicScheme) obj);
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                return ((DynamicScheme) obj).tertiaryPalette;
            default:
                return MaterialDynamicColors.lambda$static$123((DynamicScheme) obj);
        }
    }
}
