package com.accenture.enrollment.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 * The persistent class for the subject database table.
 * 
 */
@Entity
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="subject_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int subjectId;

	@Lob
	private String description;

	private String name;

	private int units;
	
	//bi-directional many-to-one association to Schedule
	@OneToMany(mappedBy="subject")
	private List<Schedule> schedules;

	//bi-directional many-to-one association to GradeLevel
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="grade_level_id")
	private GradeLevel gradeLevel;
	
	public Subject() {
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

	public List<Schedule> getSchedules() {
		return this.schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

	
	public GradeLevel getGradeLevel() {
		return this.gradeLevel;
	}

	public void setGradeLevel(GradeLevel gradeLevel) {
		this.gradeLevel = gradeLevel;
	}


}