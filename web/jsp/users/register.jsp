<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register new user</title>
</head>
<body>
 <h1>Register new user</h1>
 <sf:form method="post" commandName="user">
     <c:out value="${RegistrationFailureMessage}"/>
     email: <sf:input path="email" type="email"/> <br/>
     password: <sf:password path="password"/>
     <input type="submit" value="Register"/>
 </sf:form>
</body>
</html>
