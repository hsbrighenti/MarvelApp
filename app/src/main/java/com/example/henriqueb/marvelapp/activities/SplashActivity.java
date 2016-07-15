package com.example.henriqueb.marvelapp.activities;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.henriqueb.marvelapp.activities.MainActivity;

import java.util.concurrent.TimeUnit;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SystemClock.sleep(TimeUnit.SECONDS.toMillis(2));
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
