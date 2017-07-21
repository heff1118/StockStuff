package com.aheffernan.stockstuff.service;

import com.aheffernan.stockstuff.model.StockQuote;
import com.aheffernan.stockstuff.util.Interval;
import org.joda.time.LocalDateTime;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 */
public class YahooAPIStockService implements StockService {
    /**
     * @param symbol the stock symbol of the company you want a quote for.
     *               e.g. APPL for APPLE
     * @return
     */
    @Override
    public StockQuote getQuote(String symbol) throws StockServiceException {
        System.out.println("LOOKING FOR " + symbol);

        try {
            Stock stock = YahooFinance.get(symbol);
            if(stock != null){
                return mapStockToStockQoute(stock);
            }
            throw new StockServiceException("No stock with this symbol");
        } catch (IOException e) {
            throw new StockServiceException("Error Getting stock for symbol=" + symbol, e);
        }
    }

    /**
     * @param symbol   the stock symbol to search for
     * @param from     the date of the first stock quote
     * @param until    the date of the last stock quote
     * @param interval the number of stockquotes to get per a 24 hour period.
     * @return
     * @throws StockServiceException
     */
    @Override
    public List<StockQuote> getQuote(String symbol, LocalDateTime from, LocalDateTime until, Interval interval) throws StockServiceException {
        System.out.println("LOOKING FOR " + symbol);
        try {
            //Convert Joda time to Calendar for YahooAPI
            Calendar fromDate = convertLocalDateTimetoCalendar(Date.from(from.toDate().toInstant()));
            Calendar untilDate = convertLocalDateTimetoCalendar(Date.from(until.toDate().toInstant()));

            Stock stock = YahooFinance.get(symbol);

            List<HistoricalQuote> historicalQuotes = stock.getHistory(untilDate, fromDate, yahoofinance.histquotes.Interval.DAILY); //we only support daily in our functions in the future could update this
            if(historicalQuotes != null){
                return mapListStockToStockQoute(historicalQuotes);
            }

            throw new StockServiceException("historicalQuotes was null");

        } catch (IOException e) {
            throw new StockServiceException("Error getting stock", e);
        }
    }

    private Calendar convertLocalDateTimetoCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    private List<StockQuote> mapListStockToStockQoute(List<HistoricalQuote> listOfHistoricalQuote) {
        List<StockQuote> stockQuotes = new ArrayList<>();
        listOfHistoricalQuote.stream().forEach(stock ->
                stockQuotes.add(new StockQuote(stock.getClose(), LocalDateTime.now(), stock.getSymbol())));

        return stockQuotes;
    }

    private StockQuote mapStockToStockQoute(@NotNull Stock stock) {
        return new StockQuote(stock.getQuote().getPrice(), LocalDateTime.now(), stock.getSymbol());
    }
}
