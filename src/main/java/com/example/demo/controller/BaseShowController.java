package com.example.demo.controller;

import com.example.demo.mapper.BaseShowMapper;
import com.example.demo.pojo.ReturnJson;
import com.example.demo.pojo.base.AllShow;
import com.example.demo.pojo.base.AllShow2;
import com.example.demo.pojo.base.CompleteShow;
import com.example.demo.pojo.base.ProportionShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BaseShowController {

    @Autowired
    BaseShowMapper baseShowMapper;

    // 查询集团总值及集团下各事业部的总值
    @RequestMapping("/api/v1/listAllSumFromTable")
    public ReturnJson listAllSumFromTable(@RequestParam(name = "tableName") String tableName,
                                          @RequestParam(name = "valueName") String valueName) throws Exception {
        List<AllShow> shows = baseShowMapper.findAllSumFromTable(tableName, valueName);

        AllShow2 as2 = new AllShow2();
        as2.setList(new ArrayList<>());

        Double sum = 0.0;

        for (AllShow as : shows
             ) {
            Double val = Double.valueOf(as.getSum_val());
            sum += val;
            as.setGroup_division_id("事业部" + as.getGroup_division_id());
            as2.getList().add(as);
        }

        as2.setSum(sum.toString());
        as2.setId(tableName);
        return new ReturnJson(as2);
    }



    // 查询项目（pid）下的各个类型占比
    @RequestMapping("/api/v1/listProjectProportionByGroup")
    public ReturnJson listProjectProportionByGroup(@RequestParam(name = "tableName") String tableName,
                                                   @RequestParam(name = "valueName") String valueName,
                                                   @RequestParam(name = "valueType") String valueType,
                                                   @RequestParam(name = "pid") int pid) throws Exception {

        List<ProportionShow> shows = baseShowMapper.findSumFromTableByProject(tableName,
                                                                        valueType,
                                                                        valueName,
                                                                        pid);
        for (ProportionShow show : shows) {
            show.setProject_id(show.getProject_id());
            if( tableName.equals("poc_finance_cost"))
                show.setValue_type(show.getValue_type().equals("1") ? "生产人工成本" : "其他成本");
        }
        return new ReturnJson(shows);
    }

    // 查询事业部（gid）下的各个项目占比
    @RequestMapping("/api/v1/listProjectProportionByProject")
    public ReturnJson listProjectProportionByProject(@RequestParam(name = "tableName") String tableName,
                                                   @RequestParam(name = "valueName") String valueName,
                                                   @RequestParam(name = "gid") int gid) throws Exception {

        List<ProportionShow> shows = baseShowMapper.findSumFromTableByGroup(tableName,
                valueName,
                gid);

        for (ProportionShow show : shows) {
            show.setProject_id("项目" + show.getProject_id());
        }

        return new ReturnJson(shows);
    }

    // 查询事业部(gid)下各个项目当月完成情况/比率
    @RequestMapping("/api/v1/listCompleteByProject")
    public ReturnJson listCompleteByProject(@RequestParam(name = "tableName") String tableName,
                                            @RequestParam(name = "valueType") String valueType,
                                            @RequestParam(name = "valueName") String valueName,
                                            @RequestParam(name = "gid") int gid) throws Exception {
        List<CompleteShow> shows = new ArrayList<>();
        for (int i = 1; i <= 4; i++) {
            int pid = ( gid - 1 ) * 4 + i;
            List<ProportionShow> showsi = baseShowMapper.findAllFromTableByProject(tableName,
                    valueType,
                    valueName,
                    pid);
            CompleteShow csi = new CompleteShow();
            csi.setProject_id("项目" + pid);
            csi.setVals(new ArrayList<>());
            for (ProportionShow show : showsi
                 ) {
                csi.getVals().add(show.getSum_val());
            }
            shows.add(csi);
        }

        return new ReturnJson(shows);
    }


}
