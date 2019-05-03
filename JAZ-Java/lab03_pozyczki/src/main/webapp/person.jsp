<%--
  Created by IntelliJ IDEA.
  User: Filip
  Date: 2019-05-03
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<jsp:useBean id="parameters" class="domain.LoanParameters" scope="session"/>
<jsp:useBean id="loan" class="domain.LoanApplication" scope="session"/>

<jsp:setProperty name="parameters" property="*"/>

Numer wniosku: ${loan.number}
Wnioskowana rata: ${parameters.amount}


<form action="success.jsp">
    <label>Imię: <input type="text" id="firstName" name="firstName"/></label><br/>
    <label>Nazwisko: <input type="text" id="surname" name="surname"/></label><br/>
    <label>Nr pesel: <input type="text" id="pesel" name="pesel"/></label><br/>
    <input type="submit" value="następny krok"/>
</form>

</body>
</html>
