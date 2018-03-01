package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ConfigApp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        studentService studentJDBCTemplate = (studentService) context.getBean("studentService");
        //StudentDAOImpl studentJDBCTemplate = (StudentDAOImpl) context.getBean("studentDAOImplxx");
        //StudentDAOImpl studentJDBCTemplate = (StudentDAOImpl) context.getBean(StudentDAOImpl.class);
        System.out.println("------Records Creation--------");
        studentJDBCTemplate.create("Zara", 11);
        studentJDBCTemplate.create("Nuha", 2);
        studentJDBCTemplate.create("Ayan", 15);
        System.out.println("------Listing Multiple Records--------");
        List<Student> students = studentJDBCTemplate.listStudents();
        for (Student record : students) {
            System.out.print("ID : " + record.getId());
            System.out.print(", Name : " + record.getName());
            System.out.println(", Age : " + record.getAge());
        }
        System.out.println("----Updating Record with ID = 2 -----");
        studentJDBCTemplate.update(2, 20);
        System.out.println("----Listing Record with ID = 2 -----");
        Student student = studentJDBCTemplate.getStudent(2);
        System.out.print("ID : " + student.getId());
        System.out.print(", Name : " + student.getName());
        System.out.println(", Age : " + student.getAge());
    }

}
