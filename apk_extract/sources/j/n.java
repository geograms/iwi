package j;

import android.graphics.Typeface;
import androidx.room.MultiInstanceInvalidationClient;
import androidx.room.MultiInstanceInvalidationClient$callback$1;
import androidx.room.RoomDatabase;
import androidx.room.TransactionExecutor;

/* loaded from: classes.dex */
public final /* synthetic */ class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1873a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1874b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1875c;

    public /* synthetic */ n(int i2, Object obj, Object obj2) {
        this.f1873a = i2;
        this.f1874b = obj;
        this.f1875c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f1873a;
        Object obj = this.f1875c;
        Object obj2 = this.f1874b;
        switch (i2) {
            case 0:
                ((p) obj2).onFontRetrieved((Typeface) obj);
                return;
            case 1:
                MultiInstanceInvalidationClient$callback$1.onInvalidation$lambda$0((MultiInstanceInvalidationClient) obj2, (String[]) obj);
                return;
            case 2:
                TransactionExecutor.execute$lambda$1$lambda$0((Runnable) obj2, (TransactionExecutor) obj);
                return;
            default:
                n0.e eVar = (n0.e) obj;
                n0.i iVar = ((n0.o) obj2).f2191a;
                RoomDatabase roomDatabase = iVar.f2175a;
                roomDatabase.assertNotSuspendingTransaction();
                roomDatabase.beginTransaction();
                try {
                    iVar.f2176b.insert((k0.b) eVar);
                    roomDatabase.setTransactionSuccessful();
                    return;
                } finally {
                    roomDatabase.endTransaction();
                }
        }
    }
}
