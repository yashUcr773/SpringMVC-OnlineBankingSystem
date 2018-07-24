package com.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController{
	
	  @RequestMapping(value = "/logout", method = RequestMethod.GET)
	  public void logoutGET(HttpSession session) {
		  session.invalidate();
		  

		  
	  }
	  
	  @RequestMapping(value = "/logout", method = RequestMethod.POST)
	  public void logoutPOST(HttpSession session) {
		  session.invalidate();
	  }
	  
	  @RequestMapping(value = "/home", method = RequestMethod.GET)
	  public String redirectget(HttpSession session) {
		  session.invalidate();
	      return "redirect:home.jsp";
	  }
	  
	  @RequestMapping(value = "/home", method = RequestMethod.POST)
	  public String redirectpost(HttpSession session) {
		  session.invalidate();
	      return "redirect:home.jsp";
	  }
	  
}