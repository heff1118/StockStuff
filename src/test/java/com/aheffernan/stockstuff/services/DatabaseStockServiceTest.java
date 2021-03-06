package com.aheffernan.stockstuff.services;

import com.aheffernan.stockstuff.model.StockData;
import com.aheffernan.stockstuff.model.StockQuote;
import com.aheffernan.stockstuff.service.ServiceFactory;
import com.aheffernan.stockstuff.service.StockService;
import com.aheffernan.stockstuff.util.DatabaseInitializationException;
import com.aheffernan.stockstuff.util.Interval;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit tests for the DatabaseStockService
 */
public class DatabaseStockServiceTest extends DatabaseServiceTest {

    private StockService databaseStockService;

    @Before
    public void setUp() throws DatabaseInitializationException {
        super.setUp();
        databaseStockService = ServiceFactory.getStockService(false);
    }

    @Test
    public void testGetQuote() throws Exception {
        String symbol = "APPL";
        StockQuote stockQuote = databaseStockService.getQuote(symbol);
        assertNotNull("Verify we can get a stock quote from the db", stockQuote);
        assertEquals("Make sure the symbols match", symbol, stockQuote.getSymbol());
    }

    @Test
    public void testGetQuoteWithIntervalBasic() throws Exception {
        String symbol = "GOOG";
        String fromStringDate = "2014-02-10 00:00:01";
        String untilStringDate = "2015-02-03 00:00:01";

        LocalDateTime fromCalendar = makeCalendarFromString(fromStringDate);
        LocalDateTime untilCalendar = makeCalendarFromString(untilStringDate);

        List<StockQuote> stockQuotes = databaseStockService.getQuote(symbol, untilCalendar, fromCalendar, Interval.DAY);

        assertTrue("verify stock quotes where returned", stockQuotes.isEmpty());
    }

    @Test
    public void testGetQuoteWithinRangeDay() throws Exception {

        String fromDateString = "2015-02-09 00:01:01";
        String endDateString = "2015-02-14 01:08:01";
        String symbol = "GOOG";

        LocalDateTime fromCalendar = makeCalendarFromString(fromDateString);
        LocalDateTime untilCalendar = makeCalendarFromString(endDateString);

        List<StockQuote> stockQuotes = databaseStockService.getQuote(symbol, untilCalendar, fromCalendar, Interval.DAY);
        assertEquals("got back expected number of stockquotes for one day interval", 0, stockQuotes.size());
    }

    @Test
    public void testGetQuoteWithinRangeMinute() throws Exception {

        String fromDateString = "2015-02-10 00:02:01";
        String endDateString = "2015-02-10 00:04:01";
        String symbol = "AMZN";

        LocalDateTime fromCalendar = makeCalendarFromString(fromDateString);
        LocalDateTime untilCalendar = makeCalendarFromString(endDateString);

        List<StockQuote> stockQuotes =
                databaseStockService.getQuote(symbol, untilCalendar, fromCalendar, Interval.MINUTE);
        assertEquals("got back expected number of stockquotes for one minute interval",  0, stockQuotes.size());
    }

    /**
     * Handy dandy helper method that converts Strings in the format of   StockData.dateFormat
     * to Calendar instances set to the date expressed in the string.
     *
     * @param dateString a data and time in this format: StockData.dateFormat
     * @return a calendar instance set to the time in the string.
     * @throws ParseException if the string is not in the correct format, we can't tell what
     *                        time it is, and therefore can't make a calender set to that time.
     */
    private LocalDateTime makeCalendarFromString(String dateString) throws ParseException {
        DateTimeFormatter format = DateTimeFormat.forPattern(StockData.dateFormat);
        return LocalDateTime.parse(dateString,format);
    }

}
