package com.karthiknjay.notes.model;

/**
 * Created by karthik on 10/2/15.
 */
public class Note {

    protected int id;

    protected String title;

    protected String content;

    public Note() {}

    public Note(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return this.id + ". " + this.title + " - " + this.content;
    }
}
