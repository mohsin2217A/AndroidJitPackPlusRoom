package com.journaldev.androidjetpacknavigation.room_database;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.journaldev.androidjetpacknavigation.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NewNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        final EditText editText = (EditText)findViewById(R.id.et_note);
        Button add_btn = (Button)findViewById(R.id.add_btn);

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                if(editText.getText().toString().isEmpty()){
                    setResult(RESULT_CANCELED, resultIntent);
                }
                else{
                    resultIntent.putExtra("note_added",editText.getText().toString());
                    setResult(RESULT_OK,resultIntent);
                }
                finish();
            }
        });




    }
}
