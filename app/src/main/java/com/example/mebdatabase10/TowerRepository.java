package com.example.mebdatabase10;

        import android.app.Application;

        import androidx.lifecycle.LiveData;

        import java.util.List;

public class TowerRepository {
    private TowerDao mTowerDao;
    private LiveData<List<Tower>> mAllTowers;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    TowerRepository(Application application) {
        //TowerRoomDatabase db = TowerRoomDatabase.getDatabase(application);
        //mTowerDao = db.towerDao();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    /*LiveData<List<Tower>> getAllTowers() {
        return mAllTowers;
    }

    LiveData<List<Tower>> getTower(int towerID)
    {

    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Tower tower) {
        TowerRoomDatabase.databaseWriteExecutor.execute(() -> {
            mTowerDao.insert(tower);
        });
    }*/
}