package com.masai.ui;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.FacultyDAOImpl;
import com.masai.dao.FacultyDao;
import com.masai.dto.FacultyDTO;
import com.masai.exception.NoRecordFound;
import com.masai.exception.SomewentWrong;

public class facultyLoginUI {
	
	
	public static void loginOp(FacultyDTO factulty) throws SomewentWrong {
		Scanner sc = new Scanner(System.in);
		int choice=0;
		do {
			System.out.println("1. To view what is assigned");
			System.out.println("2. Add Topics"); 
			System.out.println("0. Exit");
			
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				ViewFacultyUI.viewByFaculty(factulty.getFacultyId());
				break;
			case 0:
				System.out.println("Exiting...");
				break;
				default:
					System.out.println("Invalid Input :(");
					break;
			}
		}while(choice!=0);
		
	}
	
	
	
	public static void login() {
		FacultyDTO faculty = null;
		
		
		Scanner sc= new Scanner(System.in);
		int i=4;
		for(; i>=0; i--) {
			System.out.println("Please Enter the Username");
			String uname = sc.next();
			
			System.out.println("Please Enter the Password");
			String pass = sc.next();
			
			FacultyDao dao = new FacultyDAOImpl();
			
			try {
				faculty = dao.loginFaculty(uname, pass);
				if(faculty == null) {
					
				}else {				
					System.out.println();
					System.out.println(" Welcome "+faculty.getFname()+" ");
					System.out.println();
					loginOp(faculty);
					return;
				}
		 	
			}catch (SomewentWrong e) {
                 // System.out.println(e.getMessage());
				System.out.println("Only "+i+" Attempts Left!!!");
				System.out.println();
				int choice=0;
				do {
					
					System.out.println("1. Want to try again?");
					System.out.println("0. Exit");
					
					 choice = sc.nextInt();
	               switch(choice) {
	               
	               case 1:
	            	   break;
	               case 0:
	            	   System.out.println("Existing...");
	            	   break;
	            	   default:
	            		   System.out.println("Invalid input :(");
	            		   break;
	               }
					
				}while(choice!=0);
				
			}
		}
	
		System.out.println("Try After Sometime");
		
	}
	

}
