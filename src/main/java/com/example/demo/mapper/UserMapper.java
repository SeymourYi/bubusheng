package com.example.demo.mapper;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user WHERE username = #{username}")
    User findByUserName(String username);

    @Insert("INSERT INTO user (username, password, create_time, update_time) " +
            "VALUES (#{username}, #{password}, NOW(), NOW())")
    void add(String username, String password);
@Update("update user set nickname=#{nickname},email=#{email} where id=#{id}")
    void update(User user);
    @Update("update user set user_pic=#{avatarUrl},update_time=NOW() where id=#{id}")

    void updateAvatar(String avatarUrl, Integer id);
    @Update("update user set password=#{md5String},update_time=NOW() where id=#{id}")

    void updatePwd(String md5String, Integer id);
}
