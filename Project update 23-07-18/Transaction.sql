drop table transaction;
CREATE TABLE transaction (
  transactionID int NOT NULL,
  sender int NOT NULL,
  reciever int NOT NULL,
  amount INT Default(0) NOT NULL,
  remark varchar(255) NULL,
  timestamp varchar(50) not null,
  dateoftransaction date NOT NULL,
  PRIMARY KEY (transactionID,sender,reciever)
  );
  
 
  
  
  insert into transaction values(1,1004,1,1000,'something','Sat Mar 28 10:22:02 IST 2017','28-03-2017');
  insert into transaction values(2,1004,2,2000,'nothing','Sat Mar 29 10:36:02 IST 2018','28-03-2017');
  insert into transaction values(3,1004,3,3000,'everything','Sat Mar 30 10:48:02 IST 2019','28-03-2017');
  
   select * from Transaction;
  
  
  
  