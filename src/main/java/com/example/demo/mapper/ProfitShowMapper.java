package com.example.demo.mapper;

import com.example.demo.pojo.profit.ProfitShow;
import com.example.demo.pojo.profit.ProfitSumShow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProfitShowMapper {

    @Select("select period, " +
            "group_division_id, " +
            "left(sum(profit),5) as sum_profit " +
            "from poc_finance_profit " +
            "group by period, group_division_id ")
    List<ProfitShow> findAllFromProfitByGroup();

    @Select("select group_division_id, project_id, left(profit,5) * 1000 as profit, period " +
            "from poc_finance_profit " +
            "where project_id = #{pid}")
    List<ProfitShow> findAllFromProfitByPID(String pid);


    @Select("select group_division_id, sum(profit) as sum_profit from poc_finance_profit group by group_division_id")
    List<ProfitSumShow> findSumProfitFromProfitByGroup();

    @Select("select project_id as group_division_id, sum(profit) as sum_profit " +
            "from poc_finance_profit " +
            "group by group_division_id, project_id " +
            "having group_division_id = #{gid}")
    List<ProfitSumShow> findSumProfitFromProfitByProject(String gid);
}
