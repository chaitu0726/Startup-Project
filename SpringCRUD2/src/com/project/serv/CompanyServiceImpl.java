package com.project.serv;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.project.model.Bidding;
import com.project.model.Company;
import com.project.model.Funding;
import com.project.model.Login;
import com.project.model.Project;
import com.project.dao.CompanyDao;
import com.project.serv.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyDao companyDao;
	
	@Autowired
	JdbcTemplate jt;
	
	
	public void setCompanyDao(CompanyDao companyDao) {
		this.companyDao = companyDao;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}


	@Override
	public boolean insert(Company comp) {
		if(comp.getCompName().equals(null) || comp.getGstId().equals(null) 
				|| comp.getContactNo().equals(null) || comp.getEmail().equals(null) ||
			comp.getPan().equals(null) || comp.getDescription().equals(null) || comp.getPassword().equals(null))
			return false;
		
		String sqll ="select count(gst_id) from gst where pan = ?";
		Integer check = jt.queryForObject(sqll, new Object[] {comp.getPan()}, Integer.class);
		System.out.println(check);
		if(check != 1)
			return false;
		    
		String sql ="select count(gst_id) from gst where gst_id=?";
		Integer count1 = jt.queryForObject(sql,new Object[] {comp.getGstId()}, Integer.class);
		sql ="select count(gst_id) from gst_company where gst_id=?";
		Integer count2 = jt.queryForObject(sql,new Object[] {comp.getGstId()}, Integer.class);
		sql ="select count(gst_id) from gst_startup where gst_id=?";
		Integer count3 = jt.queryForObject(sql,new Object[] {comp.getGstId()}, Integer.class);
		System.out.println(count1+" "+count2+" "+count3);
		if(count1 == 1 && count2 == 0 && count3 ==0)
			return companyDao.insert(comp);
		else
			return false;
		
	}

	@Override
	public boolean compLogin(Company comp) {
		
		return false;
	}

	@Override
	public boolean addProject(Project pro, Login lg) {
		
		return companyDao.addProject(pro,lg);
	}

	@Override
	public List<Funding> fundList() {
		
		return companyDao.fundList();
	}

	@Override
	public List<String> sname(List<Integer> sname) {
		
		return companyDao.sname(sname);
	}
////////////////////////////////////////////////////////////////////////////
	@Override
	public List<Funding> selectStp() {
		return companyDao.selectStp();
	}

	@Override
	public List<Bidding> selectStpBid() {
		
		return companyDao.selectStpBid();
	}

	@Override
	public void selectProject(int projetcId) {
		companyDao.selectProject(projetcId);
		
	}

	@Override
	public List<String> pname(List<Integer> pid) {
		return companyDao.pname(pid);
	}

	@Override
	public void selectFund(int fundId) {
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpSession sesion = sra.getRequest().getSession();
		int id = Integer.parseInt(sesion.getAttribute("id").toString());
		String sql = "update funds set company_id =? , fund_status ='selected' where fund_id=?";
		jt.update(sql, new Object[] {
				id,
				fundId
		});
		
	}

	
}
