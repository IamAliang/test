package com.ljl.dao;

import com.ljl.domain.Student;
import com.ljl.utils.JDBCUtils;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@SuppressWarnings(value = "all")
public class StudentDaoImpl implements StudentDao {
    @Override
    public ArrayList<Student> findAll() {
        ArrayList<Student> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JDBCUtils.getConnection();

            //获取执行者对象

            String sql = "SELECT * FROM student";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            //处理结果集
            while (rs.next()) {
                Integer sid = rs.getInt("sid");
                String name = rs.getString("name");
                Integer age = rs.getInt("age");
                Date birthday = rs.getDate("birthday");
                Student stu = new Student(sid, name, age, birthday);
                list.add(stu);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, ps, rs);
        }
        return list;
    }

    @Override
    public Student findById(Integer id) {
        Student stu = new Student();
        Connection con = null;
        PreparedStatement sta = null;
        ResultSet rs = null;
        try {
            //注册驱动

            //获取数据库连接
            con = JDBCUtils.getConnection();
            String sql = "SELECT * FROM student WHERE sid=?";
            sta = con.prepareStatement(sql);
            sta.setInt(1, id);
            rs = sta.executeQuery();
            //处理结果集
            while (rs.next()) {
                Integer sid = rs.getInt("sid");
                String name = rs.getString("name");
                Integer age = rs.getInt("age");
                Date birthday = rs.getDate("birthday");

                stu.setName(name);
                stu.setSid(sid);
                stu.setAge(age);
                stu.setBirthday(birthday);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, sta, rs);

        }
        return stu;
    }

    @Override
    public int insert(Student stu) {
        int result = 0;
        Connection con = null;
        PreparedStatement ps=null;


        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取数据库连接
            con = DriverManager.getConnection("jdbc:mysql://192.168.20.129:3306/db12", "root", "123456");


            Date d = stu.getBirthday();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String birthday = sdf.format(d);
            String sql = "INSERT INTO student VALUES (?,?,?,?)";
            ps= con.prepareStatement(sql);
            ps.setInt(1, stu.getSid());
            ps.setString(2, stu.getName());
            ps.setInt(3, stu.getAge());
            ps.setString(4, birthday);
            result = ps.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, ps);



        }
        return result;
    }

    @Override
    public int update(Student stu) {
        int result = 0;
        Connection con = null;
        PreparedStatement ps=null;
        try {
            con = JDBCUtils.getConnection();

            Date date = stu.getBirthday();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String birthday = sdf.format(date);
            String sql = "UPDATE student SET  name=?,age=?,birthday=? WHERE sid=?";
             ps = con.prepareStatement(sql);
             ps.setString(1, stu.getName());
             ps.setInt(2, stu.getAge());
             ps.setString(3, birthday);
             ps.setInt(4, stu.getSid());
            result = ps.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, ps);
        }


        return result;
    }

    @Override
    public int delete(Integer id) {
        int result = 0;
        Connection con = null;
        PreparedStatement ps=null;

        try {
            con = JDBCUtils.getConnection();


            String sql = "DELETE FROM student WHERE sid=?";
             ps= con.prepareStatement(sql);
             ps.setInt(1,id);
             result = ps.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(con, ps);
        }
        return result;


    }
}
