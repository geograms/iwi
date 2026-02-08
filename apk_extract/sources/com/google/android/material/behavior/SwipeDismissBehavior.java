package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.c;
import androidx.core.view.d1;
import androidx.core.view.m0;
import androidx.core.view.n0;
import androidx.customview.widget.g;
import androidx.customview.widget.h;
import java.util.WeakHashMap;
import r.f;
import r.n;
import r.v;

/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends c {
    private static final float DEFAULT_ALPHA_END_DISTANCE = 0.5f;
    private static final float DEFAULT_ALPHA_START_DISTANCE = 0.0f;
    private static final float DEFAULT_DRAG_DISMISS_THRESHOLD = 0.5f;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    public static final int SWIPE_DIRECTION_ANY = 2;
    public static final int SWIPE_DIRECTION_END_TO_START = 1;
    public static final int SWIPE_DIRECTION_START_TO_END = 0;
    private boolean interceptingEvents;
    OnDismissListener listener;
    private boolean requestingDisallowInterceptTouchEvent;
    private boolean sensitivitySet;
    h viewDragHelper;
    private float sensitivity = DEFAULT_ALPHA_START_DISTANCE;
    int swipeDirection = 2;
    float dragDismissThreshold = 0.5f;
    float alphaStartSwipeDistance = DEFAULT_ALPHA_START_DISTANCE;
    float alphaEndSwipeDistance = 0.5f;
    private final g dragCallback = new g() { // from class: com.google.android.material.behavior.SwipeDismissBehavior.1
        private static final int INVALID_POINTER_ID = -1;
        private int activePointerId = -1;
        private int originalCapturedViewLeft;

        private boolean shouldDismiss(View view, float f2) {
            if (f2 == SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE) {
                return Math.abs(view.getLeft() - this.originalCapturedViewLeft) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.dragDismissThreshold);
            }
            WeakHashMap weakHashMap = d1.f138a;
            boolean z2 = n0.d(view) == 1;
            int i2 = SwipeDismissBehavior.this.swipeDirection;
            if (i2 == 2) {
                return true;
            }
            if (i2 == 0) {
                if (z2) {
                    if (f2 >= SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE) {
                        return false;
                    }
                } else if (f2 <= SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE) {
                    return false;
                }
                return true;
            }
            if (i2 != 1) {
                return false;
            }
            if (z2) {
                if (f2 <= SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE) {
                    return false;
                }
            } else if (f2 >= SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE) {
                return false;
            }
            return true;
        }

        @Override // androidx.customview.widget.g
        public int clampViewPositionHorizontal(View view, int i2, int i3) {
            int width;
            int width2;
            int width3;
            WeakHashMap weakHashMap = d1.f138a;
            boolean z2 = n0.d(view) == 1;
            int i4 = SwipeDismissBehavior.this.swipeDirection;
            if (i4 == 0) {
                if (z2) {
                    width = this.originalCapturedViewLeft - view.getWidth();
                    width2 = this.originalCapturedViewLeft;
                } else {
                    width = this.originalCapturedViewLeft;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i4 != 1) {
                width = this.originalCapturedViewLeft - view.getWidth();
                width2 = this.originalCapturedViewLeft + view.getWidth();
            } else if (z2) {
                width = this.originalCapturedViewLeft;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.originalCapturedViewLeft - view.getWidth();
                width2 = this.originalCapturedViewLeft;
            }
            return SwipeDismissBehavior.clamp(width, i2, width2);
        }

        @Override // androidx.customview.widget.g
        public int clampViewPositionVertical(View view, int i2, int i3) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.g
        public int getViewHorizontalDragRange(View view) {
            return view.getWidth();
        }

        @Override // androidx.customview.widget.g
        public void onViewCaptured(View view, int i2) {
            this.activePointerId = i2;
            this.originalCapturedViewLeft = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                SwipeDismissBehavior.this.requestingDisallowInterceptTouchEvent = true;
                parent.requestDisallowInterceptTouchEvent(true);
                SwipeDismissBehavior.this.requestingDisallowInterceptTouchEvent = false;
            }
        }

        @Override // androidx.customview.widget.g
        public void onViewDragStateChanged(int i2) {
            OnDismissListener onDismissListener = SwipeDismissBehavior.this.listener;
            if (onDismissListener != null) {
                onDismissListener.onDragStateChanged(i2);
            }
        }

        @Override // androidx.customview.widget.g
        public void onViewPositionChanged(View view, int i2, int i3, int i4, int i5) {
            float width = view.getWidth() * SwipeDismissBehavior.this.alphaStartSwipeDistance;
            float width2 = view.getWidth() * SwipeDismissBehavior.this.alphaEndSwipeDistance;
            float fAbs = Math.abs(i2 - this.originalCapturedViewLeft);
            if (fAbs <= width) {
                view.setAlpha(1.0f);
            } else if (fAbs >= width2) {
                view.setAlpha(SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE);
            } else {
                view.setAlpha(SwipeDismissBehavior.clamp(SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE, 1.0f - SwipeDismissBehavior.fraction(width, width2, fAbs), 1.0f));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
        @Override // androidx.customview.widget.g
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void onViewReleased(android.view.View r3, float r4, float r5) {
            /*
                r2 = this;
                r5 = -1
                r2.activePointerId = r5
                int r5 = r3.getWidth()
                boolean r0 = r2.shouldDismiss(r3, r4)
                if (r0 == 0) goto L23
                r0 = 0
                int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r4 < 0) goto L1d
                int r4 = r3.getLeft()
                int r0 = r2.originalCapturedViewLeft
                if (r4 >= r0) goto L1b
                goto L1d
            L1b:
                int r0 = r0 + r5
                goto L21
            L1d:
                int r4 = r2.originalCapturedViewLeft
                int r0 = r4 - r5
            L21:
                r4 = 1
                goto L26
            L23:
                int r0 = r2.originalCapturedViewLeft
                r4 = 0
            L26:
                com.google.android.material.behavior.SwipeDismissBehavior r5 = com.google.android.material.behavior.SwipeDismissBehavior.this
                androidx.customview.widget.h r5 = r5.viewDragHelper
                int r1 = r3.getTop()
                boolean r5 = r5.r(r0, r1)
                if (r5 == 0) goto L41
                com.google.android.material.behavior.SwipeDismissBehavior$SettleRunnable r5 = new com.google.android.material.behavior.SwipeDismissBehavior$SettleRunnable
                com.google.android.material.behavior.SwipeDismissBehavior r2 = com.google.android.material.behavior.SwipeDismissBehavior.this
                r5.<init>(r3, r4)
                java.util.WeakHashMap r2 = androidx.core.view.d1.f138a
                androidx.core.view.m0.m(r3, r5)
                goto L4c
            L41:
                if (r4 == 0) goto L4c
                com.google.android.material.behavior.SwipeDismissBehavior r2 = com.google.android.material.behavior.SwipeDismissBehavior.this
                com.google.android.material.behavior.SwipeDismissBehavior$OnDismissListener r2 = r2.listener
                if (r2 == 0) goto L4c
                r2.onDismiss(r3)
            L4c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.AnonymousClass1.onViewReleased(android.view.View, float, float):void");
        }

        @Override // androidx.customview.widget.g
        public boolean tryCaptureView(View view, int i2) {
            int i3 = this.activePointerId;
            return (i3 == -1 || i3 == i2) && SwipeDismissBehavior.this.canSwipeDismissView(view);
        }
    };

    public interface OnDismissListener {
        void onDismiss(View view);

        void onDragStateChanged(int i2);
    }

    public class SettleRunnable implements Runnable {
        private final boolean dismiss;
        private final View view;

        public SettleRunnable(View view, boolean z2) {
            this.view = view;
            this.dismiss = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            OnDismissListener onDismissListener;
            h hVar = SwipeDismissBehavior.this.viewDragHelper;
            if (hVar != null && hVar.g()) {
                View view = this.view;
                WeakHashMap weakHashMap = d1.f138a;
                m0.m(view, this);
            } else {
                if (!this.dismiss || (onDismissListener = SwipeDismissBehavior.this.listener) == null) {
                    return;
                }
                onDismissListener.onDismiss(this.view);
            }
        }
    }

    public static float clamp(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    private void ensureViewDragHelper(ViewGroup viewGroup) {
        h hVar;
        if (this.viewDragHelper == null) {
            if (this.sensitivitySet) {
                hVar = h.h(viewGroup, this.sensitivity, this.dragCallback);
            } else {
                hVar = new h(viewGroup.getContext(), viewGroup, this.dragCallback);
            }
            this.viewDragHelper = hVar;
        }
    }

    public static float fraction(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }

    private void updateAccessibilityActions(View view) {
        d1.i(1048576, view);
        d1.g(0, view);
        if (canSwipeDismissView(view)) {
            d1.j(view, f.f2499l, null, new v() { // from class: com.google.android.material.behavior.SwipeDismissBehavior.2
                @Override // r.v
                public boolean perform(View view2, n nVar) {
                    if (!SwipeDismissBehavior.this.canSwipeDismissView(view2)) {
                        return false;
                    }
                    WeakHashMap weakHashMap = d1.f138a;
                    boolean z2 = n0.d(view2) == 1;
                    int i2 = SwipeDismissBehavior.this.swipeDirection;
                    view2.offsetLeftAndRight((!(i2 == 0 && z2) && (i2 != 1 || z2)) ? view2.getWidth() : -view2.getWidth());
                    view2.setAlpha(SwipeDismissBehavior.DEFAULT_ALPHA_START_DISTANCE);
                    OnDismissListener onDismissListener = SwipeDismissBehavior.this.listener;
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(view2);
                    }
                    return true;
                }
            });
        }
    }

    public boolean canSwipeDismissView(View view) {
        return true;
    }

    public int getDragState() {
        h hVar = this.viewDragHelper;
        if (hVar != null) {
            return hVar.f267a;
        }
        return 0;
    }

    public OnDismissListener getListener() {
        return this.listener;
    }

    @Override // androidx.coordinatorlayout.widget.c
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        boolean zIsPointInChildBounds = this.interceptingEvents;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zIsPointInChildBounds = coordinatorLayout.isPointInChildBounds(v2, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.interceptingEvents = zIsPointInChildBounds;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.interceptingEvents = false;
        }
        if (!zIsPointInChildBounds) {
            return false;
        }
        ensureViewDragHelper(coordinatorLayout);
        return !this.requestingDisallowInterceptTouchEvent && this.viewDragHelper.s(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.c
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v2, int i2) {
        boolean zOnLayoutChild = super.onLayoutChild(coordinatorLayout, v2, i2);
        WeakHashMap weakHashMap = d1.f138a;
        if (m0.c(v2) == 0) {
            m0.s(v2, 1);
            updateAccessibilityActions(v2);
        }
        return zOnLayoutChild;
    }

    @Override // androidx.coordinatorlayout.widget.c
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        if (this.viewDragHelper == null) {
            return false;
        }
        if (this.requestingDisallowInterceptTouchEvent && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.viewDragHelper.l(motionEvent);
        return true;
    }

    public void setDragDismissDistance(float f2) {
        this.dragDismissThreshold = clamp(DEFAULT_ALPHA_START_DISTANCE, f2, 1.0f);
    }

    public void setEndAlphaSwipeDistance(float f2) {
        this.alphaEndSwipeDistance = clamp(DEFAULT_ALPHA_START_DISTANCE, f2, 1.0f);
    }

    public void setListener(OnDismissListener onDismissListener) {
        this.listener = onDismissListener;
    }

    public void setSensitivity(float f2) {
        this.sensitivity = f2;
        this.sensitivitySet = true;
    }

    public void setStartAlphaSwipeDistance(float f2) {
        this.alphaStartSwipeDistance = clamp(DEFAULT_ALPHA_START_DISTANCE, f2, 1.0f);
    }

    public void setSwipeDirection(int i2) {
        this.swipeDirection = i2;
    }

    public static int clamp(int i2, int i3, int i4) {
        return Math.min(Math.max(i2, i3), i4);
    }
}
