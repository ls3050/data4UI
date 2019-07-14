package com.example.demo.controller;

import com.example.demo.mapper.ProfitShowMapper;
import com.example.demo.pojo.*;
import com.example.demo.pojo.profit.ProfitShow;
import com.example.demo.pojo.profit.ProfitShowByGroup;
import com.example.demo.pojo.profit.ProfitSumShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProfitShowController {
    @Autowired
    ProfitShowMapper profitShowMapper;

    //显示两个事业部每个月的数据
    @RequestMapping("/api/v1/listProfitByGroup")
    public ReturnJson listProfitByGroup() throws Exception {
        List<ProfitShowByGroup> showsByGroup = new ArrayList<>();

        showsByGroup.add(new ProfitShowByGroup("事业部1", new ArrayList<>(12)));
        showsByGroup.add(new ProfitShowByGroup("事业部2", new ArrayList<>(12)));

        List<ProfitShow> shows = profitShowMapper.findAllFromProfitByGroup();

        for(ProfitShow profitShow : shows){
            if(profitShow.getGroup_division_id().equals("1"))
                showsByGroup.get(0).getProfits().add(profitShow.getSum_profit());
            else
                showsByGroup.get(1).getProfits().add(profitShow.getSum_profit());
        }


        return new ReturnJson(showsByGroup);
    }

    //显示事业部(group_id)下的两个项目每个月的数据
    @RequestMapping("/api/v1/listProfitByGroupAndProject")
    public ReturnJson listProfitByGroup1(@RequestParam(name = "group_id") String gid) throws Exception {
        List<ProfitShowByGroup> showsByGroup = new ArrayList<>();
        Integer groupID = Integer.valueOf(gid);
        showsByGroup.add(new ProfitShowByGroup("项目" + ((groupID-1)*4+1), new ArrayList<>()));
        showsByGroup.add(new ProfitShowByGroup("项目" + ((groupID-1)*4+2), new ArrayList<>()));
        showsByGroup.add(new ProfitShowByGroup("项目" + ((groupID-1)*4+3), new ArrayList<>()));
        showsByGroup.add(new ProfitShowByGroup("项目" + ((groupID-1)*4+4), new ArrayList<>()));

        List<ProfitShow> shows1 = profitShowMapper.findAllFromProfitByPID("" + ((groupID-1)*4+1));
        List<ProfitShow> shows2 = profitShowMapper.findAllFromProfitByPID("" + ((groupID-1)*4+2));
        List<ProfitShow> shows3 = profitShowMapper.findAllFromProfitByPID("" + ((groupID-1)*4+3));
        List<ProfitShow> shows4 = profitShowMapper.findAllFromProfitByPID("" + ((groupID-1)*4+4));

        for(ProfitShow profitShow : shows1){
            showsByGroup.get(0).getProfits().add(profitShow.getProfit());
        }

        for(ProfitShow profitShow : shows2){
            showsByGroup.get(1).getProfits().add(profitShow.getProfit());
        }

        for(ProfitShow profitShow : shows3){
            showsByGroup.get(2).getProfits().add(profitShow.getProfit());
        }

        for(ProfitShow profitShow : shows4){
            showsByGroup.get(3).getProfits().add(profitShow.getProfit());
        }


        return new ReturnJson(showsByGroup);
    }


    @RequestMapping("/api/v1/listProfitSumByGroup")
    public ReturnJson listProfitSumByGroup() throws Exception {
        List<ProfitSumShow> shows = profitShowMapper.findSumProfitFromProfitByGroup();
        for (ProfitSumShow show:
             shows) {
            show.setGroup_division_id("事业部" + show.getGroup_division_id());
        }
        return new ReturnJson(shows);
    }

    @RequestMapping("/api/v1/listProfitSumByProject")
    public ReturnJson listProfitSumByProject(@RequestParam(name = "group_id") String gid) throws Exception {
        System.out.println(gid);
        List<ProfitSumShow> shows = profitShowMapper.findSumProfitFromProfitByProject(gid);
        for (ProfitSumShow show:
                shows) {
            show.setGroup_division_id("项目" + show.getGroup_division_id());
        }
        return new ReturnJson(shows);
    }

}
