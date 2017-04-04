<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>login</title>
	<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
	<script type="text/javascript" src="resources/jquery/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="resources/jquery/jquery-ui.js"></script>
	
	<script type="text/javascript">
		
		function validate(){
			if($("#username").val()==""){
				alert("Username can't be empty!");
				$("#username").focus();
				return false;
			}
			if($("#password").val()==""){
				alert("Password can't be empty!");
				$("#password").focus(); 
				return false;
			}
			
		}
		
	</script>
</head>
<body>
<!--name of the form must be the same as a parametr in @ModelAttribute,  name of inputs the same as class fields -->
 	<form:form id="login" name="loginBean" action="login" method="post" modelAttribute="loginBean" onsubmit="return validate()">
	    <h1>Log In</h1>
	    <c:if test="${not empty message}">
			<div id="message">${message}</div>
		</c:if>
	    <fieldset id="inputs">
	        <form:input id="username" name="username" path="username" placeholder="Username"/>   
	        <form:input id="password" name="password" path="password" placeholder="Password"/>
	    </fieldset>
	    <fieldset id="actions">
	        <input type="submit" id="submit" value="Sign in">
	        <!-- <a href="">Forgot your password?</a><a href="">Register</a> -->
	    </fieldset>
	</form:form>
</body>
</html>