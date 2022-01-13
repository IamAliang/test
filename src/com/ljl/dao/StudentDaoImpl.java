package com.ljl.dao;

import com.ljl.domain.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class StudentDaoImpl implements StudentDao{
    @Override
    public ArrayList<Student> findAll() {
        ArrayList<Student> list=new ArrayList<>();
        Connection con=null;
        Statement sta=null;
        ResultSet rs=null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取数据库连接
            con = DriverManager.getConnection("jdbc:mysql://192.168.20.129:3306/db12", "root", "123456");

            //获取执行者对象
            sta = con.createStatement();

            //执行SQL语句并返回结果集
            String sql="SELECT * FROM student";
            rs = sta.executeQuery(sql);

            //处理结果集
            while (rs.next()){
                Integer sid = rs.getInt("sid");
                String name = rs.getString("name");
                Integer age = rs.getInt("age");
                Date birthday = rs.getDate("birthday");
                Student stu=new Student(sid,name,age,birthday);
                list.add(stu);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (sta!=null){
                try {
                    sta.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    @Override
    public Student findById(Integer id) {
        return null;
    }

    @Override
    public int insert(Student stu) {
        return 0;
    }

    @Override
    public int update(Student stu) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}
