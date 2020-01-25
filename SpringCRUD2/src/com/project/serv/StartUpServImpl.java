package com.project.serv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.project.model.Project;
import com.project.model.StartUp;
import com.project.dao.StartUpDao;
import com.project.serv.StartUpService;

@Service
public class StartUpServImpl implements StartUpService {

	@Autowired
	JdbcTemplate jt;
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Autowired
	private StartUpDao startUpDao;
	
	
	public StartUpServImpl() {
		super();
		
	}
	
	public void setStartUpDao(StartUpDao startUpDao) {
		this.startUpDao = startUpDao;
	}


	@Override
	public boolean add(StartUp startup) {
		
		return startUpDao.add(startup);
	}

	@Override
	public StartUp selectByEmail(String email) {
		
		return startUpDao.selectByEmail(email);
	}

	@Override
	public List<Project> selectAll() {
		return startUpDao.selectAll();
	}

	@Override
	public boolean isUsernameExist(String username) {
		String sql = "select count(username) from login where username = ?";
		Integer count = jt.queryForObject(sql,new Object[] {username}, Integer.class);
		if(count == 1)
			return true;
		else
			return false;
	}

}
