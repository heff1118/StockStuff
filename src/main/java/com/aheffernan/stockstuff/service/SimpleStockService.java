package com.aheffernan.stockstuff.service;

import com.aheffernan.stockstuff.model.StockQuote;
import com.aheffernan.stockstuff.util.Interval;
import org.joda.time.LocalDateTime;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of the StockService that returns hard coded data.
 */
 class SimpleStockService implements StockService {

    /**
     * Return the current price for a share of stock  for the given symbol
     *
     * @param symbol the stock symbol of the company you want a quote for.
     *               e.g. APPL for APPLE
     * @return a  <CODE>BigDecimal</CODE> instance
     * @throws StockServiceException if using the service generates an exception.
     *                               If this happens, trying the service may work, depending on the actual cause of the
     *                               error.
     */
    @Override
    public StockQuote getQuote(String symbol) {
        // a dead simple implementation.
        return new StockQuote(new BigDecimal(100), LocalDateTime.now(), symbol);
    }

    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param symbol the stock symbol to search for
     * @param from   the date of the first stock quote
     * @param until  the date of the last stock quote
     * @return a list of StockQuote instances
     * @throws   StockServiceException if using the service generates an exception.
     * If this happens, trying the service may work, depending on the actual cause of the
     * error.
     */
    @Override
    public List<StockQuote> getQuote(String symbol, LocalDateTime from, LocalDateTime until, Interval interval) {
        // a dead simple implementation.
        List<StockQuote> stockQuotes = new ArrayList<>();
        LocalDateTime aDay = from;
        while (until.isAfter(aDay)) {
            stockQuotes.add(new StockQuote(new BigDecimal(100), aDay, symbol));
            from.minusDays(1);
            aDay = from;
        }
        return stockQuotes;
    }
}
