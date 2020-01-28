package com.project.serv;

import java.util.List;

import com.project.model.Company;
import com.project.model.Funding;
import com.project.model.Login;
import com.project.model.Project;

public interface CompanyService {
	public boolean insert(Company comp);
	public boolean compLogin(Company comp);
	 boolean addProject(Project pro,Login lg);
	 public List<Funding> fundList();
	 public List<String> sname(List<Integer> sname);
	 
}
