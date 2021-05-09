package com.example.moviecatalogue.activities;

import android.os.Bundle;

import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import com.example.moviecatalogue.R;
import com.example.moviecatalogue.models.movie.Movie;
import com.example.moviecatalogue.networks.Const;
import com.example.moviecatalogue.networks.MovieApiClient;
import com.example.moviecatalogue.networks.MovieApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getIntent().getStringExtra("TITLE"));
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ImageView ivPoster = findViewById(R.id.iv_poster);
        TextView tvTitle = findViewById(R.id.tv_title);
        TextView tvReleaseDate = findViewById(R.id.tv_release_date);
        TextView tvOverview = findViewById(R.id.tv_overview);

        tvTitle.setText(getIntent().getStringExtra("TITLE"));
        tvReleaseDate.setText(getIntent().getStringExtra("RELEASE_DATE"));
        tvOverview.setText(getIntent().getStringExtra("OVERVIEW"));

        Glide.with(DetailActivity.this)
                .load(Const.IMG_URL_300 + getIntent().getStringExtra("IMG_URL"))
                .into(ivPoster);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
