package com.masai.dto;

import java.time.LocalDate;

public interface BatchDTO {
	public String getBatchId();
	public void setBatchId(String batchId);
	public String getCourseName() ;
	public void setCourseName(String courseName) ;
	public int getFacultyId() ;
	public void setFacultyId(int facultyId) ;
	public int getNoOfStudents();
	public void setNoOfStudents(int noOfStudents) ;
	public LocalDate getBatchstartDate() ;
	public void setBatchstartDate(LocalDate batchstartDate);
	public int getDuration() ;
	public void setDuration(int duration);
}
