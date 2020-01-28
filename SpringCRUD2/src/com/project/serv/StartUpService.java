package com.project.serv;

import java.util.List;

import com.project.model.Bidding;
import com.project.model.Funding;
import com.project.model.Project;
import com.project.model.StartUp;

public interface StartUpService {

	boolean add(StartUp startup);
	public StartUp selectByEmail(String email);
	public List<Project> selectAll();
	public boolean isUsernameExist(String username);
	public List<StartUp> selectStp();
	public int getId(String email);
	public boolean addFund(Funding fund);
	public Project selectById(int id);
	public boolean addBid(Bidding bid);
	public List<Project> startupProjetcList();
	public List<Bidding> startupBidList();
	public int getCompanyId(String email);
}
