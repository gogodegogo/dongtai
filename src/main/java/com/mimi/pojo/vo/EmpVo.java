package com.mimi.pojo.vo;

public class EmpVo {
    private String ename;
    private Integer typeid;
    private Integer minmoney;
    private Integer maxmoney;
    private Integer page = 1;

    @Override
    public String toString() {
        return "EmpVo{" +
                "ename='" + ename + '\'' +
                ", typeid=" + typeid +
                ", minmoney=" + minmoney +
                ", maxmoney=" + maxmoney +
                ", page=" + page +
                '}';
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public Integer getMinmoney() {
        return minmoney;
    }

    public void setMinmoney(Integer minmoney) {
        this.minmoney = minmoney;
    }

    public Integer getMaxmoney() {
        return maxmoney;
    }

    public void setMaxmoney(Integer maxmoney) {
        this.maxmoney = maxmoney;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public EmpVo(String ename, Integer typeid, Integer minmoney, Integer maxmoney, Integer page) {
        this.ename = ename;
        this.typeid = typeid;
        this.minmoney = minmoney;
        this.maxmoney = maxmoney;
        this.page = page;
    }

    public EmpVo() {
    }
}
