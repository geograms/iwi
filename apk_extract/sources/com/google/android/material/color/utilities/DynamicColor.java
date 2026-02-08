package com.google.android.material.color.utilities;

import java.util.HashMap;
import java.util.function.BiFunction;
import java.util.function.Function;

/* loaded from: classes.dex */
public final class DynamicColor {
    public final Function<DynamicScheme, DynamicColor> background;
    public final Function<DynamicScheme, Double> chroma;
    private final HashMap<DynamicScheme, Hct> hctCache = new HashMap<>();
    public final Function<DynamicScheme, Double> hue;
    public final Function<DynamicScheme, Double> opacity;
    public final Function<DynamicScheme, Double> tone;
    public final Function<DynamicScheme, ToneDeltaConstraint> toneDeltaConstraint;
    public final Function<DynamicScheme, Double> toneMaxContrast;
    public final Function<DynamicScheme, Double> toneMinContrast;

    /* renamed from: com.google.android.material.color.utilities.DynamicColor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$material$color$utilities$TonePolarity;

        static {
            int[] iArr = new int[TonePolarity.values().length];
            $SwitchMap$com$google$android$material$color$utilities$TonePolarity = iArr;
            try {
                iArr[TonePolarity.DARKER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$android$material$color$utilities$TonePolarity[TonePolarity.LIGHTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$android$material$color$utilities$TonePolarity[TonePolarity.NO_PREFERENCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public DynamicColor(Function<DynamicScheme, Double> function, Function<DynamicScheme, Double> function2, Function<DynamicScheme, Double> function3, Function<DynamicScheme, Double> function4, Function<DynamicScheme, DynamicColor> function5, Function<DynamicScheme, Double> function6, Function<DynamicScheme, Double> function7, Function<DynamicScheme, ToneDeltaConstraint> function8) {
        this.hue = function;
        this.chroma = function2;
        this.tone = function3;
        this.opacity = function4;
        this.background = function5;
        this.toneMinContrast = function6;
        this.toneMaxContrast = function7;
        this.toneDeltaConstraint = function8;
    }

    public static double calculateDynamicTone(DynamicScheme dynamicScheme, Function<DynamicScheme, Double> function, Function<DynamicColor, Double> function2, BiFunction<Double, Double, Double> biFunction, Function<DynamicScheme, DynamicColor> function3, Function<DynamicScheme, ToneDeltaConstraint> function4, Function<Double, Double> function5, Function<Double, Double> function6) {
        double dDoubleValue = function.apply(dynamicScheme).doubleValue();
        DynamicColor dynamicColorApply = function3 == null ? null : function3.apply(dynamicScheme);
        if (dynamicColorApply == null) {
            return dDoubleValue;
        }
        double dRatioOfTones = Contrast.ratioOfTones(dDoubleValue, dynamicColorApply.tone.apply(dynamicScheme).doubleValue());
        double dDoubleValue2 = function2.apply(dynamicColorApply).doubleValue();
        double dDoubleValue3 = biFunction.apply(Double.valueOf(dRatioOfTones), Double.valueOf(dDoubleValue2)).doubleValue();
        double dRatioOfTones2 = Contrast.ratioOfTones(dDoubleValue2, dDoubleValue3);
        double dDoubleValue4 = 1.0d;
        if (function5 != null && function5.apply(Double.valueOf(dRatioOfTones)) != null) {
            dDoubleValue4 = function5.apply(Double.valueOf(dRatioOfTones)).doubleValue();
        }
        double dClampDouble = MathUtils.clampDouble(dDoubleValue4, (function6 == null || function6.apply(Double.valueOf(dRatioOfTones)) == null) ? 21.0d : function6.apply(Double.valueOf(dRatioOfTones)).doubleValue(), dRatioOfTones2);
        if (dClampDouble != dRatioOfTones2) {
            dDoubleValue3 = contrastingTone(dDoubleValue2, dClampDouble);
        }
        Function<DynamicScheme, DynamicColor> function7 = dynamicColorApply.background;
        return ensureToneDelta((function7 == null || function7.apply(dynamicScheme) == null) ? enableLightForeground(dDoubleValue3) : dDoubleValue3, dDoubleValue, dynamicScheme, function4, function2);
    }

    public static double contrastingTone(double d2, double d3) {
        double dLighterUnsafe = Contrast.lighterUnsafe(d2, d3);
        double dDarkerUnsafe = Contrast.darkerUnsafe(d2, d3);
        double dRatioOfTones = Contrast.ratioOfTones(dLighterUnsafe, d2);
        double dRatioOfTones2 = Contrast.ratioOfTones(dDarkerUnsafe, d2);
        if (tonePrefersLightForeground(d2)) {
            return (dRatioOfTones >= d3 || dRatioOfTones >= dRatioOfTones2 || ((Math.abs(dRatioOfTones - dRatioOfTones2) > 0.1d ? 1 : (Math.abs(dRatioOfTones - dRatioOfTones2) == 0.1d ? 0 : -1)) < 0 && (dRatioOfTones > d3 ? 1 : (dRatioOfTones == d3 ? 0 : -1)) < 0 && (dRatioOfTones2 > d3 ? 1 : (dRatioOfTones2 == d3 ? 0 : -1)) < 0)) ? dLighterUnsafe : dDarkerUnsafe;
        }
        return (dRatioOfTones2 >= d3 || dRatioOfTones2 >= dRatioOfTones) ? dDarkerUnsafe : dLighterUnsafe;
    }

    public static double enableLightForeground(double d2) {
        if (!tonePrefersLightForeground(d2) || toneAllowsLightForeground(d2)) {
            return d2;
        }
        return 49.0d;
    }

    public static double ensureToneDelta(double d2, double d3, DynamicScheme dynamicScheme, Function<DynamicScheme, ToneDeltaConstraint> function, Function<DynamicColor, Double> function2) {
        ToneDeltaConstraint toneDeltaConstraintApply = function == null ? null : function.apply(dynamicScheme);
        if (toneDeltaConstraintApply == null) {
            return d2;
        }
        double d4 = toneDeltaConstraintApply.delta;
        double dDoubleValue = function2.apply(toneDeltaConstraintApply.keepAway).doubleValue();
        double dAbs = Math.abs(d2 - dDoubleValue);
        if (dAbs >= d4) {
            return d2;
        }
        int i2 = AnonymousClass1.$SwitchMap$com$google$android$material$color$utilities$TonePolarity[toneDeltaConstraintApply.keepAwayPolarity.ordinal()];
        if (i2 == 1) {
            return MathUtils.clampDouble(0.0d, 100.0d, dDoubleValue + d4);
        }
        if (i2 == 2) {
            return MathUtils.clampDouble(0.0d, 100.0d, dDoubleValue - d4);
        }
        if (i2 != 3) {
            return d2;
        }
        boolean z2 = d3 > toneDeltaConstraintApply.keepAway.tone.apply(dynamicScheme).doubleValue();
        double dAbs2 = Math.abs(dAbs - d4);
        return (!z2 ? d2 < dAbs2 : d2 + dAbs2 <= 100.0d) ? d2 - dAbs2 : d2 + dAbs2;
    }

    public static DynamicColor fromArgb(int i2) {
        return fromPalette(new h(1, TonalPalette.fromInt(i2)), new h(2, Hct.fromInt(i2)));
    }

    public static DynamicColor fromPalette(Function<DynamicScheme, TonalPalette> function, Function<DynamicScheme, Double> function2) {
        return fromPalette(function, function2, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TonalPalette lambda$fromArgb$0(TonalPalette tonalPalette, DynamicScheme dynamicScheme) {
        return tonalPalette;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$fromArgb$1(Hct hct, DynamicScheme dynamicScheme) {
        return Double.valueOf(hct.getTone());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TonalPalette lambda$fromArgb$2(int i2, DynamicScheme dynamicScheme) {
        return TonalPalette.fromInt(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TonalPalette lambda$fromArgb$3(int i2, DynamicScheme dynamicScheme) {
        return TonalPalette.fromInt(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TonalPalette lambda$fromArgb$4(int i2, DynamicScheme dynamicScheme) {
        return TonalPalette.fromInt(i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$fromPalette$5(Function function, DynamicScheme dynamicScheme) {
        return Double.valueOf(((TonalPalette) function.apply(dynamicScheme)).getHue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$fromPalette$6(Function function, DynamicScheme dynamicScheme) {
        return Double.valueOf(((TonalPalette) function.apply(dynamicScheme)).getChroma());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$fromPalette$7(Function function, Function function2, Function function3, DynamicScheme dynamicScheme) {
        return Double.valueOf(toneMinContrastDefault(function, function2, dynamicScheme, function3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$fromPalette$8(Function function, Function function2, Function function3, DynamicScheme dynamicScheme) {
        return Double.valueOf(toneMaxContrastDefault(function, function2, dynamicScheme, function3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$getTone$10(double d2, Double d3, Double d4) {
        return Double.valueOf(d2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DynamicColor lambda$getTone$11(DynamicColor dynamicColor, DynamicScheme dynamicScheme) {
        return dynamicColor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$getTone$12(double d2, Double d3) {
        return Double.valueOf(d2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$getTone$13(double d2, Double d3) {
        return Double.valueOf(d2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$getTone$9(DynamicScheme dynamicScheme, DynamicColor dynamicColor) {
        return Double.valueOf(dynamicColor.getTone(dynamicScheme));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$toneMaxContrastDefault$17(DynamicScheme dynamicScheme, DynamicColor dynamicColor) {
        return dynamicColor.toneMaxContrast.apply(dynamicScheme);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$toneMaxContrastDefault$18(Function function, DynamicScheme dynamicScheme, Double d2, Double d3) {
        return (function == null || function.apply(dynamicScheme) == null || ((DynamicColor) function.apply(dynamicScheme)).background == null || ((DynamicColor) function.apply(dynamicScheme)).background.apply(dynamicScheme) == null) ? Double.valueOf(contrastingTone(d3.doubleValue(), Math.max(7.0d, d2.doubleValue()))) : Double.valueOf(contrastingTone(d3.doubleValue(), 7.0d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$toneMinContrastDefault$14(DynamicScheme dynamicScheme, DynamicColor dynamicColor) {
        return dynamicColor.toneMinContrast.apply(dynamicScheme);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$toneMinContrastDefault$15(Function function, DynamicScheme dynamicScheme, Function function2, Double d2, Double d3) {
        double dDoubleValue = ((Double) function.apply(dynamicScheme)).doubleValue();
        if (d2.doubleValue() >= 7.0d) {
            dDoubleValue = contrastingTone(d3.doubleValue(), 4.5d);
        } else if (d2.doubleValue() >= 3.0d) {
            dDoubleValue = contrastingTone(d3.doubleValue(), 3.0d);
        } else if (function2 != null && function2.apply(dynamicScheme) != null && ((DynamicColor) function2.apply(dynamicScheme)).background != null && ((DynamicColor) function2.apply(dynamicScheme)).background.apply(dynamicScheme) != null) {
            dDoubleValue = contrastingTone(d3.doubleValue(), d2.doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double lambda$toneMinContrastDefault$16(Double d2) {
        return d2;
    }

    public static boolean toneAllowsLightForeground(double d2) {
        return Math.round(d2) <= 49;
    }

    public static double toneMaxContrastDefault(Function<DynamicScheme, Double> function, final Function<DynamicScheme, DynamicColor> function2, final DynamicScheme dynamicScheme, Function<DynamicScheme, ToneDeltaConstraint> function3) {
        return calculateDynamicTone(dynamicScheme, function, new c(2, dynamicScheme), new BiFunction() { // from class: com.google.android.material.color.utilities.j
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return DynamicColor.lambda$toneMaxContrastDefault$18(function2, dynamicScheme, (Double) obj, (Double) obj2);
            }
        }, function2, function3, null, null);
    }

    public static double toneMinContrastDefault(final Function<DynamicScheme, Double> function, final Function<DynamicScheme, DynamicColor> function2, final DynamicScheme dynamicScheme, Function<DynamicScheme, ToneDeltaConstraint> function3) {
        int i2 = 0;
        return calculateDynamicTone(dynamicScheme, function, new c(i2, dynamicScheme), new BiFunction() { // from class: com.google.android.material.color.utilities.d
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return DynamicColor.lambda$toneMinContrastDefault$15(function, dynamicScheme, function2, (Double) obj, (Double) obj2);
            }
        }, function2, function3, null, new e(i2));
    }

    public static boolean tonePrefersLightForeground(double d2) {
        return Math.round(d2) <= 60;
    }

    public int getArgb(DynamicScheme dynamicScheme) {
        int i2 = getHct(dynamicScheme).toInt();
        Function<DynamicScheme, Double> function = this.opacity;
        if (function == null) {
            return i2;
        }
        return (MathUtils.clampInt(0, 255, (int) Math.round(function.apply(dynamicScheme).doubleValue() * 255.0d)) << 24) | (16777215 & i2);
    }

    public Hct getHct(DynamicScheme dynamicScheme) {
        Hct hct = this.hctCache.get(dynamicScheme);
        if (hct != null) {
            return hct;
        }
        Hct hctFrom = Hct.from(this.hue.apply(dynamicScheme).doubleValue(), this.chroma.apply(dynamicScheme).doubleValue(), getTone(dynamicScheme));
        if (this.hctCache.size() > 4) {
            this.hctCache.clear();
        }
        this.hctCache.put(dynamicScheme, hctFrom);
        return hctFrom;
    }

    public double getTone(DynamicScheme dynamicScheme) {
        final double dRatioOfTones;
        final double dRatioOfTones2;
        final double dDoubleValue = this.tone.apply(dynamicScheme).doubleValue();
        double d2 = dynamicScheme.contrastLevel;
        final int i2 = 0;
        final int i3 = 1;
        boolean z2 = d2 < 0.0d;
        if (d2 != 0.0d) {
            double dDoubleValue2 = this.tone.apply(dynamicScheme).doubleValue();
            dDoubleValue = dDoubleValue2 + (Math.abs(dynamicScheme.contrastLevel) * ((z2 ? this.toneMinContrast : this.toneMaxContrast).apply(dynamicScheme).doubleValue() - dDoubleValue2));
        }
        Function<DynamicScheme, DynamicColor> function = this.background;
        DynamicColor dynamicColorApply = function == null ? null : function.apply(dynamicScheme);
        if (dynamicColorApply != null) {
            Function<DynamicScheme, DynamicColor> function2 = dynamicColorApply.background;
            boolean z3 = (function2 == null || function2.apply(dynamicScheme) == null) ? false : true;
            dRatioOfTones = Contrast.ratioOfTones(this.tone.apply(dynamicScheme).doubleValue(), dynamicColorApply.tone.apply(dynamicScheme).doubleValue());
            if (z2) {
                dRatioOfTones2 = Contrast.ratioOfTones(this.toneMinContrast.apply(dynamicScheme).doubleValue(), dynamicColorApply.toneMinContrast.apply(dynamicScheme).doubleValue());
                if (!z3) {
                }
            } else {
                double dRatioOfTones3 = Contrast.ratioOfTones(this.toneMaxContrast.apply(dynamicScheme).doubleValue(), dynamicColorApply.toneMaxContrast.apply(dynamicScheme).doubleValue());
                double dMin = z3 ? Math.min(dRatioOfTones3, dRatioOfTones) : 1.0d;
                dRatioOfTones = z3 ? Math.max(dRatioOfTones3, dRatioOfTones) : 21.0d;
                dRatioOfTones2 = dMin;
            }
            return calculateDynamicTone(dynamicScheme, this.tone, new c(i3, dynamicScheme), new BiFunction() { // from class: com.google.android.material.color.utilities.g
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj, Object obj2) {
                    return DynamicColor.lambda$getTone$10(dDoubleValue, (Double) obj, (Double) obj2);
                }
            }, new h(i2, dynamicColorApply), this.toneDeltaConstraint, new Function() { // from class: com.google.android.material.color.utilities.i
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i4 = i2;
                    double d3 = dRatioOfTones2;
                    Double d4 = (Double) obj;
                    switch (i4) {
                        case 0:
                            return DynamicColor.lambda$getTone$12(d3, d4);
                        default:
                            return DynamicColor.lambda$getTone$13(d3, d4);
                    }
                }
            }, new Function() { // from class: com.google.android.material.color.utilities.i
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    int i4 = i3;
                    double d3 = dRatioOfTones;
                    Double d4 = (Double) obj;
                    switch (i4) {
                        case 0:
                            return DynamicColor.lambda$getTone$12(d3, d4);
                        default:
                            return DynamicColor.lambda$getTone$13(d3, d4);
                    }
                }
            });
        }
        dRatioOfTones = 21.0d;
        dRatioOfTones2 = 1.0d;
        return calculateDynamicTone(dynamicScheme, this.tone, new c(i3, dynamicScheme), new BiFunction() { // from class: com.google.android.material.color.utilities.g
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return DynamicColor.lambda$getTone$10(dDoubleValue, (Double) obj, (Double) obj2);
            }
        }, new h(i2, dynamicColorApply), this.toneDeltaConstraint, new Function() { // from class: com.google.android.material.color.utilities.i
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                int i4 = i2;
                double d3 = dRatioOfTones2;
                Double d4 = (Double) obj;
                switch (i4) {
                    case 0:
                        return DynamicColor.lambda$getTone$12(d3, d4);
                    default:
                        return DynamicColor.lambda$getTone$13(d3, d4);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.i
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                int i4 = i3;
                double d3 = dRatioOfTones;
                Double d4 = (Double) obj;
                switch (i4) {
                    case 0:
                        return DynamicColor.lambda$getTone$12(d3, d4);
                    default:
                        return DynamicColor.lambda$getTone$13(d3, d4);
                }
            }
        });
    }

    public static DynamicColor fromPalette(Function<DynamicScheme, TonalPalette> function, Function<DynamicScheme, Double> function2, Function<DynamicScheme, DynamicColor> function3) {
        return fromPalette(function, function2, function3, null);
    }

    public static DynamicColor fromPalette(final Function<DynamicScheme, TonalPalette> function, final Function<DynamicScheme, Double> function2, final Function<DynamicScheme, DynamicColor> function3, final Function<DynamicScheme, ToneDeltaConstraint> function4) {
        final int i2 = 0;
        final int i3 = 1;
        return new DynamicColor(new Function() { // from class: com.google.android.material.color.utilities.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                int i4 = i2;
                Function function5 = function;
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i4) {
                    case 0:
                        return DynamicColor.lambda$fromPalette$5(function5, dynamicScheme);
                    default:
                        return DynamicColor.lambda$fromPalette$6(function5, dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                int i4 = i3;
                Function function5 = function;
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i4) {
                    case 0:
                        return DynamicColor.lambda$fromPalette$5(function5, dynamicScheme);
                    default:
                        return DynamicColor.lambda$fromPalette$6(function5, dynamicScheme);
                }
            }
        }, function2, null, function3, new Function() { // from class: com.google.android.material.color.utilities.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                int i4 = i2;
                Function function5 = function3;
                Function function6 = function2;
                Function function7 = function4;
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i4) {
                    case 0:
                        return DynamicColor.lambda$fromPalette$7(function6, function5, function7, dynamicScheme);
                    default:
                        return DynamicColor.lambda$fromPalette$8(function6, function5, function7, dynamicScheme);
                }
            }
        }, new Function() { // from class: com.google.android.material.color.utilities.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                int i4 = i3;
                Function function5 = function3;
                Function function6 = function2;
                Function function7 = function4;
                DynamicScheme dynamicScheme = (DynamicScheme) obj;
                switch (i4) {
                    case 0:
                        return DynamicColor.lambda$fromPalette$7(function6, function5, function7, dynamicScheme);
                    default:
                        return DynamicColor.lambda$fromPalette$8(function6, function5, function7, dynamicScheme);
                }
            }
        }, function4);
    }

    public static DynamicColor fromArgb(int i2, Function<DynamicScheme, Double> function) {
        return fromPalette(new f(i2, 1), function);
    }

    public static DynamicColor fromArgb(int i2, Function<DynamicScheme, Double> function, Function<DynamicScheme, DynamicColor> function2) {
        return fromPalette(new f(i2, 0), function, function2);
    }

    public static DynamicColor fromArgb(int i2, Function<DynamicScheme, Double> function, Function<DynamicScheme, DynamicColor> function2, Function<DynamicScheme, ToneDeltaConstraint> function3) {
        return fromPalette(new f(i2, 2), function, function2, function3);
    }
}
