package com.springmvc.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.Password;
import com.springmvc.model.User;
import com.springmvc.model.getMD5;
import com.springmvc.service.UserService;

@Controller
@SessionAttributes("UserOBJ")
public class ForgotController {

	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/forgot",method=RequestMethod.GET)
	public ModelAndView forgot(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("user") User user)
	{
		ModelAndView mav = new ModelAndView("forgot");
		
		
		
	    
	    
		  ArrayList<String> day = new ArrayList<>();
		  for(int i=1;i<=31;i++)
		  {
			  day.add(String.valueOf(i));
		  }
		  ArrayList<String> month = new ArrayList<>();
		  month.add("Jan");
		  month.add("Feb");
		  month.add("Mar");
		  month.add("Apr");
		  month.add("May");
		  month.add("Jun");
		  month.add("July");
		  month.add("Aug");
		  month.add("Sept");
		  month.add("Oct");
		  month.add("Nov");
		  month.add("Dec");
		  ArrayList<String> year = new ArrayList<>();
		  for(int i=1900;i<=2100;i++)
		  {
			  year.add(String.valueOf(i));
		  }
		  ArrayList<String> acctype = new ArrayList<>();
		  acctype.add("Savings");
		  acctype.add("Current");
		  
		  
		  
		  mav.addObject("acctype",acctype);
		  mav.addObject("day",day);
		  mav.addObject("month",month);
		  mav.addObject("year",year);
		
		
		
		
		
		return mav;
	}
	
	@RequestMapping(value="/forgotProcess",method=RequestMethod.POST)
	public ModelAndView forgotProcess(HttpSession session, HttpServletRequest request,HttpServletResponse response,@ModelAttribute("user") User user,@ModelAttribute("password") Password password)
	{
		ModelAndView mav = new ModelAndView("forgotpassword");
		
		
	    
	    
		  ArrayList<String> day = new ArrayList<>();
		  for(int i=1;i<=31;i++)
		  {
			  day.add(String.valueOf(i));
		  }
		  ArrayList<String> month = new ArrayList<>();
		  month.add("Jan");
		  month.add("Feb");
		  month.add("Mar");
		  month.add("Apr");
		  month.add("May");
		  month.add("Jun");
		  month.add("July");
		  month.add("Aug");
		  month.add("Sept");
		  month.add("Oct");
		  month.add("Nov");
		  month.add("Dec");
		  ArrayList<String> year = new ArrayList<>();
		  for(int i=1900;i<=2100;i++)
		  {
			  year.add(String.valueOf(i));
		  }
		  ArrayList<String> acctype = new ArrayList<>();
		  acctype.add("Savings");
		  acctype.add("Current");
		  
		  
		  
		  mav.addObject("acctype",acctype);
		  mav.addObject("day",day);
		  mav.addObject("month",month);
		  mav.addObject("year",year);
		
		  
		  user.setDateofbirth(user.getDay()+"-"+user.getMonth()+"-"+user.getYear());
		  
		  
		  
		  
		  Boolean flag = false;
		  flag=userService.checkIfExists(user);

		  if(flag==true)
		  {
			  session.setAttribute("UserOBJ", user);
			  return mav;
		  }
		  else
		  {
			  ModelAndView mav2 = new ModelAndView("forgot");
			  mav2.addObject("ErrorMessage","Details do not match. Please Contact Bank for furthur details.");
			  return mav2;
		  }
		  
	}
	
	
	  @RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
	  public ModelAndView changePassword(HttpServletRequest request, HttpServletResponse response ,
			  @ModelAttribute("UserOBJ") User user , @ModelAttribute("password") Password password) {
	    ModelAndView mav = new ModelAndView("forgotpassword");
	    user.displayall();
	    System.out.println(password.getNewpass() + " " + password.getRepeat());
	    return mav;
	  }
	  
	  @RequestMapping(value = "/forgotpasswordprocess", method = RequestMethod.POST)
	  public ModelAndView changePasswordProcess(HttpServletRequest request, HttpServletResponse response ,
			  @ModelAttribute("UserOBJ") User user , @ModelAttribute("password") Password password) {
	 
		  ModelAndView mav;
		    user.displayall();
		    System.out.println(password.getNewpass() + " " + password.getRepeat());

	    
	    if(getMD5.generate(password.getNewpass()).equals(getMD5.generate(password.getRepeat())))
	    {
	    	user.setPassword(getMD5.generate(password.getNewpass()));
	    	userService.changepass(user);
	    	mav = new ModelAndView("passwordchangesuccessful");
	    }
	    else
	    {
	    	mav = new ModelAndView("forgotpassword" , "message" , "Passwords Do not Match");
	    }
	    
	    
	    return mav;
	  }
	
	
}
