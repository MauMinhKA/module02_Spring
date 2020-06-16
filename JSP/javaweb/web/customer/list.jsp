<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
    <style>
        body{
            width: 800px;
            margin-left: 35%;
        }
        table{
            border-radius: 10px;
        }
        td{
            background-color: white;
            color: black;
            border: 1.5px solid #af1605;
            text-align: center;
            width: 80px;
            height: 50px;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <h1>Customers</h1>
    <p>
        <a href="/customers?action=create">Create new customer</a>
    </p>
    <table border="1">
        <tr>
            <td style="background: aqua">Name</td>
            <td style="background: aqua">Email</td>
            <td style="background: aqua">Address</td>
            <td style="background: aqua">Edit</td>
            <td style="background: aqua">Delete</td>
        </tr>
        <c:forEach items='${requestScope["customers"]}' var="customer">
            <tr>
                <td><a href="/customers?action=view&id=${customer.getId()}">${customer.getName()}</a></td>
                <td>${customer.getEmail()}</td>
                <td>${customer.getAddress()}</td>
                <td><a href="/customers?action=edit&id=${customer.getId()}">edit</a></td>
                <td><a href="/customers?action=delete&id=${customer.getId()}">delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
