<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
           <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Schools</title>
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
  	<form class="col s12" method="POST" action="/schools/search">
  	
	<h5> Find a school: <input style="max-width:300px" type="text" name="school" placeholder=" Search.."></h5> 
	 <p><button class="btn waves-effect  blue darken-1" type="submit" name="action">Search</button></p>
	</form>
	
	</div>
	

	<h3>Search Results</h3>
	<table class="responsive-table striped">
	    <thead>
	        <tr>
	            <th>School Name:</th>
	            <th>Number of Reviews:</th>
	            <th>Action</th>
	            
	        </tr>
	    </thead>
	    <tbody>
       		<c:forEach items="${foundSchools}" var="school">
	        <tr>
	            <td><c:out value="${school.name}"/></td>
	            <td><c:out value="${school.name}"/></td>
	         	<td><a href="/schools/${school.id}">View School</a></td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	
	
  	 
	<h3>All Schools</h3>
	<table class="responsive-table striped">
	    <thead>
	        <tr>
	            <th>School Name:</th>
	            <th>Number of Reviews:</th>
	            <th>Action</th>
	            
	        </tr>
	    </thead>
	    <tbody>
       		<c:forEach items="${allSchools}" var="school">
	        <tr>
	            <td><c:out value="${school.name}"/></td>
	            <td><c:out value="${school.name}"/></td>
	         	<td><a href="/schools/${school.id}">View School</a></td>
	        </tr>
	        </c:forEach>
	    </tbody>
	</table>
	
	
	
	
	<h5>
	<a href="/schools/new">Add a School</a>
	</h5>
	</div>
	

</body>
</html>