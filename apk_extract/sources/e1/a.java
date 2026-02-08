package e1;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import x0.g;

/* loaded from: classes.dex */
public final class a extends d1.a {
    @Override // d1.a
    public final Random b() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        g.t(threadLocalRandomCurrent, "current()");
        return threadLocalRandomCurrent;
    }
}
