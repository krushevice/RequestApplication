<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<link href='<c:url value="resources/bootstrap/css/bootstrap.min.css"/>' rel="stylesheet">
		<link href='<c:url value="/resources/css/header.css" />' rel="stylesheet">
		
		<script type="text/javascript" src="<c:url value="resources/jquery/jquery-2.1.4.min.js"/>"></script> 
		<script type="text/javascript" src="<c:url value="resources/bootstrap/js/bootstrap.min.js"/>"></script> 
		
	</head>
	<body>
			<input type="hidden" name="userId" id="userId" value="${id}">
			<div id="myHeader">
				<div id="headerText">
					  <nav>				  
						  <input class="button" type="button" id="home" onclick="goHome();" value="Home">					  
						  <input class="button" type="button" id="create" onclick="createRequest();" value="Create">
					 	  <input class="button" type="button" id="view" onclick="viewRequests();" value="Read">
					 	  <input class="button" type="button" id="about" onclick="aboutUs();" value="About us">  
					 	  <input class="button" type="button" id="logOut" onclick="logOut();" value="Log Out">
					  </nav>
				</div>		
			</div>
		<script type="text/javascript">
		function viewRequests() {
			location.href = '/requestApp/viewReq?id=' + $("#userId").val();
		}
		
		function goHome() {
			location.href = '/requestApp/home?id=' + $("#userId").val();
		} 
		
		function createRequest() {
			location.href = '/requestApp/createReq?id=' + $("#userId").val();
		}
		function logOut() {
			location.href = '/requestApp/logout';
		}

		</script>			
			
	</body>
</html>