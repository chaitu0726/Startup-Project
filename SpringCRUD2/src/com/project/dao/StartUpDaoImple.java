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

import com.project.model.Bidding;
import com.project.model.Funding;
import com.project.model.Gst;
import com.project.model.Project;
import com.project.model.StartUp;
import com.project.dao.StartUpDao;

@Repository
public class StartUpDaoImple implements StartUpDao {

	@Autowired
	private JdbcTemplate jt;
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public boolean add(StartUp startup) {
	
			
	
			String sql = "select * from gst where gst_id = ? and pan =?";
			Gst st = jt.queryForObject(sql,new Object [] {startup.getGstId(),startup.getPan()},new RowMapper<Gst>(){

				@Override
				public Gst mapRow(ResultSet rs, int rowNum) throws SQLException {
					Gst temp = new Gst();
					
					temp.setGstId(rs.getString(1));
					temp.setPan(rs.getString(3));
					return temp;
				}
			
			});
			/**//*
			
			if(st == null)
				return false;*/
			
		System.out.println("here");
			//jdbcTemplate.update(q,new Object[] {student.getRno(),student.getStudentName(),student.getMarks(),student.getJdate()});
			String flag = "yes";
			 sql = "insert into login values(?,?,?)";
			
			int i = jt.update(sql,new Object[] {
					startup.getEmail(),
					startup.getPassword(),
					1
			});
			
			//System.out.println(sql);
			
			sql = "insert into user values(?,?,?,?,?,?)";
			System.out.println(sql);
			int j = jt.update(sql,new Object[]
					{
						startup.getName(),
						startup.getGstId(),
						startup.getContactNo(),
						startup.getEmail(),
						startup.getPassword(),
						flag
					});
			
			sql = "insert into startup(description,no_of_Employee,email,flag) values(?,?,?,?)";
			
			 System.out.println(sql);
			int k = jt.update(sql,new Object[] {
				startup.getDiscription(),
				startup.getNoOfEmployee(),
				startup.getEmail(),
				flag
			});
	
			//for startUpId
			
			
			sql = "select * from startup where email = ?";
			StartUp st1 = jt.queryForObject(sql,new Object[] {startup.getEmail()}, new RowMapper<StartUp>(){

				@Override
				public StartUp mapRow(ResultSet rs, int rowNum) throws SQLException {
					StartUp temp = new StartUp();
					temp.setStartUpId(rs.getInt(4));
					return temp;
				}
			});
			
			if(st1 == null)
				return false;
			
			//System.out.println(st1.toString());
			
			int sid = st1.getStartUpId();
			System.out.println(sid);
			sql = "insert into gst_startup values(?,?,?)";
			int z = jt.update(sql, new Object [] {
				startup.getGstId(),
				sid,
				flag
				
			});

		return true;
	}

	@Override
	public StartUp selectByEmail(String email) {
		
		return null;
	}

	@Override
	public List<Project> selectAll() {
		List<Project> list = new ArrayList<Project>();
		
		String sql= "select * from project where project_id not in (select project_id from bidding_details where bid_status not in ('applied','rejected'))";
		list = jt.query(sql, new ResultSetExtractor<List<Project>>(){

			@Override
			public List<Project> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Project> li = new ArrayList<Project>();
				
				while(rs.next())
				{
					Project st = new Project();
					st.setProjetcId(rs.getInt(1));
					st.setProjectName(rs.getString(2));
					st.setComapanyId(rs.getInt(7));
					li.add(st);
					
				}
				return li;
			}
	
		});
		
		return list;
	}
	
	@Override
	public List<StartUp> selectStp() {
		
		List<StartUp> list = new ArrayList<StartUp>();
		
		String sql= "select * from startup";
		list = jt.query(sql, new ResultSetExtractor<List<StartUp>>(){

			@Override
			public List<StartUp> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<StartUp> li = new ArrayList<StartUp>();
				System.out.println("company login");
				while(rs.next())
				{
					StartUp st = new StartUp();
					
					st.setStartUpId(rs.getInt(4));
					st.setNoOfEmployee(rs.getInt(2));
					st.setEmail(rs.getString(3));
					st.setDiscription(rs.getString(1));
					
					li.add(st);
				}
				return li;
			}
	
		});
		
		return list;
			
	}

	@Override
	public boolean addFund(Funding fund) {
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpSession sesion = sra.getRequest().getSession();
		int id = Integer.parseInt(sesion.getAttribute("id").toString());
		String flag = "yes";
		String status="Applied";
		String sql = "insert into funds(startup_id,fund_amount,fund_status,fund_description,flag)values(?,?,?,?,?)";
		jt.update(sql, new Object[] {
				id,
				fund.getFundAmount(),
				status,
				fund.getFundDescription(),
				flag
		});
		return true;
	}

	@Override
	public int getId(String email) {
		String sql = "select startup_id from startup where email =?";
		Integer id =jt.queryForObject(sql,new Object[] {email},Integer.class);
		return id.intValue();
	}

	@Override
	public Project selectById(int id) {
		String sql = "select * from project where project_id =?";
		Project temp = jt.queryForObject(sql, new Object [] {id}, new RowMapper<Project>() {

			@Override
			public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
				Project st = new Project();
				st.setProjetcId(rs.getInt(1));
				st.setProjectName(rs.getString(2));
				st.setProjectTechnology(rs.getString(3));
				st.setProjectDuration(rs.getString(4));
				st.setProjectDescription(rs.getString(5));
				st.setProjectBidAmount(rs.getString(6));
				st.setComapanyId(rs.getInt(7));
				return st;
			}
			
		});
		return temp;
	}

	@Override
	public boolean addBid(Bidding bid) {
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpSession sesion = sra.getRequest().getSession();
		int id = Integer.parseInt(sesion.getAttribute("id").toString());
		String Sql="select count(bid_id) from bidding_details where project_id = ? and startup_id = ?";
		 Integer count = jt.queryForObject(Sql, new Object[] {bid.getProjectId(),id}, Integer.class);
		if(count == 1)
			return false;
		String flag = "yes";
		String status = "applied";
		String sql = "insert into bidding_details(project_id,company_id,startup_id,bid_amount,bid_duration,bid_status,flag) values (?,?,?,?,?,?,?)";
		jt.update(sql, new Object[] {
				bid.getProjectId(),
				bid.getCompanyId(),
				id,
				bid.getBidAmount(),
				bid.getBidDuration(),	
				status,flag
		});
		System.out.println("hi");
		return true;
	}

	@Override
	public List<Project> startupProjetcList() {
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpSession sesion = sra.getRequest().getSession();
		int id = Integer.parseInt(sesion.getAttribute("id").toString());
		
		//String sqll = "select count(bid_status) from bidding_details where bid_status='selected' and project_id = ?";
		
		String sql="select * from project  where project_id  in (select project_id from bidding_details where startup_id =? and bid_status ='applied')";
		
		List<Project> plist = jt.query(sql,new Object[] {id}, new ResultSetExtractor<List<Project>>(){

			@Override
			public List<Project> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Project> plist = new ArrayList<Project>();
				while(rs.next())
				{
					Project project = new Project();
					project.setProjectName(rs.getString(2));
					project.setProjectTechnology(rs.getString(3));
					project.setProjectDuration(rs.getString(4));
					project.setProjectDescription(rs.getString(5));
					project.setProjectBidAmount(rs.getString(6));
					plist.add(project);
				}
				return plist;
			}});
		
		return plist;
	}

	@Override
	public List<Bidding> startupBidList() {
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpSession sesion = sra.getRequest().getSession();
		int id = Integer.parseInt(sesion.getAttribute("id").toString());
		
		String sql ="select * from bidding_details where startup_id = ? and bid_status='applied'";
		List<Bidding> blist = jt.query(sql,new Object[] {id}, new ResultSetExtractor<List<Bidding>>() {

			@Override
			public List<Bidding> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Bidding> blist = new ArrayList<Bidding>();
				
				while(rs.next())
				{
					Bidding bid = new Bidding();
					bid.setBidAmount(rs.getDouble(5));
					bid.setBidDuration(rs.getString(6));
					blist.add(bid);
				}
				
				return blist;
			}});
		return blist;
	}

	@Override
	public int getCompanyId(String email) {
		String sql = "select company_id from company where email =?";
		Integer id =jt.queryForObject(sql,new Object[] {email},Integer.class);
		System.out.println(id.intValue());
		return id.intValue();
		
	}

	@Override
	public List<String> selectList() {
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpSession sesion = sra.getRequest().getSession();
		int id = Integer.parseInt(sesion.getAttribute("id").toString());
		String sql ="select project_name from project where project_id in(select project_id from bidding_details where startup_id = ? and bid_status='selected')";
		List<String> selectProjectList = jt.queryForList(sql, new Object[] {id}, String.class);
		return selectProjectList;
	}

	@Override
	public List<String> selectProjectName() {
		// TODO Auto-generated method stub
		return null;
	}

}
