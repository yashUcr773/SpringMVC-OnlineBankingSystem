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

import com.springmvc.model.Account;
import com.springmvc.model.Transactions;
import com.springmvc.model.User;
import com.springmvc.service.UserService;


@Controller
@SessionAttributes("UserOBJ")
public class AdminController {
	

		@Autowired
		UserService userService;
		
		
		@RequestMapping(value = "/allaccounts" , method = RequestMethod.GET)
		public ModelAndView allAccounts(HttpServletRequest request, HttpServletResponse resonse,
				@ModelAttribute("UserOBJ") User user){
			
			ModelAndView mav = new ModelAndView("allaccounts");
			List<Account> accounts = userService.returnAllAccounts();
			mav.addObject("accounts",accounts);
			return mav;
		}
		
		
		@RequestMapping(value = "/allusers" , method = RequestMethod.GET)
		public ModelAndView allUsers(HttpServletRequest request, HttpServletResponse resonse){
			
			ModelAndView mav = new ModelAndView("allusers");
			List<User> users = userService.returnAllUsers(); 
			mav.addObject("users",users);
			return mav;
		}
		
		
		@RequestMapping(value = "/alltransactions" , method = RequestMethod.GET)
		public ModelAndView allTransactions(HttpServletRequest request, HttpServletResponse resonse){
			
			ModelAndView mav = new ModelAndView("alltransactions");
			List<Transactions> transactions = userService.returnAllTransactions();
			mav.addObject("transaction",transactions);
			return mav;
		}
		
		

}
