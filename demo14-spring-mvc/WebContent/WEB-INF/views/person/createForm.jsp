<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<title>Adding a person</title>
</head>	
<body>
	<h1>
		Create a person
	</h1>
		<form:form modelAttribute="person" method="post">
		  	<fieldset>		
				<legend>Person information</legend>
				<p>
					<form:label	path="firstname">Firstname</form:label><br/>
					<form:input path="firstname" />		
				</p>
				<p>	
					<form:label path="Lastname">Lastname</form:label><br/>
					<form:input path="Lastname" />
				</p>
				<p>	
					<button type="submit">Add</button>
				</p>
			</fieldset>
		</form:form>
</body>
</html>