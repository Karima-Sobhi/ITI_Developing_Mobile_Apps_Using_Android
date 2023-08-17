package com.iti.cinemamovies.connect;


import java.io.Serializable;

public class Movie implements Serializable {
    private int id;
    private String title;
    private String release_date;
    private String poster_path;
    private String overview;
    private float vote_average;


    public Movie(String title, String poster_path, String overview) {
        this.title = title;
        this.poster_path = poster_path;
        this.overview = overview;
    }


    public Movie() {

    }

    public Movie(int id, String title, String release_date, String poster_path,String overview, float vote_average) {
        this.id = id;
        this.title = title;
        this.release_date = release_date;
        this.poster_path = poster_path;
        this.overview = overview;
        this.vote_average = vote_average;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public float getVote_average() {
        return vote_average;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterUrl() {
        return poster_path;
    }

    public void setPosterUrl(String posterUrl) {
        this.poster_path = posterUrl;
    }

    public Movie(String title, String release_date) {
        this.title = title;
        this.release_date = release_date;
    }
}
