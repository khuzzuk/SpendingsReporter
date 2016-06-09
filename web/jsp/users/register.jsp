<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register new user</title>
    <link rel="stylesheet" type="text/css" href="/jsp/css/form.css"/>
</head>
<h1>Register new user</h1>
<sf:form method="post" commandName="user">
    <c:out value="${RegistrationFailureMessage}"/><br/>
    <div><sf:errors path="*" cssClass="error" element="div"/></div>
    <div>
    <div><sf:label path="email" cssErrorClass="error">email:</sf:label></div>
    <div><sf:input path="email" type="email" cssErrorClass="error"/></div>
    <div><sf:label path="password" cssErrorClass="error">password: </sf:label></div>
    <div><sf:password path="password" cssErrorClass="error"/></div>
    </div>
    <div><div><input type="submit" value="Register"/></div></div>
</sf:form>
</body>
</html>
