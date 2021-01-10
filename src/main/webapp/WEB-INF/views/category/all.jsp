<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-08-30
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ include file="/WEB-INF/views/home/header.jsp" %>
<table border="1">
    <tr>
        <td>Name</td>
        <td>Description</td>
        <td>Action</td>
    </tr>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td>${category.name}</td>
            <td>${category.description}</td>
            <td><a href="/category/edit?id=${category.id} ">Edit</a>
                <a href="/category/delete?id=${category.id}">Delete</a>
            </td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
