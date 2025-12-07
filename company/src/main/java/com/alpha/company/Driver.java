package com.alpha.company;

import java.util.Scanner;

public class Driver { //The main class where the user runs the code
public static void main(String[] args) {
	Scanner sc =  new Scanner(System.in);
	EmployeeDao dao = new EmployeeDao();
	boolean flag=true;
	
	while(flag) {
		System.out.println("Choose the Correct Option");
		System.out.println("1.Insert Employee");
		System.out.println("2.Update Employee");
		System.out.println("3.Delete Employee");
		System.out.println("4.See All Employee");
		System.out.println("5.Exit");
		
		int choice = sc.nextInt();
		
		switch(choice) {
		
		case 1:{
			Employee e = new Employee(101,"HarshaVardhan",21,80000);
			dao.insertEmployee(e);
		}
		break;
		
		case 2:{
			System.out.println("Enter Id: ");
			int id = sc.nextInt();
			System.out.println("Enter new Sal: ");
			int newsal = sc.nextInt();
			dao.updateEmployee(id,newsal);
			
		}
		break;
		
		case 3 :{
			System.out.println("Enter id");
			int id = sc.nextInt();
			dao.deleteEmployee(id);
		}
		break;
		
		case 4 :{
			dao.viewEmployee();
		}
		break;
		
		case 5 : {
			flag =  false;
			System.out.println("Thank you for using my application");
		}
		break;
		
		default:{
			System.out.println("Inavlid Choice");
		}
		}
		
	}
}
}
