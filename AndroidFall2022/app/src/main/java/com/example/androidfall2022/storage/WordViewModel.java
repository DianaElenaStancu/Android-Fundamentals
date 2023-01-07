package com.example.androidfall2022.storage;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    //must contain reference to WordRepository
    private WordRepository wordRepository;
    private LiveData<List<Word>> words;

    public WordViewModel(@NonNull Application application) {
        super(application);
        wordRepository = new WordRepository(application);
        words = wordRepository.getWords();
    }

    void insert(Word word) {
        wordRepository.insert(word);
    }

    LiveData<List<Word>> getWords(){
        return words;
    }
}
