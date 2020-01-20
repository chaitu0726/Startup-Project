package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.bean.StartUp;
import com.project.serv.StartUpService;



@Controller
public class StartUpController 
{
	
	@Autowired
	private StartUpService startUpService;
	
	public void setStartUpService(StartUpService startUpService) {
		this.startUpService = startUpService;
	}



	public StartUpController() {
		super();
		// TODO Auto-generated constructor stub
	}


	@RequestMapping(value="/add.htm",method = RequestMethod.POST)
	public String save(@ModelAttribute("stp") StartUp stp)
	{
		System.out.println("hii");
		
		if(startUpService.add(stp))
			return "index";
		else 
			return "home";
	}

}
