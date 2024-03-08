package com.buka.mapper;

import com.buka.pojo.Platform;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PlatformMapper {
    @Select("select * from t_platform where platform_name = #{platformName}")
    Platform selectplatformByPlatformName(String platformName);

    @Insert("insert into t_platform values(null,#{platformName},#{platformPassword})")
    int addPlatform(Platform platform);
}
