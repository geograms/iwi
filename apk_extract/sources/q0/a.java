package q0;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import x0.g;

/* loaded from: classes.dex */
public final class a implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2479a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f2480b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f2481c;

    public a(c cVar, int i2, b bVar) {
        this.f2481c = cVar;
        this.f2479a = i2;
        this.f2480b = bVar;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        c cVar = this.f2481c;
        cVar.f2485b.set(cVar.f2486c, cVar.f2487d + "");
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        int i5 = this.f2479a;
        c cVar = this.f2481c;
        cVar.f2486c = i5;
        int length = charSequence.toString().length();
        ImageView imageView = this.f2480b.f2483b;
        if (!g.Y(charSequence.toString())) {
            imageView.setVisibility(0);
        } else if (length > 0) {
            int iIntValue = Integer.valueOf(charSequence.toString()).intValue();
            if (iIntValue < 0 || iIntValue > 16776415) {
                imageView.setVisibility(0);
            } else {
                cVar.f2487d = iIntValue;
                imageView.setVisibility(8);
            }
        } else {
            imageView.setVisibility(0);
            cVar.f2487d = 0;
        }
        cVar.f2485b.set(cVar.f2486c, cVar.f2487d + "");
    }
}
