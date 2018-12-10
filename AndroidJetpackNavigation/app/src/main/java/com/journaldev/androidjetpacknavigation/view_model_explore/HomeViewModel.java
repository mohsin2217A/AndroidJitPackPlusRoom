package com.journaldev.androidjetpacknavigation.view_model_explore;

import android.app.Application;

import java.util.Random;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class HomeViewModel extends AndroidViewModel {
     String myRandomNumber;

    public HomeViewModel(@NonNull Application application) {
        super(application);
    }


    public String getNumber(){
        if(myRandomNumber==null){
            createNumber();
        }
        return myRandomNumber;
    }

    public void createNumber(){
        Random random = new Random();
        myRandomNumber = "Number: " + (random.nextInt(10 - 1) + 1);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        // View Model Destroy //
    }
}
