package com.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
	  
}