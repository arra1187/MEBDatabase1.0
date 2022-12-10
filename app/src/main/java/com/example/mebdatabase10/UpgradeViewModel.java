package com.example.mebdatabase10;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class UpgradeViewModel extends AndroidViewModel {
    private UpgradeRepository mRepository;

    private final LiveData<List<Upgrade>> mAllUpgrades;

    public UpgradeViewModel(Application application)
    {
        super(application);
        mRepository = new UpgradeRepository(application);
        mAllUpgrades = mRepository.getAllUpgrades();
    }

    LiveData<List<Upgrade>> getUpgrades()
    {
        return mAllUpgrades;
    }
}
