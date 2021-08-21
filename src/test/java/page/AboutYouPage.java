package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AboutYouPage extends BasePage {

    private static final String URL = "vehiclefinance#/about-you";
    private static final By titleDropDown = By.id("title");
    private static final By firstNameTextBox = By.id("firstName");
    private static final By lastNameTextBox = By.id("lastName");
    private static final By dobDayTextBox = By.id("dateOfBirth__day");
    private static final By dobMonthTextBox = By.id("dateOfBirth__month");
    private static final By dobYearTextBox = By.id("dateOfBirth__year");
    private static final By emailTextBox = By.id("email");
    private static final By phoneNumberTextBox = By.id("phoneNumber");
    private static final By postcodeTextBox = By.id("address-search-0-search-postcode");
    private static final By searchPostcodeButton = By.xpath("//span[contains(.,'Search')]");
    private static final By addressListItem = By.xpath("//li/button");
    private static final By livedYearsButton = By.xpath("//label[4]/span/span");
    private static final By continueButton = By.xpath("//button[contains(.,'Continue')]");


    public AboutYouPage(WebDriver driver) {
        super(driver);
    }

    public static String getURL() {
        return BASE_URL+URL;
    }

    public void selectTitle(String value){
        this.waitForElementToLoad(titleDropDown);
        Select title = new Select(driver.findElement(titleDropDown));
        title.selectByVisibleText(value);
    }

    public void fillFirstName(String firstName){
        this.waitForElementToLoad(firstNameTextBox);
        driver.findElement(firstNameTextBox).sendKeys(firstName);
    }

    public void fillLastName(String lastName){
        this.waitForElementToLoad(lastNameTextBox);
        driver.findElement(lastNameTextBox).sendKeys(lastName);
    }

    public void fillDateOfBirth(String day, String month, String year){
        this.waitForElementToLoad(dobYearTextBox);
        driver.findElement(dobDayTextBox).sendKeys(day);
        driver.findElement(dobMonthTextBox).sendKeys(month);
        driver.findElement(dobYearTextBox).sendKeys(year);
    }


    public void fillEmail(String email){
        this.waitForElementToLoad(emailTextBox);
        driver.findElement(emailTextBox).sendKeys(email);
    }

    public void fillPhoneNumber(String phoneNumber){
        this.waitForElementToLoad(phoneNumberTextBox);
        driver.findElement(phoneNumberTextBox).sendKeys(phoneNumber);
    }

    public void fillPostcode(String postcode){
        this.waitForElementToLoad(postcodeTextBox);
        driver.findElement(postcodeTextBox).sendKeys(postcode);
    }

    public void clickSearchPostcodeButton(){
        this.waitForElementToLoad(searchPostcodeButton);
        driver.findElement(searchPostcodeButton).click();
    }

    public void selectAddressResult(){
        this.waitForElementToLoad(addressListItem);
        driver.findElement(addressListItem).click();
    }

    public void clickLivedYearsButton(){
        this.waitForElementToLoad(livedYearsButton);
        driver.findElement(livedYearsButton).click();
    }

    public void clickContinueButton(){
        this.waitForElementToLoad(continueButton);
        driver.findElement(continueButton).click();
    }



}
