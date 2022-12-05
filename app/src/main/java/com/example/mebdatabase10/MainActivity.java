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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_first);

        Spinner topSpin = findViewById(R.id.top_path);
        ArrayAdapter<CharSequence> topAdapter = ArrayAdapter.createFromResource(this,
                R.array.tiers, android.R.layout.simple_spinner_item);
        topAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        topSpin.setAdapter(topAdapter);
        //spinner.setOnItemSelectedListener(this);

        Spinner midSpin = findViewById(R.id.middle_path);
        ArrayAdapter<CharSequence> midAdapter = ArrayAdapter.createFromResource(this,
                R.array.tiers, android.R.layout.simple_spinner_item);
        midAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        midSpin.setAdapter(midAdapter);
        //spinner.setOnItemSelectedListener(this);

        Spinner lowSpin =  findViewById(R.id.bottom_path);
        ArrayAdapter<CharSequence> lowAdapter = ArrayAdapter.createFromResource(this,
                R.array.tiers, android.R.layout.simple_spinner_item);
        lowAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        lowSpin.setAdapter(lowAdapter);
        //spinner.setOnItemSelectedListener(this);

        //binding = ActivityMainBinding.inflate(getLayoutInflater());
        //setContentView(binding.getRoot());

        //setSupportActionBar(binding.toolbar);

        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        //appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        /*binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    /*@Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        String tier = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) { }*/

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