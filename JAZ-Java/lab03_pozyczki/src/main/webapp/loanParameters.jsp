<%@ page import="java.util.Date" %>
<%@ page import="domain.LoanApplication" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Random" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    private Random generator = new Random();
%>

<%
    int number = generator.nextInt() & Integer.MAX_VALUE;
    LoanApplication loan = new LoanApplication();
    loan.setNumber("" + number);
    loan.setDate(new Date());
    session.setAttribute("loan", loan);

%>

Wygenerowany numer wniosku: <%=loan.getNumber() %>
<br/>
Data wygenerowania: <%=loan.getDate() %>

<form action="person.jsp">
    <label>Wnioskowana kwota: <input type="number" id="amount" name="amount" /></label><br/>
    <label>Ilość rat: <input type="number" id="installmentCount" name="installmentCount" /></label><br/>
    <input type="submit" value="następny krok" />
</form>

</body>
</html>
