package com.aheffernan.stockstuff.model;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by aheffernan on 7/22/17.
 */
public class IntervalTest {

    @Test
    public void enumValueOfTest(){
        assertTrue("Interval value of is returning the correct value", Interval.IntervalEnum.HOURLY.equals(Interval.valueOf("HOURLY")));
    }

    @Test
    public void enumValueOfCaseSensitivityTest(){
        assertTrue("Interval value of is returning the correct value", Interval.IntervalEnum.HOURLY.equals(Interval.valueOf("hourly")));
    }
}
