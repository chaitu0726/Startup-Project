package com.project.dao;

import com.project.model.Company;

public interface CompanyDao {

	public boolean insert(Company comp);
	public boolean compLogin(Company comp);
}
