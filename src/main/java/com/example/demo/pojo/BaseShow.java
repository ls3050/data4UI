package com.example.demo.pojo;

public class BaseShow {

    /*
    * 展示“销售收入”，“成本”，“费用”和“资产减值损失”等指标
    * （取值都是百分比，按照事业部，项目，客户，供应商，类型等维度）
    * */

    //纬度信息
    String group_division_id;   // 集团事业部编码
    String department_id;       // 部门编码
    String customer_id;         // 客户编码
    String supplier_id;         // 供应商编码
    String type;                // 类型
    String project_id;          // 项目编码

    //1.占比 = 单独 / 总体
    String proportion;
    //2.当月完成情况（百分比）=当月实际情况/当月计划情况
    String cpl_ratio;
    //3.环比
    String ring_ratio;
    //4.年度累计值/年度累计计划值
    String year_cum;
    //5.年度预测1完成情况（百分比）=年度预测值1/年度计划值
    String pred_val1_cpl_ratio;
    //6.年度预测2完成情况（百分比）=年度预测值1/年度计划值
    String pred_val2_cpl_ratio;

    public String getGroup_division_id() {
        return group_division_id;
    }

    public void setGroup_division_id(String group_division_id) {
        this.group_division_id = group_division_id;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getProportion() {
        return proportion;
    }

    public void setProportion(String proportion) {
        this.proportion = proportion;
    }

    public String getCpl_ratio() {
        return cpl_ratio;
    }

    public void setCpl_ratio(String cpl_ratio) {
        this.cpl_ratio = cpl_ratio;
    }

    public String getRing_ratio() {
        return ring_ratio;
    }

    public void setRing_ratio(String ring_ratio) {
        this.ring_ratio = ring_ratio;
    }

    public String getYear_cum() {
        return year_cum;
    }

    public void setYear_cum(String year_cum) {
        this.year_cum = year_cum;
    }

    public String getPred_val1_cpl_ratio() {
        return pred_val1_cpl_ratio;
    }

    public void setPred_val1_cpl_ratio(String pred_val1_cpl_ratio) {
        this.pred_val1_cpl_ratio = pred_val1_cpl_ratio;
    }

    public String getPred_val2_cpl_ratio() {
        return pred_val2_cpl_ratio;
    }

    public void setPred_val2_cpl_ratio(String pred_val2_cpl_ratio) {
        this.pred_val2_cpl_ratio = pred_val2_cpl_ratio;
    }
}
