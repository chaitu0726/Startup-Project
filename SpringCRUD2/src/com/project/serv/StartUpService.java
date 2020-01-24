package com.project.serv;

import java.util.List;

import com.project.model.Project;
import com.project.model.StartUp;

public interface StartUpService {

	boolean add(StartUp startup);
	StartUp selectByEmail(String email);
	List<Project> selectAll();
}
