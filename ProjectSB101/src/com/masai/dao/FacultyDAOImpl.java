package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.FacultyDTO;
import com.masai.dto.FacutlyDTOImpl;
import com.masai.exception.NoRecordFound;
import com.masai.exception.SomewentWrong;

public class FacultyDAOImpl implements FacultyDao{
	@Override
	public FacultyDTO loginFaculty(String username, String password) throws SomewentWrong {
		
		Connection conn=null;
		FacultyDTO faculty = null;
		
		try{
			conn=DbUtils.getConn();
			PreparedStatement ps= conn.prepareStatement("select * from faculty where username = ?");			
			
			ps.setString(1, username);
			
			ResultSet rs= ps.executeQuery();
			
			if(rs.next()) {		
				
				PreparedStatement ps2 = conn.prepareStatement("select * from faculty where username = ? and password = ?");
				
				ps2.setString(1, username);
				ps2.setString(2, password);
				
				ResultSet  rs2 = ps2.executeQuery();
				
				if(rs2.next()) {
					int fid = rs.getInt("facultyId");
					String fname = rs.getString("firstname");
					String lname = rs.getString("lastname");
					String uname = rs.getString("username");
					String mobile = rs.getString("mobile");
					String address = rs.getString("address");
					
					faculty = new FacutlyDTOImpl(fid,fname,lname,uname,mobile,address);
				}else
					
					throw new SomewentWrong("OOPs!! Incorrect Password");
				
			}else
			
				throw new SomewentWrong("No Such Faculty Present With this Username");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			
			throw new SomewentWrong(e.getMessage());
		}finally {
			try {
				DbUtils.closeConn(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return faculty;
		
	}
@Override
	public String forgetPassword(String mobile, String pass) throws SomewentWrong{
		Connection conn=null;
		String message ="Sorry, Something went wrong, Not Able To Change Password";
	    try {
			conn=DbUtils.getConn();
			PreparedStatement ps = conn.prepareStatement("update faculty set password = ? where mobile = ?");
			ps.setString(1, pass);
			ps.setString(2, mobile);
			
			int query = ps.executeUpdate();
			
			if(query >0) {
				message ="Your Password Updated Successfully";	
			}
		} catch (ClassNotFoundException | SQLException e) {
			message = e.getMessage();
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
public String changePassword(int faculty, String pass) throws SomewentWrong {
	
	String message = "Password Not Updated";
	Connection conn=null;
	try{
		conn=DbUtils.getConn();
		PreparedStatement ps = conn.prepareStatement("update faculty set password = ? where facultyId = ? ");
		
		ps.setString(1, pass);
		ps.setInt(2, faculty);
		
		int x = ps.executeUpdate();
		
		if(x>0) {		
			message = "Your Password Updated Successfully";	
		}
		
	}catch(ClassNotFoundException | SQLException e) {
		
		message = e.getMessage();
		
	}
	
	return message;
	
}
}
