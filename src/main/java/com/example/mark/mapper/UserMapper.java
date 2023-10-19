package com.example.mark.mapper;

import com.example.mark.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    /*
    根据id查找用户
    */
    @Select("select * from user where uid=#{id}")
    User selectById(String id);
    /*
    根据用户名和密码查找用户
     */
    @Select("select * from user where uname=#{uname} and pwd=#{pwd}")
    User selectByUnameAndPwd(String uname,String pwd);
    @Update("update user set uname=#{uname},money=#{money},pwd=#{pwd},isAdmin=#{isAdmin}  where uid=#{uid};")
    int updateById(User user);
    @Insert("insert into user  values (#{uid},#{uname},#{money},#{pwd},#{isAdmin})")
    int insert(User user);
}
