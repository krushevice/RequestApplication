<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Create</title>
		<%@ include file='header.jsp'%>
		
		<script type="text/javascript">
			function changeProduct(){
				//alert("1");
				if($('#product').val()==""){
					a//lert("2");
					$('#cakeType').val("");
					$('#cakeType').prop('disabled', true);		
				}else{
					alert("3");
					/* $('#cakeType').disabled = ""; */
					$('#cakeType').prop('disabled', false);			
				}				
			}
			
		</script>
	
	</head>
	
	<body>
		<div>
			<span> Product:</span> 
			<select id="product" onchange="changeProduct()">
				<option value=""></option>
				<option value="1">cake</option>
				<option value="2">ice cream</option>
				<option value="3">chocolate</option>
			</select> 
			<span> Type:</span> 
			<select id="cakeType" disabled>
				<option></option>
				<option>cake</option>
				<option>ice cream</option>
				<option>chocolate</option>
			</select> 
			<span> Count:</span> 
			<input type="text" size="5"/> 
			<span> Cost:</span> 
			<!-- <input type="text" /> -->
		</div>
	
		<div>
			<input type="button" value="make an order"/> 
		</div>
		
		<%@ include file='footer.jsp'%>
	</body>

</html>