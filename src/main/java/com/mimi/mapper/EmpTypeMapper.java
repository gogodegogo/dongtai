package com.mimi.mapper;

import com.mimi.pojo.EmpType;
import com.mimi.pojo.EmpTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmpTypeMapper {
    int countByExample(EmpTypeExample example);

    int deleteByExample(EmpTypeExample example);

    int deleteByPrimaryKey(Integer type);

    int insert(EmpType record);

    int insertSelective(EmpType record);

    List<EmpType> selectByExample(EmpTypeExample example);

    EmpType selectByPrimaryKey(Integer type);

    int updateByExampleSelective(@Param("record") EmpType record, @Param("example") EmpTypeExample example);

    int updateByExample(@Param("record") EmpType record, @Param("example") EmpTypeExample example);

    int updateByPrimaryKeySelective(EmpType record);

    int updateByPrimaryKey(EmpType record);
}