package com.project.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import com.project.model.Bidding;
import com.project.model.Company;
import com.project.model.Funding;
import com.project.model.Login;
import com.project.model.Project;
import com.project.dao.CompanyDao;

@Repository
public class CompanyDaoImpl implements CompanyDao{

	@Autowired
	JdbcTemplate jt;
	
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public boolean insert(Company comp) {
		return false;
		/*String sql;
		String flag ="yes";
		
		sql="select * from gst where gst_id=? and pan=?";
		
		Company comp2 = jt.queryForObject(sql, new Object[] {comp.getGstId(),comp.getPan()}, new RowMapper<Company>(){

			@Override
			public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
				Company temp=new Company();
				temp.setGstId(rs.getString(1));
				temp.setPan(rs.getString(3));
				return temp;
			}});
		
		//if(comp2.getGstId()==comp.getPan() && comp.getGstId()==comp.getPan()) {
				
		
		 sql= "insert into login values(?,?,?)";
		
		int a=jt.update(sql, new Object[] { 
				
				comp.getEmail(),
				comp.getPassword(),
				2
		});
		
		System.out.println(a+"inserted into login");
		
		sql= "insert into user values(?,?,?,?,?,?)";
		
		a=jt.update(sql, new Object [] {
				
				comp.getCompName(),
				comp.getGstId(),
				comp.getContactNo(),
				comp.getEmail(),
				comp.getPassword(),
				flag
		});
		
		System.out.println(a+"inserted into user");
		
		
		
		sql="insert into company(description,email,flag) values(?,?,?)";
		
		a=jt.update(sql, new Object [] {
				
				comp.getDescription(),
				comp.getEmail(),
				flag
		});
		
		System.out.println(a+"inserted into company");
		
		
		
		sql="select * from Company where email=?";
		Company comp1 = jt.queryForObject(sql,new Object[] {comp.getEmail()}, new RowMapper<Company>(){

			@Override
			public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
				Company temp = new Company();
				temp.setCompanyId(rs.getInt(3));
				return temp;
			}
		});
		
		//if(comp1 == null);
			//return false;
		System.out.println("selected comp id from table");
		
		int cid=comp1.getCompanyId();
		
		sql="insert into gst_company values(?,?,?)";
		jt.update(sql, new Object[] {
				
				comp.getGstId(),
				cid,
				flag
		});
		
		System.out.println("inserted into gst_company");
		
		return true;*/
	
	}

	@Override
	public boolean compLogin(Company comp) {
		
		return false;
	}

	@Override
	public boolean addProject(Project pro, Login lg) {
		
		String sql;
		sql="select company_id,flag from company where email=?";
		
		 Project pro1=jt.queryForObject(sql, new Object[] { lg.getUsername() }, new RowMapper<Project>() {

			@Override
			public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Project temp=new Project();		
				temp.setComapanyId(rs.getInt(1));
				temp.setFlag(rs.getString(2));
				return temp;
			}
		 });
		
		 sql= "insert into project(project_name,project_technology,project_duration,project_description,project_bid_amount,company_id,flag) "
		 		+ "values(?,?,?,?,?,?,?)";
			
			jt.update(sql, new Object [] {
					
					pro.getProjectName(),
					pro.getProjectTechnology(),
					pro.getProjectDuration(),
					pro.getProjectDescription(),
					pro.getProjectBidAmount(),
					pro1.getComapanyId(),
					pro1.getFlag()
			});
		return true;
	}

	@Override
	public List<Funding> fundList() {
		String sql = "select * from funds where fund_status='Applied'";
		List<Funding>flist = jt.query(sql,new ResultSetExtractor<List<Funding>>() {

			@Override
			public List<Funding> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Funding> list = new ArrayList<Funding>();
				while(rs.next())
				{
					Funding fund = new Funding();
					fund.setFundDescription(rs.getString(6));
					fund.setFundAmount(rs.getDouble(4));
					fund.setStartupId(rs.getInt(2));
					list.add(fund);
				}
				return list;
			}
				
		});
		return flist;
	}

	@Override
	public List<String> sname(List<Integer> sname) {
		List<String>name  = new ArrayList<String>();
		for (Integer integer : sname) {
			String sql = "select user_name from user where email =(select email from startup where startup_id = ?)";
			String s = jt.queryForObject(sql,new Object[] {integer},String.class);
			name.add(s);
		}
		return name;
	}
//////////////////////////////////////////
	@Override
	public List<Funding> selectStp() {
List<Funding> list = new ArrayList<Funding>();
		
		String sql="select *from funds";
		list = jt.query(sql, new ResultSetExtractor<List<Funding>>(){

			@Override
			public List<Funding> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Funding> li = new ArrayList<Funding>();
				
				while(rs.next())
				{
					Funding st = new Funding();
					st.setStartupId(rs.getInt(2));
					st.setFundAmount(rs.getDouble(4));
					st.setFundStatus(rs.getString(5));
					st.setFundDescription(rs.getString(6));
					li.add(st);
				}
				return li;
			}
	
		});

		return list;
	}

	@Override
	public List<Bidding> selectStpBid() {

		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpSession sesion = sra.getRequest().getSession();
		int id = Integer.parseInt(sesion.getAttribute("id").toString());
		
		
		List<Bidding> list = new ArrayList<Bidding>();
		
		String sql="select *from bidding_details where bid_status='applied' and company_id=?";
		list = jt.query(sql, new Object[] { id } , new ResultSetExtractor<List<Bidding>>(){

			@Override
			public List<Bidding> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Bidding> li = new ArrayList<Bidding>();
				
				while(rs.next())
				{
					Bidding st = new Bidding();
					st.setBidId(rs.getInt(1));
					st.setProjectId(rs.getInt(2));
					st.setCompanyId(rs.getInt(3));
					st.setStartupId(rs.getInt(4));
					st.setBidAmount(rs.getDouble(5));
					st.setBidDuration(rs.getString(6));
					st.setBidStatus(rs.getString(7));
					st.setFlag(rs.getString(8));
					
					li.add(st);
				}
				return li;
			}
			
		});
		
		return list;
	}
	
	@Override
	public void selectProject(int projetcId) {

		//////////////////////////////////
		///update bidding_details set bid_status = 'rejected' where project_id = ?  and company_id = ? and bid_status = 'applied'
		//////////////////////////////
		String sql="update bidding_details set bid_status='selected' where bid_id=?";
		jt.update(sql,new Object[] {projetcId});
		
	}

	@Override
	public List<String> pname(List<Integer> pid) {
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpSession sesion = sra.getRequest().getSession();
		int id = Integer.parseInt(sesion.getAttribute("id").toString());
		 
		List<String>projectname  = new ArrayList<String>();
		
		for (Integer integer : pid) {
			
			String sql = "select project_name from project where project_id=? and company_id=?";
			String p = jt.queryForObject(sql,new Object[] { integer, id },String.class);
			projectname.add(p);
		}
		return projectname;
	}
	

}
