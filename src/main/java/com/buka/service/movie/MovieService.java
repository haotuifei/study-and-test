package com.buka.service.movie;

import com.alibaba.fastjson.JSON;
import com.buka.mapper.*;
import com.buka.pojo.*;
import com.buka.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private CinemaHallMapper cinemaHallMapper;

    @Autowired
    private SchedulingMapper schedulingMapper;

    @Autowired
    private FilmMapper filmMapper;

    @Autowired
    private OrderMapper orderMapper;

    public ResponseJson getAllFilm() {
        List<Movie> movieList = movieMapper.getAllMovie();
        if (movieList != null) {
            return ResponseJson.getOK(movieList);
        } else {
            return ResponseJson.getOK("无任何影院");
        }
    }


    public ResponseJson banMovieByMovieId(int movieId) {
        int i = movieMapper.banMovieByMovieId(movieId);
        if (i > 0) {
            return ResponseJson.getOK("封禁成功");
        } else {
            return ResponseJson.getError("封禁失败");
        }

    }

    public ResponseJson unblockingMovieByMovieId(int movieId) {
        int i = movieMapper.unblockingMovieByMovieId(movieId);
        if (i > 0) {
            return ResponseJson.getOK("封禁成功");
        } else {
            return ResponseJson.getError("封禁失败");
        }
    }

    public ResponseJson getCinHallByCinId(HttpSession session) {
        Movie movie = (Movie) session.getAttribute("movie");
        int movieId = movie.getMovieId();
        List<CinemaHall> hallList = cinemaHallMapper.getCinHallByCinId(movieId);
        if (hallList != null) {
            return ResponseJson.getOK(hallList);
        } else {
            return ResponseJson.getError("获取影厅信息失败");
        }
    }

    public ResponseJson banCinHallById(int cinemaHallId) {
        int i = movieMapper.banCinHallById(cinemaHallId);
        if (i > 0) {
            return ResponseJson.getOK("已停用");
        } else {
            return ResponseJson.getError("停用失败");
        }
    }

    public ResponseJson unblockingCinHallById(int cinemaHallId) {
        int i = movieMapper.unblockingCinHallById(cinemaHallId);
        if (i > 0) {
            return ResponseJson.getOK("已启用");
        } else {
            return ResponseJson.getError("启用失败");
        }
    }

    public ResponseJson getSeatInfo(int cinemaHallId) {
        String parseObject = cinemaHallMapper.getSeatInfoByCinemaHallId(cinemaHallId);
        if (parseObject != null) {
            Integer[][] seatinfo = JSON.parseObject(parseObject, Integer[][].class);
            return ResponseJson.getOK(seatinfo);
        } else {
            return ResponseJson.getError("获取座位信息失败");
        }
    }

    public ResponseJson saveSeatInfo(String cinemaHallSeat, int cinemaHallId) {
        int i = movieMapper.addCinemaHallSeatByCinemaHallId(cinemaHallSeat, cinemaHallId);
        if (i > 0) {
            return ResponseJson.getOK("保存成功");
        } else {
            return ResponseJson.getError("保存失败");
        }
    }

    public ResponseJson getschebymovieid(HttpSession session) {
        Movie movie = (Movie) session.getAttribute("movie");
        int movieId = movie.getMovieId();
        List<Scheduling> schedulingList = schedulingMapper.getschebymovieid(movieId);
        if (schedulingList != null) {
            return ResponseJson.getOK(schedulingList);
        } else {
            return ResponseJson.getError("获取排片表信息错误");
        }
    }

    public ResponseJson banScheByScheId(int schedulingId) {
        int i = schedulingMapper.banScheByScheId(schedulingId);
        if (i > 0) {
            return ResponseJson.getOK("已下架");
        } else {
            return ResponseJson.getError("下架失败");
        }
    }

    public ResponseJson unbanScheByScheId(int schedulingId) {
        int i = schedulingMapper.unbanScheByScheId(schedulingId);
        if (i > 0) {
            return ResponseJson.getOK("已上架");
        } else {
            return ResponseJson.getError("上架失败");
        }
    }

    public ResponseJson saveSche(int schedulingFilmId, int schedulingCinemaHallId, String schedulingRuntime, int schedulingMoney, HttpSession session) throws ParseException {
        Movie movie = (Movie) session.getAttribute("movie");
        int filmTime = filmMapper.getFilmTimeByFilmId(schedulingFilmId);
        String seatinfo = cinemaHallMapper.getSeatInfoByCinemaHallId(schedulingCinemaHallId);
        int movieId = movie.getMovieId();
        Scheduling scheduling = new Scheduling();
        scheduling.setSchedulingMovieId(movieId);
        scheduling.setSchedulingFilmId(schedulingFilmId);
        scheduling.setSchedulingCinemaHallId(schedulingCinemaHallId);
        scheduling.setSchedulingSeat(seatinfo);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date parsedDate = dateFormat.parse(schedulingRuntime);
        Timestamp timestamp = new Timestamp(parsedDate.getTime());
        long seconds = timestamp.getTime() / 1000;
        seconds = seconds + filmTime;
        Timestamp timestamp2 = new Timestamp(seconds * 1000);
        scheduling.setSchedulingRuntime(timestamp);
        scheduling.setSchedulingOvertime(timestamp2);
        scheduling.setSchedulingMoney(schedulingMoney);
        int i = schedulingMapper.addSche(scheduling);
        if (i > 0) {
            return ResponseJson.getOK("添加成功");
        } else {
            return ResponseJson.getError("添加失败");
        }
    }

    public ResponseJson getAllOrderByMovieId(HttpSession session) {
        Movie movie = (Movie) session.getAttribute("movie");
        int movieId = movie.getMovieId();
        List<Order> orderList = orderMapper.getAllOrderByMovieId(movieId);
        if (orderList != null) {
            return ResponseJson.getOK(orderList);
        } else {
            return ResponseJson.getError("获取订单信息失败");
        }
    }

    public ResponseJson getAllMoneyByMovieId(HttpSession session) {
        Movie movie = (Movie) session.getAttribute("movie");
        int movieId = movie.getMovieId();
        int i = orderMapper.getAllMoneyByMovieId(movieId);
        return ResponseJson.getOK(i);
    }

    public ResponseJson getAllFilmByMovieId() {
        List<Film> filmList = filmMapper.getAllFilmByMovieId();
        if (filmList != null){
            return ResponseJson.getOK(filmList);
        }else {
            return ResponseJson.getError("获取电影信息失败");
        }
    }

    public ResponseJson addCinHall(HttpSession session, String cinemaHallName) {
        Movie movie = (Movie) session.getAttribute("movie");
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setCinemaHallName(cinemaHallName);
        cinemaHall.setCinemaHallMovieId(movie.getMovieId());
       int i = cinemaHallMapper.addCinHall(cinemaHall);
       if (i>0){
           return ResponseJson.getOK("添加成功");
       }else {
           return ResponseJson.getError("添加失败");
       }
    }
}
