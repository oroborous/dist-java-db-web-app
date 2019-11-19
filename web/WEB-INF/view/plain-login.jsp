<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Login</title>
    <link type="text/css" rel="stylesheet" href="${contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="${contextPath}/resources/css/donut-form-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Donut Reviews</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <h3>Login</h3>
        <form:form action="${contextPath}/authenticate" method="POST">
            <table>
                <!-- Only show this message if the user has been logged out -->
                <c:if test="${param.logout != null}">
                    <tr>
                        <td></td>
                        <td>You have been logged out</td>
                    </tr>
                </c:if>
                <tr>
                    <td><label>Username</label></td>
                    <td><input type="text" name="username" value="u"></td> <!-- Spring expects this to have name="username" -->
                </tr>
                <tr>
                    <td><label>Password</label></td>
                    <td><input type="text" name="password" value="p"></td> <!-- Spring expects this to have name="password" -->
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Login"></td>
                </tr>
                <!-- Only show this row if there was a login error -->
                <c:if test="${param.error != null}">
                    <tr>
                        <td></td>
                        <td class="error">Invalid login</td>
                    </tr>
                </c:if>
            </table>
        </form:form>
    </div>

    <div style="clear: both;">
        <p>
            <a href="${contextPath}/donut/list">Back to List</a>
        </p>
    </div>
</div>
</body>
</html>
