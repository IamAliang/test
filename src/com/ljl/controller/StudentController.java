package com.ljl.controller;


import com.ljl.domain.Student;
import com.ljl.service.StudentService;
import com.ljl.service.StudentServiceImpl;
import org.junit.Test;

import java.util.ArrayList;

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
}
