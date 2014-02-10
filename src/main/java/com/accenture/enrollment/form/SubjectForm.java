package com.accenture.enrollment.form;

import java.io.Serializable;

import java.util.List;

public class SubjectForm implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int subjectId;
	private String description;
	private String name;
	private int units;
	private List<ScheduleForm> schedules;
	private GradeLevelForm gradeLevel;

	public SubjectForm() {
	}

	public int getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnits() {
		return this.units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public List<ScheduleForm> getSchedules() {
		return this.schedules;
	}

	public void setSchedules(List<ScheduleForm> schedules) {
		this.schedules = schedules;
	}

	public GradeLevelForm getGradeLevel() {
		return this.gradeLevel;
	}

	public void setGradeLevel(GradeLevelForm gradeLevel) {
		this.gradeLevel = gradeLevel;
	}

}