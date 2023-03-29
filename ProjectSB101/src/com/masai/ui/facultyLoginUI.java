package com.masai.ui;

import java.util.Scanner;

import com.masai.dao.FacultyDAOImpl;
import com.masai.dao.FacultyDao;
import com.masai.exception.NoRecordFound;
import com.masai.exception.SomewentWrong;

public class facultyLoginUI {
	Scanner sc=new Scanner(System.in);
	public boolean login() {
		boolean loginSuccessful = false;
		System.out.println("Please Enter your Username");
		String user=sc.next();
		System.out.println("Please the Password Now");
		String pass=sc.next();
		
		FacultyDao facDao= new FacultyDAOImpl();
		try {
			facDao.Login(user, pass);
			loginSuccessful=true;
		} catch (SomewentWrong | NoRecordFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return loginSuccessful;
		
		
	}
}
