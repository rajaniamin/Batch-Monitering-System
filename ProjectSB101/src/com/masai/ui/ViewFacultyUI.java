package com.masai.ui;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.CourseTopicDAO;
import com.masai.dao.CourseTopicDAOImpl;
import com.masai.dto.CourseTopicDTO;
import com.masai.exception.SomewentWrong;

public class ViewFacultyUI {
	
	
	public static void viewByFaculty(int FacultyId) throws SomewentWrong {
		Scanner sc=new Scanner(System.in);
		CourseTopicDAO cdao=new CourseTopicDAOImpl();
		try {
			int choice=0;
			System.out.println("Enter your faculty Id");
			choice=sc.nextInt();
			
			List<CourseTopicDTO> list= cdao.viewFacultyCoursePlan(choice);
		  list.forEach(mod -> System.out.println(mod.getPlanid()+" "+mod.getBatchId()+" "+mod.getTopic()+" "+mod.getTotaldays()+" "+mod.getIs_Active()));
		} catch (SomewentWrong  e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
