package com.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.Transactions;
import com.springmvc.model.User;
import com.springmvc.service.UserService;

@Controller
@SessionAttributes("UserOBJ")
public class TransactionController {

	@Autowired
	UserService userService;
	
	
	@RequestMapping(value = "transactions" , method = RequestMethod.GET)
	public ModelAndView transactions(HttpServletRequest request, HttpServletResponse resonse,
		@ModelAttribute("UserOBJ") User user){
		
		ModelAndView mav = new ModelAndView("transactions");
		
		
		List<Transactions> transactions = userService.getTransactions(user.getAccountnumber());
		
		mav.addObject("transaction",transactions);
		
		return mav;
	}
	
	
}
