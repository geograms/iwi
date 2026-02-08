package d0;

import android.content.Context;
import java.io.File;

/* loaded from: classes.dex */
public final class h extends kotlin.jvm.internal.j implements c1.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f1725a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(i iVar) {
        super(0);
        this.f1725a = iVar;
    }

    @Override // c1.a
    public final Object invoke() {
        g gVar;
        i iVar = this.f1725a;
        if (iVar.f1727b == null || !iVar.f1729d) {
            gVar = new g(iVar.f1726a, iVar.f1727b, new k.j(14, null), iVar.f1728c, iVar.f1730e);
        } else {
            Context context = iVar.f1726a;
            x0.g.u(context, "context");
            File noBackupFilesDir = context.getNoBackupFilesDir();
            x0.g.t(noBackupFilesDir, "context.noBackupFilesDir");
            gVar = new g(iVar.f1726a, new File(noBackupFilesDir, iVar.f1727b).getAbsolutePath(), new k.j(14, null), iVar.f1728c, iVar.f1730e);
        }
        gVar.setWriteAheadLoggingEnabled(iVar.f1732g);
        return gVar;
    }
}
