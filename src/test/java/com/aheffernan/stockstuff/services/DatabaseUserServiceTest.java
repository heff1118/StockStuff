package com.aheffernan.stockstuff.services;

import com.aheffernan.stockstuff.model.User;
import com.aheffernan.stockstuff.service.DuplicateUserNameException;
import com.aheffernan.stockstuff.service.ServiceFactory;
import com.aheffernan.stockstuff.service.UserService;
import com.aheffernan.stockstuff.util.DatabaseInitializationException;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class DatabaseUserServiceTest extends DatabaseServiceTest{


    private UserService databaseUserService;

    @Before
    public void setUp() throws DatabaseInitializationException {
        super.setUp();
        databaseUserService = ServiceFactory.getUserService();
    }

    @Test
    public void testAddPerson() throws Exception{
        String sam = "Vic";
        User user = new User(sam);
        databaseUserService.addPerson(user);
    }

    @Test(expected = DuplicateUserNameException.class)
    public void testAddPersonDuplicateUser() throws Exception{
        String sam = "Sam";
        User user = new User(sam);
        databaseUserService.addPerson(user);

    }

}
