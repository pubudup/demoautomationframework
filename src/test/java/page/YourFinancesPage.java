package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class YourFinancesPage extends BasePage{

    private static final String URL = "vehiclefinance#/your-finances";
    private static final By grossAnnualIncomeTextBox = By.id("annualIncomeGross");
    private static final By residentialStatusDropDown = By.xpath("//*[@id=\"residentialStatus\"]");
    private static final By employmentStatusDropDown = By.xpath("//*[@id=\"employmentStatus\"]");
    private static final By dependentsNone = By.xpath("//span[contains(.,'None')]");
    private static final By privacyStatementButton = By.xpath("//span[contains(.,'Accept and get results')]");
    private static final By employmentTitleTextBox = By.id("employmentTitle");
    private static final By employmentIndustryTextBox = By.id("employmentIndustry");
    private static final By monthlyRentMortgageTextBox = By.id("monthlyRentOrMortgage");

    public YourFinancesPage(WebDriver driver) {
        super(driver);
    }

    public static String getURL() {
        return BASE_URL+URL;
    }

    public void fillGrossAnnualIncomeTextBox(String income){
        this.waitForElementToLoad(grossAnnualIncomeTextBox).sendKeys(income);
    }

    public void selectResidentialStatus(String status){
        this.waitForElementToLoad(residentialStatusDropDown);
        Select residentialStatus = new Select(driver.findElement(residentialStatusDropDown));
        residentialStatus.selectByVisibleText(status);
    }

    public void selectEmploymentStatus(String status){
        this.waitForElementToLoad(employmentStatusDropDown);
        Select residentialStatus = new Select(driver.findElement(employmentStatusDropDown));
        residentialStatus.selectByVisibleText(status);
    }

    public void clickDependents(){
        this.waitForElementToLoad(dependentsNone);
        driver.findElement(dependentsNone).click();
    }

    public void clickPrivacyStatementButton(){
        this.waitForElementToLoad(privacyStatementButton);
        driver.findElement(privacyStatementButton).click();
    }

    public void fillEmploymentTitle(String title){
        this.waitForElementToLoad(employmentTitleTextBox);
        driver.findElement(employmentTitleTextBox).sendKeys(title);
    }

    public void fillEmploymentIndustry(String industry){
        this.waitForElementToLoad(employmentIndustryTextBox);
        driver.findElement(employmentIndustryTextBox).sendKeys(industry);
    }

    public void fillMonthlyRentMortgateTextBox(String amount){
        this.waitForElementToLoad(monthlyRentMortgageTextBox);
        driver.findElement(monthlyRentMortgageTextBox).sendKeys(amount);
    }

}
