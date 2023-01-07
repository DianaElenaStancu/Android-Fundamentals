package com.example.androidfall2022.storage;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {
    private WordDAO wordDAO;
    private LiveData<List<Word>> words;

    WordRepository(Application application) {
        WordRoomDatabase wordRoomDatabase = WordRoomDatabase.getDatabase(application);
        wordDAO = wordRoomDatabase.wordDAO();
        words = wordDAO.getWords();
    }

    void insert(Word word) {
        WordRoomDatabase.databaseWriterExecuter.execute(() -> {
            wordDAO.insert(word);
        });
    }

    LiveData<List<Word>> getWords() {
        return words;
    }
}
