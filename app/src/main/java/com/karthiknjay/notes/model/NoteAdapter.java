package com.karthiknjay.notes.model;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.karthiknjay.notes.R;

import java.util.List;

/**
 * Created by karthik on 11/2/15.
 */
public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private List<Note> noteList;

    public NoteAdapter(List<Note> noteList) {
        this.noteList = noteList;
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    @Override
    public void onBindViewHolder(NoteViewHolder noteViewHolder, int i) {
        Note note = noteList.get(i);
        noteViewHolder.txtTitle.setText(note.title);
        noteViewHolder.txtContent.setText(note.content);
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);
        return new NoteViewHolder(itemView);
    }

    public static class NoteViewHolder extends RecyclerView.ViewHolder {
        protected TextView txtTitle;
        protected TextView txtContent;

        public NoteViewHolder(View view) {
            super(view);
            txtTitle = (TextView) view.findViewById(R.id.txtTitle);
            txtContent = (TextView) view.findViewById(R.id.txtContent);
        }
    }

}
