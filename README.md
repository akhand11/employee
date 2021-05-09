# employee


You are required to create a Console application which will handle a Employee Registration System.

The sytem will consist of 4 basic funnctionlaity 1.ADD Employee 2.UPDATE Employee 3.GET Employee Details 4. DELETE Employee

the Employee class will contain the follwoing details.

empId Long;
empName String;
empAge Integer;
empAddress String;


The details of the employee object will be stored in a List of Employees and will be populated at the run time.

Details of functionality:

1 ADD:
	When user enters the option to add the sytem will prompt for the Employee Name, Age and Address upon entering the details one after the other yoou will store the details in the List of the Employees.The Employee ID will be assigned based on the logic -> (10125+lastIndex+1)
	
2 UPDATE:
	The Update option will ask for the user to enter the EmployeeID and when valid employee ID has been provided it will ask for which details to update.Based on the input ->"NAME","AGE","ADDR"
3 DELETE:
	This option will take ID as the input and delete after confirmation
4. GET:
	i.if user calls get with out any argument it will return all the employees in the List
	ii.if user provides: GET <ID> then it will display the employee details with that ID
	  for ex:
	  GET 1
	  
	  empID      empName    empAge    empAddress
	  10126		   RONIN	  24		KOLKATA
	  
	  
Note: Any Exception that happens in the system will have to be handled and will return the user to the with a Option to go back to main screen or terminate.

