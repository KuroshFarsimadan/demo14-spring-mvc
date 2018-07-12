<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Showing the person information</title>
</head>	
<body>
	<h1>
		Person information 
	</h1>
	<p><c:out value="${person.firstname}" default="-----"/></p>
	<p><c:out value="${person.lastname}" default="-----"/></p>
	<p><a href="new">Back</a>
</body>
</html>