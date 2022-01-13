package com.ljl.service;

import com.ljl.domain.Student;

import java.util.ArrayList;

public interface StudentService {
    //查询所有学生信息
    ArrayList<Student> findAll();

    //根据id查询获取学生信息
    Student findById(Integer id);

    //新增学生信息
    int insert(Student stu);

    //更新学生信息
    int update(Student stu);

    //删除
    int delete(Integer id);

}
