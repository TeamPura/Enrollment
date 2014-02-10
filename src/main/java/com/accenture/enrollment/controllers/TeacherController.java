package com.accenture.enrollment.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import javax.annotation.Resource;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.enrollment.form.TeacherForm;
import com.accenture.enrollment.model.Login;
import com.accenture.enrollment.model.Teacher;
import com.accenture.enrollment.service.HomeService;


/**
 * Handles requests for the student module.
 */
@Controller
public class TeacherController {
	
	private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);
	
	@Resource
	private HomeService homeService;
	
	@RequestMapping(value="/register_Teacher", method = RequestMethod.POST )
	public ModelAndView studentsPage(@ModelAttribute Teacher teacher, @ModelAttribute Login login, String birthday) throws ParseException {
		Date birthdate = new SimpleDateFormat("yyyy-mm-dd").parse(birthday);
		teacher.setBday(birthdate);
		homeService.registerTeacher(teacher);
		homeService.loginCredentials(login);
		return new ModelAndView("dashboard");
	}
	    
    @RequestMapping(value = "/teacher/manageTeacher", headers = "Accept=application/json")
    @ResponseBody
    public String manageTeachers() {
        List<Teacher> result = homeService.findallTeachers();
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
        	teacherObj.put("bday", result.get(i).getBday().toString());
        	teacherObj.put("gender", result.get(i).getGender());
        	teacherObj.put("email", result.get(i).getEmail());
        	json.accumulate("Records", teacherObj);
    	}

        System.out.println("JSON: " + json.toString(2));
        String jsonString = json.toString();
        return jsonString;
    }
    

    @RequestMapping(value = "/teacher/updateTeacher", headers = "Accept=application/json")
    @ResponseBody
    public void updateTeacher(@ModelAttribute TeacherForm teacherForm, BindingResult result, String bday) throws ParseException {
    	if(result.hasErrors()){
    		logger.info("\nERROOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOR ");
    		logger.info("\nDATE : " + bday );   
    		Date birthdate = new SimpleDateFormat("yyyy-mm-dd").parse(bday);
    		teacherForm.setBday(birthdate);
			logger.info("\nDATE after set :" + teacherForm.getBday() ); 
    	}
    	
    	//Date birthdate = new SimpleDateFormat("yyyy-mm-dd").parse(bday);
		//teacherForm.setBday(birthdate);
    	homeService.updateTeacher(teacherForm);  
    }
    
	
	
	
	
	
}