package com.poo.truyencuoi.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.poo.truyencuoi.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_name);
        welcome();
    }

    private void welcome() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                nextActivity();
            }
        }, 500);
    }

    private void nextActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
