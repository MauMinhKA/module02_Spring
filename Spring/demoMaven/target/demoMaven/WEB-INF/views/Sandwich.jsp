
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/saveSandwich">
    <input type="checkbox" name="condiment" value="Lettuce"><label>Lettuce</label>
    <input type="checkbox" name="condiment" value="Tomamo"><label>Tomamo</label>
    <input type="checkbox" name="condiment" value="Mustard"><label>Mustard</label>
    <input type="checkbox" name="condiment" value="Spourts"><label>Spourts</label>

    <hr>
    <input type="submit" value="Save">
    <c:forEach items="${condiment}" var="condiment">
        <p>${condiment}</p>
    </c:forEach>

</form>

</body>
</html>
