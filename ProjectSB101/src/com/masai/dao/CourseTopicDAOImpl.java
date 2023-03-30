package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.CourseTopicDTO;
import com.masai.dto.CourseTopicDTOImpl;
import com.masai.exception.SomewentWrong;

public class CourseTopicDAOImpl implements CourseTopicDAO{
	@Override
	public List<CourseTopicDTO> viewFacultyCoursePlan(int facultyId) throws SomewentWrong {
		Connection conn=null;
		List<CourseTopicDTO> list = new ArrayList<>();
		try {
			conn=DbUtils.getConn();
			PreparedStatement ps = conn.prepareStatement("Select c.* from coursetopic c, Batch b where c.batchId = b.batchId and c.facultyId = ?");
			ps.setInt(1, facultyId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {		
				System.out.println("Hi");
				int pid = rs.getInt("planid");
				int bid = rs.getInt("batchId");
				int dNo = rs.getInt("totaldays");
				String topic = rs.getString("topic");
				int is_Active = rs.getInt("is_Active");
				
				
				
				CourseTopicDTO course = new CourseTopicDTOImpl(pid, bid, dNo, topic, is_Active);
				
				list.add(course);
			
			}if(list.size() == 0)
				throw new SomewentWrong("No Such Plan");
		
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
