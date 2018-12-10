package com.journaldev.androidjetpacknavigation.Test;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.journaldev.androidjetpacknavigation.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class TestFragmentTwo extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_test_fragment_two, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        final NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
        Button back = view.findViewById(R.id.button2);
        Button next = view.findViewById(R.id.button3);
        TextView bundle_txt = view.findViewById(R.id.textView2);

        Toast.makeText(getActivity(),getArguments().getString("bundle"),Toast.LENGTH_LONG).show();
        bundle_txt.setText("Bundle Data + "+getArguments().getString("bundle"));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_testFragmentTwo_to_testFragmentOne);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_testFragmentTwo_to_firstFragment2);
            }
        });

    }
}
