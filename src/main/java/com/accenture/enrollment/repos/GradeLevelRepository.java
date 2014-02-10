package com.accenture.enrollment.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.enrollment.model.GradeLevel;

public interface GradeLevelRepository extends JpaRepository<GradeLevel, Integer> {

	//public List<Subject> findByGradeLevelId(int gradeLevelId);
	
}