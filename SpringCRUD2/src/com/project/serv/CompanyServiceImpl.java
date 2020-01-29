package com.project.serv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Bidding;
import com.project.model.Company;
import com.project.model.Funding;
import com.project.model.Login;
import com.project.model.Project;
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
		if(comp.getCompName().equals(null) || comp.getGstId().equals(null) || comp.getGstId().equals(null)
				|| comp.getContactNo().equals(null) || comp.getEmail().equals(null) ||
			comp.getPan().equals(null) || comp.getDescription().equals(null) || comp.getPassword().equals(null))
			return false;
		
		return companyDao.insert(comp);
	}

	@Override
	public boolean compLogin(Company comp) {
		
		return false;
	}

	@Override
	public boolean addProject(Project pro, Login lg) {
		
		return companyDao.addProject(pro,lg);
	}

	@Override
	public List<Funding> fundList() {
		
		return companyDao.fundList();
	}

	@Override
	public List<String> sname(List<Integer> sname) {
		
		return companyDao.sname(sname);
	}
////////////////////////////////////////////////////////////////////////////
	@Override
	public List<Funding> selectStp() {
		return companyDao.selectStp();
	}

	@Override
	public List<Bidding> selectStpBid() {
		
		return companyDao.selectStpBid();
	}

	@Override
	public void selectProject(int projetcId) {
		companyDao.selectProject(projetcId);
		
	}

	@Override
	public List<String> pname(List<Integer> pid) {
		return companyDao.pname(pid);
	}

	
}
