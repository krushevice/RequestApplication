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
				location.href = '/requestApp/createReq?id=' + $("#userId").val();
			}
			function viewRequests() {
				location.href = '/requestApp/viewReq?id=' + $("#userId").val();
			}
			function viewAllRequests() {
				location.href = '/requestApp/viewAllReq?id=' + $("#userId").val();
			}
		</script>
		
		
	</head>
	<body>
		<form:form id="Choise">
			<input type="hidden" name="role" id="role" value="${role}">
			<input type="hidden" name="userId" id="userId" value="${id}">
			<c:if test="${not empty role}">									
				<table align="center" width="400" height="100">
					<tr>
						<th id="Greeting" colspan="3">Welcome!<hr id="myHR"></th>
					</tr>
					<tr>
						<td id="asking" colspan="3" align="center" width="130">Please, choose the action!</td>
					</tr>
					<tr>
						<td align="center"><input class="btn" type="button" id="create"
							onclick="createRequest();" value="Create"></td>
						<td align="center"><input class="btn" type="button" id="view"
							onclick="viewRequests();" value="Read"></td>		
					
					<c:choose>
						  <c:when test="${role=='admin'}">
						    <td align="center"><input class="btn" type="button" id="viewAll"
								onclick="viewAllRequests();" value="Read all">
							</td>
						  </c:when>
						  <c:otherwise>
						    <td/>
						  </c:otherwise>
					</c:choose>
					</tr>
				</table>
			</c:if>
			
		</form:form>
		
		<%@ include file='footer.jsp'%>
	</body>
</html>
