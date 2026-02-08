package com.geograms.iwi;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int API_PORT = 6789;

    private RadioManager radio;
    private ApiServer apiServer;
    private EditText etFrequency;
    private Button btnPower;
    private Button btnPtt;
    private EditText etAprsMessage;
    private Button btnSendAprs;
    private TextView tvStatus;
    private TextView tvLog;
    private ScrollView svLog;
    private Spinner spSquelch;
    private boolean poweredOn = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radio = new RadioManager(this);
        radio.startTxQueue();

        // Start HTTP API server
        apiServer = new ApiServer(radio, API_PORT);
        try {
            apiServer.start();
            String ip = getDeviceIp();
            String url = "http://" + ip + ":" + API_PORT + "/";
            Log.i(TAG, "API server started: " + url);
        } catch (IOException e) {
            Log.e(TAG, "Failed to start API server", e);
        }

        etFrequency = findViewById(R.id.etFrequency);
        btnPower = findViewById(R.id.btnPower);
        btnPtt = findViewById(R.id.btnPtt);
        tvStatus = findViewById(R.id.tvStatus);
        tvLog = findViewById(R.id.tvLog);
        svLog = findViewById(R.id.svLog);
        spSquelch = findViewById(R.id.spSquelch);
        etAprsMessage = findViewById(R.id.etAprsMessage);
        btnSendAprs = findViewById(R.id.btnSendAprs);
        btnSendAprs.setEnabled(false);
        btnSendAprs.setOnClickListener(v -> sendAprsMessage());

        ArrayAdapter<CharSequence> squelchAdapter = ArrayAdapter.createFromResource(
            this, R.array.squelch_levels, android.R.layout.simple_spinner_item);
        squelchAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSquelch.setAdapter(squelchAdapter);
        spSquelch.setSelection(0); // default squelch=0 for APRS

        radio.setLogCallback(msg -> runOnUiThread(() -> {
            tvLog.append(msg + "\n");
            svLog.post(() -> svLog.fullScroll(ScrollView.FOCUS_DOWN));
        }));

        btnPower.setOnClickListener(v -> {
            if (!poweredOn) {
                powerOn();
            } else {
                powerOff();
            }
        });

        btnPtt.setOnTouchListener((v, event) -> {
            if (!poweredOn) return false;
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    radio.startTx();
                    btnPtt.setBackgroundTintList(
                        ContextCompat.getColorStateList(this, R.color.ptt_active));
                    btnPtt.setText("TX");
                    return true;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    radio.stopTx();
                    btnPtt.setBackgroundTintList(
                        ContextCompat.getColorStateList(this, R.color.ptt_idle));
                    btnPtt.setText(R.string.ptt);
                    return true;
            }
            return false;
        });

        // No auto power-on — use the API or UI button instead
    }

    private void powerOn() {
        long freqHz = parseFrequencyHz();
        if (freqHz <= 0) {
            tvStatus.setText("Invalid frequency");
            return;
        }
        int squelch = getSquelchLevel();
        radio.setSquelchLevel(squelch);

        btnPower.setEnabled(false);
        tvStatus.setText(R.string.status_starting);
        tvLog.setText("Serial log:\n");

        radio.powerOn(freqHz, (success, message) -> runOnUiThread(() -> {
            btnPower.setEnabled(true);
            if (success) {
                poweredOn = true;
                btnPower.setText(R.string.power_off);
                btnPower.setBackgroundTintList(
                    ContextCompat.getColorStateList(this, R.color.red));
                btnPtt.setEnabled(true);
                btnSendAprs.setEnabled(true);
                tvStatus.setText(R.string.status_on);
            } else {
                tvStatus.setText("Error: " + message);
            }
        }));
    }

    private void powerOff() {
        radio.powerOff();
        poweredOn = false;
        btnPower.setText(R.string.power_on);
        btnPower.setBackgroundTintList(
            ContextCompat.getColorStateList(this, R.color.green));
        btnPtt.setEnabled(false);
        btnSendAprs.setEnabled(false);
        tvStatus.setText(R.string.status_off);
    }

    private void sendAprsMessage() {
        String text = etAprsMessage.getText().toString().trim();
        if (text.isEmpty()) {
            Toast.makeText(this, "Enter APRS message", Toast.LENGTH_SHORT).show();
            return;
        }

        // Build APRS message packet addressed to KO6JZI
        byte[] frame;
        String srcCall = "N0CALL";
        int srcSsid = 7;
        String destCall = "KO6JZI";
        frame = APRS.buildMessagePacket(srcCall, srcSsid, destCall, text, null);

        short[] pcm = AX25.modulateFrame(frame);
        btnSendAprs.setEnabled(false);
        btnPtt.setEnabled(false);

        radio.sendPcmFrames(pcm, () -> runOnUiThread(() -> {
            if (poweredOn) {
                btnSendAprs.setEnabled(true);
                btnPtt.setEnabled(true);
            }
        }));
    }

    private long parseFrequencyHz() {
        try {
            String text = etFrequency.getText().toString().trim();
            double mhz = Double.parseDouble(text);
            return (long) (mhz * 1_000_000);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private int getSquelchLevel() {
        try {
            return Integer.parseInt(spSquelch.getSelectedItem().toString());
        } catch (Exception e) {
            return 5;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (apiServer != null) {
            apiServer.stop();
        }
        if (poweredOn) {
            radio.powerOff();
        }
        radio.shutdown();
    }

    private String getDeviceIp() {
        try {
            Enumeration<NetworkInterface> ifaces = NetworkInterface.getNetworkInterfaces();
            while (ifaces.hasMoreElements()) {
                NetworkInterface iface = ifaces.nextElement();
                if (iface.isLoopback() || !iface.isUp()) continue;
                Enumeration<InetAddress> addrs = iface.getInetAddresses();
                while (addrs.hasMoreElements()) {
                    InetAddress addr = addrs.nextElement();
                    if (addr instanceof Inet4Address) {
                        return addr.getHostAddress();
                    }
                }
            }
        } catch (Exception ignored) {}
        return "0.0.0.0";
    }
}
