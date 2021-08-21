package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;

public class BasePage {

    final static String BASE_URL = "https://money.gocompare.com/";
    private static final By footerTermsAndConditionsLink = By.xpath("/html/body/app-root/app-page-footer/div/go-compare-footer/div/div/div[1]/nav/ul/li[1]/a");

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /*
    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
     */

    public WebElement waitForElementToLoad(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement webElement;
        webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        return webElement;
    }

    public void clickTermsAndConditionsLink(){
        this.waitForElementToLoad(footerTermsAndConditionsLink);
        driver.findElement(footerTermsAndConditionsLink).click();
        BasePage basePage = new BasePage(driver);

    }

    public void switchToChildWindow(){
        Set<String> handlesSet = driver.getWindowHandles();
        Object[] handles = handlesSet.toArray();
        String childWin1=(String)handles[1];
        driver.switchTo().window(childWin1);
    }

    public String getPageTitle(){
        String title;
        title = driver.getTitle();
        return title;
    }

}
