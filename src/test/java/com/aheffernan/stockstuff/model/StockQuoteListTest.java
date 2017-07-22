package com.aheffernan.stockstuff.model;

import org.joda.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by aheffernan on 7/22/17.
 */
public class StockQuoteListTest {

    private StockQuoteList stockList = new StockQuoteList();
    private List<StockQuote> stocks = new ArrayList<>();
    private LocalDateTime now = LocalDateTime.now();
    private BigDecimal price = new BigDecimal(100);

    @Before
    public void setup() {
        StockQuote stock = new StockQuote(price, now, "blah");
        stocks.add(stock);
        stockList.setStockQuotes(stocks);
    }

    @Test
    public void testListIsbeingSet() {
        assertEquals("Passed in one stock should get one back", 1, stockList.getStockQuotes().size());
    }

    @Test
    public void testCorrectValuesBeingReturned(){
        assertTrue("Passed in blah as symbol should get it back", stockList.getStockQuotes().get(0).getSymbol().equals("blah"));
    }

}
