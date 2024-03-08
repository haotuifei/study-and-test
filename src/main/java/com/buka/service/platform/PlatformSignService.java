package com.buka.service.platform;

import com.buka.mapper.PlatformMapper;
import com.buka.pojo.Platform;
import com.buka.util.ResponseJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatformSignService {
    @Autowired
    private PlatformMapper platformMapper;

    public ResponseJson platformSign(String platformName, String platformPassword) {
        if (platformName == null || platformPassword == null) {
            return ResponseJson.getError(-1, "注册失败");
        }
        Platform platform = new Platform();
        platform.setPlatformName(platformName);
        platform.setPlatformPassword(platformPassword);
        int i = platformMapper.addPlatform(platform);
        if (i > 0) {
            return ResponseJson.getOK(200, "注册成功");
        } else {
            return ResponseJson.getError(-1, "注册失败");
        }
    }
}

