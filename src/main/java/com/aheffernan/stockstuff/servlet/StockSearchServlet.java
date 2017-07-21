package com.aheffernan.stockstuff.servlet;

import com.aheffernan.stockstuff.model.StockQuote;
import com.aheffernan.stockstuff.model.StockQuoteList;
import com.aheffernan.stockstuff.service.ServiceFactory;
import com.aheffernan.stockstuff.service.StockService;
import com.aheffernan.stockstuff.service.StockServiceException;
import com.aheffernan.stockstuff.util.Interval;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StockSearchServlet extends HttpServlet {

    private static final String symbol = "stockQuoteSymbol";
    private static final String monthFrom = "monthFrom";
    private static final String yearFrom = "yearFrom";
    private static final String dayFrom = "dayFrom";
    private static final String monthUntil = "monthUntil";
    private static final String yearUntil = "yearUntil";
    private static final String dayUntil = "dayUntil";
    private static final DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy MMM dd");

    private String inputSymbol;
    private String inputMonthFrom;
    private String inputYearFrom;
    private String inputDayFrom;
    private String inputMonthUntil;
    private String inputYearUntil;
    private String inputDayUntil;

    private StockService stockService = ServiceFactory.getStockService();

    /**
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        getParametersFromRequest(request);

        System.out.println("Month " + inputMonthFrom + " Year " + inputYearFrom + " Day " + inputDayFrom);
        //TODO Delete these
        System.out.println("Month " + inputMonthUntil + " Year " + inputYearUntil + " Day " + inputDayUntil);

        LocalDateTime fromDate = LocalDateTime.parse(inputYearFrom + " " + inputMonthFrom + " " + inputDayFrom, formatter);
        LocalDateTime untilDate = LocalDateTime.parse(inputYearUntil + " " + inputMonthUntil + " " + inputDayUntil, formatter);

        List<StockQuote> stockQuotes = new ArrayList<>();
        try {
            stockQuotes = stockService.getQuote(inputSymbol, untilDate, fromDate, Interval.DAY);
        } catch (StockServiceException e ){
            e.printStackTrace();
        }

        StockQuoteList stockList = new StockQuoteList();
        stockList.setStockQuotes(stockQuotes);

        for (StockQuote stock: stockList.getStockQuotes()) {
            System.out.println(stock.getDate());
        }
        //Set stockquotes in session
        HttpSession session = request.getSession();
        session.setAttribute("stockQuotes", stockList);

        redirect(request,response);
    }

    public void redirect(HttpServletRequest request, HttpServletResponse response) {
        try {
            //Redirect to the Results page
            ServletContext servletContext = getServletContext();
            RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/stockquoteResults.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getParametersFromRequest(HttpServletRequest request) {
        inputSymbol = request.getParameter(symbol);
        inputMonthFrom = request.getParameter(monthFrom);
        inputYearFrom = request.getParameter(yearFrom);
        inputDayFrom = request.getParameter(dayFrom);
        inputMonthUntil = request.getParameter(monthUntil);
        inputYearUntil = request.getParameter(yearUntil);
        inputDayUntil = request.getParameter(dayUntil);
    }
}
