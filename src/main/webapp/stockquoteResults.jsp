<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <!-- (1) Whitney Font -->
    <link rel="stylesheet" href="https://static.ctctcdn.com/lp/fonts/whitney/whitney-current.css" />

    <!-- (2) FED CSS -->
    <link type="text/css" rel="stylesheet" href="https://static.ctctcdn.com/h/fed-framework/1.2.1/fed.min.css" />
    <title>Stocks</title>
</head>
<body>
<jsp:useBean id="stockQuotes" class="com.aheffernan.stockstuff.model.StockQuoteList" scope="session">
    <c:set target='${stockQuotes}'  value='${sessionScope.get("stockQuotes")}'/>
</jsp:useBean>
<div class="fed-wrapper">

    <p>
        <c:if test="${stockQuotes.stockQuotes.size() == 0}">
            Sorry, no Results found for the give information.
        </c:if>
    </p>
    <table class="Table " data-qe-id="Table-ID">
        <thead>
        <tr>
            <th>Symbol</th>
            <th>Date</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="ob" items="${stockQuotes.stockQuotes}">
            <tr>
                <td><c:out value="${ob.symbol}" /></td>
                <td><c:out value="${ob.date}" /></td>
                <td><c:out value="${ob.price}" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
