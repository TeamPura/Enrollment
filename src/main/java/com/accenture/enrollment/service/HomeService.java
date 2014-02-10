package com.accenture.enrollment.service;

import java.util.List;

import com.accenture.enrollment.form.GradeLevelForm;
import com.accenture.enrollment.form.TeacherForm;
import com.accenture.enrollment.model.GradeLevel;
import com.accenture.enrollment.model.Login;
import com.accenture.enrollment.model.Student;
import com.accenture.enrollment.model.Subject;
import com.accenture.enrollment.model.Teacher;


public interface HomeService {

	/********* Login Module *********/
	public void loginCredentials(Login login);
	
	/********* Student Module ***********/
	public void registerStudent(Student student);
	public List<Student> findallStudent();
	
	/********* Student Module ***********/
	public void registerTeacher(Teacher teacher);
	public int getTeacherCount();
	public List<Teacher> findallTeachers();
	public void updateTeacher(TeacherForm teacher);
	//public List<Teacher> findallTeachers(int jtStartIndex, int jtPageSize);

	/********* Grade Level Module ***********/
	public void createGradeLevel(GradeLevel gradeLevel);
	public List<GradeLevel> findallGradeLevel();
	public List<Subject> findSubjectsOfGradeLevel(GradeLevel gradeLevel);
	public void updateSubject(Subject subject);
	public GradeLevel gradeLevelClass(int subjectId);
	
	
}
