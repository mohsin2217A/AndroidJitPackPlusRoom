package com.journaldev.androidjetpacknavigation.room_database;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.journaldev.androidjetpacknavigation.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter  extends RecyclerView.Adapter<CustomAdapter.NoteViewHolder> {

    private final LayoutInflater layoutInflater;
    private Context mContext;
    private List<Note> mNotes;

    public CustomAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = layoutInflater.inflate(R.layout.list_item, parent, false);
        NoteViewHolder viewHolder = new NoteViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {

        if (mNotes != null) {
            Note note = mNotes.get(position);
            holder.setData(note.getNote(), position);
        } else {
            // Covers the case of data not being ready yet.
            holder.noteItemView.setText(R.string.app_name);
        }
    }

    @Override
    public int getItemCount() {
        if (mNotes != null)
            return mNotes.size();
        else return 0;
    }

    public void setNotes(List<Note> notes) {
        mNotes = notes;
        notifyDataSetChanged();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {

        private TextView noteItemView;
        private int mPosition;
        private ImageView imgDelete, imgEdit;

        public NoteViewHolder(View itemView) {
            super(itemView);
            noteItemView = itemView.findViewById(R.id.txvNote);
            imgDelete 	 = itemView.findViewById(R.id.ivRowDelete);
            imgEdit 	 = itemView.findViewById(R.id.ivRowEdit);
        }

        public void setData(String note, int position) {
            noteItemView.setText(note);
            mPosition = position;
        }
    }

}
