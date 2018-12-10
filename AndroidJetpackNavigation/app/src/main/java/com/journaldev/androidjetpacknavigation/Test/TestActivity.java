package com.journaldev.androidjetpacknavigation.Test;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.journaldev.androidjetpacknavigation.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
    }
}
