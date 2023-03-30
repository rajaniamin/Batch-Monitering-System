package com.masai.dao;

import java.util.List;

import com.masai.dto.CourseTopicDTO;
import com.masai.exception.SomewentWrong;

public interface CourseTopicDAO {
	public List<CourseTopicDTO> viewFacultyCoursePlan(int facultyId) throws SomewentWrong;
}
