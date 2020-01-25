package com.project.controller;


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
			//System.out.println(session);
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
			
			
			//System.out.println("hey");
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
			
			
			System.out.println("inside the cntr");
			Login lg= new Login();
			lg.setUsername(session.getAttribute("uname").toString());
			
			lg.setFlag(Integer.parseInt((session.getAttribute("role").toString())));	
			
			companyService.addProject(pro,lg);
			
			return "project_added_msg";
		}
		/*
		@RequestMapping(value = "/list_stp_comp_cntr", method = RequestMethod.GET)
		public ModelAndView selectStpFunds( HttpSession session ) {
			
			System.out.println("inside the cntr");
			
			ModelAndView model = new ModelAndView("list_stp_comp"); 
			
			List<Funding> list=companyService.selectStp();
			
			model.addObject("lists", list);
			
			return model;
		}
	*/	
}
