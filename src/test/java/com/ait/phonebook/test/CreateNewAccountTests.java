package com.ait.phonebook.test;

import come.ait.phonebook.models.User;
import come.ait.phonebook.utils.UserData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewAccountTests extends TestBase {

    //precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUser().isloginLinkpresent()){
            app.getUser().clickOnSignOutButtom();
        }
    }

    @Test
    public void registerExistedUserNegativeTest(){
        //click on Login linc
        app.getUser().clickOnLoginLinc();
        //enter email
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));

        //click on Registration button
        app.getUser().clickOnRegistrationButton();

        // assert
       Assert.assertTrue(app.getContact().isAlertPresent());
    }

}
