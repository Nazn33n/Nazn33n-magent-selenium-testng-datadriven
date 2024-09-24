package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.Page;
import utils.ReadExcel;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AddToCartTest extends BaseTest {

    private final String filePath = "resources\\testdata\\ExcelFiles\\Reg_data.xlsx";
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
                          String size,
                          String color) {

        System.out.println("Test start ...........");
        page.getInstance(AddToCartPage.class).getSignInLink().click();
        page.getInstance(AddToCartPage.class).getLoginEmail().sendKeys(emailAddress);
        page.getInstance(AddToCartPage.class).getLoginPassword().sendKeys(password);
        page.getInstance(AddToCartPage.class).getLoginSubmitButton().click();

        String[] menuList = clothCategory.split("_"); // Women_Tops_Jacket -> ['Women', 'Tops', 'Jacket']
        int menuCount = menuList.length;
        for (int i = 0; i < menuCount - 1; i++) {
            Actions actions = new Actions(driver);
            WebElement menu = page.getInstance(AddToCartPage.class).getHoverMenu(menuList[i]);
            actions.moveToElement(menu).perform();
        }
        page.getInstance(AddToCartPage.class).getHoverMenu(menuList[menuCount - 1]).click();

        List<WebElement> products = driver.findElements(By.cssSelector(".product-item-name a"));
        Random random = new Random();
        WebElement product = products.get(random.nextInt(products.size()));
        product.click();



    }
}
