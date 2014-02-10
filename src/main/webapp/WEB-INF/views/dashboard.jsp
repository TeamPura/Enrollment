<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Dashboard</title>
	<link href="resources/css/jquery-ui.css" rel="stylesheet">
	
	<!-- Bootstrap core CSS -->
    <link href="resources/css/bootstrap.css" rel="stylesheet">
    
    <!-- Custom styles for this template -->
    <link href="resources/css/dashboard.css" rel="stylesheet">
    
    <link href="resources/css/jtable.css" rel="stylesheet">
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="resources/js/jquery-ui-1.10.4.custom.min.js"></script>
    <script src="resources/js/bootstrap.js"></script>
    <script src="resources/js/docs.min.js"></script>
    <script src="resources/js/jquery.jtable.min.js"></script>
   
</head>
<body>

    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="${pageContext.request.contextPath}/">Project Enrollee!</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="${pageContext.request.contextPath}/home">Profile</a></li>
            <li><a href="#">Help</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </div>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="dashboardLI active"><a href="${pageContext.request.contextPath}/dashboard">Overview</a></li>
            <li class="studentsLI"><a id="students_nav" href="#">Students</a></li>
            <li class="teachersLI"><a id="teachers_nav" href="#">Teachers</a></li>
            <li class="gradeLevelI"><a id="gradeLevel_nav" href="#">Grade Level</a></li>
            <li class="activeLI"><a href="#">Subjects</a></li>
            <li class="activeLI"><a href="#">Schedule</a></li>
            <li class="activeLI"><a href="#">Classroom</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">Nav item</a></li>
            <li><a href="">One more nav</a></li>
            <li><a href="">More navigation</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">Nav item again</a></li>
            <li><a href="">One more nav</a></li>
            <li><a href="">Another nav item</a></li>
          </ul>
        </div>
        
        <!-- LOAD CONTENT VIA JQUERY -->
        
        <div id="load_container">
        
        </div>
        
        <!-- END LOADED CONTENT VIA JQUERY -->
         
      
      </div>
    </div>

    
    
    <script>
  		$(function() {  			
  			$('#load_container').load('dashboard_overview #dashboard_container');
  			
  			$("#students_nav").click(function(){
  			  	$('#load_container').load('studentsPage #dashboard_container', function() {
	  			  	$('#addStudent').on('click', function(){ 
	  			  		$(".activeBTN").removeClass("active");
	  			  		$(this).addClass("active");
	  			  		$(".studentContent").css("display","none");
	  			  		$("#addStudent_container").css("display","block");
	  			  		$("#addStudent_container input.form-control").css("margin-bottom","10px");
		  			  	$("#bday_datepicker").datepicker({changeMonth: true, changeYear: true, dateFormat: 'yy-mm-dd', yearRange: "1980:2005" });
	  			  	});
	  			  	$("#manageStudent").on('click', function(){ 
	  			  		$(".activeBTN").removeClass("active");
	  			  		$(this).addClass("active");
		  			  	$(".studentContent").css("display","none");
	  			  		$("#manageStudent_container").css("display","block");
	  			  		
		  			  	$('#manageStudent_container').jtable({
			  			  	title: 'Manage Teachers',
		  		            actions: {
		  		                listAction: '${pageContext.request.contextPath}/student/manageStudent',
		  		                createAction: '/GettingStarted/CreatePerson',
		  		                updateAction: '${pageContext.request.contextPath}/student/manageStudent',
		  		                deleteAction: '/GettingStarted/DeletePerson'
		  		            },
		  		            fields: {
		  		              	userId: {
		  		            		title: 'Student ID',
		  		                    key: true,
		  		                    list: true,
		  		                    edit: false,
		  		                    create: false,
		  		                    width: '10%'
		  		                },
		  		              	fname: {
		  		                    title: 'First Name',
		  		                    width: '10%'
		  		                },
		  		              	lname: {
		  		                    title: 'Last Name',
		  		                    width: '10%'
		  		                },
		  		              	mname: {
		  		                    title: 'Middle Name',
		  		                    width: '15%'
		  		                },
		  		              	address: {
		  		                    title: 'Address',
		  		                    width: '10%'
		  		                },
		  		              	bday: {
		  		                    title: 'Birthdate',
		  		                  	type: 'date',
		  		                  	displayFormat: 'yy-mm-dd',
		  		                    width: '10%'
		  		                },
		  		              	gender: {
		  		                    title: 'Gender',
		  		                  	width: '10%',
			  		                type: 'radiobutton',
			  	                    options: [
			  	                        { Value: 'M', DisplayText: 'Male'},
			  	                        { Value: 'F', DisplayText: 'Female'}
			  	                    ]		  		                    
		  		                },
		  		              	gradeLevelId: {
		  		                    title: 'Grade Level',
		  		                    width: '10%',
		  		                  	options: {  '7': '7', '8': '8', '9': '9', 
				  		                  		'10': '10', '11': '11', '12': '12'}
		  		                },
		  		              	email: {
		  		                    title: 'Email Address',
		  		                    width: '20%',
		  		                  	create: true,
		  		                    edit: true
		  		                }
		  		            }
		  		        });
		  			  	$('#manageStudent_container').jtable('load'); 
	  			  	});
  			  	});
  			  	$("li.active").removeClass("active");
				$('.studentsLI').addClass("active");
  			});
  			
  			$("#teachers_nav").click(function(){
  			  	$('#load_container').load('teachersPage #dashboard_container', function() {
	  			  	$('#addTeacher').on('click', function(){ 
	  			  		$(".activeBTN").removeClass("active");
	  			  		$(this).addClass("active");
	  			  		$(".teacherContent").css("display","none");
	  			  		$("#addTeacher_container").css("display","block");
	  			  		$("#addTeacher_container input.form-control").css("margin-bottom","10px");
		  			  	$("#bday_datepicker").datepicker({changeMonth: true, changeYear: true, dateFormat: 'yy-mm-dd', yearRange: "1970:2000" });
	  			  	});
	  			  	$("#manageTeacher").on('click', function(){ 
	  			  		$(".activeBTN").removeClass("active");
	  			  		$(this).addClass("active");
	  			  		$(".teacherContent").css("display","none");
	  			  		$("#manageTeacher_container").css("display","block");
	  			  	 	  
		  			  	$('#manageTeacher_container').jtable({
			  			  	title: 'Manage Teachers',
		  		            actions: {
		  		                listAction: '${pageContext.request.contextPath}/teacher/manageTeacher',
		  		                createAction: '/GettingStarted/CreatePerson',
		  		                updateAction: '${pageContext.request.contextPath}/teacher/updateTeacher',
		  		                deleteAction: '/GettingStarted/DeletePerson'
		  		            },
		  		            fields: {
		  		              	userId: {
		  		            		title: 'Teacher ID',
		  		                    key: true,
		  		                    list: true,
		  		                    edit: false,
		  		                    create: false,
		  		                    width: '10%'
		  		                },
		  		              	fname: {
		  		                    title: 'First Name',
		  		                    width: '10%'
		  		                },
		  		              	lname: {
		  		                    title: 'Last Name',
		  		                    width: '10%'
		  		                },
		  		              	mname: {
		  		                    title: 'Middle Name',
		  		                    width: '15%'
		  		                },
		  		              	address: {
		  		                    title: 'Address',
		  		                    width: '10%'
		  		                },
		  		              	bday: {
		  		                    title: 'Birthdate',
		  		                  	type: 'date',
		  		                  	displayFormat: 'yy-mm-dd',
		  		                    width: '10%'
		  		                },
		  		              	gender: {
		  		                    title: 'Gender',
		  		                  	width: '10%',
			  		                type: 'radiobutton',
			  	                    options: [
			  	                        { Value: 'M', DisplayText: 'Male'},
			  	                        { Value: 'F', DisplayText: 'Female'}
			  	                    ]		  		                    
		  		                },
		  		              	email: {
		  		                    title: 'Email Address',
		  		                    width: '20%',
		  		                  	create: true,
		  		                    edit: true
		  		                }
		  		            }
		  		        });
		  			  $('#manageTeacher_container').jtable('load'); 
		  			});
  			  	});
  			  	$("li.active").removeClass("active");
				$('.teachersLI').addClass("active");
  			});
  			
  			$("#gradeLevel_nav").click(function(){
  			  	$('#load_container').load('gradeLevelPage #dashboard_container', function() {
	  			  	$('#addGradeLevel').on('click', function(){ 
	  			  		$(".activeBTN").removeClass("active");
	  			  		$(this).addClass("active");
	  			  		$(".gradeLevelContent").css("display","none");
	  			  		$("#addGradeLevel_container").css("display","block");
	  			  	});
	  			  	$("#manageGradeLevel").on('click', function(){ 
	  			  		$(".activeBTN").removeClass("active");
	  			  		$(this).addClass("active");
	  			  		$(".gradeLevelContent").css("display","none");
	  			  		$("#manageGradeLevel_container").css("display","block");
	  			  		
		  			  	$('#manageGradeLevel_container').jtable({
			  			  	title: 'Manage Grade Levels',
			  			  	openChildAsAccordion: true,
		  		            actions: {
		  		                listAction: '${pageContext.request.contextPath}/gradeLevel/manageGradeLevel',
		  		                createAction: '/GettingStarted/CreatePerson',
		  		                updateAction: '/GettingStarted/CreatePerson',
		  		                deleteAction: '/GettingStarted/DeletePerson'
		  		            },
		  		            fields: {
		  		            	//CHILD TABLE DEFINITION FOR "SUBJECTS"
		  		                Subjects: {
		  		                    title: '',
		  		                    width: '5%',
		  		                    sorting: false,
		  		                    edit: false,
		  		                    create: false,
		  		                    display: function (gradeLevelData) {                 	
		  		                    	var $img = $('<img src="${pageContext.request.contextPath}/resources/images/jtable/list_metro.png" title="View Subjects" />');
		  		                    	$img.click(function (subjectData) {
		  		                    		//alert("SubjectData:" + subjectData.record.subjectId);
		  		                            $('#manageGradeLevel_container').jtable('openChildTable', $img.closest('tr'),
		  		                            {
		  		                            	title: gradeLevelData.record.name + ' - Subjects',
		  		                                actions: {
		  		                                	listAction: '${pageContext.request.contextPath}/gradeLevel/subjectsGradeLevel/' + gradeLevelData.record.gradeLevelId,
		  		                                    deleteAction: '/Demo/DeletePhone',
		  		                                    updateAction: '${pageContext.request.contextPath}/gradeLevel/subjectsUpdate',
		  		                                    createAction: '/Demo/CreatePhone'
		  		                                },
		  		                                fields: {
		  		                                	gradeLevel: {
		                                                type: 'hidden',
		                                                defaultValue: gradeLevelData.record.gradeLevelId
		                                            },
		  		                                    subjectId: {
		  		                                    	key: true,
		  		                                        create: true,
		  		                                        edit: false,
		  		                                        list: true
		  		                                    },
		  		                                    name: {
		  		                                    	title: 'Subject Name',
		  		                                        width: '30%'
		  		                                    },
		  		                                    units: {
		  		                                    	title: 'Units',
		  		                                        width: '30%'
		  		                                    },
		  		                                    description: {
		  		                                    	title: 'Description',
		  		                                        width: '40%',
		  		                                        create: true,
		  		                                        edit: true
		  		                                    }
		  		                                 }
		  		                               }, function (data) { //opened handler
		  		                               data.childTable.jtable('load');
		  		                           });
		  		                        });
		  		                    return $img;		  		                    
		  		                   }
		  		                },
		  		            	gradeLevelId: {
		  		            		title: 'Grade Level ID',
		  		                    key: true,
		  		                    list: true,
		  		                    edit: false,
		  		                    create: false,
		  		                    width: '30%'
		  		                },
		  		              	name: {
		  		                    title: 'Grade Name',
		  		                    width: '30%'
		  		                },
		  		              	description: {
		  		                    title: 'Description',
		  		                    width: '40%',
		  		                  	create: true,
		  		                    edit: true
		  		                }
		  		            }
		  		        });
		  			  	$('#manageGradeLevel_container').jtable('load'); 	  			  	 	
		  			});
  			  	});
  			  	$("li.active").removeClass("active");
				$('.gradeLevelI').addClass("active");
  			});
  			
  		});
  	</script>

</body>
  
</html>