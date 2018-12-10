package com.journaldev.androidjetpacknavigation.room_database;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class NoteViewModel extends AndroidViewModel {
    private NoteDao noteDao;
    private NoteRoomDatabase noteDB;
    LiveData<List<Note>> mAllNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);

        noteDB = NoteRoomDatabase.getDatabase(application);
        noteDao = noteDB.noteDao();
        mAllNotes = noteDao.getAllNotes();
    }

    public void insert(Note note) {
        new InsertAsyncTask(noteDao).execute(note);
    }

    LiveData<List<Note>> getmAllNotes(){
        return mAllNotes;
    }




    private class OperationsAsyncTask extends AsyncTask<Note, Void, Void> {

        NoteDao mAsyncTaskDao;

        OperationsAsyncTask(NoteDao dao) {
            this.mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            return null;
        }
    }


    private class InsertAsyncTask extends OperationsAsyncTask {

        InsertAsyncTask(NoteDao mNoteDao) {
            super(mNoteDao);
        }

        @Override
        protected Void doInBackground(Note... notes) {
            mAsyncTaskDao.insert(notes[0]);
            return null;
        }
    }

}
