package com.example.C0767722_w2020_mad3125_midterm.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.C0767722_w2020_mad3125_midterm.R;
import com.example.C0767722_w2020_mad3125_midterm.models.CRACustomer;
import com.example.C0767722_w2020_mad3125_midterm.ui.aboutus.AboutUsFragment;
import com.example.C0767722_w2020_mad3125_midterm.ui.home.HomeFragment;
import com.example.C0767722_w2020_mad3125_midterm.ui.taxdetails.TaxDetailsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class CRACalulationDetailActivity extends AppCompatActivity {
         Bundle bundle = new Bundle();
        private CRACustomer details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cra_calulation_detail);
        Intent intent = getIntent();
         details = intent.getParcelableExtra("detials");
         bundle.putParcelable("details",details);
        BottomNavigationView navView = findViewById(R.id.nav_view);
       // getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MapFragment()).commit();
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

}


