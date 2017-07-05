<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file='header.jsp'%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<c:url value="/resources/css/viewReq.css" />" rel="stylesheet">

	</head>
	<body>
		<form:form id="MainForm" action="updateStage" method="post" name="stageBean">
			<c:if test="${not empty message}">
				<div id="message1" class="message1" style="color: red;">${message}</div>
			</c:if>
		<input type="hidden" name="userId" id="userId" value="${id}">
		<input type="hidden" name="orderId" id="orderId" value="${orderId}">
		
		<table id="Read" align="center">
			<tr>
				<th colspan="3">Order №${orderId}<hr class="hr"></th>
			</tr>			
			<tr class="bg">
				<td>Manager</td>
        		<td>Cook</td>
        		<td>Director</td>
       		</tr>
			<c:forEach items="${stages}" var="stage">
                <tr class="canChoose">
                    <td>
                    	<input type="hidden" name="stageOne" id="stageOne" value="${stage.stageOne}">
                    	<c:choose>
						    <c:when test="${stage.stageOne=='0'}">
						        -
						    </c:when>
						    <c:when test="${stage.stageOne=='1'}">
						        <input class="btn" type="button" name="one" id="one" onclick="pressStageOne();" value="Approve"/> <!-- if id=1 button not disabled -->
						    </c:when>
						    <c:when test="${stage.stageOne=='2'}">
						        <span style="color:green"> Done </span> 
						    </c:when>   
						    <c:otherwise>
						        Error
						    </c:otherwise>
						</c:choose>
                    </td>
                    <td>
                    	<input type="hidden" name="stageTwo" id="stageTwo" value="${stage.stageTwo}">
                    	<c:choose>
						    <c:when test="${stage.stageTwo=='0'}">
						        -
						    </c:when>
						    <c:when test="${stage.stageTwo=='1'}">
						    	
						        <input class="btn" type="submit" name="two" id="two" onclick="pressStageTwo();" value="Approve"/> 
						    </c:when>
						    <c:when test="${stage.stageTwo=='2'}">
						        <span style="color:green"> Done </span>  
						    </c:when>   
						    <c:otherwise>
						        Error
						    </c:otherwise>
						</c:choose>
                    </td>
                    <td>
                    	<input type="hidden" name="stageThree" id="stageThree" value="${stage.stageThree}">
                    	<c:choose>
						    <c:when test="${stage.stageThree=='0'}">
						        -
						    </c:when>
						    <c:when test="${stage.stageThree=='1'}">
						        <input class="btn" type="submit" name="three" id="three" onclick="pressStageThree();" value="Approve"/>
						    </c:when>
						    <c:when test="${stage.stageThree=='2'}">
						        <span style="color:green"> Done </span>
						    </c:when>   
						    <c:otherwise>
						        Error
						    </c:otherwise>
						</c:choose>
                    </td>
                </tr>
            </c:forEach>

			<%--<tr class="noBorder">
				<td colspan="5" id="simpleString" align="center">	
					<hr class="hr">			
					To create new request click here
				</td>
			</tr>
			<tr class="Buttons">
				<td class="noBorder" colspan="5" align="center">
					<input class="btn" type="button" id="create" onclick="createRequest();" value="Create">		
				</td>
			</tr> --%>
		</table>

	</form:form>
	<%@ include file='footer.jsp'%>
	<script type="text/javascript">
			/* function createRequest() {
				location.href = '/requestApp/createReq?id=' + $("#userId").val();
			}
			function toStage(id) {
				location.href = '/requestApp/orderStage?id=' + $("#userId").val() + "&orderId="+id;
			} */
			function pressStageOne() {
				$("#stageOne").val("2");
				$("#MainForm").submit();
			}
			function pressStageTwo() {
				$("#stageTwo").val("2");
				$("#MainForm").submit();
			}
			function pressStageThree() {
				$("#stageThree").val("2");
				$("#MainForm").submit();
			}
			$( document ).ready(function() {
				alert($("#userId").val());
    			if($("#userId").val()!="1"){
    			alert("2");
    				$(".btn").attr("disabled", true)
    			};			
			});
	</script>	
</body>
</html>