package com.example.pretest;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvTime;
    private Handler handler = new Handler();
    private long startTime = 0L;
    private long timeInMillis = 0L;
    private boolean running = false;

    private Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            if (running) {
                timeInMillis = System.currentTimeMillis() - startTime;

                int detik = (int) (timeInMillis / 1000);
                int menit = detik / 60;
                int jam = menit / 60;

                detik = detik % 60;
                menit = menit % 60;

                int mili = (int) (timeInMillis % 1000);

                tvTime.setText(
                        String.format("%02d:%02d:%02d.%03d", jam, menit, detik, mili)
                );


                handler.postDelayed(this, 10);
            }
        }
    };

    private TextView tvMark;
    private int markCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTime = findViewById(R.id.tvTime);
        Button btnStart = findViewById(R.id.btnStart);
        Button btnStop = findViewById(R.id.btnStop);
        Button btnReset = findViewById(R.id.btnReset);

        btnStart.setOnClickListener(v -> {
            if (!running) {
                startTime = System.currentTimeMillis() - timeInMillis;
                running = true;
                handler.post(timerRunnable);
            }
        });

        tvMark = findViewById(R.id.tvMark);
        Button btnMark = findViewById(R.id.btnMark);




        btnStop.setOnClickListener(v -> running = false);

        btnReset.setOnClickListener(v -> {
            running = false;
            timeInMillis = 0;
            tvTime.setText("00:00:00.000");

            tvMark.setText("Riwayat Mark:\n");
            markCount = 1;
        });


        btnMark.setOnClickListener(v -> {
            if (running) {
                int detik = (int) (timeInMillis / 1000);
                int menit = detik / 60;
                int jam = menit / 60;

                detik = detik % 60;
                menit = menit % 60;
                int mili = (int) (timeInMillis % 1000);

                String waktuMark = String.format(
                        "%02d:%02d:%02d.%03d",
                        jam, menit, detik, mili
                );

                tvMark.append("Mark " + markCount + " : " + waktuMark + "\n");
                markCount++;
            }
        });

    }
}
