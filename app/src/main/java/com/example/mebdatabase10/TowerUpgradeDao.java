package com.example.mebdatabase10;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public abstract class TowerUpgradeDao {
    @Query("SELECT mCost FROM upgrade_table WHERE tower LIKE :tower")
    public abstract LiveData<List<Tower>> getCost(int tower);
}
