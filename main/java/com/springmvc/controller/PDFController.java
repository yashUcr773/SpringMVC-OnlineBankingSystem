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
public class PDFController {

	
	@Autowired
	UserService userService;
	
 @RequestMapping(value = "/generatepdf", method = RequestMethod.GET)
 ModelAndView generatePdf(HttpServletRequest request,
   HttpServletResponse response , @ModelAttribute("UserOBJ") User user) throws Exception {
  
	 
	 
	 List<Transactions> transactions = userService.getTransactions(user.getAccountnumber());
	 
  ModelAndView mav = new ModelAndView("pdfView");
  
  mav.addObject("user",user);
  mav.addObject("transactions",transactions);
  
  return mav;
 }
 
	@RequestMapping(value = "/exporttoexcel", method = RequestMethod.GET)
	public ModelAndView getExcel(@ModelAttribute("UserOBJ") User user) {
		
		List<Transactions> transactions = userService.getTransactions(user.getAccountnumber());
		
		
		return new ModelAndView("AnimalListExcel", "transactions", transactions);
	}

}








