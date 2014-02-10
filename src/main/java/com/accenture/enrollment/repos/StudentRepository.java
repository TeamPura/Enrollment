package com.accenture.enrollment.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.enrollment.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
