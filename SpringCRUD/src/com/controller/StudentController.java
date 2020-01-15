package com.controller;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.dao.StudentDao;
import com.bean.Student;

@Controller
public class StudentController {

@RequestMapping("/hello.htm")
public String sayHello(ModelMap model)
{
	model.put("msg","Hello i am here");
	return "index";
}


@Autowired
private	StudentDao student;
public void setStudent(StudentDao student) {
	this.student = student;
}
/*
@RequestMapping("/index")
public String showform(Model m)
{
	System.out.println("Hello");
	m.addAttribute("command",new Student());
	return "index";
}
*/
@RequestMapping(value="/save.htm",method = RequestMethod.POST)
public String save(@ModelAttribute("std")Student std)
{
	System.out.println("hii");
	student.save(std);
	return "index";
}



}
