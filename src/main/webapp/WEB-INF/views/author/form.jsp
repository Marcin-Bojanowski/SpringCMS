<%--
  Created by IntelliJ IDEA.
  User: bojan
  Date: 2020-09-01
  Time: 14:57
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

<form:form method="post" modelAttribute="author">
    <form:errors path="*"/><br>
<form:errors path="*"/><br>
    First name: <form:input path="firstName"/><br>
    Last name: <form:input path="lastName"/><br>
    <input type="submit" value="Send">

</form:form>
</body>
</html>
