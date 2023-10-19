package com.example.mark.mapper;

import com.example.mark.bean.PersonalCart;
import com.example.mark.bean.ShoppingCart;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShoppingCartMapper {
    @Results({
            @Result(property = "id",column = "id",id = true),
            @Result(property ="sname" ,column ="s_name" ),
            @Result(property ="sid" ,column ="sid" ),
            @Result(property ="price" ,column ="s_price" ),
    })
    @Select("select o.id,s.id as sid,s_name,s.s_price from shopping s join shoppingCart o on o.sid =s.id where o.uid=#{uid} and o.isAfford=#{isAfford};")
    List<PersonalCart> selectAllByUid(String uid,String isAfford);
    @Insert(" insert into shoppingCart values (#{id},#{uid},#{sid},#{isAfford})")
    int insert(@Param("id") String id, @Param("uid") String uid, @Param("sid") String sid, @Param("isAfford") String isAfford);
    @Delete("delete from shoppingCart where id=#{id}")
    int deleteById(String id);
    @Update("update shoppingCart set isAfford=#{isAfford} where id=#{id}")
    int updateById(@Param("id") String id, @Param("isAfford") String isAfford);
}
