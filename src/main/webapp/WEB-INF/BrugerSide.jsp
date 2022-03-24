<%--
  Created by IntelliJ IDEA.
  User: nbh
  Date: 24/03/2022
  Time: 10.47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Din side</title>
</head>
<body>

<h1>Velkommen, du er loggen på din konto ${sessionScope.konto.navn}</h1>

Din saldo er ${sessionScope.konto.saldo}



<h1>Hæv </h1>
<form action="TransaktionServlet">
    <label for="fname">Angiv beløb:</label><br>
    <input type="number" id="fname" name="beløb" value="0"><br>

    <input type="submit" value="Hæv">
</form>




</body>
</html>
