package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.dao.UserDao;
import com.springmvc.model.Account;
import com.springmvc.model.IFSC;
import com.springmvc.model.Locate;
import com.springmvc.model.Login;
import com.springmvc.model.Pay;
import com.springmvc.model.Transactions;
import com.springmvc.model.UIDAI;
import com.springmvc.model.User;

public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;

  public void register(User user) {
    userDao.register(user);
  }
  
  public void update(User user) {
	    userDao.update(user);
	  }

  public User validateUser(Login login) {
    return userDao.validateUser(login);
  }

  public List<User> returnAllUsers()
  {
	  return userDao.returnAllUsers();
  }
  public List<Account> returnAllAccounts()
  {
	  return userDao.returnAllAccounts();
  }
  public List<Transactions> returnAllTransactions()
  {
	  return userDao.returnAllTransactions();
  }
  
  public void createAccount(User user) {
	    userDao.createAccount(user);
	  }
  
  public Account populateAccount(User user) {
	    return userDao.populateAccount(user);
	  }
  public Boolean isExists(int accnumber)
  {
	  return userDao.isExists(accnumber);
  }
  public Boolean hasBalance(int amount,int accnumber)
  {
	  return userDao.hasBalance(amount,accnumber);
  }
  
  public void executeTransaction(Pay pay)
  {
	  userDao.executeTransaction(pay);
  }
  public void addTransaction(Pay pay)
  {
	  userDao.addTransaction(pay);
  }
  
  public List<Transactions> getTransactions(int accnumber)
  {
	  return userDao.getTransactions(accnumber);
  }
  
  public UIDAI getUidaiAccount(int accnum)
  {
	  return userDao.getUidaiAccount(accnum);
  }
  
  public void updateAadhaar(UIDAI uidai)
  {
	  userDao.updateAadhaar(uidai);
  }
  public void updatePan(UIDAI uidai)
  {
	  userDao.updatePan(uidai);
  }
  
  public List<IFSC> searchBankbyCity(Locate locate)
  {
	  return userDao.searchBankbyCity(locate);
  }
  
  public List<IFSC> searchBankbyCity(String code)
  {
	 return userDao.searchBankbyCity(code);
  }
  
  public void changepass(User user)
  {
	  userDao.changepass(user);
  }
  
  public void disableuser(int accnum)
  {
	  userDao.disableuser(accnum);
  }
  
  public Boolean checkIfExists(User user)
  {
	  return userDao.checkIfExists(user);
  }

}