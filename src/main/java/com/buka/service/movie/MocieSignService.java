package com.buka.service.movie;

import com.buka.mapper.MovieMapper;
import com.buka.mapper.UserMapper;
import com.buka.pojo.Movie;
import com.buka.pojo.User;
import com.buka.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MocieSignService {
    @Autowired
    private MovieMapper movieMapper;

    public ResponseJson movieSign(String movieName, String moviePassword,String moviePlace) {
        Movie movie = new Movie();
        movie.setMovieName(movieName);
        movie.setMoviePassword(moviePassword);
        movie.setMoviePlace(moviePlace);

        int i = movieMapper.addMovie(movie);
        if (i>0){
            return ResponseJson.getOK(200,"注册成功");
        }else {
            return ResponseJson.getError(-1,"注册失败");
        }
    }
}
