<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
				<table align="center" width="450" height="100">
					<tr>
						<th id="Greeting" colspan="3">Welcome!<hr class="myHR"></th>
					</tr>
					<tr>
						<td id="asking" colspan="3" align="center" width="130">Please, choose the action!</td>
					</tr>
					<tr>
						<td id="buttons" colspan="2" align="center">
						<input class="btn" type="button" id="create" onclick="createRequest();" value="Create">						
						<input class="btn" type="button" id="view" onclick="viewRequests();" value="Read">				
						<hr class="myHR">
						</td>
					</tr>
					<c:choose>
						  <c:when test="${role=='admin'}">
						  	<tr>
						    	<td id="simpleString" colspan="2" align="center">
						    		Congratulations, you are admin, so you can
						    	</td>
						    </tr>
						    <tr>
						    	<td colspan="2" align="center">
						    		<input class="btn" type="button" id="viewAll" onclick="viewAllRequests();" value="Read all">
								</td>
							</tr>
						  </c:when>
						  <c:otherwise>
						    <td/>
						  </c:otherwise>
					</c:choose>
				</table>
			</c:if>
			
		</form:form>
		
		<%@ include file='footer.jsp'%>
	</body>
</html>
