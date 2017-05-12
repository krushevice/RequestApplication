<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file='header.jsp'%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<c:url value="/resources/css/reqest.css" />" rel="stylesheet">
		<script type="text/javascript" src="resources/js/linkedselect.js"></script>
	</head>
	<body>
		<form:form id="MainForm" action="createReq" name="reqBean" method="post" onsubmit="return validate()">
			<c:if test="${not empty message}">
				<div id="message1" class="message1" style="color: red;">${message}</div>
			</c:if>
		<input type="hidden" name="userId" id="userId" value="${id}">
		<table id="Request" align="center">
			<tr>
				<th colspan="2">Please, choose something!<hr id="myHR" class="hr"></th>
			</tr>			
			<tr>
				<td class="yourTD">Product</td>
        		<td class="yourTD">
         			<select class="yourChoise" name="product" id="List1">
         			    <option></option>
           				<option value="1">Cake - 10 BYN / piece</option>
            			<option value="2">Cupcake - 7 BYN / package</option>
            			<option value="3">Cookie - 4 BYN / package</option>
            			<option value="4">Ice-cream - 2 BYN / piece</option>
          			</select>
       			 </td>
       		</tr>
       		<tr>
       			 <td class="yourTD">Type</td>
        		<td class="yourTD">
         			<select class="yourChoise" name="productType" id="List2">
          			</select>
       			 </td>
			</tr>
			<tr>
				<td  class="yourTD">Count</td>
				<td class="yourTD"><input type="text" class="yourChoise" name="count" id="count" maxlength="10" placeholder="count" onchange="displayPrice();"></td>
       		</tr>
       		<tr>
				<td height="20" id="priceField" colspan="2">
					&nbsp;
					<input type="hidden" id="price" name="price"/>
				</td>
			</tr>
			<tr class="Buttons">
				<td  colspan="2" align="center">
					<input class="btn" type="button" id="cancel" onclick="goHome();" value="Cancel">
					<input class="btn" type="submit" id="submit" value="Submit">
					<hr id="myHR" class="hr">
				</td>
			</tr>
			<tr>
				<td colspan="2" id="simpleString" align="center">
					To read your previous requests click here
				</td>
			</tr>
			<tr class="Buttons">
			<td colspan="2" align="center">
				<input class="btn" type="button" id="view" onclick="viewRequests();" value="Read">
				</td>
			</tr>
		</table>
		
		
		<script type="text/javascript">
			var syncList1 = new syncList;
			syncList1.dataList = {
				'1':{
					'1':'Chocolate',
					'2':'Vanilla',
					'3':'Strawberry',
					'4':'Apple',
					'5':'Caramel'
				},
				'2':{
					'6':'Cranberry',
					'7':'Cherry',
					'8':'Blueberry',
					'9':'Banana'	
				},
				'3':{
					'10':'Oat',
					'11':'Rice',
					'12':'Wheaten'
				},
				'4':{
					'13':'Mint',
					'1':'Chocolate',
					'2':'Vanilla',
					'7':'Cherry',
					'14':'Raspberries',
					'15':'Coconut'
					
				}
			}
			syncList1.sync("List1","List2");
	
			
			var prices = [10, 7, 4, 2];
			
			function displayPrice() {
				var firstList = document.getElementById("List1");
				var secondList = document.getElementById("List2");
				var what = firstList.options[firstList.selectedIndex].value;
				var which = secondList.options[secondList.selectedIndex].value;		
			    var countField = document.getElementById("count").value;
			    var thisPrice = prices[what - 1] * countField;
			    document.getElementById('priceField').firstChild.data = thisPrice + '    BYN';
			    document.getElementById('price').value = thisPrice;
			}
			
			function viewRequests() {
				location.href = '/requestApp/viewReq?id=' + $("#userId").val();
			}
			
			function goHome() {
				location.href = '/requestApp/home?id=' + $("#userId").val();
			}
			
			function validate() {
				if($("#List1").val()==""){
					alert("Please, choose a product");
					$("#List1").focus();
					return false;
				}
				if($("#List2").val()==""){
					alert("Please, choose a product type");
					$("#List2").focus(); 
					return false;
				}
				if ($("#count").val() == "" || +($("#count").val()) <= 0 || $("#price").val() == "" || +($("#price").val()) <= 0) {
					alert("Count must be positive");
					$("#price").focus(); 
					return false;
				}
				var firstList = document.getElementById("List1");
				var secondList = document.getElementById("List2");
				var what = firstList.options[firstList.selectedIndex].value;
				var which = secondList.options[secondList.selectedIndex].value;		
			    var countField = document.getElementById("count").value;
			    if (countField <= 0) {
			    	return false;
			    } else {
			    	var thisPrice = prices[what - 1] * countField;			
					if(!confirm("Do you really want to pay " + thisPrice + " BYN?")) {
						alert ("Ok...:(");
						return false;
					}
			    }
				return true;
			}
	</script>
	</form:form>
		<%@ include file='footer.jsp'%>
</body>
</html>