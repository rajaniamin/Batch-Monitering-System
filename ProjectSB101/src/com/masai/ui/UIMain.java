package com.masai.ui;

import java.util.Scanner;

import com.masai.dao.FacultyDAOImpl;
import com.masai.dao.FacultyDao;
import com.masai.dao.LoggedINUser;
import com.masai.exception.NoRecordFound;
import com.masai.exception.SomewentWrong;

public class UIMain {
	
	public static void displayAdminMenu() {
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		System.out.println("1. Check Courses");
		System.out.println("2. Check Faculty");
		System.out.println("3. Check Batch");
		System.out.println("4. Check Course Plan");
		System.out.println("5. Log Out");
		System.out.println("0. Exit");
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");

	}
	
	public static void adminMenu(Scanner sc) throws NoRecordFound {
		int choice =0;
		
		do {
			displayAdminMenu();
			choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				CheckCourseUI.checkCourse();
				break;
			case 2:
				facultyLoginUI.login();
				break;
			case 3:BatchUI.batchOp();
				
				break;
			case 4:
				CheckCourseUI.viewList();
				break;
			case 5:
				System.out.println("Logging Off...");
				break;
			case 0:
				break;
				default:
					System.out.println("Wrong Input :(");
			
			}
		}while(choice != 0);
	}
	
	public static void adminLogin(Scanner sc) throws NoRecordFound {
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");

		System.out.print("Please enter your username");
		String username = sc.next();
		System.out.print("Please enter your password");
		String password = sc.next();
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");

		
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
			adminMenu(sc);
			System.out.println("Admin Account Logged in Succesfully :D");
		}else {
			System.out.println("Invalid Username and Password");
		}
	}
	
public static void main(String[] args) throws NoRecordFound {
	Scanner sc=new Scanner(System.in);
	
	int choice=0;
	
	do {
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");

		System.out.println("Press 1 to Login Admin Account");
		System.out.println("Press 2 to Login Faculty Account");
		System.out.println("Press 0 to Exit");
		System.out.println("Please enter your selection here");
		
		
		choice=sc.nextInt();
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		switch(choice) {
		case 1:
			adminLogin(sc);
			break;
		case 2:
			facultyLoginUI.login();
			break;
		case 0:
			System.out.println("Exting... \n Please Vist again :)");
		}
		
	}while(choice!=0);
	sc.close();
}
}
