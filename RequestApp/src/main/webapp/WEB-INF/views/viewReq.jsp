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
				<th colspan="4">That's all you've ordered<hr class="hr"></th>
			</tr>			
			<tr class="bg">
				<td>Product</td>
        		<td>Type</td>
        		<td>Count</td>
        		<td>Price</td>
       		</tr>
       		<tr class=canChoose>
				<td></td>
        		<td></td>
        		<td></td>
        		<td></td>
			</tr>
			<tr class="noBorder">
				<td colspan="4" id="simpleString" align="center">	
					<hr class="hr">			
					To create new request click here
				</td>
			</tr>
			<tr class="Buttons">
				<td class="noBorder" colspan="4" align="center">
					<input class="btn" type="button" id="create" onclick="createRequest();" value="Create">		
				</td>
			</tr>
		</table>
	</form:form>
	<%@ include file='footer.jsp'%>
	<script type="text/javascript">
			function createRequest() {
				location.href = '/requestApp/createReq';
			}
	</script>	
</body>
</html>