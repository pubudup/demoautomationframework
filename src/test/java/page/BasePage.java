package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.function.Function;

public class BasePage {

    final static String BASE_URL = "https://money.gocompare.com/";
    private static final By footerTermsAndConditionsLink = By.xpath("/html/body/app-root/app-page-footer/div/go-compare-footer/div/div/div[1]/nav/ul/li[1]/a");

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementToLoad(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement webElement;
        webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        return webElement;
    }

    public void waitForPageLoad() {

        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                System.out.println("Current Window State       : "
                        + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
    }

    public void clickTermsAndConditionsLink() {
        this.waitForElementToLoad(footerTermsAndConditionsLink);
        driver.findElement(footerTermsAndConditionsLink).click();
    }

    public void switchToChildWindow() {
        Set<String> handlesSet = driver.getWindowHandles();
        Object[] handles = handlesSet.toArray();
        String childWin1 = (String) handles[1];
        driver.switchTo().window(childWin1);
    }

    public String getPageTitle() {
        String title;
        title = driver.getTitle();
        return title;
    }

}
