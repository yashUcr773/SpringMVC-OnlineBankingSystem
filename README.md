Online Banking System
	* Introduction

		* This is a very basic attempt to make a working project using Spring MVC.
		* It is an Online Banking system with features like Register, Sign-in, Pay, Loan etc. and everything is connected with a Database to store and retrieve data permanently.
	* Software Used

		* Eclipse IDE : Eclipse IDE for java EE oxygen with maven and STS support.
		* Oracle : Oracle 11-g database.
		* SQL Developer : Used to view and Modify the database and tables easily.
		* Apache Tomcat v9: Used to create the server to run web-apps.
		* Java 8 : Java version 8 and JRE 1.8 were used.
	* Frequent Errors

		* Adding server to The Project : Right click on project -> properties -> project facets -> Run-time -> select the server -> apply and close.
		* Maven errors : Right click on project -> run as -> maven build... -> clean install.
		* Update maven : Right Click on project -> maven -> update maven -> select update snapshots -> apply.
		* 404 page not found : Right click the project -> Properties -> Deployment Assembly -> Add Maven dependencies if not already added -> Apply and close. 
	* Steps 

		* Create a basic maven web-app.
		* Add server to project.
		* connect the database.
		* create controllers, DAO and services.
		* add suitable mapping.
		* run.
	* SQL Scripts

		* User table
		* Account table
		* Transaction table
		* UIDAI table
	* Features

		* It provides a feature to locate a branch near view by taking in the city or state you are in.
		* Has a register page that allows you to signup and create an account(Savings or current).
		* Has a login page that will take you to your profile wherein you can use the services provided. Login is of two types : admin and user. where in you can sign-in by providing the username password account number and the captcha
		* User login has features like

			* Updation of basic details like first-name, last-name, email, dob, address, phone.
			* Viewing account details like account number type of account balance and date opened.
			* Transactions if any which can be sorted based on date, amount or the sender/ receiver. Moreover the user can also export the transactions to a PDF file or to MS-Excel.
			* Apply for various types of Loans like Home, Car, Gold, Personal etc. or to calculate the EMI if the Principle, Rate of Interest and Tenure is given.
		* Pay to some other user either by direct account transfer or via RTGS/ NEFT(charges applicable).
		* Add money by directly adding money into the account. This is an redundant feature just to simulate how the app would work if you added money by going to the bank or via ATM.
		* Linking of AADHAAR card and PAN card.
		* Checking if an IFSC code is valid or not.
		* Change password if the user does not feel secure.
	* Admin login has the features of a normal user as well as some extra features like

		* View all transactions
		* View all users
		* View all accounts 
		* Disable a user.
	* Points to note

		* The password is stored as MD5 encryption and not used anywhere as normal text.


