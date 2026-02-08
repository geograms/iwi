package kotlin.jvm.internal;

/* loaded from: classes.dex */
public abstract class p extends c implements g1.l {
    private final boolean syntheticJavaProperty;

    public p(Object obj, String str, String str2) {
        super(obj, str, str2, false);
        this.syntheticJavaProperty = false;
    }

    @Override // kotlin.jvm.internal.c
    public g1.b compute() {
        return this.syntheticJavaProperty ? this : super.compute();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            return getOwner().equals(pVar.getOwner()) && getName().equals(pVar.getName()) && getSignature().equals(pVar.getSignature()) && x0.g.g(getBoundReceiver(), pVar.getBoundReceiver());
        }
        if (obj instanceof g1.l) {
            return obj.equals(compute());
        }
        return false;
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner().hashCode() * 31)) * 31);
    }

    @Override // g1.l
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // g1.l
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        g1.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    @Override // kotlin.jvm.internal.c
    public g1.l getReflected() {
        if (this.syntheticJavaProperty) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties");
        }
        g1.b bVarCompute = compute();
        if (bVarCompute != this) {
            return (g1.l) bVarCompute;
        }
        throw new b1.a("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }
}
