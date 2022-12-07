package com.example.mebdatabase10;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Callable;

public class UpgradeRepository {
    private UpgradeDao mUpgradeDao;
    //private LiveData<List<Upgrade>> mAllUpgrades;

    UpgradeRepository(Application application) {
        UpgradeRoomDatabase db = UpgradeRoomDatabase.getDatabase(application);
        mUpgradeDao = db.upgradeDao();
    }

    void insert(Upgrade upgrade) {
        UpgradeRoomDatabase.databaseWriteExecutor.execute(() ->
        {
            mUpgradeDao.insert(upgrade);
        });
    }

    Upgrade getUpgrade(int upgradeID) {
        //UpgradeRoomDatabase.databaseWriteExecutor.execute(() ->
        //{
            return mUpgradeDao.getUpgrade(upgradeID);
        //});
    }
}