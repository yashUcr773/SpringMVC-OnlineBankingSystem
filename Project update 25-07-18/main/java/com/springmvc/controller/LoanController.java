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

import com.springmvc.model.Loan;
import com.springmvc.service.UserService;

@Controller
@SessionAttributes("UserOBJ")
public class LoanController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/applyforloan" , method = RequestMethod.GET)
	public ModelAndView ApplyLoan(HttpServletRequest request, HttpServletResponse resonse){
		
		ModelAndView mav = new ModelAndView("applyforloan");
		return mav;
	}
	
	@RequestMapping(value = "/homeloan" , method = RequestMethod.GET)
	public ModelAndView HomeLoan(HttpServletRequest request, HttpServletResponse resonse, @ModelAttribute("loan") Loan loan){
		
		ModelAndView mav = new ModelAndView("homeloan");
		return mav;
	}
	
	@RequestMapping(value = "/homeloanProcess" , method = RequestMethod.POST)
	public ModelAndView HomeLoanProcess(HttpServletRequest request, HttpServletResponse resonse, @ModelAttribute("loan") Loan loan){
		
		ModelAndView mav = new ModelAndView("homeloan");
		loan.setEmi();
		mav.addObject("loan",loan);
		if(loan.getTos()==null)
		{
			mav.addObject("message","Please accept the Terms of Service");
		}
		else
		{
			mav.addObject("message","Loan Sanction Process Started");
		}
		return mav;
	}
	
	@RequestMapping(value = "/loantos" , method = RequestMethod.GET)
	public ModelAndView LoanTOS(HttpServletRequest request, HttpServletResponse resonse, @ModelAttribute("loan") Loan loan){
		
		ModelAndView mav = new ModelAndView("loantos");
		return mav;
	}
	@RequestMapping(value = "/carloan" , method = RequestMethod.GET)
	public ModelAndView CarLoan(HttpServletRequest request, HttpServletResponse resonse, @ModelAttribute("loan") Loan loan){
		
		ModelAndView mav = new ModelAndView("carloan");
		return mav;
	}
	@RequestMapping(value = "/carloanProcess" , method = RequestMethod.POST)
	public ModelAndView CarLoanProcess(HttpServletRequest request, HttpServletResponse resonse, @ModelAttribute("loan") Loan loan){
		
		ModelAndView mav = new ModelAndView("carloan");
		loan.setEmi();
		mav.addObject("loan",loan);
		if(loan.getTos()==null)
		{
			mav.addObject("message","Please accept the Terms of Service");
		}
		else
		{
			mav.addObject("message","Loan Sanction Process Started");
		}
		return mav;
	}
	
	@RequestMapping(value = "/goldloan" , method = RequestMethod.GET)
	public ModelAndView GoldLoan(HttpServletRequest request, HttpServletResponse resonse, @ModelAttribute("loan") Loan loan){
		
		ModelAndView mav = new ModelAndView("goldloan");
		return mav;
	}
	@RequestMapping(value = "/goldloanProcess" , method = RequestMethod.POST)
	public ModelAndView goldLoanProcess(HttpServletRequest request, HttpServletResponse resonse, @ModelAttribute("loan") Loan loan){
		
		ModelAndView mav = new ModelAndView("goldloan");
		loan.setEmi();
		mav.addObject("loan",loan);
		if(loan.getTos()==null)
		{
			mav.addObject("message","Please accept the Terms of Service");
		}
		else
		{
			mav.addObject("message","Loan Sanction Process Started");
		}
		return mav;
	}
	
	@RequestMapping(value = "/personalloan" , method = RequestMethod.GET)
	public ModelAndView PersonalLoan(HttpServletRequest request, HttpServletResponse resonse, @ModelAttribute("loan") Loan loan){
		
		ModelAndView mav = new ModelAndView("personalloan");
		return mav;
	}
	@RequestMapping(value = "/personalloanProcess" , method = RequestMethod.POST)
	public ModelAndView PersonalLoanProcess(HttpServletRequest request, HttpServletResponse resonse, @ModelAttribute("loan") Loan loan){
		
		ModelAndView mav = new ModelAndView("personalloan");
		loan.setEmi();
		mav.addObject("loan",loan);
		if(loan.getTos()==null)
		{
			mav.addObject("message","Please accept the Terms of Service");
		}
		else
		{
			mav.addObject("message","Loan Sanction Process Started");
		}
		return mav;
	}
	
	@RequestMapping(value = "/emicalculator" , method = RequestMethod.GET)
	public ModelAndView EMICalculator(HttpServletRequest request, HttpServletResponse resonse, @ModelAttribute("loan") Loan loan){
		
		ModelAndView mav = new ModelAndView("emicalculator");
		return mav;
	}
	
	
	@RequestMapping(value = "/emicalculatorProcess" , method = RequestMethod.POST)
	public ModelAndView EMICalculatorProcess(HttpServletRequest request, HttpServletResponse resonse, @ModelAttribute("loan") Loan loan){
		
		ModelAndView mav = new ModelAndView("emicalculator");
		loan.setEmi();
		mav.addObject("loan",loan);
		mav.addObject("message","Loan Sanction Process Started");
		return mav;
	}
	

}
