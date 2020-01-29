package com.project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.project.model.Gst;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	JdbcTemplate jt;
	
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}


	@Override
	public boolean insertGst(Gst gst) {
		
		String sql= "insert into gst values(?,?,?)";
		
		jt.update(sql,new Object [] {
				gst.getGstId(),
				gst.getName(),
				gst.getPan()
		});
		
		return true;
	}

}
