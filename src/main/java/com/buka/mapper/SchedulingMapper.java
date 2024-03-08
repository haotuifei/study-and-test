package com.buka.mapper;

import com.buka.pojo.CinemaHall;
import com.buka.pojo.Film;
import com.buka.pojo.Movie;
import com.buka.pojo.Scheduling;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SchedulingMapper {
    @Select("select * from t_scheduling where Scheduling_film_id = #{filmId}")
    @Results({
            @Result(property = "schedulingId", column = "scheduling_id", id = true),
            @Result(property = "schedulingMovieId", column = "scheduling_movie_id"),
            @Result(
                    property = "movie",
                    javaType = Movie.class,
                    column = "Scheduling_movie_id",
                    one = @One(select = "com.buka.mapper.MovieMapper.selectMovieBySchedulingMovieId")
            ),
            @Result(property = "schedulingCinemaHallId", column = "Scheduling_cinema_hall_id"),
            @Result(
                    property = "cinemaHall",
                    javaType = CinemaHall.class,
                    column = "Scheduling_cinema_hall_id",
                    one = @One(select = "com.buka.mapper.CinemaHallMapper.getCinemaHallBySchedulingCinemaHallId")
            ),
            @Result(property = "schedulingFilmId", column = "Scheduling_film_id"),
            @Result(
                    property = "film",
                    javaType = Film.class,
                    column = "Scheduling_film_id",
                    one = @One(select = "com.buka.mapper.FilmMapper.selectMovieBySchedulingFilmId")
            ),
            @Result(property = "schedulingRuntime", column = "Scheduling_runtime"),
            @Result(property = "schedulingOvertime", column = "Scheduling_overtime"),
            @Result(property = "schedulingMoney", column = "Scheduling_money"),
            @Result(property = "schedulingState", column = "Scheduling_state"),
    })
    List<Scheduling> getMovieByFilmId(int filmId);

    @Select("select * from t_scheduling where scheduling_id = #{schedulingId}")
    @Results({
            @Result(property = "schedulingId", column = "scheduling_id", id = true),
            @Result(property = "schedulingMovieId", column = "scheduling_movie_id"),
            @Result(
                    property = "movie",
                    javaType = Movie.class,
                    column = "Scheduling_movie_id",
                    one = @One(select = "com.buka.mapper.MovieMapper.selectMovieBySchedulingMovieId")
            ),
            @Result(property = "schedulingCinemaHallId", column = "Scheduling_cinema_hall_id"),
            @Result(
                    property = "cinemaHall",
                    javaType = CinemaHall.class,
                    column = "Scheduling_cinema_hall_id",
                    one = @One(select = "com.buka.mapper.CinemaHallMapper.getCinemaHallBySchedulingCinemaHallId")
            ),
            @Result(property = "schedulingFilmId", column = "Scheduling_film_id"),
            @Result(
                    property = "film",
                    javaType = Film.class,
                    column = "Scheduling_film_id",
                    one = @One(select = "com.buka.mapper.FilmMapper.selectMovieBySchedulingFilmId")
            ),
            @Result(property = "schedulingRuntime", column = "Scheduling_runtime"),
            @Result(property = "schedulingOvertime", column = "Scheduling_overtime"),
            @Result(property = "schedulingMoney", column = "Scheduling_money"),
            @Result(property = "schedulingState", column = "Scheduling_state"),
    })
    public Scheduling getSchedulingBySchedulingId(int schedulingId);

    @Select("select * from t_scheduling where Scheduling_movie_id = #{movieId}")
    @Results({
            @Result(property = "schedulingId", column = "scheduling_id", id = true),
            @Result(property = "schedulingMovieId", column = "scheduling_movie_id"),
            @Result(
                    property = "movie",
                    javaType = Movie.class,
                    column = "Scheduling_movie_id",
                    one = @One(select = "com.buka.mapper.MovieMapper.selectMovieBySchedulingMovieId")
            ),
            @Result(property = "schedulingCinemaHallId", column = "Scheduling_cinema_hall_id"),
            @Result(
                    property = "cinemaHall",
                    javaType = CinemaHall.class,
                    column = "Scheduling_cinema_hall_id",
                    one = @One(select = "com.buka.mapper.CinemaHallMapper.getCinemaHallBySchedulingCinemaHallId")
            ),
            @Result(property = "schedulingFilmId", column = "Scheduling_film_id"),
            @Result(
                    property = "film",
                    javaType = Film.class,
                    column = "Scheduling_film_id",
                    one = @One(select = "com.buka.mapper.FilmMapper.selectMovieBySchedulingFilmId")
            ),
            @Result(property = "schedulingRuntime", column = "Scheduling_runtime"),
            @Result(property = "schedulingOvertime", column = "Scheduling_overtime"),
            @Result(property = "schedulingMoney", column = "Scheduling_money"),
            @Result(property = "schedulingState", column = "Scheduling_state"),
    })
    List<Scheduling> getschebymovieid(int movieId);

    @Update("update t_scheduling set Scheduling_state = 1 where Scheduling_id = #{schedulingId}")
    int banScheByScheId(int schedulingId);

    @Update("update t_scheduling set Scheduling_state = 0 where Scheduling_id = #{schedulingId}")
    int unbanScheByScheId(int schedulingId);

    @Insert("insert into t_scheduling values(null,#{schedulingMovieId},#{schedulingCinemaHallId},#{schedulingFilmId},#{schedulingSeat},#{schedulingRuntime},#{schedulingOvertime},#{schedulingMoney},0)")
    int addSche(Scheduling scheduling);

    @Select("select * from t_scheduling where Scheduling_id = #{schedulingId}")
    @Results({
            @Result(property = "schedulingId", column = "scheduling_id", id = true),
            @Result(property = "schedulingMovieId", column = "scheduling_movie_id"),
            @Result(
                    property = "movie",
                    javaType = Movie.class,
                    column = "Scheduling_movie_id",
                    one = @One(select = "com.buka.mapper.MovieMapper.selectMovieBySchedulingMovieId")
            ),
            @Result(property = "schedulingCinemaHallId", column = "Scheduling_cinema_hall_id"),
            @Result(
                    property = "cinemaHall",
                    javaType = CinemaHall.class,
                    column = "Scheduling_cinema_hall_id",
                    one = @One(select = "com.buka.mapper.CinemaHallMapper.getCinemaHallBySchedulingCinemaHallId")
            ),
            @Result(property = "schedulingFilmId", column = "Scheduling_film_id"),
            @Result(
                    property = "film",
                    javaType = Film.class,
                    column = "Scheduling_film_id",
                    one = @One(select = "com.buka.mapper.FilmMapper.selectMovieBySchedulingFilmId")
            ),
            @Result(property = "schedulingRuntime", column = "Scheduling_runtime"),
            @Result(property = "schedulingOvertime", column = "Scheduling_overtime"),
            @Result(property = "schedulingMoney", column = "Scheduling_money"),
            @Result(property = "schedulingState", column = "Scheduling_state"),
    })
    Scheduling getScheById(int schedulingId);

    @Select("select Scheduling_seat from t_scheduling where Scheduling_id = #{schedulingId}")
    String getScheSeatById(int schedulingId);

    @Update("update t_scheduling set Scheduling_seat = #{newseatinfo} where Scheduling_id = #{schedulingId}")
    int updateseat(@Param("newseatinfo") String newseatinfo,@Param("schedulingId") int schedulingId);
}
