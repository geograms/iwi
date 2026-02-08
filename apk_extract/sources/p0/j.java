package p0;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import com.chamsion.quickchat.R;
import com.chamsion.quickchat.ui.AddNewContactsActivity;

/* loaded from: classes.dex */
public final class j implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2350a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AddNewContactsActivity f2351b;

    public /* synthetic */ j(AddNewContactsActivity addNewContactsActivity, int i2) {
        this.f2350a = i2;
        this.f2351b = addNewContactsActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        int i5 = this.f2350a;
        AddNewContactsActivity addNewContactsActivity = this.f2351b;
        switch (i5) {
            case 0:
                int length = charSequence.toString().length();
                Log.d(addNewContactsActivity.f1313a, "beforeTextChanged, l " + length);
                if (length > 0 && length < 9) {
                    if (!x0.g.Y(charSequence.toString())) {
                        addNewContactsActivity.f1324l.setError(addNewContactsActivity.f1327o.getString(R.string.only_input_num));
                        break;
                    } else if (length <= 8) {
                        int iIntValue = Integer.valueOf(charSequence.toString()).intValue();
                        if (iIntValue <= 16776415 && iIntValue >= 1) {
                            Log.d(addNewContactsActivity.f1313a, "beforeTextChanged, " + charSequence.toString());
                            addNewContactsActivity.f1326n = iIntValue;
                            break;
                        } else {
                            addNewContactsActivity.f1324l.setError(addNewContactsActivity.f1327o.getString(R.string.out_range));
                            addNewContactsActivity.f1326n = iIntValue;
                            break;
                        }
                    }
                } else {
                    addNewContactsActivity.f1324l.setError(addNewContactsActivity.f1327o.getString(R.string.out_range));
                    break;
                }
                break;
            default:
                int length2 = charSequence.toString().length();
                Log.d(addNewContactsActivity.f1313a, "beforeTextChanged, l " + length2);
                if (length2 == 0) {
                    addNewContactsActivity.f1323k.setError(addNewContactsActivity.f1327o.getString(R.string.cannot_be_empty));
                    break;
                }
                break;
        }
    }
}
