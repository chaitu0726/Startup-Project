package com.project.dao;

import java.util.List;

import com.project.bean.Project;
import com.project.bean.StartUp;

public interface StartUpDao {

	boolean add(StartUp startup);
	StartUp selectByEmail(String email);
	List<Project> selectAll();
}
