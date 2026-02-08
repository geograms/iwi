package com.wonder.dmr;

import a.b;
import a.c;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import androidx.constraintlayout.solver.widgets.Optimizer;
import com.wonder.dmr.utils.CRC;
import com.wonder.serial.OnDataReceiveListener;
import com.wonder.serial.SerialTools;
import com.wonder.serial.utils.HexStringUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import x0.g;

/* loaded from: classes.dex */
public class DmrManager {
    public static final int DMR_UPDATE_BEFORE = 0;
    public static final int DMR_UPDATE_END = 3;
    public static final int DMR_UPDATE_FINISH = 4;
    public static final int DMR_UPDATE_READY = 1;
    public static final int DMR_UPDATE_START = 2;
    public static int ERROR = -1;
    public static int FAIL = 1;
    public static volatile DmrManager P = null;
    public static int SUCCESS = 0;
    public static int SUM_CHECK_ERROR = 2;
    public OnSquelchListener A;
    public OnPowerSavingModeListener B;
    public OnRSSIListener C;
    public OnRelayOfflineListener D;
    public OnVersionListener E;
    public OnTransferInterruptListener F;
    public OnReportStatusListener G;
    public OnPolicyListener H;
    public OnSmsProtocolTypeListener I;
    public OnTotListener J;
    public OnSpkEnListener K;
    public OnEnhanceListener L;
    public int M;
    public OnUpgradeModeListener N;
    public boolean O;

    /* renamed from: a, reason: collision with root package name */
    public final String f1659a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1660b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1661c;

    /* renamed from: d, reason: collision with root package name */
    public Handler f1662d;

    /* renamed from: e, reason: collision with root package name */
    public OnPowerOnListener f1663e;

    /* renamed from: f, reason: collision with root package name */
    public Handler f1664f;

    /* renamed from: g, reason: collision with root package name */
    public HandlerThread f1665g;

    /* renamed from: h, reason: collision with root package name */
    public int f1666h;
    public boolean hasSmsLocalId;

    /* renamed from: i, reason: collision with root package name */
    public Object f1667i;

    /* renamed from: j, reason: collision with root package name */
    public SerialTools f1668j;

    /* renamed from: k, reason: collision with root package name */
    public int f1669k;

    /* renamed from: l, reason: collision with root package name */
    public byte[] f1670l;

    /* renamed from: m, reason: collision with root package name */
    public OnDataReceiveListener f1671m;

    /* renamed from: n, reason: collision with root package name */
    public String f1672n;

    /* renamed from: o, reason: collision with root package name */
    public OnDigitalCmdListener f1673o;

    /* renamed from: p, reason: collision with root package name */
    public OnAnalogCmdListener f1674p;

    /* renamed from: q, reason: collision with root package name */
    public OnLaunchCommandListener f1675q;

    /* renamed from: r, reason: collision with root package name */
    public OnInitializationFinishlistener f1676r;

    /* renamed from: s, reason: collision with root package name */
    public OnEnhancementsListener f1677s;

    /* renamed from: t, reason: collision with root package name */
    public OnEncryptionListener f1678t;

    /* renamed from: u, reason: collision with root package name */
    public OnMicGainListener f1679u;

    /* renamed from: v, reason: collision with root package name */
    public OnDigitalVoiceReceptionInfoListener f1680v;

    /* renamed from: w, reason: collision with root package name */
    public OnTextMessageListener f1681w;

    /* renamed from: x, reason: collision with root package name */
    public OnSmsListener f1682x;

    /* renamed from: y, reason: collision with root package name */
    public OnVolumeListener f1683y;

    /* renamed from: z, reason: collision with root package name */
    public OnMonitorListener f1684z;

    public class a implements OnDataReceiveListener {
        public a() {
        }

        @Override // com.wonder.serial.OnDataReceiveListener
        public void onDataReceive(byte[] bArr, int i2) {
            synchronized (DmrManager.this.f1667i) {
                try {
                    DmrManager.this.f1661c = true;
                    DmrManager dmrManager = DmrManager.this;
                    String str = "对讲机回复信息-onDataReceive-> " + HexStringUtils.toHexString(bArr);
                    if (dmrManager.f1660b) {
                        Log.i(dmrManager.f1659a, str);
                    }
                    DmrManager.this.checkReceiveDmrData(bArr, i2);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public DmrManager() {
        String name = DmrManager.class.getName();
        this.f1659a = name;
        this.f1660b = false;
        this.f1661c = true;
        this.f1662d = null;
        this.f1664f = null;
        this.f1665g = null;
        this.f1666h = -1;
        this.f1667i = null;
        this.hasSmsLocalId = false;
        this.f1669k = 0;
        this.f1670l = new byte[256];
        this.f1671m = new a();
        this.f1672n = "GB2312";
        this.M = -1;
        this.N = null;
        this.O = false;
        Log.i(name, "Dmrmanager init, version: 【1.0.9(2025-4-27)】");
        a();
    }

    public static DmrManager getInstance() {
        if (P == null) {
            synchronized (DmrManager.class) {
                try {
                    if (P == null) {
                        P = new DmrManager();
                    }
                } finally {
                }
            }
        }
        return P;
    }

    public static String getPathValue(String str) throws IOException {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return "";
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    return stringBuffer.toString();
                }
                stringBuffer.append(line);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public final void a(String str) {
        if (this.f1660b) {
            Log.i(this.f1659a, str);
        }
    }

    public void checkDmrUpgradeMode() {
        setDmrUpgrade(true);
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            serialTools.sendBytes("1".getBytes());
        }
    }

    public void checkInitComplete(OnInitializationFinishlistener onInitializationFinishlistener) {
        this.f1676r = onInitializationFinishlistener;
        if (!this.f1661c) {
            onInitializationFinishlistener.OnCallback(ERROR);
            return;
        }
        byte[] bArr = {104, 39, 1, 1, 0, 0, 0, 1, 1, 16};
        byte[] bArrCheckSumBytes = CRC.checkSumBytes(bArr, 10);
        g.b(bArr, g.a(bArrCheckSumBytes, 0, bArr, 4, bArrCheckSumBytes.length, "checkInitComplete, cmd-result = "), this);
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            serialTools.sendBytes(bArr);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:92:0x02a4, code lost:
    
        resetData();
        android.util.Log.e(r24.f1659a, "数据异常！！");
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x02ac, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void checkReceiveDmrData(byte[] r25, int r26) {
        /*
            Method dump skipped, instructions count: 854
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wonder.dmr.DmrManager.checkReceiveDmrData(byte[], int):void");
    }

    public void closeSerial() {
        if (this.f1666h > 0) {
            this.f1668j.closeSerial();
            this.f1668j.setOnDataReceiveListener(null);
            this.f1666h = -1;
            if (this.f1660b) {
                Log.i(this.f1659a, "关闭串口成功！");
            }
        }
    }

    public void getDigitalVoiceReceptionInfo(OnDigitalVoiceReceptionInfoListener onDigitalVoiceReceptionInfoListener) {
        this.f1680v = onDigitalVoiceReceptionInfoListener;
        if (!this.f1661c) {
            onDigitalVoiceReceptionInfoListener.OnCallback(ERROR, null);
            return;
        }
        byte[] bArr = {104, 43, 1, 1, 0, 0, 0, 1, 1, 16};
        byte[] bArrCheckSumBytes = CRC.checkSumBytes(bArr, 10);
        g.b(bArr, g.a(bArrCheckSumBytes, 0, bArr, 4, bArrCheckSumBytes.length, "getDigitalVoiceReceptionInfo, cmd result = "), this);
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            serialTools.sendBytes(bArr);
        }
    }

    public int getDmrUpgradeProcessStage() {
        return this.M;
    }

    public String getMessageEncode() {
        return this.f1672n;
    }

    public void getRSSI(OnRSSIListener onRSSIListener) {
        this.C = onRSSIListener;
        if (!this.f1661c) {
            int i2 = ERROR;
            onRSSIListener.OnCallback(i2, i2);
            return;
        }
        byte[] bArr = {104, 50, 1, 1, 0, 0, 0, 1, 1, 16};
        byte[] bArrCheckSumBytes = CRC.checkSumBytes(bArr, 10);
        g.b(bArr, g.a(bArrCheckSumBytes, 0, bArr, 4, bArrCheckSumBytes.length, "getRSSI, cmd result = "), this);
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            serialTools.sendBytes(bArr);
        }
    }

    public void getSms(OnSmsListener onSmsListener) {
        this.f1682x = onSmsListener;
        if (!this.f1661c) {
            int i2 = ERROR;
            onSmsListener.OnCallback(i2, i2, i2, "");
            return;
        }
        byte[] bArr = {104, 45, 1, 1, 0, 0, 0, 1, 1, 16};
        byte[] bArrCheckSumBytes = CRC.checkSumBytes(bArr, 10);
        g.b(bArr, g.a(bArrCheckSumBytes, 0, bArr, 4, bArrCheckSumBytes.length, "getSms, cmd result = "), this);
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            serialTools.sendBytes(bArr);
        }
    }

    public void getVersion(OnVersionListener onVersionListener) {
        this.E = onVersionListener;
        if (!this.f1661c) {
            onVersionListener.OnCallback(ERROR, null);
            return;
        }
        byte[] bArr = {104, 52, 1, 1, 0, 0, 0, 1, 1, 16};
        byte[] bArrCheckSumBytes = CRC.checkSumBytes(bArr, 10);
        g.b(bArr, g.a(bArrCheckSumBytes, 0, bArr, 4, bArrCheckSumBytes.length, "getVersion, cmd result = "), this);
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            serialTools.sendBytes(bArr);
        }
    }

    public boolean isDmrUpgrade() {
        return this.O;
    }

    public boolean isHasSmsLocalId() {
        return this.hasSmsLocalId;
    }

    public void launchCommand(int i2, OnLaunchCommandListener onLaunchCommandListener) {
        this.f1675q = onLaunchCommandListener;
        if (!this.f1661c) {
            onLaunchCommandListener.OnCallback(ERROR);
            return;
        }
        byte[] bArr = {104, 38, 1, 1, 0, 0, 0, 1, (byte) i2, 16};
        byte[] bArrCheckSumBytes = CRC.checkSumBytes(bArr, 10);
        g.b(bArr, g.a(bArrCheckSumBytes, 0, bArr, 4, bArrCheckSumBytes.length, "launchCommand, cmd-result = "), this);
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            serialTools.sendBytes(bArr);
        }
    }

    public int openSerial(String str, int i2) {
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            this.f1666h = serialTools.openSerial(str, i2);
        }
        if (this.f1666h > 0) {
            if (this.f1660b) {
                Log.i(this.f1659a, "打开串口成功！");
            }
            this.f1668j.setOnDataReceiveListener(this.f1671m);
        } else if (this.f1660b) {
            Log.e(this.f1659a, "打开串口失败！");
        }
        return this.f1666h;
    }

    public void powerCtrl(String str, int i2) {
        a(str, i2);
    }

    public void pttCtrl(String str, int i2) {
        a(str, i2);
    }

    public void pwdCtrl(String str, int i2) {
        a(str, i2);
    }

    public byte[] removeBytes(byte[] bArr, int i2, int i3) {
        if (bArr == null || bArr.length == 0 || i2 >= bArr.length) {
            return bArr;
        }
        int iMin = Math.min(i3 + i2, bArr.length);
        int length = bArr.length - (iMin - i2);
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        if (iMin < bArr.length) {
            System.arraycopy(bArr, iMin, bArr2, i2, bArr.length - iMin);
        }
        a(length + " , 已解析的数据需要从数组中移除出去 =[" + HexStringUtils.toHexString(bArr2) + "]");
        return bArr2;
    }

    public void resetData() {
        this.f1669k = 0;
        System.arraycopy(new byte[256], 0, this.f1670l, 0, 256);
        this.O = false;
        this.M = -1;
    }

    public void sendDmrUpgradeEndMsg() {
        byte[] bArr = {4};
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            serialTools.sendBytes(bArr);
        }
    }

    public void sendMsg(int i2, int i3, String str, OnTextMessageListener onTextMessageListener) {
        this.f1681w = onTextMessageListener;
        if (!this.f1661c) {
            onTextMessageListener.OnCallback(ERROR);
            return;
        }
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        int i4 = length + 14;
        byte[] bArr = new byte[i4];
        bArr[0] = 104;
        bArr[1] = 44;
        bArr[2] = 1;
        bArr[3] = 1;
        bArr[4] = 0;
        bArr[5] = 0;
        int i5 = length + 5;
        bArr[6] = (byte) (65280 & i5);
        bArr[7] = (byte) (i5 & 255);
        bArr[8] = (byte) (i2 & 255);
        bArr[9] = (byte) (i3 & 255);
        bArr[10] = (byte) ((i3 >> 8) & 255);
        bArr[11] = (byte) ((i3 >> 16) & 255);
        bArr[12] = (byte) ((i3 >> 24) & 255);
        bArr[length + 13] = 16;
        System.arraycopy(bytes, 0, bArr, 13, bytes.length);
        byte[] bArrCheckSumBytes = CRC.checkSumBytes(bArr, i4);
        g.b(bArr, g.a(bArrCheckSumBytes, 0, bArr, 4, bArrCheckSumBytes.length, "sendMsg, cmd result = "), this);
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            serialTools.sendBytes(bArr);
        }
    }

    public void sendUpgradeDataPackage(int i2, byte[] bArr) {
        byte[] bArr2 = new byte[1029];
        bArr2[0] = (byte) 2;
        bArr2[1] = (byte) i2;
        bArr2[2] = (byte) (~i2);
        byte[] bArr3 = new byte[Optimizer.OPTIMIZATION_GROUPING];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr3, 0, bArr2, 3, Optimizer.OPTIMIZATION_GROUPING);
        byte[] bArrCalculateCRC16XMODEM = CRC.calculateCRC16XMODEM(bArr3);
        System.arraycopy(bArrCalculateCRC16XMODEM, 0, bArr2, 1027, bArrCalculateCRC16XMODEM.length);
        StringBuilder sb = new StringBuilder();
        sb.append("2053 sendUpgradeDataPackage, cmd result = ");
        g.b(bArr2, sb, this);
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            serialTools.sendBytes(bArr2);
        }
    }

    public void sendUpgradeFirstPackage(String str) {
        byte[] bArr = new byte[133];
        bArr[0] = (byte) 1;
        bArr[1] = (byte) 0;
        bArr[2] = (byte) (-1);
        int length = "Filename.bin".getBytes().length;
        byte[] bArr2 = new byte[length];
        System.arraycopy("Filename.bin".getBytes(), 0, bArr2, 0, length);
        System.arraycopy(bArr2, 0, bArr, 3, length);
        System.arraycopy(str.getBytes(), 0, bArr, length + 4, str.getBytes().length);
        byte[] bArr3 = new byte[Optimizer.OPTIMIZATION_GRAPH_WRAP];
        System.arraycopy(bArr, 3, bArr3, 0, Optimizer.OPTIMIZATION_GRAPH_WRAP);
        byte[] bArrCalculateCRC16XMODEM = CRC.calculateCRC16XMODEM(bArr3);
        g.b(bArr, g.a(bArrCalculateCRC16XMODEM, 0, bArr, 131, bArrCalculateCRC16XMODEM.length, "sendUpgradeFirstPackage, cmd result = "), this);
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            serialTools.sendBytes(bArr);
        }
    }

    public void sendUpgradeLastPackage(int i2) {
        byte[] bArr = new byte[133];
        bArr[0] = 1;
        bArr[1] = (byte) i2;
        bArr[2] = (byte) (~i2);
        StringBuilder sb = new StringBuilder();
        sb.append("sendUpgradeLastPackage, cmd result = ");
        g.b(bArr, sb, this);
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            serialTools.sendBytes(bArr);
        }
    }

    public void setAnalogCmd(AnalogCommand analogCommand, OnAnalogCmdListener onAnalogCmdListener) {
        this.f1674p = onAnalogCmdListener;
        if (!this.f1661c) {
            onAnalogCmdListener.OnCallback(ERROR);
            return;
        }
        byte[] bArr = {104, 35, 1, 1, 0, 0, 0, 19, (byte) (analogCommand.getRx_freq() & 255), (byte) ((analogCommand.getRx_freq() >> 8) & 255), (byte) ((analogCommand.getRx_freq() >> 16) & 255), (byte) ((analogCommand.getRx_freq() >> 24) & 255), (byte) (analogCommand.getTx_freq() & 255), (byte) ((analogCommand.getTx_freq() >> 8) & 255), (byte) ((analogCommand.getTx_freq() >> 16) & 255), (byte) ((analogCommand.getTx_freq() >> 24) & 255), analogCommand.getBand(), analogCommand.getPower(), analogCommand.getSq(), analogCommand.getRx_type(), analogCommand.getRx_subcode(), analogCommand.getTx_type(), analogCommand.getTx_subcode(), analogCommand.getPwrsave(), analogCommand.getVolume(), analogCommand.getMonitor(), analogCommand.getRelay(), 16};
        a("setAnalogCmd, 校验前数据 = " + HexStringUtils.toHexString(bArr));
        byte[] bArrCheckSumBytes = CRC.checkSumBytes(bArr, 28);
        StringBuilder sb = new StringBuilder();
        sb.append("setAnalogCmd, 校验和 = ");
        g.b(bArrCheckSumBytes, sb, this);
        g.b(bArr, g.a(bArrCheckSumBytes, 0, bArr, 4, bArrCheckSumBytes.length, "setAnalogCmd, cmd-result = "), this);
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            serialTools.sendBytes(bArr);
        }
    }

    public void setDebug(boolean z2) {
        this.f1660b = z2;
    }

    public void setDigitalCmd(DigitalCommand digitalCommand, OnDigitalCmdListener onDigitalCmdListener) {
        this.f1673o = onDigitalCmdListener;
        if (!this.f1661c) {
            onDigitalCmdListener.OnCallback(ERROR);
            return;
        }
        byte[] bArr = new byte[172];
        bArr[0] = 104;
        bArr[1] = 34;
        bArr[2] = 1;
        bArr[3] = 1;
        bArr[4] = 0;
        bArr[5] = 0;
        bArr[6] = 0;
        bArr[7] = -93;
        bArr[8] = (byte) (digitalCommand.getRx_freq() & 255);
        bArr[9] = (byte) ((digitalCommand.getRx_freq() >> 8) & 255);
        bArr[10] = (byte) ((digitalCommand.getRx_freq() >> 16) & 255);
        bArr[11] = (byte) ((digitalCommand.getRx_freq() >> 24) & 255);
        bArr[12] = (byte) (digitalCommand.getTx_freq() & 255);
        bArr[13] = (byte) ((digitalCommand.getTx_freq() >> 8) & 255);
        bArr[14] = (byte) ((digitalCommand.getTx_freq() >> 16) & 255);
        bArr[15] = (byte) ((digitalCommand.getTx_freq() >> 24) & 255);
        bArr[16] = (byte) (digitalCommand.getLocalId() & 255);
        bArr[17] = (byte) ((digitalCommand.getLocalId() >> 8) & 255);
        bArr[18] = (byte) ((digitalCommand.getLocalId() >> 16) & 255);
        bArr[19] = (byte) ((digitalCommand.getLocalId() >> 24) & 255);
        bArr[148] = (byte) (digitalCommand.getTx_contact() & 255);
        bArr[149] = (byte) ((digitalCommand.getTx_contact() >> 8) & 255);
        bArr[150] = (byte) ((digitalCommand.getTx_contact() >> 16) & 255);
        bArr[151] = (byte) ((digitalCommand.getTx_contact() >> 24) & 255);
        bArr[152] = digitalCommand.getContactType();
        bArr[153] = digitalCommand.getPower();
        bArr[154] = digitalCommand.getCc();
        bArr[155] = digitalCommand.getInboundSlot();
        bArr[156] = digitalCommand.getOutboundSlot();
        bArr[157] = digitalCommand.getChannelMode();
        bArr[158] = digitalCommand.getEncryptSw();
        bArr[167] = digitalCommand.getPwrsave();
        bArr[168] = digitalCommand.getVolume();
        bArr[169] = digitalCommand.getMic();
        bArr[170] = digitalCommand.getRelay();
        bArr[171] = 16;
        for (int i2 = 0; i2 < digitalCommand.getGroupList().length; i2++) {
            System.arraycopy(a(digitalCommand.getGroupList()[i2]), 0, bArr, (i2 * 4) + 20, a(digitalCommand.getGroupList()[i2]).length);
        }
        StringBuilder sbA = g.a(digitalCommand.getEncryptKey(), 0, bArr, 159, digitalCommand.getEncryptKey().length, "setDigitalCmd, 校验前数据 = ");
        sbA.append(HexStringUtils.toHexString(bArr));
        a(sbA.toString());
        byte[] bArrCheckSumBytes = CRC.checkSumBytes(bArr, 172);
        StringBuilder sb = new StringBuilder();
        sb.append("setDigitalCmd, 校验和 = ");
        g.b(bArrCheckSumBytes, sb, this);
        g.b(bArr, g.a(bArrCheckSumBytes, 0, bArr, 4, bArrCheckSumBytes.length, "setDigitalCmd, cmd-result = "), this);
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            serialTools.sendBytes(bArr);
        }
    }

    public void setDmrUpgrade(boolean z2) {
        this.O = z2;
    }

    public void setDmrUpgradeListener(OnUpgradeModeListener onUpgradeModeListener) {
        this.N = onUpgradeModeListener;
    }

    public void setDmrUpgradeProcessStage(int i2) {
        this.M = i2;
    }

    public void setEncryption(int i2, byte[] bArr, OnEncryptionListener onEncryptionListener) {
        this.f1678t = onEncryptionListener;
        if (!this.f1661c) {
            onEncryptionListener.OnCallback(ERROR);
            return;
        }
        byte[] bArr2 = {104, 41, 1, 1, 0, 0, 0, 9, (byte) i2, 0, 0, 0, 0, 0, 0, 0, 0, 16};
        System.arraycopy(bArr, 0, bArr2, 9, bArr.length);
        byte[] bArrCheckSumBytes = CRC.checkSumBytes(bArr2, 18);
        g.b(bArr2, g.a(bArrCheckSumBytes, 0, bArr2, 4, bArrCheckSumBytes.length, "checkInitComplete, cmd-result = "), this);
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            serialTools.sendBytes(bArr2);
        }
    }

    public void setEnhanceListener(OnEnhanceListener onEnhanceListener) {
        this.L = onEnhanceListener;
    }

    public void setEnhancements(int i2, int i3, OnEnhancementsListener onEnhancementsListener) {
        this.f1677s = onEnhancementsListener;
        if (!this.f1661c) {
            onEnhancementsListener.OnCallback(ERROR);
            return;
        }
        byte[] bArr = {104, 40, 1, 1, 0, 0, 0, 5, (byte) i2, (byte) (i3 & 255), (byte) ((i3 >> 8) & 255), (byte) ((i3 >> 16) & 255), (byte) ((i3 >> 24) & 255), 16};
        byte[] bArrCheckSumBytes = CRC.checkSumBytes(bArr, 14);
        g.b(bArr, g.a(bArrCheckSumBytes, 0, bArr, 4, bArrCheckSumBytes.length, "checkInitComplete, cmd-result = "), this);
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            serialTools.sendBytes(bArr);
        }
    }

    public void setHasSmsLocalId(boolean z2) {
        this.hasSmsLocalId = z2;
    }

    public void setMessageEncode(String str) {
        Log.d(this.f1659a, "setMessageEncode,encode = " + str);
        this.f1672n = str;
    }

    public void setMicGain(int i2, OnMicGainListener onMicGainListener) {
        this.f1679u = onMicGainListener;
        if (!this.f1661c) {
            onMicGainListener.OnCallback(ERROR);
            return;
        }
        byte[] bArr = {104, 42, 1, 1, 0, 0, 0, 1, (byte) i2, 16};
        byte[] bArrCheckSumBytes = CRC.checkSumBytes(bArr, 10);
        g.b(bArr, g.a(bArrCheckSumBytes, 0, bArr, 4, bArrCheckSumBytes.length, "setMicGain, cmd result = "), this);
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            serialTools.sendBytes(bArr);
        }
    }

    public void setMonitor(int i2, OnMonitorListener onMonitorListener) {
        this.f1684z = onMonitorListener;
        if (!this.f1661c) {
            onMonitorListener.OnCallback(ERROR);
            return;
        }
        byte[] bArr = {104, 47, 1, 1, 0, 0, 0, 1, (byte) i2, 16};
        byte[] bArrCheckSumBytes = CRC.checkSumBytes(bArr, 10);
        g.b(bArr, g.a(bArrCheckSumBytes, 0, bArr, 4, bArrCheckSumBytes.length, "setMonitor, cmd result = "), this);
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            serialTools.sendBytes(bArr);
        }
    }

    public void setPolite(int i2, OnPolicyListener onPolicyListener) {
        this.H = onPolicyListener;
        if (!this.f1661c) {
            onPolicyListener.OnCallback(ERROR);
            return;
        }
        byte[] bArr = {104, 55, 1, 1, 0, 0, 0, 1, (byte) i2, 16};
        byte[] bArrCheckSumBytes = CRC.checkSumBytes(bArr, 10);
        g.b(bArr, g.a(bArrCheckSumBytes, 0, bArr, 4, bArrCheckSumBytes.length, "setPolite, cmd result = "), this);
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            serialTools.sendBytes(bArr);
        }
    }

    public void setPowerOnListener(OnPowerOnListener onPowerOnListener) {
        this.f1663e = onPowerOnListener;
    }

    public void setPowerSavingMode(int i2, OnPowerSavingModeListener onPowerSavingModeListener) {
        this.B = onPowerSavingModeListener;
        if (!this.f1661c) {
            onPowerSavingModeListener.OnCallback(ERROR);
            return;
        }
        byte[] bArr = {104, 49, 1, 1, 0, 0, 0, 1, (byte) i2, 16};
        byte[] bArrCheckSumBytes = CRC.checkSumBytes(bArr, 10);
        g.b(bArr, g.a(bArrCheckSumBytes, 0, bArr, 4, bArrCheckSumBytes.length, "setPowerSavingMode, cmd result = "), this);
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            serialTools.sendBytes(bArr);
        }
    }

    public void setRelayOffline(int i2, OnRelayOfflineListener onRelayOfflineListener) {
        this.D = onRelayOfflineListener;
        if (!this.f1661c) {
            onRelayOfflineListener.OnCallback(ERROR);
            return;
        }
        byte[] bArr = {104, 51, 1, 1, 0, 0, 0, 1, (byte) i2, 16};
        byte[] bArrCheckSumBytes = CRC.checkSumBytes(bArr, 10);
        g.b(bArr, g.a(bArrCheckSumBytes, 0, bArr, 4, bArrCheckSumBytes.length, "setRelayOffline, cmd result = "), this);
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            serialTools.sendBytes(bArr);
        }
    }

    public void setReportStatus(OnReportStatusListener onReportStatusListener) {
        this.G = onReportStatusListener;
    }

    public void setSendDataDely(int i2) {
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            serialTools.setDelayWriteDataTime(i2);
        }
    }

    public void setSmsProtocolType(int i2, OnSmsProtocolTypeListener onSmsProtocolTypeListener) {
        this.I = onSmsProtocolTypeListener;
        if (!this.f1661c) {
            onSmsProtocolTypeListener.OnCallback(ERROR);
            return;
        }
        byte[] bArr = {104, 58, 1, 1, 0, 0, 0, 1, (byte) i2, 16};
        byte[] bArrCheckSumBytes = CRC.checkSumBytes(bArr, 10);
        g.b(bArr, g.a(bArrCheckSumBytes, 0, bArr, 4, bArrCheckSumBytes.length, "setSmsProtocolType, cmd result = "), this);
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            serialTools.sendBytes(bArr);
        }
    }

    public void setSpkEn(int i2, OnSpkEnListener onSpkEnListener) {
        this.K = onSpkEnListener;
        if (!this.f1661c) {
            onSpkEnListener.OnCallback(ERROR);
            return;
        }
        byte[] bArr = {104, 60, 1, 1, 0, 0, 0, 1, (byte) i2, 16};
        byte[] bArrCheckSumBytes = CRC.checkSumBytes(bArr, 10);
        g.b(bArr, g.a(bArrCheckSumBytes, 0, bArr, 4, bArrCheckSumBytes.length, "setSpkEn, cmd result = "), this);
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            serialTools.sendBytes(bArr);
        }
    }

    public void setSquelch(int i2, OnSquelchListener onSquelchListener) {
        this.A = onSquelchListener;
        if (!this.f1661c) {
            onSquelchListener.OnCallback(ERROR);
            return;
        }
        byte[] bArr = {104, 48, 1, 1, 0, 0, 0, 1, (byte) i2, 16};
        byte[] bArrCheckSumBytes = CRC.checkSumBytes(bArr, 10);
        g.b(bArr, g.a(bArrCheckSumBytes, 0, bArr, 4, bArrCheckSumBytes.length, "setSquelch, cmd result = "), this);
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            serialTools.sendBytes(bArr);
        }
    }

    public void setTot(int i2, OnTotListener onTotListener) {
        this.J = onTotListener;
        if (!this.f1661c) {
            onTotListener.OnCallback(ERROR);
            return;
        }
        byte[] bArr = {104, 59, 1, 1, 0, 0, 0, 1, (byte) i2, 16};
        byte[] bArrCheckSumBytes = CRC.checkSumBytes(bArr, 10);
        g.b(bArr, g.a(bArrCheckSumBytes, 0, bArr, 4, bArrCheckSumBytes.length, "setTot, cmd result = "), this);
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            serialTools.sendBytes(bArr);
        }
    }

    public void setTransferInterrupt(int i2, OnTransferInterruptListener onTransferInterruptListener) {
        this.F = onTransferInterruptListener;
        if (!this.f1661c) {
            onTransferInterruptListener.OnCallback(ERROR);
            return;
        }
        Log.d(this.f1659a, "setTransferInterrupt, mode = " + i2);
        byte[] bArr = {104, 53, 1, 1, 0, 0, 0, 1, (byte) i2, 16};
        byte[] bArrCheckSumBytes = CRC.checkSumBytes(bArr, 10);
        g.b(bArr, g.a(bArrCheckSumBytes, 0, bArr, 4, bArrCheckSumBytes.length, "setTransferInterrupt, cmd result = "), this);
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            serialTools.sendBytes(bArr);
        }
    }

    public void setVolume(int i2, OnVolumeListener onVolumeListener) {
        this.f1683y = onVolumeListener;
        if (!this.f1661c) {
            onVolumeListener.OnCallback(ERROR);
            return;
        }
        byte[] bArr = {104, 46, 1, 1, 0, 0, 0, 1, (byte) i2, 16};
        byte[] bArrCheckSumBytes = CRC.checkSumBytes(bArr, 10);
        g.b(bArr, g.a(bArrCheckSumBytes, 0, bArr, 4, bArrCheckSumBytes.length, "setVolume, cmd result = "), this);
        SerialTools serialTools = this.f1668j;
        if (serialTools != null) {
            serialTools.sendBytes(bArr);
        }
    }

    public int setupSerial(int i2, int i3, char c2, int i4) {
        if (this.f1666h <= 0) {
            return -1;
        }
        int i5 = this.f1668j.setupSerial(i2, i3, c2, i4);
        if (!this.f1660b) {
            return i5;
        }
        Log.i(this.f1659a, "打开串口成功！");
        return i5;
    }

    public final void a(String str, int i2) {
        Handler handler = this.f1664f;
        if (handler != null) {
            Message messageObtainMessage = handler.obtainMessage();
            messageObtainMessage.what = Optimizer.OPTIMIZATION_STANDARD;
            messageObtainMessage.obj = str;
            messageObtainMessage.arg1 = i2;
            this.f1664f.sendMessageDelayed(messageObtainMessage, 10);
        }
    }

    public void closeSerial(int i2) {
        if (this.f1666h > 0) {
            this.f1668j.closeSerial(i2);
            this.f1668j.setOnDataReceiveListener(null);
            this.f1666h = -1;
            if (this.f1660b) {
                Log.i(this.f1659a, "关闭串口成功！");
            }
        }
    }

    public final byte[] a(int i2) {
        return new byte[]{(byte) (i2 & 255), (byte) ((i2 >> 8) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 24) & 255)};
    }

    public final void a() {
        this.f1667i = new Object();
        if (this.f1668j == null) {
            this.f1668j = SerialTools.getInstance();
        }
        int i2 = 0;
        this.f1662d = new Handler(new c(i2, this));
        HandlerThread handlerThread = new HandlerThread("work-handlerthread");
        this.f1665g = handlerThread;
        handlerThread.start();
        this.f1664f = new b(this, this.f1665g.getLooper(), i2);
    }

    public final void a(byte[] bArr) {
        Message messageObtainMessage;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        Message messageObtainMessage2;
        int i2;
        String str10;
        String str11;
        int i3;
        String str12;
        String str13;
        String str14;
        int i4;
        int i5;
        String str15;
        String str16;
        String str17;
        String str18;
        Handler handler;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        char c2 = bArr[1];
        if (c2 == '\"') {
            char c3 = bArr[3];
            if (c3 == 0) {
                if (this.f1660b) {
                    str23 = "设置数字组命令，设置成功";
                    Log.i(this.f1659a, str23);
                }
                messageObtainMessage2 = this.f1662d.obtainMessage();
                messageObtainMessage2.what = 277;
                i2 = bArr[3];
            } else if (c3 == 1) {
                if (this.f1660b) {
                    str23 = "设置数字组命令，设置失败";
                    Log.i(this.f1659a, str23);
                }
                messageObtainMessage2 = this.f1662d.obtainMessage();
                messageObtainMessage2.what = 277;
                i2 = bArr[3];
            } else {
                if (c3 == 2 && this.f1660b) {
                    str23 = "设置数字组命令，校验错误";
                    Log.i(this.f1659a, str23);
                }
                messageObtainMessage2 = this.f1662d.obtainMessage();
                messageObtainMessage2.what = 277;
                i2 = bArr[3];
            }
            handler.sendMessage(messageObtainMessage2);
        }
        if (c2 == '#') {
            char c4 = bArr[3];
            if (c4 == 0) {
                if (this.f1660b) {
                    str22 = "设置模拟组命令，设置成功";
                    Log.i(this.f1659a, str22);
                }
                messageObtainMessage2 = this.f1662d.obtainMessage();
                messageObtainMessage2.what = 276;
                i2 = bArr[3];
            } else if (c4 == 1) {
                if (this.f1660b) {
                    str22 = "设置模拟组命令，设置失败";
                    Log.i(this.f1659a, str22);
                }
                messageObtainMessage2 = this.f1662d.obtainMessage();
                messageObtainMessage2.what = 276;
                i2 = bArr[3];
            } else {
                if (c4 == 2 && this.f1660b) {
                    str22 = "设置模拟组命令，校验错误";
                    Log.i(this.f1659a, str22);
                }
                messageObtainMessage2 = this.f1662d.obtainMessage();
                messageObtainMessage2.what = 276;
                i2 = bArr[3];
            }
            handler.sendMessage(messageObtainMessage2);
        }
        if (c2 == '&') {
            char c5 = bArr[3];
            if (c5 == 0) {
                if (this.f1660b) {
                    str21 = "发射命令，设置成功";
                    Log.i(this.f1659a, str21);
                }
                messageObtainMessage2 = this.f1662d.obtainMessage();
                messageObtainMessage2.what = 256;
                i2 = bArr[3];
            } else if (c5 == 1) {
                if (this.f1660b) {
                    str21 = "发射命令，设置失败";
                    Log.i(this.f1659a, str21);
                }
                messageObtainMessage2 = this.f1662d.obtainMessage();
                messageObtainMessage2.what = 256;
                i2 = bArr[3];
            } else {
                if (c5 == 2 && this.f1660b) {
                    str21 = "发射命令，校验错误";
                    Log.i(this.f1659a, str21);
                }
                messageObtainMessage2 = this.f1662d.obtainMessage();
                messageObtainMessage2.what = 256;
                i2 = bArr[3];
            }
            handler.sendMessage(messageObtainMessage2);
        }
        if (c2 == '\'') {
            char c6 = bArr[3];
            if (c6 == 0) {
                if (this.f1660b) {
                    str20 = "查询是否初始化完成指令，设置成功";
                    Log.i(this.f1659a, str20);
                }
                messageObtainMessage2 = this.f1662d.obtainMessage();
                messageObtainMessage2.what = Optimizer.OPTIMIZATION_STANDARD;
                i2 = bArr[3];
            } else if (c6 == 1) {
                if (this.f1660b) {
                    str20 = "查询是否初始化完成指令，设置失败";
                    Log.i(this.f1659a, str20);
                }
                messageObtainMessage2 = this.f1662d.obtainMessage();
                messageObtainMessage2.what = Optimizer.OPTIMIZATION_STANDARD;
                i2 = bArr[3];
            } else {
                if (c6 == 2 && this.f1660b) {
                    str20 = "查询是否初始化完成指令，校验错误";
                    Log.i(this.f1659a, str20);
                }
                messageObtainMessage2 = this.f1662d.obtainMessage();
                messageObtainMessage2.what = Optimizer.OPTIMIZATION_STANDARD;
                i2 = bArr[3];
            }
            handler.sendMessage(messageObtainMessage2);
        }
        if (c2 == '(') {
            char c7 = bArr[2];
            if (c7 == 0) {
                char c8 = bArr[3];
                if (c8 == 0) {
                    if (this.f1660b) {
                        str19 = "设置增强功能，设置成功";
                        Log.i(this.f1659a, str19);
                    }
                    messageObtainMessage2 = this.f1662d.obtainMessage();
                    messageObtainMessage2.what = 261;
                    i2 = bArr[3];
                } else if (c8 == 1) {
                    if (this.f1660b) {
                        str19 = "设置增强功能，设置失败";
                        Log.i(this.f1659a, str19);
                    }
                    messageObtainMessage2 = this.f1662d.obtainMessage();
                    messageObtainMessage2.what = 261;
                    i2 = bArr[3];
                } else {
                    if (c8 == 2 && this.f1660b) {
                        str19 = "设置增强功能，校验错误";
                        Log.i(this.f1659a, str19);
                    }
                    messageObtainMessage2 = this.f1662d.obtainMessage();
                    messageObtainMessage2.what = 261;
                    i2 = bArr[3];
                }
            } else {
                if (c7 != 2) {
                    return;
                }
                String str24 = "设置增强功能，失败";
                if (bArr.length == 14) {
                    messageObtainMessage2 = this.f1662d.obtainMessage();
                    messageObtainMessage2.what = 262;
                    if (bArr[3] == 0) {
                        if (this.f1660b) {
                            Log.i(this.f1659a, "设置增强功能，成功");
                        }
                        messageObtainMessage2.arg1 = bArr[8] & 255;
                        messageObtainMessage2.arg2 = ((bArr[12] << 24) & (-16777216)) | (bArr[9] & 255) | ((bArr[10] << 8) & 65280) | ((bArr[11] << 16) & 16711680);
                    } else if (this.f1660b) {
                        Log.i(this.f1659a, "设置增强功能，失败");
                    }
                    handler = this.f1662d;
                } else {
                    if (bArr.length != 10) {
                        return;
                    }
                    a("设置增强功能，data.length = " + bArr.length);
                    if (bArr[3] == 0) {
                        if (this.f1660b) {
                            str24 = "设置增强功能，成功";
                            Log.i(this.f1659a, str24);
                        }
                        messageObtainMessage2 = this.f1662d.obtainMessage();
                        messageObtainMessage2.what = 263;
                        i2 = bArr[8];
                    } else {
                        if (this.f1660b) {
                            Log.i(this.f1659a, str24);
                        }
                        messageObtainMessage2 = this.f1662d.obtainMessage();
                        messageObtainMessage2.what = 263;
                        i2 = bArr[8];
                    }
                }
            }
        } else if (c2 == ')') {
            char c9 = bArr[3];
            if (c9 == 0) {
                if (this.f1660b) {
                    str18 = "设置 加密功能，设置成功";
                    Log.i(this.f1659a, str18);
                }
                messageObtainMessage2 = this.f1662d.obtainMessage();
                messageObtainMessage2.what = 265;
                i2 = bArr[3];
            } else if (c9 == 1) {
                if (this.f1660b) {
                    str18 = "设置 加密功能，设置失败";
                    Log.i(this.f1659a, str18);
                }
                messageObtainMessage2 = this.f1662d.obtainMessage();
                messageObtainMessage2.what = 265;
                i2 = bArr[3];
            } else {
                if (c9 == 2 && this.f1660b) {
                    str18 = "设置 加密功能，校验错误";
                    Log.i(this.f1659a, str18);
                }
                messageObtainMessage2 = this.f1662d.obtainMessage();
                messageObtainMessage2.what = 265;
                i2 = bArr[3];
            }
        } else if (c2 == '*') {
            char c10 = bArr[3];
            if (c10 == 0) {
                if (this.f1660b) {
                    str17 = "MIC 增益，设置成功";
                    Log.i(this.f1659a, str17);
                }
                messageObtainMessage2 = this.f1662d.obtainMessage();
                messageObtainMessage2.what = 258;
                i2 = bArr[3];
            } else if (c10 == 1) {
                if (this.f1660b) {
                    str17 = "MIC 增益，设置失败";
                    Log.i(this.f1659a, str17);
                }
                messageObtainMessage2 = this.f1662d.obtainMessage();
                messageObtainMessage2.what = 258;
                i2 = bArr[3];
            } else {
                if (c10 == 2 && this.f1660b) {
                    str17 = "MIC 增益，校验错误";
                    Log.i(this.f1659a, str17);
                }
                messageObtainMessage2 = this.f1662d.obtainMessage();
                messageObtainMessage2.what = 258;
                i2 = bArr[3];
            }
        } else {
            if (c2 == '+') {
                char c11 = bArr[3];
                if (c11 == 0) {
                    if (this.f1660b) {
                        str16 = "数字语音接收信息，设置成功";
                        Log.i(this.f1659a, str16);
                    }
                    DigitalVoiceReceptionInfo digitalVoiceReceptionInfo = new DigitalVoiceReceptionInfo();
                    digitalVoiceReceptionInfo.setType(bArr[8] & 255);
                    digitalVoiceReceptionInfo.setId((bArr[9] & 255) | ((bArr[10] << 8) & 65280) | ((bArr[11] << 16) & 16711680) | ((bArr[12] << 24) & (-16777216)));
                    digitalVoiceReceptionInfo.setNumber((bArr[13] & 255) | ((bArr[14] << 8) & 65280) | ((bArr[15] << 16) & 16711680) | ((bArr[16] << 24) & (-16777216)));
                    messageObtainMessage = this.f1662d.obtainMessage();
                    messageObtainMessage.what = 259;
                    messageObtainMessage.arg1 = bArr[3];
                    messageObtainMessage.obj = digitalVoiceReceptionInfo;
                } else if (c11 == 1) {
                    if (this.f1660b) {
                        str16 = "数字语音接收信息，设置失败";
                        Log.i(this.f1659a, str16);
                    }
                    DigitalVoiceReceptionInfo digitalVoiceReceptionInfo2 = new DigitalVoiceReceptionInfo();
                    digitalVoiceReceptionInfo2.setType(bArr[8] & 255);
                    digitalVoiceReceptionInfo2.setId((bArr[9] & 255) | ((bArr[10] << 8) & 65280) | ((bArr[11] << 16) & 16711680) | ((bArr[12] << 24) & (-16777216)));
                    digitalVoiceReceptionInfo2.setNumber((bArr[13] & 255) | ((bArr[14] << 8) & 65280) | ((bArr[15] << 16) & 16711680) | ((bArr[16] << 24) & (-16777216)));
                    messageObtainMessage = this.f1662d.obtainMessage();
                    messageObtainMessage.what = 259;
                    messageObtainMessage.arg1 = bArr[3];
                    messageObtainMessage.obj = digitalVoiceReceptionInfo2;
                } else {
                    if (c11 == 2 && this.f1660b) {
                        str16 = "数字语音接收信息，校验错误";
                        Log.i(this.f1659a, str16);
                    }
                    DigitalVoiceReceptionInfo digitalVoiceReceptionInfo22 = new DigitalVoiceReceptionInfo();
                    digitalVoiceReceptionInfo22.setType(bArr[8] & 255);
                    digitalVoiceReceptionInfo22.setId((bArr[9] & 255) | ((bArr[10] << 8) & 65280) | ((bArr[11] << 16) & 16711680) | ((bArr[12] << 24) & (-16777216)));
                    digitalVoiceReceptionInfo22.setNumber((bArr[13] & 255) | ((bArr[14] << 8) & 65280) | ((bArr[15] << 16) & 16711680) | ((bArr[16] << 24) & (-16777216)));
                    messageObtainMessage = this.f1662d.obtainMessage();
                    messageObtainMessage.what = 259;
                    messageObtainMessage.arg1 = bArr[3];
                    messageObtainMessage.obj = digitalVoiceReceptionInfo22;
                }
            } else if (c2 == ',') {
                char c12 = bArr[3];
                if (c12 == 0) {
                    if (this.f1660b) {
                        str15 = "发送短信，设置成功";
                        Log.i(this.f1659a, str15);
                    }
                    messageObtainMessage2 = this.f1662d.obtainMessage();
                    messageObtainMessage2.what = 264;
                    i2 = bArr[3];
                } else if (c12 == 1) {
                    if (this.f1660b) {
                        str15 = "发送短信，设置失败";
                        Log.i(this.f1659a, str15);
                    }
                    messageObtainMessage2 = this.f1662d.obtainMessage();
                    messageObtainMessage2.what = 264;
                    i2 = bArr[3];
                } else {
                    if (c12 == 2 && this.f1660b) {
                        str15 = "发送短信，校验错误";
                        Log.i(this.f1659a, str15);
                    }
                    messageObtainMessage2 = this.f1662d.obtainMessage();
                    messageObtainMessage2.what = 264;
                    i2 = bArr[3];
                }
            } else {
                int i6 = 0;
                if (c2 == '-') {
                    messageObtainMessage = this.f1662d.obtainMessage();
                    messageObtainMessage.what = 275;
                    char c13 = bArr[3];
                    if (c13 == 0) {
                        int i7 = ((bArr[6] << 8) & 65280) | (bArr[7] & 255);
                        a("获取短信，设置成功 信息长度：" + i7);
                        if (i7 != 0 && i7 > 0) {
                            if (isHasSmsLocalId()) {
                                i4 = bArr[8];
                                i5 = (bArr[9] & 255) | ((bArr[10] << 8) & 65280) | ((bArr[11] << 16) & 16711680) | ((bArr[12] << 24) & (-16777216));
                                char c14 = bArr[13];
                                char c15 = bArr[14];
                                char c16 = bArr[15];
                                char c17 = bArr[16];
                                int i8 = i7 - 9;
                                byte[] bArr2 = new byte[i8];
                                System.arraycopy(bArr, 17, bArr2, 0, i8);
                                str14 = new String(bArr2);
                            } else {
                                i4 = bArr[8];
                                i5 = (bArr[9] & 255) | ((bArr[10] << 8) & 65280) | ((bArr[11] << 16) & 16711680) | ((bArr[12] << 24) & (-16777216));
                                int i9 = i7 - 5;
                                byte[] bArr3 = new byte[i9];
                                System.arraycopy(bArr, 13, bArr3, 0, i9);
                                str14 = new String(bArr3);
                                a("获取短信，设置成功 , type = " + i4 + " callId = " + i5 + " localId = [0] sms：[" + HexStringUtils.toHexString(bArr3) + "]");
                            }
                            i6 = i5;
                        }
                        messageObtainMessage.arg1 = ((bArr[3] << 8) & 65280) | i4;
                        messageObtainMessage.arg2 = i6;
                        messageObtainMessage.obj = str14;
                    } else if (c13 == 1) {
                        if (this.f1660b) {
                            str13 = "获取短信，设置失败";
                            Log.i(this.f1659a, str13);
                        }
                    } else if (c13 == 2 && this.f1660b) {
                        str13 = "获取短信，校验错误";
                        Log.i(this.f1659a, str13);
                    }
                    str14 = "";
                    i4 = 0;
                    messageObtainMessage.arg1 = ((bArr[3] << 8) & 65280) | i4;
                    messageObtainMessage.arg2 = i6;
                    messageObtainMessage.obj = str14;
                } else if (c2 == '.') {
                    char c18 = bArr[3];
                    if (c18 == 0) {
                        if (this.f1660b) {
                            str12 = "设置音量，设置成功";
                            Log.i(this.f1659a, str12);
                        }
                        messageObtainMessage2 = this.f1662d.obtainMessage();
                        messageObtainMessage2.what = 260;
                        i2 = bArr[3];
                    } else if (c18 == 1) {
                        if (this.f1660b) {
                            str12 = "设置音量，设置失败";
                            Log.i(this.f1659a, str12);
                        }
                        messageObtainMessage2 = this.f1662d.obtainMessage();
                        messageObtainMessage2.what = 260;
                        i2 = bArr[3];
                    } else {
                        if (c18 == 2 && this.f1660b) {
                            str12 = "设置音量，校验错误";
                            Log.i(this.f1659a, str12);
                        }
                        messageObtainMessage2 = this.f1662d.obtainMessage();
                        messageObtainMessage2.what = 260;
                        i2 = bArr[3];
                    }
                } else if (c2 == '/') {
                    char c19 = bArr[3];
                    if (c19 == 0) {
                        if (this.f1660b) {
                            str11 = "设置监听，设置成功";
                            Log.i(this.f1659a, str11);
                        }
                        messageObtainMessage2 = this.f1662d.obtainMessage();
                        messageObtainMessage2.what = 266;
                        i3 = bArr[3];
                        messageObtainMessage2.arg1 = i3;
                        handler = this.f1662d;
                    } else if (c19 == 1) {
                        if (this.f1660b) {
                            str11 = "设置监听，设置失败";
                            Log.i(this.f1659a, str11);
                        }
                        messageObtainMessage2 = this.f1662d.obtainMessage();
                        messageObtainMessage2.what = 266;
                        i3 = bArr[3];
                        messageObtainMessage2.arg1 = i3;
                        handler = this.f1662d;
                    } else {
                        if (c19 == 2 && this.f1660b) {
                            str11 = "设置监听，校验错误";
                            Log.i(this.f1659a, str11);
                        }
                        messageObtainMessage2 = this.f1662d.obtainMessage();
                        messageObtainMessage2.what = 266;
                        i3 = bArr[3];
                        messageObtainMessage2.arg1 = i3;
                        handler = this.f1662d;
                    }
                } else if (c2 == '0') {
                    char c20 = bArr[3];
                    if (c20 == 0) {
                        if (this.f1660b) {
                            str10 = "设置静噪，设置成功";
                            Log.i(this.f1659a, str10);
                        }
                        messageObtainMessage2 = this.f1662d.obtainMessage();
                        messageObtainMessage2.what = 267;
                        i2 = bArr[3];
                    } else if (c20 == 1) {
                        if (this.f1660b) {
                            str10 = "设置静噪，设置失败";
                            Log.i(this.f1659a, str10);
                        }
                        messageObtainMessage2 = this.f1662d.obtainMessage();
                        messageObtainMessage2.what = 267;
                        i2 = bArr[3];
                    } else {
                        if (c20 == 2 && this.f1660b) {
                            str10 = "设置静噪，校验错误";
                            Log.i(this.f1659a, str10);
                        }
                        messageObtainMessage2 = this.f1662d.obtainMessage();
                        messageObtainMessage2.what = 267;
                        i2 = bArr[3];
                    }
                } else if (c2 == '1') {
                    char c21 = bArr[3];
                    if (c21 == 0) {
                        if (this.f1660b) {
                            str9 = "设置省电模式，设置成功";
                            Log.i(this.f1659a, str9);
                        }
                        messageObtainMessage2 = this.f1662d.obtainMessage();
                        messageObtainMessage2.what = 268;
                        i2 = bArr[3];
                    } else if (c21 == 1) {
                        if (this.f1660b) {
                            str9 = "设置省电模式，设置失败";
                            Log.i(this.f1659a, str9);
                        }
                        messageObtainMessage2 = this.f1662d.obtainMessage();
                        messageObtainMessage2.what = 268;
                        i2 = bArr[3];
                    } else {
                        if (c21 == 2 && this.f1660b) {
                            str9 = "设置省电模式，校验错误";
                            Log.i(this.f1659a, str9);
                        }
                        messageObtainMessage2 = this.f1662d.obtainMessage();
                        messageObtainMessage2.what = 268;
                        i2 = bArr[3];
                    }
                } else if (c2 == '2') {
                    messageObtainMessage = this.f1662d.obtainMessage();
                    messageObtainMessage.what = 269;
                    char c22 = bArr[3];
                    if (c22 == 0) {
                        if (this.f1660b) {
                            Log.i(this.f1659a, "获取信号强度，设置成功");
                        }
                        messageObtainMessage.arg2 = bArr[8] & 255;
                    } else {
                        if (c22 == 1) {
                            if (this.f1660b) {
                                Log.i(this.f1659a, "获取信号强度，设置失败");
                            }
                        } else if (c22 == 2) {
                            if (this.f1660b) {
                                Log.i(this.f1659a, "获取信号强度，校验错误");
                            }
                        }
                        messageObtainMessage.arg2 = ERROR;
                    }
                    messageObtainMessage.arg1 = bArr[3] & 255;
                } else if (c2 == '3') {
                    messageObtainMessage = this.f1662d.obtainMessage();
                    messageObtainMessage.what = 270;
                    char c23 = bArr[3];
                    if (c23 == 0) {
                        if (this.f1660b) {
                            Log.i(this.f1659a, "设置中继脱网，设置成功");
                        }
                    } else if (c23 == 1) {
                        if (this.f1660b) {
                            str8 = "设置中继脱网，设置失败";
                            Log.i(this.f1659a, str8);
                        }
                    } else if (c23 == 2 && this.f1660b) {
                        str8 = "设置中继脱网，校验错误";
                        Log.i(this.f1659a, str8);
                    }
                    messageObtainMessage.arg1 = bArr[3];
                } else if (c2 == '4') {
                    messageObtainMessage = this.f1662d.obtainMessage();
                    messageObtainMessage.what = 271;
                    char c24 = bArr[3];
                    if (c24 == 0) {
                        if (this.f1660b) {
                            Log.i(this.f1659a, "获取版本号，设置成功");
                        }
                        int i10 = ((bArr[6] << 8) & 65280) | (bArr[7] & 255);
                        byte[] bArr4 = new byte[i10];
                        a("获取版本号  data_len=" + i10);
                        System.arraycopy(bArr, 8, bArr4, 0, i10);
                        a(new String(bArr4) + " - 获取版本号  version=" + HexStringUtils.toHexString(bArr4));
                        messageObtainMessage.obj = new String(bArr4, StandardCharsets.UTF_8);
                    } else if (c24 == 1) {
                        if (this.f1660b) {
                            str7 = "获取版本号，设置失败";
                            Log.i(this.f1659a, str7);
                        }
                    } else if (c24 == 2 && this.f1660b) {
                        str7 = "获取版本号，校验错误";
                        Log.i(this.f1659a, str7);
                    }
                    messageObtainMessage.arg1 = bArr[3];
                } else if (c2 == '5') {
                    messageObtainMessage = this.f1662d.obtainMessage();
                    messageObtainMessage.what = 272;
                    char c25 = bArr[3];
                    if (c25 == 0) {
                        if (this.f1660b) {
                            str6 = "传输中断功能，设置成功";
                            Log.i(this.f1659a, str6);
                        }
                        messageObtainMessage.arg1 = bArr[3];
                    } else if (c25 == 1) {
                        if (this.f1660b) {
                            str6 = "传输中断功能，设置失败";
                            Log.i(this.f1659a, str6);
                        }
                        messageObtainMessage.arg1 = bArr[3];
                    } else {
                        if (c25 == 2 && this.f1660b) {
                            str6 = "传输中断功能，校验错误";
                            Log.i(this.f1659a, str6);
                        }
                        messageObtainMessage.arg1 = bArr[3];
                    }
                } else if (c2 == '6') {
                    messageObtainMessage = this.f1662d.obtainMessage();
                    messageObtainMessage.what = 273;
                    char c26 = bArr[3];
                    if (c26 == 0) {
                        if (this.f1660b) {
                            Log.i(this.f1659a, "模块上报状态信息，设置成功");
                        }
                        a("数据 ====》》》》》 【" + bArr[8] + "】");
                        messageObtainMessage.arg2 = bArr[8];
                    } else if (c26 == 1) {
                        if (this.f1660b) {
                            str5 = "模块上报状态信息，设置失败";
                            Log.i(this.f1659a, str5);
                        }
                    } else if (c26 == 2 && this.f1660b) {
                        str5 = "模块上报状态信息，校验错误";
                        Log.i(this.f1659a, str5);
                    }
                    messageObtainMessage.arg1 = bArr[3];
                } else if (c2 == '7') {
                    messageObtainMessage = this.f1662d.obtainMessage();
                    messageObtainMessage.what = 274;
                    char c27 = bArr[3];
                    if (c27 == 0) {
                        if (this.f1660b) {
                            str4 = "设置 polite 策略，设置成功";
                            Log.i(this.f1659a, str4);
                        }
                        messageObtainMessage.arg1 = bArr[3];
                    } else if (c27 == 1) {
                        if (this.f1660b) {
                            str4 = "设置 polite 策略，设置失败";
                            Log.i(this.f1659a, str4);
                        }
                        messageObtainMessage.arg1 = bArr[3];
                    } else {
                        if (c27 == 2 && this.f1660b) {
                            str4 = "设置 polite 策略，校验错误";
                            Log.i(this.f1659a, str4);
                        }
                        messageObtainMessage.arg1 = bArr[3];
                    }
                } else if (c2 == ':') {
                    messageObtainMessage = this.f1662d.obtainMessage();
                    messageObtainMessage.what = 279;
                    char c28 = bArr[3];
                    if (c28 == 0) {
                        if (this.f1660b) {
                            str3 = "设置发送短信协议类型，设置成功";
                            Log.i(this.f1659a, str3);
                        }
                        messageObtainMessage.arg1 = bArr[3];
                    } else if (c28 == 1) {
                        if (this.f1660b) {
                            str3 = "设置发送短信协议类型，设置失败";
                            Log.i(this.f1659a, str3);
                        }
                        messageObtainMessage.arg1 = bArr[3];
                    } else {
                        if (c28 == 2 && this.f1660b) {
                            str3 = "设置发送短信协议类型，校验错误";
                            Log.i(this.f1659a, str3);
                        }
                        messageObtainMessage.arg1 = bArr[3];
                    }
                } else if (c2 == ';') {
                    messageObtainMessage = this.f1662d.obtainMessage();
                    messageObtainMessage.what = 280;
                    char c29 = bArr[3];
                    if (c29 == 0) {
                        if (this.f1660b) {
                            str2 = "设置TOT，设置成功";
                            Log.i(this.f1659a, str2);
                        }
                        messageObtainMessage.arg1 = bArr[3];
                    } else if (c29 == 1) {
                        if (this.f1660b) {
                            str2 = "设置TOT，设置失败";
                            Log.i(this.f1659a, str2);
                        }
                        messageObtainMessage.arg1 = bArr[3];
                    } else {
                        if (c29 == 2 && this.f1660b) {
                            str2 = "设置TOT，校验错误";
                            Log.i(this.f1659a, str2);
                        }
                        messageObtainMessage.arg1 = bArr[3];
                    }
                } else {
                    if (c2 != '<') {
                        return;
                    }
                    messageObtainMessage = this.f1662d.obtainMessage();
                    messageObtainMessage.what = 281;
                    char c30 = bArr[3];
                    if (c30 == 0) {
                        if (this.f1660b) {
                            str = "设置SPK_EN，设置成功";
                            Log.i(this.f1659a, str);
                        }
                        messageObtainMessage.arg1 = bArr[3];
                    } else if (c30 == 1) {
                        if (this.f1660b) {
                            str = "设置SPK_EN，设置失败";
                            Log.i(this.f1659a, str);
                        }
                        messageObtainMessage.arg1 = bArr[3];
                    } else {
                        if (c30 == 2 && this.f1660b) {
                            str = "设置SPK_EN，校验错误";
                            Log.i(this.f1659a, str);
                        }
                        messageObtainMessage.arg1 = bArr[3];
                    }
                }
            }
            messageObtainMessage2 = messageObtainMessage;
            handler = this.f1662d;
        }
        handler.sendMessage(messageObtainMessage2);
        i3 = i2 & 255;
        messageObtainMessage2.arg1 = i3;
        handler = this.f1662d;
        handler.sendMessage(messageObtainMessage2);
    }
}
