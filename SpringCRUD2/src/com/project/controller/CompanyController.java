package com.project.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.model.Company;
import com.project.serv.CompanyService;



@Controller
public class CompanyController {
	
		@Autowired
		private CompanyService companyService;

	
		public void setCompanyService(CompanyService companyService) {
			this.companyService = companyService;
		}


/*		@RequestMapping("/startup.htm")
		public String Login(ModelMap model) {
			
			return "login";
		}
*/		
		
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
}
