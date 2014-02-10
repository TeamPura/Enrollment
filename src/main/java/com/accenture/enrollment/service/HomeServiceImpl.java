package com.accenture.enrollment.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.accenture.enrollment.form.GradeLevelForm;
import com.accenture.enrollment.form.TeacherForm;
import com.accenture.enrollment.model.GradeLevel;
import com.accenture.enrollment.model.Login;
import com.accenture.enrollment.model.Student;
import com.accenture.enrollment.model.Subject;
import com.accenture.enrollment.model.Teacher;
import com.accenture.enrollment.repos.GradeLevelRepository;
import com.accenture.enrollment.repos.LoginRepository;
import com.accenture.enrollment.repos.StudentRepository;
import com.accenture.enrollment.repos.SubjectRepository;
import com.accenture.enrollment.repos.TeacherRepository;


@Service
public class HomeServiceImpl implements HomeService {
	
	@Resource
	private LoginRepository loginRepo;

	@Resource 
	private StudentRepository studentRepo;
	
	@Resource
	private TeacherRepository teacherRepo;
	
	@Resource
	private GradeLevelRepository gradeLevelRepo;
	
	@Resource
	private SubjectRepository subjectRepo;
	
	
	/*********** LOGIN MODULE ********************/
	public void loginCredentials(Login login){
		loginRepo.save(login);
	}
	
	/************ STUDENT MODULE *****************/	
	public void registerStudent(Student student){
		studentRepo.save(student);
	}
	
	public List<Student> findallStudent() {
		List<Student> listStudents = studentRepo.findAll();
		return listStudents;
	}
	
	/************ TEACHER MODULE *****************/	
	public void registerTeacher(Teacher teacher){
		teacherRepo.save(teacher);
	}
	
	public int getTeacherCount(){
		return (int) teacherRepo.count();
	}
	
	public List<Teacher> findallTeachers() {
		List<Teacher> listTeachers = teacherRepo.findAll();
		return listTeachers;
	}
	
	public void updateTeacher(TeacherForm teacher) {  		
		Teacher update = teacherRepo.findOne(teacher.getUserId());
		update.setAddress(teacher.getAddress());
		update.setBday(teacher.getBday());
		update.setEmail(teacher.getEmail());
		update.setFname(teacher.getFname());
		update.setGender(teacher.getGender());
		update.setLname(teacher.getLname());
		update.setMname(teacher.getMname());
		teacherRepo.save(update);
	}
	
	/*
	public List<Teacher> findallTeachers(int jtStartIndex, int jtPageSize){
		List<Teacher> listTeachers = teacherRepo.findAll(jtStartIndex, jtPageSize);
		return listTeachers;
	}*/
	
	/************ GRADE LEVEL MODULE *****************/	
	public void createGradeLevel(GradeLevel gradeLevel){
		gradeLevelRepo.save(gradeLevel);
	}
	
	public List<GradeLevel> findallGradeLevel(){
		List<GradeLevel> listGradeLevel = gradeLevelRepo.findAll();
		return listGradeLevel;
	}
	
	//hey new
	public List<Subject> findSubjectsOfGradeLevel(GradeLevel gradeLevel){
		//GradeLevel gradeLevel = gradeLevelRepo.findOne(gradeLevelForm.getGradeLevelId());
		//List<Subject> subjects = gradeLevel.getSubjects();
		List<Subject> subjects = subjectRepo.findByGradeLevel(gradeLevel);
		return subjects;
	}
	
	public void updateSubject(Subject subject) {  
		System.out.println("SUBJECT IMPL BEFORE: " + subject.getSubjectId());
		
		Subject update = subjectRepo.findOne(subject.getSubjectId());
		update.setDescription(subject.getDescription());
		update.setName(subject.getName());
		update.setUnits(subject.getUnits());
		subjectRepo.save(update);
		//GradeLevel gradelevel = (GradeLevel) subjectRepo.findBySubjectId(subject.getSubjectId());
		//return gradelevel;
	}
	
	public GradeLevel gradeLevelClass(int subjectId){
		//GradeLevel gradeLevel = subjectRepo.findBySubjectId(subjectId);
		Subject subject = subjectRepo.findOne(subjectId);
		GradeLevel gradeLevel = subject.getGradeLevel();
		return gradeLevel;
	}

}
