package com.aheffernan.stockstuff.services;

import com.aheffernan.stockstuff.model.StockQuote;
import com.aheffernan.stockstuff.service.ServiceFactory;
import com.aheffernan.stockstuff.service.StockServiceException;
import com.aheffernan.stockstuff.util.Interval;
import org.joda.time.LocalDateTime;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by aheffernan on 7/9/17.
 */
public class YahooAPIStockServiceTest {

    @Test
    public void getStockSyml(){
        try {
            StockQuote googleStock = ServiceFactory.getStockService().getQuote("GOOG");
            assertEquals("Symbol returned is correct", "GOOG", googleStock.getSymbol());

        } catch (StockServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getStockPrice(){
        try {
            StockQuote googleStock = ServiceFactory.getStockService().getQuote("GOOG");
            assertNotNull("Symbol returned is correct", googleStock.getPrice());

        } catch (StockServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getIntervalStock() {
        try {
            List<StockQuote> historicStocks = ServiceFactory.getStockService().getQuote("GOOG", LocalDateTime.now(), LocalDateTime.now().minusDays(7), Interval.DAY);
            assertEquals("historic date returns 5 days of day", historicStocks.size(), 5); //Weekends dont return results
        } catch (StockServiceException e) {
            e.printStackTrace();
        }

    }
}
