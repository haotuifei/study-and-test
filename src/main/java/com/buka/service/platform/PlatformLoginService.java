package com.buka.service.platform;

import com.buka.mapper.PlatformMapper;
import com.buka.pojo.Platform;
import com.buka.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.security.interfaces.RSAKey;

@Service
public class PlatformLoginService {
    @Autowired
    private PlatformMapper platformMapper;

    public ResponseJson platformLogin(String platformName, String platformPassword, HttpSession httpSession) {
        Platform platform = platformMapper.selectplatformByPlatformName(platformName);
        if (platform != null && platformPassword.equals(platform.getPlatformPassword())) {
            httpSession.setAttribute("platform", platform);
            return ResponseJson.getOK(200, "登录成功");
        } else {
            return ResponseJson.getError(-1, "用户名或密码错误");
        }
    }
}
