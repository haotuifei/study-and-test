package com.buka.pojo;

import java.sql.Timestamp;

public class Order {
    private int orderId;
    private String orderNumber;
    private int orderSchedulingId;
    private int orderMovieId;
    private int orderFilmId;
    private String orderSeat;
    private Timestamp orderTime;
    private int orderMoney;
    private int orderState;
    private String payNum;
    private Scheduling scheduling;
    private Movie movie;
    private Film film;
    private int orderUserId;
    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderSchedulingId=" + orderSchedulingId +
                ", orderMovieId=" + orderMovieId +
                ", orderFilmId=" + orderFilmId +
                ", orderSeat='" + orderSeat + '\'' +
                ", orderTime=" + orderTime +
                ", orderMoney=" + orderMoney +
                ", orderState=" + orderState +
                ", payNum='" + payNum + '\'' +
                ", scheduling=" + scheduling +
                ", movie=" + movie +
                ", film=" + film +
                ", orderUserId=" + orderUserId +
                '}';
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getOrderSchedulingId() {
        return orderSchedulingId;
    }

    public void setOrderSchedulingId(int orderSchedulingId) {
        this.orderSchedulingId = orderSchedulingId;
    }

    public int getOrderMovieId() {
        return orderMovieId;
    }

    public void setOrderMovieId(int orderMovieId) {
        this.orderMovieId = orderMovieId;
    }

    public int getOrderFilmId() {
        return orderFilmId;
    }

    public void setOrderFilmId(int orderFilmId) {
        this.orderFilmId = orderFilmId;
    }

    public String getOrderSeat() {
        return orderSeat;
    }

    public void setOrderSeat(String orderSeat) {
        this.orderSeat = orderSeat;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public int getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(int orderMoney) {
        this.orderMoney = orderMoney;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public String getPayNum() {
        return payNum;
    }

    public void setPayNum(String payNum) {
        this.payNum = payNum;
    }

    public Scheduling getScheduling() {
        return scheduling;
    }

    public void setScheduling(Scheduling scheduling) {
        this.scheduling = scheduling;
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

    public int getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(int orderUserId) {
        this.orderUserId = orderUserId;
    }
}
