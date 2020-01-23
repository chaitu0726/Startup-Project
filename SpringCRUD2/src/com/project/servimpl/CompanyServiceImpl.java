package com.project.servimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bean.Company;
import com.project.dao.CompanyDao;
import com.project.serv.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyDao companyDao;
	
	
	public void setCompanydao(CompanyDao companydao) {
		this.companyDao = companydao;
	}

	@Override
	public boolean insert(Company comp) {
		return companyDao.insert(comp);
	}

	@Override
	public boolean compLogin(Company comp) {
		
		return false;
	}

}
