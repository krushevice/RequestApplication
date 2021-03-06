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
		<form:form id="MainForm" action="deleteOrder">
			<c:if test="${not empty message}">
				<div id="message1" class="message1" style="color: red;">${message}</div>
			</c:if>
				<c:if test="${not empty all}">
					<input type="hidden" name="userId" id="userId" value="${id}">
					<table id="Read" align="center">
						<tr>
							<th colspan="7">That's all you've ordered<hr class="hr"></th>
						</tr>			
						<tr class="bg">
							<td>№</td>
							<td>Product</td>
			        		<td>Type</td>
			        		<td>Count</td>
			        		<td>Price</td>
			        		<td>Status</td>
			        		<td>Delete</td>
			       		</tr>
						<c:forEach items="${orders}" var="order">
			                <tr class="canChoose">
			                	<td>${order.id}</td>
			                    <td>${order.product.productName}</td>
			                    <td>${order.productType.productTypeName}</td>
			                    <td>${order.count}</td>
			                    <td>${order.price} BYN</td>
			                    <td onclick="toStage('${order.id}')">
				                    <c:choose>
									    <c:when test="${order.status=='1'}">
									        <span style="color:green"> Completed </span> 
									    </c:when>    
									    <c:otherwise>
									        <span style="color:orange"> In progress</span>
									    </c:otherwise>
									</c:choose>
								</td>
								<td>
									<input type="button" onclick="delOrder('${order.id}');" value="Delete"/>
								</td>
			                </tr>
			            </c:forEach>
						<%-- <c:forEach items="${orders}" var="order">
			                <tr class="canChoose">
			                	<td>${order.id}</td>
			                    <td>${order.name}</td>
			                    <td>${order.product_type_name}</td>
			                    <td>${order.count}</td>
			                    <td>${order.price}</td>
			                </tr>
			            </c:forEach> --%>
						<tr class="noBorder">
							<td colspan="7" id="simpleString" align="center">	
								<hr class="hr">			
								Click here to create new request or download .xls file
							</td>
						</tr>
						<tr class="Buttons">
							<td class="noBorder" colspan="7" align="center">
								<input class="btn" type="button" id="create" onclick="createRequest();" value="Create">	
								<c:choose>
									<c:when test="${all == 'yes'}">
										<input class="btn" type="button" id="downloadAll" onclick="downloadAllExcel();" value="Download All">
									</c:when>
									<c:otherwise>
							  			<input class="btn" type="button" id="download" onclick="downloadExcel();" value="Download">
							  		</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</table>
				<input type="hidden" id="orderId" name="orderId" value=""/>
			</c:if>
		</form:form>
	<%@ include file='footer.jsp'%>
	<script type="text/javascript">
			function createRequest() {
				location.href = '/requestApp/createReq?id=' + $("#userId").val();
			}
			function downloadExcel() {
				location.href = 'downloadExcel?id=' + $("#userId").val();
			}
			function downloadAllExcel() {
				location.href = 'downloadAllExcel?id=' + $("#userId").val();
			}
			function toStage(id) {
				location.href = '/requestApp/orderStage?id=' + $("#userId").val() + "&orderId="+id;
			}
			function delOrder(id){
				$("#orderId").val(id);
				$("#MainForm").submit();
			}	
	</script>	
</body>
</html>