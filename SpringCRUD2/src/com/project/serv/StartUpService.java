package com.project.serv;

import java.util.List;

import com.project.model.Funding;
import com.project.model.Project;
import com.project.model.StartUp;

public interface StartUpService {

	boolean add(StartUp startup);
	public StartUp selectByEmail(String email);
	public List<Project> selectAll();
	public boolean isUsernameExist(String username);
	public List<StartUp> selectStp();
}
