package com.buka.service.platform;

import com.buka.mapper.FilmMapper;
import com.buka.mapper.OrderMapper;
import com.buka.pojo.Film;
import com.buka.pojo.Order;
import com.buka.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatformService {
    @Autowired
    private FilmMapper filmMapper;

    @Autowired
    private OrderMapper orderMapper;

    public ResponseJson banFilmByFilmId(int filmId) {
        int i = filmMapper.banFilmByFilmId(filmId);
        if (i > 0) {
            return ResponseJson.getOK("封禁成功");
        } else {
            return ResponseJson.getError("封禁失败");
        }
    }

    public ResponseJson UnblockingFilmByFilmId(int filmId) {
        int i = filmMapper.UnblockingFilmByFilmId(filmId);
        if (i > 0) {
            return ResponseJson.getOK("解封成功");
        } else {
            return ResponseJson.getError("解封失败");
        }
    }

    public ResponseJson getAllOrder() {
        List<Order> orderList = orderMapper.getAllOrder();
        if (orderList != null) {
            return ResponseJson.getOK(orderList);
        } else {
            return ResponseJson.getError("获取订单失败");
        }
    }

    public ResponseJson getAllMoney() {
        int money = orderMapper.getAllMoney();
        return ResponseJson.getOK(money);
    }

    public ResponseJson getAllFilm() {
        List<Film> filmList = filmMapper.getAllFilmforpla();
        if (filmList!=null){
            return ResponseJson.getOK(filmList);
        }else {
            return ResponseJson.getError("获取电影信息失败");
        }
    }
}
