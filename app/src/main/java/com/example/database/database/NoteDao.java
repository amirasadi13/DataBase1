package com.example.database.database;


import android.provider.SyncStateContract;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import java.util.List;

@Dao
public interface NoteDao {

   @Query("SELECT * from note")
    List<Note> getNoteList();

   @Insert
    void insertNote(Note note);

   @Update
    void updateNote(Note note);

   @Delete
    void deleteNote(Note note);

}
