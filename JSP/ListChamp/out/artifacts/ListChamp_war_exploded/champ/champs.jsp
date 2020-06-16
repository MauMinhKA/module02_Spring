<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 6/8/2020
  Time: 10:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>List Champ Of Mậu Minh</title>
    <style>
        table {
            border: #dd0001;
            margin-left: 30%;
            text-align: center;
            font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 600px;
        }
        .container {
            position: relative;
            width: 50%;
        }
        .container:hover .overlay {
            opacity: 1;
        }
        .overlay {
            position: absolute;
            top: 0;
            bottom: 0;
            left: 0;
            right: 0;
            height: 100%;
            width: 100%;
            opacity: 0;
            transition: .5s ease;
            background-color: #061022;
        }
        .text {
            color: white;
            font-size: 20px;
            position: absolute;
            top: 50%;
            left: 50%;
            -webkit-transform: translate(-50%, -50%);
            -ms-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
            text-align: center;
        }
        td,th {
            border: 1.5px solid #dd0700;
            color: #061022;
            padding: 2px;
        }
        tr:nth-child(even){background-color: #e5f283;
        border-radius: 8px}
        tr:hover {background-color: #00dd2a;}
        th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #4CAF50;
            color: white;
        }
        img {
            display: block;
            border-radius: 5px;
            height: auto;
            width: 100%;
        }

        ​
    </style>
</head>
<body>
<table id="tabl1">
<tbody>
<tr style="text-align: center;">
    <th style="text-align: center" width="50">ID</th>
    <th style="text-align: center" width="100">Name</th>
    <th style="text-align: center" width="100">Lane</th>
    <th style="text-align: center" width="100">Role</th>
    <th style="text-align: center;width: 150px">Images</th>
</tr>
<c:forEach items="${requestScope.champList}" var="champ">
    <tr>
        <td>
            <c:out value="${champ.ID}"></c:out>
        </td>
        <td>
            <c:out value="${champ.name}"></c:out>
        </td>
        <td>
            <c:out value="${champ.lane}"></c:out>
        </td>
        <td>
            <c:out value="${champ.role}"></c:out>
        </td>
        <td class="container">
            <img src="<c:out value="${champ.images}"/>"/>
            <div class="overlay">
                <div class="text">Trương Khánh Mậu
                </div>
            </div>
        </td>
    </tr>
</c:forEach>
</tbody>
</table>
</body>
</html>