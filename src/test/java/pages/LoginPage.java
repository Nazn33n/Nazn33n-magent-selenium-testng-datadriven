package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class LoginPage extends BasePage {

    private By signInLink = By.linkText("Sign In");
    private By loginEmail = By.id("email");
    private By loginPassword = By.id("pass");
    private By loginSubmitButton = By.id("send2");
    private By openMenu = By.xpath("*//header//ul/li[2]//button");
    private By clickMyAccount = By.linkText("My Account");


    public LoginPage(WebDriver driver) throws IOException {
        super(driver);
    }

    public WebElement getSignInLink() {return elementWithWait(signInLink, "clickable");}
    public WebElement getLoginEmail() {return elementWithWait(loginEmail, "presence");}
    public WebElement getLoginPassword() {return elementWithWait(loginPassword, "presence");}
    public WebElement getLoginSubmitButton() {return elementWithWait(loginSubmitButton, "clickable");}
    public WebElement getOpenMenus() {return elementWithWait(openMenu, "clickable");}
    public WebElement getMyAccount() {return elementWithWait(clickMyAccount, "clickable");}
}
