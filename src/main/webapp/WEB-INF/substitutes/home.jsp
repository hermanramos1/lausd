<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
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
  	<div class="row">
	<h2 class="left">Hi ${user.firstName}</h2>
	
	</div>
	
	<h3>Here are the most recent jobs</h3>
	<table class="responsive-table striped">
	    <thead>
	        <tr>
	            <th>Grade(s):</th>
	            <th>When:</th>
	            <th>School:</th>
	            <th>Description</th>
	            <th>Posted By:</th>
	            <th>Date Posted:</th>
	            <th>Action</th>
	            
	        </tr>
	    </thead>
	    <tbody>
       		<c:forEach items="${allJobs}" var="job">
	        <tr>
	            <td><c:out value="${job.grades}"/></td>
	            <td><c:out value="${job.date}"/></td>
	            <td><c:out value="${job.school}"/></td>
	            <td><c:out value="${job.description}"/></td>
	            <td><c:out value="${job.user.firstName}"/></td>
	            <td><fmt:formatDate value="${job.createdAt}" pattern="MM-dd-yyyy" /></td>
	         	<td><a href="/jobs/${job.id}">View Job</a></td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	
	
	<h5>
	<a href="/jobs/newjob">Add a Job</a>
	</h5>

	

	</div>
	
	
</body>
</html>