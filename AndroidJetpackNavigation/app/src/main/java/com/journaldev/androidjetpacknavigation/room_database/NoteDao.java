package com.journaldev.androidjetpacknavigation.room_database;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface NoteDao {

    @Insert
     void insert(Note note);

    @Query("SELECT * FROM notes")
    LiveData<List<Note>> getAllNotes();

}
