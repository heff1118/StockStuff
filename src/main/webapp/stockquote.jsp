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

    <!-- (1) Whitney Font -->
    <link rel="stylesheet" href="https://static.ctctcdn.com/lp/fonts/whitney/whitney-current.css" />

    <!-- (2) FED CSS -->
    <link type="text/css" rel="stylesheet" href="https://static.ctctcdn.com/h/fed-framework/1.2.1/fed.min.css" />

    <meta charset="utf-8">
    <title>Stocks</title>
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
<div class="fed-wrapper">

    <h2>
        Select the Stock symbol and date range for your stock: <br>
    </h2>

    <form class="From" name="myform" action="servlets/StockSearchServlet/" method="post">
        <p>Stock Symbol : <input type="text" name="stockQuoteSymbol"></p>

        <p>Select From Time :
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
        </p>
        <p>
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
        </p>
        <p><input type="checkbox" name="dataBase" value="0" id="id1">
        <label for="id1">To pull from the database instead of Yahoo API</label></p>
        <button type="submit" class="Button Button--secondary is-active">Submit</button>
    </form>
</div>
<!-- (4) jQuery -->
<script src="https://static.ctctcdn.com/h/jquery/2.1.4/jquery.min.js"></script>

<!-- (5) FED JavaScript -->
<script src="https://static.ctctcdn.com/h/fed-framework/1.2.1/fed.min.js"></script>
</body>
</html>
