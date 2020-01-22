package com.project.serv;

import java.util.List;

import com.project.bean.Project;
import com.project.bean.StartUp;

public interface StartUpService {

	boolean add(StartUp startup);
	StartUp selectByEmail(String email);
	List<Project> selectAll();
}
