<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a Donut</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-donut-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Donut Reviews</h2>
    </div>
</div>

<div id="container">
    <h3>Save Donut</h3>
    <form:form action="save" enctype="multipart/form-data" modelAttribute="donut" method="post">
        <table>
            <tr>
                <td><label>Name</label></td>
                <td><form:input path="name"/>
                    <form:errors path="name" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label>Calories</label></td>
                <td><form:input path="calories"/>
                    <form:errors path="calories" cssClass="error"/></td>
            </tr>
            <tr>
                <td><label>Shop</label></td>
                <td>
                    <form:select path="shop" items="${donutShops}" itemLabel="name" itemValue="id">
                    </form:select>
                    <form:errors path="shop" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td><label>Image</label></td>
                <td><input type="file" name="image"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Save" class="save"></td>
            </tr>
        </table>
    </form:form>

    <div style="clear: both;">
        <p>
            <a href="${pageContext.request.contextPath}/donut/list">Back to List</a>
        </p>
    </div>
</div>
</body>
</html>
