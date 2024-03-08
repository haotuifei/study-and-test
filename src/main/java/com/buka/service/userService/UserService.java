package com.buka.service.userService;

import com.alibaba.fastjson.JSON;
import com.buka.mapper.*;
import com.buka.pojo.Film;
import com.buka.pojo.Order;
import com.buka.pojo.Scheduling;
import com.buka.pojo.User;
import com.buka.util.ResponseJson;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private FilmMapper filmMapper;

    @Autowired
    private SchedulingMapper schedulingMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private WXPay wxPay;

    public ResponseJson getallfilm() {
        List<Film> filmList = filmMapper.getAllFilm();
        return ResponseJson.getOK(filmList);
    }

    public ResponseJson buytickets(int filmId) {
        List<Scheduling> schedulingList = schedulingMapper.getMovieByFilmId(filmId);
        return ResponseJson.getOK(schedulingList);
    }

    public ResponseJson getAllUser() {
        List<User> userList = userMapper.getAllUser();
        if (userList != null) {
            return ResponseJson.getOK(userList);
        } else {
            return ResponseJson.getError("无任何用户");
        }
    }

    public ResponseJson banUserByUserId(int userId) {
        int i = userMapper.changeUserStateByUserId(userId);
        if (i > 0) {
            return ResponseJson.getOK("成功封禁");
        } else {
            return ResponseJson.getError("封禁失败");
        }
    }

    public ResponseJson unblockingUserByUserId(int userId) {
        int i = userMapper.unblockingUserByUserId(userId);
        if (i > 0) {
            return ResponseJson.getOK("解封成功");
        } else {
            return ResponseJson.getError("解封失败");
        }
    }

    public ResponseJson getScheById(int schedulingId) {
        Scheduling scheduling = schedulingMapper.getScheById(schedulingId);
        if (scheduling != null) {
            return ResponseJson.getOK(scheduling);
        } else {
            return ResponseJson.getError("获取排片信息失败");
        }
    }

    public ResponseJson getSeatInfoByScheId(int schedulingId) {
        String parseObject = schedulingMapper.getScheSeatById(schedulingId);
        if (parseObject != null) {
            Integer[][] seatinfo = JSON.parseObject(parseObject, Integer[][].class);
            return ResponseJson.getOK(seatinfo);
        } else {
            return ResponseJson.getError("获取座位信息失败");
        }
    }


    public ResponseJson selSeat(int x, int y, Integer schedulingId, HttpSession session) {
        String seatinfo = schedulingMapper.getScheSeatById(schedulingId);
        Scheduling scheduling = schedulingMapper.getScheById(schedulingId);
        Integer[] seatArr = {x, y};
        Integer[][] parseObject = JSON.parseObject(seatinfo, Integer[][].class);
        User user = (User) session.getAttribute("user");
        int[] array = {y + 1, x + 1};
        String userseat = Arrays.toString(array);
        Order order = new Order();
        String payNum = user.getUserId() + "" + System.currentTimeMillis();
        for (int i = 0; i < parseObject.length; i++) {
            if (seatArr[1] == i) {
                if (parseObject[i][seatArr[0]] != 2) {
                    parseObject[i][seatArr[0]] = 2;
                    String newseatinfo = JSON.toJSONString(parseObject);
                    int k = schedulingMapper.updateseat(newseatinfo, schedulingId);
                    order.setOrderNumber(payNum);
                    order.setOrderSchedulingId(schedulingId);
                    order.setOrderMovieId(scheduling.getMovie().getMovieId());
                    order.setOrderFilmId(scheduling.getFilm().getFilmId());
                    order.setOrderSeat(userseat);
                    order.setOrderMoney(scheduling.getSchedulingMoney());
                    order.setPayNum(payNum);
                    order.setOrderUserId(user.getUserId());
                    orderMapper.addOrder(order);
                    return ResponseJson.getOK(payNum);
                }
                return ResponseJson.getError("位置已被占");
            }

        }
        return null;
    }

    public ResponseJson getBuyTicketWxCodeUrl(String payNum) {
        long currentTimeMillis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(currentTimeMillis);
        String orderNumber = payNum;
        int i = orderMapper.updateorderByPayNum(timestamp, payNum, orderNumber);
        if (i > 0) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("body", "购物车结账");
            map.put("out_trade_no", payNum);
            map.put("total_fee", "1");
            map.put("spbill_create_ip", "127.0.0.1");
            map.put("notify_url", "http://pi2frz.natappfree.cc/chwk/user/notify_url");
            map.put("trade_type", "NATIVE");
            try {
                Map<String, String> result = wxPay.unifiedOrder(map);
                String code_url = result.get("code_url");
                result = new HashMap<>();
                result.put("code_url", code_url);
                result.put("payNum", payNum);
                return ResponseJson.getOK(result);
            } catch (Exception e) {
                throw new RuntimeException("微信支付生成失败");
            }
        }
        return ResponseJson.getError("发起微信支付失败");
    }

    public ResponseJson getStateByPayNum(String payNum) {
        int state = orderMapper.getStateByPayNum(payNum);
        return ResponseJson.getOK("支付状态", state);
    }

    public void payd(String xml) throws Exception {
        Map<String, String> xmlToMap = WXPayUtil.xmlToMap(xml);
        if (xmlToMap.get("return_code").equals("SUCCESS") &&
                xmlToMap.get("result_code").equals("SUCCESS")) {
            String out_trade_no = xmlToMap.get("out_trade_no");
            int i = orderMapper.payd(out_trade_no);
            int orderId = orderMapper.getOrderIdByPayNum(out_trade_no);
        }
        System.out.println(xmlToMap);
    }


    public ResponseJson getAllOrderById(HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Order> orderList = orderMapper.getAllOrderByUserId(user.getUserId());
        return ResponseJson.getOK(orderList);
    }

    public ResponseJson refund(String payNum) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        map.put("out_trade_no", payNum);
        map.put("out_refund_no", payNum + "-");
        map.put("refund_fee", "1");
        map.put("total_fee", "1");
        Map<String, String> refund = wxPay.refund(map);
        if (refund.get("return_code").equals("SUCCESS") &&
                refund.get("result_code").equals("SUCCESS")) {
            int i = orderMapper.updateOrderStateByPaynum(payNum);
            return ResponseJson.getOK("退款成功");

        }
        return ResponseJson.getError("退款失败");
    }
}
