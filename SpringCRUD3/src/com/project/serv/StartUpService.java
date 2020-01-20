package com.project.serv;

import com.project.bean.StartUp;

public interface StartUpService {

	boolean add(StartUp startup);
	StartUp selectByEmail(String email);
}
