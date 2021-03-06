package com.project.dao;

import java.util.List;

import com.project.model.Bidding;
import com.project.model.Company;
import com.project.model.Login;
import com.project.model.Project;
import com.project.model.Funding;
public interface CompanyDao {

	public boolean insert(Company comp);
	public boolean compLogin(Company comp);
	boolean addProject(Project pro,Login lg);
	public List<Funding> fundList();
	public List<String> sname(List<Integer> sname);
	public List<Funding> selectStp();
	public List<Bidding> selectStpBid();
	public void selectProject(int projetcId);
	public List<String> pname(List<Integer> pid);
}
