package com.buka.controller.movieController;

import com.buka.service.movie.MovieLoginService;
import com.buka.service.movie.MocieSignService;
import com.buka.service.movie.MovieService;
import com.buka.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.ParseException;

@Controller
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieLoginService movieLoginService;

    @Autowired
    private MocieSignService mocieSignService;

    @Autowired
    private MovieService movieService;

    @RequestMapping("/movieLogin")
    @ResponseBody
    public ResponseJson login(String movieName, String moviePassword, HttpSession httpSession) {
        return movieLoginService.movieLogin(movieName, moviePassword, httpSession);
    }

    @RequestMapping("/movieSign")
    @ResponseBody
    public ResponseJson sign(String movieName, String moviePassword, String moviePlace) {
        return mocieSignService.movieSign(movieName, moviePassword, moviePlace);
    }

    @RequestMapping("/selectfilm")
    @ResponseBody
    public ResponseJson getMovie() {
        return movieService.getAllFilm();
    }

    @RequestMapping("/banmovie")
    @ResponseBody
    public ResponseJson banUser(int movieId) {
        return movieService.banMovieByMovieId(movieId);
    }

    @RequestMapping("/unblockingmovie")
    @ResponseBody
    public ResponseJson unblockingMovieByMovieId(int movieId) {
        return movieService.unblockingMovieByMovieId(movieId);
    }

    @RequestMapping("selectcinhall")
    @ResponseBody
    public ResponseJson getCinHall(HttpSession session) {
        return movieService.getCinHallByCinId(session);
    }

    @RequestMapping("/bancinhall")
    @ResponseBody
    public ResponseJson banCinHall(int CinemaHallId) {
        return movieService.banCinHallById(CinemaHallId);
    }

    @RequestMapping("/unblockingcinhall")
    @ResponseBody
    public ResponseJson unblockingCinHallById(int CinemaHallId) {
        return movieService.unblockingCinHallById(CinemaHallId);
    }

    @RequestMapping("/getseatinfo")
    @ResponseBody
    public ResponseJson getSeatInfo(int cinemaHallId) {
        return movieService.getSeatInfo(cinemaHallId);

    }

    @RequestMapping("/saveSeatInfo")
    @ResponseBody
    public ResponseJson saveSeatInfo(String cinemaHallSeat, int cinemaHallId) {
        return movieService.saveSeatInfo(cinemaHallSeat, cinemaHallId);
    }

    @RequestMapping("/getschebymovieid")
    @ResponseBody
    public ResponseJson getschebymovieid(HttpSession session) {
        return movieService.getschebymovieid(session);
    }

    @RequestMapping("/banschebyscheId")
    @ResponseBody
    public ResponseJson banScheByScheId(int schedulingId) {
        return movieService.banScheByScheId(schedulingId);
    }

    @RequestMapping("/unbanschebyscheId")
    @ResponseBody
    public ResponseJson unbanScheByScheId(int schedulingId) {
        return movieService.unbanScheByScheId(schedulingId);
    }

    @RequestMapping("/savesche")
    @ResponseBody
    public ResponseJson saveSche(int schedulingFilmId, int schedulingCinemaHallId, String schedulingRuntime, int schedulingMoney, HttpSession session) throws ParseException {
        return movieService.saveSche(schedulingFilmId, schedulingCinemaHallId, schedulingRuntime, schedulingMoney, session);
    }

    @RequestMapping("/getallorderbymovieid")
    @ResponseBody
    public ResponseJson getAllOrderByMovieId(HttpSession session){
        return movieService.getAllOrderByMovieId(session);
    }

    @RequestMapping("/getallmoney")
    @ResponseBody
    public ResponseJson getAllMoneyByMovieId(HttpSession session){
        return movieService.getAllMoneyByMovieId(session);
    }



    @RequestMapping("/getallfilmbymovieid")
    @ResponseBody
    public ResponseJson getAllFilmByMovieId(){
        return movieService.getAllFilmByMovieId();
    }

    @RequestMapping("/addcinhall")
    @ResponseBody
    public ResponseJson addCinHall(HttpSession session,String cinemaHallName){
        return movieService.addCinHall(session,cinemaHallName);
    }
}
