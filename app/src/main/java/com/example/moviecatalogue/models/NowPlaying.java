package com.example.moviecatalogue.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NowPlaying {
    private String id;
    private String title;
    private String overview;

    @SerializedName("vote_average")
    private String voteAverage;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("poster_path")
    private String imgUrl;

    public NowPlaying() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }
}