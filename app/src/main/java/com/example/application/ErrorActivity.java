package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class ErrorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);

        Intent intentHome = new Intent(this, MainActivity.class);
        intentHome.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intentHome.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intentHome);
                finish();
            }
        },3000);



    }


}