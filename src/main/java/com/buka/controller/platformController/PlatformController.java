package com.buka.controller.platformController;

import com.buka.service.platform.*;
import com.buka.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/platform")
public class PlatformController {
    @Autowired
    private PlatformLoginService platformLoginService;
    @Autowired
    private PlatformSignService platformSignService;
    @Autowired
    private DownService downService;
    @Autowired
    private AddFilmService addFilmService;

    @Autowired
    private PlatformService platformService;
    @RequestMapping("/platformLogin")
    @ResponseBody
    public ResponseJson platformLogin(String platformName, String platformPassword, HttpSession httpSession) {
        return platformLoginService.platformLogin(platformName, platformPassword, httpSession);
    }

    @RequestMapping("/platformSign")
    @ResponseBody
    public ResponseJson platformSign(String platformName, String platformPassword) {
        return platformSignService.platformSign(platformName, platformPassword);
    }

    @RequestMapping("/addfilm")
    @ResponseBody
    public ResponseJson addFilm(String filmName, Integer filmTime, MultipartFile file) throws IOException {
        return addFilmService.addfilm(filmName, filmTime, file);
    }


    @RequestMapping("/down")
    @ResponseBody
    public void getFilmPosters(HttpServletResponse response, String filmId) throws IOException {
        downService.down(response, filmId);
    }

    @RequestMapping("/getallfilm")
    @ResponseBody
    public ResponseJson getAllFilm(){
        return platformService.getAllFilm();
    }

    @RequestMapping("/banfilm")
    @ResponseBody
    private ResponseJson banFilmByFilmId(int filmId){
        return platformService.banFilmByFilmId(filmId);
    }

    @RequestMapping("/UnblockingFilm")
    @ResponseBody
    private ResponseJson UnblockingFilmByFilmId(int filmId){
        return platformService.UnblockingFilmByFilmId(filmId);
    }

    @RequestMapping("/selectorder")
    @ResponseBody
    public ResponseJson getAllOrder(){
        return platformService.getAllOrder();
    }

    @RequestMapping("/selectallmoney")
    @ResponseBody
    public ResponseJson getAllMoney(){
        return platformService.getAllMoney();
    }
}

