package com.buka.service.movie;

import com.buka.mapper.MovieMapper;
import com.buka.pojo.Movie;
import com.buka.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class MovieLoginService {
    @Autowired
    private MovieMapper movieMapper;
    public ResponseJson movieLogin(String movieName, String moviePassword, HttpSession httpSession) {
        Movie movie = movieMapper.selectMovieByMovieName(movieName);
        if (movie != null && moviePassword.equals(movie.getMoviePassword())){
            httpSession.setAttribute("movie",movie);
            return ResponseJson.getOK(200,"登录成功");
        }else {
            return ResponseJson.getError(-1,"用户名或密码错误");
        }
    }
}
