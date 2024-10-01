package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AddToCartPage;
import pages.BillingAddressPage;
import pages.Page;
import utils.ReadExcel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static utils.Constant.success_message;

public class AddToCartTest extends BaseTest {

    private final String filePath = "resources\\testdata\\ExcelFiles\\Test_data.xlsx";
    private final String sheetName = "Data";

    WebDriver driver;
    Page page;


    public AddToCartTest(String url) {
        super(url);
    }

    @BeforeClass
    public void beforeClass() {
        driver = BaseTest.driver;
        page = BaseTest.page;
    }

    List<String> orderIds = new ArrayList<>();

    @DataProvider(name = "loginExcelData")
    public Object[][] readExcelData() throws IOException {
        return ReadExcel.getExcelDataFirstRow(filePath, sheetName);
    }

    @Test(dataProvider = "loginExcelData")
    public void loginTest(String firstName,
                          String lastName,
                          String emailAddress,
                          String password,
                          String confirmPassword,
                          String company,
                          String phoneNumber,
                          String streetAddress,
                          String city,
                          String state,
                          String zipCode,
                          String clothCategory,
                          String size) throws Exception {
        SoftAssert softAssert = new SoftAssert();

        System.out.println("Test start ...........");
        page.getInstance(AddToCartPage.class).getSignInLink().click();
        page.getInstance(AddToCartPage.class).getLoginEmail().sendKeys(emailAddress);
        page.getInstance(AddToCartPage.class).getLoginPassword().sendKeys(password);
        page.getInstance(AddToCartPage.class).getLoginSubmitButton().click();

        String[] menuList = clothCategory.split("_"); // Women_Tops_Jacket -> ['Women', 'Tops', 'Jacket']
        int menuCount = menuList.length;
        for (int i = 0; i < menuCount - 1; i++) {
            Actions actions = new Actions(driver);
            WebElement menu = page.getInstance(AddToCartPage.class).getByLinkText(menuList[i]);
            actions.moveToElement(menu).perform();
        }
        page.getInstance(AddToCartPage.class).getByLinkText(menuList[menuCount - 1]).click();


        //Random Product
        List<WebElement> products = driver.findElements(By.cssSelector(".product-item-name a"));
        Random random = new Random();
        WebElement product = products.get(random.nextInt(products.size()));
        product.click();

        page.getInstance(AddToCartPage.class).getButtonByOptionLabel(size).click();

        //Random Color
        List<WebElement> colorOptions = driver.findElements(By.cssSelector(".swatch-option.color"));
        Random random1 = new Random();
        WebElement color = colorOptions.get(random1.nextInt(colorOptions.size()));
        color.click();

        page.getInstance(AddToCartPage.class).getAddToCart().click();
        page.getInstance(AddToCartPage.class).getByLinkText("shopping cart").click();
        page.getInstance(AddToCartPage.class).getCheckoutButton().click();
        page.getInstance(AddToCartPage.class).getShipRadioButton().click();
        Thread.sleep(6000);
        page.getInstance(AddToCartPage.class).getShippingNextButton().submit();
        WebElement proceedButton = page.getInstance(AddToCartPage.class).getShippingPlaceOrderButton();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", proceedButton);
        String actualText = page.getInstance(AddToCartPage.class).getShippingSuccessMsg().getText();
        softAssert.assertEquals(actualText, success_message);
        System.out.println(success_message);
        takeScreenshot("ss2");
        String orderCompletionID = page.getInstance(AddToCartPage.class).getOrderCompletionId().getText();
        orderIds.add(orderCompletionID);
        System.out.println(orderCompletionID);
        page.getInstance(AddToCartPage.class).getOpenMenus2().click();
        page.getInstance(AddToCartPage.class).getSignOut().click();
        driver.quit();
    }
}
