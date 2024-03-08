package com.buka.mapper;

import com.buka.pojo.Movie;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MovieMapper {
    @Select("select * from t_movie where movie_name = #{movieName}")
    Movie selectMovieByMovieName(String movieName);

    @Insert("insert into t_movie values(null,#{movieName},#{moviePassword},#{moviePlace},0)")
    int addMovie(Movie movie);

    @Select("select * from t_movie where movie_id = #{schedulingMovieId}")
    public Movie selectMovieBySchedulingMovieId(String schedulingMovieId);

    @Select("select * from t_movie")
    List<Movie> getAllMovie();

    @Update("update t_movie set movie_state = 1 where movie_id = #{movieId}")
    int banMovieByMovieId(int movieId);

    @Update("update t_movie set movie_state = 0 where movie_id = #{movieId}")
    int unblockingMovieByMovieId(int movieId);

    @Update("update t_cinema_hall set Cinema_hall_state = 1 where Cinema_hall_id = #{cinemaHallId}")
    int banCinHallById(int cinemaHallId);

    @Update("update t_cinema_hall set Cinema_hall_state = 0 where Cinema_hall_id = #{cinemaHallId}")
    int unblockingCinHallById(int cinemaHallId);

    @Update("update t_cinema_hall set Cinema_hall_seat = #{cinemaHallSeat} where Cinema_hall_id = #{cinemaHallId}")
    int addCinemaHallSeatByCinemaHallId(@Param("cinemaHallSeat") String cinemaHallSeat, @Param("cinemaHallId") int cinemaHallId);
}
