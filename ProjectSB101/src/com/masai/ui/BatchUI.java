package com.masai.ui;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;

import com.masai.dao.BatchDao;
import com.masai.dao.BatchDaoImpl;
import com.masai.dto.BatchDTO;
import com.masai.dto.BatchDTOImpl;
import com.masai.exception.SomewentWrong;

public class BatchUI {
	
	public static void addBatchUI() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Course ID of the Batch");
		int cId = sc.nextInt();
		System.out.println("Enter Students number of the Batch");
		int totStu = sc.nextInt();
		System.out.println("Enter Start date of the Batch(YYYY-MM-DD).");
		Date date = Date.valueOf(sc.next());
		System.out.println("Enter Batch Duration");
		int dur = sc.nextInt();
		
		BatchDTO bdto=new BatchDTOImpl(cId,totStu,date,dur);
		BatchDao bdao= new BatchDaoImpl();	
		
		try {
			String str = bdao.addBatch(bdto);
			System.out.println(str);
		} catch (SomewentWrong e) {
			// TODO: handle exception
		}
	}
	

	public static void batchOp() {
		
		
		Scanner sc=new Scanner(System.in);
		
		int choice=0;
		
		do {
			
			System.out.println("1. Add Batch");
			System.out.println("2. Update Batch");
			System.out.println("3. Search Batch");
			System.out.println("4. Delete Batch");
			System.out.println("5. Assign the Faculty");
			System.out.println("0. Exit");
			System.out.println();
			
			System.out.println("Enter your selection here");

			choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				addBatchUI();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 0:
				break;
				
			}
			
		}while(choice!=0);
	}
}
