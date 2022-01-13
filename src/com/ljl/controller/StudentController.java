package com.ljl.controller;


import com.ljl.domain.Student;
import com.ljl.service.StudentService;
import com.ljl.service.StudentServiceImpl;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@SuppressWarnings(value = "all")
public class StudentController {
    private StudentService s=new StudentServiceImpl();
    @Test
    public void findAll(){
        ArrayList<Student> list = s.findAll();
        for (Student stu:list){
            System.out.println(stu.toString());
        }
    }
    @Test
    public void findById(){
        Student stu = s.findById(2);
        System.out.println(stu);
    }
    @Test
    public void insert(){

        Student student=new Student(5,"枸七",24,new Date());
        int result = s.insert(student);
        if (result!=0){
            System.out.println("添加成功");
        }else
            System.out.println("添加失败");

    }
}
