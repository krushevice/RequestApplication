<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file='header.jsp'%>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link href="<c:url value="/resources/css/request.css" />" rel="stylesheet">
		<script type="text/javascript" src="resources/js/linkedselect.js"></script>
		<style>
    		td select,
   		    td input {
      		width: 150px;
      		height: 35x;
      
    		}
  		</style>
	</head>
	<body>
		<form:form id="Request">
		<table align="center" width="400" height="200">
			<tr>
				<th id="Greeting" align="center" colspan="2" >Please, choose something!</th>
			</tr>
			<tr>
				<td align="center" width="60">Product</td>
        		<td align="center" width="60">
         			<select  id="List1">
         			    <option></option>
           				<option value="1">Cake - 10 BYN / piece</option>
            			<option value="2">Cupcake - 7 BYN / package</option>
            			<option value="3">Cookie - 4 BYN / package</option>
            			<option value="4">Ice-cream - 2 BYN / piece</option>
          			</select>
       			 </td>
       		</tr>
       		<tr>
       			 <td align="center" width="60">Type</td>
        		<td align="center" width="60">
         			<select id="List2">
          			</select>
       			 </td>
			</tr>
			<tr>
				<td align="center" width="60">Count</td>
				<td><input type="text" id="myId" maxlength="10" size="40" placeholder="count" onchange="displayPrice();"></td>
       		</tr>
       		<tr>
				<td align="center" height="20" id="priceField" colspan = "2">
					&nbsp;
				</td>
			</tr>
			<tr id="Buttons" >
				<td colspan="1" align="center" style="width: 325px; "><input class="btn" type="button" id="cancel"
						onclick="cancelRequest();" value="Cancel"></td>
				<td colspan="1" align="center"><input class="btn" type="button" id="submit"
						onclick="submitRequest();" value="Submit"></td>
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
					'1':'Cranberry',
					'2':'Cherry',
					'3':'Blueberry',
					'4':'Banana'	
				},
				'3':{
					'1':'Oat',
					'2':'Rice',
					'3':'Wheaten'
				},
				'4':{
					'1':'Mint',
					'2':'Chocolate',
					'3':'Vanilla',
					'4':'Cherry',
					'5':'Raspberries',
					'6':'Coconut'
					
				}
			}
			syncList1.sync("List1","List2");
	

			var prices = [10, 7, 4, 2];
       
			function submitRequest() {	
				var firstList = document.getElementById("List1");
				var secondList = document.getElementById("List2");
				var what = firstList.options[firstList.selectedIndex].value;
				var which = secondList.options[secondList.selectedIndex].value;		
			    var countField = document.getElementById("myId").value;
			    var thisPrice = prices[what - 1] * countField;
				confirm("Do you really want to pay " + thisPrice + " BYN?");
			}
			
			function displayPrice() {
				var firstList = document.getElementById("List1");
				var secondList = document.getElementById("List2");
				var what = firstList.options[firstList.selectedIndex].value;
				var which = secondList.options[secondList.selectedIndex].value;		
			    var countField = document.getElementById("myId").value;
			    var thisPrice = prices[what - 1] * countField;
			    document.getElementById('priceField').firstChild.data = thisPrice + '    BYN';
			}
	</script>
	</form:form>
		<%@ include file='footer.jsp'%>
</body>
</html>