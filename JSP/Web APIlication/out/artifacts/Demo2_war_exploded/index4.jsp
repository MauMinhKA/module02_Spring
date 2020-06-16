<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/8/2020
  Time: 9:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/chietkhau">
    <div class="chuyendoi">
        <label>priceProduct: </label><br/>
        <input type="text" name="priceProduct"  /><br/>
        <label>DiscountPercent: </label><br/>
        <input type="text" name="DiscountPercent"  /><br/>
        <input type = "submit" id = "submit" value = "Converter"/>
    </div>
</form>
</body>
</html>
