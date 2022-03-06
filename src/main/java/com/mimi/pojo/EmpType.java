package com.mimi.pojo;

public class EmpType {
    private Integer type;

    private String zhiwei;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getZhiwei() {
        return zhiwei;
    }

    public void setZhiwei(String zhiwei) {
        this.zhiwei = zhiwei == null ? null : zhiwei.trim();
    }
}