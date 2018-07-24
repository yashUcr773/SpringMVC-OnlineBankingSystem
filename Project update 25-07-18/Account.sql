drop table account;
CREATE TABLE account (
  accountnumber int NOT NULL,
  accounttype VARCHAR(45) Default('savings') NOT NULL,
  balance INT Default(0) NOT NULL,
  timestamp varchar(50) not null,
  dateopened date NOT NULL,
  PRIMARY KEY (accountnumber)
  );
 
  insert into account values(1,'savings',1200,'Thu Mar 26 08:22:02 IST 2015','26-03-2015');
  insert into account values(2,'current',500,'Fri Mar 27 09:22:02 IST 2016','27-03-2016');
  insert into account values(3,'savings',5000,'Sat Mar 28 10:22:02 IST 2017','28-03-2017');

    select * from account;
    
    