package com.aheffernan.stockstuff.services;

import com.aheffernan.stockstuff.service.BackFillDatabase;
import org.junit.Test;

/**
 * Created by aheffernan on 7/2/17.
 */
public class BackFillDatabaseTest {


    @Test
    public void testBackFillDatabase(){
        BackFillDatabase.parseXML();
    }
}
