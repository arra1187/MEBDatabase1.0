package com.example.mebdatabase10;

import android.os.Bundle;

import com.example.mebdatabase10.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    /*
    //@Fts4
    @Entity(tableName = "Towers")
    public class Tower {
        @PrimaryKey
        //@ColumnInfo(name = "rowid")
        public int towerID; // <int><int> - <1-4><1-7>

        public String title;
        public String category;
    }

    //@Fts4
    @Entity(tableName = "Upgrades")
    public class Upgrade {
        @PrimaryKey
        //@ColumnInfo(name = "rowid")
        public int parentTowerID; // <int><int> - <1-4><1-7>

        public int upgradeID;
        public String title;
        public int cost;
    }

    public class towerWithUpgrades {
        @Embedded public Tower tower;
        @Relation(
                parentColumn = "towerID",
                entityColumn = "parentTowerID"
        )
        public List<Upgrade> upgrades;
    }

    @Dao
    public interface AllDao {
        @Query("SELECT * FROM Towers")
        List<Tower> getAll();

        @Query("SELECT * FROM Towers WHERE title IN (:towerIDs)")
        List<Tower> loadAllByIds(int[] towerIDs);

        @Query("SELECT * FROM Towers WHERE title LIKE :towerName")
        Tower findByTitle(String towerName);

        @Insert
        void insertAll(Tower... towers);

        @Delete
        void delete(Tower user);

        @Transaction
        @Query("SELECT * FROM Towers")
        public List<towerWithUpgrades> getTowersWithUpgrades();
    }

    @androidx.room.Database(entities = {Tower.class}, version = 1)
    public abstract class AppDatabase extends RoomDatabase {
        public abstract AllDao towerDao();
    }

    AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "tower_database").createFromAsset("database/tower.db").build();

    AllDao towerDao = db.towerDao();
    List<Tower> towers = towerDao.getAll();*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Spinner
                spinnerLanguages=findViewById(R.id.top_path);
                ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,
                R.array.tiers, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
                spinnerLanguages.setAdapter(adapter);
                spinnerLanguages=findViewById(R.id.middle_path);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
                spinnerLanguages.setAdapter(adapter);
                spinnerLanguages=findViewById(R.id.bottom_path);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
                spinnerLanguages.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}