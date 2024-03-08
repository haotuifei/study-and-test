package com.buka.pojo;

public class CinemaHall {
    private int cinemaHallId;
    private String cinemaHallName;
    private String cinemaHallSeat;
    private int cinemaHallMovieId;
    private int cinemaHallState;

    @Override
    public String toString() {
        return "CinemaHall{" +
                "cinemaHallId=" + cinemaHallId +
                ", cinemaHallName='" + cinemaHallName + '\'' +
                ", cinemaHallSeat='" + cinemaHallSeat + '\'' +
                ", cinemaHallMovieId=" + cinemaHallMovieId +
                ", cinemaHallState=" + cinemaHallState +
                '}';
    }

    public int getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(int cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }

    public String getCinemaHallName() {
        return cinemaHallName;
    }

    public void setCinemaHallName(String cinemaHallName) {
        this.cinemaHallName = cinemaHallName;
    }

    public String getCinemaHallSeat() {
        return cinemaHallSeat;
    }

    public void setCinemaHallSeat(String cinemaHallSeat) {
        this.cinemaHallSeat = cinemaHallSeat;
    }

    public int getCinemaHallMovieId() {
        return cinemaHallMovieId;
    }

    public void setCinemaHallMovieId(int cinemaHallMovieId) {
        this.cinemaHallMovieId = cinemaHallMovieId;
    }

    public int getCinemaHallState() {
        return cinemaHallState;
    }

    public void setCinemaHallState(int cinemaHallState) {
        this.cinemaHallState = cinemaHallState;
    }
}
