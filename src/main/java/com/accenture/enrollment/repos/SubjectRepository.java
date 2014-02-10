package com.accenture.enrollment.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.enrollment.model.GradeLevel;
import com.accenture.enrollment.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

	public List<Subject> findByGradeLevel(GradeLevel gradeLevel);
	//public GradeLevel findBySubjectId(int subjectId);
	
	//List<Subject> findByGradeLevel_GradeLevelId(int gradeLevelId);
}
