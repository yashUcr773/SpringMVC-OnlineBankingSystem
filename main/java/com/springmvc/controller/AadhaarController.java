package com.springmvc.controller;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.UIDAI;
import com.springmvc.model.User;
import com.springmvc.service.UserService;

@Controller
@SessionAttributes("UserOBJ")
public class AadhaarController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "linkaadhaar" , method = RequestMethod.GET)
	public ModelAndView LinkAadhaar(HttpServletRequest request, HttpServletResponse resonse,
			@ModelAttribute("UIDAI") UIDAI uidai,@ModelAttribute("UserOBJ") User user){
		ModelAndView mav = new ModelAndView("linkaadhaar");

		uidai=userService.getUidaiAccount(user.getAccountnumber());
		
		
		
		
		if(uidai==null)
		{
			uidai=new UIDAI();
			uidai.setAccountnumber(user.getAccountnumber());
			uidai.setPan(null);
			uidai.setAadhaar(null);
		}
		
		mav.addObject("UIDAI", uidai);
		
		if(uidai.getAadhaar()!=null)
		{
			mav.addObject("alreadyupdated","Aadhaar Already Linked");
		}
		
		return mav;
	}
	
	
	@RequestMapping(value = "linkAadhaarProcess" , method = RequestMethod.POST)
	public ModelAndView LinkAadhaarProcess(HttpServletRequest request, HttpServletResponse resonse,
			@ModelAttribute("UIDAI") UIDAI uidai,@ModelAttribute("UserOBJ") User user){
		
		
		
		ModelAndView mav = new ModelAndView("linkaadhaar");
		
		
		if(Pattern.matches("^\\d{4}\\s\\d{4}\\s\\d{4}$",uidai.getAadhaar()) || 
				Pattern.matches("^\\d{4}\\d{4}\\d{4}$", uidai.getAadhaar()))
		{
			userService.updateAadhaar(uidai);
			mav.addObject("Message","Updated Successfully");
		}
		else
		{
			mav.addObject("Message","Not Valid Aadhaar");
		}	
			
		mav.addObject("UIDAI",uidai);
		return mav;
	}
	
	
	@RequestMapping(value = "linkpan" , method = RequestMethod.GET)
	public ModelAndView LinkPan(HttpServletRequest request, HttpServletResponse resonse,
			@ModelAttribute("UIDAI") UIDAI uidai,@ModelAttribute("UserOBJ") User user){
		ModelAndView mav = new ModelAndView("linkpan");

		uidai=userService.getUidaiAccount(user.getAccountnumber());
		
		if(uidai==null)
		{
			uidai=new UIDAI();
			uidai.setAccountnumber(user.getAccountnumber());
			uidai.setPan(null);
			uidai.setAadhaar(null);
		}
		
		mav.addObject("UIDAI", uidai);
		if(uidai.getPan()!=null)
		{
			mav.addObject("alreadyupdated","PAN Already Linked");
		}
		return mav;
	}
	
	
	@RequestMapping(value = "linkPanProcess" , method = RequestMethod.POST)
	public ModelAndView LinkPanProcess(HttpServletRequest request, HttpServletResponse resonse,
			@ModelAttribute("UIDAI") UIDAI uidai,@ModelAttribute("UserOBJ") User user){
		
		
		ModelAndView mav = new ModelAndView("linkpan");
		
		
		if(Pattern.matches("[A-Za-z]{5}\\d{4}[A-Za-z]{1}",uidai.getPan()))
		{
			userService.updatePan(uidai);
			mav.addObject("Message","Updated Successfully");
		}
		else
		{
			mav.addObject("Message","Not Valid PAN");
		}	
			
		mav.addObject("UIDAI",uidai);
		return mav;
	}

}
