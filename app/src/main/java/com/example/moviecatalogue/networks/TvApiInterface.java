package com.example.moviecatalogue.networks;

import com.example.moviecatalogue.models.TvAiringTodayResponse;
import com.example.moviecatalogue.models.movie.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TvApiInterface {
    // https://api.themoviedb.org/3/tv/airing_today
    @GET("airing_today")
    Call<TvAiringTodayResponse> getAiringToday(
            @Query("api_key") String apiKey
    );

}
