package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Account;
import com.springmvc.model.IFSC;
import com.springmvc.model.Locate;
import com.springmvc.model.Login;
import com.springmvc.model.Pay;
import com.springmvc.model.Transactions;
import com.springmvc.model.UIDAI;
import com.springmvc.model.User;

public interface UserService {

  void register(User user);
  void update(User user);
  User validateUser(Login login);
  List<User> returnAllUsers();
  List<Account> returnAllAccounts();
  List<Transactions> returnAllTransactions();
  void createAccount(User user);
  Account populateAccount(User user);
  Boolean isExists(int accnumber);
  Boolean hasBalance(int amount,int accnumber);
  void executeTransaction(Pay pay);
  void addTransaction(Pay pay);
  List<Transactions> getTransactions(int accnumber);
  UIDAI getUidaiAccount(int accnum);
  void updateAadhaar(UIDAI uidai);
  void updatePan(UIDAI uidai);
  List<IFSC> searchBankbyCity(Locate locate);
  List<IFSC> searchBankbyCity(String code);
  void changepass(User user);
  void disableuser(int accnum);
  
  
}