<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="resources/js/linkedselect.js"></script>
<style>
    td select,
    td input {
      width: 150px;
      height: 25px;
      
    }

    label {
      display: block;
    }

    .error input,cookie
    .error textarea {
      border: 1px solid red;
    }

    .error {
      color: red;
    }
  </style>
<title>Insert title here</title>
</head>
<body>
	<select id="List1">
         	 <option value="cake">Cake</option>
             <option value="cupcake">Cupcake</option>
             <option value="cookie">Cookie</option>
             <option value="icecream">Ice-cream</option>
    </select>
    
     <select id="List2"></select>
    
     <select id="List3">
       		<option></option>
       		<option value="1">1</option>
       		<option value="2">2</option>
       		<option value="3">3</option>
       		<option value="4">4</option>
       		<option value="5">5</option>
       		<option value="6">6</option>
       		<option value="7">7</option>
       		<option value="8">8</option>
       		<option value="9">9</option>
       		<option value="10">10</option>
     </select>	
	<script type="text/javascript">
		var syncList1 = new syncList;
		syncList1.dataList = {
			'cake':{
				'1':'Chocolate',
				'2':'Vanilla',
				'3':'Strawberry',
				'4':'Apple',
				'5':'Caramel'
			},
			'cupcake':{
				'1':'Cranberry',
				'2':'Cherry',
				'3':'Blueberry',
				'4':'Banana'	
			},
			'cookie':{
				'1':'Oat',
				'2':'Rice',
				'3':'Wheaten',
				'4':'Banana'
			},
			'icecream':{
				'1':'Mint',
				'2':'Chocolate',
				'3':'Vanilla',
				'4':'Cherry',
				'5':'Raspberries',
		        '6':'Coconut'
				
			}
		}
		syncList1.sync("List1","List2");
	
	</script>
</body>
</html>