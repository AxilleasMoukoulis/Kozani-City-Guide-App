package com.example.axilleas.cityguideapp;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.axilleas.cityguideapp.fragments.BarFragment;
import com.example.axilleas.cityguideapp.fragments.ChurchFragment;
import com.example.axilleas.cityguideapp.fragments.ClubFragment;
import com.example.axilleas.cityguideapp.fragments.CofeeFragment;
import com.example.axilleas.cityguideapp.fragments.HistoricFragment;
import com.example.axilleas.cityguideapp.fragments.HotelFragment;
import com.example.axilleas.cityguideapp.fragments.MezesFragment;
import com.example.axilleas.cityguideapp.fragments.MuseumFragment;
import com.example.axilleas.cityguideapp.fragments.RestaurantFragment;
import com.example.axilleas.cityguideapp.fragments.TavernsFragment;
import com.example.axilleas.cityguideapp.fragments.TrendingFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    protected Toolbar toolbar;
    private static final int RESULT_SETTINGS = 1;

    private FragmentManager fm ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fm = getFragmentManager();
//        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.content_frame, new TrendingFragment()).commit();
    }

    @Override
    public void onResume(){
        super.onResume();

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        StringBuilder builder = new StringBuilder();
        builder.append("\n Send report:" + sharedPrefs.getBoolean("prefSendReport", false));

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_settings:
                Intent i = new Intent(this, SettingsActivity.class);
                startActivityForResult(i, RESULT_SETTINGS);
                break;

        }

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case RESULT_SETTINGS:
                showUserSettings();
                break;

        }

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        //android.app.FragmentManager fm = getFragmentManager();
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_historic) {
            fm.beginTransaction().replace(R.id.content_frame, new HistoricFragment()).commit();
            toolbar.setTitle("Ιστορικά Κτήρια");
        } else if (id == R.id.nav_church) {
            fm.beginTransaction().replace(R.id.content_frame, new ChurchFragment()).commit();
            toolbar.setTitle("Εκκλησίες");
        } else if (id == R.id.nav_museum) {
            fm.beginTransaction().replace(R.id.content_frame, new MuseumFragment()).commit();
            toolbar.setTitle("Μουσεία");
        } else if (id == R.id.nav_cafes) {
            fm.beginTransaction().replace(R.id.content_frame, new CofeeFragment()).commit();
            toolbar.setTitle("Καφετέριες");
        } else if (id == R.id.nav_bar) {
            fm.beginTransaction().replace(R.id.content_frame, new BarFragment()).commit();
            toolbar.setTitle("Μπαρ");
        } else if (id == R.id.nav_club) {
            fm.beginTransaction().replace(R.id.content_frame, new ClubFragment()).commit();
            toolbar.setTitle("Κλαμπ");
        } else if (id == R.id.nav_restaurants) {
            fm.beginTransaction().replace(R.id.content_frame, new RestaurantFragment()).commit();
            toolbar.setTitle("Εστιατόρια");
        } else if (id == R.id.nav_taverns) {
            fm.beginTransaction().replace(R.id.content_frame, new TavernsFragment()).commit();
            toolbar.setTitle("Ταβέρνες");
        } else if (id == R.id.nav_mezes) {
            fm.beginTransaction().replace(R.id.content_frame, new MezesFragment()).commit();
            toolbar.setTitle("Μεζεδοπωλεία");
        } else if (id == R.id.nav_hotels) {
            fm.beginTransaction().replace(R.id.content_frame, new HotelFragment()).commit();
            toolbar.setTitle("Ξενοδοχεία");
        } else if( id == R.id.nav_trending ) {
            fm.beginTransaction().replace(R.id.content_frame, new TrendingFragment()).commit();
            toolbar.setTitle("Δημοφιλή");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showUserSettings() {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);

        StringBuilder builder = new StringBuilder();
        builder.append("\n Send report:" + sharedPrefs.getBoolean("prefSendReport", false));
    }

}

