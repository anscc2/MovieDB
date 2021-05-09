package com.example.moviecatalogue.networks;

import com.example.moviecatalogue.models.NowPlayingResponse;
import com.example.moviecatalogue.models.UpcomingResponse;
import com.example.moviecatalogue.models.movie.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApiInterface {
    // https://api.themoviedb.org/3/movie/now_playing
    @GET("now_playing")
    Call<NowPlayingResponse> getNowPlaying(
            @Query("api_key") String apiKey
    );

    @GET("movie/{movie_id}")
    Call<Movie> getMovie(
            @Path("movie_id") String id,
            @Query("api_key") String apiKey
    );

    @GET("upcoming")
    Call<UpcomingResponse> getUpcoming(
            @Query("api_key") String apiKey
    );

}
