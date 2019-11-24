<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Donut Reviews</title>
    <link type="text/css" rel="stylesheet" href="${contextPath}/resources/css/style.css">
</head>
<body>

<%@ include file="/WEB-INF/view/includes/header.jsp" %>

<div id="container">

    <div id="content">

        <!-- Only logged-in users can see this button -->
        <security:authorize access="hasRole('USER')">
            <!-- add donut button -->
            <button class="add-button"
                    onclick="window.location.href='${contextPath}/donut/user/showAddDonutForm'; return false;">Add Donut
            </button>
        </security:authorize>

        <!-- search form -->
        <form:form action="search" method="GET">
            Search donuts <input type="search" name="searchTerm"/>
            <input type="submit" value="Search" class="add-button"/>
        </form:form>

        <!-- donut list table -->

        <table>
            <tr>
                <th></th>
                <th>Shop</th>
                <th>Name</th>
                <th>Calories</th>
                <th>Date Reviewed</th>

                <!-- Don't show this column if not logged in -->
                <security:authorize access="hasAnyRole('USER,ADMIN')">
                    <th>Action</th>
                </security:authorize>
            </tr>
            <c:forEach var="tempDonut" items="${donuts}">

                <!-- construct an "update" link with donut id -->
                <!-- c:url is same as JSP's response.encodeURL() -->
                <c:url var="updateLink" value="/donut/user/showUpdateDonutForm">
                    <c:param name="donutId" value="${tempDonut.id}"/>
                </c:url>

                <!-- construct a "delete" link with donut id -->
                <c:url var="deleteLink" value="/donut/admin/delete">
                    <c:param name="donutId" value="${tempDonut.id}"/>
                </c:url>

                <!-- construct a "view reviews" link with donut id -->
                <c:url var="reviewLink" value="../reviews/list">
                    <c:param name="donutId" value="${tempDonut.id}"/>
                </c:url>

                <tr>
                    <td>
                        <img src="${contextPath}/resources/img/${tempDonut.imagePath}"
                             alt="${tempDonut.name}"></td>
                    <td>${tempDonut.shop.name}</td>
                    <td><a href="${reviewLink}">${tempDonut.name}</a></td>
                    <td>${tempDonut.calories}</td>
                    <td>${tempDonut.formattedDate}</td>

                    <!-- Don't show this column if not logged in -->
                    <security:authorize access="hasAnyRole('USER,ADMIN')">
                        <td>
                            <!-- display the update link -->
                            <a href="${updateLink}">Update</a>

                            <!-- Only admin can delete -->
                            <security:authorize access="hasRole('ADMIN')">
                                |
                                <!-- display the delete link -->
                                <a href="${deleteLink}"
                                   onclick="if (!confirm('Are you sure?')) return false">Delete</a>
                            </security:authorize>
                        </td>
                    </security:authorize>

                </tr>
            </c:forEach>
        </table>

    </div>

</div>

</body>
</html>
