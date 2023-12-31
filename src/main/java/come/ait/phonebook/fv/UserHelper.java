package come.ait.phonebook.fv;

import come.ait.phonebook.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper{
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnSignOutButtom() {
        click(By.xpath("//button[.='Sign Out']"));
    }

    public boolean isloginLinkpresent() {
        return isElementPresent(By.cssSelector("[href='/login']"));
    }

    public void clickOnRegistrationButton() {
        click(By.name("registration"));
    }

    public void fillLoginRegisterForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void clickOnLoginLinc() {
        click(By.cssSelector("[href='/login']"));
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.xpath("//button[.='Sign Out']"));
    }

    public void clickOnLoginButton() {
        click(By.name("login"));
    }
}
