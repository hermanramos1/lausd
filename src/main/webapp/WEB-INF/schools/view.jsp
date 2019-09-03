<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
           <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${school.name}</title>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
 <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
 <script type="text/javascript" src="js/app.js"></script>
 <link rel="stylesheet" type="text/css" href="css/schoolcss.css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<body>

  <nav>
    <div class="nav-wrapper  blue darken-1">
      <a style="font-family:'Comic Sans MS', cursive, sans-serif" href="/home" class="brand-logo right center">Sub LA </a>
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

		<h3 class="center">${school.name}</h3>
		
		<div class="row">
			<div class="col s6">
				<h5>Overall Rating</h5><h5> ${schoolRating}/10</h5>
				
				</div>
			
			<div class="col s6">	
				
				<h5>Rate</h5>
				 <p><form:errors path="ratingObj.*"/></p>
			     <form:form method="POST" action="/schools/${school.id}/addRating" modelAttribute="ratingObj">
			     
			 		<p>
			           <form:label path="rating">Rating(Out of 10):</form:label>
			           <form:input type="text" path="rating"/>
		       		 </p>
		
					<p>	
					<button class="btn waves-effect  blue darken-1" type="submit" name="action">Rate</button>
						
					</p>	
		       		 
		       		
			     </form:form>

		</div>
	</div>
	
	<div class="row">

		<div class="col s6">
				 <h4>Write a Review</h4>
			 <p><form:errors path="commentObj.*"/></p>
			     <form:form method="POST" action="/schools/${school.id }/addComment" modelAttribute="commentObj">
			     
			 		<p>
			           <form:label path="name">Review:</form:label>
			           <form:textarea rows="4" type="text" path="name"/>
		       		 </p>
		
					<p>	
					<button class="btn waves-effect  blue darken-1" type="submit" name="action">Add</button>
						
					</p>	
		       		 
		       		
			     </form:form>
			</div>
		
				<div class="col s6">
				<h5>Reviews(${school.comments.size()})</h5>
				
				<c:forEach items="${allReviews}" var="review">
					<p style="font-weight:bold;"><i class="material-icons">face</i> <c:out value="${review.user.firstName}"/> <c:out value="${review.user.lastName}"/></p>
					<p style="margin-left:20px;"><c:out value="${review.name}"/> - <fmt:formatDate value="${review.createdAt}" pattern="MM-dd-yyyy" /></p>
				   </c:forEach>
				</div>
		</div>
	</div>
	


</body>
</html>