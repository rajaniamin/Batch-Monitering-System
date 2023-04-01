package com.masai.ui;

import java.util.List;
import java.util.Scanner;

import com.masai.dao.CourseDAO;
import com.masai.dao.CourseDAOImpl;
import com.masai.dao.CourseTopicDAO;
import com.masai.dao.CourseTopicDAOImpl;
import com.masai.dto.CourseTopicDTO;
import com.masai.dto.CourseTopicDTOImpl;
import com.masai.exception.NoRecordFound;
import com.masai.exception.SomewentWrong;

public class ViewFacultyUI {
	public static void addCoursePlanMtd() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the batch Id");
		int bid=sc.nextInt();
		System.out.println("Enter the number of days that is required to cover the topic");
		int days=sc.nextInt();
		
	     System.out.println("Enter the name of the topic");
	     String tpc=sc.next();
	     System.out.println("Enter the status");
	     int sts=sc.nextInt();
	     
	     CourseTopicDTO cdto=new CourseTopicDTOImpl();
	     
	     CourseTopicDAO cdao=new CourseTopicDAOImpl();
	     
	     try {
			cdao.addTopic(cdto);
			System.out.println("Topic added successfully");
		} catch (SomewentWrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	     
		
		
	}
	
	public static void viewByFaculty(int FacultyId) throws SomewentWrong, NoRecordFound {
		Scanner sc=new Scanner(System.in);
		CourseTopicDAO cdao=new CourseTopicDAOImpl();
		try {
			
			int choice=0;
			System.out.println("Enter your faculty Id");
			choice=sc.nextInt();
			
			List<CourseTopicDTO> list= cdao.viewFacultyCoursePlan(FacultyId);
		  list.forEach(mod -> System.out.println(" PlanId ->"+mod.getPlanid()+'\n'+" BatchId->"+mod.getBatchId()+'\n'+" Topic->"+mod.getTopic()+'\n'+" Number of Days->"+mod.getTotaldays()+'\n'+" Active->"+mod.getIs_Active()));
		} catch (SomewentWrong  e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
