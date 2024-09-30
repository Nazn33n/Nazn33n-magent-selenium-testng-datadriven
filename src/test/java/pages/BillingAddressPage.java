package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class BillingAddressPage extends BasePage {


    private By editAddress = By.xpath("*//a[@data-ui-id=\"default-billing-edit-link\"]");
    private By companyName = By.id("company");
    private By phoneNumber = By.id("telephone");
    private By addressOne = By.id("street_1");
    private By cityName = By.id("city");
    private By stateDropdown = By.id("region_id");
    private By zipCode = By.id("zip");
    private By saveAddressButton = By.cssSelector("button[title='Save Address']");
    private By text = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/address");
    private By openMenu2 = By.xpath("*//header//ul/li[2]//button");
    private By clickSignOut = By.partialLinkText("Sign Out");


    public BillingAddressPage(WebDriver driver) throws IOException {
        super(driver);
    }


    public WebElement getEditAddressLink() {
        return elementWithWait(editAddress, "clickable");
    }

    public WebElement getCompanyName() {
        return elementWithWait(companyName, "presence");
    }

    public WebElement getPhoneNumber() {
        return elementWithWait(phoneNumber, "presence");
    }

    public WebElement getAddressOne() {
        return elementWithWait(addressOne, "presence");
    }

    public WebElement getCityName() {
        return elementWithWait(cityName, "presence");
    }

    public WebElement getRegionDropdown() {
        return elementWithWait(stateDropdown, "presence");
    }


    public WebElement getZipCode() {
        return elementWithWait(zipCode, "presence");
    }

    public WebElement getSaveAddressButton() {
        return elementWithWait(saveAddressButton, "clickable");
    }

    public WebElement getinfoText() {
        return elementWithWait(saveAddressButton, "clickable");
    }

    public WebElement getOpenMenus2() {
        return elementWithWait(openMenu2, "clickable");
    }

    public WebElement getSignOut() {
        return elementWithWait(clickSignOut, "clickable");
    }
}
