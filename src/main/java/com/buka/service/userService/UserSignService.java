package com.buka.service.userService;

import com.buka.mapper.UserMapper;
import com.buka.pojo.User;
import com.buka.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSignService {
    @Autowired
    private UserMapper userMapper;

    public ResponseJson userSign(String userName, String userPassword) {
        User user = new User();
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        int i = userMapper.addUser(user);
        if (i>0){
            return ResponseJson.getOK(200,"注册成功");
        }else {
            return ResponseJson.getError(-1,"注册失败");
        }
    }
}
