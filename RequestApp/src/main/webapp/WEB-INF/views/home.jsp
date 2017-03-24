<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
 <head>
  <meta charset="UTF-8">
  <title>Welcome</title>
  <link rel="stylesheet" href="/WelcomePage/src/main/webapp/WEB-INF/views/Button.css">
  <style>
   button {
    background: #f2f6f8; /* Цвет фона */
    border: 1px solid #7a7b7e; /* Параметры рамки */
    width: 60px; /* Ширина кнопки */
    height: 30px; /* Высота */
    }
  </style>
 </head>
 <body style="background-color: #FFFAF0">
  <h1 style="color: #708090"><p align=center>
  Welcome, ${loginBean.username}!
  </h1>
  <hr align="center" size="3" width="1000" color="#B0C4DE" noshade>
  <form>
   <table cols="4"  frame="void" align="center" width="50%" height="100"> 
    <tr>
     <th colspan="4" style="color: #708090">
     Please, choose the action!
     </th>
    </tr>
    <tr>
     <td align="center"><button>Create</button></td>
     <td align="center"><button>Read</button></td>
     <td align="center"><button>Update</button></td>
     <td align="center"><button>Delete</button></td> 
    </tr>
   </table>
  </form>
</body>
</html>