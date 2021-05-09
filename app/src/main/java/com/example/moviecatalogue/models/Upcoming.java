package com.example.moviecatalogue.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Upcoming {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("release_date")
    @Expose
    private String releaseDate;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    @SerializedName("overview")
    @Expose
    private String overview;

    @SerializedName("poster_path")
    @Expose
    private String imgUrl;
}
