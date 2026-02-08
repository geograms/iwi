package androidx.appcompat.widget;

import android.view.View;

/* loaded from: classes.dex */
public class TooltipCompat {

    public static class Api26Impl {
        private Api26Impl() {
        }

        public static void setTooltipText(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    private TooltipCompat() {
    }

    public static void setTooltipText(View view, CharSequence charSequence) {
        Api26Impl.setTooltipText(view, charSequence);
    }
}
