package com.accenture.enrollment.form;

import java.io.Serializable;
import java.util.Date;

public class StudentForm implements Serializable {
	private static final long serialVersionUID = 1L;


	private int userId;
	private String address;
	private Date bday;
	private String email;
	private String fname;
	private String gender;
	private int gradeLevelId;
	private String lname;
	private String mname;

	public StudentForm() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBday() {
		return this.bday;
	}

	public void setBday(Date bday) {
		this.bday = bday;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getGradeLevelId() {
		return this.gradeLevelId;
	}

	public void setGradeLevelId(int gradeLevelId) {
		this.gradeLevelId = gradeLevelId;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

}