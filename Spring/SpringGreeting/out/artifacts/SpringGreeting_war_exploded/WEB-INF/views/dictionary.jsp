<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/10/2020
  Time: 2:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        body{
            margin-left: 42%;
        }
        .tudien {
            width: 300px;
            font-size: 16px;
            border: 2px solid #ccc;
            border-radius: 4px;
            padding: 12px 10px 12px 10px;
        }
        .tudien input {
            width: 300px;
            font-size: 16px;
            border: 2px solid #ccc;
            border-radius: 4px;
            padding: 12px 10px 12px 10px;
        }
    </style>
</head>
<body>
<h2>Vietnamese Dictionary</h2>
<form method="post" action="/dictionary">
    <div class="tudien">
        <input type="text" name="word" placeholder="Enter your word: "/>
        <input type = "submit" id = "submit" value = "Search"/>
    </div>
<c:if test="${result.equals(null)}"><p>not found</p></c:if>
<c:if test="${result!=null}"><p>${result}</p></c:if>
</body>
</html>
