package com.example.mpproject.movie;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieContainer {
    @SerializedName("page")
    @Expose
    int page;

    @SerializedName("results")
    @Expose
    List<MovieResults> resultList;
    public List<MovieResults> getResultList() {
        return resultList;
    }

    public void setResultList(List<MovieResults> resultList) {
        this.resultList = resultList;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }



}
