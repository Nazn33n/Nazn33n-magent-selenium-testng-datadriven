package tests;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
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
    @DataProvider(name = "excelData")
    public Object[][] readExcelData() throws IOException {
        String filePath = "resources\\testdata\\ExcelFiles\\Reg_data.xlsx";
        String sheetName = "Sheet1";
        return ReadExcel.getExcelData(filePath, sheetName);
    }

    @Test(dataProvider = "excelData")
    public void registerUser(String firstName, String lastName, String emailAddress, String pwd, String confirmPwd) throws IOException {

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

        Log.info("Excel Data Used: " + firstName + " " + lastName + " " + emailAddress);
    }
}
