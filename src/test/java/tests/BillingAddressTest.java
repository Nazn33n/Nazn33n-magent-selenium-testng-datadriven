package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BillingAddressPage;
import pages.Page;
import utils.Log;
import utils.ReadExcel;

import java.io.IOException;

public class BillingAddressTest extends BaseTest {
    private final String filePath = "resources\\testdata\\ExcelFiles\\Test_data.xlsx";
    private final String sheetName = "Data";

    WebDriver driver;
    Page page;


    public BillingAddressTest(String url) {
        super(url);
    }

    @BeforeClass
    public void beforeClass() {
        driver = BaseTest.driver;
        page = BaseTest.page;

    }


    @DataProvider(name = "billingExcelData")
    public Object[][] readExcelData() throws IOException {
        return ReadExcel.getExcelDataFirstRow(filePath, sheetName);
    }

    @Test(dataProvider = "billingExcelData")
    public void addBillingAddressTest(String firstName,
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
                                      String size) {
        page.getInstance(BillingAddressPage.class).getEditAddressLink().click();
        page.getInstance(BillingAddressPage.class).getCompanyName().clear();
        page.getInstance(BillingAddressPage.class).getCompanyName().sendKeys(company);
        page.getInstance(BillingAddressPage.class).getPhoneNumber().clear();
        page.getInstance(BillingAddressPage.class).getPhoneNumber().sendKeys(phoneNumber);
        page.getInstance(BillingAddressPage.class).getAddressOne().clear();
        page.getInstance(BillingAddressPage.class).getAddressOne().sendKeys(streetAddress);
        page.getInstance(BillingAddressPage.class).getCityName().clear();
        page.getInstance(BillingAddressPage.class).getCityName().sendKeys(city);
        page.getInstance(BillingAddressPage.class).getRegionDropdown().sendKeys(state);
        page.getInstance(BillingAddressPage.class).getZipCode().clear();
        page.getInstance(BillingAddressPage.class).getZipCode().sendKeys(zipCode);
        page.getInstance(BillingAddressPage.class).getSaveAddressButton().click();
        page.getInstance(BillingAddressPage.class).getOpenMenus2().click();
        page.getInstance(BillingAddressPage.class).getSignOut().click();

        Log.info("Excel Data Used----------------------------------: " + company + " " + phoneNumber + " " + streetAddress + " " + city + " " + state + " " + zipCode);
    }

}
