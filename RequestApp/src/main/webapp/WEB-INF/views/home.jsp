<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file='header.jsp'%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>home</title>
<link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">

<script type="text/javascript">
	function createRequest() {
		location.href = '/requestApp/createRequest';
	}
	function viewRequests() {
		//parent.openLayerDialog("");
		location.href = '/requestApp/viewRequests';
	}
</script>


</head>
<body>
	<form:form id="Choise">
		<table cols="4" align="center" width="50%" height="100">
			<tr>
				<th id="Greeting" colspan="2">Welcome, ${loginBean.username}!</th>
			</tr>
			<tr>
				<th colspan="2">Please, choose the action! <%-- <a href="<c:url value="/createRequest" />"> sssss</a> --%>
				</th>
			</tr>
			<tr>
				<td align="center"><input class="btn" type="button" id="create"
					onclick="createRequest();" value="Create"></td>
				<td align="center"><input class="btn" type="button" id="view"
					onclick="viewRequests();" value="Read"></td>
			</tr>
		</table>
	</form:form>
</body>
<%@ include file='footer.jsp'%>
</html>