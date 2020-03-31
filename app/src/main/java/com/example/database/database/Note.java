package com.example.database.database;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note")
public class Note {


    @PrimaryKey(autoGenerate = true)
    private int note_id = 0;

    @ColumnInfo(name = "noteText")
    private String content;

    @ColumnInfo(name = "title")
    private String title;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getNote_id() {
        return note_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNote_id(int note_id) {
        this.note_id = note_id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Note ( String content , String title){
        this.content = content;
        this.title = title;
    }

}
