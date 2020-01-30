package com.project.serv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.project.model.Bidding;
import com.project.model.Funding;
import com.project.model.Project;
import com.project.model.StartUp;
import com.project.dao.StartUpDao;
import com.project.serv.StartUpService;

@Service
public class StartUpServImpl implements StartUpService {

	@Autowired
	JdbcTemplate jt;
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Autowired
	private StartUpDao startUpDao;
	
	
	public StartUpServImpl() {
		super();
		
	}
	
	public void setStartUpDao(StartUpDao startUpDao) {
		this.startUpDao = startUpDao;
	}


	@Override
	public boolean add(StartUp startup) {
		if(startup.getName().equals(null) || startup.getGstId().equals(null) || startup.getContactNo().equals(null) 
			|| startup.getEmail().equals(null) || startup.getNoOfEmployee()==0 || startup.getDiscription().equals(null)
			|| startup.getPan().equals(null) || startup.getPassword().equals(null))
			return false;
		
		System.out.println("add");
		String sqll ="select count(gst_id) from gst where pan = ?";
		Integer check = jt.queryForObject(sqll, new Object[] {startup.getPan()}, Integer.class);
		System.out.println(check);
		if(check != 1)
			return false;
		
		String sql ="select count(gst_id) from gst where gst_id=?";
		Integer count1 = jt.queryForObject(sql,new Object[] {startup.getGstId()}, Integer.class);
		sql ="select count(gst_id) from gst_company where gst_id=?";
		Integer count2 = jt.queryForObject(sql,new Object[] {startup.getGstId()}, Integer.class);
		sql ="select count(gst_id) from gst_startup where gst_id=?";
		Integer count3 = jt.queryForObject(sql,new Object[] {startup.getGstId()}, Integer.class);
		
		System.out.println(count1+" "+count2+" "+count3);
		if(count1 == 1 && count2 == 0 && count3 ==0)
			return startUpDao.add(startup);
		else
			return false;
	}

	@Override
	public StartUp selectByEmail(String email) {
		
		return startUpDao.selectByEmail(email);
	}

	@Override
	public List<Project> selectAll() {
		return startUpDao.selectAll();
	}

	@Override
	public boolean isUsernameExist(String username) {
		String sql = "select count(username) from login where username = ?";
		Integer count = jt.queryForObject(sql,new Object[] {username}, Integer.class);
		if(count == 1)
			return true;
		else
			return false;
	}
	
	@Override
	public List<StartUp> selectStp() {
		
		return  startUpDao.selectStp();
	}

	@Override
	public int getId(String email) {
		return startUpDao.getId(email);
	}

	@Override
	public boolean addFund(Funding fund) {
		// TODO Auto-generated method stub
		return startUpDao.addFund(fund);
	}

	@Override
	public Project selectById(int id) {
		
		return startUpDao.selectById(id);
	}

	@Override
	public boolean addBid(Bidding bid) {
		
		return startUpDao.addBid(bid);
	}

	@Override
	public List<Project> startupProjetcList() {
		
		return startUpDao.startupProjetcList();
	}

	@Override
	public List<Bidding> startupBidList() {
		
		return startUpDao.startupBidList();
	}

	@Override
	public int getCompanyId(String email) {
		
		return startUpDao.getCompanyId(email);
	}

	@Override
	public List<String> selectList() {
		
		return startUpDao.selectList();
	}

	@Override
	public List<String> selectProjectName() {
		return startUpDao.selectProjectName();
	}


}
