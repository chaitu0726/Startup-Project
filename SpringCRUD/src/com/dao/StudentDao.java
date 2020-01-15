package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.Student;

@Repository
public class StudentDao {
@Autowired
private	JdbcTemplate template;
public StudentDao(JdbcTemplate template) {
	this.template = template;
}

public StudentDao() {
	super();
}

public void save(Student student)
{
	String sql = "insert into student values("+student.getId()+",'"+student.getName()+"',"+student.getAge()+")";
	System.out.println(sql);
	template.update(sql);//insert,update,delete
}
	
}
