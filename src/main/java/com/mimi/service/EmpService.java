package com.mimi.service;

import com.github.pagehelper.PageInfo;
import com.mimi.pojo.Emp;
import com.mimi.pojo.vo.EmpVo;

import java.util.List;

public interface EmpService {
    List<Emp> all();

    PageInfo fenye(int pageNum,int pageSize);
    
    Emp zhaoyige(int empno);

    int xiugai(Emp emp);

    int save(Emp emp);

    int delete(int empno);

    int deletebatch(String str);

    PageInfo<Emp> tiaojianchaxun(EmpVo vo);
}
