package com.springmvc.controller;

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
import com.springmvc.service.UserService;

@Controller
@SessionAttributes("UserOBJ")
public class UpdateController {
	
	  @Autowired
	  public UserService userService;
	  @RequestMapping(value = "/update", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response , @ModelAttribute("UserOBJ") User user) {
	    ModelAndView mav = new ModelAndView("update");
	    mav.addObject("Username", user.getUsername());
	    mav.addObject("Acc", user.getAccountnumber());
	    mav.addObject("Pass", user.getPassword());
	    mav.addObject("user", user);
	    return mav;
	  }
	  
	  @RequestMapping(value = "/updateProcess", method = RequestMethod.POST)
	  public ModelAndView updateUser(HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("user") User user) {
	  userService.update(user);
	  ModelAndView mav = new ModelAndView("update", "Message", "Details Updated");
	  return mav;
	  }
	  
	  @RequestMapping(value = "/backfromupdate", method = RequestMethod.GET)
	  public ModelAndView backFromUpdate(HttpServletRequest request, HttpServletResponse response, HttpSession session,
	  @ModelAttribute("UserOBJ") User user) {
		  ModelAndView mav = null;
		  
	    	if(user.getAccounttype().equals("Admin"))
	    		mav = new ModelAndView("adminlogin");
	    	else
	    		mav = new ModelAndView("loginSuccessful");
	    	
	    	mav.addObject("firstname", user.getFirstname());
	    	mav.addObject("accountnumber", user.getAccountnumber());
	    	mav.addObject("user" , user.getFirstname());
	    	session.setAttribute("UserOBJ", user);
	  return mav;
	  }
	  
	  
	  @RequestMapping(value = "/changepassword", method = RequestMethod.GET)
	  public ModelAndView changePassword(HttpServletRequest request, HttpServletResponse response ,
			  @ModelAttribute("UserOBJ") User user , @ModelAttribute("password") Password password) {
	    ModelAndView mav = new ModelAndView("changepassword");
	    return mav;
	  }
	  
	  @RequestMapping(value = "/changepasswordprocess", method = RequestMethod.POST)
	  public ModelAndView changePasswordProcess(HttpServletRequest request, HttpServletResponse response ,
			  @ModelAttribute("UserOBJ") User user , @ModelAttribute("password") Password password) {
	 
		  ModelAndView mav;
	    
	    
	    if(user.getPassword().equals(password.getCurrent()) && password.getNewpass().equals(password.getRepeat()))
	    {
	    	
	    	user.setPassword(password.getNewpass());
	    	userService.changepass(user);
	    	mav = new ModelAndView("passwordchangesuccessful");
	    }
	    else
	    {
	    	mav = new ModelAndView("changepassword" , "message" , "Passwords Do not Match");
	    }
	    
	    
	    return mav;
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  

}
