<div id="dashboard_container" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<h1 class="page-header">Grade Levels</h1>
					
	<a href="#" id="addGradeLevel" class="activeBTN btn btn-primary btn-large">Add Grade Level</a>
	<a href="#" id="manageGradeLevel" class="activeBTN btn btn-primary btn-large">Manage Grade Level</a>

		<!-- ADD STUDENT CONTAINER -->
		<div id="addGradeLevel_container" class="row gradeLevelContent" style="display: none; margin-left: 0px; margin-top: 30px;">
	        <div class="col-xs-12 col-sm-12 col-md-4 well well-sm">
	        <legend><i class="glyphicon glyphicon-globe"></i>&nbsp; Create Grade Level</legend>
	        <form action="register_gradeLevel" method="post" class="form" role="form">
	        	<input class="form-control" name="gradeLevelId" placeholder="Grade Level ID" type="text" required autofocus  />
	        	<input class="form-control" name="name" placeholder="Name" type="text" required />
	            <input class="form-control" name="description" placeholder="Description" type="text" required />
	            <br />
	            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
	        </form>
	        </div>
	    </div>
		<!-- END ADD STUDENT CONTAINER -->
		
		<!-- MANAGE TEACHER CONTAINER -->
		<div id="manageGradeLevel_container" class="gradeLevelContent" style="display: none; margin-left: 0px; margin-top: 30px;">
			
		</div>	
		<!-- END MANAGE TEACHER CONTAINER -->		
	
</div>

