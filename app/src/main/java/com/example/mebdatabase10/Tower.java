package com.example.mebdatabase10;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tower_table")
public class Tower {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tower")
    private int mTowerID;

    public String title;
    public String category;

    public int getTower(){return this.mTowerID;}
}
