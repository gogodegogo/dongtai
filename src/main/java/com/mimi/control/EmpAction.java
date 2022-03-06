package com.mimi.control;

import com.github.pagehelper.PageInfo;
import com.mimi.pojo.Emp;
import com.mimi.pojo.vo.EmpVo;
import com.mimi.service.EmpService;
import com.mimi.service.EmpTypeService;
import com.mimi.utils.FileNameUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/prod")
public class EmpAction {
    String saveFileName = "";

    @Autowired
    EmpService empService;

    @Autowired
    EmpTypeService empTypeService;

    @RequestMapping("/getAll")
    public String getAll(HttpServletRequest request){
        List<Emp> list = empService.all();
        request.setAttribute("list",list);
        return "product";
    }


    //ajax分页
    @ResponseBody
    @RequestMapping("/ajaxfenye")
    public void ajaxfenye(int page, HttpSession session){
        PageInfo info = empService.fenye(page,5);
        session.setAttribute("info",info);
    }

    //异步ajax上传文件
    @ResponseBody
    @RequestMapping("/ajaxTuPian")
    public Object ajaxTuPian(MultipartFile pimage,HttpServletRequest request){
        //提取生成文件名UUID+后缀
        saveFileName = FileNameUtil.getUUIDFileName()+FileNameUtil.getFileType(pimage.getOriginalFilename());
        //得到项目中图片存储路径
        String path = request.getServletContext().getRealPath("/image_big");
        System.out.println(path+File.separator+saveFileName);
        //转存
        try {
            pimage.transferTo(new File(path+File.separator+saveFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject object = new JSONObject();
        object.put("imgurl",saveFileName);
        return object.toString();
    }

    @RequestMapping("/save")
    public String save(Emp emp,HttpServletRequest request){
        emp.setImage(saveFileName);
        emp.setHiredate(new Date());
        int flag = -1;
        try {
           flag = empService.save(emp);
        }catch (Exception e){
            request.setAttribute("msg","添加失败,编号重复");
            return "forward:/prod/fenye.action";
        }
        if(flag > 0){
            request.setAttribute("msg","添加成功");
        }else {
            request.setAttribute("msg","添加失败");
        }
        saveFileName = "";
        return "forward:/prod/fenye.action";
    }

    @RequestMapping("/one")
    public String one(HttpServletRequest request,int empno,EmpVo vo){
        Emp emp = empService.zhaoyige(empno);
        request.setAttribute("emp",emp);
        request.getSession().setAttribute("Empvo",vo);
        return "update";
    }

    @RequestMapping("/update")
    public String update(Emp emp,HttpServletRequest request){
        if(!saveFileName.equals("")) {
            emp.setImage(saveFileName);
        }
        emp.setHiredate(new Date());
        int flag = empService.xiugai(emp);
        saveFileName = "";
        if(flag > 0){
            request.setAttribute("msg","更新成功");
        }else {
            request.setAttribute("msg","更新失败");
        }
        return "forward:/prod/fenye.action";
    }

    //不分页，一页显示
    @RequestMapping("/fenye")
    public String fenye(HttpServletRequest request){
        PageInfo info = null;
        Object vo = request.getSession().getAttribute("Empvo");
        if(vo == null) {
            info = empService.fenye(1, 5);
        }else {
            info = empService.tiaojianchaxun((EmpVo) vo);
        }
        request.setAttribute("info",info);
        return "product";
    }

    @RequestMapping("/delete")
    public String delete(int empno,HttpServletRequest request){
        int flag = empService.delete(empno);
        if(flag > 0){
            request.setAttribute("msg","删除成功");
        }else {
            request.setAttribute("msg","删除失败");
        }
        return "forward:/prod/ajaxdelete.action";
    }

    @ResponseBody
    @RequestMapping(value = "/ajaxdelete",produces = "text/html;charset=UTF-8")
    public Object ajaxdelete(HttpServletRequest request){
        PageInfo info = empService.fenye(1,5);
        request.getSession().setAttribute("info",info);
        return request.getAttribute("msg");
    }

    @RequestMapping("/deletebatch")
    public String deletebatch(String str,HttpServletRequest request){
        str = str.substring(0,str.length()-1);
        int flag = empService.deletebatch(str);
        if(flag > 0){
            request.setAttribute("msg","删除成功");
        }else {
            request.setAttribute("msg","删除失败");
        }
        return "forward:/prod/ajaxdelete.action";
    }

    @ResponseBody
    @RequestMapping("/chaxu")
    public void chaxu(EmpVo vo,HttpServletRequest request){
        PageInfo info  = empService.tiaojianchaxun(vo);
        System.out.println(vo.toString());
        request.getSession().setAttribute("info",info);
    }
}
