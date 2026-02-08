package x0;

import c1.p;

/* loaded from: classes.dex */
public abstract class a implements h {
    private final i key;

    public a(i iVar) {
        this.key = iVar;
    }

    @Override // x0.j
    public <R> R fold(R r2, p pVar) {
        g.u(pVar, "operation");
        return (R) pVar.a(r2, this);
    }

    @Override // x0.j
    public <E extends h> E get(i iVar) {
        g.u(iVar, "key");
        if (g.g(getKey(), iVar)) {
            return this;
        }
        return null;
    }

    @Override // x0.h
    public i getKey() {
        return this.key;
    }

    @Override // x0.j
    public j minusKey(i iVar) {
        g.u(iVar, "key");
        return g.g(getKey(), iVar) ? k.f2662a : this;
    }

    public j plus(j jVar) {
        g.u(jVar, "context");
        return jVar == k.f2662a ? this : (j) jVar.fold(this, c.f2655c);
    }
}
