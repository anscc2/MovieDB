package com.example.moviecatalogue.networks;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TvApiClient {
    private static Retrofit retrofit;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(Const.BASE_URL_TV)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
