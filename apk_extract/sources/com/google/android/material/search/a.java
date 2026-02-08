package com.google.android.material.search;

import android.animation.Animator;
import android.app.Dialog;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.chamsion.quickchat.R;
import com.chamsion.quickchat.ui.FragmentLocalDeviceAreaListActivity;
import com.google.android.material.animation.AnimatableView;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.carousel.MaskableFrameLayout;
import k0.o;
import k0.t;
import r.n;
import r.v;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements r.d, AnimatableView.Listener, f.a, o, v, CanvasCompat.CanvasOperation {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f1575a;

    public /* synthetic */ a(Object obj) {
        this.f1575a = obj;
    }

    @Override // k0.o
    public void a(k0.a aVar, int i2) {
        FragmentLocalDeviceAreaListActivity fragmentLocalDeviceAreaListActivity = (FragmentLocalDeviceAreaListActivity) this.f1575a;
        fragmentLocalDeviceAreaListActivity.f1367e = i2;
        View viewInflate = LayoutInflater.from(fragmentLocalDeviceAreaListActivity).inflate(R.layout.local_device_area_dialog, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.local_device_area_dialog_use);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.local_device_area_dialog_edit);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.local_device_area_dialog_delete);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.local_device_area_dialog_reset);
        textView.setOnClickListener(fragmentLocalDeviceAreaListActivity);
        textView2.setOnClickListener(fragmentLocalDeviceAreaListActivity);
        textView3.setOnClickListener(fragmentLocalDeviceAreaListActivity);
        textView4.setOnClickListener(fragmentLocalDeviceAreaListActivity);
        textView.setVisibility(8);
        textView4.setVisibility(8);
        if (((k0.a) fragmentLocalDeviceAreaListActivity.f1366d.get(i2)).f1942f) {
            textView3.setVisibility(8);
        } else {
            textView3.setVisibility(0);
        }
        Dialog dialog = new Dialog(fragmentLocalDeviceAreaListActivity);
        fragmentLocalDeviceAreaListActivity.f1368f = dialog;
        dialog.setContentView(viewInflate);
        Dialog dialog2 = fragmentLocalDeviceAreaListActivity.f1368f;
        int i3 = fragmentLocalDeviceAreaListActivity.getResources().getDisplayMetrics().widthPixels;
        Window window = dialog2.getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.y = 100;
            attributes.width = (int) (i3 * 0.9f);
            window.setAttributes(attributes);
            window.setBackgroundDrawableResource(android.R.color.transparent);
        }
        fragmentLocalDeviceAreaListActivity.f1368f.show();
    }

    @Override // f.a
    public Object apply(Object obj) {
        return ((t) this.f1575a).f2013a.a(((Integer) obj).intValue());
    }

    @Override // com.google.android.material.animation.AnimatableView.Listener
    public void onAnimationEnd() {
        ((Animator) this.f1575a).start();
    }

    @Override // r.d
    public void onTouchExplorationStateChanged(boolean z2) {
        ((SearchBar) this.f1575a).lambda$new$0(z2);
    }

    @Override // r.v
    public boolean perform(View view, n nVar) {
        return ((BottomSheetDragHandleView) this.f1575a).lambda$onBottomSheetStateChanged$0(view, null);
    }

    @Override // com.google.android.material.canvas.CanvasCompat.CanvasOperation
    public void run(Canvas canvas) {
        ((MaskableFrameLayout) this.f1575a).lambda$dispatchDraw$1(canvas);
    }
}
