<%@ page import="domain.LoanApplication" %><%--
  Created by IntelliJ IDEA.
  User: Filip
  Date: 2019-05-03
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:useBean id="loanService" class="services.LoanService" scope="application"/>
    <jsp:useBean id="loan" class="domain.LoanApplication" scope="session"/>
    <jsp:useBean id="parameters" class="domain.LoanParameters" scope="session"/>
    <jsp:useBean id="person" class="domain.Person" scope="session"/>

    <jsp:setProperty name="person" property="*"/>

<%
    loan.setParameters(parameters);
    loan.setPerson(person);
    loanService.add(loan);
%>
<ul>
    <%
        for(LoanApplication loanApplication: loanService.getAll()){
    %>
    <li>Wniosek: <%=loanApplication.getNumber()
                    + " Osoba: " + loanApplication.getPerson().getSurname()
                    + " Kwota: " + loanApplication.getParameters().getAmount() %>
    </li>
    <%
        }
    %>
</ul>

</body>
</html>
