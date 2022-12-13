package com.example.mebdatabase10;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Upgrade.class}, version = 2, exportSchema = false)
public abstract class UpgradeRoomDatabase extends RoomDatabase
{

    public abstract UpgradeDao upgradeDao();

    private static volatile UpgradeRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static UpgradeRoomDatabase getDatabase(final Context context)
    {
        if(INSTANCE == null)
        {
            synchronized (UpgradeRoomDatabase.class)
            {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), UpgradeRoomDatabase.class, "upgrade_database")
                            .fallbackToDestructiveMigration()
                            //.addCallback(sRoomDatabaseCallback)
                            .createFromAsset("tower.db")
                            .build();
                }
            }
        }

        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback()
    {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db)
        {
            super.onCreate(db);

            databaseWriteExecutor.execute(() ->
            {
                UpgradeDao dao = INSTANCE.upgradeDao();
                dao.deleteAll();

                Upgrade upgrade = new Upgrade(11, 0, "Base Dart", 200);
                dao.insert(upgrade);

                upgrade = new Upgrade(11, 11, "Sharp Shots", 140);
                dao.insert(upgrade);

                upgrade = new Upgrade(11, 12, "Razor Sharp Shots", 220);
                dao.insert(upgrade);

                upgrade = new Upgrade(11, 13, "Spike-o-pult", 300);
                dao.insert(upgrade);

                upgrade = new Upgrade(11, 14, "Juggernaut", 1800);
                dao.insert(upgrade);

                upgrade = new Upgrade(11, 15, "Ultra Juggernaut", 15000);
                dao.insert(upgrade);

                upgrade = new Upgrade(11, 21, "Quick Shots", 100);
                dao.insert(upgrade);

                upgrade = new Upgrade(11, 22, "Very Quick Shots", 190);
                dao.insert(upgrade);

                upgrade = new Upgrade(11, 23, "Triple Dart", 400);
                dao.insert(upgrade);

                upgrade = new Upgrade(11, 24, "Super Monkey Fan Club", 8000);
                dao.insert(upgrade);

                upgrade = new Upgrade(11, 25, "Plasma Monkey Fan Club", 45000);
                dao.insert(upgrade);

                upgrade = new Upgrade(11, 31, "Long Range Darts", 90);
                dao.insert(upgrade);

                upgrade = new Upgrade(11, 32, "Enhanced Eyesight", 200);
                dao.insert(upgrade);

                upgrade = new Upgrade(11, 33, "Crossbow", 625);
                dao.insert(upgrade);

                upgrade = new Upgrade(11, 34, "Sharp Shooter", 2000);
                dao.insert(upgrade);

                upgrade = new Upgrade(11, 35, "Crossbow Master", 23500);
                dao.insert(upgrade);

                upgrade = new Upgrade(11, 60, "Apex Plasma Master", 350000);
                dao.insert(upgrade);
            });
        }
    };
}

