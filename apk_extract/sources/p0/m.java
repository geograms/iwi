package p0;

import android.text.Editable;
import com.chamsion.quickchat.ui.ChatActivity;
import com.chamsion.quickchat.ui.FragmentLocalSettingsActivity;
import com.google.android.material.carousel.MaskableFrameLayout;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.textfield.TextInputLayout;
import com.wonder.dmr.OnEnhancementsListener;

/* loaded from: classes.dex */
public final /* synthetic */ class m implements n0.l, OnEnhancementsListener, ShapeAppearanceModel.CornerSizeUnaryOperator, TextInputLayout.LengthCounter {
    @Override // com.wonder.dmr.OnEnhancementsListener, com.wonder.dmr.OnUpgradeModeListener, com.wonder.dmr.OnTransferInterruptListener
    public final void OnCallback(int i2) {
        int i3 = FragmentLocalSettingsActivity.M;
    }

    @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
    public final CornerSize apply(CornerSize cornerSize) {
        return MaskableFrameLayout.lambda$setShapeAppearanceModel$0(cornerSize);
    }

    @Override // com.google.android.material.textfield.TextInputLayout.LengthCounter
    public final int countLength(Editable editable) {
        return TextInputLayout.lambda$new$0(editable);
    }

    @Override // n0.l
    public final void f() {
        int i2 = ChatActivity.f1335n;
    }
}
