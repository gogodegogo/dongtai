package com.mimi.service.impl;

import com.mimi.mapper.EmpTypeMapper;
import com.mimi.pojo.EmpType;
import com.mimi.pojo.EmpTypeExample;
import com.mimi.service.EmpTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("EmpTypeServiceImpl")
public class EmpTypeServiceImpl implements EmpTypeService {

    @Autowired
    EmpTypeMapper emptypeMapper;
    @Override
    public List<EmpType> getType() {
        List<EmpType> list = emptypeMapper.selectByExample(new EmpTypeExample());
        return list;
    }
}
