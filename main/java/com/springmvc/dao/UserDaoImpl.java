package com.springmvc.dao;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springmvc.model.Account;
import com.springmvc.model.IFSC;
import com.springmvc.model.Locate;
import com.springmvc.model.Login;
import com.springmvc.model.Pay;
import com.springmvc.model.Transactions;
import com.springmvc.model.UIDAI;
import com.springmvc.model.User;
public class UserDaoImpl implements UserDao {
  @Autowired
  DataSource datasource;
  @Autowired
  JdbcTemplate jdbcTemplate;
  
  
  public void register(User user) {
    String sql = "insert into users(username,password,ACCOUNTNUMBER,EMAIL,FIRSTNAME,LASTNAME,ADDRESS,PHONE,ACCOUNTTYPE,DOB) values(?,?,?,?,?,?,?,?,?,?)";
    jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(),user.getAccountnumber(),user.getEmail(),user.getFirstname(), user.getLastname(),user.getAddress(),user.getPhone(),"user",user.getDateofbirth()});
    }
  
  public void createAccount(User user)
  {
	    long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis);  
	    java.util.Date timestamp=java.util.Calendar.getInstance().getTime(); 
	    
	  String sql = "insert into account values(?,?,?,?,?)";
	  jdbcTemplate.update(sql, new Object[] { user.getAccountnumber(), user.getAccounttype(),0 ,timestamp ,date});
  }
  
  
  public Account populateAccount(User user) {
  String sql = "select * from Account where accountnumber=" + user.getAccountnumber();
  List<Account> account = jdbcTemplate.query(sql, new AccountMapper());
  return account.size() > 0 ? account.get(0) : null;
  }
  
  public List<Transactions> getTransactions(int accnumber) {
  String sql = "select * from transaction where sender = " + accnumber + " or reciever = " + accnumber;
  List<Transactions> transactions = jdbcTemplate.query(sql, new TransactionMapper());
  return transactions;
  }


  public void changepass(User user)
  {
	    String sql = "update users " + 
	    		  " set " +
	    	   " password = '" + user.getPassword() + "' "+ 
	    	   " where USERNAME = '" + user.getUsername()+ "'" ;
	    
	    	jdbcTemplate.update(sql);
  }
  
  public Boolean isExists(int accnumber)
  {
	  String sql = "select * from Account where accountnumber=" + accnumber;
	  List<Account> account = jdbcTemplate.query(sql, new AccountMapper());
	  return account.size() > 0 ? true : false;
  }
  
  
  public Boolean hasBalance(int amount,int accnumber)
  {
	  String sql = "select * from Account where accountnumber=" + accnumber;
	  List<Account> account = jdbcTemplate.query(sql, new AccountMapper());
	  
	  if(account.get(0).getBalance()>=amount)
		  return true;
	  else
		  return false;
  }
  
  public void executeTransaction(Pay pay)
  {
	  String sql = "select * from Account where accountnumber=" + pay.getSender();
	  List<Account> account = jdbcTemplate.query(sql, new AccountMapper());
	  
	  Account sender = account.get(0);
	  
	  String sql2 = "select * from Account where accountnumber=" + pay.getRecipient();
	  List<Account> account2 = jdbcTemplate.query(sql2, new AccountMapper());
	  
	  Account reciever = account2.get(0);
	  
	  int newBalance = sender.getBalance()-pay.getAmount();
	  String sql3 = "update account " + " set " + " balance = " + newBalance + ""+
    	   " where accountnumber = " + sender.getNumber()+ "" ;
    	jdbcTemplate.update(sql3);
	  
  	  int newBalance2 = reciever.getBalance()+pay.getAmount();
  	  String sql4 = "update account " + " set " + " balance = " + newBalance2 + ""+
      	   " where accountnumber = " + reciever.getNumber()+ "" ;
      	jdbcTemplate.update(sql4);
	  
  }
  
  
  public void addTransaction(Pay pay) {
	  
	  String sql = "select * from transaction where sender = " + pay.getSender();
	  List<Transactions> transactions = jdbcTemplate.query(sql, new TransactionMapper());
	  
	  
	    String sql2 = "insert into Transaction values(?,?,?,?,?,?,?)";
	    jdbcTemplate.update(sql2, new Object[] {transactions.size()+1, pay.getSender(), pay.getRecipient(),pay.getAmount(),pay.getRemark(),pay.getTimestamp(),Date.valueOf(pay.getDate())});
	      
  }
  
  
  
  public void update(User user) {
	    String sql = "update users " + 
	    		  " set " +
	    	   " firstname = '" + user.getFirstname() + "' ,"+
	    	   " lastname ='" + user.getLastname() + "' ,"+
	    	   " email = '" + user.getEmail() + "' ,"+
	    	   " address = '"+ user.getAddress() + "' ,"+
	    	   " phone = " + user.getPhone() +
	    	   " where USERNAME = '" + user.getUsername()+ "'" ;
	    
	    	jdbcTemplate.update(sql);
	    }
  
  	
    public List<User> returnAllUsers()
    {
    	String sql = "select * from users";
    	List<User> users = jdbcTemplate.query(sql, new UserMapper());
    	return users;
    }
    public List<Account> returnAllAccounts()
    {
    	String sql = "select * from account";
    	List<Account> account = jdbcTemplate.query(sql, new AccountMapper());
    	return account;
    }
    public List<Transactions> returnAllTransactions()
    {
    	String sql = "select * from transaction";
    	List<Transactions> transaction = jdbcTemplate.query(sql, new TransactionMapper());
    	return transaction;
    }
  
    public User validateUser(Login login) {
    String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
    + "' and accountnumber=" + login.getAccountnumber() ;
    List<User> users = jdbcTemplate.query(sql, new UserMapper());
    return users.size() > 0 ? users.get(0) : null;
    }
    
    
    
    public UIDAI getUidaiAccount(int accnum) {
    String sql = "select * from UIDAI where accountnumber=" + accnum;
    List<UIDAI> uidai = jdbcTemplate.query(sql, new UIDAIMapper());
    return uidai.size() > 0 ? uidai.get(0) : null;
    }

	@Override
	public void updateAadhaar(UIDAI uidai) {
	    
		UIDAI temp=getUidaiAccount(uidai.getAccountnumber());
		
		if(temp==null)
		{
			String sql = "insert into UIDAI values(?,?,?)";
		    jdbcTemplate.update(sql, new Object[] {uidai.getAccountnumber(),uidai.getAadhaar(),uidai.getPan()});
		     
		}
		else
		{
		String sql = "update UIDAI " + 
	    		  " set " +
	    	   " aadhaarnumber ='" + uidai.getAadhaar() + "' ,"+
	    	   " pannumber = '" + uidai.getPan() + "'"+
	    	   " where accountnumber = " + uidai.getAccountnumber() ;
	    
	    	jdbcTemplate.update(sql);
		}
	}
	
	public List<IFSC> searchBankbyCity(Locate locate)
	{
		String sql="Select * from IFSC where city = '" + locate.getCity() + "' or state = '" + locate.getState() +"'";
		List<IFSC> ifsc = jdbcTemplate.query(sql,new IFSCMapper());
		return ifsc;
	}
	public List<IFSC> searchBankbyCity(String code)
	{
		String sql="Select * from IFSC where code = '" + code +"'";
		List<IFSC> ifsc = jdbcTemplate.query(sql,new IFSCMapper());
		return ifsc;
	}
	
	public void updatePan(UIDAI uidai) {
	    
		UIDAI temp=getUidaiAccount(uidai.getAccountnumber());
		
		if(temp==null)
		{
			String sql = "insert into UIDAI values(?,?,?)";
		    jdbcTemplate.update(sql, new Object[] {uidai.getAccountnumber(),uidai.getAadhaar(),uidai.getPan()});
		     
		}
		else
		{
		String sql = "update UIDAI " + 
	    		  " set " +
	    	   " aadhaarnumber ='" + uidai.getAadhaar() + "' ,"+
	    	   " pannumber = '" + uidai.getPan() + "'"+
	    	   " where accountnumber = " + uidai.getAccountnumber() ;
	    
	    	jdbcTemplate.update(sql);
		}
	}
  }

class TransactionMapper implements RowMapper<Transactions> {
public Transactions mapRow(ResultSet rs, int arg1) throws SQLException {
  Transactions transactions = new Transactions();
  
  transactions.setTransactionID(rs.getInt("transactionID"));
  transactions.setSender(rs.getInt("sender"));
  transactions.setRecipient(rs.getInt("reciever"));
  transactions.setAmount(rs.getInt("amount"));
  transactions.setRemark(rs.getString("remark"));
  transactions.setTimestamp(rs.getString("timestamp"));
  transactions.setDate(String.valueOf(rs.getDate("dateoftransaction")));
  return transactions;
	}
}
  class UserMapper implements RowMapper<User> {
  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();
    user.setUsername(rs.getString("username"));
    user.setPassword(rs.getString("password"));
    user.setFirstname(rs.getString("firstname"));
    user.setLastname(rs.getString("lastname"));
    user.setEmail(rs.getString("email"));
    user.setAddress(rs.getString("address"));
    user.setPhone(rs.getString("phone"));
    user.setAccountnumber(rs.getInt("accountnumber"));
    user.setAccounttype(rs.getString("accounttype"));
    user.setDateofbirth(rs.getString("dob"));
    
    return user;
  }
}
  class AccountMapper implements RowMapper<Account> {
  public Account mapRow(ResultSet rs, int arg1) throws SQLException {
    Account account = new Account();
    
    
    account.setNumber(rs.getInt("accountnumber"));
    account.setType(rs.getString("accounttype"));
    account.setBalance(rs.getInt("balance"));
    account.setTimestamp(rs.getString("timestamp"));
    account.setDate(rs.getDate("dateopened"));
    return account;
  	}
 } 
  class IFSCMapper implements RowMapper<IFSC> {
	  public IFSC mapRow(ResultSet rs, int arg1) throws SQLException {
	    IFSC ifsc = new IFSC();
	    
	    
	    ifsc.setAddress(rs.getString("ADDRESS"));
	    ifsc.setBranch(rs.getString("BRANCH"));
	    ifsc.setCity(rs.getString("CITY"));
	    ifsc.setCode(rs.getString("CODE"));
	    ifsc.setContact(rs.getString("CONTACT"));
	    ifsc.setDistrict(rs.getString("DISTRICT"));
	    ifsc.setName(rs.getString("NAME"));
	    ifsc.setRtgs(rs.getString("RTGS"));
	    ifsc.setState(rs.getString("STATE"));
	    
	    
	    return ifsc;
	  	}
	  }
  class UIDAIMapper implements RowMapper<UIDAI> {
  public UIDAI mapRow(ResultSet rs, int arg1) throws SQLException {
    UIDAI uidai = new UIDAI();
    
    
    uidai.setAccountnumber(rs.getInt("accountnumber"));
    uidai.setAadhaar(rs.getString("aadhaarnumber"));
    uidai.setPan(rs.getString("pannumber"));
    return uidai;
  	}
  }
  