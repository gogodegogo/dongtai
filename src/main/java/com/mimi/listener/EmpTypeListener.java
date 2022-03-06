package com.mimi.listener;

import com.mimi.pojo.EmpType;
import com.mimi.service.EmpTypeService;
import com.mimi.service.impl.EmpTypeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class EmpTypeListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-*.xml");
        EmpTypeService empTypeService = (EmpTypeService) context.getBean("EmpTypeServiceImpl");
        List<EmpType> Tpyelist = empTypeService.getType();
        servletContextEvent.getServletContext().setAttribute("Tpyelist",Tpyelist);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
