package y;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;

/* loaded from: classes.dex */
public final class l implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final EditText f2683a;

    /* renamed from: c, reason: collision with root package name */
    public k f2685c;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f2684b = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2686d = true;

    public l(EditText editText) {
        this.f2683a = editText;
    }

    public static void a(EditText editText, int i2) {
        int length;
        if (i2 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            androidx.emoji2.text.j jVarA = androidx.emoji2.text.j.a();
            if (editableText == null) {
                length = 0;
            } else {
                jVarA.getClass();
                length = editableText.length();
            }
            jVarA.f(0, length, editableText);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        EditText editText = this.f2683a;
        if (editText.isInEditMode() || !this.f2686d) {
            return;
        }
        if ((this.f2684b || androidx.emoji2.text.j.f373j != null) && i3 <= i4 && (charSequence instanceof Spannable)) {
            int iB = androidx.emoji2.text.j.a().b();
            if (iB != 0) {
                if (iB == 1) {
                    androidx.emoji2.text.j.a().f(i2, i4 + i2, (Spannable) charSequence);
                    return;
                } else if (iB != 3) {
                    return;
                }
            }
            androidx.emoji2.text.j jVarA = androidx.emoji2.text.j.a();
            if (this.f2685c == null) {
                this.f2685c = new k(editText);
            }
            jVarA.g(this.f2685c);
        }
    }
}
