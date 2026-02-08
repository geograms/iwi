package kotlin.jvm.internal;

/* loaded from: classes.dex */
public abstract class h extends c implements g1.e {
    private final int arity;
    private final int flags;

    public h(Object obj, String str, String str2) {
        super(obj, str, str2, false);
        this.arity = 1;
        this.flags = 0;
    }

    @Override // kotlin.jvm.internal.c
    public g1.b computeReflected() {
        r.f2043a.getClass();
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            return getName().equals(hVar.getName()) && getSignature().equals(hVar.getSignature()) && this.flags == hVar.flags && this.arity == hVar.arity && x0.g.g(getBoundReceiver(), hVar.getBoundReceiver()) && x0.g.g(getOwner(), hVar.getOwner());
        }
        if (obj instanceof g1.e) {
            return obj.equals(compute());
        }
        return false;
    }

    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner() == null ? 0 : getOwner().hashCode() * 31)) * 31);
    }

    @Override // g1.e
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // g1.e
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // g1.e
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // g1.e
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.jvm.internal.c, g1.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        g1.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    @Override // kotlin.jvm.internal.c
    public g1.e getReflected() {
        g1.b bVarCompute = compute();
        if (bVarCompute != this) {
            return (g1.e) bVarCompute;
        }
        throw new b1.a("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }
}
