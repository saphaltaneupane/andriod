package com.example.mpproject.movie;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieResults {
    @SerializedName("adult")
    @Expose
     boolean adult;

    @SerializedName("backdrop_path")
    @Expose
      String backdropPath;

    @SerializedName("genere_ids")
    @Expose
     List<Integer> genereId;

    @SerializedName("id")
    @Expose
     int id;
    @SerializedName("original_language")
    @Expose
     String originallanguage;

    @SerializedName("original_title")
    @Expose
     String originalTitle;

    @SerializedName("overview")
    @Expose
     String overview;

    @SerializedName("popularity")
    @Expose
     double popularity;

    @SerializedName("poster_path")
    @Expose
     String posterPath;
    @SerializedName("release_date")
    @Expose
     String releaseDate;

    @SerializedName("title")
    @Expose
     String title;

    @SerializedName("video")
    @Expose
     boolean video;

    @SerializedName("vote_average")
    @Expose
     double voteAverage;

    @SerializedName("vote_count")
    @Expose
     int voteCount;

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public List<Integer> getGenereId() {
        return genereId;
    }

    public void setGenereId(List<Integer> genereId) {
        this.genereId = genereId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginallanguage() {
        return originallanguage;
    }

    public void setOriginallanguage(String originallanguage) {
        this.originallanguage = originallanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}
