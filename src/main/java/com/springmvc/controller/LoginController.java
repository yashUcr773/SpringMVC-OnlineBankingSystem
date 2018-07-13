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

import com.springmvc.model.Login;
import com.springmvc.model.User;
import com.springmvc.service.UserService;

@Controller
@SessionAttributes("UserOBJ")
public class LoginController {
  @Autowired
  UserService userService;
  
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("login");
    mav.addObject("login", new Login());
    return mav;
  }
  
  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
  public ModelAndView loginProcess(HttpSession session, HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("login") Login login) {
    ModelAndView mav = null;
    User user = userService.validateUser(login);
    if (user != null) {
    	
    	
    	if(user.getAccounttype().equals("user"))
    		mav = new ModelAndView("loginSuccessful");
    	else
    		mav = new ModelAndView("adminlogin");
    	
    	
    	mav.addObject("firstname", user.getFirstname());
    	mav.addObject("accountnumber", user.getAccountnumber());
    	mav.addObject("user" , user.getFirstname());
    	session.setAttribute("UserOBJ", user);
    } 
    else
    {
    	mav = new ModelAndView("login");
    	mav.addObject("message", "Username or Password is Incorrect!!");
    }
    
    return mav;
  }
  
  @RequestMapping(value = "/aboutus", method = RequestMethod.GET)
  public ModelAndView aboutUs(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("aboutus");
    mav.addObject("aboutus");
    return mav;
  }
  
}
