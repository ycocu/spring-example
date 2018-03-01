package com.spring.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("studentService")
public class studentServiceImpl implements studentService{

    @Autowired
    //StudentDAO studentDAO;
    StudentDAOImpl studentDAO;
    
    public void create(String name, Integer age) {
        // TODO Auto-generated method stub
        studentDAO.create(name, age);
    }

    public Student getStudent(Integer id) {
        // TODO Auto-generated method stub
        return studentDAO.getStudent(id);
    }

    public List<Student> listStudents() {
        // TODO Auto-generated method stub
        return studentDAO.listStudents();
    }

    public void delete(Integer id) {
        // TODO Auto-generated method stub
        studentDAO.delete(id);
    }

    public void update(Integer id, Integer age) {
        // TODO Auto-generated method stub
        studentDAO.update(id, age);
    }

}
