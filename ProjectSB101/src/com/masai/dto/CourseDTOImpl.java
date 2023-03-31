package com.masai.dto;

public class CourseDTOImpl implements CourseDTO{
private int courseId;
private String courseName;
private int coursefee;

public CourseDTOImpl() {
	super();
}

public CourseDTOImpl(int courseId, String courseName, int coursefee) {
	super();
	this.courseId = courseId;
	this.courseName = courseName;
	this.coursefee = coursefee;
}
public CourseDTOImpl(String courseName, int coursefee) {
	super();
	this.courseName = courseName;
	this.coursefee = coursefee;
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
public String getCourseName() {
	return courseName;
}
@Override
public void setCourseName(String courseName) {
	this.courseName = courseName;
}
@Override
public int getCoursefee() {
	return coursefee;
}
@Override
public void setCoursefee(int coursefee) {
	this.coursefee = coursefee;
}

@Override
public String toString() {
	return "courseId=" + courseId + ", courseName=" + courseName + ", coursefee=" + coursefee;
}


}
