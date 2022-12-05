package com.example.mebdatabase10;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class TowerViewModel extends AndroidViewModel {
    private TowerRepository mRepository;

    //private final LiveData<List<Tower>> mAllTowers;

    public TowerViewModel (Application application) {
        super(application);
        mRepository = new TowerRepository(application);
        //mAllTowers = mRepository.getAllTowers();
    }

    //LiveData<List<Tower>> getAllTowers() { return mAllTowers; }

    //public void insert(Tower tower) { mRepository.insert(tower); }
}
