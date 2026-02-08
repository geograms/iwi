package androidx.emoji2.text;

import android.content.Context;
import android.os.Looper;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public class EmojiCompatInitializer implements f0.b {
    @Override // f0.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Boolean create(Context context) {
        Object objB;
        s sVar = new s(new k.j(context));
        sVar.f370b = 1;
        if (j.f373j == null) {
            synchronized (j.f372i) {
                try {
                    if (j.f373j == null) {
                        j.f373j = new j(sVar);
                    }
                } finally {
                }
            }
        }
        f0.a aVarC = f0.a.c(context);
        aVarC.getClass();
        synchronized (f0.a.f1759e) {
            try {
                objB = aVarC.f1760a.get(ProcessLifecycleInitializer.class);
                if (objB == null) {
                    objB = aVarC.b(ProcessLifecycleInitializer.class, new HashSet());
                }
            } finally {
            }
        }
        final Lifecycle lifecycle = ((LifecycleOwner) objB).getLifecycle();
        lifecycle.addObserver(new DefaultLifecycleObserver() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @Override // androidx.lifecycle.DefaultLifecycleObserver, androidx.lifecycle.FullLifecycleObserver
            public final void onResume(LifecycleOwner lifecycleOwner) {
                EmojiCompatInitializer.this.getClass();
                b.a(Looper.getMainLooper()).postDelayed(new m(), 500L);
                lifecycle.removeObserver(this);
            }
        });
        return Boolean.TRUE;
    }

    @Override // f0.b
    public final List dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }
}
