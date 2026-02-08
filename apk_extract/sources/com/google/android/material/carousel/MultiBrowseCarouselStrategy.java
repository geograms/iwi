package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.i1;
import com.google.android.material.R;
import com.google.android.material.carousel.KeylineState;
import x0.g;

/* loaded from: classes.dex */
public final class MultiBrowseCarouselStrategy extends CarouselStrategy {
    private static final float MEDIUM_ITEM_FLEX_PERCENTAGE = 0.1f;
    private final boolean forceCompactArrangement;
    private static final int[] SMALL_COUNTS = {1};
    private static final int[] MEDIUM_COUNTS = {1, 0};
    private static final int[] MEDIUM_COUNTS_COMPACT = {0};

    public static final class Arrangement {
        final float cost;
        final int largeCount;
        float largeSize;
        final int mediumCount;
        float mediumSize;
        final int priority;
        final int smallCount;
        float smallSize;

        public Arrangement(int i2, float f2, float f3, float f4, int i3, float f5, int i4, float f6, int i5, float f7) {
            this.priority = i2;
            this.smallSize = g.w(f2, f3, f4);
            this.smallCount = i3;
            this.mediumSize = f5;
            this.mediumCount = i4;
            this.largeSize = f6;
            this.largeCount = i5;
            fit(f7, f3, f4, f6);
            this.cost = cost(f6);
        }

        private float calculateLargeSize(float f2, int i2, float f3, int i3, int i4) {
            if (i2 <= 0) {
                f3 = 0.0f;
            }
            float f4 = i2;
            float f5 = i3 / 2.0f;
            return (f2 - ((f4 + f5) * f3)) / (i4 + f5);
        }

        private float cost(float f2) {
            if (isValid()) {
                return Math.abs(f2 - this.largeSize) * this.priority;
            }
            return Float.MAX_VALUE;
        }

        private void fit(float f2, float f3, float f4, float f5) {
            float space = f2 - getSpace();
            int i2 = this.smallCount;
            if (i2 > 0 && space > 0.0f) {
                float f6 = this.smallSize;
                this.smallSize = Math.min(space / i2, f4 - f6) + f6;
            } else if (i2 > 0 && space < 0.0f) {
                float f7 = this.smallSize;
                this.smallSize = Math.max(space / i2, f3 - f7) + f7;
            }
            float fCalculateLargeSize = calculateLargeSize(f2, this.smallCount, this.smallSize, this.mediumCount, this.largeCount);
            this.largeSize = fCalculateLargeSize;
            float f8 = (this.smallSize + fCalculateLargeSize) / 2.0f;
            this.mediumSize = f8;
            int i3 = this.mediumCount;
            if (i3 <= 0 || fCalculateLargeSize == f5) {
                return;
            }
            float f9 = (f5 - fCalculateLargeSize) * this.largeCount;
            float fMin = Math.min(Math.abs(f9), f8 * MultiBrowseCarouselStrategy.MEDIUM_ITEM_FLEX_PERCENTAGE * i3);
            if (f9 > 0.0f) {
                this.mediumSize -= fMin / this.mediumCount;
                this.largeSize = (fMin / this.largeCount) + this.largeSize;
            } else {
                this.mediumSize = (fMin / this.mediumCount) + this.mediumSize;
                this.largeSize -= fMin / this.largeCount;
            }
        }

        private float getSpace() {
            return (this.smallSize * this.smallCount) + (this.mediumSize * this.mediumCount) + (this.largeSize * this.largeCount);
        }

        private boolean isValid() {
            int i2 = this.largeCount;
            if (i2 <= 0 || this.smallCount <= 0 || this.mediumCount <= 0) {
                return i2 <= 0 || this.smallCount <= 0 || this.largeSize > this.smallSize;
            }
            float f2 = this.largeSize;
            float f3 = this.mediumSize;
            return f2 > f3 && f3 > this.smallSize;
        }

        public String toString() {
            return "Arrangement [priority=" + this.priority + ", smallCount=" + this.smallCount + ", smallSize=" + this.smallSize + ", mediumCount=" + this.mediumCount + ", mediumSize=" + this.mediumSize + ", largeCount=" + this.largeCount + ", largeSize=" + this.largeSize + ", cost=" + this.cost + "]";
        }
    }

    public MultiBrowseCarouselStrategy() {
        this(false);
    }

    private static Arrangement findLowestCostArrangement(float f2, float f3, float f4, float f5, int[] iArr, float f6, int[] iArr2, float f7, int[] iArr3) {
        Arrangement arrangement = null;
        int i2 = 1;
        for (int i3 : iArr3) {
            int length = iArr2.length;
            int i4 = 0;
            while (i4 < length) {
                int i5 = iArr2[i4];
                int length2 = iArr.length;
                int i6 = 0;
                while (i6 < length2) {
                    int i7 = i6;
                    int i8 = length2;
                    int i9 = i4;
                    int i10 = length;
                    Arrangement arrangement2 = new Arrangement(i2, f3, f4, f5, iArr[i6], f6, i5, f7, i3, f2);
                    if (arrangement == null || arrangement2.cost < arrangement.cost) {
                        if (arrangement2.cost == 0.0f) {
                            return arrangement2;
                        }
                        arrangement = arrangement2;
                    }
                    i2++;
                    i6 = i7 + 1;
                    length2 = i8;
                    i4 = i9;
                    length = i10;
                }
                i4++;
            }
        }
        return arrangement;
    }

    private float getExtraSmallSize(Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_gone_size);
    }

    private float getSmallSizeMax(Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_max);
    }

    private float getSmallSizeMin(Context context) {
        return context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_min);
    }

    private static int maxValue(int[] iArr) {
        int i2 = Integer.MIN_VALUE;
        for (int i3 : iArr) {
            if (i3 > i2) {
                i2 = i3;
            }
        }
        return i2;
    }

    @Override // com.google.android.material.carousel.CarouselStrategy
    public KeylineState onFirstChildMeasuredWithMargins(Carousel carousel, View view) {
        float containerWidth = carousel.getContainerWidth();
        i1 i1Var = (i1) view.getLayoutParams();
        float f2 = ((ViewGroup.MarginLayoutParams) i1Var).leftMargin + ((ViewGroup.MarginLayoutParams) i1Var).rightMargin;
        float smallSizeMin = getSmallSizeMin(view.getContext()) + f2;
        float smallSizeMax = getSmallSizeMax(view.getContext()) + f2;
        float measuredWidth = view.getMeasuredWidth();
        float fMin = Math.min(measuredWidth + f2, containerWidth);
        float fW = g.w((measuredWidth / 3.0f) + f2, getSmallSizeMin(view.getContext()) + f2, getSmallSizeMax(view.getContext()) + f2);
        float f3 = (fMin + fW) / 2.0f;
        int[] iArr = SMALL_COUNTS;
        int[] iArr2 = this.forceCompactArrangement ? MEDIUM_COUNTS_COMPACT : MEDIUM_COUNTS;
        int iMax = (int) Math.max(1.0d, Math.floor(((containerWidth - (maxValue(iArr2) * f3)) - (maxValue(iArr) * smallSizeMax)) / fMin));
        int iCeil = (int) Math.ceil(containerWidth / fMin);
        int i2 = (iCeil - iMax) + 1;
        int[] iArr3 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr3[i3] = iCeil - i3;
        }
        Arrangement arrangementFindLowestCostArrangement = findLowestCostArrangement(containerWidth, fW, smallSizeMin, smallSizeMax, iArr, f3, iArr2, fMin, iArr3);
        float extraSmallSize = getExtraSmallSize(view.getContext()) + f2;
        float f4 = extraSmallSize / 2.0f;
        float f5 = 0.0f - f4;
        float f6 = (arrangementFindLowestCostArrangement.largeSize / 2.0f) + 0.0f;
        float fMax = Math.max(0, arrangementFindLowestCostArrangement.largeCount - 1);
        float f7 = arrangementFindLowestCostArrangement.largeSize;
        float f8 = (fMax * f7) + f6;
        float f9 = (f7 / 2.0f) + f8;
        int i4 = arrangementFindLowestCostArrangement.mediumCount;
        if (i4 > 0) {
            f8 = (arrangementFindLowestCostArrangement.mediumSize / 2.0f) + f9;
        }
        if (i4 > 0) {
            f9 = (arrangementFindLowestCostArrangement.mediumSize / 2.0f) + f8;
        }
        float f10 = arrangementFindLowestCostArrangement.smallCount > 0 ? (arrangementFindLowestCostArrangement.smallSize / 2.0f) + f9 : f8;
        float containerWidth2 = carousel.getContainerWidth() + f4;
        float childMaskPercentage = CarouselStrategy.getChildMaskPercentage(extraSmallSize, arrangementFindLowestCostArrangement.largeSize, f2);
        float childMaskPercentage2 = CarouselStrategy.getChildMaskPercentage(arrangementFindLowestCostArrangement.smallSize, arrangementFindLowestCostArrangement.largeSize, f2);
        float childMaskPercentage3 = CarouselStrategy.getChildMaskPercentage(arrangementFindLowestCostArrangement.mediumSize, arrangementFindLowestCostArrangement.largeSize, f2);
        KeylineState.Builder builderAddKeylineRange = new KeylineState.Builder(arrangementFindLowestCostArrangement.largeSize).addKeyline(f5, childMaskPercentage, extraSmallSize).addKeylineRange(f6, 0.0f, arrangementFindLowestCostArrangement.largeSize, arrangementFindLowestCostArrangement.largeCount, true);
        if (arrangementFindLowestCostArrangement.mediumCount > 0) {
            builderAddKeylineRange.addKeyline(f8, childMaskPercentage3, arrangementFindLowestCostArrangement.mediumSize);
        }
        int i5 = arrangementFindLowestCostArrangement.smallCount;
        if (i5 > 0) {
            builderAddKeylineRange.addKeylineRange(f10, childMaskPercentage2, arrangementFindLowestCostArrangement.smallSize, i5);
        }
        builderAddKeylineRange.addKeyline(containerWidth2, childMaskPercentage, extraSmallSize);
        return builderAddKeylineRange.build();
    }

    public MultiBrowseCarouselStrategy(boolean z2) {
        this.forceCompactArrangement = z2;
    }
}
