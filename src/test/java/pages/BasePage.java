package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.List;

public class BasePage extends Page {

    public BasePage(WebDriver driver) throws IOException {
        super(driver);
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Override
    public String getPageHeader(By locator) {
        return getElementBy(locator).getText();
    }

    @Override
    public WebElement getElementBy(By locator) {
        WebElement element = null;

        try {
            element = driver.findElement(locator);
            return element;
        }catch(Exception e) {
            System.out.println("Some Error Occurred while creating element"+locator.toString());
            e.printStackTrace();
        }
        return element;
    }


    @Override
    public WebElement getElementBy(By locator, WebElement webElement) {
        WebElement element = null;
        element = webElement.findElement(locator);
        return element;
    }


    public List<WebElement> getElementsBy(By locator) {
        List<WebElement> list = null;

        try {
            list = driver.findElements(locator);
            return list;
        }catch(Exception e) {
            System.out.println("Some Error Occurred while creating element"+locator.toString());
            e.printStackTrace();
        }
        return list;
    }


    public void waitForElementPresent(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }catch(Exception e) {
            System.out.println("some exception occurred while waiting for the element "+locator.toString());
        }
    }

    @Override
    public void waitForPageTitle(String title) {
        try {
            wait.until(ExpectedConditions.titleContains(title));
        }catch(Exception e) {
            System.out.println("some exception occurred while waiting for the title "+title);
        }
    }

    public void sleepScript(int number) throws InterruptedException {
        Thread.sleep(number);
    }

    public void scrollDown(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0,1000);");
    }

    /**
     * Function for detecting elements presence with size
     */
    public int getSizeForCommonElements(By locator){
        if(!driver.getCurrentUrl().contains("my-chain-")){
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return driver.findElements(locator).size();
        }
        else
            return 0;
    }

    /**
     * Return Element with By after waiting using Fluent Wait
     * @return
     *
     */
    public WebElement elementWithWait(By element, String type){

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mat-mdc-progress-bar")));

        if(type.equals("presence")) {
            //Log.info("presence CHECK......");
            wait.until(ExpectedConditions.presenceOfElementLocated(element));
        }
        else if(type.equals("visibility")) {
            //Log.info("visibility CHECK......");
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        }
        else if(type.equals("clickable")) {
            //Log.info("clickable CHECK......");
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }

        //wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(element))));

        try {
            return getElementBy(element);
        }catch (StaleElementReferenceException e){
            return getElementBy(element);
        }
    }

    /**
     * Return Element List with By after waiting using Fluent Wait
     * @return
     *
     */
    public List<WebElement> elementsWithWait(By element, String type){

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".page-loader-container")));


        if(type.equals("presence")) {
            //Log.info("presence CHECK......");
            wait.until(ExpectedConditions.presenceOfElementLocated(element));
        }
        else if(type.equals("visibility")) {
            //Log.info("visibility CHECK......");
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        }
        else if(type.equals("clickable")) {
            //Log.info("clickable CHECK......");
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }

        //wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(element))));

        try {
            return getElementsBy(element);
        }catch (StaleElementReferenceException e){
            return getElementsBy(element);
        }
    }

    @Override
    public WebElement elementWithWait(By element, String type, WebElement webElement){

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".page-loader-container")));


        if(type.equals("presence")) {
            //Log.info("presence CHECK......");
            wait.until(ExpectedConditions.presenceOfElementLocated(element));
        }
        else if(type.equals("visibility")) {
            //Log.info("visibility CHECK......");
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        }
        else if(type.equals("clickable")) {
            //Log.info("clickable CHECK......");
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }

        //wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(element))));

        try {
            return getElementBy(element, webElement);
        }catch (StaleElementReferenceException e){
            return getElementBy(element, webElement);
        }
    }
}
