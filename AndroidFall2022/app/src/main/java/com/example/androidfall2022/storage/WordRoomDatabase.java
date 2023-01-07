package com.example.androidfall2022.storage;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Word.class}, version = 1)
public abstract class WordRoomDatabase extends RoomDatabase {

    public abstract WordDAO wordDAO();

    //implement singleton
    private static WordRoomDatabase INSTANCE;

    static WordRoomDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    WordRoomDatabase.class,
                    "word_database").build();
        }
        return INSTANCE;
    }

    //implement an executer for long running operations

    static final ExecutorService databaseWriterExecuter = Executors.newFixedThreadPool(4);
}