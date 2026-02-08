package o;

/* loaded from: classes.dex */
public class j implements q.d {

    /* renamed from: a, reason: collision with root package name */
    public int f2234a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f2235b;

    public j(int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f2235b = new Object[i2];
    }

    @Override // q.d
    public Object acquire() {
        int i2 = this.f2234a;
        if (i2 <= 0) {
            return null;
        }
        int i3 = i2 - 1;
        Object[] objArr = this.f2235b;
        Object obj = objArr[i3];
        objArr[i3] = null;
        this.f2234a = i2 - 1;
        return obj;
    }

    @Override // q.d
    public boolean release(Object obj) {
        int i2 = 0;
        while (true) {
            int i3 = this.f2234a;
            Object[] objArr = this.f2235b;
            if (i2 >= i3) {
                if (i3 >= objArr.length) {
                    return false;
                }
                objArr[i3] = obj;
                this.f2234a = i3 + 1;
                return true;
            }
            if (objArr[i2] == obj) {
                throw new IllegalStateException("Already in the pool!");
            }
            i2++;
        }
    }

    public j(int i2, k[] kVarArr) {
        this.f2234a = i2;
        this.f2235b = kVarArr;
    }
}
