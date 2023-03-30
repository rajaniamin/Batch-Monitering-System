package com.masai.dto;

import java.sql.Date;
import java.time.LocalDate;

public interface BatchDTO {
	public int getBatchId();
	public void setBatchId(int batchId);
	public int getCourseId();
	public void setCourseId(int courseId);
	public int getFacultyId() ;
	public void setFacultyId(int facultyId);
	public int getNoOfStudents();
	public void setNoOfStudents(int noOfStudents);
	public Date getStartDate();
	
	public int getDuration() ;
	public void setDuration(int duration) ;
	void setStartDate(Date startDate);
}
