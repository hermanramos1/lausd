<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sub LA</title>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
 <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</head>
<body>
	
	<div class="container">
	
	<div class="row  center-align">
	
		<div class="col s12 card-panel  blue darken-1">
			
			<h2 style="font-family:'Comic Sans MS', cursive, sans-serif" class="white-text text-darken-2">
				Sub LA
				
			</h2>
			<p style="font-family:'Comic Sans MS', cursive, sans-serif" class="white-text text-darken-2"> The App for LAUSD Substitute teachers.</p>
		
		</div>
	
	
	</div>
	
	<div class="row">
	
	<div class="col s12 m6">
		<h3 class="center-align">Register!</h3>
		
		<p><c:out value="${regerror}" /></p>
		   
		   <p><form:errors path="user.*"/></p>
		   
		   <form:form method="POST" action="/registration" modelAttribute="user">
		      	<p>
		           <form:label path="firstName">First Name:</form:label>
		           <form:input type="text" path="firstName"/>
		       </p>
		       <p>
		           <form:label path="lastName">Last Name:</form:label>
		           <form:input type="text" path="lastName"/>
		       </p>
		       <p>
		           <form:label path="email">Email:</form:label>
		           <form:input type="text" path="email"/>
		       </p>
		       <p>
		           <form:label path="password">Password:</form:label>
		           <form:password path="password"/>
		       </p>
		       <p>
		           <form:label path="passwordConfirmation">Password Confirmation:</form:label>
		           <form:password path="passwordConfirmation"/>
		       </p>
		      
  				<button class="btn waves-effect blue darken-1" type="submit" name="action">Submit</button>
		   </form:form>
		</div>
	<div class="col s12 m6">
			<h3 class="center-align">Login!</h3>
		    <p><c:out value="${error}" /></p>
		    <form method="post" action="/login">
		        <p>
		            <label for="email">Email</label>
		            <input type="text" id="email" name="email"/>
		        </p>
		        <p>
		            <label for="password">Password</label>
		            <input type="password" id="password" name="password"/>
		        </p>
		        <button class="btn waves-effect  blue darken-1" type="submit" name="action">Submit</button>
		    </form> 
		  </div>
    </div>
    </div>
	
</body>
</html>