package com.masai.dao;

import java.util.List;

import com.masai.dto.CourseDTO;
import com.masai.exception.NoRecordFound;
import com.masai.exception.SomewentWrong;

public interface CourseDAO {
	public String addCourse(CourseDTO course) throws SomewentWrong;
	public String updateCourseDetails(CourseDTO course) throws SomewentWrong;
	public List<CourseDTO> searchCourse(String name) throws SomewentWrong;
	public List<CourseDTO> getAllCourse() throws SomewentWrong, NoRecordFound;
	public String deleteBatch(String cName) throws SomewentWrong;
}
