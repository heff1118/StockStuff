package com.aheffernan.stockstuff.model.pojo;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.assertTrue;

/**
 * Created by aheffernan on 7/22/17.
 */
public class StockTest {

    private Stock stock = new Stock();
    private LocalDateTime now = LocalDateTime.now();
    private BigDecimal price = new BigDecimal(100);

    @Before
    public void setup() {
        stock.setDate(now);
        stock.setPrice(price);
        stock.setSymbol("blah");
    }

    @Test
    public void modalSymbolTest() {
        assertTrue("Passed in symbol should match returned", stock.getSymbol().equals("blah"));
    }

    @Test
    public void modalDateTest() {
        assertTrue("Passed in time should match returned", stock.getDate().equals(now));
    }

    @Test
    public void modalPriceTest() {
        assertTrue("Passed in price should match returned", stock.getPrice().equals(price));
    }
}
