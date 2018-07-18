package com.springmvc.controller;
import java.util.ArrayList;
import java.util.List;

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

import com.springmvc.model.User;
import com.springmvc.service.UserService;


@Controller
@SessionAttributes("UserOBJ")
public class RegistrationController {
	
	public int max(int a,int b)
	{
		if(a>b)
			return a;
		else
			return b;
	}
	
  @Autowired
  public UserService userService;
  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("register");
    mav.addObject("user", new User());
    
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
  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, HttpSession session,
  @ModelAttribute("user") User user) {
	  
	  ModelAndView mav=new ModelAndView("welcome");
	  List<User> users = userService.returnAllUsers();
	  
	  int acc=0;
	  
	  for(User u:users)
	  {
		  
		  if(u.getUsername().equals(user.getUsername()))
		  {
			    ModelAndView mav2 = new ModelAndView("register");
			    mav2.addObject("user", user);
			    mav2.addObject("ErrorMessage","User Name already exists");
			    return mav2;
		  }
		  
		  if(u.getEmail().equals(user.getEmail()))
		  {
			    ModelAndView mav2 = new ModelAndView("register");
			    mav2.addObject("user", user);
			    mav2.addObject("ErrorMessage","Email already exists");
			    return mav2;
		  }
		  
		  
		  acc=max(acc,u.getAccountnumber());
	  }
	  
	  if(acc<1000)
		  acc=1000;
	  
		 acc +=1;
	  user.setAccountnumber(acc);
	 
	  
	  user.setDateofbirth(user.getDay()+"-"+user.getMonth()+"-"+user.getYear());
	  user.displayall();
  userService.register(user);
  userService.createAccount(user);
  
  
  mav.addObject("firstname",user.getFirstname());
  mav.addObject("accountnumber", user.getAccountnumber());
  session.setAttribute("UserOBJ", user);
  return mav;
  }
  
  @RequestMapping(value = "/myprofile", method = RequestMethod.GET)
  public ModelAndView myprofile(HttpServletRequest request, HttpServletResponse response , HttpSession session ,
  @ModelAttribute("UserOBJ") User user) {
	ModelAndView mav = new ModelAndView("loginSuccessful");
  	mav.addObject("firstname", user.getFirstname());
  	mav.addObject("accountnumber", user.getAccountnumber());
  	mav.addObject("user" , user.getFirstname());
  	session.setAttribute("UserOBJ", user);
  	return mav;
  }
  
}