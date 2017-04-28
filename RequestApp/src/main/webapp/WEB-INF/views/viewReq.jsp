<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file='header.jsp'%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="<c:url value="/resources/css/viewReq.css" />" rel="stylesheet">
	</head>
	<body>
		<form:form id="MainForm">
			<c:if test="${not empty message}">
				<div id="message1" class="message1" style="color: red;">${message}</div>
			</c:if>
		<table id="Read" align="center">
			<tr>
				<th colspan="4">That's all you've ordered<hr id="myHR"></th>
			</tr>			
			<tr class="bg">
				<td class="header">Product</td>
        		<td class="header">Type</td>
        		<td class="header">Count</td>
        		<td class="header">Price</td>
       		</tr>
       		<tr class=canChoose>
				<td class="simple"></td>
        		<td class="simple"></td>
        		<td class="simple"></td>
        		<td class="simple"></td>
			</tr>
		</table>
	</form:form>
		<%@ include file='footer.jsp'%>
</body>
</html>