package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.CourseDTO;
import com.masai.dto.CourseDTOImpl;
import com.masai.exception.NoRecordFound;
import com.masai.exception.SomewentWrong;

public class CourseDAOImpl implements CourseDAO{
@Override
	public String addCourse(CourseDTO course) throws SomewentWrong{
		Connection conn=null;
		String msg="Something Went Wrong :(";
		try {
			conn=DbUtils.getConn();
			PreparedStatement ps = conn .prepareStatement("insert into Coursedetails(courseName, courseFee) values(?,?)");
			ps.setString(1, course.getCourseName());
			ps.setInt(2, course.getCoursefee());
			
			if(ps.executeUpdate()>0) {
				msg="Course Added SuccessFully :)";
			}else {
				throw new SomewentWrong(msg);
			}
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
		return msg;
	}
@Override
public String updateCourseDetails(CourseDTO course) throws SomewentWrong{
	Connection conn=null;
	String msg="Something Went Wrong :(";
	try {
		conn=DbUtils.getConn();
		PreparedStatement ps = conn .prepareStatement("update Coursedetails set courseName=?,courseFee=?  where courseId=?");
		ps.setString(1, course.getCourseName());
		ps.setInt(2, course.getCoursefee());
		ps.setInt(3, course.getCourseId());
		
		
		if(ps.executeUpdate()>0) {
			msg="Course Updated SuccessFully :)";
		}else {
			throw new SomewentWrong(msg);
		}
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
	return msg;
}
@Override
public List<CourseDTO> searchCourse(String name) throws SomewentWrong{
	Connection conn= null;
	List<CourseDTO> list = new ArrayList<>();
	try {
		conn=DbUtils.getConn();
		PreparedStatement ps = conn .prepareStatement("Select * from Coursedetails where courseName = ?");
		ps.setString(1, name);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {		
			
			int cid = rs.getInt("courseId");
			String cname = rs.getString("courseName");
			int cfee = rs.getInt("courseFee");
			
			
			list.add(new CourseDTOImpl(cid, cname, cfee));
		}else {
			throw new SomewentWrong("Timed out , Try again later :(");
		}
	}catch(ClassNotFoundException | SQLException e) {
		
	}finally {
		try {
			DbUtils.closeConn(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return list;
}
private List<CourseDTO> getListFromResultSet(ResultSet resultSet) throws SQLException{
	List<CourseDTO> list = new ArrayList<>();
	while(resultSet.next()) {
		//Create an object of Employee
		CourseDTO cdto = new CourseDTOImpl();
		cdto.setCourseId(resultSet.getInt("courseId"));
		cdto.setCourseName(resultSet.getString("courseName"));
		cdto.setCoursefee(resultSet.getInt("coursefee"));
		
		list.add(cdto);
	}
	return list;
}
@Override
public List<CourseDTO> getAllCourse() throws SomewentWrong, NoRecordFound{
	Connection conn= null;
	List<CourseDTO> list = new ArrayList<>();
	try {
		conn=DbUtils.getConn();
		PreparedStatement ps = conn .prepareStatement("Select * from Coursedetails");
		
		
		ResultSet rs = ps.executeQuery();
		
		if(DbUtils.isResultSetEmpty(rs)) {
			throw new NoRecordFound("No category Found");
		}
		list=getListFromResultSet(rs);
	}catch(ClassNotFoundException | SQLException e) {
		
	}finally {
		try {
			DbUtils.closeConn(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	return list;
	
}
@Override
public String deleteBatch(String cName) throws SomewentWrong{
	Connection conn=null;
	String msg="Something Went Wrong :(";
	try {
		conn=DbUtils.getConn();
		PreparedStatement ps = conn .prepareStatement("delete from Coursedetails where courseName=?");
		ps.setString(1, cName);
		
		
		if(ps.executeUpdate()>0) {
			msg="Course Delete SuccessFully :)";
		}else {
			throw new SomewentWrong(msg);
		}
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
	return msg;
	
}
}
