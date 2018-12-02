package com.jung.sql;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 *   to mybatis²Ù×÷
 *   1.InputStream
 *   2.SqlSessionFacory
 *   3.SqlSesison
 * @author jung
 *
 */
public class SqlSessionFactoryUtils {
    private static String RESOURCE="com/jung/sql/mybatis-config.xml";
    private static SqlSessionFactory sqlSessionFactory;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();

    public static void initSqlSessionFacotry(){
        try {
            InputStream  is = Resources.getResourceAsStream(RESOURCE);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
    public static void close(){
        SqlSession session  =threadLocal.get();
        if(session!=null){
            session.close();
            threadLocal.set(null);
        }
    }
}
