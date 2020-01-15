package com.serv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Student;
import com.dao.StudentDao;

@Service
public class StudentService {
	@Autowired
	private StudentDao stdDao;
	
	public void createUser(Student student)
	{
		stdDao.save(student);
	}

}
