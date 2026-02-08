package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import g1.c;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.j;
import x0.g;

/* loaded from: classes.dex */
public final class ViewModelLazy<VM extends ViewModel> implements u0.a {
    private VM cached;
    private final c1.a extrasProducer;
    private final c1.a factoryProducer;
    private final c1.a storeProducer;
    private final c viewModelClass;

    /* renamed from: androidx.lifecycle.ViewModelLazy$1, reason: invalid class name */
    public static final class AnonymousClass1 extends j implements c1.a {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // c1.a
        public final CreationExtras.Empty invoke() {
            return CreationExtras.Empty.INSTANCE;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelLazy(c cVar, c1.a aVar, c1.a aVar2) {
        this(cVar, aVar, aVar2, null, 8, null);
        g.u(cVar, "viewModelClass");
        g.u(aVar, "storeProducer");
        g.u(aVar2, "factoryProducer");
    }

    public boolean isInitialized() {
        return this.cached != null;
    }

    public ViewModelLazy(c cVar, c1.a aVar, c1.a aVar2, c1.a aVar3) {
        g.u(cVar, "viewModelClass");
        g.u(aVar, "storeProducer");
        g.u(aVar2, "factoryProducer");
        g.u(aVar3, "extrasProducer");
        this.viewModelClass = cVar;
        this.storeProducer = aVar;
        this.factoryProducer = aVar2;
        this.extrasProducer = aVar3;
    }

    @Override // u0.a
    public VM getValue() {
        VM vm = this.cached;
        if (vm != null) {
            return vm;
        }
        ViewModelProvider viewModelProvider = new ViewModelProvider((ViewModelStore) this.storeProducer.invoke(), (ViewModelProvider.Factory) this.factoryProducer.invoke(), (CreationExtras) this.extrasProducer.invoke());
        c cVar = this.viewModelClass;
        g.u(cVar, "<this>");
        Class clsA = ((d) cVar).a();
        g.r(clsA, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        VM vm2 = (VM) viewModelProvider.get(clsA);
        this.cached = vm2;
        return vm2;
    }

    public /* synthetic */ ViewModelLazy(c cVar, c1.a aVar, c1.a aVar2, c1.a aVar3, int i2, kotlin.jvm.internal.g gVar) {
        this(cVar, aVar, aVar2, (i2 & 8) != 0 ? AnonymousClass1.INSTANCE : aVar3);
    }
}
