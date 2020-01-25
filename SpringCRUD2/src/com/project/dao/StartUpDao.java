package com.project.dao;

import java.util.List;

import com.project.model.Funding;
import com.project.model.Project;
import com.project.model.StartUp;

public interface StartUpDao {

	boolean add(StartUp startup);
	public StartUp selectByEmail(String email);
	public List<Project> selectAll();
	public List<StartUp> selectStp();
	public boolean addFund(Funding fund);
	public int getId(String email);
}
