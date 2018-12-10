package com.journaldev.androidjetpacknavigation.room_database;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.journaldev.androidjetpacknavigation.R;
import com.journaldev.androidjetpacknavigation.view_model_explore.HomeViewModel;

import java.util.List;
import java.util.UUID;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RoomGetActivity extends AppCompatActivity {

    private static final int NEW_NOTE_ACTIVITY_REQUEST_CODE = 1;
    private NoteViewModel noteViewModel;
    CustomAdapter noteListAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_get);
        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        noteListAdapter = new CustomAdapter(this);
        recyclerView.setAdapter(noteListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton floatingActionButton = (FloatingActionButton)findViewById(R.id.fab_btn);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),NewNoteActivity.class);
                startActivityForResult(i, NEW_NOTE_ACTIVITY_REQUEST_CODE);
            }
        });

        noteViewModel.getmAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                noteListAdapter.setNotes(notes);
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==NEW_NOTE_ACTIVITY_REQUEST_CODE && resultCode==RESULT_OK){

            String note_id = UUID.randomUUID().toString();
            Note note = new Note(note_id,data.getStringExtra("note_added"));
            noteViewModel.insert(note);

            Toast.makeText(getApplicationContext(),"true",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"false",Toast.LENGTH_SHORT).show();
        }
    }
}
