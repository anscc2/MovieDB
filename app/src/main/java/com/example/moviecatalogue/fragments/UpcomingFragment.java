package com.example.moviecatalogue.fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import com.example.moviecatalogue.R;
import com.example.moviecatalogue.adapters.UpcomingAdapter;
import com.example.moviecatalogue.models.Upcoming;
import com.example.moviecatalogue.models.UpcomingResponse;
import com.example.moviecatalogue.networks.Const;
import com.example.moviecatalogue.networks.MovieApiClient;
import com.example.moviecatalogue.networks.MovieApiInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpcomingFragment extends Fragment {
    private static final String TAG = "UpcomingFragment";
    private RecyclerView recyclerView;
    private UpcomingAdapter adapter;
    private List<Upcoming> upcomings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upcoming, container, false);
        recyclerView = view.findViewById(R.id.rv_upcoming);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        loadData();
        return view;
    }

    public void loadData() {
        MovieApiInterface movieApiInterface = MovieApiClient.getRetrofit()
                .create(MovieApiInterface.class);
        Call<UpcomingResponse> upcomingCall = movieApiInterface.getUpcoming(Const.API_KEY);
        upcomingCall.enqueue(new Callback<UpcomingResponse>() {
            @Override
            public void onResponse(Call<UpcomingResponse> call, Response<UpcomingResponse> response) {
                if (response.isSuccessful()) {
                    upcomings = response.body().getUpcomings();
                    adapter = new UpcomingAdapter(upcomings);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(getActivity(), "Failed", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UpcomingResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
                Toast.makeText(getActivity(), "Failed " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
