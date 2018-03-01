package com.spring.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class StudentJDBCTemplateATransaction implements StudentTransactionDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    private PlatformTransactionManager transactionManager;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    
    @Transactional
    public void create(String name, Integer age, Integer marks, Integer year) {
        
        String SQL1 = "insert into Student (name, age) values (?, ?)";
        jdbcTemplateObject.update(SQL1, name, age);
        // Get the latest student id to be used in Marks table
        try {
            Thread.sleep(1000*10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String SQL2 = "select max(id) from Student";
        int sid = jdbcTemplateObject.queryForInt(SQL2);
        String SQL3 = "insert into Marks(sid, marks, year) " + "values (?, ?, ?)";
        jdbcTemplateObject.update(SQL3, sid, marks, year);
        System.out.println("Created Name = " + name + ", Age = " + age);
        return;
    }

    public List<StudentMarks> listStudents() {
        String SQL = "select * from Student, Marks where Student.id=Marks.sid";
        List<StudentMarks> studentMarks = jdbcTemplateObject.query(SQL, new StudentMarksMapper());
        return studentMarks;
    }

}
