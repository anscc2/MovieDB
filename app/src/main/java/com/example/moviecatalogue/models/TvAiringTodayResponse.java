package com.example.moviecatalogue.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TvAiringTodayResponse {
    @SerializedName("results")
    @Expose
    private List<TvAiringToday> tvAiringTodays;

    public List<TvAiringToday> getTvAiringTodays() {
        return tvAiringTodays;
    }
}
