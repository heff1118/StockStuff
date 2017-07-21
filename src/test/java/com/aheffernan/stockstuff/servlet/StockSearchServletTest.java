package com.aheffernan.stockstuff.servlet;

import com.aheffernan.stockstuff.model.StockQuery;
import com.aheffernan.stockstuff.model.StockQuote;
import com.aheffernan.stockstuff.service.StockService;
import com.aheffernan.stockstuff.service.YahooAPIStockService;
import com.aheffernan.stockstuff.util.Interval;
import org.joda.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StockSearchServletTest extends Mockito {

    private StockService stockServiceMock;
    private YahooAPIStockService yahooAPIStockService;
    private HttpSession httpSession;
    private ServletContext servletContext;
    private StockSearchServlet stockSearchServlet;
    private ServletConfig servletConfig;

    @Before
    public void setup() {
        stockServiceMock = mock(StockService.class);
        yahooAPIStockService = mock(YahooAPIStockService.class);
        httpSession = mock(HttpSession.class);
        servletContext = mock(ServletContext.class);
        stockSearchServlet = mock(StockSearchServlet.class);
        servletConfig = mock(ServletConfig.class);
    }

    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        List<StockQuote> historicalQuotes = new ArrayList<>();
        historicalQuotes.add(new StockQuote());
        historicalQuotes.add(new StockQuote());


        String symbol = "APPL";
        String from = "2011-10-29 12:12:12";    //yyyy-MM-dd HH:mm:ss
        String until = "2014-11-29 12:12:12";
        StockQuery stockQuery = new StockQuery(symbol, from, until);

        when(request.getParameter("stockQuoteSymbol")).thenReturn("SNAP");
        when(request.getParameter("monthFrom")).thenReturn("Jan");
        when(request.getParameter("yearFrom")).thenReturn("2017");
        when(request.getParameter("dayFrom")).thenReturn("1");
        when(request.getParameter("monthUntil")).thenReturn("Jan");
        when(request.getParameter("yearUntil")).thenReturn("2017");
        when(request.getParameter("dayUntil")).thenReturn("8");

        List<StockQuote> stockQuotes = new ArrayList<>();
        StockQuote stockQuoteFromDate = new StockQuote(new BigDecimal(100), stockQuery.getFrom(), stockQuery.getSymbol());
        stockQuotes.add(stockQuoteFromDate);
        StockQuote stockQuoteUntilDate = new StockQuote(new BigDecimal(100), stockQuery.getUntil(), stockQuery.getSymbol());
        stockQuotes.add(stockQuoteUntilDate);

        when(stockServiceMock.getQuote(any(String.class),
                any(LocalDateTime.class),
                any(LocalDateTime.class),
                any(Interval.class))).thenReturn(stockQuotes);

        when(yahooAPIStockService.getQuote(anyString(),
                any(LocalDateTime.class),
                any(LocalDateTime.class),
                any(Interval.class))).thenReturn(historicalQuotes);

        RequestDispatcher mockDispatcher = mock(RequestDispatcher.class);

        when(servletContext.getContext(any())).thenReturn(servletContext);
        when(servletContext.getRequestDispatcher(any())).thenReturn(mockDispatcher);
        when(request.getSession()).thenReturn(httpSession);

        stockSearchServlet.doPost(request, response);

        assertEquals("Stockqoutes is empty ", stockQuotes.size(), 2);

    }
}

