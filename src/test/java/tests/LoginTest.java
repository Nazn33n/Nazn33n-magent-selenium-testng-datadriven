package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Page;
import utils.ReadExcel;
import java.io.IOException;

public class LoginTest extends BaseTest {

    private final String filePath = "resources\\testdata\\ExcelFiles\\Reg_data.xlsx";
    private final String sheetName = "Data";

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

    @DataProvider(name = "loginExcelData")
    public Object[][] readExcelData() throws IOException {
        return ReadExcel.getExcelDataFirstRow(filePath, sheetName);
    }

    @Test(dataProvider = "loginExcelData")
    public void initiateLoginTest(String firstName,
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
                                  String color) throws InterruptedException {
        System.out.println("Test start ...........");
        page.getInstance(LoginPage.class).getSignInLink().click();
        page.getInstance(LoginPage.class).getLoginEmail().sendKeys(emailAddress);
        page.getInstance(LoginPage.class).getLoginPassword().sendKeys(password);
        page.getInstance(LoginPage.class).getLoginSubmitButton().click();
        Thread.sleep(3000);
        page.getInstance(LoginPage.class).getOpenMenus().click();
        page.getInstance(LoginPage.class).getMyAccount().click();
    }
}
