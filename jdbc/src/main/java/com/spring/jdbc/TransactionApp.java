package com.spring.jdbc;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionApp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        StudentJDBCTemplateTransaction studentJDBCTemplateTransaction = (StudentJDBCTemplateTransaction) context
                .getBean("studentJDBCTemplateTransaction");
        System.out.println("------Records creation--------");
        studentJDBCTemplateTransaction.create("Zara", 11, 99, 2010);
        studentJDBCTemplateTransaction.create("Nuha", 20, 97, 2010);
        studentJDBCTemplateTransaction.create("Ayan", 25, 100, 2011);
        System.out.println("------Listing all the records--------");
        List<StudentMarks> studentMarks = studentJDBCTemplateTransaction.listStudents();
        for (StudentMarks record : studentMarks) {
            System.out.print("ID : " + record.getId());
            System.out.print(", Name : " + record.getName());
            System.out.print(", Marks : " + record.getMarks());
            System.out.print(", Year : " + record.getYear());
            System.out.println(", Age : " + record.getAge());
        }
    }

}
