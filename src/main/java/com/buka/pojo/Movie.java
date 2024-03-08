package com.buka.pojo;

public class Movie {
    private int movieId;
    private String movieName;
    private String moviePassword;
    private String moviePlace;
    private int movieState;

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", moviePassword='" + moviePassword + '\'' +
                ", moviePlace='" + moviePlace + '\'' +
                ", movieState=" + movieState +
                '}';
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMoviePassword() {
        return moviePassword;
    }

    public void setMoviePassword(String moviePassword) {
        this.moviePassword = moviePassword;
    }

    public String getMoviePlace() {
        return moviePlace;
    }

    public void setMoviePlace(String moviePlace) {
        this.moviePlace = moviePlace;
    }

    public int getMovieState() {
        return movieState;
    }

    public void setMovieState(int movieState) {
        this.movieState = movieState;
    }
}
