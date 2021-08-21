package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CarDetailsPage extends BasePage {

    private static final String URL = "vehiclefinance#/car-details";
    private static final By registrationNumberTextBox = By.id("car-registration-search");
    private static final By findButton = By.xpath("//span[contains(.,'Find car')]");
    private static final By registrationNumberError = By.xpath("/html/body/app-root/app-car-details/app-search-form-container/div/div[1]/app-car-details-form/form/section[1]/div/app-form-car-search/div/div/p[1]");
    private static final By registrationIDNoButton = By.xpath("//label[2]/span/span");
    private static final By carValueTextBox = By.id("value");
    private static final By depositAmountTextBox = By.id("depositAmount");
    private static final By yearsDropdown = By.xpath("/html/body/app-root/app-car-details/app-search-form-container/div/div[1]/app-car-details-form/form/section[2]/div/app-form-question[3]/section/div/div[2]/app-form-select/div/select");
    private static final By continueButton = By.xpath("//button[contains(.,'Continue')]");


    public CarDetailsPage(WebDriver driver) {
        super(driver);
    }

    public static String getURL() {
        return BASE_URL + URL;
    }

    public void openCarDetailsPage() {
        driver.get(BASE_URL + URL);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void fillRegistrationNumber(String registrationNumber) {
        this.waitForElementToLoad(registrationNumberTextBox);
        driver.findElement(registrationNumberTextBox).sendKeys(registrationNumber);
    }

    public void clickFindButton() {
        this.waitForElementToLoad(findButton);
        driver.findElement(findButton).click();
    }

    public String getInvalidRegistrationErrorMessage() {
        this.waitForElementToLoad(registrationNumberError);
        String errorText = driver.findElement(registrationNumberError).getText();
        return errorText;
    }

    public void clickRegistrationIDNoButton() {
        this.waitForElementToLoad(registrationIDNoButton);
        driver.findElement(registrationIDNoButton).click();
    }

    public void fillCarValue(String value) {
        this.waitForElementToLoad(carValueTextBox);
        driver.findElement(carValueTextBox).sendKeys(value);
    }

    public void fillDepositAmount(String deposit) {
        this.waitForElementToLoad(depositAmountTextBox);
        driver.findElement(depositAmountTextBox).sendKeys(deposit);
    }

    public void selectPaymentYears(int selectOption) {
        this.waitForElementToLoad(yearsDropdown);
        Select years = new Select(driver.findElement(yearsDropdown));
        years.selectByIndex(selectOption);

    }

    public void clickContinueButton() {
        this.waitForElementToLoad(continueButton);
        driver.findElement(continueButton).click();
        this.waitForPageLoad();
    }
}
