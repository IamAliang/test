package com.ljl.utils;

import com.mysql.jdbc.Driver;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    //私有构造
    private JDBCUtils(){}

    //静态变量
    private  static String driverClass;
    private  static String url;
    private  static String root;
    private  static String password;
    private  static Connection con;


    //提供静态代码块，读取配置文件的信息并为变量赋值，注册驱动
    static {
        //读取配置文件的信息

        try{
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("config.properties");

            Properties pro=new Properties();
            pro.load(is);
            driverClass = pro.getProperty("driverClass");
            url = pro.getProperty("url");
            root = pro.getProperty("username");
            password = pro.getProperty("password");
            //注册驱动
            Class.forName(driverClass);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //提供获取数据库连接方法
    public static Connection  getConnection(){

        try{
            con=DriverManager.getConnection(url,root,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
    //释放资源
    public static void close(Connection con, Statement sta, ResultSet rt){
        if (con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (sta != null){
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rt != null){
            try {
                rt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection con, Statement sta){
        if (con != null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (sta != null){
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }



}
