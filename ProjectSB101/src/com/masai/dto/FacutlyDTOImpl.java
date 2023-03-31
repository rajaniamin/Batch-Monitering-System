package com.masai.dto;

public class FacutlyDTOImpl implements FacultyDTO {
	private int facultyId;
	private String fname;
	private String lname;
	private String username;
	private String password;
	private String mobile;
	private String address;
	
	public FacutlyDTOImpl() {
		super();
	}
	public FacutlyDTOImpl(int facultyId, String fname, String lname, String username, String password, String mobile,
			String address) {

		this.facultyId = facultyId;
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
	}
	public FacutlyDTOImpl(int facultyId, String fname, String lname, String username, String mobile,
			String address) {

		this.facultyId = facultyId;
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.mobile = mobile;
		this.address = address;
	}
	public FacutlyDTOImpl( String fname, String lname, String username, String password, String mobile,
			String address) {

		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
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
	public String getFname() {
		return fname;
	}
	@Override
	public void setFname(String fname) {
		this.fname = fname;
	}
	@Override
	public String getLname() {
		return lname;
	}
	@Override
	public void setLname(String lname) {
		this.lname = lname;
	}
	@Override
	public String getUsername() {
		return username;
	}
	@Override
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String getMobile() {
		return mobile;
	}
	@Override
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String getAddress() {
		return address;
	}
	@Override
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "FacutlyDTOImpl [facultyId=" + facultyId + ", fname=" + fname + ", lname=" + lname + ", username="
				+ username + ", password=" + password + ", mobile=" + mobile + ", address=" + address + "]";
	}
	
	
}
