package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.model.Gst;
import com.project.serv.AdminService;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@RequestMapping(value="/gstadd",method = RequestMethod.POST)
	public String gstAdd(@ModelAttribute("gst") Gst gst)
	{
		try
		{
			if(adminService.insertGst(gst))
			{
				System.out.println("controller");
				return "success";
			}
			else
			{
				System.out.println("else");
				return "admin_home";
			}
			
		}catch(Exception e)
		{
			System.out.println("catch");
			return "admin_home";
		}
	}
	
}
