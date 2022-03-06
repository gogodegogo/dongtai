package com.mimi.mapper;

import com.mimi.pojo.Emp;
import com.mimi.pojo.EmpExample;
import java.util.List;

import com.mimi.pojo.vo.EmpVo;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {
    int countByExample(EmpExample example);

    int deleteByExample(EmpExample example);

    int deleteByPrimaryKey(Integer empno);

    int insert(Emp record);

    int insertSelective(Emp record);

    List<Emp> selectByExample(EmpExample example);

    Emp selectByPrimaryKey(Integer empno);

    int updateByExampleSelective(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByExample(@Param("record") Emp record, @Param("example") EmpExample example);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);

    int deletebatch(String[] str);

    List<Emp> tiaojianchaxun(EmpVo vo);
}