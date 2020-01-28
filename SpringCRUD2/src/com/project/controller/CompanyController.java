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
}
