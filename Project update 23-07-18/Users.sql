drop table users;
CREATE TABLE USERS (
  username VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  accountnumber INT NOT NULL unique,
  email VARCHAR(45) NOT NULL,
  firstname VARCHAR(45) NOT NULL,
  lastname VARCHAR(45) NULL,
  address VARCHAR(45) NULL,
  phone varchar(15) Not NULL,
  accounttype VARCHAR(45) DEFAULT(User) NOT NULL,
  dob varchar(45) not null,
  PRIMARY KEY (username,accountnumber,email));
  
  insert into users(username,password,ACCOUNTNUMBER,EMAIL,FIRSTNAME,LASTNAME,ADDRESS,PHONE,accountTYPE,DOB) 
    values('admin1','admin1',1,'yg3752@gmail.com','Admin 1','Yash','abc',123,'Admin','17-07-1997');
  insert into users values('admin2','admin2',2,'zebashaheen896@gmail.com','Admin 2','Zeba','def',456,'Admin','21-04-1998');
  insert into users values('admin3','admin3',3,'xyz@gmail.com','Admin 3','Third Admin','ghi',789,'Admin','20-09-1997');
  
  select * from users;
  
  
  
  