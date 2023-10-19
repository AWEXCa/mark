package com.example.mark.mapper;

import com.example.mark.bean.Shopping;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ShoppingMapper {
    @Results(id="shopping",value = {
            @Result(property = "id",column = "id",id = true),
            @Result(property = "sname",column = "s_name"),
            @Result(property = "price",column = "s_price"),
    })
    @Select("select *from shopping")
    List<Shopping> selectAll();
    @ResultMap(value = "shopping")
    @Select("select * from shopping where id=#{sid}")
    Shopping selectById(String sid);
    @Update("update shopping set s_name=#{sname},s_price=#{price} where id=#{id} ;")
    int updateById(Shopping shopping);
    @Insert("insert into shopping values (#{id},#{sname},#{price})")
    int insert(Shopping shopping);
}
