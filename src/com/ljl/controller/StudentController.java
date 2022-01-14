package com.ljl.controller;


import com.ljl.domain.Student;
import com.ljl.service.StudentService;
import com.ljl.service.StudentServiceImpl;
import org.junit.Test;
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

    @Test
    public void update(){

        Student stu=new Student(2,"李四四",36,new Date());
        int result = s.update(stu);
        if (result!=0){
            System.out.println("修改成功");
        }else
            System.out.println("修改失败");

    }
    @Test
    public  void delete(){
        int sid=5;
        int result = s.delete(sid);

        if (result!=0){
            System.out.println("删除成功");
        }else
            System.out.println("删除失败");

    }

}
