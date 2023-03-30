package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.dto.BatchDTO;
import com.masai.dto.BatchDTOImpl;
import com.masai.exception.SomewentWrong;

public class BatchDaoImpl implements BatchDao {
	@Override
	public String addBatch(BatchDTO batch) throws SomewentWrong{
		Connection conn=null;
		String message ="Something is wrong";
		try {
			conn=DbUtils.getConn();
			PreparedStatement ps = conn .prepareStatement("select courseName from Coursedetails where courseId = ?");
			ps.setInt(1, batch.getCourseId());
			
            ResultSet rs = ps.executeQuery();
			
			String cName = "";
			if(rs.next()) {		
				cName = rs.getString("courseName");
				
			}else {
				throw new SomewentWrong("Course Id does not exist.");
			}
			
		PreparedStatement ps1 = conn .prepareStatement("select count(courseId) from Batch where courseId = ?");
			
			ps1.setInt(1, batch.getCourseId());
			
			ResultSet rs1 = ps1.executeQuery();
			

			int count = 0;
			if(rs1.next()) {		
				count = rs1.getInt(1);
			}else {
				throw new SomewentWrong("Course Id does not exist.");
			}
			
			count++;
            String text = String.format("%03d", count);
			
			String batchId = cName + text;
			
			PreparedStatement ps2 = conn .prepareStatement("insert into Batch(batchId, courseId, noOfStudents, batchstartDate, duration) values(?,?,?,?,?)");
			
			ps2.setString(1, batchId);
			ps2.setInt(2, batch.getCourseId());
			ps2.setInt(3,batch.getNoOfStudents());
			ps2.setDate(4, batch.getStartDate());
			ps2.setInt(5, batch.getDuration());
			
			int x = ps2.executeUpdate();
			
			if(x>0) {		
				message = "New Course Added Successfully";	
				
			}else {
				throw new SomewentWrong("Duplicate Entry");
				
			}
		} catch (ClassNotFoundException |SQLException e) {
			// TODO: handle exception
		}finally {
			try {
				DbUtils.closeConn(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return message;
		
	}
	@Override
	public String updateBatch(String str, String set, String name) throws SomewentWrong {
		Connection conn=null;
		String message = "Batch Data Not Updated";
		
		try{
			conn=DbUtils.getConn();
			PreparedStatement ps = conn.prepareStatement("update batch set "+ str +" = ? where batchId = ?");
			
			ps.setString(1, set);
			ps.setString(2, name);
			
			int x = ps.executeUpdate();
			
			if(x>0) {		
				message ="Batch Details Updated Successfully";	
			}else {
				throw new SomewentWrong("Batch Not Exist");
			}
			
		} catch (ClassNotFoundException | SQLException e) {

			throw new SomewentWrong("Wrong Data Format");
		}finally {
			try {
				DbUtils.closeConn(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return message;
	}
	

@Override
	public BatchDTO searchBatchById(String id) throws SomewentWrong{
		Connection conn=null;
		BatchDTO batch=null;
		try {
			conn=DbUtils.getConn();
			PreparedStatement ps = conn.prepareStatement("Select b.batchId, b.courseId, b.facultyId, f.facultyFname, b.noOfStudents, b.batchstartDate, b.duration from Batch b, Faculty f where b.facultyID = f.facultyID and b.batchId = ?");
              ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {		
				int bid = rs.getInt("batchId");
				int cid = rs.getInt("courseId");
				int fid = rs.getInt("facultyId");
				int nos = rs.getInt("noOfStudents");
				Date date = rs.getDate("batchstartDate");
				int dur = rs.getInt("duration");
				
				String sDate = date.toString();
				
				 batch = new BatchDTOImpl(bid,cid,fid,nos,date,dur);
				
			}else 
				throw new SomewentWrong("Batch does not exist with this id "+ id + ".");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
		}finally {
			try {
				DbUtils.closeConn(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return batch;
	}
@Override
public String deleteBatch(String batchId) throws SomewentWrong {
	Connection conn=null;
	String message = "Batch Data Not Updated";
	
	try{
		conn= DbUtils.getConn();
		PreparedStatement ps = conn.prepareStatement("delete from batch where batchId = ?");
		
		ps.setString(1, batchId);
		
		int x = ps.executeUpdate();
		
		if(x>0) {		
			message ="Batch Deleted Successfully";	
		}else {
			throw new SomewentWrong("Batch Not Exist");
		}
		
	} catch (ClassNotFoundException | SQLException e) {

		throw new SomewentWrong("Wrong Data Format");
	}finally {
		try {
			DbUtils.closeConn(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	return message;
}
@Override
public String allocateFaculty(int fName, String batchId) throws SomewentWrong {
	Connection conn=null;
	String message = "Faculty not allocated to "+batchId+" batch..";
	
	try{
		conn= DbUtils.getConn();
		PreparedStatement ps = conn.prepareStatement("update batch set facultyId = ? where batchId = ?");
		
		ps.setInt(1, fName);
		ps.setString(2, batchId);
		
		int x = ps.executeUpdate();
		
		if(x>0) {		
			message = "Faculty allocated to "+batchId+" batch";	
		}else {
			throw new SomewentWrong("Batch doesn't Not Exist");
		}
		
	} catch (ClassNotFoundException | SQLException e) {

		throw new SomewentWrong("Wrong Data Format");
	}
	
	return message;
}
}
