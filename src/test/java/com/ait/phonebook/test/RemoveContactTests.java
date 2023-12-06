package com.ait.phonebook.test;

import come.ait.phonebook.models.Contact;
import come.ait.phonebook.models.User;
import come.ait.phonebook.utils.ContactData;
import come.ait.phonebook.utils.UserData;
import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase {
    //precondition: User should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isloginLinkpresent()) {
            app.getUser().clickOnSignOutButtom();
        }
        //click on Login linc
        app.getUser().clickOnLoginLinc();
        //login
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        // click on login button
        app.getUser().clickOnLoginButton();
        //click on Add linc
        app.getContact().clickOnAddLinc();
        app.getContact().fillContactForm(new Contact()
                .setName(ContactData.NAME)
                .setLastName(ContactData.LAST_NAME)
                .setPhone(ContactData.PHONE)
                .setEmail(ContactData.EMAIL)
                .setAddresse(ContactData.ADDRESS)
                .setDescription(ContactData.DESCRIPTION));
        //click on Save button
        app.getContact().clickOnSaveButton();
    }
    @Test
    public void removeContactPositiveTest() {
        //get size of contact before remove
        int sizeBefore = app.getContact().sizeOfcontacts();
        //click on contact card
        app.getContact().removeContact();
        app.getContact().pause(1000);
        ////get size of contact before remove
        int sizeAfter = app.getContact().sizeOfcontacts();
        //assert: Contact is
        Assert.assertEquals(sizeAfter,sizeBefore-1 );
    }

}
