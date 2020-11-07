package com.Technotuner.SVPCET;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;

    private ImageView newComplaintImg, myComplaintImg, allComplaintImg, emergencyServicesImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        navigationAndToolbarSetup();
        initialize();

        newComplaintImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Home.this,NewComplaint.class);
                startActivity(intent);

            }
        });

        myComplaintImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,MyComplaint.class);
                startActivity(intent);
            }
        });

        allComplaintImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home.this, "All", Toast.LENGTH_SHORT).show();
            }
        });

        emergencyServicesImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Home.this, "Emergency", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initialize() {
        newComplaintImg = findViewById(R.id.newComplaintImg);
        myComplaintImg = findViewById(R.id.myComplaintImg);
        allComplaintImg = findViewById(R.id.allComplaintImg);
        emergencyServicesImg  = findViewById(R.id.emergencyServicesImg);

    }

    private void navigationAndToolbarSetup() {
        navigationView = findViewById(R.id.navigationView);
        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);

        //Tool Bar Work
        setSupportActionBar(toolbar);

        // Navigation Menu too and fro when button is click
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        /* To set Icon on Navigation */
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.navigation_icon);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.nav_home:
                break;
            case R.id.nav_share:
                break;
            case R.id.nav_privacy_policy:
                break;
            case R.id.nav_aboutus:
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }
}