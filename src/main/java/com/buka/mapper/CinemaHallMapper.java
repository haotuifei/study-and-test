package com.buka.mapper;

import com.buka.pojo.CinemaHall;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CinemaHallMapper {
    @Select("select * from t_cinema_hall where Cinema_hall_id = #{schedulingCinemaHallId}")
    public CinemaHall getCinemaHallBySchedulingCinemaHallId(String schedulingCinemaHallId);

    @Select("select * from t_cinema_hall where Cinema_hall_movie_id = #{movieId}")
    List<CinemaHall> getCinHallByCinId(int movieId);

    @Select("select cinema_hall_seat from t_cinema_hall where cinema_hall_id = #{cinemaHallId}")
    String getSeatInfoByCinemaHallId(int cinemaHallId);

    @Insert("insert into t_cinema_hall values(null,#{cinemaHallName},null,#{cinemaHallMovieId},0)")
    int addCinHall(CinemaHall cinemaHall);
}
