package com.example.demo.pojo.profit;

public class ProfitShow {
    /**
     *（2）利润展示如下指标：
     */

    //1.利润（按照事业部和项目等维度）
    String group_division_id; //集团事业部编码
    String project_id;//项目编码
    String profit;//利润
    String sum_profit;
    String period;//时间（yyyymm）

    public String getGroup_division_id() {
        return group_division_id;
    }

    public void setGroup_division_id(String group_division_id) {
        this.group_division_id = group_division_id;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    public String getSum_profit() {
        return sum_profit;
    }

    public void setSum_profit(String sum_profit) {
        this.sum_profit = sum_profit;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }
}
