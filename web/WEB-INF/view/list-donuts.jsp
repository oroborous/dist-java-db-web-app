<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Donuts</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>Donut Reviews</h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <!-- add donut button -->

        <button class="add-button"
                onclick="window.location.href='showAddDonutForm'; return false;">Add Donut</button>

        <!-- donut list table -->

        <table>
            <tr>
                <th></th>
                <th>Shop</th>
                <th>Name</th>
                <th>Calories</th>
                <th>Date Reviewed</th>
            </tr>
            <c:forEach var="tempDonut" items="${donuts}">
                <tr>
                    <td>
                        <img src="${pageContext.request.contextPath}/resources/img/${tempDonut.imagePath}"
                             alt="${tempDonut.name}"></td>
                    <td>${tempDonut.shop.name}</td>
                    <td>${tempDonut.name}</td>
                    <td>${tempDonut.calories}</td>
                    <td>${tempDonut.formattedDate}</td>
                </tr>
            </c:forEach>
        </table>

    </div>

</div>

</body>
</html>
