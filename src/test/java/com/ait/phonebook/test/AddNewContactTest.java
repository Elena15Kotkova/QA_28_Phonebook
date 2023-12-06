package com.ait.phonebook.test;

import come.ait.phonebook.models.Contact;
import come.ait.phonebook.models.User;
import come.ait.phonebook.utils.ContactData;
import come.ait.phonebook.utils.DataProviders;
import come.ait.phonebook.utils.UserData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AddNewContactTest extends TestBase {

    //precondition: User should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isloginLinkpresent()) {
            app.getUser().clickOnSignOutButtom();
        }
        //click on Login linc
        app.getUser().clickOnLoginLinc();
        //enter email
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));

        // click on login button
        app.getUser().clickOnLoginButton();
    }

    //click on Add linc
    @Test
    public void addNewContactPositivTest() {
        app.getContact().clickOnAddLinc();

        app.getContact().fillContactForm(new Contact()
                .setName(ContactData.NAME)
                .setLastName(ContactData.LAST_NAME)
                .setPhone(ContactData.PHONE)
                .setEmail(ContactData.EMAIL)
                .setAddresse(ContactData.ADDRESS)
                .setDescription(ContactData.DESCRIPTION));

        app.getContact().clickOnSaveButton();

        Assert.assertTrue(app.getContact().isContactCreatedByText(ContactData.NAME));
    }

    @AfterMethod
    public void postCondition() {
        app.getContact().removeContact();
    }


    @Test(dataProvider = "addNewContact", dataProviderClass = DataProviders.class)
    public void addNewContactFromDataProviderPositivTest(String name, String lastName, String phone, String email, String adress, String desc) {
        app.getContact().clickOnAddLinc();

        app.getContact().fillContactForm(new Contact()
                .setName(name)
                .setLastName(lastName)
                .setPhone(phone)
                .setEmail(email)
                .setAddresse(adress)
                .setDescription(desc));

        app.getContact().clickOnSaveButton();

    }

    @Test(dataProvider = "addNewContactFromCSV", dataProviderClass = DataProviders.class)
    public void addNewContactFromDataProviderCSVPositivTest(Contact contact) {
        app.getContact().clickOnAddLinc();

        app.getContact().fillContactForm(contact);


        app.getContact().clickOnSaveButton();
    }
}
