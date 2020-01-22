package com.project.daoimple;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.sql.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.project.bean.Login;
import com.project.dao.LoginDao;

@Repository
public class LoginDaoImple implements LoginDao{

	@Autowired
	JdbcTemplate jt;
	
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}


	@Override
	public Login login(Login login) {
		
		String sql = "select *from login where username=? and password = ?";
		Login lg = jt.queryForObject(sql, new Object [] {login.getUsername(),login.getPassword()}, new RowMapper<Login>() {
			
			

			@Override
			public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Login temp = new Login();
				temp.setUsername(rs.getString(1));
				temp.setPassword(rs.getString(2));
				temp.setFlag(rs.getInt(3));
				return temp;		
				
			}
		});
	
		return lg;
	}

}
