package s0;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.c0;
import p0.p0;

/* loaded from: classes.dex */
public abstract class e {
    public static void a(AppCompatActivity appCompatActivity, String str) {
        new AlertDialog.Builder(appCompatActivity).setTitle("").setMessage(str).setPositiveButton("确定", (DialogInterface.OnClickListener) null).show();
    }

    public static void b(AppCompatActivity appCompatActivity, String str, String str2, String str3, String str4, p0 p0Var) {
        new AlertDialog.Builder(appCompatActivity).setTitle(str).setMessage(str2).setPositiveButton(str3, p0Var).setNegativeButton(str4, (DialogInterface.OnClickListener) null).setCancelable(false).show();
    }

    public static ProgressDialog c(c0 c0Var, String str, String str2) {
        ProgressDialog progressDialog = new ProgressDialog(c0Var);
        progressDialog.setTitle(str);
        progressDialog.setMessage(str2);
        progressDialog.setCancelable(true);
        progressDialog.setInverseBackgroundForced(true);
        progressDialog.setOnCancelListener(new d());
        progressDialog.show();
        return progressDialog;
    }
}
