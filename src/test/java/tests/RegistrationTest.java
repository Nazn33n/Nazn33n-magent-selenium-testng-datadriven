package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Page;
import pages.RegistrationPage;
import utils.ReadExcel;
import utils.Log;
import utils.WriteExcel;

import java.io.IOException;

public class RegistrationTest extends BaseTest {

    private final String filePath = "resources\\testdata\\ExcelFiles\\Test_data.xlsx";
    private final String sheetName = "Data";

    WebDriver driver;
    Page page;

    public RegistrationTest(String url) {
        super(url);
    }

    @BeforeClass
    public void beforeClass() {
        driver = BaseTest.driver;
        page = BaseTest.page;
    }

    @DataProvider(name = "registrationExcelData")
    public Object[][] readExcelData() throws IOException {
        return ReadExcel.getExcelData(filePath, sheetName);
    }

    @Test
    public void writeExcelData() throws IOException {
        WriteExcel.writeExcelData(filePath, sheetName);
    }

    @Test(dataProvider = "registrationExcelData")
    public void registerUser(String firstName,
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
        SoftAssert softAssert = new SoftAssert();
        page.getInstance(RegistrationPage.class).getNewAccountLink().click();
        page.getInstance(RegistrationPage.class).getFirstName().clear();
        page.getInstance(RegistrationPage.class).getFirstName().sendKeys(firstName);
        page.getInstance(RegistrationPage.class).getLastName().clear();
        page.getInstance(RegistrationPage.class).getLastName().sendKeys(lastName);
        page.getInstance(RegistrationPage.class).getEmailAddress().clear();
        page.getInstance(RegistrationPage.class).getEmailAddress().sendKeys(emailAddress);
        page.getInstance(RegistrationPage.class).getPassword().clear();
        page.getInstance(RegistrationPage.class).getPassword().sendKeys(password);
        page.getInstance(RegistrationPage.class).getPasswordConfirmation().clear();
        page.getInstance(RegistrationPage.class).getPasswordConfirmation().sendKeys(confirmPassword);
        page.getInstance(RegistrationPage.class).getSubmitButton().click();
        Log.info("Excel Data Used: " + firstName + " " + lastName + " " + emailAddress);
        WebElement element = page.getInstance(RegistrationPage.class).getUserNameTxt();
        String[] lines = element.getText().split("\\r?\\n");
        // Check if there are at least two lines
        if (lines.length > 1) {
            // Print the second line
            System.out.println("Second line: " + lines[1]);
            String email = lines[1];
            softAssert.assertEquals(email, "safia2@yopmail.com");
        } else {
            System.out.println("There is no second line.");
        }
        page.getInstance(RegistrationPage.class).getOpenMenus2().click();
        page.getInstance(RegistrationPage.class).getSignOut().click();
    }
}
