package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.bean.Login;
import com.project.bean.Project;
import com.project.bean.StartUp;
import com.project.serv.LoginSevice;
import com.project.serv.StartUpService;



@Controller
public class StartUpController 
{
	
	@Autowired
	private StartUpService startUpService;
	
	public void setStartUpService(StartUpService startUpService) {
		this.startUpService = startUpService;
	}

	@Autowired
	private LoginSevice loginService;
	

	public void setLoginService(LoginSevice loginService) {
		this.loginService = loginService;
	}


	public StartUpController() {
		super();
		// TODO Auto-generated constructor stub
	}


	@RequestMapping(value="/add.htm",method = RequestMethod.POST)
	public String save(@ModelAttribute("stp") StartUp stp)
	{
		//System.out.println("hii");
		try {
		if(startUpService.add(stp))
			return "index";
		else 
			return "home";
		}catch(Exception e)
		{
			return "home";
		}
		
	}
	
	@RequestMapping(value="/login.htm",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("lg") Login lg)
	{
		ModelAndView model; 
		//System.out.println("hii");
		try {
			Login lgn = loginService.login(lg);
		if(lgn.getFlag() == 1)
		{
			List<Project>list = startUpService.selectAll();
			model = new ModelAndView("startup_home");
			model.addObject("lists",list);
			return model;
		}
		else
		{
			model = new ModelAndView("index");
			return model;
		}
		}catch(Exception e)
		{
			model = new ModelAndView("index");
			return model;
		}
		
	}
	

}
