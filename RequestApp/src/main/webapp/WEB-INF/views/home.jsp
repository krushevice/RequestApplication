<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file='header.jsp'%>
	<style>
    	td select,
   		td input {
      		width: 150px;
      		height: 35x;
      
    	}
		label {
        	display: block;
   			}
  	</style>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <link href="<c:url value="resources/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
		<link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
		<script type="text/javascript">
			function createRequest() {
				location.href = '/requestApp/createReq';
			}
			function viewRequests() {
				location.href = '/requestApp/viewReq';
			}
		</script>
		
		
	</head>
	<body>
		<form:form id="Choise">
			<table align="center" width="400" height="100">
				<tr>
					<th id="Greeting" colspan="2">Welcome, ${loginBean.username}!<hr id="myHR"></th>
				</tr>
				<tr>
					<td id="asking" colspan="2" align="center" width="130">Please, choose the action!</td>
				</tr>
				<tr>
					<td align="center"><input class="btn" type="button" id="create"
						onclick="createRequest();" value="Create"></td>
					<td align="center"><input class="btn" type="button" id="view"
						onclick="viewRequests();" value="Read"></td>
				</tr>
			</table>
		</form:form>
		<%@ include file='footer.jsp'%>
	</body>
</html>