package com.project.servimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bean.StartUp;
import com.project.dao.StartUpDao;
import com.project.serv.StartUpService;

@Service
public class StartUpServImpl implements StartUpService {

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

}
