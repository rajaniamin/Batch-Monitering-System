package com.masai.ui;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.CourseDAO;
import com.masai.dao.CourseDAOImpl;
import com.masai.dto.CourseDTO;
import com.masai.dto.CourseDTOImpl;
import com.masai.exception.NoRecordFound;
import com.masai.exception.SomewentWrong;

public class CheckCourseUI {
	public static void addCourseUI() {
	
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Name of the Course");
			String cname = sc.next();
			System.out.println("Enter the Course Fee");
			int cfee = sc.nextInt();
			
			CourseDTO cdto=new CourseDTOImpl(cname,cfee);
			
			CourseDAO cdao=new CourseDAOImpl();
			
			String res;
			
			try {
				res=cdao.addCourse(cdto);
				System.out.println(res);
			} catch (SomewentWrong e) {
				System.out.println(e.getMessage());
				// TODO: handle exception
			}
	 }
	public static void updateUI() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name of the Courseid");
		int cid = sc.nextInt();
		System.out.println("Enter Name of the Course");
		String cname = sc.next();
		System.out.println("Enter the Course Fee");
		int cfee = sc.nextInt();
		
		CourseDTO cdto=new CourseDTOImpl(cid,cname,cfee);
		CourseDAO cdao=new CourseDAOImpl();
		String res;
		try {
			res=cdao.updateCourseDetails(cdto);
			System.out.println(res);
			
		} catch (SomewentWrong e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		
		
	}
	
	public static void searchCourse() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name of the Course");
		String cname = sc.next();
		CourseDAO cdao=new CourseDAOImpl();
		try {
			List<CourseDTO> listC= cdao.searchCourse(cname);
			listC.forEach(System.out::println);
		} catch (SomewentWrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void viewList() {
		CourseDAO cdao=new CourseDAOImpl();
		try {
			List<CourseDTO> listC= cdao.getAllCourse();
			listC.forEach(System.out::println);
		} catch (SomewentWrong | NoRecordFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void deleteUI() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Name of the Course");
		String cname = sc.next();
		CourseDAO cdao=new CourseDAOImpl();
		
		try {
			cdao.deleteBatch(cname);
			System.out.println("Batch Deleted Sucesfully ");
		} catch (SomewentWrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void checkCourse() {
		
		
		Scanner sc=new Scanner(System.in);
		int choice =0;
		do {
			System.out.println("1. Add Course");
			System.out.println("2. Update Course");
			System.out.println("3. Search Course");
			System.out.println("4. View Course Details");
			System.out.println("5. Delete Course");
			System.out.println("0. Exit");
			
			choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				addCourseUI();
				break;
			case 2:
				updateUI();
				break;
			case 3:
				searchCourse();
				break;
			case 4:
				viewList();
				break;
			case 5:
				deleteUI();
				break;
			case 0:
				System.out.println("Exiting...");
				break;
				default:
					System.out.println("Wrong Input :(");
				   break;
				
			}
			
			
		}while(choice!=0);
	}
}
