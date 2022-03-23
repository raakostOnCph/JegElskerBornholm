<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<h1>liste af kontoer</h1>

<c:forEach items="${applicationScope.kontis}" var="element">

    ${element.value.navn} : ${element.value.saldo}
    <br>



</c:forEach>


</body>
</html>

