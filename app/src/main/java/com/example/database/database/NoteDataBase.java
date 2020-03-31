package com.example.database.database;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.database.fragment.ListNoteFrag;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Note.class},version = 1,exportSchema = false)
public abstract class NoteDataBase extends RoomDatabase {

    public abstract NoteDao noteDao();

    private static volatile NoteDataBase instance;
    private static final int NUMBER_OF_THREADS =4;
    static final ExecutorService databaseex = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

public static NoteDataBase getInstance(final Context context){
    if (instance == null){
        synchronized (NoteDataBase.class){
            if (instance == null){
                instance = Room.databaseBuilder(context.getApplicationContext(),NoteDataBase.class,"note_database")
                        .allowMainThreadQueries().build();
            }
        }
    }
    return instance;
}



}
