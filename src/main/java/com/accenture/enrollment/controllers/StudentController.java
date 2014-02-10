package com.accenture.enrollment.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.enrollment.service.HomeService;
import com.accenture.enrollment.model.Login;
import com.accenture.enrollment.model.Student;
import com.accenture.enrollment.model.Teacher;


/**
 * Handles requests for the student module.
 */
@Controller
public class StudentController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Resource
	private HomeService homeService;
	
	@RequestMapping(value="/register_Student", method = RequestMethod.POST )
	public ModelAndView studentsPage(@ModelAttribute Student student, @ModelAttribute Login login, String birthday) throws ParseException {
		Date birthdate = new SimpleDateFormat("yyyy-mm-dd").parse(birthday);
		student.setBday(birthdate);
		homeService.registerStudent(student);
		homeService.loginCredentials(login);
		return new ModelAndView("dashboard");
	}
	
	@RequestMapping(value = "/student/manageStudent", headers = "Accept=application/json")
    @ResponseBody
    public String manageStudent() {
        List<Student> result = homeService.findallStudent();
        JSONObject json = new JSONObject();        
        json.put("Result", "OK");
        
       	for(int i=0; i<result.size(); i++){
       		System.out.println("Value: " + i + " - Person ID: " + result.get(i).getUserId());
        	JSONObject teacherObj = new JSONObject();
        	teacherObj.put("userId", result.get(i).getUserId());
        	teacherObj.put("fname", result.get(i).getFname());
        	teacherObj.put("lname", result.get(i).getLname());
        	teacherObj.put("mname", result.get(i).getMname());
        	teacherObj.put("address", result.get(i).getAddress());
        	teacherObj.put("birthday", result.get(i).getBday().toString());
        	teacherObj.put("gender", result.get(i).getGender());
        	teacherObj.put("email", result.get(i).getEmail());
        	teacherObj.put("gradeLevelId", result.get(i).getGradeLevelId());
        	json.accumulate("Records", teacherObj);
    	}

        System.out.println("JSON: " + json.toString(2));
        
        String jsonString = json.toString();
        return jsonString;
    }
	
	
	
}