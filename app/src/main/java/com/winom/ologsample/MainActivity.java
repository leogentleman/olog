package com.winom.ologsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.winom.olog.OLog;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new WriteThread().start();
    }
    
    public static class WriteThread extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < 10240 ; j++) {
                    builder.append("a");
                }
                OLog.i(TAG, builder.toString());
                if (i == 100) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {

                    }
                }
            }
            OLog.flush();
        }
    }
}
