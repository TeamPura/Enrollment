package com.accenture.enrollment.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LinkController {
	
	private static final Logger logger = LoggerFactory.getLogger(LinkController.class);
	
	@RequestMapping(value="/studentsPage")
	public ModelAndView studentsPage() {
		return new ModelAndView("student/studentsPage");
	}
	
	@RequestMapping(value="/teachersPage")
	public ModelAndView teachersPage() {
		return new ModelAndView("teacher/teachersPage");
	}
	
	@RequestMapping(value="/gradeLevelPage")
	public ModelAndView gradeLevelPage() {
		return new ModelAndView("gradeLevel/gradeLevelPage");
	}
	
	@RequestMapping(value="/dashboard_overview")
	public ModelAndView dashboard_overviewPage() {
		return new ModelAndView("dashboard_overview");
	}
	
}
