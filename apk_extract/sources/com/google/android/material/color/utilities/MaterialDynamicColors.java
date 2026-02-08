package com.google.android.material.color.utilities;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.function.Function;

/* loaded from: classes.dex */
public final class MaterialDynamicColors {
    private static final double CONTAINER_ACCENT_TONE_DELTA = 15.0d;
    public static final DynamicColor background;
    public static final DynamicColor controlActivated;
    public static final DynamicColor controlHighlight;
    public static final DynamicColor controlNormal;
    public static final DynamicColor error;
    public static final DynamicColor errorContainer;
    public static final DynamicColor onBackground;
    public static final DynamicColor onError;
    public static final DynamicColor onErrorContainer;
    public static final DynamicColor onPrimary;
    public static final DynamicColor onPrimaryContainer;
    public static final DynamicColor onPrimaryFixed;
    public static final DynamicColor onPrimaryFixedVariant;
    public static final DynamicColor onSecondary;
    public static final DynamicColor onSecondaryContainer;
    public static final DynamicColor onSecondaryFixed;
    public static final DynamicColor onSecondaryFixedVariant;
    public static final DynamicColor onSurface;
    public static final DynamicColor onSurfaceInverse;
    public static final DynamicColor onSurfaceVariant;
    public static final DynamicColor onTertiary;
    public static final DynamicColor onTertiaryContainer;
    public static final DynamicColor onTertiaryFixed;
    public static final DynamicColor onTertiaryFixedVariant;
    public static final DynamicColor outline;
    public static final DynamicColor outlineVariant;
    public static final DynamicColor primary;
    public static final DynamicColor primaryContainer;
    public static final DynamicColor primaryFixed;
    public static final DynamicColor primaryFixedDarker;
    public static final DynamicColor primaryInverse;
    public static final DynamicColor secondary;
    public static final DynamicColor secondaryContainer;
    public static final DynamicColor secondaryFixed;
    public static final DynamicColor secondaryFixedDarker;
    public static final DynamicColor surface;
    public static final DynamicColor surfaceAdd1;
    public static final DynamicColor surfaceAdd2;
    public static final DynamicColor surfaceBright;
    public static final DynamicColor surfaceContainer;
    public static final DynamicColor surfaceDim;
    public static final DynamicColor surfaceInverse;
    public static final DynamicColor surfaceSub1;
    public static final DynamicColor surfaceSub2;
    public static final DynamicColor surfaceVariant;
    public static final DynamicColor tertiary;
    public static final DynamicColor tertiaryContainer;
    public static final DynamicColor tertiaryFixed;
    public static final DynamicColor tertiaryFixedDarker;
    public static final DynamicColor textHintInverse;
    public static final DynamicColor textPrimaryInverse;
    public static final DynamicColor textPrimaryInverseDisableOnly;
    public static final DynamicColor textSecondaryAndTertiaryInverse;
    public static final DynamicColor textSecondaryAndTertiaryInverseDisabled;

    static {
        final int i2 = 3;
        final int i3 = 5;
        background = DynamicColor.fromPalette(new e(i2), new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i3) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        });
        final int i4 = 16;
        final int i5 = 27;
        final int i6 = 8;
        onBackground = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i4) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i5) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i6) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        });
        final int i7 = 19;
        final int i8 = 0;
        surface = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i7) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i8) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        });
        final int i9 = 11;
        final int i10 = 22;
        surfaceInverse = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i9) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i10) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        });
        final int i11 = 14;
        surfaceBright = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.o
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i2) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$99(dynamicScheme);
                    default:
                        return dynamicScheme.neutralPalette;
                }
            }
        }, new e(i11));
        final int i12 = 25;
        final int i13 = 6;
        surfaceDim = DynamicColor.fromPalette(new e(i12), new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i13) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        });
        final int i14 = 17;
        final int i15 = 28;
        surfaceSub2 = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i14) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i15) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        });
        final int i16 = 1;
        surfaceSub1 = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i8) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i16) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        });
        final int i17 = 2;
        surfaceContainer = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i17) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i2) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        });
        final int i18 = 4;
        surfaceAdd1 = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i18) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i13) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        });
        final int i19 = 7;
        surfaceAdd2 = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i19) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i6) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        });
        final int i20 = 9;
        Function function = new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i20) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        };
        final int i21 = 10;
        onSurface = DynamicColor.fromPalette(function, new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i21) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i9) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        });
        final int i22 = 12;
        Function function2 = new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i22) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        };
        final int i23 = 13;
        onSurfaceInverse = DynamicColor.fromPalette(function2, new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i23) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i11) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        });
        final int i24 = 15;
        surfaceVariant = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i24) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i14) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        });
        final int i25 = 18;
        Function function3 = new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i25) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        };
        Function function4 = new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i7) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        };
        final int i26 = 20;
        onSurfaceVariant = DynamicColor.fromPalette(function3, function4, new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i26) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        });
        final int i27 = 21;
        final int i28 = 23;
        outline = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i27) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i10) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i28) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        });
        final int i29 = 24;
        final int i30 = 26;
        outlineVariant = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i29) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i12) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i30) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        });
        final int i31 = 29;
        primaryContainer = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i15) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.l
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i31) {
                    case 0:
                        return dynamicScheme.neutralPalette;
                    case 1:
                        return MaterialDynamicColors.lambda$static$16(dynamicScheme);
                    case 2:
                        return dynamicScheme.neutralPalette;
                    case 3:
                        return MaterialDynamicColors.lambda$static$18(dynamicScheme);
                    case 4:
                        return dynamicScheme.neutralPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$1(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$20(dynamicScheme);
                    case 7:
                        return dynamicScheme.neutralPalette;
                    case 8:
                        return MaterialDynamicColors.lambda$static$22(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.neutralPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$24(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$27(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$28(dynamicScheme);
                    case 15:
                        return dynamicScheme.neutralVariantPalette;
                    case 16:
                        return dynamicScheme.neutralPalette;
                    case 17:
                        return MaterialDynamicColors.lambda$static$30(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$32(dynamicScheme);
                    case 20:
                        return MaterialDynamicColors.lambda$static$33(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$35(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$38(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$3(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$41(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i8) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        });
        onPrimaryContainer = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i16) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i17) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i2) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        }, null);
        final int i32 = 5;
        final int i33 = 7;
        primary = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i18) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i32) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i13) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i33) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        });
        final int i34 = 9;
        final int i35 = 10;
        primaryInverse = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i34) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i35) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i9) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        });
        final int i36 = 12;
        final int i37 = 13;
        onPrimary = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i36) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i37) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i11) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        });
        final int i38 = 15;
        final int i39 = 16;
        secondaryContainer = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i38) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i39) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i14) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        });
        final int i40 = 18;
        final int i41 = 20;
        final int i42 = 21;
        onSecondaryContainer = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i40) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i41) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i42) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        });
        final int i43 = 23;
        final int i44 = 24;
        secondary = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i10) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i43) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i44) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i12) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        });
        final int i45 = 26;
        final int i46 = 27;
        onSecondary = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i45) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i46) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i15) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        });
        final int i47 = 29;
        tertiaryContainer = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.m
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i47) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$44(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$45(dynamicScheme);
                    case 4:
                        return dynamicScheme.primaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$47(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$49(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.lambda$static$4(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return dynamicScheme.primaryPalette;
                    case 10:
                        return MaterialDynamicColors.lambda$static$51(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$52(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$54(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$55(dynamicScheme);
                    case 15:
                        return dynamicScheme.secondaryPalette;
                    case 16:
                        return MaterialDynamicColors.lambda$static$57(dynamicScheme);
                    case 17:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$60(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$61(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.lambda$static$63(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return MaterialDynamicColors.lambda$static$65(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return dynamicScheme.secondaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$67(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$68(dynamicScheme);
                    default:
                        return dynamicScheme.tertiaryPalette;
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i16) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i17) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        });
        final int i48 = 5;
        onTertiaryContainer = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i2) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i18) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i48) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        });
        final int i49 = 7;
        final int i50 = 8;
        final int i51 = 9;
        tertiary = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i13) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i49) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i50) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i51) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        });
        final int i52 = 10;
        final int i53 = 12;
        final int i54 = 13;
        onTertiary = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i52) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i53) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i54) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        });
        final int i55 = 15;
        final int i56 = 16;
        errorContainer = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i11) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i55) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i56) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        });
        final int i57 = 18;
        final int i58 = 19;
        onErrorContainer = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i14) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i57) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i58) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        });
        final int i59 = 20;
        final int i60 = 21;
        final int i61 = 23;
        final int i62 = 24;
        error = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i59) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i60) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i61) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i62) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        });
        final int i63 = 26;
        final int i64 = 27;
        onError = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i12) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i63) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i64) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        });
        final int i65 = 29;
        final int i66 = 0;
        primaryFixed = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i15) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.n
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i65) {
                    case 0:
                        return MaterialDynamicColors.lambda$static$6(dynamicScheme);
                    case 1:
                        return MaterialDynamicColors.lambda$static$70(dynamicScheme);
                    case 2:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 3:
                        return dynamicScheme.tertiaryPalette;
                    case 4:
                        return MaterialDynamicColors.lambda$static$73(dynamicScheme);
                    case 5:
                        return MaterialDynamicColors.lambda$static$74(dynamicScheme);
                    case 6:
                        return dynamicScheme.tertiaryPalette;
                    case 7:
                        return MaterialDynamicColors.lambda$static$76(dynamicScheme);
                    case 8:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$78(dynamicScheme);
                    case 10:
                        return dynamicScheme.tertiaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$80(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$81(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return dynamicScheme.errorPalette;
                    case 15:
                        return MaterialDynamicColors.lambda$static$83(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 17:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$86(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return MaterialDynamicColors.lambda$static$87(dynamicScheme);
                    case 20:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return MaterialDynamicColors.lambda$static$89(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$8(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$91(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.errorPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$93(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return MaterialDynamicColors.lambda$static$94(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return dynamicScheme.primaryPalette;
                    default:
                        return MaterialDynamicColors.lambda$static$96(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.o
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i66) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$99(dynamicScheme);
                    default:
                        return dynamicScheme.neutralPalette;
                }
            }
        });
        primaryFixedDarker = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.o
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i16) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$99(dynamicScheme);
                    default:
                        return dynamicScheme.neutralPalette;
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.o
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i17) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.primaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$99(dynamicScheme);
                    default:
                        return dynamicScheme.neutralPalette;
                }
            }
        }, new e(i18));
        onPrimaryFixed = DynamicColor.fromPalette(new e(5), new e(i13), new e(7));
        onPrimaryFixedVariant = DynamicColor.fromPalette(new e(8), new e(9), new e(10));
        secondaryFixed = DynamicColor.fromPalette(new e(i9), new e(12), new e(13));
        secondaryFixedDarker = DynamicColor.fromPalette(new e(15), new e(16), new e(i14));
        onSecondaryFixed = DynamicColor.fromPalette(new e(18), new e(19), new e(20));
        onSecondaryFixedVariant = DynamicColor.fromPalette(new e(21), new e(i10), new e(23));
        tertiaryFixed = DynamicColor.fromPalette(new e(24), new e(26), new e(27));
        final int i67 = 0;
        tertiaryFixedDarker = DynamicColor.fromPalette(new e(i15), new e(29), new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i67) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        });
        onTertiaryFixed = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i16) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i17) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i2) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        });
        Function function5 = new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i18) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        };
        final int i68 = 5;
        final int i69 = 7;
        onTertiaryFixedVariant = DynamicColor.fromPalette(function5, new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i68) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i69) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        });
        final int i70 = 8;
        final int i71 = 9;
        controlActivated = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i70) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i71) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        }, null);
        final int i72 = 10;
        controlNormal = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i72) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i9) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        });
        final int i73 = 12;
        final int i74 = 13;
        final int i75 = 15;
        final int i76 = 16;
        final int i77 = 18;
        controlHighlight = new DynamicColor(new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i73) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i74) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i11) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i75) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        }, null, new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i76) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i77) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        }, null);
        final int i78 = 19;
        final int i79 = 20;
        textPrimaryInverse = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i78) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i79) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        });
        final int i80 = 21;
        textSecondaryAndTertiaryInverse = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i80) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i10) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        });
        final int i81 = 23;
        final int i82 = 24;
        textPrimaryInverseDisableOnly = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i81) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i82) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        });
        final int i83 = 26;
        textSecondaryAndTertiaryInverseDisabled = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i12) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i83) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        });
        final int i84 = 27;
        final int i85 = 29;
        textHintInverse = DynamicColor.fromPalette(new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i84) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.k
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i85) {
                    case 0:
                        return MaterialDynamicColors.highestSurface(dynamicScheme);
                    case 1:
                        return dynamicScheme.tertiaryPalette;
                    case 2:
                        return MaterialDynamicColors.lambda$static$126(dynamicScheme);
                    case 3:
                        return MaterialDynamicColors.lambda$static$127(dynamicScheme);
                    case 4:
                        return dynamicScheme.tertiaryPalette;
                    case 5:
                        return MaterialDynamicColors.lambda$static$129(dynamicScheme);
                    case 6:
                        return MaterialDynamicColors.lambda$static$12(dynamicScheme);
                    case 7:
                        return MaterialDynamicColors.lambda$static$130(dynamicScheme);
                    case 8:
                        return dynamicScheme.primaryPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                        return MaterialDynamicColors.lambda$static$132(dynamicScheme);
                    case 10:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                        return MaterialDynamicColors.lambda$static$134(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                        return MaterialDynamicColors.lambda$static$135(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                        return MaterialDynamicColors.lambda$static$136(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                        return MaterialDynamicColors.lambda$static$137(dynamicScheme);
                    case 15:
                        return MaterialDynamicColors.lambda$static$138(dynamicScheme);
                    case 16:
                        return MaterialDynamicColors.lambda$static$140(dynamicScheme);
                    case 17:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_START_TO_START_OF /* 18 */:
                        return MaterialDynamicColors.lambda$static$142(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_END_TO_START_OF /* 19 */:
                        return dynamicScheme.neutralPalette;
                    case 20:
                        return MaterialDynamicColors.lambda$static$144(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_LEFT /* 21 */:
                        return dynamicScheme.neutralVariantPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_TOP /* 22 */:
                        return MaterialDynamicColors.lambda$static$146(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_RIGHT /* 23 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_BOTTOM /* 24 */:
                        return MaterialDynamicColors.lambda$static$148(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_START /* 25 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_GONE_MARGIN_END /* 26 */:
                        return MaterialDynamicColors.lambda$static$150(dynamicScheme);
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_WIDTH /* 27 */:
                        return dynamicScheme.neutralPalette;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINED_HEIGHT /* 28 */:
                        return MaterialDynamicColors.lambda$static$14(dynamicScheme);
                    default:
                        return MaterialDynamicColors.lambda$static$152(dynamicScheme);
                }
            }
        });
    }

    private MaterialDynamicColors() {
    }

    public static double findDesiredChromaByTone(double d2, double d3, double d4, boolean z2) {
        Hct hctFrom = Hct.from(d2, d3, d4);
        if (hctFrom.getChroma() >= d3) {
            return d4;
        }
        Hct hct = hctFrom;
        double chroma = hctFrom.getChroma();
        double d5 = d4;
        while (hct.getChroma() < d3) {
            double d6 = d5 + (z2 ? -1.0d : 1.0d);
            Hct hctFrom2 = Hct.from(d2, d3, d6);
            if (chroma > hctFrom2.getChroma() || Math.abs(hctFrom2.getChroma() - d3) < 0.4d) {
                return d6;
            }
            if (Math.abs(hctFrom2.getChroma() - d3) < Math.abs(hct.getChroma() - d3)) {
                hct = hctFrom2;
            }
            chroma = Math.max(chroma, hctFrom2.getChroma());
            d5 = d6;
        }
        return d5;
    }

    public static DynamicColor highestSurface(DynamicScheme dynamicScheme) {
        return dynamicScheme.isDark ? surfaceBright : surfaceDim;
    }

    private static boolean isFidelity(DynamicScheme dynamicScheme) {
        Variant variant = dynamicScheme.variant;
        return variant == Variant.FIDELITY || variant == Variant.CONTENT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$1(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 6.0d : 98.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$10(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 24.0d : 98.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$102(DynamicScheme dynamicScheme) {
        return Double.valueOf(10.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DynamicColor lambda$static$103(DynamicScheme dynamicScheme) {
        return primaryFixedDarker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$105(DynamicScheme dynamicScheme) {
        return Double.valueOf(30.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DynamicColor lambda$static$106(DynamicScheme dynamicScheme) {
        return primaryFixedDarker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$108(DynamicScheme dynamicScheme) {
        return Double.valueOf(90.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$111(DynamicScheme dynamicScheme) {
        return Double.valueOf(80.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$114(DynamicScheme dynamicScheme) {
        return Double.valueOf(10.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DynamicColor lambda$static$115(DynamicScheme dynamicScheme) {
        return secondaryFixedDarker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$117(DynamicScheme dynamicScheme) {
        return Double.valueOf(30.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DynamicColor lambda$static$118(DynamicScheme dynamicScheme) {
        return secondaryFixedDarker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$12(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 6.0d : 87.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$120(DynamicScheme dynamicScheme) {
        return Double.valueOf(90.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$123(DynamicScheme dynamicScheme) {
        return Double.valueOf(80.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$126(DynamicScheme dynamicScheme) {
        return Double.valueOf(10.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DynamicColor lambda$static$127(DynamicScheme dynamicScheme) {
        return tertiaryFixedDarker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$129(DynamicScheme dynamicScheme) {
        return Double.valueOf(30.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DynamicColor lambda$static$130(DynamicScheme dynamicScheme) {
        return tertiaryFixedDarker;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$132(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 30.0d : 90.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$134(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 80.0d : 30.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$135(DynamicScheme dynamicScheme) {
        return Double.valueOf(0.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$136(DynamicScheme dynamicScheme) {
        return Double.valueOf(0.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$137(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 100.0d : 0.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$138(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 0.2d : 0.12d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$139(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 100.0d : 0.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$14(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 4.0d : 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$140(DynamicScheme dynamicScheme) {
        return Double.valueOf(DynamicColor.toneMinContrastDefault(new e(2), null, dynamicScheme, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$141(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 100.0d : 0.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$142(DynamicScheme dynamicScheme) {
        return Double.valueOf(DynamicColor.toneMaxContrastDefault(new e(1), null, dynamicScheme, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$144(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 10.0d : 90.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$146(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 30.0d : 80.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$148(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 10.0d : 90.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$150(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 10.0d : 90.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$152(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 10.0d : 90.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$16(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 10.0d : 96.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$18(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 12.0d : 94.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$20(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 17.0d : 92.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$22(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 22.0d : 90.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$24(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 90.0d : 10.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$27(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 20.0d : 95.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DynamicColor lambda$static$28(DynamicScheme dynamicScheme) {
        return surfaceInverse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$3(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 90.0d : 10.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$30(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 30.0d : 90.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$32(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 80.0d : 30.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DynamicColor lambda$static$33(DynamicScheme dynamicScheme) {
        return surfaceVariant;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$35(DynamicScheme dynamicScheme) {
        return Double.valueOf(50.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$38(DynamicScheme dynamicScheme) {
        return Double.valueOf(80.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DynamicColor lambda$static$4(DynamicScheme dynamicScheme) {
        return background;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$41(DynamicScheme dynamicScheme) {
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(performAlbers(dynamicScheme.sourceColorHct, dynamicScheme));
        }
        return Double.valueOf(dynamicScheme.isDark ? 30.0d : 90.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$44(DynamicScheme dynamicScheme) {
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(DynamicColor.contrastingTone(primaryContainer.getTone(dynamicScheme), 4.5d));
        }
        return Double.valueOf(dynamicScheme.isDark ? 90.0d : 10.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DynamicColor lambda$static$45(DynamicScheme dynamicScheme) {
        return primaryContainer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$47(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 80.0d : 40.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ToneDeltaConstraint lambda$static$49(DynamicScheme dynamicScheme) {
        return new ToneDeltaConstraint(CONTAINER_ACCENT_TONE_DELTA, primaryContainer, dynamicScheme.isDark ? TonePolarity.DARKER : TonePolarity.LIGHTER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$51(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 40.0d : 80.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DynamicColor lambda$static$52(DynamicScheme dynamicScheme) {
        return surfaceInverse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$54(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 20.0d : 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DynamicColor lambda$static$55(DynamicScheme dynamicScheme) {
        return primary;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$57(DynamicScheme dynamicScheme) {
        double d2 = dynamicScheme.isDark ? 30.0d : 90.0d;
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(performAlbers(dynamicScheme.secondaryPalette.getHct(findDesiredChromaByTone(dynamicScheme.secondaryPalette.getHue(), dynamicScheme.secondaryPalette.getChroma(), d2, !dynamicScheme.isDark)), dynamicScheme));
        }
        return Double.valueOf(d2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$6(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 6.0d : 98.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$60(DynamicScheme dynamicScheme) {
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(DynamicColor.contrastingTone(secondaryContainer.getTone(dynamicScheme), 4.5d));
        }
        return Double.valueOf(dynamicScheme.isDark ? 90.0d : 10.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DynamicColor lambda$static$61(DynamicScheme dynamicScheme) {
        return secondaryContainer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$63(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 80.0d : 40.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ToneDeltaConstraint lambda$static$65(DynamicScheme dynamicScheme) {
        return new ToneDeltaConstraint(CONTAINER_ACCENT_TONE_DELTA, secondaryContainer, dynamicScheme.isDark ? TonePolarity.DARKER : TonePolarity.LIGHTER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$67(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 20.0d : 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DynamicColor lambda$static$68(DynamicScheme dynamicScheme) {
        return secondary;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$70(DynamicScheme dynamicScheme) {
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(DislikeAnalyzer.fixIfDisliked(dynamicScheme.tertiaryPalette.getHct(performAlbers(dynamicScheme.tertiaryPalette.getHct(dynamicScheme.sourceColorHct.getTone()), dynamicScheme))).getTone());
        }
        return Double.valueOf(dynamicScheme.isDark ? 30.0d : 90.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$73(DynamicScheme dynamicScheme) {
        if (isFidelity(dynamicScheme)) {
            return Double.valueOf(DynamicColor.contrastingTone(tertiaryContainer.getTone(dynamicScheme), 4.5d));
        }
        return Double.valueOf(dynamicScheme.isDark ? 90.0d : 10.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DynamicColor lambda$static$74(DynamicScheme dynamicScheme) {
        return tertiaryContainer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$76(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 80.0d : 40.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ToneDeltaConstraint lambda$static$78(DynamicScheme dynamicScheme) {
        return new ToneDeltaConstraint(CONTAINER_ACCENT_TONE_DELTA, tertiaryContainer, dynamicScheme.isDark ? TonePolarity.DARKER : TonePolarity.LIGHTER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$8(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 90.0d : 20.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$80(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 20.0d : 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DynamicColor lambda$static$81(DynamicScheme dynamicScheme) {
        return tertiary;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$83(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 30.0d : 90.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$86(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 90.0d : 10.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DynamicColor lambda$static$87(DynamicScheme dynamicScheme) {
        return errorContainer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$89(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 80.0d : 40.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ToneDeltaConstraint lambda$static$91(DynamicScheme dynamicScheme) {
        return new ToneDeltaConstraint(CONTAINER_ACCENT_TONE_DELTA, errorContainer, dynamicScheme.isDark ? TonePolarity.DARKER : TonePolarity.LIGHTER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$93(DynamicScheme dynamicScheme) {
        return Double.valueOf(dynamicScheme.isDark ? 20.0d : 100.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DynamicColor lambda$static$94(DynamicScheme dynamicScheme) {
        return error;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$96(DynamicScheme dynamicScheme) {
        return Double.valueOf(90.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$static$99(DynamicScheme dynamicScheme) {
        return Double.valueOf(80.0d);
    }

    public static double performAlbers(Hct hct, DynamicScheme dynamicScheme) {
        Hct hctInViewingConditions = hct.inViewingConditions(viewingConditionsForAlbers(dynamicScheme));
        return (!DynamicColor.tonePrefersLightForeground(hct.getTone()) || DynamicColor.toneAllowsLightForeground(hctInViewingConditions.getTone())) ? DynamicColor.enableLightForeground(hctInViewingConditions.getTone()) : DynamicColor.enableLightForeground(hct.getTone());
    }

    private static ViewingConditions viewingConditionsForAlbers(DynamicScheme dynamicScheme) {
        return ViewingConditions.defaultWithBackgroundLstar(dynamicScheme.isDark ? 30.0d : 80.0d);
    }
}
