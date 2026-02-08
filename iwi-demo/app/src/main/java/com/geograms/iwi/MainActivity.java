package com.geograms.iwi;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private RadioManager radio;
    private EditText etFrequency;
    private Button btnPower;
    private Button btnPtt;
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

        etFrequency = findViewById(R.id.etFrequency);
        btnPower = findViewById(R.id.btnPower);
        btnPtt = findViewById(R.id.btnPtt);
        tvStatus = findViewById(R.id.tvStatus);
        tvLog = findViewById(R.id.tvLog);
        svLog = findViewById(R.id.svLog);
        spSquelch = findViewById(R.id.spSquelch);

        ArrayAdapter<CharSequence> squelchAdapter = ArrayAdapter.createFromResource(
            this, R.array.squelch_levels, android.R.layout.simple_spinner_item);
        squelchAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSquelch.setAdapter(squelchAdapter);
        spSquelch.setSelection(5); // default squelch=5

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
        tvStatus.setText(R.string.status_off);
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
        if (poweredOn) {
            radio.powerOff();
        }
    }
}
