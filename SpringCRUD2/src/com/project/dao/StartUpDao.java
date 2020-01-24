package com.project.dao;

import java.util.List;

import com.project.model.Project;
import com.project.model.StartUp;

public interface StartUpDao {

	boolean add(StartUp startup);
	StartUp selectByEmail(String email);
	List<Project> selectAll();
}
