<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Stocks</title>
</head>
<body>
<jsp:useBean id="stockQuotes" class="com.aheffernan.stockstuff.model.StockQuoteList" scope="session">
    <c:set target='${stockQuotes}'  value='${sessionScope.get("stockQuotes")}'/>
</jsp:useBean>
<p>
    <c:forEach var="ob" items="${stockQuotes.stockQuotes}">
        <div>Symbol of the stock value: <c:out value="${ob.symbol}" /></div>
        <div>Date of the stock value: <c:out value="${ob.date}" /></div>
        <div>Price of the stock value: <c:out value="${ob.price}" /></div>
    </c:forEach>

</p>
</body>
</html>
