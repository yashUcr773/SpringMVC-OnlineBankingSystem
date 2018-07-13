package com.springmvc.controller;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.Account;
import com.springmvc.model.User;
import com.springmvc.service.UserService;

@Controller
@SessionAttributes("UserOBJ")
public class AccountDetailsController {

	@Autowired
	UserService userService;
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response , @ModelAttribute("UserOBJ") User user) {
	    ModelAndView mav = new ModelAndView("check");
	    Account account = new Account();
	    
	    
	    account = userService.populateAccount(user);
	
	    
	    
	    
	    
	    mav.addObject("accountnumber", account.getNumber());
	    mav.addObject("accounttype", account.getType());
	    mav.addObject("accountbalance", account.getBalance());
	    mav.addObject("accountopendate", account.getDate());
	    mav.addObject("accountopentimestamp", account.getTimestamp());
	    return mav;
	  }
	
	
	
}
