package com.example.mebdatabase10;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;

@Dao
public interface UpgradeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Upgrade upgrade);

    @Query("DELETE FROM upgrade_table")
    void deleteAll();

    @Query("SELECT mCost FROM upgrade_table WHERE mUpgradeID = :upgradeID")
    int getUpgradeCost(int upgradeID);
}