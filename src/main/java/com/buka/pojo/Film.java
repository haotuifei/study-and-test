package com.buka.pojo;

public class Film {
    private int filmId;
    private String filmName;
    private String filmPosters;
    private Integer filmTime;
    private int filmState;

    @Override
    public String toString() {
        return "Film{" +
                "filmId=" + filmId +
                ", filmName='" + filmName + '\'' +
                ", filmPosters='" + filmPosters + '\'' +
                ", filmTime=" + filmTime +
                ", filmState=" + filmState +
                '}';
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmPosters() {
        return filmPosters;
    }

    public void setFilmPosters(String filmPosters) {
        this.filmPosters = filmPosters;
    }

    public Integer getFilmTime() {
        return filmTime;
    }

    public void setFilmTime(Integer filmTime) {
        this.filmTime = filmTime;
    }

    public int getFilmState() {
        return filmState;
    }

    public void setFilmState(int filmState) {
        this.filmState = filmState;
    }
}
