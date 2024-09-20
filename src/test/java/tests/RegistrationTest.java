package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.Page;
import pages.RegistrationPage;
import utils.RandomEmail;
import utils.ReadExcel;
import utils.Log;

import java.io.IOException;

public class RegistrationTest extends BaseTest {
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
        String filePath = "resources\\testdata\\ExcelFiles\\Reg_data.xlsx";
        String sheetName = "Sheet1";
        return ReadExcel.getExcelData(filePath, sheetName);
    }

    @Test(dataProvider = "registrationExcelData")
    public void registerUser(String firstName, String lastName, String emailAddress, String pwd, String confirmPwd) throws IOException {
        SoftAssert softAssert = new SoftAssert();
        page.getInstance(RegistrationPage.class).getNewAccountLink().click();
        page.getInstance(RegistrationPage.class).getFirstName().clear();
        page.getInstance(RegistrationPage.class).getFirstName().sendKeys(firstName);

        page.getInstance(RegistrationPage.class).getLastName().clear();
        page.getInstance(RegistrationPage.class).getLastName().sendKeys(lastName);

        page.getInstance(RegistrationPage.class).getEmailAddress().clear();
        page.getInstance(RegistrationPage.class).getEmailAddress().sendKeys(emailAddress);

        page.getInstance(RegistrationPage.class).getPassword().clear();
        page.getInstance(RegistrationPage.class).getPassword().sendKeys(pwd);

        page.getInstance(RegistrationPage.class).getPasswordConfirmation().clear();
        page.getInstance(RegistrationPage.class).getPasswordConfirmation().sendKeys(confirmPwd);

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
