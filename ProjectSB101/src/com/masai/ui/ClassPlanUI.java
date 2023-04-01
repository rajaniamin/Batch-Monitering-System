package com.masai.ui;

import java.util.Scanner;

import com.masai.dto.CourseDTO;
import com.masai.dto.CourseDTOImpl;

public class ClassPlanUI {
	
	public static void addCourceMtd() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Course Name");
		String cname = sc.next();
		
		System.out.println("Enter the Course Fee");
		int cfee = sc.nextInt();
		
		CourseDTO cdto=new CourseDTOImpl(cname,cfee);
	}
	
	
	
	public static void courseOptions() {
		Scanner sc = new Scanner(System.in);
		
		int choice=0;
		do {
			System.out.println("1. Add Course");
			System.out.println("2. Update Course");
			System.out.println("3. Search Course");
			System.out.println("4. Delete Course");
			System.out.println("0. Exit");
			
			choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 0:
				System.out.println("Exiting...");
				break;
				default:
					break;
			}
			
		}while(choice!=0);
	}
}
