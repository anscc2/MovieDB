package com.example.moviecatalogue.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NowPlayingResponse {
    @SerializedName("results")
    @Expose
    private List<NowPlaying> nowPlayings;

    public List<NowPlaying> getNowPlayings() {
        return nowPlayings;
    }
}
