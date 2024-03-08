package com.buka.controller.userController;

import com.buka.service.userService.UserLoginService;
import com.buka.service.userService.UserService;
import com.buka.service.userService.UserSignService;
import com.buka.util.ResponseJson;
import com.github.wxpay.sdk.WXPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserLoginService userLoginService;

    @Autowired
    private UserSignService userSignService;

    @Autowired
    private UserService userService;

    @RequestMapping("/userLogin")
    @ResponseBody
    public ResponseJson login(String userName, String userPassword, HttpSession httpSession) {
        return userLoginService.userLogin(userName, userPassword, httpSession);
    }

    @RequestMapping("/userSign")
    @ResponseBody
    public ResponseJson sign(String userName, String userPassword) {
        return userSignService.userSign(userName, userPassword);
    }

    @RequestMapping("/getallfilm")
    @ResponseBody
    public ResponseJson getallfilm() {
        return userService.getallfilm();
    }

    @RequestMapping("/buytickets")
    @ResponseBody
    public ResponseJson buytickets(int filmId) {
        return userService.buytickets(filmId);
    }

    @RequestMapping("/selectUser")
    @ResponseBody
    public ResponseJson getAllUser(){
        return userService.getAllUser();
    }

    @RequestMapping("/banuser")
    @ResponseBody
    public ResponseJson banUser(int userId){
        return userService.banUserByUserId(userId);
    }

    @RequestMapping("/unblockinguser")
    @ResponseBody
    public ResponseJson unblockingUserByUserId(int userId){
        return userService.unblockingUserByUserId(userId);
    }

    @RequestMapping("/getschebyid")
    @ResponseBody
    public ResponseJson getScheById(int schedulingId){
        return userService.getScheById(schedulingId);
    }

    @RequestMapping("/getseatinfobyscheid")
    @ResponseBody
    public ResponseJson getSeatInfoByScheId(int schedulingId){
        return userService.getSeatInfoByScheId(schedulingId);
    }

    @RequestMapping("/selseat")
    @ResponseBody
    public ResponseJson selSeat(int x,int y,Integer schedulingId,HttpSession session){
        return userService.selSeat(x,y,schedulingId,session);
    }

    @RequestMapping("/buyticketwxcodeurl")
    @ResponseBody
    public ResponseJson getBuyTicketWxCodeUrl(String payNum){
       return userService.getBuyTicketWxCodeUrl(payNum);
    }



    @RequestMapping("/getstatebypaynum")
    @ResponseBody
    public ResponseJson getStateByPayNum(String payNum){
        return userService.getStateByPayNum(payNum);
    }

    @PostMapping("/notify_url")
    public String notifyUrl(@RequestBody String xml) throws Exception {
        userService.payd(xml);

        return "<xml>\n" +
                "  <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "  <return_msg><![CDATA[OK]]></return_msg>\n" +
                "</xml>";
    }

    @RequestMapping("/getAllOrderById")
    @ResponseBody
    public ResponseJson getAllOrderById(HttpSession session){
        return userService.getAllOrderById(session);
    }

    @RequestMapping("/refund")
    @ResponseBody
    public ResponseJson refund(String payNum) throws Exception {
       return userService.refund(payNum);
    }
}
