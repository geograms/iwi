package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class c implements g1.b, Serializable {
    public static final Object NO_RECEIVER = b.f2037a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner = c0.b.class;
    protected final Object receiver;
    private transient g1.b reflected;
    private final String signature;

    public c(Object obj, String str, String str2, boolean z2) {
        this.receiver = obj;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z2;
    }

    @Override // g1.b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // g1.b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public g1.b compute() {
        g1.b bVar = this.reflected;
        if (bVar != null) {
            return bVar;
        }
        g1.b bVarComputeReflected = computeReflected();
        this.reflected = bVarComputeReflected;
        return bVarComputeReflected;
    }

    public abstract g1.b computeReflected();

    @Override // g1.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public g1.d getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        if (this.isTopLevel) {
            r.f2043a.getClass();
            return new m(cls);
        }
        r.f2043a.getClass();
        return new e(cls);
    }

    @Override // g1.b
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    public abstract g1.b getReflected();

    @Override // g1.b
    public g1.m getReturnType() {
        getReflected().getReturnType();
        return null;
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // g1.b
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // g1.b
    public g1.n getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // g1.b
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // g1.b
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // g1.b
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // g1.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}
