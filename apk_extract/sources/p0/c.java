package p0;

import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chamsion.quickchat.ui.AddNewChannelActivity;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class c implements AdapterView.OnItemSelectedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2292a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AddNewChannelActivity f2293b;

    public /* synthetic */ c(AddNewChannelActivity addNewChannelActivity, int i2) {
        this.f2292a = i2;
        this.f2293b = addNewChannelActivity;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i2, long j2) throws Resources.NotFoundException {
        int i3 = this.f2292a;
        AddNewChannelActivity addNewChannelActivity = this.f2293b;
        switch (i3) {
            case 0:
                Log.e(addNewChannelActivity.f1260a, "mAspReceive, onItemSelected " + i2);
                byte b2 = (byte) i2;
                addNewChannelActivity.f1307x0 = b2;
                if (b2 == 0) {
                    addNewChannelActivity.D.setVisibility(8);
                } else {
                    addNewChannelActivity.D.setVisibility(0);
                }
                if (!addNewChannelActivity.f1277i0) {
                    addNewChannelActivity.f1309y0 = (byte) 0;
                    addNewChannelActivity.A0 = (byte) 0;
                    addNewChannelActivity.h(i2, -1);
                    break;
                } else {
                    addNewChannelActivity.f1277i0 = false;
                    break;
                }
            case 1:
                addNewChannelActivity.f1301u0 = (byte) (i2 + 1);
                break;
            case 2:
                addNewChannelActivity.B0 = addNewChannelActivity.W[i2];
                Log.e(addNewChannelActivity.f1260a, "mAspMonitor onItemSelected ,mMonitor = " + ((int) addNewChannelActivity.B0));
                break;
            case 3:
                addNewChannelActivity.f1285m0 = (byte) i2;
                break;
            case 4:
                addNewChannelActivity.f1291p0 = (byte) (i2 == 1 ? 4 : 0);
                break;
            case 5:
                byte b3 = (byte) i2;
                addNewChannelActivity.f1287n0 = b3;
                addNewChannelActivity.f1289o0 = b3;
                break;
            case 6:
                Log.d(addNewChannelActivity.f1260a, "onItemSelected, mAspContactsType = " + i2);
                addNewChannelActivity.f1283l0 = (byte) i2;
                if (i2 != 0) {
                    addNewChannelActivity.G0 = 3;
                    addNewChannelActivity.V.setVisibility(i2 == 1 ? 0 : 8);
                    addNewChannelActivity.T.setVisibility(i2 == 1 ? 0 : 8);
                    addNewChannelActivity.K.setVisibility(i2 == 1 ? 0 : 8);
                    addNewChannelActivity.f1288o.setVisibility(8);
                } else {
                    addNewChannelActivity.G0 = 1;
                    addNewChannelActivity.V.setVisibility(8);
                    addNewChannelActivity.T.setVisibility(8);
                    addNewChannelActivity.f1288o.setVisibility(8);
                }
                if (i2 == 2) {
                    addNewChannelActivity.I.setVisibility(8);
                    addNewChannelActivity.f1281k0 = 16777215;
                    addNewChannelActivity.S.setText(addNewChannelActivity.f1281k0 + "");
                } else {
                    addNewChannelActivity.I.setVisibility(0);
                    addNewChannelActivity.f1281k0 = 1;
                    addNewChannelActivity.S.setText(addNewChannelActivity.f1281k0 + "");
                }
                String str = " onItemSelected,222 mAspContactsType ，mISFirstContact= " + addNewChannelActivity.f1273g0;
                String str2 = addNewChannelActivity.f1260a;
                Log.d(str2, str);
                boolean z2 = addNewChannelActivity.f1273g0;
                ArrayList arrayList = addNewChannelActivity.F0;
                if (!z2) {
                    if (i2 == 0) {
                        ArrayList arrayList2 = addNewChannelActivity.E0;
                        if (!arrayList2.isEmpty()) {
                            addNewChannelActivity.f1281k0 = ((m0.a) arrayList2.get(0)).f2093d;
                            addNewChannelActivity.S.setText(addNewChannelActivity.f1281k0 + "");
                        }
                    } else if (i2 == 1 && !arrayList.isEmpty()) {
                        addNewChannelActivity.f1281k0 = ((m0.a) arrayList.get(0)).f2093d;
                        addNewChannelActivity.S.setText(addNewChannelActivity.f1281k0 + "");
                    }
                    Log.d(str2, "onItemSelected,3333 mAspContactsType   mContact= " + addNewChannelActivity.f1281k0);
                    break;
                } else {
                    if (i2 == 1 && !arrayList.isEmpty()) {
                        if (addNewChannelActivity.Y) {
                            Log.d(str2, "修改信息-组呼， onItemSelected,222 mAspContactsType ，mContact= " + addNewChannelActivity.f1281k0);
                            addNewChannelActivity.S.setText(addNewChannelActivity.f1281k0 + "");
                        } else {
                            addNewChannelActivity.f1281k0 = ((m0.a) arrayList.get(0)).f2093d;
                            Log.d(str2, "默认信息-组呼， onItemSelected,222 mAspContactsType ，mContact= " + addNewChannelActivity.f1281k0);
                            addNewChannelActivity.S.setText(addNewChannelActivity.f1281k0 + "");
                        }
                    }
                    addNewChannelActivity.f1273g0 = false;
                    break;
                }
                break;
            case 7:
                Log.d(addNewChannelActivity.f1260a, "mEtFrequencyBand onItemSelected, i  " + i2);
                AddNewChannelActivity.I0 = i2;
                if (i2 == 0) {
                    addNewChannelActivity.f1297s0 = 401025000;
                    addNewChannelActivity.f1299t0 = 401025000;
                    addNewChannelActivity.Q.setError(null);
                    addNewChannelActivity.R.setError(null);
                } else if (i2 == 1) {
                    addNewChannelActivity.f1297s0 = 136025000;
                    addNewChannelActivity.f1299t0 = 136025000;
                    addNewChannelActivity.Q.setError(null);
                    addNewChannelActivity.R.setError(null);
                }
                if (addNewChannelActivity.f1279j0 && addNewChannelActivity.X != null) {
                    addNewChannelActivity.O.setText(addNewChannelActivity.X.f1945i + "");
                    addNewChannelActivity.P.setText(addNewChannelActivity.X.f1944h + "");
                    addNewChannelActivity.f1279j0 = false;
                    break;
                } else {
                    addNewChannelActivity.O.setText("");
                    addNewChannelActivity.P.setText("");
                    int i4 = AddNewChannelActivity.I0;
                    if (i4 != 0) {
                        if (i4 == 1) {
                            addNewChannelActivity.O.setHint("(136000000-174000000)");
                            addNewChannelActivity.P.setHint("(136000000-174000000)");
                            break;
                        }
                    } else {
                        addNewChannelActivity.O.setHint("(400000000-480000000)");
                        addNewChannelActivity.P.setHint("(400000000-480000000)");
                        break;
                    }
                }
                break;
            case 8:
                addNewChannelActivity.G0 = i2 + 1;
                Log.i(addNewChannelActivity.f1260a, ",mAspSmsType , 短信类型：" + addNewChannelActivity.G0);
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_LEFT_TO_RIGHT_OF /* 9 */:
                Log.d(addNewChannelActivity.f1260a, "mAspChannelType onItemSelected, i  " + i2);
                addNewChannelActivity.j(i2);
                break;
            case 10:
                if (i2 == 0) {
                    addNewChannelActivity.L.setVisibility(0);
                } else {
                    addNewChannelActivity.L.setVisibility(8);
                }
                addNewChannelActivity.f1293q0 = addNewChannelActivity.W[i2];
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_TO_RIGHT_OF /* 11 */:
                addNewChannelActivity.f1303v0 = (byte) i2;
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_TOP_OF /* 12 */:
                addNewChannelActivity.f1305w0 = (byte) i2;
                break;
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_TOP_TO_BOTTOM_OF /* 13 */:
                Log.e(addNewChannelActivity.f1260a, "mAspTransmission, onItemSelected " + i2);
                byte b4 = (byte) i2;
                addNewChannelActivity.f1311z0 = b4;
                if (b4 == 0) {
                    addNewChannelActivity.C.setVisibility(8);
                } else {
                    addNewChannelActivity.C.setVisibility(0);
                }
                Log.e(addNewChannelActivity.f1260a, "WONDER, BBBBB mAspTransmission.setOnItemSelectedListener,mTxType =   " + ((int) addNewChannelActivity.f1311z0));
                if (!addNewChannelActivity.f1275h0) {
                    addNewChannelActivity.f1309y0 = (byte) 0;
                    addNewChannelActivity.A0 = (byte) 0;
                    addNewChannelActivity.i(i2, -1);
                    break;
                } else {
                    addNewChannelActivity.f1275h0 = false;
                    break;
                }
            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_BOTTOM_TO_TOP_OF /* 14 */:
                addNewChannelActivity.A0 = (byte) i2;
                break;
            default:
                addNewChannelActivity.f1309y0 = (byte) i2;
                break;
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
    }
}
