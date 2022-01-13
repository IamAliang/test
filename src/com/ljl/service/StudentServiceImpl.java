package com.ljl.service;

import com.ljl.dao.StudentDao;
import com.ljl.dao.StudentDaoImpl;
import com.ljl.domain.Student;

import java.util.ArrayList;

public class StudentServiceImpl implements StudentService{
    private StudentDao dao=new StudentDaoImpl();
    @Override
    public ArrayList<Student> findAll() {
        return dao.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return dao.findById(id);
    }

    @Override
    public int insert(Student stu) {
        return dao.insert(stu);
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
