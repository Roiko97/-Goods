package com.jung.sql;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *  ������������ʱ��ע��Session����
 * @author jung
 *
 */
@WebListener
public class InitSqlSessionListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	SqlSessionFactoryUtils.close();
    }

    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	SqlSessionFactoryUtils.initSqlSessionFacotry();
    }
	
}
