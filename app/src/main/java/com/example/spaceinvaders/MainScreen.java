package com.example.spaceinvaders;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import org.w3c.dom.Text;

public class MainScreen extends AppCompatActivity {

    //Button Venus;
    //Button Mars;



//    TextView oxygenPercentage = findViewById(R.id.oxygenNumber);
 //   TextView carbonDioxidePercentage = findViewById(R.id.carbonDioxideNumber);
  //  TextView nitrogenPercentage = findViewById(R.id.nitrogenNumber);
   // TextView otherGasesPercentage = findViewById(R.id.otherGasesNumber);

    //int Oxygen = findViewById(R.id.oxygen);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        BottomNavigationView navView = findViewById(R.id.navView);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.constraintLayout, new PlanetScreen()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId())
            {
                case R.id.navigation_dashboard:
                    selectedFragment = new PlanetScreen();
                  //  oxygenPercentage.setText(oxygen/);
                    break;
                case R.id.navigation_map:
                    selectedFragment = new MapScreen();

                break;
                case R.id.navigation_upgrades:
                    selectedFragment = new UpgradesScreen();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.constraintLayout, selectedFragment).commit();
            return true;
        }
    };

}
