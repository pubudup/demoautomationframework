package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class YourResultsPage extends BasePage {

    private static final String URL = "vehiclefinance#/results";
    private static final By searchResultsNotification = By.xpath("/html/body/app-root/app-results/app-results-container/div/div[2]/div[2]/app-results-header/header/div[2]/span");
    private static final By carFinanceProduct = By.xpath("/html/body/app-root/app-results/app-results-container/div/div[2]/div[2]/app-product-table/section/app-product[1]/article/section/div[1]");

    public YourResultsPage(WebDriver driver) {
        super(driver);
    }

    public static String getURL() {
        return BASE_URL + URL;
    }

    public String getSearchResultNotification() {
        this.waitForElementToLoad(searchResultsNotification);
        String label = driver.findElement(searchResultsNotification).getText();
        return label;
    }

    public boolean isProductVisible() {
        this.waitForElementToLoad(carFinanceProduct);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        boolean displayed = driver.findElement(carFinanceProduct).isDisplayed();
        return displayed;
    }

}
