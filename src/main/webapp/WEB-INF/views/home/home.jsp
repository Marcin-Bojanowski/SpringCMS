<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-08-30
  Time: 22:45
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
        <td>Title</td>
        <td>Content</td>
        <td>Created</td>
        <td>Updated</td>
        <td>Author</td>
        <td>Categories</td>
        <td>Action</td>
    </tr>
    <c:forEach items="${lastFive}" var="article">
        <tr>
            <td>${article.title}</td>
            <td>${article.content}</td>
            <td>${article.created}</td>
            <td>${article.updated}</td>
            <td>${article.author.fullName}</td>
            <td><c:forEach items="${article.categories}" var="category">
                ${category.name}<br>
            </c:forEach>

            </td>
            <td><a href="/article/edit?id=${article.id} ">Edit</a>
                <a href="/article/delete?id=${article.id}">Delete</a>
            </td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
