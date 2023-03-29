package com.masai.dto;

import java.time.LocalDate;

public class BatchDTOImpl implements BatchDTO {
	private String batchId;
	private String courseName;
	private int facultyId;
	private int noOfStudents;
	private LocalDate batchstartDate;
	private int duration;
	public BatchDTOImpl(String batchId, String courseName, int facultyId, int noOfStudents, LocalDate batchstartDate,
			int duration) {
	
		this.batchId = batchId;
		this.courseName = courseName;
		this.facultyId = facultyId;
		this.noOfStudents = noOfStudents;
		this.batchstartDate = batchstartDate;
		this.duration = duration;
	}
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
	public LocalDate getBatchstartDate() {
		return batchstartDate;
	}
	public void setBatchstartDate(LocalDate batchstartDate) {
		this.batchstartDate = batchstartDate;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "BatchDTOImpl [batchId=" + batchId + ", courseName=" + courseName + ", facultyId=" + facultyId
				+ ", noOfStudents=" + noOfStudents + ", batchstartDate=" + batchstartDate + ", duration=" + duration
				+ "]";
	}
	
	
	
}
