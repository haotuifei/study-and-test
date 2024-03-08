package com.buka.pojo;

import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import javax.xml.crypto.Data;
import java.sql.Timestamp;

public class Scheduling {
    private int schedulingId;
    private int schedulingMovieId;
    private int schedulingCinemaHallId;
    private int schedulingFilmId;
    private String schedulingSeat;
    private Timestamp schedulingRuntime;
    private Timestamp schedulingOvertime;
    private int schedulingMoney;
    private int schedulingState;
    private Movie movie;
    private Film film;
    private CinemaHall cinemaHall;

    @Override
    public String toString() {
        return "Scheduling{" +
                "schedulingId=" + schedulingId +
                ", schedulingMovieId=" + schedulingMovieId +
                ", schedulingCinemaHallId=" + schedulingCinemaHallId +
                ", schedulingFilmId=" + schedulingFilmId +
                ", schedulingSeat='" + schedulingSeat + '\'' +
                ", schedulingRuntime=" + schedulingRuntime +
                ", schedulingOvertime=" + schedulingOvertime +
                ", schedulingMoney=" + schedulingMoney +
                ", schedulingState=" + schedulingState +
                ", movie=" + movie +
                ", film=" + film +
                ", cinemaHall=" + cinemaHall +
                '}';
    }

    public int getSchedulingId() {
        return schedulingId;
    }

    public void setSchedulingId(int schedulingId) {
        this.schedulingId = schedulingId;
    }

    public int getSchedulingMovieId() {
        return schedulingMovieId;
    }

    public void setSchedulingMovieId(int schedulingMovieId) {
        this.schedulingMovieId = schedulingMovieId;
    }

    public int getSchedulingCinemaHallId() {
        return schedulingCinemaHallId;
    }

    public void setSchedulingCinemaHallId(int schedulingCinemaHallId) {
        this.schedulingCinemaHallId = schedulingCinemaHallId;
    }

    public int getSchedulingFilmId() {
        return schedulingFilmId;
    }

    public void setSchedulingFilmId(int schedulingFilmId) {
        this.schedulingFilmId = schedulingFilmId;
    }

    public String getSchedulingSeat() {
        return schedulingSeat;
    }

    public void setSchedulingSeat(String schedulingSeat) {
        this.schedulingSeat = schedulingSeat;
    }

    public Timestamp getSchedulingRuntime() {
        return schedulingRuntime;
    }

    public void setSchedulingRuntime(Timestamp schedulingRuntime) {
        this.schedulingRuntime = schedulingRuntime;
    }

    public Timestamp getSchedulingOvertime() {
        return schedulingOvertime;
    }

    public void setSchedulingOvertime(Timestamp schedulingOvertime) {
        this.schedulingOvertime = schedulingOvertime;
    }

    public int getSchedulingMoney() {
        return schedulingMoney;
    }

    public void setSchedulingMoney(int schedulingMoney) {
        this.schedulingMoney = schedulingMoney;
    }

    public int getSchedulingState() {
        return schedulingState;
    }

    public void setSchedulingState(int schedulingState) {
        this.schedulingState = schedulingState;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }
}
