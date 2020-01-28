package com.project.serv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class AjaxServiceImpl implements AjaxService{

	@Autowired
	JdbcTemplate jt;
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
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
	public boolean isGstExist(String gst) {
		String sql = "select count(gst_id) from gst where gst_id = ?";
		Integer count = jt.queryForObject(sql,new Object[] {gst}, Integer.class);
		if(count == 1)
			return true;
		else
			return false;
	}

	@Override
	public boolean isPanExist(String pan) {
		String sql = "select count(pan) from gst where pan = ?";
		Integer count = jt.queryForObject(sql,new Object[] {pan}, Integer.class);
		if(count == 1)
			return true;
		else
			return false;
	}

}
