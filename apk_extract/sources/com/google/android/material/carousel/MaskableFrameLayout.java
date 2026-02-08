package com.google.android.material.carousel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.search.a;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.ClampedCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.Shapeable;
import p0.m;
import x0.g;

/* loaded from: classes.dex */
public class MaskableFrameLayout extends FrameLayout implements Maskable, Shapeable {
    private final RectF maskRect;
    private float maskXPercentage;
    private final MaskableDelegate maskableDelegate;
    private OnMaskChangedListener onMaskChangedListener;
    private Boolean savedForceCompatClippingEnabled;
    private ShapeAppearanceModel shapeAppearanceModel;

    public static abstract class MaskableDelegate {
        boolean forceCompatClippingEnabled;
        RectF maskBounds;
        ShapeAppearanceModel shapeAppearanceModel;
        final Path shapePath;

        private MaskableDelegate() {
            this.forceCompatClippingEnabled = false;
            this.maskBounds = new RectF();
            this.shapePath = new Path();
        }

        private void updateShapePath() {
            if (this.maskBounds.isEmpty() || this.shapeAppearanceModel == null) {
                return;
            }
            ShapeAppearancePathProvider.getInstance().calculatePath(this.shapeAppearanceModel, 1.0f, this.maskBounds, this.shapePath);
        }

        public abstract void invalidateClippingMethod(View view);

        public boolean isForceCompatClippingEnabled() {
            return this.forceCompatClippingEnabled;
        }

        public void maybeClip(Canvas canvas, CanvasCompat.CanvasOperation canvasOperation) {
            if (!shouldUseCompatClipping() || this.shapePath.isEmpty()) {
                canvasOperation.run(canvas);
                return;
            }
            canvas.save();
            canvas.clipPath(this.shapePath);
            canvasOperation.run(canvas);
            canvas.restore();
        }

        public void onMaskChanged(View view, RectF rectF) {
            this.maskBounds = rectF;
            updateShapePath();
            invalidateClippingMethod(view);
        }

        public void onShapeAppearanceChanged(View view, ShapeAppearanceModel shapeAppearanceModel) {
            this.shapeAppearanceModel = shapeAppearanceModel;
            updateShapePath();
            invalidateClippingMethod(view);
        }

        public void setForceCompatClippingEnabled(View view, boolean z2) {
            if (z2 != this.forceCompatClippingEnabled) {
                this.forceCompatClippingEnabled = z2;
                invalidateClippingMethod(view);
            }
        }

        public abstract boolean shouldUseCompatClipping();
    }

    public static class MaskableDelegateV14 extends MaskableDelegate {
        private MaskableDelegateV14() {
            super();
        }

        @Override // com.google.android.material.carousel.MaskableFrameLayout.MaskableDelegate
        public void invalidateClippingMethod(View view) {
            if (this.shapeAppearanceModel == null || this.maskBounds.isEmpty() || !shouldUseCompatClipping()) {
                return;
            }
            view.invalidate();
        }

        @Override // com.google.android.material.carousel.MaskableFrameLayout.MaskableDelegate
        public boolean shouldUseCompatClipping() {
            return true;
        }
    }

    public static class MaskableDelegateV22 extends MaskableDelegate {
        private boolean isShapeRoundRect;

        public MaskableDelegateV22(View view) {
            super();
            this.isShapeRoundRect = false;
            initMaskOutlineProvider(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float getCornerRadiusFromShapeAppearance(ShapeAppearanceModel shapeAppearanceModel, RectF rectF) {
            return shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF);
        }

        private void initMaskOutlineProvider(View view) {
            view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.google.android.material.carousel.MaskableFrameLayout.MaskableDelegateV22.1
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    MaskableDelegateV22 maskableDelegateV22 = MaskableDelegateV22.this;
                    if (maskableDelegateV22.shapeAppearanceModel == null || maskableDelegateV22.maskBounds.isEmpty()) {
                        return;
                    }
                    MaskableDelegateV22 maskableDelegateV222 = MaskableDelegateV22.this;
                    RectF rectF = maskableDelegateV222.maskBounds;
                    outline.setRoundRect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom, maskableDelegateV222.getCornerRadiusFromShapeAppearance(maskableDelegateV222.shapeAppearanceModel, rectF));
                }
            });
        }

        private void updateIsShapeRoundRect() {
            ShapeAppearanceModel shapeAppearanceModel;
            if (this.maskBounds.isEmpty() || (shapeAppearanceModel = this.shapeAppearanceModel) == null) {
                return;
            }
            this.isShapeRoundRect = shapeAppearanceModel.isRoundRect(this.maskBounds);
        }

        @Override // com.google.android.material.carousel.MaskableFrameLayout.MaskableDelegate
        public void invalidateClippingMethod(View view) {
            updateIsShapeRoundRect();
            view.setClipToOutline(!shouldUseCompatClipping());
            if (shouldUseCompatClipping()) {
                view.invalidate();
            } else {
                view.invalidateOutline();
            }
        }

        @Override // com.google.android.material.carousel.MaskableFrameLayout.MaskableDelegate
        public boolean shouldUseCompatClipping() {
            return !this.isShapeRoundRect || this.forceCompatClippingEnabled;
        }
    }

    public static class MaskableDelegateV33 extends MaskableDelegate {
        public MaskableDelegateV33(View view) {
            super();
            initMaskOutlineProvider(view);
        }

        private void initMaskOutlineProvider(View view) {
            view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.google.android.material.carousel.MaskableFrameLayout.MaskableDelegateV33.1
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    if (MaskableDelegateV33.this.shapePath.isEmpty()) {
                        return;
                    }
                    outline.setPath(MaskableDelegateV33.this.shapePath);
                }
            });
        }

        @Override // com.google.android.material.carousel.MaskableFrameLayout.MaskableDelegate
        public void invalidateClippingMethod(View view) {
            view.setClipToOutline(!shouldUseCompatClipping());
            if (shouldUseCompatClipping()) {
                view.invalidate();
            } else {
                view.invalidateOutline();
            }
        }

        @Override // com.google.android.material.carousel.MaskableFrameLayout.MaskableDelegate
        public boolean shouldUseCompatClipping() {
            return this.forceCompatClippingEnabled;
        }
    }

    public MaskableFrameLayout(Context context) {
        this(context, null);
    }

    private MaskableDelegate createMaskableDelegate() {
        return Build.VERSION.SDK_INT >= 33 ? new MaskableDelegateV33(this) : new MaskableDelegateV22(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dispatchDraw$1(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ CornerSize lambda$setShapeAppearanceModel$0(CornerSize cornerSize) {
        return cornerSize instanceof AbsoluteCornerSize ? ClampedCornerSize.createFromCornerSize((AbsoluteCornerSize) cornerSize) : cornerSize;
    }

    private void onMaskChanged() {
        if (getWidth() == 0) {
            return;
        }
        float fLerp = AnimationUtils.lerp(0.0f, getWidth() / 2.0f, 0.0f, 1.0f, this.maskXPercentage);
        this.maskRect.set(fLerp, 0.0f, getWidth() - fLerp, getHeight());
        this.maskableDelegate.onMaskChanged(this, this.maskRect);
        OnMaskChangedListener onMaskChangedListener = this.onMaskChangedListener;
        if (onMaskChangedListener != null) {
            onMaskChangedListener.onMaskChanged(this.maskRect);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        this.maskableDelegate.maybeClip(canvas, new a(this));
    }

    @Override // com.google.android.material.carousel.Maskable
    public RectF getMaskRectF() {
        return this.maskRect;
    }

    @Override // com.google.android.material.carousel.Maskable
    public float getMaskXPercentage() {
        return this.maskXPercentage;
    }

    @Override // com.google.android.material.shape.Shapeable
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.shapeAppearanceModel;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Boolean bool = this.savedForceCompatClippingEnabled;
        if (bool != null) {
            this.maskableDelegate.setForceCompatClippingEnabled(this, bool.booleanValue());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.savedForceCompatClippingEnabled = Boolean.valueOf(this.maskableDelegate.isForceCompatClippingEnabled());
        this.maskableDelegate.setForceCompatClippingEnabled(this, true);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        onMaskChanged();
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.maskRect.isEmpty() && motionEvent.getAction() == 0) {
            if (!this.maskRect.contains(motionEvent.getX(), motionEvent.getY())) {
                return false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setForceCompatClipping(boolean z2) {
        this.maskableDelegate.setForceCompatClippingEnabled(this, z2);
    }

    @Override // com.google.android.material.carousel.Maskable
    public void setMaskXPercentage(float f2) {
        float fW = g.w(f2, 0.0f, 1.0f);
        if (this.maskXPercentage != fW) {
            this.maskXPercentage = fW;
            onMaskChanged();
        }
    }

    @Override // com.google.android.material.carousel.Maskable
    public void setOnMaskChangedListener(OnMaskChangedListener onMaskChangedListener) {
        this.onMaskChangedListener = onMaskChangedListener;
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        ShapeAppearanceModel shapeAppearanceModelWithTransformedCornerSizes = shapeAppearanceModel.withTransformedCornerSizes(new m());
        this.shapeAppearanceModel = shapeAppearanceModelWithTransformedCornerSizes;
        this.maskableDelegate.onShapeAppearanceChanged(this, shapeAppearanceModelWithTransformedCornerSizes);
    }

    public MaskableFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskableFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.maskXPercentage = 0.0f;
        this.maskRect = new RectF();
        this.maskableDelegate = createMaskableDelegate();
        this.savedForceCompatClippingEnabled = null;
        setShapeAppearanceModel(ShapeAppearanceModel.builder(context, attributeSet, i2, 0, 0).build());
    }
}
