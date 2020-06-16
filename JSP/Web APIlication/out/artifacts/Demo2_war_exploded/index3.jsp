<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/8/2020
  Time: 6:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Từ Điển Đơn Giản</title>
<%--    <link rel="stylesheet" type="text/css" > --%>
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
<form method="post" action="/index3">
    <div class="tudien">
    <input type="text" name="txtSearch" placeholder="Enter your word: "/>
    <input type = "submit" id = "submit" value = "Search"/>
    </div>
</form>
</body>
</html>
