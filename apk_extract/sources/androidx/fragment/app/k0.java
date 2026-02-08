package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

/* loaded from: classes.dex */
public abstract class k0 extends i0 {

    /* renamed from: a, reason: collision with root package name */
    public final Activity f553a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f554b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f555c;

    /* renamed from: d, reason: collision with root package name */
    public final x0 f556d;

    public k0(AppCompatActivity appCompatActivity) {
        Handler handler = new Handler();
        this.f556d = new x0();
        this.f553a = appCompatActivity;
        this.f554b = appCompatActivity;
        this.f555c = handler;
    }
}
