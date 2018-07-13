package com.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.Temp;

@Controller
public class TempController {
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
	
	  @RequestMapping(value = "/temp", method = RequestMethod.GET)
	  public ModelAndView Temp(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("temp") Temp temp) {
	    ModelAndView mav = new ModelAndView("temp");
	    return mav;
	  }
	  
	  @RequestMapping(value = "/tempProcess", method = RequestMethod.POST)
	  public ModelAndView TempProcess(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("temp") Temp temp) {
	    ModelAndView mav = new ModelAndView("temp");
	    /*
	    Map<String, String> countries = new LinkedHashMap<String, String>();
	    countries.put("US", "US");
	    countries.put("IN", "India");
	    countries.put("ZN", "China");
	    */
	    
	    ArrayList<String> countries = new ArrayList<>();
	    
	    countries.add("US");
	    countries.add("UK");
	    countries.add("India");
	    countries.add("China");
	    
	    mav.addObject("countries",countries);
	    
	    temp.display();
	    return mav;
	  }

}
