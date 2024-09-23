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
        String filePath = "resources\\testdata\\ExcelFiles\\Billing_data.xlsx";
        String sheetName = "Sheet1";
        return ReadExcel.getExcelData(filePath, sheetName);
    }

    @Test(dataProvider = "billingExcelData")
    public void addBillingAddressTest(String company, String phoneNumber, String addressName, String cityName, String state, String zipCode) {

        page.getInstance(BillingAddressPage.class).getEditAddressLink().click();
        page.getInstance(BillingAddressPage.class).getCompanyName().sendKeys(company);
        page.getInstance(BillingAddressPage.class).getPhoneNumber().sendKeys(phoneNumber);
        page.getInstance(BillingAddressPage.class).getAddressOne().sendKeys(addressName);
        page.getInstance(BillingAddressPage.class).getCityName().sendKeys(cityName);
        Select selectRegion = new Select(page.getInstance(BillingAddressPage.class).getRegionDropdown());
        selectRegion.selectByValue("Alaska");

//        page.getInstance(BillingAddressPage.class).getZipCode().sendKeys(zipCode);
////       page.getInstance(BillingAddressPage.class).getSaveAddressButton().click();
//
//        Log.info("Excel Data Used----------------------------------: " + company + " " + phoneNumber + " " + addressName + " " + cityName + " " + state+ " " + zipCode);
//       WebElement lala = page.getInstance(BillingAddressPage.class).getinfoText();
//       lala.getText();
//        System.out.println(lala);
    }

}
