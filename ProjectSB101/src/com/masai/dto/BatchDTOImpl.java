package com.masai.dto;

import java.sql.Date;
import java.time.LocalDate;

public class BatchDTOImpl implements BatchDTO {
	private int batchId;
	private int courseId;
	private int facultyId;
	private int noOfStudents;
	private Date startDate;
	private int duration;
	
	
	public BatchDTOImpl() {
		super();
	}
	public BatchDTOImpl(int batchId, int courseId, int facultyId, int noOfStudents, Date date, int duration) {
		super();
		this.batchId = batchId;
		this.courseId = courseId;
		this.facultyId = facultyId;
		this.noOfStudents = noOfStudents;
		this.startDate = date;
		this.duration = duration;
	}
	
	public BatchDTOImpl(int courseId, int facultyId, int noOfStudents, Date startDate, int duration) {
		super();
		this.courseId = courseId;
		this.facultyId = facultyId;
		this.noOfStudents = noOfStudents;
		this.startDate = startDate;
		this.duration = duration;
	}
	public BatchDTOImpl(int courseId, int noOfStudents, Date startDate, int duration) {
		super();
		this.courseId = courseId;
		this.noOfStudents = noOfStudents;
		this.startDate = startDate;
		this.duration = duration;
	}
	@Override
	public int getBatchId() {
		return batchId;
	}
	@Override
	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}
	@Override
	public int getCourseId() {
		return courseId;
	}
	@Override
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	@Override
	public int getFacultyId() {
		return facultyId;
	}
	@Override
	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}
	@Override
	public int getNoOfStudents() {
		return noOfStudents;
	}
	@Override
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
	@Override
	public Date getStartDate() {
		return startDate;
	}
	@Override
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@Override
	public int getDuration() {
		return duration;
	}
	@Override
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "BatchDTOImpl [batchId=" + batchId + ", courseId=" + courseId + ", facultyId=" + facultyId
				+ ", noOfStudents=" + noOfStudents + ", startDate=" + startDate + ", duration=" + duration + "]";
	}
}
