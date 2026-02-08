package y;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes.dex */
public final class a extends c.c {

    /* renamed from: b, reason: collision with root package name */
    public final EditText f2663b;

    /* renamed from: c, reason: collision with root package name */
    public final l f2664c;

    public a(EditText editText) {
        this.f2663b = editText;
        l lVar = new l(editText);
        this.f2664c = lVar;
        editText.addTextChangedListener(lVar);
        if (c.f2667b == null) {
            synchronized (c.f2666a) {
                try {
                    if (c.f2667b == null) {
                        c cVar = new c();
                        try {
                            c.f2668c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, c.class.getClassLoader());
                        } catch (Throwable unused) {
                        }
                        c.f2667b = cVar;
                    }
                } finally {
                }
            }
        }
        editText.setEditableFactory(c.f2667b);
    }

    @Override // c.c
    public final boolean j() {
        return this.f2664c.f2686d;
    }

    @Override // c.c
    public final void n(boolean z2) {
        l lVar = this.f2664c;
        if (lVar.f2686d != z2) {
            if (lVar.f2685c != null) {
                androidx.emoji2.text.j jVarA = androidx.emoji2.text.j.a();
                k kVar = lVar.f2685c;
                jVarA.getClass();
                x0.g.s(kVar, "initCallback cannot be null");
                ReentrantReadWriteLock reentrantReadWriteLock = jVarA.f374a;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    jVarA.f375b.remove(kVar);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            lVar.f2686d = z2;
            if (z2) {
                l.a(lVar.f2683a, androidx.emoji2.text.j.a().b());
            }
        }
    }

    public final KeyListener q(KeyListener keyListener) {
        if (keyListener instanceof g) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return keyListener instanceof NumberKeyListener ? keyListener : new g(keyListener);
    }

    public final InputConnection r(InputConnection inputConnection, EditorInfo editorInfo) {
        return inputConnection instanceof d ? inputConnection : new d(this.f2663b, inputConnection, editorInfo);
    }
}
