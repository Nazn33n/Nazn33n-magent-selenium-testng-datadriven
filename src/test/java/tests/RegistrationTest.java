package tests;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.Page;
import pages.RegistrationPage;
import utils.Log;

import java.io.FileInputStream;
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

    @Test
    public void readExcelTest() throws IOException {

        FileInputStream fis = new FileInputStream("D:\\#Projects\\Nazn33n-magent-selenium-testng-datadriven\\resources\\testdata\\ExcelFiles\\Reg_data.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rowcount = sheet.getLastRowNum();
        int colcount = sheet.getRow(1).getLastCellNum();
        Log.info("Row Count : ---------------------------------------------: " + rowcount + " " + "Column Count:------------------------------- " + " " + colcount);
        for (int i = 1; i <= rowcount; i++) {
            XSSFRow cellData = sheet.getRow(i);
            String firstName = cellData.getCell(0).getStringCellValue();
            String lastName = cellData.getCell(1).getStringCellValue();
            String emailAddress = cellData.getCell(2).getStringCellValue();
            String pwd = cellData.getCell(3).getStringCellValue();
            String confirmPwd = cellData.getCell(4).getStringCellValue();
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
            Log.info("Excel Data Appearing : -------------------------------------------------------------" + firstName + " " + lastName + " " + emailAddress);
        }

        driver.quit();
    }
}
