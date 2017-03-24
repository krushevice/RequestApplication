<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>home</title>
  <link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
  </head>
 <body>
  <form:form id="Choise" name="ChoiceBean" action="Choise" method="post" modelAttribute="ChoiseBean">
   <table cols="4" align="center" width="50%" height="100"> 
    <tr>
     <th id="Greeting" colspan="2">
     Welcome, ${loginBean.username}!
     </th>
    </tr>
    <tr>
     <th colspan="2">
     Please, choose the action!
     </th>
    </tr>
    <tr>
     <td align="center"><button>Create</button></td>
     <td align="center"><button>Read</button></td>
    </tr>
   </table>
  </form:form>
</body>
</html>