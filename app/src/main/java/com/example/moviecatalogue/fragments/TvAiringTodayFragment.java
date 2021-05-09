package com.example.moviecatalogue.fragments;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.moviecatalogue.R;
import com.example.moviecatalogue.activities.DetailActivity;
import com.example.moviecatalogue.adapters.TvAiringTodayAdapter;
import com.example.moviecatalogue.models.TvAiringToday;
import com.example.moviecatalogue.models.TvAiringTodayResponse;
import com.example.moviecatalogue.networks.Const;
import com.example.moviecatalogue.networks.TvApiClient;
import com.example.moviecatalogue.networks.TvApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvAiringTodayFragment extends Fragment implements TvAiringTodayAdapter.OnItemClick {
    private static final String TAG = "TvAiringTodayFragment";
    private RecyclerView recyclerView;
    private TvAiringTodayAdapter adapter;
    private List<TvAiringToday> tvAiringTodays;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_tv_airing_today, container, false);
        recyclerView = view.findViewById(R.id.rv_tv_airing_today);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        loadData();
        return view;
    }

    private void loadData() {
        TvApiInterface tvApiInterface = TvApiClient.getRetrofit()
                .create(TvApiInterface.class);

        Call<TvAiringTodayResponse> airingTodayResponseCall = tvApiInterface.getAiringToday(Const.API_KEY);
        airingTodayResponseCall.enqueue(new Callback<TvAiringTodayResponse>() {
            @Override
            public void onResponse(Call<TvAiringTodayResponse> call, Response<TvAiringTodayResponse> response) {
                if (response.isSuccessful() && response.body().getTvAiringTodays() != null) {
                    tvAiringTodays = response.body().getTvAiringTodays();
                    adapter = new TvAiringTodayAdapter(tvAiringTodays, TvAiringTodayFragment.this);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(getActivity(), "Failed", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<TvAiringTodayResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
                Toast.makeText(getActivity(), "Failed " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }

        });
    }

    @Override
    public void onClick(int pos) {
        String s = tvAiringTodays.get(pos).getName();
        Intent detailActivity = new Intent(getActivity(), DetailActivity.class);
        detailActivity.putExtra("ID", tvAiringTodays.get(pos).getId());
        detailActivity.putExtra("TITLE", tvAiringTodays.get(pos).getName());
        detailActivity.putExtra("IMG_URL", tvAiringTodays.get(pos).getImgUrl());
        detailActivity.putExtra("RELEASE_DATE", tvAiringTodays.get(pos).getReleaseDate());
        detailActivity.putExtra("OVERVIEW", tvAiringTodays.get(pos).getOverview());
        startActivity(detailActivity);
    }
}