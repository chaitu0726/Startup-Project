package com.project.servimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bean.Login;
import com.project.dao.LoginDao;
import com.project.serv.LoginSevice;

@Service
public class LoginServImple implements LoginSevice {

	
	@Autowired
	private LoginDao loginDao;
	
	
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}


	@Override
	public Login login(Login login) {
		
		return loginDao.login(login);
	}

}
