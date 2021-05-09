package com.example.moviecatalogue.models;

import com.google.gson.annotations.SerializedName;

public class TvAiringToday {
    private String id;
    private String name;
    private String overview;

    @SerializedName("vote_average")
    private String voteAverage;

    @SerializedName("first_air_date")
    private String releaseDate;

    @SerializedName("backdrop_path")
    private String imgUrl;

    public TvAiringToday(){}

    public String getId() {return id;}

    public void setId(String id){this.id = id;}

    public String getName(){return name;}

    public void setName(String name){this.name = name;}

    public String getOverview(){return overview;}

    public void setOverview(String overview){this.overview = overview;}

    public String getReleaseDate(){return releaseDate;}

    public void setReleaseDate(String releaseDate){this.releaseDate = releaseDate;}

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getVoteAverage() {return voteAverage;}

    public void setVoteAverage(String voteAverage) {
        this.voteAverage = voteAverage;
    }
}
