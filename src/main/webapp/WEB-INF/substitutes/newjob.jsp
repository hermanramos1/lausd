<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
           <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a Job</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
 <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
 <script type="text/javascript" src="js/app.js"></script>
</head>
<body>

  <nav>
    <div class="nav-wrapper  blue darken-1">
      <a style="font-family:'Comic Sans MS', cursive, sans-serif" href="/home" class="brand-logo right center">Sub LA</a>
      <ul id="nav-mobile" class="left hide-on-med-and-down">
        <li><a href="/home">Jobs</a></li>
        <li><a href="/schools">Schools</a></li>
      </ul>
      <ul id="nav-mobile" class="right hide-on-med-and-down">
      <li><a href="/logout">Logout</a></li>
      </ul>
    </div>
  </nav>
  
	  <div class="container">
	 <h3>Create a new job</h3>
	 <p><form:errors path="jobObj.*"/></p>
	     <form:form method="POST" action="/jobs" modelAttribute="jobObj">
	     
	 		<p>
	           <form:label path="grades">Grade(s):</form:label>
	           <form:input type="text" path="grades"/>
       		 </p>
       		 
       		 <p>
	       		 <form:label path="school">School:</form:label>
	       		 <form:input type="text" path="school"/>
       		 </p>
       		 <p>
		           <form:label path="date">Date(s):</form:label>
		           <form:input type="text" path="date"/>
		      </p>
		      <p>
		           <form:label path="description">Description(optional):</form:label>
		           <form:textarea rows="2"  path="description"/>
		      </p>

			<p>	
			 <button class="btn waves-effect  blue darken-1" type="submit" name="action">Create</button>
				
			</p>	
       		 
       		
	     </form:form>
	</div>
</body>
</html>