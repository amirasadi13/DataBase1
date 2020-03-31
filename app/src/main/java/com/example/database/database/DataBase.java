package com.example.database.database;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class},version = 1,exportSchema = false)
abstract class NoteDataBase extends RoomDatabase {

    public NoteDao noteDao() {
        return null;
    }

    private static final String DB_NAME ="note_db";
    private static NoteDataBase instance;

    public static synchronized NoteDataBase getInstance(final Context context){
        if (instance == null ){
            instance = Room.databaseBuilder(context.getApplicationContext(),NoteDataBase.class,DB_NAME)
                    .build();
        }
        return instance;
    }



}
