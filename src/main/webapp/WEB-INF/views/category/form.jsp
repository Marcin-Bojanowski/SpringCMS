<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-08-30
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add category</title>
</head>
<body>
<%@ include file="/WEB-INF/views/home/header.jsp" %>

<form:form method="post" modelAttribute="category">
    <form:errors path="*"/><br>
    <form:errors path="*"/><br>
   Name: <form:input path="name"/><br>
    Description: <form:textarea path="description" cols="15" rows="5"/><br>
    <input type="submit" value="Send">

</form:form>
</body>
</html>
