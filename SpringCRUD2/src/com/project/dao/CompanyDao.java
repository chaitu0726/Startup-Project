package com.project.dao;

import java.util.List;

import com.project.model.Company;
import com.project.model.Login;
import com.project.model.Project;
import com.project.model.Funding;
public interface CompanyDao {

	public boolean insert(Company comp);
	public boolean compLogin(Company comp);
	boolean addProject(Project pro,Login lg);
	
}
