<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Job</title>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
 <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
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
  
 		<div class="row">
 	
    <div class="col s12 center">
      <div class="card blue lighten-5 z-depth-4">
        <div class="card-content black-text">
          <span class="card-title">Posted By: ${job.user.firstName} ${job.user.lastName}</span>
			<h6>Grade(s): ${job.grades}</h6>
			<h6>School:  ${job.school}</h6>
			<h6>When: ${job.date}</h6>
			<h6>Date Posted: <fmt:formatDate value="${job.createdAt}" pattern="MM-dd-yyyy" /></h6>
			<h6> Description: ${job.description}</h6>
        </div>
      </div>
    </div>
    </div>

 		

			
		
		<div class="row">
		
		
		<div class="col s6">
			
				<h5>All Comments(${comments.size()})</h5>
				
				<c:forEach items="${comments}" var="comment">
					<p style="font-weight:bold;"><i class="material-icons">face</i> <c:out value="${comment.user.firstName}"/> <c:out value="${comment.user.lastName}"/>:</p>
					<p style="margin-left:20px;"><c:out value="${comment.name}"/> - <fmt:formatDate value="${comment.createdAt}" pattern="MM-dd-yyyy" /></p>
				   </c:forEach>
				   
		<div class="col s6">	
				 <h6 style="margin-top:30px;">Add a Comment</h6>
			 <p><form:errors path="commentObj.*"/></p>
			     <form:form method="POST" action="/jobs/${job.id}/addComment" modelAttribute="commentObj">
			     
			 		<p>
			           <form:label path="name">Comment:</form:label>
			           <form:input type="text" path="name"/>
		       		 </p>
		
					<p>	
					<button class="btn waves-effect  blue darken-1" type="submit" name="action">Comment</button>
						
					</p>	
		       		
			     </form:form>
			</div>
		</div>
		</div>
		</div>

		
	
</body>
</html>