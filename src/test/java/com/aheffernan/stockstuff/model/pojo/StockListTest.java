package com.aheffernan.stockstuff.model.pojo;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by aheffernan on 7/22/17.
 */
public class StockListTest {

    private StockList stockList = new StockList();
    private List<Stock> stocks = new ArrayList<>();
    private LocalDateTime now = LocalDateTime.now();
    private BigDecimal price = new BigDecimal(100);

    @Before
    public void setup() {
        Stock stock = new Stock();
        stock.setDate(now);
        stock.setPrice(price);
        stock.setSymbol("blah");
        stocks.add(stock);
        stockList.setStocks(stocks);
    }

    @Test
    public void testListIsbeingSet() {
        assertEquals("Passed in one stock should get one back", 1, stockList.getStocks().size());
    }

    @Test
    public void testCorrectValuesBeingReturned(){
        assertTrue("Passed in blah as symbol should get it back", stockList.getStocks().get(0).getSymbol().equals("blah"));
    }
}
