package com.accenture.enrollment.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the grade_level database table.
 * 
 */
@Entity
@Table(name="grade_level")
public class GradeLevel implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name="grade_level_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int gradeLevelId;

	@Lob
	private String description;

	private String name;

	//bi-directional many-to-one association to Subject
	@OneToMany(mappedBy="gradeLevel")
	private List<Subject> subjects;

	public GradeLevel() {
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

	public List<Subject> getSubjects() {
		return this.subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

}