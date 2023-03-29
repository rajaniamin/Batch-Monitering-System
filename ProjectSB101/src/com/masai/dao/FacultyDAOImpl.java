package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.FacultyDTO;
import com.masai.exception.NoRecordFound;
import com.masai.exception.SomewentWrong;

public class FacultyDAOImpl implements FacultyDao{
	@Override 
	public void Login(String username, String password) throws SomewentWrong, NoRecordFound{
		Connection conn = null;
		
		try {
			conn=DbUtils.getConn();
			String LOGIN_QUERY = "SELECT username FROM user WHERE username = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(LOGIN_QUERY);
			
			
			ps.setString(1, username);
			ps.setString(2, password);
			
			
			ResultSet resultSet = ps.executeQuery();
			if(DbUtils.isResultSetEmpty(resultSet)) {
				throw new NoRecordFound("Invalid Username and Password");
			}
			
			resultSet.next();
			LoggedINUser.loggedInUserId = resultSet.getInt("username");
			
			
			
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
		
	}
	@Override
	public List<FacultyDTO> searchByModleNo(int batchId) throws SomewentWrong, NoRecordFound{
		
		Connection conn=null;
		List <FacultyDTO> list=new ArrayList<>();
		
		try {
			conn=DbUtils.getConn();
			PreparedStatement ps = conn .prepareStatement("select batchid, courseName, startDate, duration from faculty f inner join batch b on f.facultyId=b.facultyId where f.facultyId=?");		
			
	          ps.setInt(1,batchId);	
		      
	          ResultSet rs= ps.executeQuery();
	          
	          if(DbUtils.isResultSetEmpty(rs)) {
	        	   throw new NoRecordFound("Not record Found");
	           }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DbUtils.closeConn(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		return list;
		
	}
}
