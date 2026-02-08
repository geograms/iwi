package p0;

import android.text.Editable;
import android.text.TextWatcher;
import com.chamsion.quickchat.R;
import com.chamsion.quickchat.ui.AddNewChannelActivity;

/* loaded from: classes.dex */
public final class d implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2298a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AddNewChannelActivity f2299b;

    public /* synthetic */ d(AddNewChannelActivity addNewChannelActivity, int i2) {
        this.f2298a = i2;
        this.f2299b = addNewChannelActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        switch (this.f2298a) {
            case 0:
            case 1:
            case 2:
                break;
            default:
                String string = editable.toString();
                int length = string.length();
                AddNewChannelActivity addNewChannelActivity = this.f2299b;
                if (length != 8) {
                    if (string.length() <= 8) {
                        if (!x0.g.Y(string)) {
                            addNewChannelActivity.f1270f.setVisibility(0);
                            break;
                        } else {
                            addNewChannelActivity.f1270f.setVisibility(0);
                            break;
                        }
                    } else {
                        addNewChannelActivity.f1270f.setVisibility(0);
                        break;
                    }
                } else if (!x0.g.Y(string)) {
                    addNewChannelActivity.f1270f.setVisibility(0);
                    break;
                } else {
                    addNewChannelActivity.f1295r0 = string;
                    addNewChannelActivity.f1270f.setVisibility(8);
                    break;
                }
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        int i5 = this.f2298a;
        AddNewChannelActivity addNewChannelActivity = this.f2299b;
        switch (i5) {
            case 0:
                if (charSequence.toString().length() <= 0) {
                    addNewChannelActivity.f1268e.setVisibility(0);
                    break;
                } else {
                    addNewChannelActivity.f1265c0 = addNewChannelActivity.M.getText().toString().trim();
                    addNewChannelActivity.f1268e.setVisibility(8);
                    break;
                }
            case 1:
                int length = charSequence.toString().length();
                if (!x0.g.Y(charSequence.toString())) {
                    addNewChannelActivity.Q.setError(addNewChannelActivity.getString(R.string.only_input_num));
                    AddNewChannelActivity.g(addNewChannelActivity.Q);
                    break;
                } else if (length != 9) {
                    int i6 = AddNewChannelActivity.I0;
                    if (i6 != 0) {
                        if (i6 == 1) {
                            addNewChannelActivity.Q.setError("136M~174M");
                            AddNewChannelActivity.g(addNewChannelActivity.Q);
                            break;
                        }
                    } else {
                        addNewChannelActivity.Q.setError("400M~480M");
                        AddNewChannelActivity.g(addNewChannelActivity.Q);
                        break;
                    }
                } else {
                    int iIntValue = Integer.valueOf(charSequence.toString()).intValue();
                    int i7 = AddNewChannelActivity.I0;
                    if (i7 != 0) {
                        if (i7 == 1) {
                            if (iIntValue >= 136000000 && iIntValue <= 174000000) {
                                addNewChannelActivity.f1299t0 = iIntValue;
                                addNewChannelActivity.Q.setError(null);
                                break;
                            } else {
                                addNewChannelActivity.f1299t0 = iIntValue;
                                addNewChannelActivity.Q.setError(addNewChannelActivity.getString(R.string.out_range));
                                AddNewChannelActivity.g(addNewChannelActivity.Q);
                                break;
                            }
                        }
                    } else if (iIntValue >= 400000000 && iIntValue <= 480000000) {
                        addNewChannelActivity.f1299t0 = iIntValue;
                        addNewChannelActivity.Q.setError(null);
                        break;
                    } else {
                        addNewChannelActivity.f1299t0 = iIntValue;
                        addNewChannelActivity.Q.setError(addNewChannelActivity.getString(R.string.out_range));
                        AddNewChannelActivity.g(addNewChannelActivity.Q);
                        break;
                    }
                }
                break;
            case 2:
                int length2 = charSequence.toString().length();
                if (!x0.g.Y(charSequence.toString())) {
                    addNewChannelActivity.R.setError(addNewChannelActivity.getString(R.string.only_input_num));
                    AddNewChannelActivity.g(addNewChannelActivity.R);
                    break;
                } else if (length2 != 9) {
                    int i8 = AddNewChannelActivity.I0;
                    if (i8 != 0) {
                        if (i8 == 1) {
                            addNewChannelActivity.R.setError("136M~174M");
                            AddNewChannelActivity.g(addNewChannelActivity.R);
                            break;
                        }
                    } else {
                        addNewChannelActivity.R.setError("400M~480M");
                        AddNewChannelActivity.g(addNewChannelActivity.R);
                        break;
                    }
                } else {
                    int iIntValue2 = Integer.valueOf(charSequence.toString()).intValue();
                    int i9 = AddNewChannelActivity.I0;
                    if (i9 != 0) {
                        if (i9 == 1) {
                            if (iIntValue2 >= 136000000 && iIntValue2 <= 174000000) {
                                addNewChannelActivity.f1297s0 = iIntValue2;
                                addNewChannelActivity.R.setError(null);
                                break;
                            } else {
                                addNewChannelActivity.f1297s0 = iIntValue2;
                                addNewChannelActivity.R.setError(addNewChannelActivity.getString(R.string.out_range));
                                AddNewChannelActivity.g(addNewChannelActivity.R);
                                break;
                            }
                        }
                    } else if (iIntValue2 >= 400000000 && iIntValue2 <= 480000000) {
                        addNewChannelActivity.f1297s0 = iIntValue2;
                        addNewChannelActivity.R.setError(null);
                        break;
                    } else {
                        addNewChannelActivity.f1297s0 = iIntValue2;
                        addNewChannelActivity.R.setError(addNewChannelActivity.getString(R.string.out_range));
                        AddNewChannelActivity.g(addNewChannelActivity.R);
                        break;
                    }
                }
                break;
        }
    }
}
