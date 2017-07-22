package com.aheffernan.stockstuff.model;

import java.util.List;

/**
 *
 */
public class StockQuoteList {
    private List<StockQuote> stockQuotes;

    /**
     * @return stockQuotes list
     */
    public List<StockQuote> getStockQuotes() {
        return stockQuotes;
    }

    /**
     * @param  stockQuotes list
     */
    public void setStockQuotes(List<StockQuote> stockQuotes) {
        this.stockQuotes = stockQuotes;
    }
}
