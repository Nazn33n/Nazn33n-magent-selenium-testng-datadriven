package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;


public class AddToCartPage extends BasePage {

    private By signInLink = By.linkText("Sign In");
    private By loginEmail = By.id("email");
    private By loginPassword = By.id("pass");
    private By loginSubmitButton = By.id("send2");
    private By checkoutButton = By.xpath("*//ul/li[1]/button");
    private By shippingRadioButton = By.name("ko_unique_2");
    private By shippingNextButton = By.xpath("//*[@id=\"shipping-method-buttons-container\"]//button");
    private By shippingCheckBox = By.id("billing-address-same-as-shipping-checkmo");
    private By shippingPlaceOrderButton = By.cssSelector(".action.primary.checkout");
    private By shippingSuccessMsg = By.xpath("/html/body/div[2]/main/div[1]/h1");
    private By totalPrice = By.xpath("//*[@id=\"opc-sidebar\"]//table/tbody/tr[3]/td/strong");
    private By orderId = By.className("order-number");

    public AddToCartPage(WebDriver driver) throws IOException {super(driver);}

    public WebElement getSignInLink() {return elementWithWait(signInLink, "clickable");}
    public WebElement getLoginEmail() {return elementWithWait(loginEmail, "presence");}
    public WebElement getLoginPassword() {return elementWithWait(loginPassword, "presence");}
    public WebElement getLoginSubmitButton() {return elementWithWait(loginSubmitButton, "clickable");}
    public WebElement getByLinkText(String linkText) {return elementWithWait(By.linkText(linkText), "clickable");}
    public WebElement getCheckoutButton() {return elementWithWait(checkoutButton, "clickable");}
    public WebElement getButtonByOptionLabel(String optionLabel) {return elementWithWait(By.xpath("//div[@option-label='" + optionLabel + "']"), "clickable");}
    public WebElement getShipRadioButton() {return elementWithWait(shippingRadioButton, "presence");}
    public WebElement getShippingNextButton() {return elementWithWait(shippingNextButton, "presence");}
    public WebElement getShippingCheckBox() {return elementWithWait(shippingCheckBox, "presence");}
    public WebElement getShippingPlaceOrderButton() {return elementWithWait(shippingPlaceOrderButton, "presence");}
    public WebElement getShippingSuccessMsg() {return elementWithWait(shippingSuccessMsg, "presence");}
    public WebElement getProductsTotalPrice() {return elementWithWait(totalPrice, "presence");}
    public WebElement getOrderCompletionId() {return elementWithWait(orderId, "presence");}
}
