package com.masai.ui;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.Scanner;

import com.masai.dao.BatchDao;
import com.masai.dao.BatchDaoImpl;
import com.masai.dao.DbUtils;
import com.masai.dto.BatchDTO;
import com.masai.dto.BatchDTOImpl;
import com.masai.exception.SomewentWrong;

public class BatchUI {
	
	public static void addBatchUI() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		System.out.println("Enter Course ID of the Batch");
		int cId = sc.nextInt();
		System.out.println("Enter Students number of the Batch");
		int totStu = sc.nextInt();
		System.out.println("Enter Start date of the Batch(YYYY-MM-DD).");
		Date date = Date.valueOf(sc.next());
		System.out.println("Enter Batch Duration");
		int dur = sc.nextInt();
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		BatchDTO bdto=new BatchDTOImpl(cId,totStu,date,dur);
		BatchDao bdao= new BatchDaoImpl();	
		
		try {
			String str = bdao.addBatch(bdto);
			System.out.println(str);
		} catch (SomewentWrong e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
	}
	public static void updateBatchUI(int batchId) {
		Scanner sc = new Scanner(System.in);
		
		boolean flag1 = true;
		boolean flag2 = true;
		
		int choice=0;
		while(flag1) {
			String str = "";
			
			do {
				flag2 = true;
				System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
				System.out.println("What do you want to update?");
				System.out.println("1. Number of Students");
				System.out.println("2. Start Date");
				System.out.println("3. Batch Duration in Months");
				System.out.println("0. Exit" );
				System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
				choice=sc.nextInt();
				switch(choice) {
				case 1:
					str = "numberofStudents";
					break;
				case 2:
					str = "startDate";
					break;
				case 3:
					str = "duration";
					break;
				case 0:
					System.out.println("Exiting...");
					break;
					default:
						System.out.println("Invalid Input");
						break;
				}
				
				if(flag2) {
					sc.nextLine();
					System.out.println("Enter New Entry :");
					String set = sc.nextLine();
					System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
					BatchDao dao = new BatchDaoImpl();
					
					String result;
					try {
						result = dao.updateBatch(str, set, batchId);
						
						System.out.println(result);
						
						
					} catch (Exception e) {
						System.out.println( e.getMessage());
						
					}
				}
			}while(choice!=0);
		}
   
}

	public static void allocateFacultyUI() {
		Connection conn=null;
		Scanner sc = new Scanner(System.in);
		try{
			conn=DbUtils.getConn();
			System.out.println("Enter the Faculty Id :");
			int fid = sc.nextInt();
			
			PreparedStatement ps = conn.prepareStatement("select * from faculty where facultyId = ?");
			
			ps.setInt(1, fid);
			
			ResultSet rs = ps.executeQuery();
			
			boolean flag = rs.next();
			if(flag) {
				while(flag) {
					System.out.println("Enter the Batch Id ");
					String batchId = sc.next();
					
					BatchDao dao = new BatchDaoImpl();
					
					try {
						String res = dao.allocateFaculty(fid, batchId);
						System.out.println();
						System.out.println(res);
						System.out.println();
						flag = false;
						
					} catch (SomewentWrong e) {
						
						System.out.println( e.getMessage());
					
						
					}
		
				}
				
			}else {
				System.out.println("Faculty is Not Present");
				allocateFacultyUI();
			}
			
		}catch(Exception ie) {
			System.out.println();
			System.out.println("Invalid Input :(");
			System.out.println();
			allocateFacultyUI();		}
		
	}
	
	public static void deleteBatch() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Batch id");
		int id = sc.nextInt();
		
		BatchDao dao = new BatchDaoImpl();
		
		try {
			String res = dao.deleteBatch(id);
			System.out.println(res);
		} catch (SomewentWrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void searchBatchById() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter id of Batch");
		int id = sc.nextInt();
		
		BatchDao dao = new BatchDaoImpl();
		
		try {
			BatchDTO b = dao.searchBatchById(id);
			System.out.println(" BatchId ->"+b.getBatchId()+'\n' +" CourseId ->"+ b.getCourseId()+'\n'+" FacultyId ->"+ b.getFacultyId()+'\n'+" Number of Students ->"+ b.getNoOfStudents()+'\n'+" Start Date ->"+ b.getStartDate()+'\n'+" Duration ->"+ b.getDuration()+'\n');
		} catch (SomewentWrong e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void batchOp() {
		
		
		Scanner sc=new Scanner(System.in);
		
		int choice=0;
		
		do {
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
			System.out.println("1. Add Batch");
			System.out.println("2. Update Batch");
			System.out.println("3. Search Batch");
			System.out.println("4. Delete Batch");
			System.out.println("5. Assign the Faculty");
			System.out.println("0. Exit");
			System.out.println();
			
			System.out.println("Enter your selection here");

			choice=sc.nextInt();
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
			switch(choice) {
			case 1:
				addBatchUI();
				break;
			case 2:
				System.out.println("Enter the batchId");
				int batchId=sc.nextInt();
				updateBatchUI(batchId);
				break;
			case 3:
				searchBatchById();
				break;
			case 4:
				deleteBatch();
				break;
			case 5:
				allocateFacultyUI();
				break;
			case 0:
				break;
				
			}
			
		}while(choice!=0);
	}
}
