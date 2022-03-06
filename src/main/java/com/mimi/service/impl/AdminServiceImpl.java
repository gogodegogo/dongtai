package com.mimi.service.impl;

import com.mimi.mapper.AdminMapper;
import com.mimi.pojo.Admin;
import com.mimi.pojo.AdminExample;
import com.mimi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin login(String name, String password) {
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andNameEqualTo(name);
        List<Admin> list = adminMapper.selectByExample(adminExample);
        if(list.size() > 0){
            Admin admin = list.get(0);
            if(admin.getPassword().equals(password)){
                return admin;
            }
        }
        return null;
    }
}
