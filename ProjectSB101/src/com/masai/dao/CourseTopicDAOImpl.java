package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.masai.dto.CourseTopicDTO;
import com.masai.dto.CourseTopicDTOImpl;
import com.masai.exception.NoRecordFound;
import com.masai.exception.SomewentWrong;

public class CourseTopicDAOImpl implements CourseTopicDAO{
	@Override
	public void addTopic(CourseTopicDTO ct) throws SomewentWrong{
		Connection conn = null;
		try {
			conn=DbUtils.getConn();
			PreparedStatement ps= conn.prepareStatement("insert into coursetopic(batchId,totaldays,topic,is_Active) values (?,?,?,?");
		
			ps.setInt(1, ct.getBatchId());
			ps.setInt(2, ct.getTotaldays());
			ps.setString(3,ct.getTopic());
			ps.setInt(4, ct.getIs_Active());
			
			ps.executeUpdate();
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
	public List<CourseTopicDTO> viewFacultyCoursePlan(int facultyId) throws SomewentWrong, NoRecordFound {
		Connection conn=null;
		List<CourseTopicDTO> list = new ArrayList<>();
		try {
			conn=DbUtils.getConn();
			PreparedStatement ps = conn.prepareStatement(" select * from coursetopic c join batch b on c.batchId=b.batchId where facultyid=?");
			ps.setInt(1, facultyId);
			ResultSet rs = ps.executeQuery();
			
			if(DbUtils.isResultSetEmpty(rs)) throw new  NoRecordFound("No record found");
			while(rs.next()) {		
				//System.out.println("Hi");
				int pid = rs.getInt("planid");
				int bid = rs.getInt("batchId");
				int dNo = rs.getInt("totaldays");
				String topic = rs.getString("topic");
				int is_Active = rs.getInt("is_Active");
				
				
				
				CourseTopicDTO course = new CourseTopicDTOImpl(pid, bid, dNo, topic, is_Active);
				
				list.add(course);
			
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			
			// TODO: handle exception
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
}
