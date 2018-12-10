package com.journaldev.androidjetpacknavigation.Test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.journaldev.androidjetpacknavigation.R;

import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class TestFragmentOne extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_test_fragment_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        Button button = view.findViewById(R.id.button);
        Button view_model_btn = view.findViewById(R.id.button4);

        final Bundle bundle = new Bundle();
        bundle.putString("bundle","Mohsin");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_testFragmentOne_to_testFragmentTwo,bundle);
            }
        });

        view_model_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_testFragmentOne_to_viewModelExploreActivity);
            }
        });

    }
}
