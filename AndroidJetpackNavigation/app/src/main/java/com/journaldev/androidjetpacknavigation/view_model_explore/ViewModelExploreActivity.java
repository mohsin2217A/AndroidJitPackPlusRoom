package com.journaldev.androidjetpacknavigation.view_model_explore;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


import com.journaldev.androidjetpacknavigation.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class ViewModelExploreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model_explore);

        TextView textView = (TextView) findViewById(R.id.txt);

        HomeViewModel homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        String myRandomNumber = homeViewModel.getNumber();
        textView.setText(myRandomNumber);

    }
}
