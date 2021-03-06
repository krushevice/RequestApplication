<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>login</title>
		
		<link href="<c:url value="resources/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
		<link href="<c:url value="/resources/css/loginB.css" />" rel="stylesheet">
			
		
		<script type="text/javascript" src="<c:url value="resources/jquery/jquery-2.1.4.min.js"/>"></script> 
		<script type="text/javascript" src="<c:url value="resources/bootstrap/js/bootstrap.min.js"/>"></script> 
		<script type="text/javascript" src="<c:url value="resources/js/loginB.js"/>"></script>
		
	</head>

	<body>
		<div class="container">
	    	<div class="row">
				<div class="col-md-6 col-md-offset-3">
					<span style="float: right">
				    	<a href="?lang=en">en</a> 
				    	<a href="?lang=ru">ru</a>
					</span>
					<div class="panel panel-login">
						<div class="panel-heading">
							<div class="row">
								<div class="col-xs-6">
									<a href="#" class="active" id="login-form-link"><spring:message code="login"/></a>									
								</div>
								<div class="col-xs-6">
									<a href="#" id="register-form-link"><spring:message code="register"/></a>
								</div>
							</div>
							<hr>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
									<form id="login-form" action="login" method="post" style="display: block;" onsubmit="return validate()">
									<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
										<c:if test="${not empty message}">
											<div id="message1" class="message1" style="color: ${color}">${message}</div>
										</c:if>
										
										<div class="form-group">
											<input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="<spring:message code="loginName"/>">
										</div>
										<div class="form-group">
											<input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="<spring:message code="loginPassword"/>">
										</div>
										<!-- <div class="form-group text-center">
											<input type="checkbox" tabindex="3" class="" name="remember" id="remember">
											<label for="remember"> Remember Me</label>
										</div> -->
										<div class="form-group">
											<div class="row">
												<div class="col-sm-6 col-sm-offset-3">
													<input type="submit" name="login-submit" id="login-submit" tabindex="4" class="form-control btn btn-login" value="<spring:message code="loginButton"/>">
												</div>
											</div>
										</div>
										<!-- <div class="form-group">
											<div class="row">
												<div class="col-lg-12">
													<div class="text-center">
														<a href="http://phpoll.com/recover" tabindex="5" class="forgot-password">Forgot Password?</a>
													</div>
												</div>
											</div>
										</div> -->
									</form>
									<form id="register-form" action="register" method="post" style="display: none;" onsubmit="return validate()">
										<c:if test="${not empty message}">
											<div id="message1" class="message1" style="color: ${color}">${message}</div>
										</c:if>
										<div class="form-group">
											<input type="text" name="username" id="username" tabindex="1" class="form-control" placeholder="<spring:message code="loginName"/>">
											<form:errors path="username"/>
										</div>
										<div class="form-group">
											<input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="<spring:message code="loginPassword"/>">
											<form:errors path="password"/>
										</div>
										<div class="form-group">
											<input type="password" name="confirm-password" id="confirm-password" tabindex="2" class="form-control" placeholder="<spring:message code="registerRepeat"/>">
										</div>
										<div class="form-group">
											<div class="row">
												<div class="col-sm-6 col-sm-offset-3">
													<input type="submit" name="register-submit" id="register-submit" tabindex="4" class="form-control btn btn-register" value="<spring:message code="registerButton"/>">
												</div>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
