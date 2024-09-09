package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Page;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

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
