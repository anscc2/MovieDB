package com.example.moviecatalogue.activities;

import android.os.Bundle;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.moviecatalogue.fragments.TvAiringTodayFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import com.example.moviecatalogue.R;
import com.example.moviecatalogue.fragments.NowPlayingFragment;
import com.example.moviecatalogue.fragments.UpcomingFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bnv_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.item_now_playing);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.item_now_playing:
                getSupportActionBar().setTitle("Movie Now Playing");
                fragment = new NowPlayingFragment();
                break;
            case R.id.item_airing_today:
                getSupportActionBar().setTitle("Airing Today");
                fragment = new TvAiringTodayFragment();
                break;
            case R.id.item_upcoming:
                getSupportActionBar().setTitle(getResources().getString(R.string.menu_upcoming));
                fragment = new UpcomingFragment();
                break;
        }
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_main, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
