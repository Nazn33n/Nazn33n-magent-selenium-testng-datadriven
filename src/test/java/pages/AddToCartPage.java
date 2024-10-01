package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;


public class AddToCartPage extends BasePage {

    private By signInLink = By.linkText("Sign In");
    private By loginEmail = By.id("email");
    private By loginPassword = By.id("pass");
    private By loginSubmitButton = By.id("send2");
    private By addToCartButton = By.id("product-addtocart-button");
    private By checkoutButton = By.xpath("*//ul/li[1]/button");
    private By loadPage = By.cssSelector("img[alt='Loading...']");
    private By shippingRadioButton = By.name("ko_unique_2");
    private By shippingNextButton = By.xpath("//*[@id=\"shipping-method-buttons-container\"]//button");
    private By shippingPlaceOrderButton = By.xpath("//*[text()='Place Order']");
    private By shippingSuccessMsg = By.xpath("/html/body/div[2]/main/div[1]/h1");
    private By orderId = By.className("order-number");
    private By openMenu2 = By.xpath("*//header/div[1]//ul/li[2]//button");
    private By clickSignOut = By.partialLinkText("Sign Out");

    public AddToCartPage(WebDriver driver) throws IOException {
        super(driver);
    }

    public WebElement getSignInLink() {return elementWithWait(signInLink, "clickable");}
    public WebElement getLoginEmail() {return elementWithWait(loginEmail, "presence");}
    public WebElement getLoginPassword() {return elementWithWait(loginPassword, "presence");}
    public WebElement getLoginSubmitButton() {return elementWithWait(loginSubmitButton, "clickable");}
    public WebElement getByLinkText(String linkText) {return elementWithWait(By.linkText(linkText), "clickable");}
    public WebElement getButtonByOptionLabel(String optionLabel) {return elementWithWait(By.xpath("//div[@option-label='" + optionLabel + "']"), "clickable");}
    public WebElement getAddToCart() {return elementWithWait(addToCartButton, "clickable");}
    public WebElement getCheckoutButton() {return elementWithWait(checkoutButton, "clickable");}
    public WebElement getLoadingIcon() {return elementWithWait(loadPage, "presence");}
    public WebElement getShipRadioButton() {return elementWithWait(shippingRadioButton, "presence");}
    public WebElement getShippingNextButton() {return elementWithWait(shippingNextButton, "presence");}
    public WebElement getShippingPlaceOrderButton() {return elementWithWait(shippingPlaceOrderButton, "clickable");}
    public WebElement getShippingSuccessMsg() {return elementWithWait(shippingSuccessMsg, "visibility");}
    public WebElement getOrderCompletionId() {return elementWithWait(orderId, "visibility");}
    public WebElement getOpenMenus2() {return elementWithWait(openMenu2, "clickable");}
    public WebElement getSignOut() {return elementWithWait(clickSignOut, "clickable");}
}
