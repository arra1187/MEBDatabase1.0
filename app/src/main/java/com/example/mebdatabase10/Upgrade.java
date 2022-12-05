package com.example.mebdatabase10;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "upgrade_table")
public class Upgrade {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tower")
    public int mTowerID; // <int><int> - <1-4><1-7>

    public int mUpgradeID; // <int><int> - <1-3><1-5> or 0 or 6
    public String mTitle;
    public int mCost;

    //public int getUpgradeID(){return this.mUpgradeID;}
    //public int getUpgradeCost(){return this.mCost;}

    public Upgrade(@NonNull int towerID, int upgradeID, String title, int cost)
    {
        this.mTowerID = towerID;
        this.mUpgradeID = upgradeID;
        this.mTitle = title;
        this.mCost = cost;
    };
    //public abstract int getUpgradeCost(int upgradeID);
}