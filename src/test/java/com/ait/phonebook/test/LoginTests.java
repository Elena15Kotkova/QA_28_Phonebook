package com.ait.phonebook.test;

import come.ait.phonebook.models.User;
import come.ait.phonebook.utils.UserData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    // precondition: User logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isloginLinkpresent()) {
            app.getUser().clickOnSignOutButtom();
        }
    }

    @Test
    public void loginRegisterPositiveTest() {
        //click on Login linc
        app.getUser().clickOnLoginLinc();
        //enter email
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        // click on login button
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isSignOutButtonPresent());

    }
   @Test
    public void loginRegisterNegativeTestWithountEmail() {
        //click on Login linc
        app.getUser().clickOnLoginLinc();
        //enter email
        app.getUser().fillLoginRegisterForm(new User()
                .setPassword(UserData.PASSWORD));
        // click on login button
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getContact().isAlertPresent());

    }

}
