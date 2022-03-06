package com.mimi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mimi.mapper.EmpMapper;
import com.mimi.pojo.Emp;
import com.mimi.pojo.EmpExample;
import com.mimi.pojo.vo.EmpVo;
import com.mimi.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;

    @Override
    public List<Emp> all() {
        List<Emp> list = empMapper.selectByExample(new EmpExample());
        return list;
    }

    @Override
    public PageInfo fenye(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        EmpExample empExample = new EmpExample();
        empExample.setOrderByClause("empno desc");
        List<Emp> list = empMapper.selectByExample(empExample);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public Emp zhaoyige(int empno) {
        EmpExample empExample = new EmpExample();
        empExample.createCriteria().andEmpnoEqualTo(empno);
        List<Emp> emp = empMapper.selectByExample(empExample);
        return emp.get(0);
    }

    @Override
    public int xiugai(Emp emp) {
        int flag = empMapper.updateByPrimaryKey(emp);
        return flag;
    }

    @Override
    public int save(Emp emp) {
        int falg = empMapper.insert(emp);
        return falg;
    }

    @Override
    public int delete(int empno) {
        EmpExample empExample = new EmpExample();
        empExample.createCriteria().andEmpnoEqualTo(empno);
        int flag = empMapper.deleteByExample(empExample);
        return flag;
    }

    @Override
    public int deletebatch(String str) {
        int flag = empMapper.deletebatch(str.split(","));
        return flag;
    }

    @Override
    public PageInfo<Emp> tiaojianchaxun(EmpVo vo) {
        if(vo.getMaxmoney() == null){
            vo.setMaxmoney(Integer.MAX_VALUE);
        }
        if(vo.getMinmoney() == null) {
            vo.setMinmoney(0);
        }
        PageHelper.startPage(vo.getPage(),5);
        List<Emp> list = empMapper.tiaojianchaxun(vo);
        PageInfo<Emp> info = new PageInfo<>(list);
        return info;
    }
}
