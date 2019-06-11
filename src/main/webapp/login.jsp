<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Pawel
  Date: 2019-03-30
  Time: 23:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>log</title>
        
    <link rel="stylesheet" href="style.css" type="text/css"/>
    <title>Title</title>
    <style>
        table#nat {
            width: 50%;
            background-color: #c48ec5;
        }
    </style>
</head>
<body>
<div id="panel">
    <form action="log" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username">

        <label for="password">Password:</label>
        <input type="password" id="password" name="password">

        <div id="lower">
            <input type="submit" value="login">
        </div>

    </form>
</div>

<c:forEach var="customer" items="${customers}">

    <form>
        <div class="customer"></div>
            ${customer.getName()}
            ${customer.getSurname()}

        </label>

    </form>
</c:forEach>

</table>
</body>
</html>
