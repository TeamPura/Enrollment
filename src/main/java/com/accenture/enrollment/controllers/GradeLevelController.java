package com.accenture.enrollment.controllers;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.enrollment.form.GradeLevelForm;
import com.accenture.enrollment.model.GradeLevel;
import com.accenture.enrollment.model.Subject;
import com.accenture.enrollment.service.HomeService;


/**
 * Handles requests for the student module.
 */
@Controller
public class GradeLevelController {
	
	private static final Logger logger = LoggerFactory.getLogger(GradeLevelController.class);
	
	@Autowired
	private HomeService homeService;
	
	@ModelAttribute("gradeLevelForm")
	public GradeLevelForm addGradeLevelForm()
	{
		return new GradeLevelForm();
	}
	
	@RequestMapping(value="/register_gradeLevel", method = RequestMethod.POST )
	public ModelAndView studentsPage(@ModelAttribute GradeLevel gradeLevel) {
		homeService.createGradeLevel(gradeLevel);
		return new ModelAndView("dashboard");
	}
	
	@RequestMapping(value = "/gradeLevel/manageGradeLevel", headers = "Accept=application/json")
    @ResponseBody
    public String manageGradeLevel() {
        List<GradeLevel> result = homeService.findallGradeLevel();
        JSONObject json = new JSONObject();        
        json.put("Result", "OK");
        
       	for(int i=0; i<result.size(); i++){
        	JSONObject teacherObj = new JSONObject();
        	teacherObj.put("gradeLevelId", result.get(i).getGradeLevelId());
        	teacherObj.put("name", result.get(i).getName());
        	teacherObj.put("description", result.get(i).getDescription());
        	json.accumulate("Records", teacherObj);
       	}
        System.out.println("JSON: " + json.toString(2));
        String jsonString = json.toString();
        return jsonString;
    }
	
	@RequestMapping(value = "/gradeLevel/subjectsGradeLevel/{id}", headers = "Accept=application/json")
    @ResponseBody
    public String subjectsGradeLevel(@ModelAttribute GradeLevel gradeLevel, @PathVariable Integer id) {
		System.out.println("SUBJEEEEEEEEEEEEEEEEEEEEEEEEEEEEECT");
		System.out.println("Grade Level ID: " + id);
		
		gradeLevel.setGradeLevelId(id);
        List<Subject> result = homeService.findSubjectsOfGradeLevel(gradeLevel);
        
        JSONObject json = new JSONObject();        
        json.put("Result", "OK");
        
       	for(int i=0; i<result.size(); i++){
        	JSONObject subjectObj = new JSONObject();
        	subjectObj.put("gradeLevel", result.get(i).getGradeLevel().getGradeLevelId());
        	subjectObj.put("subjectId", result.get(i).getSubjectId());
        	subjectObj.put("name", result.get(i).getName());
        	subjectObj.put("description", result.get(i).getDescription());
        	subjectObj.put("units", result.get(i).getUnits());
        	json.accumulate("Records", subjectObj);
       	}
        System.out.println("JSON: " + json.toString(2));
        String jsonString = json.toString();
        return jsonString;
        
        
    }

	/*
	@RequestMapping(value = "/gradeLevel/subjectsUpdate", headers = "Accept=application/json")
    @ResponseBody
    public void subjectsUpdate(@ModelAttribute Subject subject, BindingResult result) {
    	System.out.println("SUBJECT UPDATE HERE!!!!!!!!!!!!!!!!");
    	if(subject.getGradeLevel() == null)
    		System.out.println("grade level null: " + subject.getGradeLevel());
    	else
    		System.out.println("grade level is NOT null: " + subject.getGradeLevel());    		
    	System.out.println("grade level ID: " + subject.getGradeLevel().getGradeLevelId()); 
		homeService.updateSubject(subject);
		//GradeLevel gradelevel = homeService.gradeLevelClass(subject.getSubjectId());
		//this.subjectsGradeLevel(gradelevel, gradelevel.getGradeLevelId());
    }*/
	
	@RequestMapping(value = "/gradeLevel/subjectsUpdate", headers = "Accept=application/json")
    @ResponseBody
    public void subjectsUpdate(@ModelAttribute Subject subject, BindingResult result) {
    	System.out.println("SUBJECT UPDATE HERE!!!!!!!!!!!!!!!!");    	
    	homeService.updateSubject(subject);   	
	
		GradeLevel gradeLevel = homeService.gradeLevelClass(subject.getSubjectId());
		subject.setGradeLevel(gradeLevel);
		System.out.println("Grade ID: " + gradeLevel.getGradeLevelId()); 
		
		if(subject.getGradeLevel() == null)
    		System.out.println("grade level null: " + subject.getGradeLevel());
    	else
    		System.out.println("grade level is NOT null: " + subject.getGradeLevel()); 
		
		this.subjectsGradeLevel(gradeLevel, gradeLevel.getGradeLevelId());
	}   
	
	
}