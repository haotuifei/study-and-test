package com.buka.mapper;

import com.buka.pojo.Film;
import com.buka.pojo.Movie;
import com.buka.util.ResponseJson;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface FilmMapper {

    @Select("select * from t_film where film_state = 0")
    List<Film> getAllFilm();

    @Select("select * from t_film where film_id = #{SchedulingFilmId}")
    Film selectMovieBySchedulingFilmId(String SchedulingFilmId);

    @Insert("insert into t_film values(null,#{filmName},#{filmPosters},#{filmTime},0)")
    int addFilm(Film film);

    @Update("update t_film set film_state = 1 where film_id = #{filmId}")
    int banFilmByFilmId(int filmId);

    @Update("update t_film set film_state = 0 where film_id = #{filmId}")
    int UnblockingFilmByFilmId(int filmId);

    @Select("select film_time from t_film where film_id = #{schedulingFilmId}")
    int getFilmTimeByFilmId(int schedulingFilmId);

    @Select("select * from t_film where film_state = 0")
    List<Film> getAllFilmByMovieId();

    @Select("select * from t_film")
    List<Film> getAllFilmforpla();
}
