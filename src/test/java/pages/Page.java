package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import utils.ConfigProperties;

import java.io.IOException;
import java.time.Duration;

public abstract class Page {

    private static ConfigProperties configProperties;
    WebDriver driver;
    FluentWait wait;

    public Page(WebDriver driver) throws IOException {
        this.driver = driver;
        wait = new FluentWait(driver);

        ConfigProperties configProperties = new ConfigProperties();
        wait.withTimeout(Duration.ofSeconds(Long.valueOf(configProperties.config.getProperty("TIMEOUT_IN_SECONDS"))));
        wait.withTimeout(Duration.ofSeconds(Long.valueOf(configProperties.config.getProperty("POLLING_IN_MILISECONDS"))));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(TimeoutException.class);
    }

    // Abstract Methods
    public abstract String getPageTitle();

    public abstract String getPageHeader(By locator);

    public abstract WebElement getElementBy(By locator);

    public abstract WebElement getElementBy(By locator, WebElement webElement);

    public abstract void waitForPageTitle(String title);

    // Java Generics
    public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
}


    public abstract WebElement elementWithWait(By element, String type, WebElement webElement);
}

