package com.springmvc.controller;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TempController{

	@RequestMapping(value = "/temp" , method = RequestMethod.GET)
	public ModelAndView Temp(HttpServletRequest request, HttpServletResponse resonse){
		
		ModelAndView mav = new ModelAndView("temp");
		return mav;
	}

}
