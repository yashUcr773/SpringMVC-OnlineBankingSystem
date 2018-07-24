package com.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.Account;
import com.springmvc.model.IFSC;
import com.springmvc.model.Money;
import com.springmvc.model.Neft;
import com.springmvc.model.Pay;
import com.springmvc.model.User;
import com.springmvc.service.UserService;

@Controller
@SessionAttributes("UserOBJ")
public class PaymentController {
	
	  @Autowired
	  UserService userService;
	  
	  @RequestMapping(value = "/pay", method = RequestMethod.GET)
	  public ModelAndView paymentForm(HttpServletRequest request, HttpServletResponse response,
	   @ModelAttribute("UserOBJ") User user) {

		  Pay pay = new Pay();
		  ModelAndView mav = new ModelAndView("pay");
		  long millis=System.currentTimeMillis();
		  pay.setSender(user.getAccountnumber());
		  pay.setDate(String.valueOf(new java.sql.Date(millis)));
		  pay.setTimestamp(String.valueOf(java.util.Calendar.getInstance().getTime()));
		  
		  
		  mav.addObject("pay" , pay);
		  
		  
		  
		  return mav;
	  }
	  
	  @RequestMapping(value = "/payProcess", method = RequestMethod.POST)
	  public ModelAndView payProcess(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute("pay") Pay pay , @ModelAttribute("UserOBJ") User user) {
		  
		  
		  Boolean recieverExists = userService.isExists(pay.getRecipient());
		  
		  Boolean enoughBalance = userService.hasBalance(pay.getAmount(),pay.getSender());
		  
		
		  if(pay.getSender()==pay.getRecipient())
		  {
			  return new ModelAndView("paymentFailure" , "message" , "Can't Send Money to yourself");  
		  }
		  else if(recieverExists && enoughBalance)
		  {
			  
			  Account a = userService.populateAccount(user);
			  int newBalance=a.getBalance()-pay.getAmount();
			  
			  
			  userService.addTransaction(pay);
			  userService.executeTransaction(pay);
			  ModelAndView mav =  new ModelAndView("paymentSuccessful");
			  
			  mav.addObject("amount" , pay.getAmount());
			  mav.addObject("reciever" , pay.getRecipient());
			  mav.addObject("remark" , pay.getRemark());
			  
			  mav.addObject("newBalance" , newBalance);
			  
			  return mav;
		  }
		  else if(recieverExists && !enoughBalance)
		  {
			  
			  return new ModelAndView("paymentFailure" , "message" , "Not Enough Balance");
		  }
		  else if(!recieverExists && enoughBalance)
		  {
			  return new ModelAndView("paymentFailure" , "message" , "No such Account Number Exists, Please Verify");
		  }
		  else
		  {
			  return new ModelAndView("paymentFailure" , "message" , "Some internal Error Occured,Try Again Later");
		  }
		 
	  }
	  @RequestMapping(value = "/addmoney", method = RequestMethod.GET)
	  public ModelAndView addMoney(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute("money") Money money) {
		  
		  return new ModelAndView("addmoney");
	  }
	  
	  @RequestMapping(value = "/addmoneyprocess", method = RequestMethod.POST)
	  public ModelAndView addMoneyProcess(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute("money") Money money , @ModelAttribute("UserOBJ") User user) {
		  
		  
		  
		  Boolean ifExists = userService.isExists(user.getAccountnumber());
		  
		  if(ifExists)
		  {
			  
			  Pay pay = new Pay();
			  
			  
			  pay.setAmount(money.getAmount());
			  long millis=System.currentTimeMillis();
			  pay.setSender(user.getAccountnumber());
			  pay.setDate(String.valueOf(new java.sql.Date(millis)));
			  pay.setTimestamp(String.valueOf(java.util.Calendar.getInstance().getTime()));
			  pay.setRecipient(user.getAccountnumber());
			  pay.setRemark("Self Balance Added");
			  pay.setSender(user.getAccountnumber());
			  
			  userService.addTransaction(pay);
			  userService.executeTransaction(pay);
			  
			  return new ModelAndView("addmoney" , "message" , "Amount Added Successfully");
		  }
		  else
		  {
			  return new ModelAndView("addmoney" , "message" , "Internal Error Occured, Try Again Later");
		  }
		  
		  
	  }
	  
	  @RequestMapping(value = "/payvianeftrtgs", method = RequestMethod.GET)
	  public ModelAndView NEFT(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute("neft") Neft neft,@ModelAttribute("UserOBJ") User user) {
		  
		  ModelAndView mav=  new ModelAndView("payvianeftrtgs");
		  neft.setSendernumber(user.getAccountnumber());
		  neft.setSendername(user.getFirstname() + " " + user.getLastname());
		  neft.setSenderphone(user.getPhone());
		  
		   long millis=System.currentTimeMillis();  
		   java.sql.Date date=new java.sql.Date(millis);  
		   java.util.Date timestamp=java.util.Calendar.getInstance().getTime(); 
		  
		   neft.setDate(String.valueOf(date));
		   neft.setTimestamp(String.valueOf(timestamp));
		   
		   mav.addObject("neft",neft);
		   
		   
		  
		  return mav;
	  }
	  
	  @RequestMapping(value = "/payvianeftrtgsProcess", method = RequestMethod.POST,params = "validate")
	  public ModelAndView NEFTProcessValidate(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute("neft") Neft neft) {
		  
		  ModelAndView mav=  new ModelAndView("payvianeftrtgs");
		  
		  
			List<IFSC> ifsc = userService.searchBankbyCity(neft.getRecieverifsc().toUpperCase());
			if(ifsc.size()==0)
			{
				mav.addObject("message","Please Enter a valid IFSC");
			}
			else
			{
				mav.addObject("message","show");
				mav.addObject("ifsc",ifsc);
			}
		  return mav;
	  }
	  
	  @RequestMapping(value = "/payvianeftrtgsProcess", method = RequestMethod.POST,params = "pay")
	  public ModelAndView NEFTProcessPay(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			  @ModelAttribute("neft") Neft neft , @ModelAttribute("UserOBJ") User u) {
		  
		  ModelAndView mav=  new ModelAndView("payvianeftrtgs");
		  
		  
			List<IFSC> ifsc = userService.searchBankbyCity(neft.getRecieverifsc().toUpperCase());
			if(ifsc.size()==0)
			{
				mav.addObject("message","Please Enter a valid IFSC");
			}
			else
			{	
				
				mav.addObject("message","show");
				mav.addObject("ifsc",ifsc);
				
				Pay pay = new Pay();
				pay.setAmount(neft.getAmount());
				pay.setDate(neft.getDate());
				pay.setRecipient(neft.getRecipientnumber());
				pay.setSender(neft.getSendernumber());
				pay.setTimestamp(neft.getTimestamp());
				
				String temp = "NEFT/RTGS TXN ID = " +neft.getTransactionID() + " IFSC = " + neft.getRecieverifsc(); 
				pay.setRemark(neft.getRemark() + " "  + temp);
				
				
				Boolean recieverExists = userService.isExists(pay.getRecipient()); 
				Boolean enoughBalance = userService.hasBalance(pay.getAmount(),pay.getSender());
				  
				
				  if(pay.getSender()==pay.getRecipient())
				  {
					  return new ModelAndView("paymentFailure" , "message" , "Can't Send Money to yourself");  
				  }
				  else if(recieverExists && enoughBalance)
				  {
					  
					  Account a = userService.populateAccount(u);
					  int newBalance=a.getBalance()-pay.getAmount();
					  
					  
					  userService.addTransaction(pay);
					  userService.executeTransaction(pay);
					  ModelAndView mav2 =  new ModelAndView("paymentSuccessful");
					  
					  mav2.addObject("amount" , pay.getAmount());
					  mav2.addObject("reciever" , pay.getRecipient());
					  mav2.addObject("remark" , pay.getRemark());
					  
					  mav2.addObject("newBalance" , newBalance);
					  
					  return mav2;
				  }
				  else if(recieverExists && !enoughBalance)
				  {
					  
					  return new ModelAndView("paymentFailure" , "message" , "Not Enough Balance");
				  }
				  else if(!recieverExists && enoughBalance)
				  {
					  return new ModelAndView("paymentFailure" , "message" , "No such Account Number Exists, Please Verify");
				  }
				  else
				  {
					  return new ModelAndView("paymentFailure" , "message" , "Some internal Error Occured,Try Again Later");
				  }
			}
			
		  return mav;
	  }
	  
	  
	  
		 
}