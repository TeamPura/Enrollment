package com.accenture.enrollment.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.enrollment.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

	

}
