package com.project.dao;

import com.project.bean.StartUp;

public interface StartUpDao {

	boolean add(StartUp startup);
	StartUp selectByEmail(String email);

}
