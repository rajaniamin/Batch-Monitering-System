package com.masai.ui;

import java.util.Scanner;

import com.masai.dao.FacultyDAOImpl;
import com.masai.dao.FacultyDao;
import com.masai.exception.NoRecordFound;
import com.masai.exception.SomewentWrong;

public class UIMain {
	public static void facultyLogin(Scanner sc) {
		facultyLoginUI fui=new facultyLoginUI();
		if(!fui.login()) return;
		//System.out.println("HIII");
		
		int choice=0;
		
		do {
			System.out.println("Please enter your Faculty id to check the assiged bactch for you :D ");
		     choice =sc.nextInt();
			FacultyDao facDao=new FacultyDAOImpl();
			try {
				
				facDao.searchByModleNo(choice);
				System.out.println("hii");
			} catch (SomewentWrong | NoRecordFound e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}while(choice!=0);
		
		}
	
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	
	int choice=0;
	
	do {
		System.out.println("Press 1 to Login Admin Account");
		System.out.println("Press 2 to Login Faculty Account");
		System.out.println("Press 0 to Exit");
		System.out.println("Please enter your selection here");
		
		choice=sc.nextInt();
		switch(choice) {
		case 1:
			break;
		case 2:
			facultyLogin(sc);
			break;
		case 0:
			System.out.println("Exting... \n Please Vist again :)");
		}
		
	}while(choice!=0);
	sc.close();
}
}
