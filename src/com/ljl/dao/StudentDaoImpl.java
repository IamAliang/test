package com.ljl.dao;

import com.ljl.domain.Student;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.SimpleFormatter;

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
         Student stu=new Student();
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
            String sql="SELECT * FROM student WHERE sid='"+id+"'";
            rs = sta.executeQuery(sql);

            //处理结果集
            while (rs.next()){
                Integer sid = rs.getInt("sid");
                String name = rs.getString("name");
                Integer age = rs.getInt("age");
                Date birthday = rs.getDate("birthday");

               stu.setName(name);
               stu.setSid(sid);
                stu.setAge(age);
                stu.setBirthday(birthday);
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
        return stu;
    }

    @Override
    public int insert(Student stu) {
        int result=0;
        Connection con=null;
        Statement sta=null;

        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取数据库连接
            con = DriverManager.getConnection("jdbc:mysql://192.168.20.129:3306/db12", "root", "123456");

            //获取执行者对象
            sta = con.createStatement();
            //
            Date d = stu.getBirthday();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String birthday = sdf.format(d);
            String sql="INSERT INTO student VALUES ('"+stu.getSid()+"','"+stu.getName()+"','"+stu.getAge()+"','"+birthday+"')";

            result = sta.executeUpdate(sql);


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

        }
        return result;
    }

    @Override
    public int update(Student stu) {
       int result=0;
        Connection connection=null;
        Statement sta=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://192.168.20.129:3306/db12", "root", "123456");
             sta = connection.createStatement();
            Date date = stu.getBirthday();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String birthday = sdf.format(date);
            String sql="UPDATE student SET  name='"+stu.getName()+"',age='"+stu.getAge()+"',birthday='"+birthday+"' WHERE sid='"+stu.getSid()+"'";

           result= sta.executeUpdate(sql);


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (connection!=null){
                try {
                    connection.close();
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
        }


        return result;
    }

    @Override
    public int delete(Integer id) {
        int result=0;
        Connection connection=null;
        Statement sta=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.20.129:3306/db12", "root", "123456");
            sta = connection.createStatement();

            String sql="DELETE FROM student WHERE sid='"+id+"'";

            result= sta.executeUpdate(sql);


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (connection!=null){
                try {
                    connection.close();
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
        }
        return result;






    }
}
