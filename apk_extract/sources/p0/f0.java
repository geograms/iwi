package p0;

import android.app.ActivityManager;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.room.RoomDatabase;
import com.chamsion.quickchat.R;
import com.chamsion.quickchat.db.channel.ChannelDatabase;
import com.chamsion.quickchat.db.channelMessage.ChannelMessageDatabase;
import com.chamsion.quickchat.db.contacts.ContactDatabase;
import com.chamsion.quickchat.db.message.MessageDatabase;
import com.chamsion.quickchat.ui.FragmentLocalDeviceAreaActivity;
import com.chamsion.quickchat.ui.FragmentLocalInformationActivity;
import com.chamsion.quickchat.ui.FragmentLocalSettingsActivity;
import com.chamsion.quickchat.ui.FragmentLocalUseGuideActivity;
import com.chamsion.quickchat.ui.UpdateDmrAcitivity;
import com.wonder.dmr.DmrManager;
import com.wonder.dmr.utils.SPUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class f0 extends j0.b implements View.OnClickListener {
    public static final /* synthetic */ int G = 0;
    public TextView A;
    public TextView B;
    public Uri C;
    public Toast D;

    /* renamed from: h, reason: collision with root package name */
    public androidx.fragment.app.c0 f2318h;

    /* renamed from: j, reason: collision with root package name */
    public Dialog f2320j;

    /* renamed from: k, reason: collision with root package name */
    public Uri f2321k;

    /* renamed from: l, reason: collision with root package name */
    public Dialog f2322l;

    /* renamed from: m, reason: collision with root package name */
    public Dialog f2323m;

    /* renamed from: n, reason: collision with root package name */
    public View f2324n;

    /* renamed from: o, reason: collision with root package name */
    public View f2325o;

    /* renamed from: p, reason: collision with root package name */
    public View f2326p;

    /* renamed from: q, reason: collision with root package name */
    public ImageView f2327q;

    /* renamed from: r, reason: collision with root package name */
    public View f2328r;

    /* renamed from: s, reason: collision with root package name */
    public View f2329s;

    /* renamed from: t, reason: collision with root package name */
    public View f2330t;

    /* renamed from: u, reason: collision with root package name */
    public TextView f2331u;

    /* renamed from: v, reason: collision with root package name */
    public TextView f2332v;

    /* renamed from: w, reason: collision with root package name */
    public TextView f2333w;

    /* renamed from: x, reason: collision with root package name */
    public TextView f2334x;

    /* renamed from: y, reason: collision with root package name */
    public TextView f2335y;

    /* renamed from: z, reason: collision with root package name */
    public TextView f2336z;

    /* renamed from: g, reason: collision with root package name */
    public final String f2317g = f0.class.getName();

    /* renamed from: i, reason: collision with root package name */
    public boolean f2319i = false;
    public int E = 720;
    public final androidx.activity.d F = new androidx.activity.d(6, this);

    public static Uri f(androidx.fragment.app.c0 c0Var, String str) {
        File cacheDir = c0Var.getCacheDir();
        cacheDir.mkdirs();
        return FileProvider.b(c0Var, new File(cacheDir, str));
    }

    @Override // j0.b
    public final void e() {
        if (!this.f1895a || this.f2319i) {
            return;
        }
        this.f2319i = true;
    }

    public final void g() {
        this.f2321k = f(getActivity(), "CropEditUserPhoto.jpg");
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(this.C, "image/*");
        Uri uri = this.f2321k;
        intent.putExtra("output", uri);
        intent.addFlags(3);
        intent.setClipData(ClipData.newRawUri("output", uri));
        intent.putExtra("crop", "true");
        intent.putExtra("scale", true);
        intent.putExtra("scaleUpIfNeeded", true);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", this.E);
        intent.putExtra("outputY", this.E);
        intent.resolveActivity(getActivity().getPackageManager());
        getActivity().startActivityForResult(intent, 1003);
    }

    public final boolean h() throws Resources.NotFoundException {
        boolean z2 = x0.g.N(getActivity(), 0, "pref_person_send_status") == 1;
        if (z2) {
            int i2 = R.string.interphone_talk_send_status_toast;
            Toast toast = this.D;
            if (toast != null) {
                toast.cancel();
            }
            Toast toastMakeText = Toast.makeText(getActivity(), i2, 0);
            this.D = toastMakeText;
            toastMakeText.show();
        }
        return z2;
    }

    public final void i(Dialog dialog) {
        int i2 = getResources().getDisplayMetrics().widthPixels;
        Window window = dialog.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        attributes.y = 60;
        attributes.width = (int) (i2 * 0.9f);
        window.setAttributes(attributes);
        window.setBackgroundDrawableResource(android.R.color.transparent);
    }

    public final void j() {
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.interphone_camera_dialog, (ViewGroup) null);
        Dialog dialog = new Dialog(getActivity());
        this.f2320j = dialog;
        dialog.setContentView(viewInflate);
        i(this.f2320j);
        this.f2320j.show();
        viewInflate.findViewById(R.id.interphone_camera_take_picture).setOnClickListener(this);
        viewInflate.findViewById(R.id.interphone_camera_seleted_picture).setOnClickListener(this);
    }

    public final void k() {
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_local_exitapp_dialog, (ViewGroup) null);
        Dialog dialog = new Dialog(getActivity());
        this.f2322l = dialog;
        dialog.setContentView(viewInflate);
        i(this.f2322l);
        this.f2322l.show();
        viewInflate.findViewById(R.id.fragment_local_exit_app_cancle).setOnClickListener(this);
        viewInflate.findViewById(R.id.fragment_local_exit_app_ok).setOnClickListener(this);
    }

    public final void l() {
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_local_factoryreset_dialog, (ViewGroup) null);
        Dialog dialog = new Dialog(getActivity());
        this.f2323m = dialog;
        dialog.setContentView(viewInflate);
        i(this.f2323m);
        this.f2323m.show();
        viewInflate.findViewById(R.id.fragment_local_factory_reset_cancle).setOnClickListener(this);
        viewInflate.findViewById(R.id.fragment_local_factory_reset_ok).setOnClickListener(this);
    }

    public final void m(Bitmap bitmap) {
        if (bitmap != null) {
            this.f2327q.setImageDrawable(t0.c.a(getActivity(), bitmap));
            SharedPreferences.Editor editorEdit = getActivity().getSharedPreferences(SPUtils.FILE_NAME, 0).edit();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
            editorEdit.putString("pref_person_icon", new String(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0)));
            editorEdit.commit();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Dialog dialog;
        Dialog dialog2;
        Dialog dialog3;
        Dialog dialog4;
        int id = view.getId();
        if (id == R.id.fragment_local_camera) {
            if (h()) {
                return;
            }
            j();
            return;
        }
        if (id == R.id.fragment_local_exit_app_cancle) {
            Dialog dialog5 = this.f2322l;
            if (dialog5 != null) {
                dialog5.dismiss();
                return;
            }
            return;
        }
        if (id == R.id.fragment_local_exit_app_ok) {
            if (h() || (dialog4 = this.f2322l) == null) {
                return;
            }
            dialog4.dismiss();
            getActivity().finishAffinity();
            getActivity().finish();
            System.exit(0);
            return;
        }
        if (id == R.id.fragment_local_factory_reset_cancle) {
            Dialog dialog6 = this.f2323m;
            if (dialog6 != null) {
                dialog6.dismiss();
                return;
            }
            return;
        }
        if (id != R.id.fragment_local_factory_reset_ok) {
            if (id == R.id.interphone_camera_seleted_picture) {
                if (h() || (dialog2 = this.f2320j) == null) {
                    return;
                }
                dialog2.dismiss();
                this.C = f(getActivity(), "TakeEditUserPhoto2.jpg");
                Intent intent = new Intent("android.intent.action.GET_CONTENT", (Uri) null);
                intent.setType("image/*");
                Uri uri = this.C;
                intent.putExtra("output", uri);
                intent.addFlags(3);
                intent.setClipData(ClipData.newRawUri("output", uri));
                getActivity().startActivityForResult(intent, 1001);
                return;
            }
            if (id == R.id.interphone_camera_take_picture) {
                if (h() || (dialog = this.f2320j) == null) {
                    return;
                }
                dialog.dismiss();
                this.C = f(getActivity(), "TakeEditUserPhoto2.jpg");
                Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
                Uri uri2 = this.C;
                intent2.putExtra("output", uri2);
                intent2.addFlags(3);
                intent2.setClipData(ClipData.newRawUri("output", uri2));
                intent2.addFlags(3);
                getActivity().startActivityForResult(intent2, 1002);
                return;
            }
            if (id == R.id.local_device_area) {
                if (h() || ActivityManager.isUserAMonkey()) {
                    return;
                }
                getActivity().startActivity(new Intent(getContext(), (Class<?>) FragmentLocalDeviceAreaActivity.class));
                return;
            }
            if (id == R.id.local_exit_app) {
                if (h()) {
                    return;
                }
                k();
                return;
            }
            if (id == R.id.local_factory_reset) {
                if (h()) {
                    return;
                }
                l();
                return;
            }
            if (id == R.id.local_information) {
                getActivity().startActivity(new Intent(getContext(), (Class<?>) FragmentLocalInformationActivity.class));
                return;
            }
            if (id == R.id.local_seting) {
                if (h()) {
                    return;
                }
                getActivity().startActivity(new Intent(getContext(), (Class<?>) FragmentLocalSettingsActivity.class));
                return;
            } else {
                if (id == R.id.local_test_bite_error_rate) {
                    return;
                }
                if (id == R.id.local_use_assistant) {
                    getActivity().startActivity(new Intent(getContext(), (Class<?>) FragmentLocalUseGuideActivity.class));
                    return;
                } else {
                    if (id == R.id.rl_upgrade) {
                        getActivity().startActivity(new Intent(getContext(), (Class<?>) UpdateDmrAcitivity.class));
                        return;
                    }
                    return;
                }
            }
        }
        if (h() || (dialog3 = this.f2323m) == null) {
            return;
        }
        dialog3.dismiss();
        String string = getString(R.string.fragment_local_factory_reset_progress_dialog_title);
        if (this.f1896b == null) {
            this.f1896b = new ProgressDialog(getActivity());
        }
        this.f1896b.setMessage(string);
        this.f1896b.setCancelable(false);
        this.f1896b.show();
        DmrManager.getInstance().resetData();
        m(x0.g.K(this.f2318h));
        ChannelDatabase.c(this.f2318h).b().a();
        ChannelDatabase.c(this.f2318h).a().a();
        ChannelDatabase.c(this.f2318h).getOpenHelper().getWritableDatabase().execSQL("DELETE FROM sqlite_sequence");
        l0.c cVarB = ChannelMessageDatabase.a(this.f2318h).b();
        RoomDatabase roomDatabase = cVarB.f2086a;
        roomDatabase.assertNotSuspendingTransaction();
        k0.w wVar = cVarB.f2087b;
        c0.k kVarAcquire = wVar.acquire();
        try {
            roomDatabase.beginTransaction();
            try {
                kVarAcquire.executeUpdateDelete();
                roomDatabase.setTransactionSuccessful();
                wVar.release(kVarAcquire);
                ChannelMessageDatabase.a(this.f2318h).getOpenHelper().getWritableDatabase().execSQL("DELETE FROM sqlite_sequence");
                m0.d dVarA = ContactDatabase.b(this.f2318h).a();
                RoomDatabase roomDatabase2 = dVarA.f2101a;
                roomDatabase2.assertNotSuspendingTransaction();
                k0.w wVar2 = dVarA.f2105e;
                c0.k kVarAcquire2 = wVar2.acquire();
                try {
                    roomDatabase2.beginTransaction();
                    try {
                        kVarAcquire2.executeUpdateDelete();
                        roomDatabase2.setTransactionSuccessful();
                        wVar2.release(kVarAcquire2);
                        ContactDatabase.b(this.f2318h).getOpenHelper().getWritableDatabase().execSQL("DELETE FROM sqlite_sequence");
                        n0.i iVarB = MessageDatabase.a(this.f2318h).b();
                        RoomDatabase roomDatabase3 = iVarB.f2175a;
                        roomDatabase3.assertNotSuspendingTransaction();
                        n0.h hVar = iVarB.f2177c;
                        c0.k kVarAcquire3 = hVar.acquire();
                        try {
                            roomDatabase3.beginTransaction();
                            try {
                                kVarAcquire3.executeUpdateDelete();
                                roomDatabase3.setTransactionSuccessful();
                                hVar.release(kVarAcquire3);
                                MessageDatabase.a(this.f2318h).getOpenHelper().getWritableDatabase().execSQL("DELETE FROM sqlite_sequence");
                                SharedPreferences.Editor editorEdit = this.f2318h.getSharedPreferences(SPUtils.FILE_NAME, 0).edit();
                                editorEdit.clear();
                                s0.m.a(editorEdit);
                                new k0.g(new k0.h(this.f2318h), 0, 0).execute(new Void[0]);
                                x0.g.n0(this.f2318h, "first_launch", false);
                                Handler handler = this.f1898d;
                                handler.postDelayed(this.f1897c, 1000L);
                                handler.postDelayed(this.F, 1000L);
                            } finally {
                                roomDatabase3.endTransaction();
                            }
                        } catch (Throwable th) {
                            hVar.release(kVarAcquire3);
                            throw th;
                        }
                    } finally {
                        roomDatabase2.endTransaction();
                    }
                } catch (Throwable th2) {
                    wVar2.release(kVarAcquire2);
                    throw th2;
                }
            } finally {
                roomDatabase.endTransaction();
            }
        } catch (Throwable th3) {
            wVar.release(kVarAcquire);
            throw th3;
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Log.d(this.f2317g, "onConfigurationChanged");
        Dialog dialog = this.f2320j;
        if (dialog != null && dialog.isShowing()) {
            this.f2320j.dismiss();
            this.f2320j = null;
            j();
        }
        Dialog dialog2 = this.f2323m;
        if (dialog2 != null && dialog2.isShowing()) {
            this.f2323m.dismiss();
            this.f2323m = null;
            l();
        }
        Dialog dialog3 = this.f2322l;
        if (dialog3 == null || !dialog3.isShowing()) {
            return;
        }
        this.f2322l.dismiss();
        this.f2322l = null;
        k();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f1899e == null) {
            this.f1899e = layoutInflater.inflate(R.layout.fragment_mine, viewGroup, false);
        }
        this.f1899e.setBackground(getResources().getDrawable(R.color.black));
        ViewGroup viewGroup2 = (ViewGroup) this.f1899e.getParent();
        if (viewGroup2 != null) {
            viewGroup2.removeView(this.f1899e);
        }
        this.f2318h = getActivity();
        return this.f1899e;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f1898d.post(this.F);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ((TextView) view.findViewById(R.id.tv_title)).setText(getResources().getString(R.string.rb_mine));
        ((ImageView) view.findViewById(R.id.iv_add)).setVisibility(8);
        ((ImageButton) view.findViewById(R.id.fragment_local_camera)).setOnClickListener(this);
        this.f2331u = (TextView) view.findViewById(R.id.local_device_area_setings);
        ImageView imageView = (ImageView) view.findViewById(R.id.fragment_local_img);
        this.f2327q = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f2329s = view.findViewById(R.id.local_seting);
        this.f2333w = (TextView) view.findViewById(R.id.local_seting_title);
        this.f2329s.setOnClickListener(this);
        this.f2328r = view.findViewById(R.id.local_information);
        this.f2334x = (TextView) view.findViewById(R.id.local_information_title);
        this.f2328r.setOnClickListener(this);
        this.f2324n = view.findViewById(R.id.local_device_area);
        this.f2335y = (TextView) view.findViewById(R.id.local_device_area_title);
        this.f2324n.setOnClickListener(this);
        this.f2326p = view.findViewById(R.id.local_factory_reset);
        this.f2336z = (TextView) view.findViewById(R.id.local_factory_reset_title);
        this.f2326p.setOnClickListener(this);
        this.f2330t = view.findViewById(R.id.local_use_assistant);
        this.A = (TextView) view.findViewById(R.id.local_use_assistant_title);
        this.f2330t.setOnClickListener(this);
        this.f2325o = view.findViewById(R.id.local_exit_app);
        this.B = (TextView) view.findViewById(R.id.local_exit_app_title);
        this.f2325o.setOnClickListener(this);
        view.findViewById(R.id.local_test_bite_error_rate).setOnClickListener(this);
        view.findViewById(R.id.rl_upgrade).setOnClickListener(this);
        this.f2332v = (TextView) view.findViewById(R.id.tv_upgrade);
        this.E = (int) getActivity().getResources().getDimension(R.dimen.interphone_circle_view_size);
        m(x0.g.M(getActivity(), x0.g.K(this.f2318h)));
        setUserVisibleHint(true);
    }
}
