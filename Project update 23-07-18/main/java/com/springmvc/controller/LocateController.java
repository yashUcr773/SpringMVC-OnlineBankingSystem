package com.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.IFSC;
import com.springmvc.model.Searchbycode;
import com.springmvc.model.Locate;
import com.springmvc.service.UserService;

@Controller
public class LocateController {

	@Autowired
	UserService userService;
	
	
	@RequestMapping(value = "/locate" , method=RequestMethod.GET )
	ModelAndView locate(HttpServletRequest request , HttpServletResponse response,@ModelAttribute("locate") Locate locate)
	{
		ModelAndView mav = new ModelAndView("locate");
		
		
		
		return mav;
	}
	
	@RequestMapping(value = "/locateProcess" , method=RequestMethod.POST )
	ModelAndView locateProcess(HttpServletRequest request , HttpServletResponse response,@ModelAttribute("locate") Locate locate)
	{
		ModelAndView mav = new ModelAndView("viewbranches");
		
		locate.setCity(locate.getCity().toUpperCase());
		locate.setState(locate.getState().toUpperCase());
		List<IFSC> ifsc = userService.searchBankbyCity(locate);
	
		mav.addObject("ifsc",ifsc);
		
		
		
		return mav;
	}
	
	@RequestMapping(value = "/bankifsc" , method=RequestMethod.GET )
	ModelAndView viewbranches(HttpServletRequest request , HttpServletResponse response,@ModelAttribute("searchbycode") Searchbycode ifscode)
	{
		ModelAndView mav = new ModelAndView("bankifsc");
		
		System.out.println(ifscode.getCode());
		
		return mav;
	}
	
	@RequestMapping(value = "/bankifscProcess" , method=RequestMethod.POST )
	ModelAndView viewBranchProcess(HttpServletRequest request , HttpServletResponse response,@ModelAttribute("searchbycode") Searchbycode ifscode)
	{
		ModelAndView mav = new ModelAndView("viewbranches");
		
		
		ifscode.setCode(ifscode.getCode().toUpperCase());
		List<IFSC> ifsc = userService.searchBankbyCity(ifscode.getCode());
		
		mav.addObject("ifsc",ifsc);
		mav.addObject("ShowAll","true");
		return mav;
	}
	
	
}
