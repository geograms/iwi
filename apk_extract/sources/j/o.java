package j;

import androidx.room.RoomDatabase;
import com.google.android.material.sidesheet.SideSheetBehavior;

/* loaded from: classes.dex */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1876a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f1877b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f1878c;

    public /* synthetic */ o(int i2, int i3, Object obj) {
        this.f1876a = i3;
        this.f1878c = obj;
        this.f1877b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f1876a;
        int i3 = this.f1877b;
        Object obj = this.f1878c;
        switch (i2) {
            case 0:
                ((p) obj).onFontRetrievalFailed(i3);
                return;
            case 1:
                n0.i iVar = ((n0.o) obj).f2191a;
                RoomDatabase roomDatabase = iVar.f2175a;
                roomDatabase.assertNotSuspendingTransaction();
                n0.h hVar = iVar.f2178d;
                c0.k kVarAcquire = hVar.acquire();
                long j2 = i3;
                kVarAcquire.bindLong(1, j2);
                kVarAcquire.bindLong(2, j2);
                kVarAcquire.bindLong(3, j2);
                try {
                    roomDatabase.beginTransaction();
                    try {
                        kVarAcquire.executeUpdateDelete();
                        roomDatabase.setTransactionSuccessful();
                        return;
                    } finally {
                        roomDatabase.endTransaction();
                    }
                } finally {
                    hVar.release(kVarAcquire);
                }
            default:
                ((SideSheetBehavior) obj).lambda$setState$0(i3);
                return;
        }
    }
}
