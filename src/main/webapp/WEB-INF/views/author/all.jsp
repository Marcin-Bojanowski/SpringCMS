<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-09-01
  Time: 14:54
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
        <td>First name</td>
        <td>last name</td>
        <td>Action</td>
    </tr>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td><a href="/author/edit?id=${author.id} ">Edit</a>
                <a href="/author/delete?id=${author.id}">Delete</a>
            </td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
