package com.example.demo.pojo.profit;

import java.util.List;

public class ProfitShowByGroup {
    String group_division_id; //集团事业部编码
    List<String> profits;//12个月的利润

    public ProfitShowByGroup(String group_division_id, List<String> profits) {
        this.group_division_id = group_division_id;
        this.profits = profits;
    }

    public String getGroup_division_id() {
        return group_division_id;
    }

    public void setGroup_division_id(String group_division_id) {
        this.group_division_id = group_division_id;
    }

    public List<String> getProfits() {
        return profits;
    }

    public void setProfits(List<String> profits) {
        this.profits = profits;
    }

}
