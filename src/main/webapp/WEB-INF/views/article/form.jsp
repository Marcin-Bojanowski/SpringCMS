<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-09-01
  Time: 17:33
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

<form:form method="post" modelAttribute="article">
    <form:errors path="*"/><br>
    Title: <form:input path="title"/><br>
    Content: <form:textarea   cols="20" rows="20" path="content" /><br>
<%--   <form:input path="created" cssStyle="display: none" /><br>--%>
<%--   <form:input path="updated" cssStyle="display: none" /><br>--%>
    Author: <form:select path="author">
    <form:option value="0" label="Wybierz autora"/>
    <form:options items="${authors}" itemValue="id" itemLabel="fullName"/>
</form:select><br>
    Categories: <form:select path="categories" items="${categories}" itemValue="id" itemLabel="name" multiple="true"/><br>
    <input type="submit" value="Send">
</form:form>
</body>
</html>
