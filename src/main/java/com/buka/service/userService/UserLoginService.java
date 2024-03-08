package com.buka.service.userService;

import com.buka.mapper.UserMapper;
import com.buka.pojo.User;
import com.buka.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserLoginService {
    @Autowired
    private UserMapper userMapper;

    public ResponseJson userLogin(String userName, String userPassword, HttpSession httpSession) {
        User user = userMapper.selectUserByUserName(userName);
        if (user != null && userPassword.equals(user.getUserPassword())) {
            httpSession.setAttribute("user", user);
            return ResponseJson.getOK(200, "登录成功");
        } else {
            return ResponseJson.getError(-1, "用户名或密码错误");
        }

    }


}
