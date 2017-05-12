<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=750, user-scalable=yes">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Ошибка 500</title>
</head>
<body >
	<%@ include file='../header.jsp'%>
		<i 	style="	position: absolute;
    				top: 10%;
    				left: 35%;
    				color: #9E9C9C;
    				font-size: 5000% !important;"
    		class="fa fa-exclamation-triangle fa-6x">
    	</i>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<div class="row">
			<div class="col-xs-6 btn-primary" style="height:125px; font-size:60px; padding:20px 50px;" >
				ОШИБКА 500
			</div>
		</div>
		<br>
		<div class="row">
			<div class="col-xs-6 btn-primary" style="height:50px; font-size:20px; padding:10px 50px;" >
				Внутренняя ошибка сервера
			</div>
		</div>
	<%@ include file='../footer.jsp'%>
</body>
</html>