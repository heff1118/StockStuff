<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aheffernan
  Date: 7/16/17
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Stocksss</title>

</head>
<body>

<h2>
    Select the Stock symbol and date range for your stock: <br>
</h2>

<P></P>

<form name="myform" action="servlets/StockSearchServlet/" method="post">
    Stock Symbol : <input type="text" name="stockQuoteSymbol"><br>

    Select From Time :
    <select name="monthFrom">
        <option value="Jan">January</option>
        <option value="Feb">February</option>
        <option value="Mar">March</option>
        <option value="Apr">April</option>
        <option value="May">May</option>
        <option value="Jun">June</option>
        <option value="Jul">July</option>
        <option value="Aug">August</option>
        <option value="Sep">September</option>
        <option value="Oct">October</option>
        <option value="Nov">November</option>
        <option value="Dec">December</option>
    </select>

    <select name="dayFrom">
        <d:forEach begin="1" end="31" var="day">
            <option><d:out value="${day}"/></option>
        </d:forEach>
    </select>

    <select name="yearFrom">
        <d:forEach begin="2000" end="2017" var="year">
            <option><d:out value="${year}"/></option>
        </d:forEach>
    </select>
    <br>
    Select Until Time:

    <select name="monthUntil">
        <option value="Jan">January</option>
        <option value="Feb">February</option>
        <option value="Mar">March</option>
        <option value="Apr">April</option>
        <option value="May">May</option>
        <option value="Jun">June</option>
        <option value="Jul">July</option>
        <option value="Aug">August</option>
        <option value="Sep">September</option>
        <option value="Oct">October</option>
        <option value="Nov">November</option>
        <option value="Dec">December</option>
    </select>

    <select name="dayUntil">
        <d:forEach begin="1" end="31" var="day">
            <option><d:out value="${day}"/></option>
        </d:forEach>
    </select>

    <select name="yearUntil">
        <d:forEach begin="2000" end="2017" var="year">
            <option><d:out value="${year}"/></option>
        </d:forEach>
    </select>

    <input type="SUBMIT" value="OK">
    <input type="HIDDEN" name="submit" value="true">
</form>

</body>
</html>
