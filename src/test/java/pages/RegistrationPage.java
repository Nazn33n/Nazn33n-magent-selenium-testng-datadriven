package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class RegistrationPage extends BasePage {

    private By newAccount = By.linkText("Create an Account");
    private By firstName = By.id("firstname");
    private By lastName = By.id("lastname");
    private By emailAddress = By.name("email");
    private By inputPassword = By.id("password");
    private By passwordConfirmation = By.id("password-confirmation");
    private By submitButton = By.cssSelector("button[title='Create an Account'] span");
    private By userName = By.cssSelector(".box.box-information .box-content p");
    private By openMenu2 = By.xpath("*//header/div[1]//ul/li[2]//button");
    private By clickSignOut = By.partialLinkText("Sign Out");


    public RegistrationPage(WebDriver driver) throws IOException {
        super(driver);
    }

    public WebElement getNewAccountLink() {
        return elementWithWait(newAccount, "clickable");
    }

    public WebElement getFirstName() {
        return elementWithWait(firstName, "presence");
    }

    public WebElement getLastName() {
        return elementWithWait(lastName, "presence");
    }

    public WebElement getEmailAddress() {
        return elementWithWait(emailAddress, "presence");
    }

    public WebElement getPassword() {
        return elementWithWait(inputPassword, "presence");
    }

    public WebElement getPasswordConfirmation() {
        return elementWithWait(passwordConfirmation, "presence");
    }

    public WebElement getSubmitButton() {
        return elementWithWait(submitButton, "clickable");

    }

    public WebElement getUserNameTxt() {
        return elementWithWait(userName, "presence");
    }

    public WebElement getOpenMenus2() {
        return elementWithWait(openMenu2, "clickable");
    }

    public WebElement getSignOut() {
        return elementWithWait(clickSignOut, "clickable");
    }

}