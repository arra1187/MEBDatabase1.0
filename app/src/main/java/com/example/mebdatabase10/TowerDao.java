package com.example.mebdatabase10;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import java.util.List;

@Dao
public abstract class TowerDao {
    @Query("SELECT * FROM tower_table WHERE tower LIKE :tower")
    public abstract LiveData<List<Tower>> getTower(int tower);
}
