package com.funcode.example.chapter8.mapper;

import com.funcode.example.chapter8.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("SELECT * FROM USER")
    @Results({
            @Result(property = "nickName", column = "nick_name")
    })
    List<User> selectAll();


    @Insert("INSERT INTO USER(nick_name, age) VALUES(#{nickName}, #{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);
}
