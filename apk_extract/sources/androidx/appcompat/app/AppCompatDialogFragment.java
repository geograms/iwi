package androidx.appcompat.app;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.q;

/* loaded from: classes.dex */
public class AppCompatDialogFragment extends q {
    public AppCompatDialogFragment() {
    }

    @Override // androidx.fragment.app.q
    public Dialog onCreateDialog(Bundle bundle) {
        return new AppCompatDialog(getContext(), getTheme());
    }

    @Override // androidx.fragment.app.q
    public void setupDialog(Dialog dialog, int i2) {
        if (!(dialog instanceof AppCompatDialog)) {
            super.setupDialog(dialog, i2);
            return;
        }
        AppCompatDialog appCompatDialog = (AppCompatDialog) dialog;
        if (i2 != 1 && i2 != 2) {
            if (i2 != 3) {
                return;
            } else {
                dialog.getWindow().addFlags(24);
            }
        }
        appCompatDialog.supportRequestWindowFeature(1);
    }

    public AppCompatDialogFragment(int i2) {
        super(i2);
    }
}
