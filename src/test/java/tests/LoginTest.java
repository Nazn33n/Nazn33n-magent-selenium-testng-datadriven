package tests;


import org.openqa.selenium.WebDriver;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Page;



import static utils.Constant.*;

public class LoginTest extends BaseTest {

    WebDriver driver;
    Page page;


    public LoginTest(String url) {
        super(url);
    }

    @BeforeClass
    public void beforeClass() {
        driver = BaseTest.driver;
        page = BaseTest.page;

    }

    @Test
    public void initiateLoginTest() {
        page.getInstance(LoginPage.class).getSignInLink().click();
        page.getInstance(LoginPage.class).getLoginEmail().sendKeys(login_email);
        page.getInstance(LoginPage.class).getLoginPassword().sendKeys(login_password);
        page.getInstance(LoginPage.class).getLoginSubmitButton().click();

    }

}
