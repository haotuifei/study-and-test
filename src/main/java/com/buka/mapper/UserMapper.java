package com.buka.mapper;

import com.buka.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from t_user where user_name = #{userName}")
    User selectUserByUserName(String userName);

    @Insert("insert into t_user values(null,#{userName},#{userPassword},null)")
    int addUser(User user);

    @Select("select * from t_user")
    List<User> getAllUser();

    @Update("update t_user set user_state = 1 where user_id = #{userId}")
    int changeUserStateByUserId(int userId);

    @Update("update t_user set user_state = 0 where user_id = #{userId}")
    int unblockingUserByUserId(int userId);

}
