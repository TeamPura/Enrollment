package com.accenture.enrollment.form;

import java.io.Serializable;


public class ScheduleForm implements Serializable {
	private static final long serialVersionUID = 1L;

	private int scheduleId;
	private String classroom;
	private String day;
	private String time;
	private SubjectForm subject;
	private TeacherForm teacher;

	public ScheduleForm() {
	}

	public int getScheduleId() {
		return this.scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getClassroom() {
		return this.classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public String getDay() {
		return this.day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public SubjectForm getSubject() {
		return this.subject;
	}

	public void setSubject(SubjectForm subject) {
		this.subject = subject;
	}

	public TeacherForm getTeacher() {
		return this.teacher;
	}

	public void setTeacher(TeacherForm teacher) {
		this.teacher = teacher;
	}

}