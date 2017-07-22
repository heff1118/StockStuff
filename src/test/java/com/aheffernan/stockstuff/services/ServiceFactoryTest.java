package com.aheffernan.stockstuff.services;

import com.aheffernan.stockstuff.model.StockQuote;
import com.aheffernan.stockstuff.service.ServiceFactory;
import com.aheffernan.stockstuff.service.StockService;
import com.aheffernan.stockstuff.service.StockServiceException;
import com.aheffernan.stockstuff.service.UserService;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * JUnit test for <CODE>ServiceFactory</CODE>
 */
public class ServiceFactoryTest {

    @Test
    public void testGetStockServiceInstance() {
        StockService stockService = ServiceFactory.getStockService(true);
        assertNotNull(stockService);
    }

    @Test
    public void testSwitchingBackends() {
        StockService stockServiceDefault = ServiceFactory.getStockService(true);
        StockQuote stockQuoteDefault = null;
        try {
            stockQuoteDefault = stockServiceDefault.getQuote("GOOG");
        } catch (StockServiceException e) {
            e.printStackTrace();
        }

        StockService stockServiceDatabase = ServiceFactory.getStockService(false);
        StockQuote stockQuoteDatabase = null;
        try {
            stockQuoteDatabase = stockServiceDatabase.getQuote("GOOG");
        } catch (StockServiceException e) {
            e.printStackTrace();
        }

        assertFalse("Changing datasource should change the results", stockQuoteDefault.equals(stockQuoteDatabase));
    }

    @Test
    public void testGetUserServiceInstance() {
        UserService userService = ServiceFactory.getUserService();
        assertNotNull(userService);
    }
}
