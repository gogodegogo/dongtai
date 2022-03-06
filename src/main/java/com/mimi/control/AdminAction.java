package com.mimi.control;

import com.mimi.pojo.Admin;
import com.mimi.service.AdminService;
import com.mimi.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminAction {
    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    public String login(String name, String pwd, HttpServletRequest request){
        Admin admin = adminService.login(name,pwd);
        if(admin != null){
            return "main";
        }else {
            request.setAttribute("errmsg","登入失败");
            return "login";
        }
    }
}
