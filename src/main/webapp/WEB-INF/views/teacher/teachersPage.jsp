<div id="dashboard_container" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<h1 class="page-header">Teachers</h1>
					
	<a href="#" id="addTeacher" class="activeBTN btn btn-primary btn-large">Add Teacher</a>
	<a href="#" id="manageTeacher" class="activeBTN btn btn-primary btn-large">Manage</a>

	<!-- ADD TEACHER CONTAINER -->
	<div id="addTeacher_container" class="row teacherContent" style="display: none; margin-left: 0px; margin-top: 30px;">
		<div class="col-xs-12 col-sm-12 col-md-4 well well-sm">
	        <legend><i class="glyphicon glyphicon-globe"></i>&nbsp; Register New Teacher</legend>
	        <form action="register_Teacher" method="post" class="form" role="form">
	        	<input class="form-control" name="userId" placeholder="Teacher ID" type="text" required autofocus  />
	        	<input class="form-control" name="fname" placeholder="First Name" type="text" required />
	            <input class="form-control" name="lname" placeholder="Last Name" type="text" required />
	            <input class="form-control" name="mname" placeholder="Middle Name" type="text" required />
	            <input class="form-control" name="address" placeholder="Address" type="text" required />
	            <input class="form-control" name="birthday" placeholder="Birth Day" id="bday_datepicker" required />        
		        <label for="">Gender &nbsp;&nbsp;</label>
	            <label class="radio-inline">
	                <input type="radio" name="gender" id="inlineCheckbox1" value="M" />Male</label>
	            <label class="radio-inline">
	                <input type="radio" name="gender" id="inlineCheckbox2" value="F" />Female</label>  
	            <br />         
	            <input class="form-control" name="email" placeholder="Your Email" type="email" required/>   		
	            <input class="form-control" name="password" placeholder="Password" type="password" required />
	            <br />
	            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
	        </form>
		</div>
	</div>
	<!-- END ADD TEACHER CONTAINER -->	
		
		
	<!-- MANAGE TEACHER CONTAINER -->
	<div id="manageTeacher_container" class="teacherContent" style="display: none; margin-left: 0px; margin-top: 30px;">
		
	</div>	
	<!-- END MANAGE TEACHER CONTAINER -->	
		
		
</div>

