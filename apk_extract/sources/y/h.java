package y;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class h extends c.c {

    /* renamed from: b, reason: collision with root package name */
    public final TextView f2677b;

    /* renamed from: c, reason: collision with root package name */
    public final f f2678c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2679d;

    public h(TextView textView) {
        super(13);
        this.f2677b = textView;
        this.f2679d = true;
        this.f2678c = new f(textView);
    }

    @Override // c.c
    public final InputFilter[] e(InputFilter[] inputFilterArr) {
        if (!this.f2679d) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i2 = 0; i2 < inputFilterArr.length; i2++) {
                InputFilter inputFilter = inputFilterArr[i2];
                if (inputFilter instanceof f) {
                    sparseArray.put(i2, inputFilter);
                }
            }
            if (sparseArray.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
            int i3 = 0;
            for (int i4 = 0; i4 < length; i4++) {
                if (sparseArray.indexOfKey(i4) < 0) {
                    inputFilterArr2[i3] = inputFilterArr[i4];
                    i3++;
                }
            }
            return inputFilterArr2;
        }
        int length2 = inputFilterArr.length;
        int i5 = 0;
        while (true) {
            f fVar = this.f2678c;
            if (i5 >= length2) {
                InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                inputFilterArr3[length2] = fVar;
                return inputFilterArr3;
            }
            if (inputFilterArr[i5] == fVar) {
                return inputFilterArr;
            }
            i5++;
        }
    }

    @Override // c.c
    public final boolean j() {
        return this.f2679d;
    }

    @Override // c.c
    public final void k(boolean z2) {
        if (z2) {
            TextView textView = this.f2677b;
            textView.setTransformationMethod(p(textView.getTransformationMethod()));
        }
    }

    @Override // c.c
    public final void n(boolean z2) {
        this.f2679d = z2;
        TextView textView = this.f2677b;
        textView.setTransformationMethod(p(textView.getTransformationMethod()));
        textView.setFilters(e(textView.getFilters()));
    }

    @Override // c.c
    public final TransformationMethod p(TransformationMethod transformationMethod) {
        return this.f2679d ? ((transformationMethod instanceof m) || (transformationMethod instanceof PasswordTransformationMethod)) ? transformationMethod : new m(transformationMethod) : transformationMethod instanceof m ? ((m) transformationMethod).f2687a : transformationMethod;
    }
}
