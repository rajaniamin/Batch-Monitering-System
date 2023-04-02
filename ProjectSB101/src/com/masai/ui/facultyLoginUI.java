package com.masai.ui;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.masai.dao.DbUtils;
import com.masai.dao.FacultyDAOImpl;
import com.masai.dao.FacultyDao;
import com.masai.dto.FacultyDTO;
import com.masai.exception.NoRecordFound;
import com.masai.exception.SomewentWrong;

public class facultyLoginUI {
	
public static boolean forgetPass() {
		
		Scanner sc = new Scanner(System.in);
		Connection conn=null;
		try{
			
			conn=DbUtils.getConn();
			System.out.println("Enter Mobile No. : ");
			String mobile = sc.next();
			
			
			
			PreparedStatement ps = conn .prepareStatement("select * from faculty where mobile = ? ");
			ps.setString(1, mobile);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				FacultyDao dao = new FacultyDAOImpl();
					
				System.out.println("Enter New Password: ");
				String newPass = sc.next();
				
				
				System.out.println("Enter New Password Again : ");
				String newPass2 = sc.next();
				

				if(newPass.equals(newPass2)) {
					
					
					try {
						String res = dao.forgetPassword(mobile, newPass2);
						System.out.println();
						System.out.println(res);
						System.out.println();
						
					} catch (SomewentWrong e) {
						System.out.println();
						System.out.println( e.getMessage());
						System.out.println();
						return false;
					}
					
				}else {
					System.out.println();
					System.out.println("New Password Mismatch");
					System.out.println();
					return false;
				}
				
				
			}else {
				System.out.println();
				System.out.println("Mobile Number or Email Not Found");
				System.out.println();
				return false;
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println();
			System.out.println( e.getMessage());
			System.out.println();
			return false;
			
		}
		return true;
		
	}
	public static void loginOp(FacultyDTO factulty) throws SomewentWrong, NoRecordFound {
		Scanner sc = new Scanner(System.in);
		int choice=0;
		do {
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
			System.out.println("1. To view what is assigned");
			System.out.println("2. Add Topics"); 
			System.out.println("0. Exit");
			
			choice=sc.nextInt();
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
			switch(choice) {
			case 1:
				ViewFacultyUI.viewByFaculty(factulty.getFacultyId());
				break;
			case 2:
				ViewFacultyUI.addCoursePlanMtd();
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
public static void changePass(int facultyId) {
		
		Scanner sc = new Scanner(System.in);
		Connection conn=null;
		try{
			
			conn=DbUtils.getConn();
			System.out.println("Enter Old Password : ");
			String oldPass = sc.next();
			
			System.out.println("Enter New Password: ");
			String newPass = sc.next();
			
			System.out.println("Enter New Password : ");
			String newPass2 = sc.next();
			
			
			PreparedStatement ps = conn .prepareStatement("select * from faculty where facultyId = ? And password = ?");
			ps.setInt(1, facultyId);
			ps.setString(2, oldPass);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				
				if(newPass.equals(newPass2)) {
					
					FacultyDao dao = new FacultyDAOImpl();
					
					try {
						String res = dao.changePassword(facultyId, newPass2);
						System.out.println();
						System.out.println(res);
						System.out.println();
					} catch (SomewentWrong e) {
						
						System.out.println();
						System.out.println( e.getMessage());
						System.out.println();
					}
					
				}else {
					System.out.println();
					System.out.println("New Password is not Matching");
					System.out.println();
				}
				
			}else {
				System.out.println();
				System.out.println("Wrong Old Password");
				System.out.println();
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println();
			System.out.println( e.getMessage());
			System.out.println();
		}
		
	}
	
	
	public static void login() throws NoRecordFound {
		FacultyDTO faculty = null;
		
		
		Scanner sc= new Scanner(System.in);
		int i=4;
		for(; i>=0; i--) {
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
			System.out.println("Please Enter the Username");
			String uname = sc.next();
			
			System.out.println("Please Enter the Password");
			String pass = sc.next();
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
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
					System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
					System.out.println("1. Want to try again?");
					System.out.println("2. Forget Password");
					System.out.println("3. Change Password");
					System.out.println("0. Exit");
					
					 choice = sc.nextInt();
					 System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
	               switch(choice) {
	               
	               case 1:
	            	   break;
	               case 2:
	            	   forgetPass();
	            	   break;
	               case 3:
	            	   System.out.println("Enter the FActultyId");
	            	   int id=sc.nextInt();
	            	   changePass(id);
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
