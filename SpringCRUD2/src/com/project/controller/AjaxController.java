package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.serv.AjaxService;
@Controller
public class AjaxController {
//hjvvhvhv
	@Autowired
	AjaxService ajaxService;
	
	public void setAjaxService(AjaxService ajaxService) {
		this.ajaxService = ajaxService;
	}

	@RequestMapping(value="/check_username",method = RequestMethod.GET)
	@ResponseBody
	public String checkAvailability(@RequestParam String username)
	{
		if(ajaxService.isUsernameExist(username))
			return "";
		else if(username == "")
			return "Email Cannot blank";
		else
			return "Username is Invalid";
	}
	
	@RequestMapping(value="/check_gst",method = RequestMethod.GET)
	@ResponseBody
	public String checkAvailabilityGst(@RequestParam String gst)
	{
		if(ajaxService.isGstExist(gst))
			return "Gst is Already Registered";
		else if(gst == "")
			return "Gst Number Cannot blank";
		return "";
	}
	
	
	@RequestMapping(value="/check_pan",method = RequestMethod.GET)
	@ResponseBody
	public String checkAvailabilityPan(@RequestParam String pan)
	{
		if(ajaxService.isPanExist(pan))
			return "PAN Is already registered";
		else if(pan == "")
			return "PAN Number Cannot blank";
		return "";
		
	}
	
	@RequestMapping(value="/check_gstt",method = RequestMethod.GET)
	@ResponseBody
	public String checkAvailabilityGstt(@RequestParam String gst)
	{
		if(ajaxService.isGstExist(gst))
			return "";
		else if(gst == "")
			return "Gst Number Cannot blank";
		return "Invalid GST";
	}
	
	@RequestMapping(value="/check_pann",method = RequestMethod.GET)
	@ResponseBody
	public String checkAvailabilityPann(@RequestParam String pan)
	{
		if(ajaxService.isPanExist(pan))
			return "";
		else if(pan == "")
			return "PAN Number Cannot blank";
		return "Invalid PAN";
		
	}
}
