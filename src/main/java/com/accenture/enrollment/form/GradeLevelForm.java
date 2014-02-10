package com.accenture.enrollment.form;

import java.io.Serializable;

import java.util.List;


public class GradeLevelForm implements Serializable {
	private static final long serialVersionUID = 1L;

	private int gradeLevelId;
	private String description;
	private String name;
	private List<SubjectForm> subjects;

	public GradeLevelForm() {
	}

	public int getGradeLevelId() {
		return this.gradeLevelId;
	}

	public void setGradeLevelId(int gradeLevelId) {
		this.gradeLevelId = gradeLevelId;
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

	public List<SubjectForm> getSubjects() {
		return this.subjects;
	}

	public void setSubjects(List<SubjectForm> subjects) {
		this.subjects = subjects;
	}

}