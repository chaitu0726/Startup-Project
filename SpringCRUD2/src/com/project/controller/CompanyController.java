package com.project.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.Bidding;
import com.project.model.Company;
import com.project.model.Login;
import com.project.model.Project;
import com.project.serv.CompanyService;
import com.project.model.Funding;


@Controller
public class CompanyController {
	
		@Autowired
		private CompanyService companyService;

	
		public void setCompanyService(CompanyService companyService) {
			this.companyService = companyService;
		}	
		
		@RequestMapping(value="/compReg",method = RequestMethod.GET)
		public String loginGet(HttpSession session)
		{
			try {
			if(session != null)
				if((int)session.getAttribute("role") == 2)
					return "startup_home";
				else
					return "company_home";
			return "index";
			}catch(Exception e)
			{
				return "index";
			}
		}
		
		@RequestMapping(value="/compReg",method=RequestMethod.POST)
		public String insert(@ModelAttribute("comp")Company comp ,ModelMap model) {
			
			try {
				if(companyService.insert(comp))
					return "index";
				else
					return "company_register";
				
			}catch(Exception e){
				
				return "company_register";
			}
		}
		
		@RequestMapping(value = "/comProjectAdd", method = RequestMethod.POST)
		public String addProject(@ModelAttribute("pro") Project pro ,HttpSession session ) {
			
			Login lg= new Login();
			lg.setUsername(session.getAttribute("uname").toString());
			
			lg.setFlag(Integer.parseInt((session.getAttribute("role").toString())));	
			
			companyService.addProject(pro,lg);
			
			return "project_added_msg";
		}
		
		@RequestMapping(value = "/showFundList" ,method = RequestMethod.GET)
		public ModelAndView showFundList()
		{
			ModelAndView model;
			List<Funding>flist = companyService.fundList();
			List<Integer>sid = new ArrayList<Integer>();
			
			for (Funding fund : flist) {
				sid.add(fund.getStartupId());
			}
			List<String>sname = companyService.sname(sid);
			model = new ModelAndView("funding_list");
			model.addObject("fundlist", flist);
			model.addObject("startupList", sname);
			return model;
		}
		
		
		
		@RequestMapping(value = "/list_stp_comp_cntr", method = RequestMethod.GET)
		public ModelAndView selectStpFunds( HttpSession session ) {
		
			ModelAndView model = new ModelAndView("list_stp_comp"); 
			
			List<Integer>sid = new ArrayList<Integer>();
			List<Funding> list=companyService.selectStp();
			
			for (Funding fund : list) {
				sid.add(fund.getStartupId());
			}
			List<String>sname = companyService.sname(sid);
			
			model.addObject("lists", list);
			model.addObject("startupname", sname);
			
			return model;
		}
		
		@RequestMapping(value = "/list_stp_apply_bidding")
		public ModelAndView selectStpBid() {
			
			ModelAndView model =new ModelAndView("list_proj_apply_stp");
			List<Integer>sid = new ArrayList<Integer>();
			List<Integer>pid=new ArrayList<Integer>();
			
			//Get startup list from db
			List<Bidding> list=companyService.selectStpBid();
			
			//using startupID get startup name
			for (Bidding fund1 : list) {
				sid.add(fund1.getStartupId());
			}
			List<String>sname = companyService.sname(sid);
			
			//using projectId get project name
			for(Bidding bid : list) {
				pid.add(bid.getProjectId());
			}
			List<String> pname=companyService.pname(pid);
			
			
			model.addObject("lists", list);
			model.addObject("startupname", sname);
			model.addObject("projectname", pname);
			
			return model;
		}
		
		@RequestMapping(value = "/selectProject")
		public String  selectedProject(@ModelAttribute("pid") Project pid) {
			
			companyService.selectProject(pid.getProjetcId());
			
			return "selectedProject";
		}
		
}
