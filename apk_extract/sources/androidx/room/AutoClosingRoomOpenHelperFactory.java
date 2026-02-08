package androidx.room;

/* loaded from: classes.dex */
public final class AutoClosingRoomOpenHelperFactory implements c0.g {
    private final AutoCloser autoCloser;
    private final c0.g delegate;

    public AutoClosingRoomOpenHelperFactory(c0.g gVar, AutoCloser autoCloser) {
        x0.g.u(gVar, "delegate");
        x0.g.u(autoCloser, "autoCloser");
        this.delegate = gVar;
        this.autoCloser = autoCloser;
    }

    @Override // c0.g
    public AutoClosingRoomOpenHelper create(c0.f fVar) {
        x0.g.u(fVar, "configuration");
        return new AutoClosingRoomOpenHelper(this.delegate.create(fVar), this.autoCloser);
    }
}
