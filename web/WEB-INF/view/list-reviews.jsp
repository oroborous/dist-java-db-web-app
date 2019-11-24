<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Donut Reviews - ${donut.name}</title>
    <link type="text/css" rel="stylesheet" href="${contextPath}/resources/css/style.css">
</head>
<body>

<%@ include file="/WEB-INF/view/includes/header.jsp" %>

<div id="container">

    <div id="content">

        <!-- add review button -->

        <button class="add-button"
                onclick="window.location.href='${contextPath}/review/user/showAddReviewForm'; return false;">Add Review
        </button>

        <!-- construct a "delete" link with donut id -->
        <c:url var="deleteLink" value="/reviews/user/delete">
            <c:param name="donutId" value="${tempDonut.id}"/>
        </c:url>

        <table>
            <tr>
                <th></th>
                <th>Shop</th>
                <th>Name</th>
                <th>Calories</th>
                <th>Date Reviewed</th>
                <th>Action</th>
            </tr>
            <tr>
                <td>
                    <img src="${contextPath}/resources/img/${tempDonut.imagePath}"
                         alt="${tempDonut.name}"></td>
                <td>${tempDonut.shop.name}</td>
                <td><a href="${reviewLink}">${tempDonut.name}</a></td>
                <td>${tempDonut.calories}</td>
                <td>${tempDonut.formattedDate}</td>
                <td>
                    <!-- display the update link -->
                    <a href="${updateLink}">Update</a>
                    |
                    <!-- display the delete link -->
                    <a href="${deleteLink}"
                       onclick="if (!confirm('Are you sure?')) return false">Delete</a>
                </td>
            </tr>
            <c:forEach var="tempReview" items="${donut.reviews}">
            <p>
                <c:forEach begin="0" end="${stars}" var="i">

                </c:forEach>
                    ${tempReview.review}
            </p>
            </c:forEach>

    </div>

</div>

<%@ include file="/WEB-INF/view/includes/footer.jsp" %>

</body>

<script>
    document.onload(function () {
        var canvas = document.getElementById("canvas");
        var ctx = canvas.getContext("2d");
    })

    function drawStar(cx, cy, spikes, outerRadius, innerRadius) {
        var rot = Math.PI / 2 * 3;
        var x = cx;
        var y = cy;
        var step = Math.PI / spikes;

        ctx.strokeSyle = "#000";
        ctx.beginPath();
        ctx.moveTo(cx, cy - outerRadius)
        for (i = 0; i < spikes; i++) {
            x = cx + Math.cos(rot) * outerRadius;
            y = cy + Math.sin(rot) * outerRadius;
            ctx.lineTo(x, y)
            rot += step

            x = cx + Math.cos(rot) * innerRadius;
            y = cy + Math.sin(rot) * innerRadius;
            ctx.lineTo(x, y)
            rot += step
        }
        ctx.lineTo(cx, cy - outerRadius)
        ctx.closePath();
        ctx.lineWidth = 5;
        ctx.strokeStyle = 'blue';
        ctx.stroke();
        ctx.fillStyle = 'skyblue';
        ctx.fill();

    }
</script>

</html>
