package com.example.demo.mapper;

import com.example.demo.pojo.BaseShow;
import com.example.demo.pojo.base.AllShow;
import com.example.demo.pojo.base.CompleteShow;
import com.example.demo.pojo.base.ProportionShow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BaseShowMapper {

    // 查询集团下各事业部的总数据
    @Select("select group_division_id, sum(${valueName}) as sum_val " +
            "from ${tableName} " +
            "group by group_division_id")
    List<AllShow> findAllSumFromTable(@Param(value = "tableName") String tableName,
                                      @Param(value = "valueName") String valueName);


    //查询项目下各类型的占比
    @Select("select group_division_id, project_id, ${valueType} as value_type, sum(${valueName}) as sum_val " +
            "from ${tableName} " +
            "group by group_division_id, project_id, ${valueType} " +
            "having project_id = ${pid}")
    List<ProportionShow> findSumFromTableByProject(@Param(value = "tableName") String tableName,
                                                   @Param(value = "valueType") String valueType,
                                                   @Param(value = "valueName") String valueName,
                                                   @Param(value = "pid") int pid);

    //查询事业部下的各项目的占比
    @Select("select group_division_id, project_id, sum(${valueName}) as sum_val " +
            "from ${tableName} " +
            "group by group_division_id, project_id " +
            "having group_division_id = ${gid}")
    List<ProportionShow> findSumFromTableByGroup(@Param(value = "tableName") String tableName,
                                                   @Param(value = "valueName") String valueName,
                                                   @Param(value = "gid") int gid);

    //查询完成情况
    @Select("select group_division_id, project_id, ${valueName} as sum_val " +
            "from ${tableName} " +
            "where project_id = ${pid} and ${valueType} = 2 " +
            "order by project_id, period, ${valueType} ")
    List<ProportionShow> findAllFromTableByProject(@Param(value = "tableName") String tableName,
                                                   @Param(value = "valueType") String valueType,
                                                   @Param(value = "valueName") String valueName,
                                                   @Param(value = "pid") int pid);

}
