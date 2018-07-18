package com.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController{
	
	  @RequestMapping(value = "/logout", method = RequestMethod.GET)
	  public void logout(HttpSession session) {
		  session.invalidate();
	  }
	  @RequestMapping(value = "/logout", method = RequestMethod.POST)
	  public void logout2(HttpSession session) {
		  session.invalidate();
	  }
}