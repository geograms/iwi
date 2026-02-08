package kotlinx.coroutines.scheduling;

/* loaded from: classes.dex */
public final class j extends h {

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f2071c;

    public j(Runnable runnable, long j2, i iVar) {
        this.f2068a = j2;
        this.f2069b = iVar;
        this.f2071c = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f2071c.run();
        } finally {
            this.f2069b.getClass();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.f2071c;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(runnable)));
        sb.append(", ");
        sb.append(this.f2068a);
        sb.append(", ");
        sb.append(this.f2069b);
        sb.append(']');
        return sb.toString();
    }
}
