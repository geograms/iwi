package com.google.android.material.carousel;

import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.carousel.KeylineState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
class KeylineStateList {
    private static final int NO_INDEX = -1;
    private final KeylineState defaultState;
    private final float leftShiftRange;
    private final List<KeylineState> leftStateSteps;
    private final float[] leftStateStepsInterpolationPoints;
    private final float rightShiftRange;
    private final List<KeylineState> rightStateSteps;
    private final float[] rightStateStepsInterpolationPoints;

    private KeylineStateList(KeylineState keylineState, List<KeylineState> list, List<KeylineState> list2) {
        this.defaultState = keylineState;
        this.leftStateSteps = Collections.unmodifiableList(list);
        this.rightStateSteps = Collections.unmodifiableList(list2);
        float f2 = list.get(list.size() - 1).getFirstKeyline().loc - keylineState.getFirstKeyline().loc;
        this.leftShiftRange = f2;
        float f3 = keylineState.getLastKeyline().loc - list2.get(list2.size() - 1).getLastKeyline().loc;
        this.rightShiftRange = f3;
        this.leftStateStepsInterpolationPoints = getStateStepInterpolationPoints(f2, list, true);
        this.rightStateStepsInterpolationPoints = getStateStepInterpolationPoints(f3, list2, false);
    }

    private static int findFirstInBoundsKeylineIndex(KeylineState keylineState) {
        for (int i2 = 0; i2 < keylineState.getKeylines().size(); i2++) {
            if (keylineState.getKeylines().get(i2).locOffset >= 0.0f) {
                return i2;
            }
        }
        return -1;
    }

    private static int findFirstIndexAfterLastFocalKeylineWithMask(KeylineState keylineState, float f2) {
        for (int lastFocalKeylineIndex = keylineState.getLastFocalKeylineIndex(); lastFocalKeylineIndex < keylineState.getKeylines().size(); lastFocalKeylineIndex++) {
            if (f2 == keylineState.getKeylines().get(lastFocalKeylineIndex).mask) {
                return lastFocalKeylineIndex;
            }
        }
        return keylineState.getKeylines().size() - 1;
    }

    private static int findLastInBoundsKeylineIndex(Carousel carousel, KeylineState keylineState) {
        for (int size = keylineState.getKeylines().size() - 1; size >= 0; size--) {
            if (keylineState.getKeylines().get(size).locOffset <= carousel.getContainerWidth()) {
                return size;
            }
        }
        return -1;
    }

    private static int findLastIndexBeforeFirstFocalKeylineWithMask(KeylineState keylineState, float f2) {
        for (int firstFocalKeylineIndex = keylineState.getFirstFocalKeylineIndex() - 1; firstFocalKeylineIndex >= 0; firstFocalKeylineIndex--) {
            if (f2 == keylineState.getKeylines().get(firstFocalKeylineIndex).mask) {
                return firstFocalKeylineIndex;
            }
        }
        return 0;
    }

    public static KeylineStateList from(Carousel carousel, KeylineState keylineState) {
        return new KeylineStateList(keylineState, getStateStepsLeft(keylineState), getStateStepsRight(carousel, keylineState));
    }

    private static float[] getStateStepInterpolationPoints(float f2, List<KeylineState> list, boolean z2) {
        int size = list.size();
        float[] fArr = new float[size];
        int i2 = 1;
        while (i2 < size) {
            int i3 = i2 - 1;
            KeylineState keylineState = list.get(i3);
            KeylineState keylineState2 = list.get(i2);
            fArr[i2] = i2 == size + (-1) ? 1.0f : fArr[i3] + ((z2 ? keylineState2.getFirstKeyline().loc - keylineState.getFirstKeyline().loc : keylineState.getLastKeyline().loc - keylineState2.getLastKeyline().loc) / f2);
            i2++;
        }
        return fArr;
    }

    private static List<KeylineState> getStateStepsLeft(KeylineState keylineState) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState);
        int iFindFirstInBoundsKeylineIndex = findFirstInBoundsKeylineIndex(keylineState);
        if (!isFirstFocalItemAtLeftOfContainer(keylineState) && iFindFirstInBoundsKeylineIndex != -1) {
            int firstFocalKeylineIndex = (keylineState.getFirstFocalKeylineIndex() - 1) - iFindFirstInBoundsKeylineIndex;
            float f2 = keylineState.getFirstKeyline().locOffset - (keylineState.getFirstKeyline().maskedItemSize / 2.0f);
            for (int i2 = 0; i2 <= firstFocalKeylineIndex; i2++) {
                KeylineState keylineState2 = (KeylineState) arrayList.get(arrayList.size() - 1);
                int size = keylineState.getKeylines().size() - 1;
                int i3 = (iFindFirstInBoundsKeylineIndex + i2) - 1;
                if (i3 >= 0) {
                    size = findFirstIndexAfterLastFocalKeylineWithMask(keylineState2, keylineState.getKeylines().get(i3).mask) - 1;
                }
                arrayList.add(moveKeylineAndCreateKeylineState(keylineState2, iFindFirstInBoundsKeylineIndex, size, f2, (keylineState.getFirstFocalKeylineIndex() - i2) - 1, (keylineState.getLastFocalKeylineIndex() - i2) - 1));
            }
        }
        return arrayList;
    }

    private static List<KeylineState> getStateStepsRight(Carousel carousel, KeylineState keylineState) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(keylineState);
        int iFindLastInBoundsKeylineIndex = findLastInBoundsKeylineIndex(carousel, keylineState);
        if (!isLastFocalItemAtRightOfContainer(carousel, keylineState) && iFindLastInBoundsKeylineIndex != -1) {
            int lastFocalKeylineIndex = iFindLastInBoundsKeylineIndex - keylineState.getLastFocalKeylineIndex();
            float f2 = keylineState.getFirstKeyline().locOffset - (keylineState.getFirstKeyline().maskedItemSize / 2.0f);
            for (int i2 = 0; i2 < lastFocalKeylineIndex; i2++) {
                KeylineState keylineState2 = (KeylineState) arrayList.get(arrayList.size() - 1);
                int i3 = (iFindLastInBoundsKeylineIndex - i2) + 1;
                arrayList.add(moveKeylineAndCreateKeylineState(keylineState2, iFindLastInBoundsKeylineIndex, i3 < keylineState.getKeylines().size() ? findLastIndexBeforeFirstFocalKeylineWithMask(keylineState2, keylineState.getKeylines().get(i3).mask) + 1 : 0, f2, keylineState.getFirstFocalKeylineIndex() + i2 + 1, keylineState.getLastFocalKeylineIndex() + i2 + 1));
            }
        }
        return arrayList;
    }

    private static boolean isFirstFocalItemAtLeftOfContainer(KeylineState keylineState) {
        return keylineState.getFirstFocalKeyline().locOffset - (keylineState.getFirstFocalKeyline().maskedItemSize / 2.0f) <= 0.0f || keylineState.getFirstFocalKeyline() == keylineState.getFirstKeyline();
    }

    private static boolean isLastFocalItemAtRightOfContainer(Carousel carousel, KeylineState keylineState) {
        return (keylineState.getLastFocalKeyline().maskedItemSize / 2.0f) + keylineState.getLastFocalKeyline().locOffset >= ((float) carousel.getContainerWidth()) || keylineState.getLastFocalKeyline() == keylineState.getLastKeyline();
    }

    private static KeylineState lerp(List<KeylineState> list, float f2, float[] fArr) {
        int size = list.size();
        float f3 = fArr[0];
        int i2 = 1;
        while (i2 < size) {
            float f4 = fArr[i2];
            if (f2 <= f4) {
                return KeylineState.lerp(list.get(i2 - 1), list.get(i2), AnimationUtils.lerp(0.0f, 1.0f, f3, f4, f2));
            }
            i2++;
            f3 = f4;
        }
        return list.get(0);
    }

    private static KeylineState moveKeylineAndCreateKeylineState(KeylineState keylineState, int i2, int i3, float f2, int i4, int i5) {
        ArrayList arrayList = new ArrayList(keylineState.getKeylines());
        arrayList.add(i3, (KeylineState.Keyline) arrayList.remove(i2));
        KeylineState.Builder builder = new KeylineState.Builder(keylineState.getItemSize());
        int i6 = 0;
        while (i6 < arrayList.size()) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) arrayList.get(i6);
            float f3 = keyline.maskedItemSize;
            builder.addKeyline((f3 / 2.0f) + f2, keyline.mask, f3, i6 >= i4 && i6 <= i5);
            f2 += keyline.maskedItemSize;
            i6++;
        }
        return builder.build();
    }

    public KeylineState getDefaultState() {
        return this.defaultState;
    }

    public KeylineState getLeftState() {
        return this.leftStateSteps.get(r1.size() - 1);
    }

    public KeylineState getRightState() {
        return this.rightStateSteps.get(r1.size() - 1);
    }

    public KeylineState getShiftedState(float f2, float f3, float f4) {
        float f5 = this.leftShiftRange + f3;
        float f6 = f4 - this.rightShiftRange;
        if (f2 < f5) {
            return lerp(this.leftStateSteps, AnimationUtils.lerp(1.0f, 0.0f, f3, f5, f2), this.leftStateStepsInterpolationPoints);
        }
        if (f2 <= f6) {
            return this.defaultState;
        }
        return lerp(this.rightStateSteps, AnimationUtils.lerp(0.0f, 1.0f, f6, f4, f2), this.rightStateStepsInterpolationPoints);
    }
}
