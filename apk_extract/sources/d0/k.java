package d0;

import android.database.sqlite.SQLiteStatement;

/* loaded from: classes.dex */
public final class k extends j implements c0.k {

    /* renamed from: b, reason: collision with root package name */
    public final SQLiteStatement f1734b;

    public k(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.f1734b = sQLiteStatement;
    }

    @Override // c0.k
    public final void execute() {
        this.f1734b.execute();
    }

    @Override // c0.k
    public final long executeInsert() {
        return this.f1734b.executeInsert();
    }

    @Override // c0.k
    public final int executeUpdateDelete() {
        return this.f1734b.executeUpdateDelete();
    }

    @Override // c0.k
    public final long simpleQueryForLong() {
        return this.f1734b.simpleQueryForLong();
    }

    @Override // c0.k
    public final String simpleQueryForString() {
        return this.f1734b.simpleQueryForString();
    }
}
