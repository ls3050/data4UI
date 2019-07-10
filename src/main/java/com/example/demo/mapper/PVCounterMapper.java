package com.example.demo.mapper;

import com.example.demo.pojo.PVCounter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


import java.util.List;

@Mapper
public interface PVCounterMapper {

    @Select("select * from demo ")
    List<PVCounter> findAll();

    @Select("select * from demo where userid = #{id}")
    PVCounter findById(String id);
}
