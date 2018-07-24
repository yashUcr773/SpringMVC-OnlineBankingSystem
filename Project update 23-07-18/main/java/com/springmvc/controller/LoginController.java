package com.springmvc.controller;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    Login login = new Login();
    
    String str = GenerateCaptcha();
    
    login.setDisplayedcaptcha(str);
    
    
    mav.addObject("login", login);
    return mav;
  }
  
  
  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST,params = "refresh")
  public ModelAndView loginProcessRefresh(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("login") Login login) {
    
	  ModelAndView mav = new ModelAndView("login");
    
    String str = GenerateCaptcha();
    
    login.setDisplayedcaptcha(str);
    login.setEnteredcaptcha(null);
    
    
    mav.addObject("login", login);
    return mav;
  }
  
  
  
  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST,params = "login")
  public ModelAndView loginProcessLogin(HttpSession session, HttpServletRequest request, HttpServletResponse response,
  @ModelAttribute("login") Login login) {
    ModelAndView mav = null;
    
    if(!login.getDisplayedcaptcha().toUpperCase().equals(login.getEnteredcaptcha().toUpperCase()))
    {
    	ModelAndView mav2 = new ModelAndView("login");
    	login.setDisplayedcaptcha(GenerateCaptcha());
    	login.setEnteredcaptcha(null);
    	mav2.addObject("login",login);
    	mav2.addObject("message", "Captcha Doesn't Match");
    	return mav2;
    }
    
    
    
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
    	login.setDisplayedcaptcha(GenerateCaptcha());
    	login.setEnteredcaptcha(null);
    	mav.addObject("login",login);
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
  
  String GenerateCaptcha()
  {
	  
	  String cap = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	  String small = "abcdefghijklmnopqrstuvwxyz";
	  String num="0123456789";
	  
	  String captcha="";
	  
	  Random rand = new Random();

	  for(int i=0;i<10;i++)
	  {
		  int  n = rand.nextInt(3);
		  
		  if(n==0)
		  {
			  n=rand.nextInt(26);
			  captcha+=cap.charAt(n);
		  }else if(n==1)
		  {
			  n=rand.nextInt(26);
			  captcha+=small.charAt(n);
			  
		  }else
		  {
			  n=rand.nextInt(10);
			  captcha+=num.charAt(n);
		  }
	  }
	  return captcha;
  }
  
}
