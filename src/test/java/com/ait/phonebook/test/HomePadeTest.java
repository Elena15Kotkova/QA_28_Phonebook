package com.ait.phonebook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePadeTest extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getHomepage().isHomeComponentPresent()) {
            app.getHomepage().clickOnHomeLink();
        }
    }

    @Test
    public void isHomeComponentPresentTest() {
        //System.out.println("Home Components is  " + isHomeComponentPresent());
        Assert.assertTrue(app.getHomepage().isHomeComponentPresent());
    }


}

